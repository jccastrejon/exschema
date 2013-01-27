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
package fr.imag.exschema.mongodb;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.IVariableBinding;
import org.eclipse.jdt.core.dom.MarkerAnnotation;

import fr.imag.exschema.Util;

/**
 * Identifies Spring data's cross-store support for MongoDB.
 * 
 * @author jccastrejon
 * 
 */
public class RelatedDocumentVisitor extends ASTVisitor {

    /**
     * Identified relationshipEntities;
     */
    private Map<String, IVariableBinding[]> entities;

    /**
     * Full constructor.
     */
    public RelatedDocumentVisitor() {
        this.entities = new HashMap<String, IVariableBinding[]>();
    }

    /**
     * Name of the annotations that are expected by this visitor.
     * 
     * @return
     */
    public String[] getExpectedAnnotations() {
        return new String[] { "org.springframework.data.mongodb.crossstore.RelatedDocument" };
    }

    /**
     * Identify classes annotated for Spring-data neo4j.
     */
    @Override
    public boolean visit(final MarkerAnnotation annotation) {
        String entityName;
        ITypeBinding typeBinding;

        if (Util.isExpectedAnnotation(annotation, this.getExpectedAnnotations())) {
            // Save in the style {node {attributes}}
            typeBinding = ((FieldDeclaration) annotation.getParent()).getType().resolveBinding();
            entityName = typeBinding.getName();
            entities.put(entityName, typeBinding.getDeclaredFields());
        }
        return super.visit(annotation);
    }

    /**
     * Get the identified node entities.
     * 
     * @return
     */
    public Map<String, IVariableBinding[]> getEntities() {
        return this.entities;
    }
}
