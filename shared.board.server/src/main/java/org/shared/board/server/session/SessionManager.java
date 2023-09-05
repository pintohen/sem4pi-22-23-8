package org.shared.board.server.session;

import org.apache.commons.httpclient.auth.InvalidCredentialsException;
import org.authz.application.AuthenticationService;
import org.authz.application.AuthzRegistry;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class SessionManager implements SessionManagerInt{
    private final Map<UUID, User> tokensUsers = new HashMap<>();
    private static SessionManager instance = null;

    /**
     * Get AuthenticationService.
     */
    private AuthenticationService authService = AuthzRegistry
            .authenticationService();

    private SessionManager(){

    }

    public static SessionManager getInstance(){
        if(instance == null){
            instance = new SessionManager();
        }

        return instance;
    }

    @Override
    public synchronized UUID login(final String email, final String password)
            throws InvalidCredentialsException {
        Optional<UserSession> session = authService
                .authenticate(email, password,
                        CourseRoles.allRoles());

        if (!session.isPresent()) {
            throw new InvalidCredentialsException("Invalid Credentials!");
        }

        UserSession userSession = session.get();

        tokensUsers.put(userSession.token(), userSession.authenticatedUser());

        return userSession.token();
    }

    @Override
    public User getUserByToken(String token) throws IllegalArgumentException{
        if(token != null){
            UUID uuidToken = UUID.fromString(token);

            return tokensUsers.get(uuidToken);
        }

        throw new IllegalArgumentException();
    }

    @Override
    public User logout(String token) {

        if(token != null) {
            UUID uuidToken = UUID.fromString(token);


            return tokensUsers.remove(uuidToken);
        }

        throw new IllegalArgumentException();
    }
}
