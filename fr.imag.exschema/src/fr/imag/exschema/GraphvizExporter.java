package fr.imag.exschema;

/**
 * To be implemented by classes that can generate Graphviz's dot notation.
 * 
 * @author jccastrejon
 * 
 */
public interface GraphvizExporter {
    /**
     * Get the appropriate Graphviz notation for this object.
     * 
     * @param parent
     * @return
     */
    public String getDotNodes(final String parent);
}
