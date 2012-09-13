package fr.imag.exschema;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

/**
 * Generic visitor for classes that need to identify declarations of variables
 * with a given class name.
 * 
 * @author jccastrejon
 * 
 */
public abstract class DeclareVisitor extends ASTVisitor {

    /**
     * Declaration's variable name.
     */
    private String variableName;

    /**
     * Matching declarations.
     */
    private List<VariableDeclarationFragment> variableDeclarations;

    /**
     * Look for all declarations.
     */
    public DeclareVisitor() {
        this.variableDeclarations = new ArrayList<VariableDeclarationFragment>();
    }

    /**
     * When we're interested in finding the declaration of a particular
     * variable.
     * 
     * @param variableName
     */
    public DeclareVisitor(final String variableName) {
        this.variableName = variableName;
        this.variableDeclarations = new ArrayList<VariableDeclarationFragment>();
    }

    @Override
    public boolean visit(final VariableDeclarationFragment variableDeclaration) {
        if (this.isDeclareMethod(variableDeclaration)) {
            this.variableDeclarations.add(variableDeclaration);
        }
        return super.visit(variableDeclaration);
    }

    /**
     * Determine if the specified declaration fragment matches with the ones
     * we're looking for.
     * 
     * @param variableDeclaration
     * @return
     */
    protected boolean isDeclareMethod(final VariableDeclarationFragment variableDeclaration) {
        boolean returnValue;
        ASTNode parentNode;
        String qualifiedName;

        returnValue = false;
        qualifiedName = null;
        parentNode = variableDeclaration.getParent();
        if (VariableDeclarationStatement.class.isAssignableFrom(parentNode.getClass())) {
            qualifiedName = ((VariableDeclarationStatement) parentNode).getType().resolveBinding().getQualifiedName();
        } else if (FieldDeclaration.class.isAssignableFrom(parentNode.getClass())) {
            qualifiedName = ((FieldDeclaration) parentNode).getType().resolveBinding().getQualifiedName();
        }

        // If a variable name was provided, the declarations that we're looking
        // for should match that name
        if (this.getExpectedQualifiedName().equals(qualifiedName)) {
            if (this.variableName != null) {
                if (this.variableName.equals(variableDeclaration.getName().toString())) {
                    returnValue = true;
                }
            } else {
                returnValue = true;
            }
        }

        return returnValue;
    }

    /**
     * 
     * @return
     */
    public List<VariableDeclarationFragment> getVariableDeclarations() {
        return this.variableDeclarations;
    }

    /**
     * 
     * @param variableName
     */
    public void setVariableName(final String variableName) {
        this.variableName = variableName;
    }

    /**
     * The class name of the declarations we're looking for.
     * 
     * @param qualifiedName
     * @return
     */
    protected abstract String getExpectedQualifiedName();
}
