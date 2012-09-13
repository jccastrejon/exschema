package fr.imag.exschema.model;

import java.util.ArrayList;
import java.util.List;

import fr.imag.exschema.GraphvizExporter;

/**
 * 
 * @author jccastrejon
 * 
 */
public class Set implements GraphvizExporter {

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
    public Set() {
        this.sets = new ArrayList<Set>();
        this.structs = new ArrayList<Struct>();
        this.attributes = new ArrayList<Attribute>();
    }

    /**
     * 
     * @param structs
     */
    public Set(final List<Set> sets, final List<Struct> structs, final List<Attribute> attributes) {
        this.sets = sets;
        this.structs = structs;
        this.attributes = attributes;
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
