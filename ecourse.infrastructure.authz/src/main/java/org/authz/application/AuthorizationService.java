package org.authz.application;

import eapli.framework.infrastructure.authz.application.exceptions.UnauthenticatedException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.authz.exception.UnauthorizedException;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;

import java.util.Optional;

public class AuthorizationService {
    /**
     * Current user session.
     */
    private UserSession session = null;

    /**
     * Create session for user.
     * @param user session is being created.
     * @return user session, or empty if the session creation failed.
     */
    public Optional<UserSession> createUserSession(final User user) {
        if (user != null) {
            this.session = new UserSession(user);
        } else {
            clearSession();
        }
        return session();
    }

    /**
     * Clear the current session.
     */
    private void clearSession() {
        this.session = null;
    }

    /**
     * Get the current user session.
     * @return current user session, or empty if no session exists
     */
    public Optional<UserSession> session() {
        return Optional.ofNullable(session);
    }

    /**
     * checks if there is an authenticated user session.
     *
     * @return {@code true} if there is an authenticated user session
     */
    public boolean hasSession() {
        return session != null;
    }

    /**
     * Check if authenticated user have some role.
     * @param actions roles that have authorization to do something
     */
    public void ensureAuthenticatedUserHasAnyOf(final Role... actions) {
        final UserSession us = session().orElseThrow(() -> {
            System.out.println("Unauthenticated access attempt");
            return new UnauthenticatedException();
        });
        if (!us.authenticatedUser().hasAnyOf(actions)) {
            System.out.println("Unauthorized access attempt by user"
                    + us.authenticatedUser().emailAddress());
            throw new UnauthorizedException(us.authenticatedUser(), actions);
        }
    }

    /**
     * Check if authenticated user have some role.
     * @param actions roles that have authorization to do something
     * @return true if authenticated user have some role
     */
    public boolean isAuthenticatedUserAuthorizedTo(final Role... actions) {
        return session()
                .map(us -> us.authenticatedUser().hasAnyOf(actions))
                .orElse(false);
    }
}
