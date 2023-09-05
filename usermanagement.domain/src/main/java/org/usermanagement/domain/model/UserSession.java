package org.usermanagement.domain.model;

import eapli.framework.validations.Preconditions;

import java.time.LocalDateTime;
import java.util.UUID;

public class UserSession  {
    private static final long serialVersionUID = 1L;

    /**
     * User the is authenticated in session.
     */
    private final User authenticatedUser;
    /**
     * Token  of User the is authenticated in session.
     */
    private final UUID token;

    /**
     * When user got authenticated.
     */
    private final LocalDateTime startedOn;

    /**
     * Constructor for UserSession.
     * @param user
     */
    public UserSession(final User user) {
        Preconditions.nonNull(user, "User can't be null");

        authenticatedUser = user;
        token = UUID.randomUUID();
        startedOn = LocalDateTime.now();
    }

    /**
     * Print this class identity and token.
     * @return
     */
    @Override
    public String toString() {
        return authenticatedUser.identity() + "@" + token;
    }

    /**
     * @return user that is authenticated.
     */
    public User authenticatedUser() {
        return authenticatedUser;
    }

    public UUID token() {
        return token;
    }
}
