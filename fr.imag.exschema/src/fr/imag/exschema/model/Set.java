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
 * Data model set.
 * 
 * @author jccastrejon
 * 
 */
public class Set implements GraphvizExporter, RooExporter {

    /**
     * Inner sets.
     */
    private List<Set> sets;

    /**
     * Inner structs.
     */
    private List<Struct> structs;

    /**
     * Attributes associated to the set.
     */
    private List<Attribute> attributes;

    /**
     * Default constructor.
     */
    public Set() {
        this.sets = new ArrayList<Set>();
        this.structs = new ArrayList<Struct>();
        this.attributes = new ArrayList<Attribute>();
    }

    /**
     * Full constructor.
     * 
     * @param structs
     */
    public Set(final List<Set> sets, final List<Struct> structs, final List<Attribute> attributes) {
        this.sets = sets;
        this.structs = structs;
        this.attributes = attributes;
    }

    /**
     * Associate an inner set to this set.
     * 
     * @param set
     */
    public void addSet(final Set set) {
        this.sets.add(set);
    }

    /**
     * Associate an inner struct to this set.
     * 
     * @param struct
     */
    public void addStruct(final Struct struct) {
        this.structs.add(struct);
    }

    /**
     * Associate an attribute to this set.
     * 
     * @param attribute
     */
    public void addAttribute(final Attribute attribute) {
        this.attributes.add(attribute);
    }

    @Override
    public String getDotNodes(final String parent) {
        String identifier;
        StringBuilder returnValue;

        identifier = Long.toString(System.nanoTime());
        returnValue = new StringBuilder(identifier + " [label=\"Set\"]\n");

        if (parent != null) {
            returnValue.append(parent + " -> " + identifier + "\n");
        }

        for (Attribute attribute : this.attributes) {
            returnValue.append(attribute.getDotNodes(identifier));
        }

        for (Set set : this.sets) {
            returnValue.append(set.getDotNodes(identifier));
        }

        for (Struct struct : this.structs) {
            returnValue.append(struct.getDotNodes(identifier));
        }

        return returnValue.toString();
    }

    @Override
    public String getRooCommands(String parent, final RooModel rooModel) {
        String entityName;
        String projectName;
        RooModel projectRooModel;
        StringBuilder returnValue;

        returnValue = new StringBuilder();
        // Start of the schema
        if (parent == null) {
            projectName = "project" + System.currentTimeMillis();
            returnValue.append("project --topLevelPackage fr.imag.exschema." + projectName + "\n");
            // Project setup depending on the data model
            for (Attribute attribute : this.getAttributes()) {
                // The implementation attribute specifies the Roo model that
                // this schema relies upon
                if ("implementation".equals(attribute.getName())) {
                    projectRooModel = RooModel.valueOf(attribute.getValue().toUpperCase());
                    // TODO: Identify Spring MongoDB and relational repositories
                    // (instead of generic Spring repository)
                    switch (projectRooModel) {
                    case NEO4J:
                        returnValue.append("graph setup --provider Neo4j --databaseLocation graphdb.location" + "\n");
                        break;
                    case MONGODB:
                        returnValue.append("mongo setup --databaseName database" + projectName + "\n");
                        break;
                    case RELATIONAL:
                    default:
                        returnValue.append("jpa setup --provider HIBERNATE --database HYPERSONIC_IN_MEMORY" + "\n");
                        break;
                    }
                    break;
                }
            }
        }

        // Entity
        else {
            entityName = null;
            for (Attribute attribute : this.getAttributes()) {
                if ("name".equals(attribute.getName())) {
                    entityName = attribute.getValue();
                    if (entityName.contains(".")) {
                        entityName = entityName.substring(entityName.indexOf('.') + 1);
                    }
                }
            }

            if (entityName != null) {
                switch (rooModel) {
                case NEO4J:
                    returnValue.append("entity graph --class ~.domain." + entityName + "\n");
                    returnValue.append("repository graph --interface ~.repository." + entityName
                            + "Repository --entity ~.domain." + entityName + "\n");
                    break;
                case MONGODB:
                    returnValue.append("entity mongo --class ~.domain." + entityName + "\n");
                    returnValue.append("repository mongo --interface ~.repository." + entityName
                            + "Repository --entity ~.domain." + entityName + "\n");
                    break;
                case RELATIONAL:
                default:
                    returnValue.append("entity jpa --class ~.domain." + entityName + "\n");
                    break;
                }
            }
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

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
