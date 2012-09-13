package fr.imag.exschema.hbase;

import fr.imag.exschema.DeclareVisitor;

/**
 * Identifies declarations of HBase tables.
 * 
 * @author jccastrejon
 * 
 */
public class TableDeclareVisitor extends DeclareVisitor {
    @Override
    protected String getExpectedQualifiedName() {
        return "org.apache.hadoop.hbase.HTableDescriptor";
    }
}
