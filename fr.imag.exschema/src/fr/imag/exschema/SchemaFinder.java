package fr.imag.exschema;

import java.util.List;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;

import fr.imag.exschema.model.Set;

/**
 * 
 * @author jccastrejon
 * 
 */
public interface SchemaFinder {
    /**
     * 
     * @param project
     * @return
     * @throws JavaModelException
     */
    public List<Set> discoverSchemas(final IJavaProject project) throws JavaModelException;
}