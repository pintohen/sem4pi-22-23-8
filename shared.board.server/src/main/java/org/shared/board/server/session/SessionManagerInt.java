package org.shared.board.server.session;

import org.apache.commons.httpclient.auth.InvalidCredentialsException;
import org.usermanagement.domain.model.User;

import java.util.UUID;

public interface SessionManagerInt {
    UUID login(final String email, final String password) throws InvalidCredentialsException;

    User getUserByToken(String token) throws IllegalArgumentException;

    User logout(String token);
}
