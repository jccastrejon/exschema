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
package fr.imag.exschema.mongodb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;

import fr.imag.exschema.SchemaFinder;
import fr.imag.exschema.Util;
import fr.imag.exschema.exporter.RooModel;
import fr.imag.exschema.model.Attribute;
import fr.imag.exschema.model.Set;
import fr.imag.exschema.model.Struct;

/**
 * MongoDB utility methods.
 * 
 * @author jccastrejon
 * 
 */
public class MongoDBUtil implements SchemaFinder {

    /**
     * Class logger.
     */
    private static Logger logger = Logger.getLogger(MongoDBUtil.class.getName());

    @Override
    public List<Set> discoverSchemas(final IJavaProject project) throws CoreException {
        List<Set> returnValue;

        // Analyze code for mongodb operations
        returnValue = new ArrayList<Set>();
        MongoDBUtil.analyzeSaveInvocations(project, returnValue);
        MongoDBUtil.analyzeSpringCrossStore(project, returnValue);

        return returnValue;
    }

    /**
     * Analyze invocation to MongoDB's java API (save invocations).
     * 
     * @param discoveredSchemas
     * @throws CoreException 
     */
    private static void analyzeSaveInvocations(final IJavaProject project, final List<Set> discoveredSchemas)
            throws CoreException {
        Set currentFields;
        Struct currentField;
        Set currentDatabase;
        Set currentCollection;
        Struct currentDocument;
        MongoInsertVisitor insertVisitor;
        Map<String, Map<String, List<String>>> mongoCollections;

        // Identify when objects are being saved
        insertVisitor = new MongoInsertVisitor();
        Util.analyzeJavaProject(project, insertVisitor);

        mongoCollections = MongoDBUtil.getMongoCollections(insertVisitor.getSaveInvocations());
        if (!mongoCollections.isEmpty()) {
            currentDatabase = new Set();
            currentDatabase.addAttribute(new Attribute("implementation", RooModel.MONGODB.toString()));
            discoveredSchemas.add(currentDatabase);
            MongoDBUtil.logger.log(Util.LOGGING_LEVEL, "\nMongoDB documents (based on inserts): ");
            for (String collection : mongoCollections.keySet()) {
                currentCollection = new Set();
                currentDatabase.addSet(currentCollection);
                currentCollection.addAttribute(new Attribute("name", collection));
                MongoDBUtil.logger.log(Util.LOGGING_LEVEL, "--Collection: " + collection);
                for (String document : mongoCollections.get(collection).keySet()) {
                    currentDocument = new Struct();
                    currentCollection.addStruct(currentDocument);
                    currentDocument.addAttribute(new Attribute("name", document));
                    MongoDBUtil.logger.log(Util.LOGGING_LEVEL, "----Document: " + document);
                    if (!mongoCollections.get(collection).isEmpty()) {
                        currentFields = new Set();
                        currentDocument.addSet(currentFields);
                        for (String field : mongoCollections.get(collection).get(document)) {
                            currentField = new Struct();
                            currentFields.addStruct(currentField);
                            currentField.addAttribute(new Attribute("name", field));
                            MongoDBUtil.logger.log(Util.LOGGING_LEVEL, "------Field: " + field);
                        }
                    }
                }
            }
        }
    }

