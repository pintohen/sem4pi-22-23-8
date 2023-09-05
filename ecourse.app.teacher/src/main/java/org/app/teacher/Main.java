package org.app.teacher;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.authz.application.AuthzRegistry;
import org.persistence.PersistenceContext;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.authz.config.LoginUI;

public final class Main {

    /**
     * Ensure that this class cannot be instantiated.
     */
    private Main() {
        // utility class. (entry point)
    }

    /**
     * Initialize LoginUI.
     */
    private static LoginUI login;
    /**
     * Start modulo user.
     * @param args - args
     */
    public static void main(final String[] args) {
        try {
            AuthzRegistry.configure(
                    PersistenceContext.repositories().users(),
                    new PlainTextEncoder(),
                    new ECoursePasswordPolicy()
            );

            login = new LoginUI();

            if (login.show()) {
                MainMenu menu = new MainMenu();
                menu.mainLoop();
            } else {
                System.out.println("Login failed\nToo many tries");
            }

        } catch (Exception e) {
            System.out.println("Database is down.");
            System.out.println(e.getMessage());
        }
    }
}
