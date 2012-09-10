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
public class RelationshipCreateVisitor extends ASTVisitor {
    List<MethodInvocation> createInvocations;

    /**
     * 
     */
    public RelationshipCreateVisitor() {
        this.createInvocations = new ArrayList<MethodInvocation>();
    }

    @Override
    public boolean visit(final MethodInvocation invocation) {
        if (this.isCreateRelationshipMethod(invocation)) {
            this.createInvocations.add(invocation);
        }

        return super.visit(invocation);
    }

    /**
     * 
     * @param invocation
     * @return
     */
    private boolean isCreateRelationshipMethod(final MethodInvocation invocation) {
        boolean returnValue;

        returnValue = false;
        if ("org.neo4j.graphdb.Node".equals(invocation.resolveMethodBinding().getDeclaringClass().getQualifiedName())) {
            if (invocation.getName().toString().equals("createRelationshipTo")) {
                returnValue = true;
            }
        }

        return returnValue;
    }

    /**
     * 
     * @return
     */
    public List<MethodInvocation> getCreateInvocations() {
        return this.createInvocations;
    }
}
