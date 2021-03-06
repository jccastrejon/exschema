/*
 * Copyright 2012 jccastrejon
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
package fr.imag.exschema;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Annotation;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodInvocation;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;

import fr.imag.exschema.couchdb.CouchDBUtil;
import fr.imag.exschema.git.GitUtil;
import fr.imag.exschema.hbase.HBaseUtil;
import fr.imag.exschema.jpa.JpaRepositoryVisitor;
import fr.imag.exschema.jpa.SpringJpaRepositoryVisitor;
import fr.imag.exschema.model.Attribute;
import fr.imag.exschema.model.Set;
import fr.imag.exschema.model.Struct;
import fr.imag.exschema.mongodb.MongoDBUtil;
import fr.imag.exschema.mongodb.SpringDocumentRepositoryVisitor;
import fr.imag.exschema.neo4j.Neo4jUtil;
import fr.imag.exschema.visitor.AnnotationVisitor;
import fr.imag.exschema.visitor.SpringRepositoryVisitor;

/**
 * Generic utility methods.
 * 
 * @author jccastrejon
 * 
 */
public class Util {

    /**
     * Default logging level.
     */
    public static Level LOGGING_LEVEL = Level.FINE;

    /**
     * Class logger.
     */
    private static Logger logger = Logger.getLogger(Util.class.getName());

    /**
     * Starting point for discovering schemas from non-relational applications.
     * 
     * @param project
     * @param monitor
     * @throws InterruptedException
     * @throws IOException
     * @throws CoreException
     */
    public static File discoverSchemas(final IJavaProject project, final IProgressMonitor monitor) throws IOException,
            InterruptedException, CoreException {
        File returnValue;
        List<Set> schemas;

        // JPA repositories
        Util.monitorSubtask(monitor, "Analyzing JPA repositories");
        schemas = new ArrayList<Set>();
        schemas.addAll(Util.discoverSpringRepositories(project, new JpaRepositoryVisitor()));
        schemas.addAll(Util.discoverSpringRepositories(project, new SpringJpaRepositoryVisitor()));

        // Document repositories
        Util.monitorSubtask(monitor, "Analyzing document repositories");
        schemas.addAll(Util.discoverSpringRepositories(project, new SpringDocumentRepositoryVisitor()));

        // Document
        Util.monitorSubtask(monitor, "Analyzing document datastores");
        schemas.addAll(new MongoDBUtil().discoverSchemas(project));
        schemas.addAll(new CouchDBUtil().discoverSchemas(project));

        // Graph
        Util.monitorSubtask(monitor, "Analyzing graph datastores");
        schemas.addAll(new Neo4jUtil().discoverSchemas(project));

        // Column
        Util.monitorSubtask(monitor, "Analyzing column datastores");
        schemas.addAll(new HBaseUtil().discoverSchemas(project));

        // Export discovered schemas
        Util.monitorSubtask(monitor, "Exporting schemas");
        returnValue = Util.exportDiscoveredSchemas(schemas, project);

        return returnValue;
    }

    /**
     * Starting point for discovering schemas from all the versions stored in
     * the Git repository of the specified project.
     * 
     * @param project
     * @param monitor
     * @throws GitAPIException
     * @throws IOException
     * @throws CoreException
     * @throws InterruptedException
     */
    public static List<File> discoverHistorySchemas(final IJavaProject project, final IProgressMonitor monitor)
            throws IOException, GitAPIException, InterruptedException, CoreException {
        File currentOutput;
        File renamedOutput;
        List<File> returnValue;
        List<Ref> projectVersions;

        projectVersions = GitUtil.getProjectVersions(project);
        returnValue = new ArrayList<File>(projectVersions.size());
        for (Ref version : projectVersions) {
            // Analyze project at this version
            Util.monitorSubtask(monitor, "Starting the analysis of version: " + version.getName());
            try {
                // Checkout and analyze this project version
                Util.monitorSubtask(monitor, "Checking out project version");
                GitUtil.checkoutProjectVersion(project, version.getName());
                Util.monitorSubtask(monitor, "Discovering schemas");
                currentOutput = Util.discoverSchemas(project, monitor);

                // Rename output directory with the version name
                Util.monitorSubtask(monitor, "Renaming results directory");
                renamedOutput = new File(currentOutput.getParentFile(), version.getName().replaceAll("\\W", ".") + "-"
                        + currentOutput.getName());
                currentOutput.renameTo(renamedOutput);
                returnValue.add(renamedOutput);
            } catch (Exception e) {
                Util.logger.log(
                        Util.LOGGING_LEVEL,
                        "Unable to discover schemas for project " + project.getElementName() + " at version "
                                + version.getName(), e);
            }
        }

        // Return project to the latest version
        Util.monitorSubtask(monitor, "Going back to the master branch");
        GitUtil.checkoutProjectVersion(project, "master");

        return returnValue;
    }

