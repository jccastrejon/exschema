package fr.imag.exschema.mongodb;

import fr.imag.exschema.SpringRepositoryVisitor;

/**
 * Visitor that identifies Spring data MongoDB repositories.
 * 
 * @author jccastrejon
 * 
 */
public class SpringDocumentRepositoryVisitor extends SpringRepositoryVisitor {

    @Override
    protected boolean isSpringRepository(final String className) {
        boolean returnValue;
        String qualifiedName;

        // Consider Spring data repositories, except for the Neo4J repository,
        // that needs special handling
        returnValue = false;
        qualifiedName = this.getQualifiedName(className);
        if (qualifiedName.startsWith("org.springframework.")) {
            if ((qualifiedName.endsWith("Repository")) && (!qualifiedName.contains("neo4j"))) {
                returnValue = true;
            }
        }

        return returnValue;
    }
}
