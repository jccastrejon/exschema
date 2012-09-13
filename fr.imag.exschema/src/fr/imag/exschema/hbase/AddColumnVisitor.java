package fr.imag.exschema.hbase;

import fr.imag.exschema.UpdateVisitor;

/**
 * Identifies when HBase columns are added, based on the Increment API.
 * 
 * @author jccastrejon
 * 
 */
public class AddColumnVisitor extends UpdateVisitor {
    @Override
    protected String getMethodBinding() {
        return "org.apache.hadoop.hbase.client.Increment";
    }

    @Override
    protected String getMethodName() {
        return "addColumn";
    }
}
