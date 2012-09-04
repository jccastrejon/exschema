package fr.imag.exschema;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IField;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.MethodInvocation;

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
        Util.discoverRepositories(project);
        Util.discoverMongoObjects(project);
    }

    /**
     * Spring-based repositories.
     * 
     * @param project
     * @throws JavaModelException
     */
    private static void discoverRepositories(final IJavaProject project) throws JavaModelException {
        RepositoryVisitor annotationVisitor;

        // Identify model classes
        annotationVisitor = new RepositoryVisitor();
        for (IPackageFragment aPackage : project.getPackageFragments()) {
            if (aPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                for (ICompilationUnit compilationUnit : aPackage.getCompilationUnits()) {
                    Util.analyzeCompilationUnit(compilationUnit, annotationVisitor);
                }
            }
        }

        // Analyze model classes
        System.out.println("Data model classes: ");
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
     * @param project
     * @throws JavaModelException
     */
    private static void discoverMongoObjects(final IJavaProject project) throws JavaModelException {
        MongoVisitor mongoVisitor;

        // Identify when objects are being saved
        mongoVisitor = new MongoVisitor();
        for (IPackageFragment aPackage : project.getPackageFragments()) {
            if (aPackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                for (ICompilationUnit compilationUnit : aPackage.getCompilationUnits()) {
                    Util.analyzeCompilationUnit(compilationUnit, mongoVisitor);
                }
            }
        }

        // Analyze save invocations
        System.out.println("Invocations: ");
        for (MethodInvocation methodInvocation : mongoVisitor.getSaveInvocations()) {
            System.out.println(methodInvocation.getExpression());
        }
    }

    /**
     * 
     * @param type
     * @throws JavaModelException
     */
    private static void analyzeModelType(IType type) throws JavaModelException {
        System.out.println("Fields:");
        for (IField field : type.getFields()) {
            System.out.println(field.getElementName() + ":" + field.getTypeSignature());
        }
    }

    /**
     * 
     * @param type
     * @throws JavaModelException
     */
    private static void analyzeCompilationUnit(final ICompilationUnit compilationUnit,
            final ASTVisitor annotationVisitor) throws JavaModelException {
        CompilationUnit parsedUnit;

        parsedUnit = Util.parse(compilationUnit);
        parsedUnit.accept(annotationVisitor);
    }

    /**
     * 
     * @param compilationUnit
     * @return
     */
    private static CompilationUnit parse(ICompilationUnit compilationUnit) {
        ASTParser parser;

        parser = ASTParser.newParser(AST.JLS4);
        parser.setKind(ASTParser.K_COMPILATION_UNIT);
        parser.setSource(compilationUnit);
        parser.setResolveBindings(true);
        return (CompilationUnit) parser.createAST(null);
    }
}
