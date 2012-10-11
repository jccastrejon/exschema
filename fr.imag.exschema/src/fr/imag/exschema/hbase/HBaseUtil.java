/*
 * Copyright 2012 jccastrejon
 *  
 * This file is part of ExSchema.
 *
 * ExSchema is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * ExSchema is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with ExSchema. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.imag.exschema.hbase;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import fr.imag.exschema.DeclareVisitor;
import fr.imag.exschema.SchemaFinder;
import fr.imag.exschema.UpdateVisitor;
import fr.imag.exschema.Util;
import fr.imag.exschema.model.Attribute;
import fr.imag.exschema.model.Set;
import fr.imag.exschema.model.Struct;

/**
 * HBase utility methods.
 * 
 * @author jccastrejon
 * 
 */
public class HBaseUtil implements SchemaFinder {

    /**
     * Class logger.
     */
    private static Logger logger = Logger.getLogger(HBaseUtil.class.getName());

    @Override
    public List<Set> discoverSchemas(final IJavaProject project) throws JavaModelException {
        String tableName;
        Set currentTableSet;
        List<String> columns;
        List<Set> returnValue;
        String tableDescriptor;
        String columnFamilyName;
        Struct currentFamilyStruct;
        Struct currentColumnStruct;
        TablePutVisitor putVisitor;
        FamilyAddVisitor addVisitor;
        TableCreateVisitor createVisitor;
        TableDeclareVisitor declareVisitor;
        TableIncrementVisitor incrementVisitor;
        ColumnFamilyDeclareVisitor columnFamilyDeclareVisitor;

        // Identify when tables are created
        createVisitor = new TableCreateVisitor();
        Util.analyzeJavaProject(project, createVisitor);

        // Identify when data is inserted in a table
        putVisitor = new TablePutVisitor();
        Util.analyzeJavaProject(project, putVisitor);

        // Identify when columns are added to a column family
        incrementVisitor = new TableIncrementVisitor();
        Util.analyzeJavaProject(project, incrementVisitor);

        // Get tables data
        returnValue = new ArrayList<Set>();
        HBaseUtil.logger.log(Util.LOGGING_LEVEL, "\n\nHBase tables:");
        for (MethodInvocation createInvocation : createVisitor.getUpdateInvocations()) {
            tableDescriptor = createInvocation.arguments().get(0).toString();

            // Table name
            declareVisitor = new TableDeclareVisitor();
            declareVisitor.setVariableName(tableDescriptor);
            tableName = HBaseUtil.getHBaseName(createInvocation.getRoot(), declareVisitor);
            if (tableName != null) {
                currentTableSet = new Set();
                returnValue.add(currentTableSet);
                currentTableSet.addAttribute(new Attribute("name", tableName));
                currentTableSet.addAttribute(new Attribute("implementation", "HBase"));
                HBaseUtil.logger.log(Util.LOGGING_LEVEL, "\n--Table: " + tableName);

                // Column families
                addVisitor = new FamilyAddVisitor();
                addVisitor.setVariableName(tableDescriptor);
                createInvocation.getRoot().accept(addVisitor);
                for (MethodInvocation invocation : addVisitor.getUpdateInvocations()) {
                    columnFamilyName = invocation.arguments().get(0).toString();
                    columnFamilyDeclareVisitor = new ColumnFamilyDeclareVisitor();
                    columnFamilyDeclareVisitor.setVariableName(columnFamilyName);
                    columnFamilyName = HBaseUtil.getHBaseName(createInvocation.getRoot(), columnFamilyDeclareVisitor);
                    if (columnFamilyName != null) {
                        currentFamilyStruct = new Struct();
                        currentTableSet.addStruct(currentFamilyStruct);
                        currentFamilyStruct.addAttribute(new Attribute("name", columnFamilyName));
                        HBaseUtil.logger.log(Util.LOGGING_LEVEL, "\n----Family: " + columnFamilyName);

                        // Columns
                        if ((tableName != null) && (columnFamilyName != null)) {
                            // put(family, qualifier, value)
                            columns = new ArrayList<String>();
                            columns.addAll(HBaseUtil.getHBaseColumns(tableName, createInvocation.getRoot(),
                                    new PutAddVisitor(), columnFamilyName, putVisitor.getUpdateInvocations()));

                            // addColumn(family, qualifier, amount)
                            columns.addAll(HBaseUtil.getHBaseColumns(tableName, createInvocation.getRoot(),
                                    new AddColumnVisitor(), columnFamilyName, incrementVisitor.getUpdateInvocations()));

                            for (String column : columns) {
                                currentColumnStruct = new Struct();
                                currentFamilyStruct.addStruct(currentColumnStruct);
                                currentColumnStruct.addAttribute(new Attribute("name", column));
                                HBaseUtil.logger.log(Util.LOGGING_LEVEL, "\n------Column: " + column);
                            }
                        }
                    }
                }
            }
        }

        return returnValue;
    }

