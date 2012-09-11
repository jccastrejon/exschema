package fr.imag.exschema.neo4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;

import fr.imag.exschema.Util;

/**
 * 
 * @author jccastrejon
 *
 */
public class Neo4jUtil {
    /**
     * 
     * @param project
     * @throws JavaModelException
     */
    public static void discoverNeo4JNodeEntities(final IJavaProject project) throws JavaModelException {
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
                if (Neo4jUtil.hasRelatedToAnnotation(field.modifiers())) {
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
    public static void discoverNeo4JNodes(final IJavaProject project) throws JavaModelException {
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
        nodes = Neo4jUtil.associateContainersFields(declareVisitor.getVariableDeclarations(),
                updateVisitor.getUpdateInvocations());

        // Match relationships to their corresponding fields and relations
        relationships = Neo4jUtil.associateContainersFields(relationshipDeclareVisitor.getVariableDeclarations(),
                updateVisitor.getUpdateInvocations());

        // Identify relations between the identified nodes
        nodesRelationships = new HashMap<String, List<String>>();
        relationshipTypes = new HashMap<String, Map<String, String>>();
        for (MethodInvocation invocation : relationVisitor.getUpdateInvocations()) {
            // TODO: Consider operations that don't rely on variables
            // Only work with variables
            startNode = invocation.getExpression().toString();
            endNode = invocation.arguments().get(0).toString();
            if (Util.isVariableName(startNode) && Util.isVariableName(endNode)) {
                endDeclaration = Neo4jUtil.getVariableDeclaration(Util.getInvocationBlock(invocation), endNode);
                startDeclaration = Neo4jUtil.getVariableDeclaration(Util.getInvocationBlock(invocation), startNode);
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
                        RelationshipStartNodeVisitor startNodeVisitor = new RelationshipStartNodeVisitor();
                        startNodeVisitor.setVariableName(relationship.substring(relationship.lastIndexOf('.') + 1));
                        RelationshipEndNodeVisitor endNodeVisitor = new RelationshipEndNodeVisitor();
                        endNodeVisitor.setVariableName(relationship.substring(relationship.lastIndexOf('.') + 1));
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

        variableDeclareVisitor = new NodeDeclareVisitor();
        variableDeclareVisitor.setVariableName(variableName);
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
}
