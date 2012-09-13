package fr.imag.exschema.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Data model relationship.
 * 
 * @author jccastrejon
 * 
 */
public class Relationship {

    /**
     * Start point of the relationship.
     */
    private Struct endStruct;

    /**
     * End point of the relationship.
     */
    private Struct startStruct;

    /**
     * Attributes associated to the relationship.
     */
    private List<Attribute> attributes;

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

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