    /**
     * Get the invocation block that contains the specified node.
     * 
     * @param node
     * @return
     */
    public static Block getInvocationBlock(final ASTNode node) {
        Block returnValue;

        returnValue = null;
        if (node != null) {
            if (Block.class.isAssignableFrom(node.getClass())) {
                returnValue = (Block) node;
            } else {
                returnValue = Util.getInvocationBlock(node.getParent());
            }
        }

        return returnValue;
    }

    /**
     * Determine whether the invocation matches with the expected class name.
     * 
     * @param invocation
     * @param className
     * @return
     */
    public static boolean isMatchingClass(final MethodInvocation invocation, final String className) {
        boolean returnValue;

        // TODO: Support more cases, not only instantiation
        returnValue = false;
        if (ClassInstanceCreation.class.isAssignableFrom(invocation.getParent().getClass())) {
            if (className.contains(((ClassInstanceCreation) invocation.getParent()).resolveTypeBinding().getName())) {
                returnValue = true;
            }
        }

        return returnValue;
    }

    /**
     * Analyze the specified Java project with the specified AST visitor.
     * 
     * @param project
     * @param visitor
     * @throws CoreException
     */
    public static void analyzeJavaProject(final IJavaProject project, final ASTVisitor visitor) throws CoreException {
        CompilationUnit parsedUnit;

        for (IPackageFragment aPackage : Util.getPackageFragments(project)) {
            if (aPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                for (ICompilationUnit compilationUnit : aPackage.getCompilationUnits()) {
                    parsedUnit = Util.parse(compilationUnit);
                    parsedUnit.accept(visitor);
                }
            }
        }
    }

    /**
     * Analyze classes that are expected by the specified annotationVisitor, as
     * well as any super class that may match the requirements of such visitor.
     * 
     * @param annotationVisitor
     * @throws CoreException
     */
    public static void analyzeAnnotations(final IJavaProject project, final AnnotationVisitor annotationVisitor)
            throws CoreException {
        Map<String, IField[]> childEntities;

        // Classes that directly have the expected annotations
        Util.analyzeJavaProject(project, annotationVisitor);

        // Classes that some of their parents have the expected annotation
        childEntities = new HashMap<String, IField[]>();
        for (String macthingClass : annotationVisitor.getEntities().keySet()) {
            for (IPackageFragment aPackage : Util.getPackageFragments(project)) {
                if (aPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                    for (ICompilationUnit compilationUnit : aPackage.getCompilationUnits()) {
                        for (IType type : compilationUnit.getTypes()) {
                            if ((type.getSuperclassName() != null)
                                    && (macthingClass.contains(type.getSuperclassName()))) {
                                childEntities.put(type.getFullyQualifiedName(), type.getFields());
                            }
                        }
                    }
                }
            }
        }

        annotationVisitor.setChildEntities(childEntities);
    }

    /**
     * Determine whether the specified string is a valid Java variable name.
     * 
     * @param name
     * @return
     */
    public static boolean isVariableName(final String name) {
        return name.matches("^[a-zA-Z][a-zA-Z0-9]*?$");
    }

    /**
     * Get a valid String name.
     * 
     * @param name
     * @return
     */
    public static String getValidName(final String name) {
        String returnValue;

        returnValue = name;
        if (returnValue.contains("=")) {
            returnValue = returnValue.substring(0, returnValue.indexOf('='));
        }

        return returnValue;
    }

    /**
     * Verify if the specified annotation matches the expected annotation names.
     * 
     * @param annotation
     * @param annotationNames
     * @return
     */
    public static boolean isExpectedAnnotation(final Annotation annotation, String... annotationNames) {
        boolean returnValue;
        String qualifiedName;

        returnValue = false;
        qualifiedName = annotation.resolveTypeBinding().getQualifiedName();
        if (qualifiedName != null) {
            for (String annotationName : annotationNames) {
                if (qualifiedName.equals(annotationName)) {
                    returnValue = true;
                    break;
                }
            }
        }

        return returnValue;
    }

    /**
     * Get the different files where the specified nodes are used.
     * 
     * @param nodes
     * @return
     */
    public static java.util.Set<ASTNode> getNodesFiles(final List<? extends ASTNode> nodes) {
        java.util.Set<ASTNode> returnValue;

        returnValue = new HashSet<ASTNode>();
        for (ASTNode node : nodes) {
            // Get the root node of the file containing this invocation
            returnValue.add(Util.getRootNode(node));
        }

        return returnValue;
    }

