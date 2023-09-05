package org.exam.application;

import eapli.framework.application.UseCaseController;
import org.authz.application.AuthorizationService;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.domain.model.examtemplate.domain.ExamTitle;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;

import java.io.IOException;

@UseCaseController
public class UpdateExamController {

    private final ExamTemplateManagementService service;


    private final AuthorizationService authz;

    public UpdateExamController() {
        this.authz = null;
        this.service = null;
    }

    public UpdateExamController(
            final AuthorizationService authzServicep
    ) {
        this.authz = authzServicep;
        this.service = new ExamTemplateManagementService(
                PersistenceContext.repositories().examTemplates(),
                PersistenceContext.repositories().courses()
        );
    }

    public ExamTemplate updateExam(String title,
                                   String filePath) throws IOException  {
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.TEACHER);

        UserSession session = authz.session().orElse(null);

        assert session != null;
        User teacher = session.authenticatedUser();

        return service.updateExam(ExamTitle.of(title), filePath, teacher);
    }

}
