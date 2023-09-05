package org.enrollment.request.repositories;

import eapli.framework.domain.repositories.DomainRepository;

import org.domain.model.Course;
import org.enrollment.request.domain.EnrollmentRequest;
import org.usermanagement.domain.model.User;

import java.util.List;
import java.util.Optional;

/**
 * The interface Enrollment request repository.
 */
public interface EnrollmentRequestRepository
        extends DomainRepository<Long, EnrollmentRequest> {
    /**
     * Find by course and student enrollment request.
     *
     * @param course  the course
     * @param student the student
     * @return the enrollment request
     */
    EnrollmentRequest findByCourseAndStudent(Course course, User student);

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<EnrollmentRequest> findById(Long id);

    /**
     * Save enrollment request.
     * @param request
     * @return the enrollment request
     */
    EnrollmentRequest save(EnrollmentRequest request);

    /**
     * Find pending requests list.
     *
     * @return the list
     */
    List<EnrollmentRequest> findPendingRequests();
}
