package fr.imag.exschema.neo4j;

import fr.imag.exschema.UpdateVisitor;

/**
 * Identifies updates to Neo4j's containers.
 * 
 * @author jccastrejon
 * 
 */
public class ContainerUpdateVisitor extends UpdateVisitor {
    @Override
    protected String getMethodBinding() {
        return "org.neo4j.graphdb.PropertyContainer";
    }

    @Override
    protected String getMethodName() {
        return "setProperty";
    }
}
