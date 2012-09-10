package fr.imag.exschema.neo4j;

import fr.imag.exschema.UpdateVisitor;

/**
 * 
 * @author jccastrejon
 * 
 */
public class RelationshipStartNodeVisitor extends UpdateVisitor {
    /**
     * 
     * @param variableName
     */
    public RelationshipStartNodeVisitor(final String variableName) {
        super(variableName);
    }

    @Override
    protected String getMethodBinding() {
        return "org.neo4j.graphdb.Relationship";
    }

    @Override
    protected String getMethodName() {
        return "getStartNode";
    }
}
