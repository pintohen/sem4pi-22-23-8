package org.exam.application;

import org.authz.application.AuthorizationService;
import org.domain.model.exam.Exam;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;

public class ListExamGradesController {

    private final ExamService service;

    private final AuthorizationService authz;

    public ListExamGradesController(
            final AuthorizationService authzServicep
    ) {
        this.authz = authzServicep;
        this.service = new ExamService(
                PersistenceContext.repositories().exams(),
                PersistenceContext.repositories().examTemplates(),
                PersistenceContext.repositories().courses()
        );
    }

    public Iterable<Exam> listExamGrades() {

        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.STUDENT);

        UserSession session = authz.session().orElse(null);

        assert session != null;
        User student = session.authenticatedUser();

        return service.listExamGrades(student);

    }

}
