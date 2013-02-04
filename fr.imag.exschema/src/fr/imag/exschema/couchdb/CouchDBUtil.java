/*
 * Copyright 2013 jccastrejon
 *  
 * This file is part of ExSchema.
 *
 * ExSchema is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * any later version.
 *
 * ExSchema is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with ExSchema. If not, see <http://www.gnu.org/licenses/>.
 */
package fr.imag.exschema.couchdb;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.dom.MethodInvocation;

import fr.imag.exschema.SchemaFinder;
import fr.imag.exschema.Util;
import fr.imag.exschema.exporter.RooModel;
import fr.imag.exschema.model.Attribute;
import fr.imag.exschema.model.Set;
import fr.imag.exschema.model.Struct;

/**
 * CouchDB utility methods.
 * 
 * @author jccastrejon
 * 
 */
public class CouchDBUtil implements SchemaFinder {

    /**
     * Class logger.
     */
    private static Logger logger = Logger.getLogger(CouchDBUtil.class.getName());

    @Override
    public List<Set> discoverSchemas(final IJavaProject project) throws CoreException {
        String field;
        Set currentFields;
        Struct currentField;
        Set currentDatabase;
        String documentName;
        List<Set> returnValue;
        Set currentCollection;
        Struct currentDocument;
        DocumentPutVisitor documentPutVisitor;
        DocumentSaveVisitor documentSaveVisitor;

        // Identify when documents are saved
        returnValue = new ArrayList<Set>();
        documentSaveVisitor = new DocumentSaveVisitor();
        Util.analyzeJavaProject(project, documentSaveVisitor);

        // Assume only one database
        // TODO: Support more than one database, by recognizing initializations
        currentDatabase = new Set();
        currentDatabase.addAttribute(new Attribute("implementation", RooModel.COUCHDB.toString()));
        returnValue.add(currentDatabase);

        // Assume only one collection
        // TODO: Support more than one collection, by recognizing
        // initializations
        currentCollection = new Set();
        currentDatabase.addSet(currentCollection);
        currentCollection.addAttribute(new Attribute("name", "collection"));
        CouchDBUtil.logger.log(Util.LOGGING_LEVEL, "--Collection: " + "collection");

        // Get the attributes from the identified documents
        CouchDBUtil.logger.log(Util.LOGGING_LEVEL, "\nCouchDB documents (based on puts): ");
        for (MethodInvocation saveInvocation : documentSaveVisitor.getUpdateInvocations()) {
            // TODO: Consider operations that don't rely on variables
            // Only work with variables
            documentName = saveInvocation.arguments().get(0).toString();
            if (Util.isVariableName(documentName)) {
                currentDocument = new Struct();
                currentCollection.addStruct(currentDocument);
                currentDocument.addAttribute(new Attribute("name", documentName));
                CouchDBUtil.logger.log(Util.LOGGING_LEVEL, "----Document: " + documentName);

                // Attributes added through the Document.put() method
                documentPutVisitor = new DocumentPutVisitor();
                documentPutVisitor.setVariableName(documentName);
                saveInvocation.getRoot().accept(documentPutVisitor);

                if (!documentPutVisitor.getUpdateInvocations().isEmpty()) {
                    currentFields = new Set();
                    currentDocument.addSet(currentFields);

                    for (MethodInvocation putInvocation : documentPutVisitor.getUpdateInvocations()) {
                        field = putInvocation.arguments().get(0).toString().replace('"', ' ').trim();
                        currentField = new Struct();
                        currentFields.addStruct(currentField);
                        currentField.addAttribute(new Attribute("name", field));
                        CouchDBUtil.logger.log(Util.LOGGING_LEVEL, "------Field: " + field);
                    }
                }
            }
        }

        return returnValue;
    }
}
