package fr.imag.exschema.neo4j;

import fr.imag.exschema.DeclareVisitor;

/**
 * Identifies when Neo4j relationships are declared.
 * 
 * @author jccastrejon
 * 
 */
public class RelationshipDeclareVisitor extends DeclareVisitor {
    @Override
    protected String getExpectedQualifiedName() {
        return "org.neo4j.graphdb.Relationship";
    }
}