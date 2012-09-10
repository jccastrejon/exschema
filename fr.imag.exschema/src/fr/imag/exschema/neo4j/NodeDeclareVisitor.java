package fr.imag.exschema.neo4j;

import fr.imag.exschema.DeclareVisitor;

/**
 * 
 * @author jccastrejon
 * 
 */
public class NodeDeclareVisitor extends DeclareVisitor {
    /**
     * 
     */
    public NodeDeclareVisitor() {
        super();
    }

    /**
     * 
     * @param variableName
     */
    public NodeDeclareVisitor(final String variableName) {
        super(variableName);
    }

    @Override
    protected String getExpectedQualifiedName() {
        return "org.neo4j.graphdb.Node";
    }
}
