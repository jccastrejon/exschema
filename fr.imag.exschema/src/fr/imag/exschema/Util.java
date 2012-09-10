package fr.imag.exschema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import fr.imag.exschema.mongodb.MongoCollectionVisitor;
import fr.imag.exschema.mongodb.MongoInsertVisitor;
import fr.imag.exschema.mongodb.MongoUpdateVisitor;
import fr.imag.exschema.neo4j.ContainerUpdateVisitor;
import fr.imag.exschema.neo4j.NodeDeclareVisitor;
import fr.imag.exschema.neo4j.NodeEntityVisitor;
import fr.imag.exschema.neo4j.RelationshipCreateVisitor;
import fr.imag.exschema.neo4j.RelationshipDeclareVisitor;
import fr.imag.exschema.neo4j.RelationshipEndNodeVisitor;
import fr.imag.exschema.neo4j.RelationshipStartNodeVisitor;

/**
 * 
 * @author jccastrejon
 * 
 */
public class Util {

    /**
     * 
     * @param project
     * @throws JavaModelException
     */
    public static void discoverSchemas(final IJavaProject project) throws JavaModelException {
        // Document
        Util.discoverRepositories(project);
        Util.discoverMongoObjects(project);

        // Graph
        Util.discoverNeo4JNodeEntities(project);
        Util.discoverNeo4JNodes(project);

        // Column
    }

    /**
     * 
     * @param node
     * @return
     */
    public static Block getInvocationBlock(final ASTNode node) {
        Block returnValue;

        returnValue = null;
        if (node != null) {
            if (Block.class.isAssignableFrom(node.getClass())) {
                returnValue = (Block) node;
            } else {
                returnValue = Util.getInvocationBlock(node.getParent());
            }
        }

        return returnValue;
    }

