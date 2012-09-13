package fr.imag.exschema.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;

/**
 * Identifies inserts to MongoDB collections.
 * 
 * @author jccastrejon
 * 
 */
public class MongoInsertVisitor extends ASTVisitor {

    /**
     * Method invocations to MongoDB save operations.
     */
    private List<MethodInvocation> saveInvocations;

    /**
     * Default constructor.
     */
    public MongoInsertVisitor() {
        this.saveInvocations = new ArrayList<MethodInvocation>();
    }

    @Override
    public boolean visit(final MethodInvocation invocation) {
        if (this.isInsertMethod(invocation)) {
            this.saveInvocations.add(invocation);
        }

        return super.visit(invocation);
    }

    /**
     * Decide whether or not the given invocation represents a MongoDB
     * collection's insert operation.
     * 
     * @param invocation
     * @return
     */
    private boolean isInsertMethod(final MethodInvocation invocation) {
        boolean returnValue;
        ITypeBinding typeBinding;

        returnValue = false;
        typeBinding = invocation.resolveTypeBinding();
        if (typeBinding != null) {
            // Analyze when documents are saved in mongodb
            if (typeBinding.getQualifiedName().toString().equals("com.mongodb.WriteResult")) {
                if (invocation.getName().toString().equals("insert")) {
                    returnValue = true;
                }
            }
        }

        return returnValue;
    }

    /**
     * Get the save invocations.
     * 
     * @return
     */
    public List<MethodInvocation> getSaveInvocations() {
        return this.saveInvocations;
    }
}