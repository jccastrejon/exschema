package fr.imag.exschema.model;

import java.util.ArrayList;
import java.util.List;

import fr.imag.exschema.GraphvizExporter;

/**
 * 
 * @author jccastrejon
 * 
 */
public class Struct implements GraphvizExporter {
    /**
     * 
     */
    private List<Set> sets;

    /**
     * 
     */
    private List<Struct> structs;

    /**
     * 
     */
    private List<Attribute> attributes;

    /**
     * 
     */
    private List<Relationship> relationships;

    /**
     * 
     */
    public Struct() {
        this.sets = new ArrayList<Set>();
        this.structs = new ArrayList<Struct>();
        this.attributes = new ArrayList<Attribute>();
        this.relationships = new ArrayList<Relationship>();
    }

    /**
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
     * 
     * @param set
     */
    public void addSet(final Set set) {
        this.sets.add(set);
    }

    /**
     * 
     * @param struct
     */
    public void addStruct(final Struct struct) {
        this.structs.add(struct);
    }

    /**
     * 
     * @param attribute
     */
    public void addAttribute(final Attribute attribute) {
        this.attributes.add(attribute);
    }

    /**
     * 
     * @param relationship
     */
    public void addRelationship(final Relationship relationship) {
        this.relationships.add(relationship);
    }

    public String getDotNodes(final String parent) {
        String identifier;
        StringBuilder returnValue;

        identifier = Long.toString(System.nanoTime());
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

    public List<Relationship> getRelationships() {
        return relationships;
    }

    public void setRelationships(List<Relationship> relationships) {
        this.relationships = relationships;
    }
}
