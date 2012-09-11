package fr.imag.exschema;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;

/**
 * 
 * @author jccastrejon
 * 
 */
public abstract class DeclareVisitor extends ASTVisitor {
    /**
     * 
     */
    private String variableName;

    /**
     * 
     */
    private List<VariableDeclarationFragment> variableDeclarations;

    /**
     * All declarations.
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
     * 
     * @param qualifiedName
     * @return
     */
    protected abstract String getExpectedQualifiedName();
}
