package fr.imag.exschema.hbase;

import fr.imag.exschema.DeclareVisitor;

/**
 * 
 * @author jccastrejon
 * 
 */
public class ColumnFamilyDeclareVisitor extends DeclareVisitor {
    @Override
    protected String getExpectedQualifiedName() {
        return "org.apache.hadoop.hbase.HColumnDescriptor";
    }
}
