package fr.imag.exschema.hbase;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import fr.imag.exschema.DeclareVisitor;
import fr.imag.exschema.UpdateVisitor;
import fr.imag.exschema.Util;

/**
 * 
 * @author jccastrejon
 *
 */
public class HBaseUtil {
    
    /**
     * 
     * @param project
     * @throws JavaModelException
     */
    public static void discoverHbaseTables(final IJavaProject project) throws JavaModelException {
        String tableName;
        List<String> columns;
        String tableDescriptor;
        String columnFamilyName;
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
        System.out.println("\n\nHBase tables:");
        for (MethodInvocation createInvocation : createVisitor.getUpdateInvocations()) {
            tableDescriptor = createInvocation.arguments().get(0).toString();

            // Table name
            declareVisitor = new TableDeclareVisitor();
            declareVisitor.setVariableName(tableDescriptor);
            tableName = HBaseUtil.getHBaseName(createInvocation.getRoot(), declareVisitor);
            if (tableName != null) {
                System.out.println("\n--Table: " + tableName);

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
                        System.out.println("\n----Family: " + columnFamilyName);

                        // Columns
                        if ((tableName != null) && (columnFamilyName != null)) {
                            // put(family, qualifier, value)
                            columns = HBaseUtil.getHBaseColumns(createInvocation.getRoot(), new PutAddVisitor(),
                                    columnFamilyName, putVisitor.getUpdateInvocations());

                            // addColumn(family, qualifier, amount)
                            columns.addAll(HBaseUtil.getHBaseColumns(createInvocation.getRoot(), new AddColumnVisitor(),
                                    columnFamilyName, incrementVisitor.getUpdateInvocations()));

                            for (String column : columns) {
                                System.out.println("\n------Column: " + column);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 
     * @param rootNode
     * @param updateVisitor
     * @param columnFamilyName
     * @param updateInvocations
     * @return
     */
    private static List<String> getHBaseColumns(final ASTNode rootNode, UpdateVisitor updateVisitor,
            final String columnFamilyName, final List<MethodInvocation> updateInvocations) {
        String putName;
        List<String> arguments;
        List<String> returnValue;

        returnValue = new ArrayList<String>();
        for (MethodInvocation putInvocation : updateInvocations) {
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

        return returnValue;
    }
    
    /**
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
