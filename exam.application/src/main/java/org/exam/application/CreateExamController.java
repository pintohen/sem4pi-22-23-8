package org.exam.application;

import eapli.framework.application.UseCaseController;
import org.authz.application.AuthorizationService;
import eapli.framework.validations.Preconditions;
import org.domain.model.CourseCode;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;

import java.io.IOException;

@UseCaseController
public class CreateExamController {

    private final ExamTemplateManagementService service;

    private final AuthorizationService authz;

    public CreateExamController() {
        this.authz = null;
        this.service = null;
    }

    public CreateExamController(
            final AuthorizationService authzServicep
    ) {
        this.authz = authzServicep;
        this.service = new ExamTemplateManagementService(
                PersistenceContext.repositories().examTemplates(),
                PersistenceContext.repositories().courses()
        );
    }


    public ExamTemplate createExam(String courseCode,
                                   String filePath) throws IOException {
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.TEACHER);

        Preconditions.ensure(courseCode != null, "Course code must not be null");

        UserSession session = authz.session().orElse(null);

        assert session != null;
        User teacher = session.authenticatedUser();

        return service.createExam(filePath, CourseCode.of(courseCode), teacher);
    }


}
