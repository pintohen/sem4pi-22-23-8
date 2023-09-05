package org.persistence;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.domain.model.Course;
import org.domain.model.exam.Exam;
import org.usermanagement.domain.model.User;
import repositories.ExamRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

public class JpaAutoTxExamRepository
    extends JpaAutoTxRepository<Exam, Long, Long>
        implements ExamRepository{

    public JpaAutoTxExamRepository(String persistenceUnitName, String identityFieldName) {
        super(persistenceUnitName, identityFieldName);
    }

    public JpaAutoTxExamRepository(String persistenceUnitName, Map properties) {
        super(persistenceUnitName, properties, "id");
    }

    public JpaAutoTxExamRepository(TransactionalContext tx, String identityFieldName) {
        super(tx, identityFieldName);
    }

    @Override
    public Exam save(Exam exam) {
        return this.repo.save(exam);
    }

    @Override
    public Iterable<Exam> findGradesByStudentEmail(User student) {
        TypedQuery<Exam> query = createQuery(
                "SELECT e FROM Exam e WHERE e.student.email = :email",
                Exam.class
        );
        query.setParameter("email", student.identity());
        try {
            return query.getResultList();
        } catch (NoResultException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Iterable<Exam> findGradesByCourse(Course course){
        TypedQuery<Exam> query = createQuery(
                "SELECT e FROM Exam e WHERE e.examTemplate.course = :course",
                Exam.class
        );
        query.setParameter("course", course);
        try {
            return query.getResultList();
        } catch (NoResultException e){
            return new ArrayList<>();
        }
    }

    @Override
    public boolean containsOfIdentity(Long id) {
        return ExamRepository.super.containsOfIdentity(id);
    }

    @Override
    public boolean contains(Exam entity) {
        return ExamRepository.super.contains(entity);
    }

    @Override
    public long size() {
        return this.repo.size();
    }

    @Override
    public void remove(Exam entity) {
        this.repo.delete(entity);
    }

    @Override
    public void removeOfIdentity(Long entityId) {
        this.repo.deleteOfIdentity(entityId);
    }

    @Override
    public void forEach(Consumer<? super Exam> action) {
        super.forEach(action);
    }

    @Override
    public Spliterator<Exam> spliterator() {
        return super.spliterator();
    }
}
