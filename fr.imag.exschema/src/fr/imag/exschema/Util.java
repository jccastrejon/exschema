package fr.imag.exschema;

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
        // Document
        Util.discoverRepositories(project);
        MongoDBUtil.discoverMongoObjects(project);

        // Graph
        Neo4jUtil.discoverNeo4JNodeEntities(project);
        Neo4jUtil.discoverNeo4JNodes(project);

        // Column
        HBaseUtil.discoverHbaseTables(project);
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
     * Spring-based repositories.
     * 
     * @param project
     * @throws JavaModelException
     */
    private static void discoverRepositories(final IJavaProject project) throws JavaModelException {
        SpringRepositoryVisitor annotationVisitor;

        // Identify model classes
        annotationVisitor = new SpringRepositoryVisitor();
        Util.analyzeJavaProject(project, annotationVisitor);

        // Analyze model classes
        System.out.println("Spring-based repository classes: ");
        for (IPackageFragment aPackage : project.getPackageFragments()) {
            if (aPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                for (ICompilationUnit compilationUnit : aPackage.getCompilationUnits()) {
                    for (IType type : compilationUnit.getAllTypes()) {
                        for (String domainClass : annotationVisitor.getDomainClasses()) {
                            if (type.getFullyQualifiedName().equals(domainClass)) {
                                System.out.println("\n" + domainClass);
                                Util.analyzeModelType(type);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * 
     * @param type
     * @throws JavaModelException
     */
    private static void analyzeModelType(IType type) throws JavaModelException {
        // TODO: Real analysis...
        System.out.println("Fields:");
        for (IField field : type.getFields()) {
            System.out.println(field.getElementName() + ":" + field.getTypeSignature());
        }
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