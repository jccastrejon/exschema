package fr.imag.exschema.hbase;

import fr.imag.exschema.DeclareVisitor;

/**
 * 
 * @author jccastrejon
 * 
 */
public class ColumnFamilyDeclareVisitor extends DeclareVisitor {
    /**
     * 
     * @param variableName
     */
    public ColumnFamilyDeclareVisitor(final String variableName) {
       super(variableName); 
    }
    
    @Override
    protected String getExpectedQualifiedName() {
        return "org.apache.hadoop.hbase.HColumnDescriptor";
    }
}
