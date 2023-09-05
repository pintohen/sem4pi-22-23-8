package org.user.management;

import eapli.framework.infrastructure.authz.domain.model.Role;

/**
 * All users can create and use boards as well as meetings.
 */
public final class CourseRoles {

    /**
     * Ensures Utility class.
     */
    private CourseRoles() {
        // utility class
    }
    /**
     * Manages everything within the system.
     */
    public static final Role MANAGER = Role.valueOf("MANAGER");

    /**
     * Enrolls in course and takes exams.
     */
    public static final Role TEACHER = Role.valueOf("TEACHER");

    /**
     * Teaches and schedules the classes enrolled to and creates exam.
     */
    public static final Role STUDENT = Role.valueOf("STUDENT");

    /**
     * Get available roles in eCourse.
     * @return all User roles
     */
    public static Role[] allRoles() {
        return new Role[] {MANAGER, TEACHER, STUDENT};
    }
}
