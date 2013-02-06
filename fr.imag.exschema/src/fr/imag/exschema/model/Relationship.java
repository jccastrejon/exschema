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

import java.util.ArrayList;
import java.util.List;

import fr.imag.exschema.exporter.GraphvizExporter;
import fr.imag.exschema.exporter.RooExporter;
import fr.imag.exschema.exporter.RooModel;

/**
 * Data model relationship.
 * 
 * @author jccastrejon
 * 
 */
public class Relationship extends Entity implements GraphvizExporter, RooExporter {

    /**
     * Start point of the relationship.
     */
    private Struct endStruct;

    /**
     * End point of the relationship.
     */
    private Struct startStruct;

    /**
     * Default constructor.
     */
    public Relationship() {
        this.attributes = new ArrayList<Attribute>();
    }

    /**
     * Full constructor.
     * 
     * @param endStruct
     * @param startStruct
     * @param attributes
     */
    public Relationship(final Struct endStruct, final Struct startStruct, final List<Attribute> attributes) {
        this.endStruct = endStruct;
        this.startStruct = startStruct;
        this.attributes = attributes;
    }

    @Override
    public String getDotNodes(final String parent) {
        String identifier;
        StringBuilder returnValue;

        returnValue = new StringBuilder("");
        if ((this.getStartStruct() != null) && (this.getEndStruct() != null)) {
            identifier = Long.toString(System.nanoTime());
            returnValue.append("subgraph cluster_relationship_" + identifier + "{\n");
            returnValue.append("label=\"\"\n");
            returnValue.append("color=\"lightgrey\";\n");
            returnValue.append(identifier + " [label=\"Relationship\"]\n");

            for (Attribute attribute : this.attributes) {
                returnValue.append(attribute.getDotNodes(identifier));
            }

            // Associate to start and end structs
            returnValue.append(identifier + " -> " + "struct" + this.startStruct.hashCode()
                    + " [label=\"start\", style=\"dotted\"]\n");
            returnValue.append(identifier + " -> " + "struct" + this.endStruct.hashCode()
                    + " [label=\"end\", style=\"dotted\"]\n");

            returnValue.append("}\n");
        }
        return returnValue.toString();
    }

    @Override
    public String getRooCommands(final RooModel rooModel, final String parent) {
        StringBuilder returnValue;

        returnValue = new StringBuilder("");
        if ((this.getStartStruct() != null) && (this.getEndStruct() != null)) {
            returnValue.append("relationship entity graph --class ~.domain.Relation" + System.currentTimeMillis());
            returnValue.append(" --type " + this.getSimpleName());
            returnValue.append(" --from " + this.getStartStruct().getSimpleName());
            returnValue.append(" --to " + this.getEndStruct().getSimpleName());
            returnValue.append("\n");
        }
        return returnValue.toString();
    }

    /**
     * Associate an attribute to this relation.
     * 
     * @param attribute
     */
    public void addAttribute(final Attribute attribute) {
        this.attributes.add(attribute);
    }

    @Override
    public String toString() {
        StringBuilder returnValue;

        returnValue = new StringBuilder();
        returnValue.append("\n\nAttributes: ");
        for (Attribute attribute : this.attributes) {
            returnValue.append("\n" + attribute);
        }

        returnValue.append("\n\nStart: " + this.startStruct.toString());
        returnValue.append("\n\nEnd: " + this.endStruct.toString());

        return returnValue.toString();
    }

    // Getters-setters

    public Struct getEndStruct() {
        return endStruct;
    }

    public void setEndStruct(Struct endStruct) {
        this.endStruct = endStruct;
    }

    public Struct getStartStruct() {
        return startStruct;
    }

    public void setStartStruct(Struct startStruct) {
        this.startStruct = startStruct;
    }
}
