package fr.imag.exschema.hbase;

import fr.imag.exschema.UpdateVisitor;

/**
 * 
 * @author jccastrejon
 * 
 */
public class FamilyAddVisitor extends UpdateVisitor {
    /**
     * 
     * @param variableName
     */
    public FamilyAddVisitor(final String variableName) {
        super(variableName);
    }

    @Override
    protected String getMethodBinding() {
        return "org.apache.hadoop.hbase.HTableDescriptor";
    }

    @Override
    protected String getMethodName() {
        return "addFamily";
    }
}