    /**
     * Get the Root node of the specified node.
     * 
     * @param node
     * @return
     */
    public static ASTNode getRootNode(final ASTNode node) {
        ASTNode returnValue;

        returnValue = node;
        while (returnValue.getParent() != null) {
            returnValue = returnValue.getParent();
        }

        return returnValue;
    }

    /**
     * Get a random unique identifier.
     * 
     * @return
     */
    public static String getUniqueIdentifier() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    /**
     * Notify in the progress monitor the start of a subtask with the specified
     * description.
     * 
     * @param monitor
     * @param description
     */
    private static void monitorSubtask(final IProgressMonitor monitor, final String description) {
        if (monitor != null) {
            monitor.subTask(description);
        }
    }

    /**
     * Get the package fragments associated to the specified project and its
     * required projects.
     * 
     * @param project
     * @throws CoreException
     */
    private static List<IPackageFragment> getPackageFragments(final IJavaProject project) throws CoreException {
        IProject requiredProject;
        String[] requiredProjects;
        IWorkspaceRoot workspaceRoot;
        List<IPackageFragment> returnValue;

        // Project fragments
        returnValue = new ArrayList<IPackageFragment>();
        returnValue.addAll(Arrays.asList(project.getPackageFragments()));

        // Required projects fragments
        requiredProjects = project.getRequiredProjectNames();
        if ((requiredProjects != null) && (requiredProjects.length > 0)) {
            workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
            for (String currentProject : requiredProjects) {
                requiredProject = workspaceRoot.getProject(currentProject);
                if (requiredProject.hasNature(JavaCore.NATURE_ID)) {
                    returnValue.addAll(Arrays.asList((JavaCore.create(requiredProject)).getPackageFragments()));
                }
            }
        }

        return returnValue;
    }

    /**
     * Export the list of schemas into a Graphviz-generated pdf file, saved at
     * the top of the specified project.
     * 
     * @param schemas
     * @param project
     * @return The directory where the results are stored.
     * @throws IOException
     * @throws InterruptedException
     * @throws CoreException
     */
    private static File exportDiscoveredSchemas(final List<Set> schemas, final IJavaProject project)
            throws IOException, InterruptedException, CoreException {
        File dotFile;
        String dotGraph;
        File outputDirectory;
        String dateIdentifier;
        List<String> dslFiles;
        List<String> rooScripts;

        // Associate all the export files with a common date identifier
        dateIdentifier = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(System.currentTimeMillis());
        outputDirectory = new File(project.getProject().getLocation().toOSString(), "exschema_results/"
                + dateIdentifier);
        outputDirectory.mkdirs();

        // Export a pdf graph with the discovered schemas
        dotGraph = Util.createDotGraph(schemas);
        dotFile = Util.saveDotGraph(dotGraph, outputDirectory);
        Util.executeDotCommand(dotFile);

        // Export Roo scripts
        rooScripts = Util.createRooScripts(schemas);
        Util.saveFiles(rooScripts, outputDirectory, "rooScripts", "roo");

        // Export a Dsl representation
        dslFiles = Util.createDslFiles(schemas);
        Util.saveFiles(dslFiles, outputDirectory, "dslFiles", "exschema");

        // Reload workspace to reflect the changes
        project.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);

