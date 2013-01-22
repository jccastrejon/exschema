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
package fr.imag.exschema.neo4j;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MarkerAnnotation;
import org.eclipse.jdt.core.dom.TypeDeclaration;

/**
 * Identifies Spring's RelationshipEntities.
 * 
 * @author jccastrejon
 * 
 */
public class RelationshipEntityVisitor extends ASTVisitor {
    
    /**
     * Identified relationshipEntities;
     */
    private Map<String, FieldDeclaration[]> relationshipEntities;

    /**
     * Full constructor.
     */
    public RelationshipEntityVisitor() {
        this.relationshipEntities = new HashMap<String, FieldDeclaration[]>();
    }

    /**
     * Identify classes annotated for Spring-data neo4j.
     */
    @Override
    public boolean visit(final MarkerAnnotation annotation) {
        String entityName;
        TypeDeclaration nodeDeclaration;

        if (this.isRelationshipEntityAnnotation(annotation)) {
            // Save in the style {node {attributes}}
            nodeDeclaration = ((TypeDeclaration) annotation.getParent());
            entityName = nodeDeclaration.resolveBinding().getQualifiedName();

            relationshipEntities.put(entityName, nodeDeclaration.getFields());
        }
        return super.visit(annotation);
    }

    /**
     * Verify if this class has been marked as a Neo4j relationshipEntity.
     * 
     * @param annotation
     * @return
     */
    private boolean isRelationshipEntityAnnotation(final MarkerAnnotation annotation) {
        boolean returnValue;
        String qualifiedName;

        returnValue = false;
        qualifiedName = annotation.resolveTypeBinding().getQualifiedName();
        if (qualifiedName != null) {
            returnValue = (qualifiedName.equals("org.springframework.data.graph.annotation.RelationshipEntity") || qualifiedName
                    .equals("org.springframework.data.neo4j.annotation.RelationshipEntity"));
        }

        return returnValue;
    }

    /**
     * Get the identified node entities.
     * 
     * @return
     */
    public Map<String, FieldDeclaration[]> getRelationshipEntities() {
        return this.relationshipEntities;
    }
}
