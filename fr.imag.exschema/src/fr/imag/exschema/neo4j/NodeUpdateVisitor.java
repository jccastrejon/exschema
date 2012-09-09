package fr.imag.exschema.neo4j;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;

/**
 * 
 * @author jccastrejon
 * 
 */
public class NodeUpdateVisitor extends ASTVisitor {
    List<MethodInvocation> updateInvocations;

    /**
     * 
     */
    public NodeUpdateVisitor() {
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
        if ("org.neo4j.graphdb.PropertyContainer".equals(invocation.resolveMethodBinding().getDeclaringClass()
                .getQualifiedName())) {
            if (invocation.getName().toString().equals("setProperty")) {
                returnValue = true;
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
}
