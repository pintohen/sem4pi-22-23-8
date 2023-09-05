package org.usermanagement.controller;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserManagementService;

import java.util.Calendar;

/**
 * Controller class for adding a new user to the system.
 */
@UseCaseController
public class AddUserController {
    /**
     * Authorization service instance.
     */
    private final AuthorizationService authz = AuthzRegistry
                                            .authorizationService();
    /**
     * User management service instance.
     */
    private final UserManagementService userSvc = AuthzRegistry.userService();


    /**
     * Add a new user to the system with the provided details.
     * @param shortName  short name of the new user.
     * @param password  password of the new user.
     * @param fullName full name of the new user.
     * @param email     email of the new user.
     * @param role     roles of the new user.
     * @param birthDate     birthdate of the new user.
     * @param taxPayerNumber     taxPayerNumber of the new user.
     * @param acronym     acronym of the new user.
     * @param createdOn creation date of the new user.
     * @return SystemUser object.
     */
    public User addUser(final String shortName, final String password,
                        final String fullName, final String email,
                        final Role role, final String birthDate,
                        final String taxPayerNumber,
                        final String acronym, final Calendar createdOn) {
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.MANAGER);

        return userSvc.registerNewUser(shortName, password, fullName,
                                    email, role, birthDate,
                                    taxPayerNumber, acronym, createdOn);
    }

    /**
     * Add a new user to the system with the provided details.
     * @param shortName  short name of the new user.
     * @param password  password of the new user.
     * @param fullName full name of the new user.
     * @param email     email of the new user.
     * @param role     roles of the new user.
     * @param birthDate     birthdate of the new user.
     * @param taxPayerNumber     taxPayerNumber of the new user.
     * @param acronym     acronym of the new user.
     * @return User
     */
    public User addUser(final String shortName, final String password,
                        final String fullName, final String email,
                        final Role role, final String birthDate,
                        final String taxPayerNumber, final String acronym) {

        return addUser(shortName, password, fullName,
                        email, role, birthDate,
                        taxPayerNumber, acronym, CurrentTimeCalendars.now());
    }
}
