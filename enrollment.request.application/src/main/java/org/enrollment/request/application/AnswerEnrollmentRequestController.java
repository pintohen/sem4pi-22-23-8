package org.enrollment.request.application;

import eapli.framework.application.UseCaseController;
import org.authz.application.AuthorizationService;
import org.enrollment.request.domain.EnrollmentRequest;
import org.enrollment.request.repositories.EnrollmentRequestRepository;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;

import java.util.List;


/**
 * The type Answer enrollment request controller.
 */
@UseCaseController
public class AnswerEnrollmentRequestController {

    /**
     * The Service.
     */
    private final EnrollmentRequestManagementService service;
    /**
     * The Enrollment request repo.
     */
    private final EnrollmentRequestRepository enrollmentRequestRepo;
    /**
     * The Authz svc.
     */
    private final AuthorizationService authzSvc;

    /**
     * Instantiates a new Answer enrollment request controller.
     *
     * @param enrollmentRequestRepop the enrollment request repo
     * @param authzSvcp              the authz svc
     */
    public AnswerEnrollmentRequestController(
            final EnrollmentRequestRepository enrollmentRequestRepop,
            final AuthorizationService authzSvcp
    ) {
        this.enrollmentRequestRepo = enrollmentRequestRepop;

        this.service = new EnrollmentRequestManagementService(
                PersistenceContext.repositories().courses(),
                this.enrollmentRequestRepo
        );

        this.authzSvc = authzSvcp;
    }

    /**
     * Accept enrollment request.
     *
     * @param request the request
     * @return the enrollment request
     */
    public EnrollmentRequest acceptRequest(final EnrollmentRequest request) {
        authzSvc.ensureAuthenticatedUserHasAnyOf(CourseRoles.MANAGER);
        return this.service.acceptRequest(request);
    }

    /**
     * Reject enrollment request.
     *
     * @param request the request
     * @return the enrollment request
     */
    public EnrollmentRequest rejectRequest(final EnrollmentRequest request) {
        authzSvc.ensureAuthenticatedUserHasAnyOf(CourseRoles.MANAGER);
        return this.service.rejectRequest(request);
    }

    /**
     * Get pending requests.
     *
     * @return the list
     */
    public List<EnrollmentRequest> getPendingRequests() {
        authzSvc.ensureAuthenticatedUserHasAnyOf(CourseRoles.MANAGER);
        return this.enrollmentRequestRepo.findPendingRequests();
    }
}
