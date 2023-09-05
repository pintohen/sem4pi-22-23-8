package org.exam.application;

import org.authz.application.AuthorizationService;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;

public class ListFutureExamsController {

    private final ExamTemplateManagementService service;

    private final AuthorizationService authz;

    public ListFutureExamsController(
            final AuthorizationService authzServicep
    ) {
        this.authz = authzServicep;
        this.service = new ExamTemplateManagementService(
                PersistenceContext.repositories().examTemplates(),
                PersistenceContext.repositories().courses()
        );
    }

    public Iterable<ExamTemplate> listFutureExams() {

        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.STUDENT);

        UserSession session = authz.session().orElse(null);

        assert session != null;
        User student = session.authenticatedUser();

        return service.listFutureExams(student);

    }
}
