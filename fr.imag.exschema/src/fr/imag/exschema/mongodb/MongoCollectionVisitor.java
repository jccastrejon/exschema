/*
 * Copyright 2012 jccastrejon
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