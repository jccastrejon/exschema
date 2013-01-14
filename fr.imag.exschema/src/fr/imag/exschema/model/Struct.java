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
 * Data model struct.
 * 
 * @author jccastrejon
 * 
 */
public class Struct extends Entity implements GraphvizExporter, RooExporter {

    /**
     * Inner sets.
     */
    private List<Set> sets;

    /**
     * Inner structs.
     */
    private List<Struct> structs;

    /**
     * Relationships to other structs.
     */
    private List<Relationship> relationships;

    /**
     * Default constructor.
     */
    public Struct() {
        this.sets = new ArrayList<Set>();
        this.structs = new ArrayList<Struct>();
        this.attributes = new ArrayList<Attribute>();
        this.relationships = new ArrayList<Relationship>();
    }

    /**
     * Full constructor.
     * 
     * @param structs
     * @param attributes
     * @param relationships
     */
    public Struct(final List<Set> sets, final List<Struct> structs, final List<Attribute> attributes,
            final List<Relationship> relationships) {
        this.sets = sets;
        this.structs = structs;
        this.attributes = attributes;
        this.relationships = relationships;
    }

    /**
     * Associate an inner set to this struct.
     * 
     * @param set
     */
    public void addSet(final Set set) {
        this.sets.add(set);
    }

    /**
     * Associate an inner struct to this struct.
     * 
     * @param struct
     */
    public void addStruct(final Struct struct) {
        this.structs.add(struct);
    }

    /**
     * Associate an attribute to this struct.
     * 
     * @param attribute
     */
    public void addAttribute(final Attribute attribute) {
        this.attributes.add(attribute);
    }

    /**
     * Add a relationship to this struct.
     * 
     * @param relationship
     */
    public void addRelationship(final Relationship relationship) {
        this.relationships.add(relationship);
    }

    @Override
    public String getDotNodes(final String parent) {
        String identifier;
        StringBuilder returnValue;

        identifier = "struct" + this.hashCode();
        returnValue = new StringBuilder(identifier + " [shape=\"box\", label=\"Struct\"]\n");

        if (parent != null) {
            returnValue.append(parent + " -> " + identifier + "\n");
        }

        for (Attribute attribute : this.attributes) {
            returnValue.append(attribute.getDotNodes(identifier));
        }

        for (Struct struct : this.structs) {
            returnValue.append(struct.getDotNodes(identifier));
        }

        for (Set set : this.sets) {
            returnValue.append(set.getDotNodes(identifier));
        }

        for (Relationship relationship : this.relationships) {
            returnValue.append(relationship.getDotNodes(identifier));
        }

        return returnValue.toString();
    }

    @Override
    public String getRooCommands(final RooModel rooModel) {
        StringBuilder returnValue;

        returnValue = new StringBuilder();
        // TODO: Support for complex attributes (require nested structs)
        switch (rooModel) {
        case NEO4J:
            // Structs with the single 'name' attribute are entities
            // TODO: Change from structs to sets?
            if ((this.attributes.size() == 1) && (this.attributes.get(0).getName().equals("name"))) {
                returnValue.append("graph setup --provider Neo4j --databaseLocation graphdb.location" + "\n");

                for (Relationship relationship : this.relationships) {
                    returnValue.append(relationship.getRooCommands(rooModel));
                }
            } else {
                for (Attribute attribute : this.getAttributes()) {
                    returnValue.append(attribute.getRooCommands(rooModel));
                }
            }
            break;
        case MONGODB:
            for (Attribute attribute : this.getAttributes()) {
                returnValue.append(attribute.getRooCommands(rooModel));
            }
            break;
        case RELATIONAL:
        default:
            for (Attribute attribute : this.getAttributes()) {
                returnValue.append(attribute.getRooCommands(rooModel));
            }
            break;
        }

        return returnValue.toString();
    }

    // Getters-setters

    public List<Set> getSets() {
        return sets;
    }

    public void setSets(List<Set> sets) {
        this.sets = sets;
    }

    public List<Struct> getStructs() {
        return structs;
    }

    public void setStructs(List<Struct> structs) {
        this.structs = structs;
    }

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }
}
