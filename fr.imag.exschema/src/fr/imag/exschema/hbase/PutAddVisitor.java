package fr.imag.exschema.hbase;

import fr.imag.exschema.UpdateVisitor;

/**
 * 
 * @author jccastrejon
 * 
 */
public class PutAddVisitor extends UpdateVisitor {
    /**
     * 
     * @param variableName
     */
    public PutAddVisitor(final String variableName) {
        super(variableName);
    }
    
    @Override
    protected String getMethodBinding() {
        return "org.apache.hadoop.hbase.client.Put";
    }

    @Override
    protected String getMethodName() {
        return "add";
    }
}
