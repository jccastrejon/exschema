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

import fr.imag.exschema.exporter.DslExporter;
import fr.imag.exschema.exporter.GraphvizExporter;
import fr.imag.exschema.exporter.RooExporter;
import fr.imag.exschema.exporter.RooModel;

/**
 * Data model set.
 * 
 * @author jccastrejon
 * 
 */
public class Set extends Entity implements GraphvizExporter, RooExporter, DslExporter {

    /**
     * Inner sets.
     */
    private List<Set> sets;

    /**
     * Inner structs.
     */
    private List<Struct> structs;

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
    public String getRooCommands(final RooModel rooModel, final String parent) {
        String projectName;
        RooModel startingRooModel;
        StringBuilder returnValue;

        startingRooModel = null;
        returnValue = new StringBuilder();

        // The implementation attribute specifies the Roo model that
        // this schema relies upon
        for (Attribute attribute : this.getAttributes()) {
            if ("implementation".equals(attribute.getName())) {
                startingRooModel = RooModel.valueOf(attribute.getValue().toUpperCase());
            }
        }

        // Start of the schema
        if (startingRooModel != null) {
            projectName = "project" + System.currentTimeMillis();
            returnValue.append("project --topLevelPackage fr.imag.exschema." + projectName + "\n");

            switch (startingRooModel) {
            case NEO4J:
                returnValue.append("graph setup --provider Neo4j --databaseLocation graphdb.location" + "\n");
                // TODO: Change from structs to sets?
                for (Struct struct : this.getStructs()) {
                    returnValue.append(struct.getRooCommands(startingRooModel, this.getSimpleName()));
                }
                break;
            case MONGODB:
                returnValue.append("mongo setup --databaseName database" + projectName + "\n");
                for (Set set : this.getSets()) {
                    returnValue.append(set.getRooCommands(startingRooModel, this.getSimpleName()));
                }
                break;
            case RELATIONAL:
            default:
                returnValue.append("jpa setup --provider HIBERNATE --database HYPERSONIC_IN_MEMORY" + "\n");
                for (Set set : this.getSets()) {
                    returnValue.append(set.getRooCommands(startingRooModel, this.getSimpleName()));
                }
                break;
            }
        }

        // Entity
        else {
            if (this.getSimpleName() != null) {
                switch (rooModel) {
                case NEO4J:
                    returnValue.append("entity graph --class ~.domain." + this.getSimpleName() + "\n");
                    returnValue.append("repository graph --interface ~.repository." + this.getSimpleName()
                            + "Repository --entity ~.domain." + this.getSimpleName() + "\n");
                    break;
                case MONGODB:
                    returnValue.append("entity mongo --class ~.domain." + this.getSimpleName() + "\n");
                    returnValue.append("repository mongo --interface ~.repository." + this.getSimpleName()
                            + "Repository --entity ~.domain." + this.getSimpleName() + "\n");
                    break;
                case RELATIONAL:
                default:
                    returnValue.append("entity jpa --class ~.domain." + this.getSimpleName() + "\n");
                    break;
                }

                for (Struct struct : this.getStructs()) {
                    returnValue.append(struct.getRooCommands(rooModel, this.getSimpleName()));
                }
            }
        }

        return returnValue.toString();
    }

    @Override
    public String getDsl() {
        StringBuilder returnValue;

        returnValue = new StringBuilder("\nSet ");

        returnValue.append(System.currentTimeMillis());
        returnValue.append("[ ");
        for (Attribute attribute : this.attributes) {
            returnValue.append(attribute.getDsl());
        }
        returnValue.append(" ]");

        returnValue.append("\n{");
        if (!this.sets.isEmpty()) {
            for (Set set : this.sets) {
                returnValue.append(set.getDsl());
            }
        }

        if (!this.structs.isEmpty()) {
            for (Struct struct : this.structs) {
                returnValue.append(struct.getDsl());
            }
        }
        returnValue.append("\n}");

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
}
