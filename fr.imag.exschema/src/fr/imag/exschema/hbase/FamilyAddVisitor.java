package fr.imag.exschema.hbase;

import fr.imag.exschema.UpdateVisitor;

/**
 * Identifies when a column family is added to a HBase table.
 * 
 * @author jccastrejon
 * 
 */
public class FamilyAddVisitor extends UpdateVisitor {
    @Override
    protected String getMethodBinding() {
        return "org.apache.hadoop.hbase.HTableDescriptor";
    }

    @Override
    protected String getMethodName() {
        return "addFamily";
    }
}
