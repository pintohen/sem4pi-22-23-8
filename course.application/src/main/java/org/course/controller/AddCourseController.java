package org.course.controller;

import eapli.framework.application.UseCaseController;
import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import org.authz.application.AuthorizationService;
import org.course.service.CourseManagementService;
import org.domain.model.*;
import org.domain.repositories.CourseRepository;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.repositories.UserRepository;

/**
 * The type Add course controller.
 */
@UseCaseController
public class AddCourseController {

    /**
     * The authorization service for managing user authorization.
     */
    private final AuthorizationService authz;
    /**
     * The repository for managing course entities.
     */
    private final CourseRepository repo;

    /**
     * The repository for managing user entities.
     */
    private final UserRepository userRepo;

    /**
     * The service for creating course entities.
     */
    private final CourseManagementService service;

    private final TransactionalContext txt;

    /**
     *
     * @param repo
     * @param users
     * @param authz
     */

    public AddCourseController(final CourseRepository repo, final UserRepository users,
                               final TransactionalContext txt, final AuthorizationService authz){
        this.authz = authz;
        this.repo = repo;
        this.userRepo = users;
        this.txt = txt;
        service = new CourseManagementService(users, repo, txt, authz);
    }
    /**
     * Add course course.
     *
     * @param name        the name
     * @param code        the code
     * @param edition     the edition
     * @param description the description
     * @param max         the max
     * @param min         the min
     * @param headTeacher the head teacher
     * @return the course
     */
    public Course addCourse(final String name,
                            final String code,
                            final String edition,
                            final String description,
                            final Integer max,
                            final Integer min,
                            final String headTeacher) {

        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.MANAGER);

        User teacher = userRepo.findUserByEmail(
                        EmailAddress.valueOf(headTeacher)
                )
                .orElse(null);

        final Course course = service.createCourse(name, code, edition,
                description, max, min, teacher);

        return course;
    }
}
