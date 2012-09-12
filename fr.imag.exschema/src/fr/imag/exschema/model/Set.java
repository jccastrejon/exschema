package fr.imag.exschema.model;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author jccastrejon
 * 
 */
public class Set {
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
        this.structs = new ArrayList<Struct>();
        this.attributes = new ArrayList<Attribute>();
    }

    /**
     * 
     * @param structs
     */
    public Set(final List<Struct> structs, final List<Attribute> attributes) {
        this.structs = structs;
        this.attributes = attributes;
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

    @Override
    public String toString() {
        StringBuilder returnValue;

        returnValue = new StringBuilder();
        returnValue.append("\n\nAttributes: ");
        for (Attribute attribute : this.attributes) {
            returnValue.append("\n" + attribute);
        }

        returnValue.append("\n\nStructs:");
        for (Struct struct : this.structs) {
            returnValue.append("\n" + struct);
        }

        return returnValue.toString();
    }

    // Getters-setters

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
