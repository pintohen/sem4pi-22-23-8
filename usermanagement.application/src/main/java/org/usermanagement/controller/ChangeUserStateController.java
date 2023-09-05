package org.usermanagement.controller;

import eapli.framework.general.domain.model.EmailAddress;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserManagementService;

public class ChangeUserStateController {
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
     * Enable user.
     * @param userEmail user email to enable
     * @return User enabled
     */
    public User enableUserByEmail(final EmailAddress userEmail){
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.MANAGER);

        return userSvc.enableUser(userEmail);
    }

    /**
     * Disable user.
     * @param userEmail user email to disable
     * @return User disabled
     */
    public User disableUserByEmail(final EmailAddress userEmail){
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.MANAGER);

        return userSvc.disableUser(userEmail);
    }
}
