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
        AnnotationVisitor annotationVisitor;

        // Identify model classes
        annotationVisitor = new AnnotationVisitor();
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
