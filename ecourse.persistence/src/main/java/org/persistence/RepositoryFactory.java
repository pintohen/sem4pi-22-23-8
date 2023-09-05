package org.persistence;

import eapli.framework.domain.repositories.TransactionalContext;
import org.domain.repositories.BoardRepository;
import org.domain.repositories.CourseRepository;
import org.enrollment.request.repositories.EnrollmentRequestRepository;
import org.usermanagement.domain.repositories.UserRepository;
import repositories.ExamRepository;
import repositories.ExamTemplateRepository;
import repositories.PostItRepository;
import repositories.TemplateFormativeQuestionRepository;

public interface RepositoryFactory {
    /**
     * Create a Transactional Context.
     * @return TransactionalContext
     */
    TransactionalContext newTransactionalContext();

    /**
     * For configure persistence context.
     * @return UserRepository
     */
     UserRepository users();

    /**
     * For configure persistence context.
     * @return CourseRepository
     */
    CourseRepository courses();

    /**
     * For configure persistence context.
     * @return BoardRepository
     */
    BoardRepository boards();

    /**
     * For configure persistence context.
     * @return EnrollmentRequestRepository
     */
    EnrollmentRequestRepository enrollmentRequests();

    /**
     * For configure persistence context.
     * @return ExamRepository
     */
    ExamTemplateRepository examTemplates();

    TemplateFormativeQuestionRepository formativeQuestions();

    ExamRepository exams();

    /**
     * For configure persistence context.
     * @return PostItRepository
     */
    PostItRepository postIt();
}
