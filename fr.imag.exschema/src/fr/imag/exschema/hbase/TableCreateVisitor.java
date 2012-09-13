package fr.imag.exschema.hbase;

import fr.imag.exschema.UpdateVisitor;

/**
 * Identifies the creation of HBase tables;
 * 
 * @author jccastrejon
 * 
 */
public class TableCreateVisitor extends UpdateVisitor {
    @Override
    protected String getMethodBinding() {
        return "org.apache.hadoop.hbase.client.HBaseAdmin";
    }

    @Override
    protected String getMethodName() {
        return "createTable";
    }
}
