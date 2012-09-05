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
public class MongoUpdateVisitor extends ASTVisitor {
    private String variableName;
    private List<String> fields;

    public MongoUpdateVisitor(final String variableName) {
        this.variableName = variableName;
        this.fields = new ArrayList<String>();
    }

    @Override
    public boolean visit(final MethodInvocation invocation) {
        if (this.isUpdateMethod(invocation)) {
            this.fields.add(invocation.arguments().get(0).toString());
        }

        return super.visit(invocation);
    }

    /**
     * Identify those update methods that affect the variable associated to this
     * visitor
     * 
     * @param invocation
     * @return
     */
    private boolean isUpdateMethod(final MethodInvocation invocation) {
        boolean returnValue;

        returnValue = false;
        if (invocation.resolveMethodBinding().getDeclaringClass().getQualifiedName().equals("org.bson.BasicBSONObject")) {
            if (invocation.getName().toString().equals("put")) {
                if (this.variableName.equals(invocation.getExpression().toString())) {
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
    public List<String> getFields() {
        return this.fields;
    }
}