    /**
     * Spring-based repositories.
     * 
     * @param project
     * @throws JavaModelException
     */
    private static void discoverRepositories(final IJavaProject project) throws JavaModelException {
        SpringRepositoryVisitor annotationVisitor;

        // Identify model classes
        annotationVisitor = new SpringRepositoryVisitor();
        Util.analyzeJavaProject(project, annotationVisitor);

        // Analyze model classes
        System.out.println("Spring-based repository classes: ");
        for (IPackageFragment aPackage : project.getPackageFragments()) {
            if (aPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                for (ICompilationUnit compilationUnit : aPackage.getCompilationUnits()) {
                    for (IType type : compilationUnit.getAllTypes()) {
                        for (String domainClass : annotationVisitor.getDomainClasses()) {
                            if (type.getFullyQualifiedName().equals(domainClass)) {
                                System.out.println("\n" + domainClass);
                                Util.analyzeModelType(type);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 
     * @param project
     * @throws JavaModelException
     */
    private static void discoverMongoObjects(final IJavaProject project) throws JavaModelException {
        MongoInsertVisitor insertVisitor;
        Map<String, Map<String, List<String>>> mongoCollections;

        // Identify when objects are being saved
        insertVisitor = new MongoInsertVisitor();
        Util.analyzeJavaProject(project, insertVisitor);

        // Analyze save invocations
        // TODO: Real analysis...
        System.out.println("\nMongoDB documents (based on inserts): ");
        mongoCollections = Util.getMongoCollections(insertVisitor.getSaveInvocations());
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
     * @param project
     * @throws JavaModelException
     */
    private static void discoverNeo4JNodeEntities(final IJavaProject project) throws JavaModelException {
        NodeEntityVisitor entityVisitor;

        // Identify node entities
        entityVisitor = new NodeEntityVisitor();
        Util.analyzeJavaProject(project, entityVisitor);

        // TODO: Real analysis...
        System.out.println("Neo4J node entities: ");
        for (String node : entityVisitor.getNodeEntities().keySet()) {
            System.out.println("\n--Node: " + node);
            for (FieldDeclaration field : entityVisitor.getNodeEntities().get(node)) {
                System.out.println("----Field: " + field.fragments().get(0));
                if (Util.hasRelatedToAnnotation(field.modifiers())) {
                    System.out.println("------Related to: " + field.getType());
                }
            }
        }
    }

    /**
     * 
     * @param project
     * @throws JavaModelException
     */
    private static void discoverNeo4JNodes(final IJavaProject project) throws JavaModelException {
        String endNode;
        String nodeClass;
        String startNode;
        String node2Class;
        List<String> currentRelations;
        ContainerUpdateVisitor updateVisitor;
        Map<String, List<String>> nodes;
        NodeDeclareVisitor declareVisitor;
        Map<String, List<String>> relationships;
        RelationshipCreateVisitor relationVisitor;
        VariableDeclarationFragment endDeclaration;
        Map<String, String> currentRelationshipType;
        Map<String, List<String>> nodesRelationships;
        VariableDeclarationFragment startDeclaration;
        Map<String, Map<String, String>> relationshipTypes;
        Map<String, List<String>> currentRelationshipFields;
        RelationshipDeclareVisitor relationshipDeclareVisitor;
        Map<String, Map<String, List<String>>> relationshipFields;

        // Identify when nodes are being declared
        declareVisitor = new NodeDeclareVisitor();
        Util.analyzeJavaProject(project, declareVisitor);

        // Identify when nodes are assigned properties
        updateVisitor = new ContainerUpdateVisitor();
        Util.analyzeJavaProject(project, updateVisitor);

        // Identify when nodes are being related
        relationVisitor = new RelationshipCreateVisitor();
        Util.analyzeJavaProject(project, relationVisitor);

        // Identify when relationships are declared
        relationshipDeclareVisitor = new RelationshipDeclareVisitor();
        Util.analyzeJavaProject(project, relationshipDeclareVisitor);

        // Match nodes to their corresponding fields and relations
        nodes = Util.associateContainersFields(declareVisitor.getVariableDeclarations(),
                updateVisitor.getUpdateInvocations());

        // Match relationships to their corresponding fields and relations
        relationships = Util.associateContainersFields(relationshipDeclareVisitor.getVariableDeclarations(),
                updateVisitor.getUpdateInvocations());

        // Identify relations between the identified nodes
        nodesRelationships = new HashMap<String, List<String>>();
        relationshipTypes = new HashMap<String, Map<String, String>>();
        for (MethodInvocation invocation : relationVisitor.getCreateInvocations()) {
            // TODO: Consider operations that don't rely on variables
            // Only work with variables
            startNode = invocation.getExpression().toString();
            endNode = invocation.arguments().get(0).toString();
            if (Util.isVariableName(startNode) && Util.isVariableName(endNode)) {
                endDeclaration = Util.getVariableDeclaration(Util.getInvocationBlock(invocation), endNode);
                startDeclaration = Util.getVariableDeclaration(Util.getInvocationBlock(invocation), startNode);
                if ((endDeclaration != null) && (startDeclaration != null)) {
                    // Try to match the previously identified nodes with the
                    // relationships' nodes
                    for (String node : nodes.keySet()) {
                        nodeClass = node.substring(0, node.indexOf('.'));
                        // Match startNode
                        if (startDeclaration.getInitializer().toString().contains(nodeClass)) {
                            currentRelations = nodesRelationships.get(node);
                            if (currentRelations == null) {
                                currentRelations = new ArrayList<String>();
                            }

                            // Match endNode
                            for (String node2 : nodes.keySet()) {
                                node2Class = node2.substring(0, node2.indexOf('.'));
                                if (endDeclaration.getInitializer().toString().contains(node2Class)) {
                                    currentRelationshipType = relationshipTypes.get(node);
                                    if (currentRelationshipType == null) {
                                        currentRelationshipType = new HashMap<String, String>();
                                        relationshipTypes.put(node, currentRelationshipType);
                                    }

                                    // Add the relation and its type
                                    currentRelations.add(node2);
                                    currentRelationshipType.put(node2, invocation.arguments().get(1).toString());
                                    break;
                                }
                            }

                            // Save relationships (if any)
                            if (currentRelations.size() > 0) {
                                nodesRelationships.put(node, currentRelations);
                            }
                        }
                    }
                }
            }
        }

        // Associate relationships found between nodes and the combinations of
        // relationships-fields
        relationshipFields = new HashMap<String, Map<String, List<String>>>();
        for (String relationStart : nodes.keySet()) {
            if (nodesRelationships.get(relationStart) != null) {
                for (String relationEnd : nodesRelationships.get(relationStart)) {
                    for (String relationship : relationships.keySet()) {
                        // Look for references to the start and end nodes for
                        // the relationship
                        RelationshipStartNodeVisitor startNodeVisitor = new RelationshipStartNodeVisitor(
                                relationship.substring(relationship.lastIndexOf('.') + 1));
                        RelationshipEndNodeVisitor endNodeVisitor = new RelationshipEndNodeVisitor(
                                relationship.substring(relationship.lastIndexOf('.') + 1));
                        Util.analyzeJavaProject(project, startNodeVisitor);
                        Util.analyzeJavaProject(project, endNodeVisitor);

                        // Look for classes between the classes associated to
                        // the start and end nodes of the relation, and
                        // previously discovered nodes
                        if ((startNodeVisitor.getUpdateInvocations().size() > 0)
                                && (endNodeVisitor.getUpdateInvocations().size() > 0)) {
                            if ((Util.isMatchingClass(startNodeVisitor.getUpdateInvocations().get(0), relationStart))
                                    && (Util.isMatchingClass(endNodeVisitor.getUpdateInvocations().get(0), relationEnd))) {
                                currentRelationshipFields = relationshipFields.get(relationStart);
                                if (currentRelationshipFields == null) {
                                    currentRelationshipFields = new HashMap<String, List<String>>();
                                    relationshipFields.put(relationStart, currentRelationshipFields);
                                }

                                currentRelationshipFields.put(relationEnd, relationships.get(relationship));
                            }
                        }
                    }
                }
            }
        }

        // TODO: Real analysis...
        System.out.println("\nNeo4J nodes: ");
        for (String node : nodes.keySet()) {
            System.out.println("\n--Node: " + node);
            for (String field : nodes.get(node)) {
                System.out.println("\n----Field: " + field);
            }

            if (nodesRelationships.get(node) != null) {
                for (String relationship : nodesRelationships.get(node)) {
                    System.out.println("\n----Relationship: " + relationship + " ["
                            + relationshipTypes.get(node).get(relationship) + "]");
                    if (relationshipFields.get(node).get(relationship) != null) {
                        for (String relationField : relationshipFields.get(node).get(relationship)) {
                            System.out.println("\n------Relationship field: " + relationField);
                        }
                    }
                }
            }
        }
    }

    /**
     * 
     * @param invocation
     * @param className
     * @return
     */
    private static boolean isMatchingClass(final MethodInvocation invocation, final String className) {
        boolean returnValue;

        // TODO: Support more cases, not only instantiation
        returnValue = false;
        if (ClassInstanceCreation.class.isAssignableFrom(invocation.getParent().getClass())) {
            if (className.contains(((ClassInstanceCreation) invocation.getParent()).resolveTypeBinding().getName())) {
                returnValue = true;
            }
        }

        return returnValue;
    }

    /**
     * 
     * @param declarations
     * @param updateInvocations
     * @return
     */
    private static Map<String, List<String>> associateContainersFields(
            final List<VariableDeclarationFragment> declarations, List<MethodInvocation> updateInvocations) {
        String fragmentKey;
        String fragmentRoot;
        String invocationRoot;
        List<String> currentFields;
        Map<String, List<String>> returnValue;

        returnValue = new HashMap<String, List<String>>();
        // Declarations
        for (VariableDeclarationFragment fragment : declarations) {
            currentFields = new ArrayList<String>();
            fragmentRoot = ((CompilationUnit) fragment.getRoot()).getTypeRoot().getElementName();

            // Fields
            for (MethodInvocation invocation : updateInvocations) {
                invocationRoot = ((CompilationUnit) invocation.getRoot()).getTypeRoot().getElementName();
                // Match name of declare and update variables, in the same file
                if (fragmentRoot.equals(invocationRoot)) {
                    if (fragment.getName().toString().equals(invocation.getExpression().toString())) {
                        currentFields.add(((SimpleName) invocation.arguments().get(0)).toString());
                    }
                }
            }

            fragmentKey = fragmentRoot + "." + fragment.toString();
            if ((currentFields.size() > 0) && (returnValue.get(fragmentKey) == null)) {
                returnValue.put(fragmentKey, currentFields);
            }
        }

        return returnValue;
    }

    /**
     * 
     * @param block
     * @param variableName
     * @return
     */
    private static VariableDeclarationFragment getVariableDeclaration(final Block block, final String variableName) {
        VariableDeclarationFragment returnValue;
        NodeDeclareVisitor variableDeclareVisitor;

        variableDeclareVisitor = new NodeDeclareVisitor(variableName);
        block.accept(variableDeclareVisitor);
        returnValue = null;
        if (!variableDeclareVisitor.getVariableDeclarations().isEmpty()) {
            returnValue = variableDeclareVisitor.getVariableDeclarations().get(0);
        }

        return returnValue;
    }

    /**
     * 
     * @param modifier
     * @return
     */
    private static boolean hasRelatedToAnnotation(final List<?> modifiers) {
        boolean returnValue;
        String annotationName;

        returnValue = false;
        for (Object modifier : modifiers) {
            if (NormalAnnotation.class.isAssignableFrom(modifier.getClass())) {
                annotationName = ((NormalAnnotation) modifier).resolveTypeBinding().getQualifiedName();
                if (annotationName.equals("org.springframework.data.neo4j.annotation.RelatedTo")) {
                    returnValue = true;
                    break;
                }
            }
        }

        return returnValue;
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

    /**
     * 
     * @param type
     * @throws JavaModelException
     */
    private static void analyzeModelType(IType type) throws JavaModelException {
        // TODO: Real analysis...
        System.out.println("Fields:");
        for (IField field : type.getFields()) {
            System.out.println(field.getElementName() + ":" + field.getTypeSignature());
        }
    }

    /**
     * 
     * @param project
     * @param visitor
     * @throws JavaModelException
     */
    private static void analyzeJavaProject(final IJavaProject project, final ASTVisitor visitor)
            throws JavaModelException {
        CompilationUnit parsedUnit;

        for (IPackageFragment aPackage : project.getPackageFragments()) {
            if (aPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                for (ICompilationUnit compilationUnit : aPackage.getCompilationUnits()) {
                    parsedUnit = Util.parse(compilationUnit);
                    parsedUnit.accept(visitor);
                }
            }
        }
    }

    /**
     * 
     * @param compilationUnit
     * @return
     */
    private static CompilationUnit parse(final ICompilationUnit compilationUnit) {
        ASTParser parser;

        parser = ASTParser.newParser(AST.JLS4);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setSource(compilationUnit);
        parser.setResolveBindings(true);
        return (CompilationUnit) parser.createAST(null);
    }

    /**
     * 
     * @param name
     * @return
     */
    private static boolean isVariableName(final String name) {
        return name.matches("^[a-zA-Z][a-zA-Z0-9]*?$");
    }
}
