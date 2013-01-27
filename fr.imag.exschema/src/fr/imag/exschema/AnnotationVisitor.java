/*
 * Copyright 2013 jccastrejon
 *  
 * This file is part of ExSchema.
 *
 * ExSchema is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * ExSchema is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with ExSchema. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.imag.exschema;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * Identifies entities that have associated annotations.
 * 
 * @author jccastrejon
 * 
 */
public abstract class AnnotationVisitor extends ASTVisitor {

    /**
     * Identified relationshipEntities;
     */
    private Map<String, FieldDeclaration[]> entities;

    /**
     * Full constructor.
     */
    public AnnotationVisitor() {
        this.entities = new HashMap<String, FieldDeclaration[]>();
    }

    /**
     * Name of the annotations that are expected by this visitor.
     * 
     * @return
     */
    protected abstract String[] getExpectedAnnotations();

    /**
     * Identify classes annotated for Spring-data neo4j.
     */
    @Override
    public boolean visit(final MarkerAnnotation annotation) {
        String entityName;
        TypeDeclaration nodeDeclaration;

        if (Util.isExpectedAnnotation(annotation, this.getExpectedAnnotations())) {
            // Save in the style {node {attributes}}
            nodeDeclaration = ((TypeDeclaration) annotation.getParent());
            entityName = nodeDeclaration.resolveBinding().getQualifiedName();
            entities.put(entityName, nodeDeclaration.getFields());
        }
        return super.visit(annotation);
    }

    /**
     * Get the identified node entities.
     * 
     * @return
     */
    public Map<String, FieldDeclaration[]> getEntities() {
        return this.entities;
    }
}
