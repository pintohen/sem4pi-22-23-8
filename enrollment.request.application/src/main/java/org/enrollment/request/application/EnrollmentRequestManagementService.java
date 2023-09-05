package org.enrollment.request.application;

import eapli.framework.validations.Preconditions;
import org.domain.model.Course;
import org.domain.model.CourseCode;
import org.domain.repositories.CourseRepository;
import org.enrollment.request.repositories.EnrollmentRequestRepository;
import org.enrollment.request.domain.EnrollmentRequest;
import org.springframework.stereotype.Service;
import org.usermanagement.domain.model.User;

/**
 * The type Enrollment request management service.
 */
@Service
public class EnrollmentRequestManagementService {
    /**
     * The Course repo.
     */
    private final CourseRepository courseRepo;
    /**
     * The Enrollment request repo.
     */

    private final EnrollmentRequestRepository enrollmentRequestRepo;

    /**
     * Instantiates a new Enrollment request management service.
     *
     * @param courseRepop            the course repo
     * @param enrollmentRequestRepop the enrollment request repo
     */
    public EnrollmentRequestManagementService(
            final CourseRepository courseRepop,
            final EnrollmentRequestRepository enrollmentRequestRepop
    ) {
        this.courseRepo = courseRepop;
        this.enrollmentRequestRepo = enrollmentRequestRepop;
    }

    /**
     * Create enrollment request.
     *
     * @param courseCode the course code
     * @param student    the student
     * @return the enrollment request
     */
    public EnrollmentRequest createRequest(
            final CourseCode courseCode,
            final User student
    ) {

        Course course = this.courseRepo
                .findByCode(courseCode)
                .orElseThrow(
                        () -> new IllegalArgumentException(
                                "Course with code "
                                        + courseCode.value()
                                        + " does not exist"
                        )
                );

        Preconditions.ensure(
                this
                        .enrollmentRequestRepo
                        .findByCourseAndStudent(course, student) == null,
                "Student "
                        + student.identity()
                        + " already requested to enroll in "
                        + courseCode.value()
                        + " course."
        );

        EnrollmentRequest request = EnrollmentRequest.create(student, course);

        return this.enrollmentRequestRepo.save(request);
    }

    /**
     * Accept enrollment request.
     *
     * @param request the request
     * @return the enrollment request
     */
    public EnrollmentRequest acceptRequest(final EnrollmentRequest request) {

        request.accept();

        EnrollmentRequest reflection = this.enrollmentRequestRepo.save(request);

        this.courseRepo.save(request.course());

        return reflection;
    }

    /**
     * Reject enrollment request.
     *
     * @param request the request
     * @return the enrollment request
     */
    public EnrollmentRequest rejectRequest(final EnrollmentRequest request) {
        request.reject();

        return this.enrollmentRequestRepo.save(request);
    }

}
