package fr.imag.exschema.neo4j;

import fr.imag.exschema.DeclareVisitor;

/**
 * Identifies declarations of Neo4j nodes.
 * 
 * @author jccastrejon
 * 
 */
public class NodeDeclareVisitor extends DeclareVisitor {
    @Override
    protected String getExpectedQualifiedName() {
        return "org.neo4j.graphdb.Node";
    }
}