        return outputDirectory;
    }

    /**
     * Execute Graphviz dot's command to generate the pdf file.
     * 
     * @param dotFile
     * @throws IOException
     * @throws InterruptedException
     */
    private static File executeDotCommand(final File dotFile) throws IOException, InterruptedException {
        Process process;
        int processCode;
        File returnValue;
        String dotCommand;

        returnValue = new File(dotFile.getParent(), "schemas.pdf");
        dotCommand = "dot -Tpdf " + dotFile.getAbsolutePath() + " -o " + returnValue.getAbsolutePath();
        process = Runtime.getRuntime().exec(dotCommand);
        processCode = process.waitFor();
        dotFile.delete();

        if (processCode != 0) {
            throw new RuntimeException("An error ocurred while executing: " + dotCommand);
        }

        return returnValue;
    }

    /**
     * Save the specified Graphviz's dot file at the top of the specified
     * project.
     * 
     * @param dotGraph
     * @param outputDirectory
     * @return
     * @throws IOException
     */
    private static File saveDotGraph(final String dotGraph, final File outputDirectory) throws IOException {
        File returnValue;
        FileWriter fileWriter;

        // Output content
        returnValue = new File(outputDirectory, "schemas.dot");
        fileWriter = new FileWriter(returnValue, false);
        fileWriter.write(dotGraph);
        fileWriter.close();

        return returnValue;
    }

    /**
     * Save file contents in an output directory.
     * 
     * @param contents
     * @param outputDirectory
     * @param dirName
     * @param fileExtension
     * @throws IOException
     */
    private static void saveFiles(final List<String> contents, final File outputDirectory, final String outputName,
            final String fileExtension) throws IOException {
        int index;
        File directory;
        File rooScriptFile;
        FileWriter fileWriter;

        // Save scripts in a new folder
        directory = new File(outputDirectory, outputName);
        directory.mkdir();

        index = 0;
        for (String content : contents) {
            index = index + 1;
            rooScriptFile = new File(directory, "schema" + index + "." + fileExtension);
            fileWriter = new FileWriter(rooScriptFile, false);
            fileWriter.write(content);
            fileWriter.close();
        }
    }

    /**
     * Create a Graphviz's graph from the specified list of schemas.
     * 
     * @param schemas
     * @return
     */
    private static String createDotGraph(final List<Set> schemas) {
        int index;
        StringBuilder returnValue;

        returnValue = new StringBuilder("digraph schema_" + System.nanoTime() + "_ {\n");

        index = 0;
        for (Set schema : schemas) {
            index = index + 1;
            returnValue.append("\nsubgraph cluster_" + System.nanoTime() + "_ {\n");
            returnValue.append("color=lightgrey;\n");
            returnValue.append("label=\"Schema" + index + "\";\n");
            returnValue.append(schema.getDotNodes(null));
            returnValue.append("\n}\n");
        }

        returnValue.append("\n}\n");
        return returnValue.toString();
    }

    /**
     * Create a list of Spring Roo scripts from the specified schemas (One
     * script per schema).
     * 
     * @param schemas
     * @return
     */
    private static List<String> createRooScripts(final List<Set> schemas) {
        List<String> returnValue;

        returnValue = new ArrayList<String>(schemas.size());
        for (Set schema : schemas) {
            returnValue.add(schema.getRooCommands(null, null));
        }

        return returnValue;
    }

    /**
     * Create a list of DSL representations from the specified schemas (One file
     * per schema).
     * 
     * @param schemas
     * @return
     */
    private static List<String> createDslFiles(final List<Set> schemas) {
        List<String> returnValue;

        returnValue = new ArrayList<String>(schemas.size());
        for (Set schema : schemas) {
            returnValue.add(schema.getDsl());
        }

        return returnValue;
    }

    /**
     * Discover Spring-based repositories.
     * 
     * @param project
     * @param annotationVisitor
     * @return
     * @throws CoreException
     */
    private static List<Set> discoverSpringRepositories(final IJavaProject project,
            final SpringRepositoryVisitor annotationVisitor) throws CoreException {
        Set currentClass;
        Struct currentFields;
        Set currentCollection;
        List<Set> returnValue;

        // Identify model classes
        Util.analyzeJavaProject(project, annotationVisitor);

        // Analyze model classes
        returnValue = new ArrayList<Set>();
        currentCollection = new Set();
        currentCollection.addAttribute(new Attribute("implementation", annotationVisitor.getImplementation()));
        Util.logger.log(Util.LOGGING_LEVEL, "Spring-based repository classes: ");
        for (IPackageFragment aPackage : Util.getPackageFragments(project)) {
            if (aPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                for (ICompilationUnit compilationUnit : aPackage.getCompilationUnits()) {
                    for (IType type : compilationUnit.getAllTypes()) {
                        for (String domainClass : annotationVisitor.getDomainClasses()) {
                            if (type.getFullyQualifiedName().equals(domainClass)) {
                                currentClass = new Set();
                                currentCollection.addSet(currentClass);
                                currentClass.addAttribute(new Attribute("name", domainClass));
                                Util.logger.log(Util.LOGGING_LEVEL, "\n" + domainClass);
                                currentFields = new Struct();
                                currentClass.addStruct(currentFields);
                                Util.logger.log(Util.LOGGING_LEVEL, "Fields:");
                                for (IField field : type.getFields()) {
                                    currentFields.addAttribute(new Attribute("name", field.getElementName()));
                                    Util.logger.log(Util.LOGGING_LEVEL,
                                            field.getElementName() + ":" + field.getTypeSignature());
                                }
                            }
                        }
                    }
                }
            }
        }

        // Verify if any repository was found
        if (!currentCollection.getSets().isEmpty()) {
            returnValue.add(currentCollection);
        }

        return returnValue;
    }

    /**
     * Parse the specified compilation unit.
     * 
     * @param compilationUnit
     * @return
     */
    private static CompilationUnit parse(final ICompilationUnit compilationUnit) {
        ASTParser parser;

        parser = ASTParser.newParser(AST.JLS4);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setSource(compilationUnit);
        parser.setResolveBindings(true);
        return (CompilationUnit) parser.createAST(null);
    }
}