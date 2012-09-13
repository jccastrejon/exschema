package fr.imag.exschema;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;

/**
 * Generic visitor for classes that need to identify update operations,
 * associated to a particular Method binding and with a specific name.
 * 
 * @author jccastrejon
 * 
 */
public abstract class UpdateVisitor extends ASTVisitor {

    /**
     * Update's variable name.
     */
    private String variableName;

    /**
     * Matching invocations.
     */
    private List<MethodInvocation> updateInvocations;

    /**
     * Default constructor.
     */
    public UpdateVisitor() {
        this.updateInvocations = new ArrayList<MethodInvocation>();
    }

    /**
     * Full constructor.
     * 
     * @param variableName
     */
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
     * Determine if the specified method matches with the ones we're looking
     * for.
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
     * The fully qualified name of the expected method binding.
     * 
     * @return
     */
    protected abstract String getMethodBinding();

    /**
     * Expected method name.
     * 
     * @return
     */
    protected abstract String getMethodName();
}
