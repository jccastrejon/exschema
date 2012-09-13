package fr.imag.exschema.neo4j;

import fr.imag.exschema.UpdateVisitor;

/**
 * Identifies references to end nodes of Neo4j relationships.
 * 
 * @author jccastrejon
 * 
 */
public class RelationshipEndNodeVisitor extends UpdateVisitor {
    @Override
    protected String getMethodBinding() {
        return "org.neo4j.graphdb.Relationship";
    }

    @Override
    protected String getMethodName() {
        return "getEndNode";
    }
}