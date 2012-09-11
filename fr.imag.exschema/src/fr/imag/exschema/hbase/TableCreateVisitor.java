package fr.imag.exschema.hbase;

import fr.imag.exschema.UpdateVisitor;

/**
 * 
 * @author jccastrejon
 *
 */
public class TableCreateVisitor extends UpdateVisitor{
    @Override
    protected String getMethodBinding() {
        return "org.apache.hadoop.hbase.client.HBaseAdmin";
    }

    @Override
    protected String getMethodName() {
        return "createTable";
    }
}
