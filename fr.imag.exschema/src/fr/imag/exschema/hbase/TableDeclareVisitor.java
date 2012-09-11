package fr.imag.exschema.hbase;

import fr.imag.exschema.DeclareVisitor;

/**
 * 
 * @author jccastrejon
 * 
 */
public class TableDeclareVisitor extends DeclareVisitor {
    /**
     * 
     * @param variableName
     */
    public TableDeclareVisitor(final String variableName) {
        super(variableName);
    }

    @Override
    protected String getExpectedQualifiedName() {
        return "org.apache.hadoop.hbase.HTableDescriptor";
    }
}
