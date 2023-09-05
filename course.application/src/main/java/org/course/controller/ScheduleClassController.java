package org.course.controller;

import eapli.framework.validations.Preconditions;
import org.authz.application.AuthorizationService;
import org.domain.model.Course;
import org.course.service.CourseManagementService;
import org.domain.repositories.CourseRepository;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.UserSession;

public class ScheduleClassController {

    private final AuthorizationService authz;


    private final CourseManagementService courseManagementService;

    private final CourseRepository courseRepository;

    public ScheduleClassController(final AuthorizationService authzService) {
        this.authz = authzService;
        this.courseManagementService = new CourseManagementService(PersistenceContext.repositories().users(), PersistenceContext.repositories().courses(), PersistenceContext.repositories().newTransactionalContext(), authzService);
        this.courseRepository = PersistenceContext.repositories().courses();
    }

    public Course scheduleClass(String courseCode,
                                String classTitle,
                                String dayOfWeek,
                                String startTime,
                                String endTime) {
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.TEACHER);

        Preconditions.ensure(courseCode != null, "Course code must not be null");

        UserSession session = authz.session().orElse(null);

        return courseManagementService.scheduleNewClass(courseCode, classTitle, dayOfWeek, startTime, endTime, session.authenticatedUser());
    }
}
