package org.bootstrappers;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import org.domain.model.CourseCode;
import org.enrollment.request.application.EnrollmentRequestManagementService;
import org.enrollment.request.domain.EnrollmentRequest;
import org.persistence.PersistenceContext;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.repositories.UserRepository;

/**
 * The type Enrollment requests bootstrapper base.
 */
public class EnrollmentRequestsBootstrapperBase {
    /**
     * The User repo.
     */
    private final UserRepository userRepo =
            PersistenceContext.repositories().users();
    /**
     * The Service.
     */
    private final EnrollmentRequestManagementService service =
            new EnrollmentRequestManagementService(
            PersistenceContext.repositories().courses(),
            PersistenceContext.repositories().enrollmentRequests());


    /**
     * Find user by email user.
     *
     * @param email the email
     * @return the user
     */
    protected User findUserByEmail(final String email) {
        return userRepo.findUserByEmail(
                EmailAddress.valueOf(email)
        ).get();
    }

    /**
     * Create enrollment request.
     *
     * @param courseCode the course code
     * @param student    the student
     * @return the enrollment request
     */
    protected EnrollmentRequest createRequest(
            final String courseCode,
            final User student
    ) {

        EnrollmentRequest request = null;

        try {

             request = service.createRequest(
                    CourseCode.of(courseCode),
                    student
             );

            System.out.println(
                    "[+] EnrollmentRequest from "
                            + student.emailAddress()
                            + " to " + courseCode
            );

        } catch (final IntegrityViolationException
                | ConcurrencyException e) {
            System.out.println(
                    "[-] Error creating EnrollmentRequest from "
                            + student.emailAddress()
                            + " to " + courseCode
            );
        } catch (final Exception e) {
            System.out.println(
                    "[-] Error creating EnrollmentRequest from "
                            + student.emailAddress()
                            + " to " + courseCode
            );
        }
        return request;
    }
}
