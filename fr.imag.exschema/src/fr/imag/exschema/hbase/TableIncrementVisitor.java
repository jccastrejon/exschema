package fr.imag.exschema.hbase;

import fr.imag.exschema.UpdateVisitor;

/**
 * Identifies modification of HBase tables;
 * 
 * @author jccastrejon
 * 
 */
public class TableIncrementVisitor extends UpdateVisitor {
    @Override
    protected String getMethodBinding() {
        return "org.apache.hadoop.hbase.client.HTable";
    }

    @Override
    protected String getMethodName() {
        return "increment";
    }
}