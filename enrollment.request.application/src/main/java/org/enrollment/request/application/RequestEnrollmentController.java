package org.enrollment.request.application;

import eapli.framework.application.UseCaseController;
import org.authz.application.AuthorizationService;
import org.domain.model.CourseCode;
import org.persistence.PersistenceContext;
import org.enrollment.request.domain.EnrollmentRequest;
import org.user.management.CourseRoles;

/**
 * The type Request enrollment controller.
 */
@UseCaseController
public class RequestEnrollmentController {

    /**
     * The Service.
     */
    private final EnrollmentRequestManagementService service;
    /**
     * The Authz service.
     */
    private final AuthorizationService authzService;

    /**
     * Instantiates a new Request enrollment controller.
     *
     * @param authzServicep the authz service
     */
    public RequestEnrollmentController(
            final AuthorizationService authzServicep
    ) {
        this.authzService = authzServicep;
        this.service = new EnrollmentRequestManagementService(
                PersistenceContext.repositories().courses(),
                PersistenceContext.repositories().enrollmentRequests()
        );
    }


    /**
     * Create enrollment request.
     *
     * @param courseCodeString the course code string
     * @return the enrollment request
     */
    public EnrollmentRequest createRequest(final String courseCodeString) {
        authzService.ensureAuthenticatedUserHasAnyOf(CourseRoles.STUDENT);
        return this.service.createRequest(
                CourseCode.of(courseCodeString),
                authzService
                        .session()
                        .orElseThrow(
                            () -> new IllegalArgumentException(
                                    "There is no user Logged."
                            )
                        )
                        .authenticatedUser()
        );
    }
}
