package fr.imag.exschema.jpa;

import fr.imag.exschema.SpringRepositoryVisitor;

/**
 * Visitor that identifies JPA repositories.
 * 
 * @author jccastrejon
 * 
 */
public class SpringJpaRepositoryVisitor extends SpringRepositoryVisitor {

    @Override
    protected boolean isSpringRepository(final String className) {
        boolean returnValue;
        String qualifiedName;

        qualifiedName = this.getQualifiedName(className);
        returnValue = false;
        if (qualifiedName.startsWith("org.springframework.")) {
            if (qualifiedName.endsWith("ActiveRecord")) {
                returnValue = true;
            }
        }

        return returnValue;
    }
}
