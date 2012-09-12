package fr.imag.exschema.model;

/**
 * 
 * @author jccastrejon
 * 
 */
public class Attribute {
    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String value;

    /**
     * 
     * @param name
     */
    public Attribute(final String name, final String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name + ":" + value;
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
