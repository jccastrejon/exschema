package fr.imag.exschema.model;

import java.util.ArrayList;
import java.util.List;

import fr.imag.exschema.GraphvizExporter;

/**
 * Data model struct.
 * 
 * @author jccastrejon
 * 
 */
public class Struct implements GraphvizExporter {

    /**
     * Inner sets.
     */
    private List<Set> sets;

    /**
     * Inner structs.
     */
    private List<Struct> structs;

    /**
     * Attributes associated to the struct.
     */
    private List<Attribute> attributes;

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
