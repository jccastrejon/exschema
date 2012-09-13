package fr.imag.exschema.mongodb;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MethodInvocation;

/**
 * Identifies MongoDB collections.
 * 
 * @author jccastrejon
 * 
 */
public class MongoCollectionVisitor extends ASTVisitor {

    /**
     * Collection's variable name.
     */
    private String variableName;

    /**
     * Collection name.
     */
    private String collectionName;

    /**
     * Full constructor.
     * 
     * @param variableName
     */
    public MongoCollectionVisitor(final String variableName) {
        this.variableName = variableName;
    }

    @Override
    public boolean visit(final MethodInvocation invocation) {
        if (this.isGetCollection(invocation)) {
            this.collectionName = invocation.arguments().get(0).toString().replace("\"", "");
        }

        return super.visit(invocation);
    }

    /**
     * Decide whether or not the given invocation resolves to a MongoDB
     * collection.
     * 
     * @param invocation
     * @return
     */
    private boolean isGetCollection(final MethodInvocation invocation) {
        boolean returnValue;
        String currentVariable;
        String invocationString;

        returnValue = false;
        if (invocation.resolveMethodBinding().getDeclaringClass().getQualifiedName().equals("com.mongodb.DB")) {
            if (invocation.getName().toString().equals("getCollection")) {
                invocationString = invocation.getParent().toString();
                currentVariable = invocationString.substring(0, invocationString.indexOf('='));
                if (this.variableName.equals(currentVariable)) {
                    returnValue = true;
                }
            }
        }

        return returnValue;
    }

    /**
     * Get collection's name.
     * 
     * @return
     */
    public String getCollectionName() {
        return this.collectionName;
    }
}