    /**
     * Get the HBase columns associated to the given update invocations.
     * 
     * @param tableName
     * @param rootNode
     * @param updateVisitor
     * @param columnFamilyName
     * @param updateInvocations
     * @return
     */
    private static List<String> getHBaseColumns(final String tableName, final ASTNode rootNode,
            UpdateVisitor updateVisitor, final String columnFamilyName, final List<MethodInvocation> updateInvocations) {
        String putName;
        List<String> arguments;
        List<String> returnValue;

        returnValue = new ArrayList<String>();
        for (MethodInvocation putInvocation : updateInvocations) {
            if (HBaseUtil.isMatchingTable(tableName, putInvocation)) {
                putName = putInvocation.arguments().get(0).toString();
                if (Util.isVariableName(putName)) {
                    updateVisitor.setVariableName(putName);
                    rootNode.accept(updateVisitor);
                    for (MethodInvocation addInvocation : updateVisitor.getUpdateInvocations()) {
                        arguments = HBaseUtil.getHBaseAddArguments(addInvocation);
                        if (arguments.get(0).equals(columnFamilyName)) {
                            returnValue.add(arguments.get(1));
                        }
                    }
                }
            }
        }

        return returnValue;
    }

    /**
     * Determine if the update invocation refers to the expected HBase table.
     * 
     * @param expectedTable
     * @param updateInvocation
     * @return
     */
    private static boolean isMatchingTable(final String expectedTable, final MethodInvocation updateInvocation) {
        boolean returnValue;
        MethodInvocation templateExecution;

        returnValue = false;
        templateExecution = HBaseUtil.getSpringTemplateExecution(updateInvocation);
        if (templateExecution != null) {
            returnValue = (templateExecution.arguments().get(0).toString().equals(expectedTable));
        }

        return returnValue;
    }

    /**
     * Get Spring's HBase template method execution.
     * 
     * @param node
     * @return
     */
    private static MethodInvocation getSpringTemplateExecution(final ASTNode node) {
        MethodInvocation returnValue;
        MethodInvocation updateInvocation;

        returnValue = null;
        if (node != null) {
            if (MethodInvocation.class.isAssignableFrom(node.getClass())) {
                updateInvocation = (MethodInvocation) node;
                if ((updateInvocation.getName().toString().equals("execute"))
                        && (updateInvocation.getExpression().resolveTypeBinding().getQualifiedName()
                                .equals("org.springframework.data.hadoop.hbase.HbaseTemplate"))) {
                    returnValue = updateInvocation;
                }
            }

            if (returnValue == null) {
                if (node.getParent() != null) {
                    returnValue = HBaseUtil.getSpringTemplateExecution(node.getParent());
                }
            }
        }

        return returnValue;
    }

    /**
     * Get the list of arguments used in an HBase add operation.
     * 
     * @param putInvocation
     * @return
     */
    private static List<String> getHBaseAddArguments(final MethodInvocation putInvocation) {
        String currentArgument;
        List<String> returnValue;

        returnValue = new ArrayList<String>(putInvocation.arguments().size());
        for (Object argument : putInvocation.arguments()) {
            currentArgument = ((Expression) argument).toString();
            // TODO: Consider operations that don't rely on variables
            // TODO: Consider operations that don't rely on method invocations
            if (currentArgument.contains("(")) {
                returnValue.add(currentArgument.substring(currentArgument.indexOf('(') + 1,
                        currentArgument.indexOf(')')));
            }
        }

        return returnValue;
    }

    /**
     * Get the name of the HBase table by analyzing the given declaration
     * definitions.
     * 
     * @param tableDeclaration
     * @return
     */
    private static String getHBaseName(final ASTNode rootNode, final DeclareVisitor declareVisitor) {
        String returnValue;
        VariableDeclarationFragment declaration;

        returnValue = null;
        rootNode.accept(declareVisitor);
        if (declareVisitor.getVariableDeclarations().size() > 0) {
            declaration = declareVisitor.getVariableDeclarations().get(0);
            // TODO: Support more cases, not only instantiation
            if (ClassInstanceCreation.class.isAssignableFrom(declaration.getInitializer().getClass())) {
                // TODO: Consider operations that don't rely on variables
                // Only work with variables
                returnValue = ((ClassInstanceCreation) declaration.getInitializer()).arguments().get(0).toString();
                if (!Util.isVariableName(returnValue)) {
                    returnValue = null;
                }
            }
        }

        return returnValue;
    }
}
