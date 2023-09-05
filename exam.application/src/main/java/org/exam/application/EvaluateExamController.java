package org.exam.application;

import org.authz.application.AuthorizationService;
import org.domain.model.exam.Exam;
import org.domain.model.examtemplate.domain.ExamTitle;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;

import java.io.IOException;

public class EvaluateExamController {
    private AuthorizationService authzSvc;
    private ExamService examSvc;

    public EvaluateExamController(AuthorizationService authzSvc) {
        this.authzSvc = authzSvc;
        this.examSvc = new ExamService(
                PersistenceContext.repositories().exams(),
                PersistenceContext.repositories().examTemplates(),
                PersistenceContext.repositories().courses()
        );
    }

    public Exam evaluateExamFromFile(String filePath, String examTitle) throws IOException {
        authzSvc.ensureAuthenticatedUserHasAnyOf(CourseRoles.STUDENT);

        User loggedUser = authzSvc.session()
                .orElseThrow(
                        () -> new IllegalStateException(
                                "Log in needs to be done" +
                                        " in order to take an exam"
                        )
                ).authenticatedUser();

        return this.examSvc.evaluateExamFromFile(
                filePath, loggedUser, ExamTitle.of(examTitle)
        );
    }
}
