package fr.imag.exschema.git;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.Ref;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

/**
 * Utility methods to access Git repositories using the JGit project.
 * 
 * @author jccastrejon
 * 
 */
public class GitUtil {
    /**
     * Get all the different versions of the specified project, represented by
     * the existing <em>Tags</em> and <em>Branches</em> in the associated Git
     * repository.
     * 
     * @param project
     * @throws IOException
     * @throws GitAPIException
     */
    public static List<Ref> getProjectVersions(final IJavaProject project) throws IOException, GitAPIException {
        Git gitRepository;
        List<Ref> returnValue;

        // Try to get a reference to the Git repository associated to the
        // specified project
        returnValue = new ArrayList<Ref>();
        gitRepository = GitUtil.getGitRepository(project);

        // Consider each tag/branch as a different project version
        if (gitRepository != null) {
            returnValue.addAll(gitRepository.branchList().call());
            returnValue.addAll(gitRepository.tagList().call());
        }

        return returnValue;
    }

    /**
     * Checkout a particular version of the specified project.
     * 
     * @param versionName
     * @throws IOException
     * @throws GitAPIException
     * @throws CoreException
     */
    public static void checkoutProjectVersion(final IJavaProject project, final String versionName) throws IOException,
            GitAPIException, CoreException {
        Git gitRepository;

        gitRepository = GitUtil.getGitRepository(project);
        if (gitRepository != null) {
            gitRepository.checkout().setName(versionName).call();
            project.getProject().refreshLocal(IResource.DEPTH_INFINITE, null);
        }
    }

    /**
     * Obtain the Git respository that contains the specified project. The
     * repository can either be in the project's directory or in its hierarchy.
     * 
     * @param project
     * @return
     * @throws IOException
     */
    private static Git getGitRepository(final IJavaProject project) throws IOException {
        Git returnValue;
        File gitDirectory;
        File currentDirectory;
        Repository repository;
        FileRepositoryBuilder repositoryBuilder;

        // Check whether the project or one of its ancestors hosts a Git
        // repository
        returnValue = null;
        if (project.getProject().getRawLocation() != null) {
            repositoryBuilder = new FileRepositoryBuilder();
            currentDirectory = project.getProject().getRawLocation().toFile();
            repository = repositoryBuilder.setGitDir(currentDirectory).readEnvironment().findGitDir().build();
            while (currentDirectory != null) {
                gitDirectory = new File(currentDirectory, ".git");
                if (gitDirectory.exists()) {
                    repositoryBuilder = new FileRepositoryBuilder();
                    repository = repositoryBuilder.setGitDir(gitDirectory).readEnvironment().findGitDir().build();
                    break;
                } else {
                    currentDirectory = currentDirectory.getParentFile();
                }
            }

            // If possible, reference the Git repository
            if (repository != null) {
                returnValue = new Git(repository);
            }
        }

        return returnValue;
    }
}