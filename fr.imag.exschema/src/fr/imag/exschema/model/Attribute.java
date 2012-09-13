package fr.imag.exschema.model;

import fr.imag.exschema.GraphvizExporter;

/**
 * Data model attribute.
 * 
 * @author jccastrejon
 * 
 */
public class Attribute implements GraphvizExporter {

    /**
     * Attribute's name.
     */
    private String name;

    /**
     * Attribute's value.
     */
    private String value;

    /**
     * Full constructor.
     * 
     * @param name
     */
    public Attribute(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String getDotNodes(final String parent) {
        String identifier;
        StringBuilder returnValue;

        identifier = Long.toString(System.nanoTime());
        returnValue = new StringBuilder(identifier + " [label=\"Attribute \\n " + name + " : " + value + "\"]\n");

        if (parent != null) {
            returnValue.append(parent + " -> " + identifier + "\n");
        }

        return returnValue.toString();
    }

    // Getters-setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
