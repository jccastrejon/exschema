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
package fr.imag.exschema.jpa;

import fr.imag.exschema.exporter.RooModel;
import fr.imag.exschema.visitor.SpringRepositoryVisitor;

/**
 * 
 * @author jccastrejon
 * 
 */
public class JpaRepositoryVisitor extends SpringRepositoryVisitor {
    @Override
    protected boolean isSpringRepository(String className) {
        boolean returnValue;
        String qualifiedName;

        qualifiedName = this.getQualifiedName(className);
        returnValue = false;
        if (qualifiedName.equals("javax.persistence.Entity")) {
            returnValue = true;
        }

        return returnValue;
    }

    @Override
    public String getImplementation() {
        return RooModel.RELATIONAL.toString();
    }
}