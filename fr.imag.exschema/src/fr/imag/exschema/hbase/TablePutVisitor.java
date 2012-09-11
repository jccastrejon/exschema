package fr.imag.exschema.hbase;

import fr.imag.exschema.UpdateVisitor;

/**
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