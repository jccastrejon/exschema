package fr.imag.exschema;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.NormalAnnotation;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * Visitor that identifies domain classes, based on the annotations associated
 * to the Spring data project.
 * 
 * @author jccastrejon
 * 
 */
public abstract class SpringRepositoryVisitor extends ASTVisitor {
    List<String> domainClasses;

    public SpringRepositoryVisitor() {
        this.domainClasses = new ArrayList<String>();
    }

    /**
     * Identify classes annotated with a spring-based Repository annotation.
     * (JPA)
     */
    @Override
    public boolean visit(final MarkerAnnotation annotation) {
        String qualifiedName;
        TypeDeclaration typeDeclaration;

        qualifiedName = annotation.resolveTypeBinding().getQualifiedName();
        if (this.isSpringRepository(qualifiedName)) {
            if (TypeDeclaration.class.isAssignableFrom(annotation.getParent().getClass())) {
                typeDeclaration = (TypeDeclaration) annotation.getParent();
                this.domainClasses.add(this.getQualifiedName(typeDeclaration.resolveBinding()));
            }
        }

        return super.visit(annotation);
    }

    /**
     * Identify classes annotated with a spring-based Repository annotation.
     * (MongoDB)
     */
    @Override
    public boolean visit(final NormalAnnotation annotation) {
        String qualifiedName;
        MemberValuePair valuePair;

        qualifiedName = annotation.resolveTypeBinding().getQualifiedName();
        if (this.isSpringRepository(qualifiedName)) {
            for (Object value : annotation.values()) {
                valuePair = ((MemberValuePair) value);
                if (valuePair.getName().toString().equals("domainType")) {
                    this.domainClasses.add(this.getQualifiedName(valuePair.getValue().resolveTypeBinding()));
                }
            }
        }

        return super.visit(annotation);
    }

    /**
     * Identify interfaces that extend a spring-based Repository annotation.
     */
    @Override
    public boolean visit(final TypeDeclaration typeDeclaration) {
        String qualifiedName;

        if (typeDeclaration.superInterfaceTypes() != null) {
            for (Object superInterface : typeDeclaration.superInterfaceTypes()) {
                qualifiedName = ((Type) superInterface).resolveBinding().getQualifiedName();
                if (this.isSpringRepository(qualifiedName)) {
                    this.domainClasses.add(this.getSpringInterfaceType(qualifiedName));
                }
            }
        }

        return super.visit(typeDeclaration);
    }

    /**
     * Return domain classes.
     * 
     * @return
     */
    public List<String> getDomainClasses() {
        return this.domainClasses;
    }
    
    /**
     * Determine if the specified class name represents a Spring-based
     * repository.
     * 
     * @param className
     * @return
     */
    protected abstract boolean isSpringRepository(final String className);
    
    /**
     * 
     * @param className
     * @return
     */
    protected String getQualifiedName(final String className) {
        String returnValue;

        returnValue = className;
        if (returnValue.contains("<")) {
            returnValue = returnValue.substring(0, returnValue.indexOf('<'));
        }
        
        return returnValue;
    }

    /**
     * Get the qualified name associated to the specified type.
     * 
     * @param type
     * @return
     */
    private String getQualifiedName(ITypeBinding type) {
        return type.getQualifiedName().replace("java.lang.Class<", "").replace(">", "").trim();
    }

    /**
     * Extract Spring's interface type from the specified class name.
     * 
     * @param className
     * @return
     */
    private String getSpringInterfaceType(final String className) {
        return className.substring(className.indexOf('<') + 1, className.indexOf(','));
    }
}
