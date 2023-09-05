package org.authz.application;

import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.usermanagement.domain.model.UserManagementService;
import org.usermanagement.domain.repositories.UserRepository;

/**
 * Registry for authorization services.
 */
public final class AuthzRegistry {

    /**
     * Authorization service instance.
     */
    private static AuthorizationService authorizationService;
    /**
     * Authentication service instance.
     */
    private static AuthenticationService authenticationService;
    /**
     * User management service instance.
     */
    private static UserManagementService userManagementService;


    /**
     * Private constructor to prevent instantiation.
     */
    private AuthzRegistry() {

    }

    /**
     * Get the authorization service.
     * @return authorization service.
     * @throws IllegalStateException service is not configured.
     */
    public static AuthorizationService authorizationService() {
        if (authorizationService == null) {
            throw new IllegalStateException("Authorization service not "
                    + "available.\nConfigure authzregistry first");
        }
        return authorizationService;
    }

    /**
     * Get the authentication service.
     * @return authentication service.
     * @throws IllegalStateException service is not configured.
     */
    public static AuthenticationService authenticationService() {
        if (authenticationService == null) {
            throw new IllegalStateException("Authentication service not "
                    + "available.\nConfigure authzregistry first");
        }
        return authenticationService;
    }

    /**
     * Get the user management service.
     * @return user management service.
     * @throws IllegalStateException service is not configured.
     */
    public static UserManagementService userService() {
        if (userManagementService == null) {
            throw new IllegalStateException("User service not available."
                    + "\nConfigure authzregistry first.");
        }
        return userManagementService;
    }

    /**
     * Configure the authorization services.
     * @param userRepo user repository.
     * @param encoder password encoder.
     * @param policy password policy.
     */
    public static void configure(final UserRepository userRepo,
                                 final PasswordEncoder encoder,
                                 final PasswordPolicy policy) {

        authorizationService = new AuthorizationService();
        authenticationService = new AuthenticationService(userRepo,
                        authorizationService, policy, encoder);
        userManagementService = new UserManagementService(userRepo,
                                    policy, encoder);
    }
}
