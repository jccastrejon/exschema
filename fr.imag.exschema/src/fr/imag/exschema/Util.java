package fr.imag.exschema;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTNode;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.ClassInstanceCreation;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodInvocation;

import fr.imag.exschema.hbase.HBaseUtil;
import fr.imag.exschema.model.Attribute;
import fr.imag.exschema.model.Set;
import fr.imag.exschema.model.Struct;
import fr.imag.exschema.mongodb.MongoDBUtil;
import fr.imag.exschema.neo4j.Neo4jUtil;

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
     * @throws InterruptedException
     * @throws IOException
     * @throws CoreException
     */
    public static void discoverSchemas(final IJavaProject project) throws IOException, InterruptedException,
            CoreException {
        List<Set> schemas;

        // Generic Spring-based repositories
        schemas = new ArrayList<Set>();
        schemas.addAll(Util.discoverSpringRepositories(project));

        // Document
        schemas.addAll(new MongoDBUtil().discoverSchemas(project));

        // Graph
        schemas.addAll(new Neo4jUtil().discoverSchemas(project));

        // Column
        schemas.addAll(new HBaseUtil().discoverSchemas(project));

        // Export discovered schemas
        Util.exportDiscoveredSchemas(schemas, project);
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
     * @throws JavaModelException
     */
    public static void analyzeJavaProject(final IJavaProject project, final ASTVisitor visitor)
            throws JavaModelException {
        CompilationUnit parsedUnit;

        for (IPackageFragment aPackage : project.getPackageFragments()) {
            if (aPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                for (ICompilationUnit compilationUnit : aPackage.getCompilationUnits()) {
                    parsedUnit = Util.parse(compilationUnit);
                    parsedUnit.accept(visitor);
                }
            }
        }
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
     * Export the list of schemas into a Graphviz-generated pdf file, saved at
     * the top of the specified project.
     * 
     * @param schemas
     * @throws IOException
     * @throws InterruptedException
     * @throws CoreException
     */
    private static void exportDiscoveredSchemas(final List<Set> schemas, final IJavaProject project)
            throws IOException, InterruptedException, CoreException {
        File dotFile;
        String dotGraph;

        // Export a pdf graph with the discovered schemas, and reload
        // workspace to reflect the changes
        dotGraph = Util.createDotGraph(schemas);
        dotFile = Util.saveDotGraph(dotGraph, project);
        Util.executeDotCommand(dotFile);
        project.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
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
     * @param project
     * @return
     * @throws IOException
     */
    private static File saveDotGraph(final String dotGraph, final IJavaProject project) throws IOException {
        File returnValue;
        FileWriter fileWriter;

        // Output content
        returnValue = new File(project.getProject().getLocation().toOSString(), "schemas.dot");
        fileWriter = new FileWriter(returnValue, false);
        fileWriter.write(dotGraph);
        fileWriter.close();

        return returnValue;
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
     * Discover Spring-based repositories.
     * 
     * @param project
     * @throws JavaModelException
     */
    private static List<Set> discoverSpringRepositories(final IJavaProject project) throws JavaModelException {
        Set currentClass;
        Struct currentFields;
        Set currentCollection;
        List<Set> returnValue;
        SpringRepositoryVisitor annotationVisitor;

        // Identify model classes
        annotationVisitor = new SpringRepositoryVisitor();
        Util.analyzeJavaProject(project, annotationVisitor);

        // Analyze model classes
        returnValue = new ArrayList<Set>();
        currentCollection = new Set();
        currentCollection.addAttribute(new Attribute("implementation", "Spring Repository"));
        Util.logger.log(Util.LOGGING_LEVEL, "Spring-based repository classes: ");
        for (IPackageFragment aPackage : project.getPackageFragments()) {
            if (aPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                for (ICompilationUnit compilationUnit : aPackage.getCompilationUnits()) {
                    for (IType type : compilationUnit.getAllTypes()) {
                        for (String domainClass : annotationVisitor.getDomainClasses()) {
                            if (type.getFullyQualifiedName().equals(domainClass)) {
                                currentClass = new Set();
                                currentCollection.addSet(currentClass);
                                currentClass.addAttribute(new Attribute("name", domainClass));
                                Util.logger.log(Util.LOGGING_LEVEL, "\n" + domainClass);
                                // TODO: Real analysis...
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