package fr.imag.exschema.hbase;

import fr.imag.exschema.UpdateVisitor;

/**
 * Identifies the addition of data into a HBase table.
 * 
 * @author jccastrejon
 * 
 */
public class TablePutVisitor extends UpdateVisitor {
    @Override
    protected String getMethodBinding() {
        return "org.apache.hadoop.hbase.client.HTable";
    }

    @Override
    protected String getMethodName() {
        return "put";
    }
}