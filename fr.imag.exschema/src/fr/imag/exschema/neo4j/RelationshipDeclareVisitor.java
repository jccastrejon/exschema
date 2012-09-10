package fr.imag.exschema.neo4j;

import fr.imag.exschema.DeclareVisitor;

/**
 * 
 * @author jccastrejon
 * 
 */
public class RelationshipDeclareVisitor extends DeclareVisitor {
    /**
     * 
     */
    public RelationshipDeclareVisitor() {
        super();
    }

    /**
     * 
     * @param variableName
     */
    public RelationshipDeclareVisitor(final String variableName) {
        super(variableName);
    }

    @Override
    protected String getExpectedQualifiedName() {
        return "org.neo4j.graphdb.Relationship";
    }
}