package fr.imag.exschema;

import java.util.ArrayList;
import java.util.List;

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
 * 
 * @author jccastrejon
 * 
 */
public class Util {

    /**
     * 
     * @param project
     * @throws JavaModelException
     */
    public static void discoverSchemas(final IJavaProject project) throws JavaModelException {
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

        System.out.println("\n\nDiscovered schemas:" + Util.createDotGraph(schemas));
    }

    /**
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
     * 
     * @param name
     * @return
     */
    public static boolean isVariableName(final String name) {
        return name.matches("^[a-zA-Z][a-zA-Z0-9]*?$");
    }

    /**
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
     * Spring-based repositories.
     * 
     * @param project
     * @throws JavaModelException
     */
    private static List<Set> discoverSpringRepositories(final IJavaProject project) throws JavaModelException {
        Set currentClass;
        Set currentFields;
        Struct currentField;
        Set currentCollection;
        List<Set> returnValue;
        SpringRepositoryVisitor annotationVisitor;

        // Identify model classes
        annotationVisitor = new SpringRepositoryVisitor();
        Util.analyzeJavaProject(project, annotationVisitor);

        // Analyze model classes
        returnValue = new ArrayList<Set>();
        currentCollection = new Set();
        System.out.println("Spring-based repository classes: ");
        for (IPackageFragment aPackage : project.getPackageFragments()) {
            if (aPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                for (ICompilationUnit compilationUnit : aPackage.getCompilationUnits()) {
                    for (IType type : compilationUnit.getAllTypes()) {
                        for (String domainClass : annotationVisitor.getDomainClasses()) {
                            if (type.getFullyQualifiedName().equals(domainClass)) {
                                currentClass = new Set();
                                currentCollection.addSet(currentClass);
                                currentClass.addAttribute(new Attribute("name", domainClass));
                                System.out.println("\n" + domainClass);
                                // TODO: Real analysis...
                                currentFields = new Set();
                                currentClass.addSet(currentFields);
                                System.out.println("Fields:");
                                for (IField field : type.getFields()) {
                                    currentField = new Struct();
                                    currentFields.addStruct(currentField);
                                    currentField.addAttribute(new Attribute("name", field.getElementName()));
                                    System.out.println(field.getElementName() + ":" + field.getTypeSignature());
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