package fr.imag.exschema.neo4j;

import fr.imag.exschema.UpdateVisitor;

/**
 * Identifies the creation of relationships between Neo4j nodes.
 * 
 * @author jccastrejon
 * 
 */
public class RelationshipCreateVisitor extends UpdateVisitor {
    @Override
    protected String getMethodBinding() {
        return "org.neo4j.graphdb.Node";
    }

    @Override
    protected String getMethodName() {
        return "createRelationshipTo";
    }
}
