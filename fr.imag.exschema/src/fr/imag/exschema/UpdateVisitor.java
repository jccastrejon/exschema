package fr.imag.exschema;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;

/**
 * 
 * @author jccastrejon
 * 
 */
public abstract class UpdateVisitor extends ASTVisitor {
    /**
     * 
     */
    private String variableName;

    /**
     * 
     */
    private List<MethodInvocation> updateInvocations;

    /**
     * 
     */
    public UpdateVisitor() {
        this.updateInvocations = new ArrayList<MethodInvocation>();
    }

    public UpdateVisitor(final String variableName) {
        this.variableName = variableName;
        this.updateInvocations = new ArrayList<MethodInvocation>();
    }

    @Override
    public boolean visit(final MethodInvocation invocation) {
        if (this.isUpdateMethod(invocation)) {
            this.updateInvocations.add(invocation);
        }

        return super.visit(invocation);
    }

    /**
     * 
     * @param invocation
     * @return
     */
    private boolean isUpdateMethod(final MethodInvocation invocation) {
        boolean returnValue;

        returnValue = false;
        if (this.getMethodBinding().equals(invocation.resolveMethodBinding().getDeclaringClass().getQualifiedName())) {
            if (invocation.getName().toString().equals(this.getMethodName())) {
                if (this.variableName != null) {
                    if (this.variableName.equals(invocation.getExpression().toString())) {
                        returnValue = true;
                    }
                } else {
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
    public List<MethodInvocation> getUpdateInvocations() {
        return this.updateInvocations;
    }
    
    /**
     * 
     * @param variableName
     */
    public void setVariableName(final String variableName) {
        this.variableName = variableName;
    }

    /**
     * 
     * @return
     */
    protected abstract String getMethodBinding();

    /**
     * 
     * @return
     */
    protected abstract String getMethodName();
}
