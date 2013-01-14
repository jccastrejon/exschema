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
package fr.imag.exschema.model;

import java.util.List;

/**
 * 
 * @author jccastrejon
 *
 */
public abstract class Entity {
    /**
     * Attributes associated to the relationship.
     */
    protected List<Attribute> attributes;

    /**
     * 
     * @return
     */
    public List<Attribute> getAttributes() {
        return this.attributes;
    }

    /**
     * 
     * @param attributes
     */
    public void setAttributes(final List<Attribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * 
     * @return
     */
    public String getSimpleName() {
        String returnValue;

        returnValue = null;
        if (this.getAttributes() != null) {
            for (Attribute attribute : this.getAttributes()) {
                if ("name".equals(attribute.getName())) {
                    returnValue = attribute.getValue();
                    if (returnValue.contains(".")) {
                        returnValue = returnValue.substring(returnValue.indexOf('.') + 1);
                    }
                }
            }
        }

        return returnValue;
    }
}
