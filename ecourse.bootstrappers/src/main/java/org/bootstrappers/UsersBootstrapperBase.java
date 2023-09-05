package org.bootstrappers;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.usermanagement.controller.AddUserController;
import org.usermanagement.domain.model.User;

public class UsersBootstrapperBase {
    /**
     * Instance Add User Controller.
     */
    private final AddUserController userController = new AddUserController();

    /**
     * User Bootstrapper Base Constructor.
     */
    public UsersBootstrapperBase() {
        super();
    }

    /**
     * Register user for boostrap.
     * @param shortName
     * @param password
     * @param fullName
     * @param email
     * @param role
     * @param birthDate
     * @param taxPayerNumber
     * @param acronym
     * @return User
     */
    protected User registerUser(final String shortName, final String password,
                                final String fullName, final String email,
                                final Role role, final String birthDate,
                                final String taxPayerNumber,
                                final String acronym) {
        User u = null;

        try {
            u = userController.addUser(shortName, password, fullName,
                    email, role, birthDate, taxPayerNumber, acronym);

            System.out.println("[+] " + email);
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("Already exist --> " + email);
        }

        return u;
    }
}
