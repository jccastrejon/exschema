package fr.imag.exschema.neo4j;

import fr.imag.exschema.UpdateVisitor;

/**
 * Identifies references to start nodes of Neo4j relationships.
 * 
 * @author jccastrejon
 * 
 */
public class RelationshipStartNodeVisitor extends UpdateVisitor {
    @Override
    protected String getMethodBinding() {
        return "org.neo4j.graphdb.Relationship";
    }

    @Override
    protected String getMethodName() {
        return "getStartNode";
    }
}
