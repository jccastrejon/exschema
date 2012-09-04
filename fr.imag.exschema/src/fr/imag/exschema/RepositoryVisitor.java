package fr.imag.exschema;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.ITypeBinding;
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
public class RepositoryVisitor extends ASTVisitor {
    List<String> domainClasses;

    public RepositoryVisitor() {
        this.domainClasses = new ArrayList<String>();
    }

    /**
     * Identify classes annotated with a spring-based Repository annotation.
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
     * 
     * @return
     */
    public List<String> getDomainClasses() {
        return this.domainClasses;
    }

    /**
     * 
     * @param type
     * @return
     */
    private String getQualifiedName(ITypeBinding type) {
        return type.getQualifiedName().replace("java.lang.Class<", "").replace(">", "").trim();
    }

    /**
     * 
     * @param className
     * @return
     */
    private boolean isSpringRepository(final String className) {
        String qualifiedName;

        qualifiedName = className;
        if (qualifiedName.contains("<")) {
            qualifiedName = qualifiedName.substring(0, qualifiedName.indexOf('<'));
        }

        return ((qualifiedName.startsWith("org.springframework.")) && (qualifiedName.endsWith("Repository")));
    }

    /**
     * 
     * @param className
     * @return
     */
    private String getSpringInterfaceType(final String className) {
        return className.substring(className.indexOf('<') + 1, className.indexOf(','));
    }
}
