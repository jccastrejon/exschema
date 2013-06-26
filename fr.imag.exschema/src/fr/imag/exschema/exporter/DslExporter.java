package fr.imag.exschema.exporter;

/**
 * To be implemented by classes that can generate a ExSchema DSL representation.
 * 
 * @author jccastrejon
 * 
 */
public interface DslExporter {
    /**
     * Get the appropriate DSL notation for this object.
     * 
     * @return
     */
    public String getDsl();
}
