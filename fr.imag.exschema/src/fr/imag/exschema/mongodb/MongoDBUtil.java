package fr.imag.exschema.mongodb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodInvocation;

import fr.imag.exschema.Util;

/**
 * 
 * @author jccastrejon
 *
 */
public class MongoDBUtil {
    /**
     * 
     * @param project
     * @throws JavaModelException
     */
    public static void discoverMongoObjects(final IJavaProject project) throws JavaModelException {
        MongoInsertVisitor insertVisitor;
        Map<String, Map<String, List<String>>> mongoCollections;

        // Identify when objects are being saved
        insertVisitor = new MongoInsertVisitor();
        Util.analyzeJavaProject(project, insertVisitor);

        // Analyze save invocations
        // TODO: Real analysis...
        System.out.println("\nMongoDB documents (based on inserts): ");
        mongoCollections = MongoDBUtil.getMongoCollections(insertVisitor.getSaveInvocations());
        for (String collection : mongoCollections.keySet()) {
            System.out.println("--Collection: " + collection);
            for (String document : mongoCollections.get(collection).keySet()) {
                System.out.println("----Document: " + document);
                for (String field : mongoCollections.get(collection).get(document)) {
                    System.out.println("------Field: " + field);
                }
            }
        }
    }
    
    /**
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
