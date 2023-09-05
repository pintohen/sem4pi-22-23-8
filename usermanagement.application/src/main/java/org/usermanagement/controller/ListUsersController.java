package org.usermanagement.controller;

import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserManagementService;

public class ListUsersController {
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
     * Manager want to list all users.
     * @return Iterable<User>
     */
    public Iterable<User> listAllUsers(){
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.MANAGER);

        return userSvc.allUsers();
    }
}
