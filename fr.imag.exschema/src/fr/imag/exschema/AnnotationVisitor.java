package fr.imag.exschema;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.MemberValuePair;
import org.eclipse.jdt.core.dom.NormalAnnotation;

/**
 * Visitor that identifies domain classes, based on the annotations associated
 * to the Spring data project.
 * 
 * @author jccastrejon
 * 
 */
public class AnnotationVisitor extends ASTVisitor {
    List<String> domainClasses;

    public AnnotationVisitor() {
        this.domainClasses = new ArrayList<String>();
    }

    @Override
    public boolean visit(final NormalAnnotation annotation) {
        String qualifiedName;
        MemberValuePair valuePair;

        qualifiedName = annotation.resolveTypeBinding().getQualifiedName();
        if ((qualifiedName.startsWith("org.springframework.")) && (qualifiedName.endsWith("Repository"))) {
            for (Object value : annotation.values()) {
                valuePair = ((MemberValuePair) value);
                if (valuePair.getName().toString().equals("domainType")) {
                    this.domainClasses.add(valuePair.getValue().resolveTypeBinding().getQualifiedName()
                            .replace("java.lang.Class<", "").replace(">", "").trim());
                }
            }
        }

        return super.visit(annotation);
    }

    /**
     * 
     * @return
     */
    public List<String> getDomainClasses() {
        return this.domainClasses;
    }
}
