package org.authz.config;

import eapli.framework.presentation.console.AbstractUI;
import org.authz.application.AuthenticationService;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.UserSession;

import java.util.Optional;
import java.util.Scanner;

public class LoginUI extends AbstractUI {
    /**
     * Get AuthenticationService.
     */
    private final AuthenticationService authService = AuthzRegistry
                                    .authenticationService();

    /**
     * Get AuthorizationService.
     */
    private final AuthorizationService authzService = AuthzRegistry
                                    .authorizationService();

    /**
     * Scanner for read lines.
     */
    private final Scanner reader = new Scanner(System.in);

    /**
     * Max attempts to login.
     */
    private static final int MAX_TRIES = 3;

    /**
     * Ask user Email and Password to authenticate.
     * @return true or false
     */
    @Override
    protected boolean doShow() {
        int tries = 0;

        while (tries < MAX_TRIES) {

            try {
                System.out.print("Email: ");
                String username = reader.nextLine();
                System.out.println();

                System.out.print("Password: ");
                String password = reader.nextLine();
                System.out.println();

                Optional<UserSession> session = authService
                        .authenticate(username, password,
                                CourseRoles.allRoles());

                if (session.isPresent()) {
                    return true;
                }

                tries++;
                System.out.println("Invalid credentials, "
                        + (MAX_TRIES - tries) + " tries left\n");
            } catch (Exception e) {
                tries++;
                System.out.println(e.getMessage()
                        + ", " + (MAX_TRIES - tries) + " tries left\n");
            }

        }

        return false;
    }

    /**
     * Title of UI.
     * @return String with Title
     */
    @Override
    public String headline() {
        return "Login";
    }
}
