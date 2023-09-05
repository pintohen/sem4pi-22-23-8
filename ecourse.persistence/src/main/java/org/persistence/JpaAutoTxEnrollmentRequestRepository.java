package org.persistence;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.domain.model.Course;
import org.enrollment.request.domain.EnrollmentRequest;
import org.enrollment.request.domain.RequestState;
import org.enrollment.request.repositories.EnrollmentRequestRepository;
import org.usermanagement.domain.model.User;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * The type Jpa auto tx enrollment request repository.
 */
public class JpaAutoTxEnrollmentRequestRepository
        extends JpaAutoTxRepository<EnrollmentRequest, Long, Long>
        implements EnrollmentRequestRepository {


    /**
     * Instantiates a new Jpa auto tx enrollment request repository.
     *
     * @param persistenceUnitName the persistence unit name
     * @param identityFieldName   the identity field name
     */
    public JpaAutoTxEnrollmentRequestRepository(
            final String persistenceUnitName,
            final String identityFieldName
    ) {
        super(persistenceUnitName, identityFieldName);
    }

    /**
     * Instantiates a new Jpa auto tx enrollment request repository.
     *
     * @param persistenceUnitName the persistence unit name
     * @param properties          the properties
     * @param identityFieldName   the identity field name
     */
    public JpaAutoTxEnrollmentRequestRepository(
            final String persistenceUnitName,
            final Map properties,
            final String identityFieldName
    ) {
        super(persistenceUnitName, properties, identityFieldName);
    }

    /**
     * Instantiates a new Jpa auto tx enrollment request repository.
     *
     * @param tx                the tx
     * @param identityFieldName the identity field name
     */
    public JpaAutoTxEnrollmentRequestRepository(
            final TransactionalContext tx,
            final String identityFieldName
    ) {
        super(tx, identityFieldName);
    }

    /**
     * Instantiates a new Jpa auto tx enrollment request repository.
     *
     * @param persistenceUnitName the persistence unit name
     * @param properties          the properties
     */
    public JpaAutoTxEnrollmentRequestRepository(
            final String persistenceUnitName,
            final Map properties
    ) {
        super(persistenceUnitName, properties, "id");
    }

    /**
     * find enrollment request by course and student.
     * @param course  the course
     * @param student the student
     * @return
     */
    @Override
    public EnrollmentRequest findByCourseAndStudent(
            final Course course,
            final User student
    ) {
        TypedQuery<EnrollmentRequest> query = createQuery(
                "SELECT er FROM EnrollmentRequest er WHERE er.student = :student AND er.course = :course",
                EnrollmentRequest.class
        );

        query.setParameter("student", student);
        query.setParameter("course", course);

        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * find enrollment request by id.
     * @param id the id
     * @return
     */
    @Override
    public Optional<EnrollmentRequest> findById(final Long id) {
        return this.repo.findById(id);
    }

    /**
     * save enrollment request.
     * @param request
     * @return
     */
    @Override
    public EnrollmentRequest save(final EnrollmentRequest request) {
        return this.repo.save(request);
    }

    /**
     * find pending requests.
     * @return
     */
    @Override
    public List<EnrollmentRequest> findPendingRequests() {
        TypedQuery<EnrollmentRequest> query = createQuery(
                "SELECT er FROM EnrollmentRequest er WHERE er.state = :state",
                EnrollmentRequest.class
        );

        query.setParameter("state", RequestState.PENDING);

        return query.getResultList();
    }

    /**
     * find all enrollment requests.
     * @return
     */
    @Override
    public Iterable<EnrollmentRequest> findAll() {
        return this.repo.findAll();
    }

    /**
     * find enrollment request by identity.
     * @param id
     * @return
     */
    @Override
    public Optional<EnrollmentRequest> ofIdentity(final Long id) {
        return this.repo.ofIdentity(id);
    }

    /**
     * delete enrollment request.
     * @param entity
     */
    @Override
    public void delete(final EnrollmentRequest entity) {
        this.repo.delete(entity);
    }

    /**
     * delete enrollment request by identity.
     * @param entityId
     */
    @Override
    public void deleteOfIdentity(final Long entityId) {
        this.repo.deleteOfIdentity(entityId);
    }

    /**
     * count enrollment requests.
     * @return
     */
    @Override
    public long count() {
        return this.repo.count();
    }
}
