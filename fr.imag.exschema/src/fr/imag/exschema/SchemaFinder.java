package fr.imag.exschema;

import java.util.List;

import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;

import fr.imag.exschema.model.Set;

/**
 * To be implemented by classes that can discover schemas from the source code
 * of existing applications.
 * 
 * @author jccastrejon
 * 
 */
public interface SchemaFinder {
    /**
     * Discover schemas in the specified Java project.
     * 
     * @param project
     * @return
     * @throws JavaModelException
     */
    public List<Set> discoverSchemas(final IJavaProject project) throws JavaModelException;
}