    /**
     * Analyze Spring based cross-store usage.
     * 
     * @param project
     * @param discoveredSchemas
     * @throws CoreException 
     */
    private static void analyzeSpringCrossStore(final IJavaProject project, final List<Set> discoveredSchemas)
            throws CoreException {
        Set currentFields;
        Struct currentField;
        Set currentDatabase;
        Set currentCollection;
        Struct currentDocument;
        RelatedDocumentVisitor relatedDocumentVisitor;

        relatedDocumentVisitor = new RelatedDocumentVisitor();
        Util.analyzeJavaProject(project, relatedDocumentVisitor);

        if (!relatedDocumentVisitor.getEntities().isEmpty()) {
            // Database
            currentDatabase = new Set();
            currentDatabase.addAttribute(new Attribute("implementation", RooModel.MONGODB.toString()));
            discoveredSchemas.add(currentDatabase);

            // Treat each entity as a unique collection/document
            MongoDBUtil.logger.log(Util.LOGGING_LEVEL, "\nMongoDB documents (based on spring data cross-store): ");
            for (String entity : relatedDocumentVisitor.getEntities().keySet()) {
                // Collection
                currentCollection = new Set();
                currentDatabase.addSet(currentCollection);
                currentCollection.addAttribute(new Attribute("name", entity + "Collection"));
                MongoDBUtil.logger.log(Util.LOGGING_LEVEL, "--Collection: " + entity + "Collection");

                // Document
                currentDocument = new Struct();
                currentCollection.addStruct(currentDocument);
                currentDocument.addAttribute(new Attribute("name", entity));
                MongoDBUtil.logger.log(Util.LOGGING_LEVEL, "----Document: " + entity);

                // Fields
                if ((relatedDocumentVisitor.getEntities().get(entity) != null)
                        && (relatedDocumentVisitor.getEntities().get(entity).length > 0)) {
                    currentFields = new Set();
                    currentDocument.addSet(currentFields);
                    for (IVariableBinding field : relatedDocumentVisitor.getEntities().get(entity)) {
                        currentField = new Struct();
                        currentFields.addStruct(currentField);
                        currentField.addAttribute(new Attribute("name", field.getName()));
                        MongoDBUtil.logger.log(Util.LOGGING_LEVEL, "------Field: " + field.getName());
                    }
                }
            }
        }
    }

    /**
     * Identify MongoDB collections from the given list of invocations.
     * 
     * @param invocations
     * @return
     */
    private static Map<String, Map<String, List<String>>> getMongoCollections(final List<MethodInvocation> invocations) {
        String argumentName;
        String argumentClass;
        Block invocationBlock;
        String currentCollectionName;
        MongoUpdateVisitor updateVisitor;
        MongoCollectionVisitor collectionVisitor;
        Map<String, Block> collectionsBlocks;
        Map<String, List<String>> currentCollection;
        Map<String, Map<String, List<String>>> returnValue;
        Map<String, Map<String, List<String>>> collectionsData;

        // TODO: Consider what would happen if the same collection variable is
        // initialized more than once (coll=db.getCollection()) in a same block
        collectionsBlocks = new HashMap<String, Block>();
        collectionsData = new HashMap<String, Map<String, List<String>>>();
        for (MethodInvocation methodInvocation : invocations) {
            for (Object argument : methodInvocation.arguments()) {
                argumentClass = ((Expression) argument).resolveTypeBinding().getQualifiedName();
                if (argumentClass.equals("com.mongodb.BasicDBObject")) {
                    argumentName = argument.toString();
                    // TODO: Consider operations that don't rely on variables
                    // Only work with variables
                    if (Util.isVariableName(argumentName)) {
                        invocationBlock = Util.getInvocationBlock(methodInvocation);
                        if (invocationBlock != null) {
                            updateVisitor = new MongoUpdateVisitor(argumentName);
                            invocationBlock.accept(updateVisitor);

                            // Build {collections {documents {fields}}}
                            currentCollectionName = methodInvocation.getExpression().toString();
                            currentCollection = collectionsData.get(currentCollectionName);
                            if (currentCollection == null) {
                                currentCollection = new HashMap<String, List<String>>();
                                collectionsData.put(currentCollectionName, currentCollection);
                                collectionsBlocks.put(currentCollectionName, invocationBlock);
                            }

                            currentCollection.put(argumentName, updateVisitor.getFields());
                        }
                    }
                }
            }
        }

        // Get collections name
        returnValue = new HashMap<String, Map<String, List<String>>>();
        for (String collection : collectionsBlocks.keySet()) {
            collectionVisitor = new MongoCollectionVisitor(collection);
            collectionsBlocks.get(collection).accept(collectionVisitor);
            returnValue.put(collectionVisitor.getCollectionName(), collectionsData.get(collection));
        }

        return returnValue;
    }
}
