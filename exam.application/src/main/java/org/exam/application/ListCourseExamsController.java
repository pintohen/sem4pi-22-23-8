package org.exam.application;

import eapli.framework.application.UseCaseController;
import eapli.framework.validations.Preconditions;
import org.authz.application.AuthorizationService;
import org.domain.model.CourseCode;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;

@UseCaseController
public class ListCourseExamsController {

    private final ExamTemplateManagementService service;

    private final AuthorizationService authz;

    public ListCourseExamsController(
            final AuthorizationService authzServicep
    ) {
        this.authz = authzServicep;
        this.service = new ExamTemplateManagementService(
                PersistenceContext.repositories().examTemplates(),
                PersistenceContext.repositories().courses()
        );
    }

    public Iterable<ExamTemplate> listCourseExams(String courseCode) {
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.TEACHER);

        Preconditions.ensure(courseCode != null, "Course code must not be null");

        UserSession session = authz.session().orElseThrow();
        User teacher = session.authenticatedUser();

        return service.listCourseExams(CourseCode.of(courseCode), teacher);
    }
}
