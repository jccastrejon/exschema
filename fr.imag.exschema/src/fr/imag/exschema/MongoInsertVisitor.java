package fr.imag.exschema;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MethodInvocation;

/**
 * 
 * @author jccastrejon
 * 
 */
public class MongoInsertVisitor extends ASTVisitor {
    private List<MethodInvocation> saveInvocations;

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
     * 
     * @return
     */
    public List<MethodInvocation> getSaveInvocations() {
        return this.saveInvocations;
    }
}