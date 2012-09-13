package fr.imag.exschema.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.MethodInvocation;

import fr.imag.exschema.Util;

/**
 * Identifies updates to MongoDB collections.
 * 
 * @author jccastrejon
 * 
 */
public class MongoUpdateVisitor extends ASTVisitor {

    /**
     * Update variable name.
     */
    private String variableName;

    /**
     * Update fields.
     */
    private List<String> fields;

    /**
     * Full constructor.
     * 
     * @param variableName
     */
    public MongoUpdateVisitor(final String variableName) {
        this.variableName = variableName;
        this.fields = new ArrayList<String>();
    }

    @Override
    public boolean visit(final MethodInvocation invocation) {
        String fieldName;
        String qualifiedName;
        Block invocationBlock;
        MongoUpdateVisitor innerUpdateVisitor;

        if (this.isUpdateMethod(invocation)) {
            fieldName = invocation.arguments().get(0).toString();
            this.addField(fieldName);

            // Look for inner fields
            qualifiedName = ((Expression) invocation.arguments().get(1)).resolveTypeBinding().getQualifiedName();
            if (this.isBSONObject(qualifiedName)) {
                innerUpdateVisitor = new MongoUpdateVisitor(invocation.arguments().get(1).toString());
                invocationBlock = Util.getInvocationBlock(invocation);

                // TODO: Save more than one level...
                if (invocationBlock != null) {
                    invocationBlock.accept(innerUpdateVisitor);
                    for (String innerField : innerUpdateVisitor.getFields()) {
                        this.addField(fieldName + "." + innerField);
                    }
                }
            }
        }

        return super.visit(invocation);
    }

    /**
     * Add an update field.
     * 
     * @param field
     */
    private void addField(final String field) {
        this.fields.add(field.replace("\"", ""));
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
        if (this.isBSONObject(invocation.resolveMethodBinding().getDeclaringClass().getQualifiedName())) {
            if (invocation.getName().toString().equals("put")) {
                if (this.variableName.equals(invocation.getExpression().toString())) {
                    returnValue = true;
                }
            }
        }

        return returnValue;
    }

    /**
     * Identify whether the specified class name represents a BSON object.
     * 
     * @param declaringClass
     * @return
     */
    private boolean isBSONObject(final String qualifiedName) {
        boolean returnValue;

        returnValue = false;
        if (qualifiedName != null) {
            if ((qualifiedName.startsWith("org.bson.")) || (qualifiedName.startsWith("com.mongodb"))) {
                if (qualifiedName.endsWith("Object")) {
                    returnValue = true;
                }
            }
        }

        return returnValue;
    }

    /**
     * Get the update fields.
     * 
     * @return
     */
    public List<String> getFields() {
        return this.fields;
    }
}