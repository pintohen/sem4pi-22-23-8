package org.authz.application;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.validations.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.usermanagement.domain.model.Password;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;
import org.usermanagement.domain.repositories.UserRepository;

import java.util.Optional;

@Component
public class AuthenticationService {
    /**
     * Repository for User entity.
     */
    private UserRepository repo;
    /**
     * AuthorizationService instance.
     */
    private AuthorizationService authorizationService;
    /**
     * PasswordPolicy for validating passwords.
     */
    private PasswordPolicy policy;
    /**
     * PasswordEncoder for encoding and decoding passwords.
     */
    private PasswordEncoder encoder;


    /**
     * Constructor for AuthenticationService.
     *
     * @param repop UserRepository instance for managing User entities.
     * @param authServicep AuthorizationService creating user sessions.
     * @param policyp PasswordPolicy instance for validating passwords.
     * @param encoderp PasswordEncoder encoding and decoding passwords.
     */
    @Autowired
    public AuthenticationService(final UserRepository repop,
                                 final AuthorizationService authServicep,
                                 final PasswordPolicy policyp,
                                 final PasswordEncoder encoderp) {
        Preconditions.noneNull(repop, authServicep, encoderp);
        this.repo = repop;
        this.authorizationService = authServicep;
        this.policy = policyp;
        this.encoder = encoderp;
    }


    /**
     * Authenticates a user.
     *
     * @param emailString Username of the user to be authenticated.
     * @param rawPassword Raw password of the user to be authenticated.
     * @param requiredRoles Optional required roles for the authenticated user.
     * @return UserSession if authentication is successful, else empty Optional.
     */
    public Optional<UserSession> authenticate(final String emailString,
                                              final String rawPassword,
                                              final Role... requiredRoles) {
        Preconditions.nonEmpty(emailString, "A email must be provided");
        Preconditions.nonEmpty(rawPassword, "A password must be provided");

        final User user = retrieveUser(emailString)
                .filter(u -> u.passwordMatches(rawPassword, encoder)
                        && u.isActive()
                        && (noRolesToValidate(requiredRoles)
                        || u.hasAnyOf(requiredRoles)))
                .orElse(null);

        System.out.println();

        return authorizationService.createUserSession(user);
    }





    /**
     * Checks if there are no roles to validate.
     * @param roles Roles to be validated.
     * @return True if there are no roles to validate, else false.
     */
    private boolean noRolesToValidate(final Role... roles) {
        return roles.length == 0 || (roles.length == 1 && roles[0] == null);
    }

    /**
     * Retrieves a User entity from the UserRepository by username.
     * @param email Username of the user to be retrieved.
     * @return Optional User entity if found, else empty Optional.
     */
    private Optional<User> retrieveUser(final String email) {
        return repo.ofIdentity(EmailAddress.valueOf(email));
    }

    /**
     * Changes the password of a User entity.
     * @param user User entity for which the password needs to be changed.
     * @param oldPassword Old password of the user.
     * @param newPassword New password for the user.
     * @return User with the changed password if successful, else empty.
     */
    public Optional<User> changePassword(final User user,
                                         final String oldPassword,
                                         final String newPassword) {
        if (user.passwordMatches(oldPassword, encoder)) {
            return Password.encodedAndValid(newPassword, policy, encoder)
                .map(p -> {
                    user.changePassword(p);
                    return repo.save(user);
                });
        }
        return Optional.empty();
    }
}
