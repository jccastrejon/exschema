package fr.imag.exschema.hbase;

import fr.imag.exschema.UpdateVisitor;

/**
 * Identifies when data is added to HBase columns.
 * 
 * @author jccastrejon
 * 
 */
public class PutAddVisitor extends UpdateVisitor {
    @Override
    protected String getMethodBinding() {
        return "org.apache.hadoop.hbase.client.Put";
    }

    @Override
    protected String getMethodName() {
        return "add";
    }
}
