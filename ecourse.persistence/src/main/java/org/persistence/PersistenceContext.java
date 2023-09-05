package org.persistence;

import eapli.framework.util.Utility;
import org.ecourse.Application;

import java.lang.reflect.InvocationTargetException;

@Utility
public final class PersistenceContext {
    /**
     * RepositoryFactory instance.
     */
    private static RepositoryFactory theFactory;

    /**
     * PersistenceContext Constructor.
     */
    private PersistenceContext() {
    }

    /**
     * Dynamically load repository factory.
     * @return RepositoryFactory
     */
    public static RepositoryFactory repositories() {
        if (theFactory == null) {
            final String factoryClassName = Application.
                    settings().repositoryFactory();


            try {
                theFactory = (RepositoryFactory) Class.forName(factoryClassName)
                        .getDeclaredConstructor().newInstance();
            } catch (ClassNotFoundException | IllegalAccessException
                     | InstantiationException | IllegalArgumentException
                     | InvocationTargetException | NoSuchMethodException
                     | SecurityException e) {

                System.out.println("Unable to dynamically load the "
                        + "Repository Factory" + e.getMessage());

                throw new IllegalStateException("Unable to dynamically "
                        + "load the Repository Factory: "
                        + factoryClassName, e);
            }
        }
        return theFactory;
    }
}
