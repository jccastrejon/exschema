package fr.imag.exschema.neo4j;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * 
 * @author jccastrejon
 * 
 */
public class NodeEntityVisitor extends ASTVisitor {
    private Map<String, FieldDeclaration[]> nodeEntities;

    public NodeEntityVisitor() {
        this.nodeEntities = new HashMap<String, FieldDeclaration[]>();
    }

    /**
     * Identify classes annotated for Spring-data neo4j.
     */
    @Override
    public boolean visit(final MarkerAnnotation annotation) {
        String entityName;
        TypeDeclaration nodeDeclaration;

        if (this.isNodeEntityAnnotation(annotation)) {
            // Save in the style {node {attributes}}
            nodeDeclaration = ((TypeDeclaration) annotation.getParent());
            entityName = nodeDeclaration.resolveBinding().getQualifiedName();

            nodeEntities.put(entityName, nodeDeclaration.getFields());
        }
        return super.visit(annotation);
    }

    private boolean isNodeEntityAnnotation(final MarkerAnnotation annotation) {
        return annotation.resolveTypeBinding().getQualifiedName()
                .equals("org.springframework.data.neo4j.annotation.NodeEntity");
    }
    
    /**
     * 
     * @return
     */
    public Map<String, FieldDeclaration[]> getNodeEntities() {
        return this.nodeEntities;
    }
}