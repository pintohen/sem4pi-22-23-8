package org.course.controller;

import eapli.framework.application.UseCaseController;
import org.authz.application.AuthzRegistry;
import org.domain.model.Course;
import org.domain.model.CourseCode;
import org.course.service.CourseManagementService;
import org.domain.repositories.CourseRepository;
import org.persistence.PersistenceContext;
import org.usermanagement.domain.model.User;

import java.util.Set;
@UseCaseController
public class AddCourseTeacherController {

    private final CourseRepository repo;
    private final CourseManagementService service;
    public AddCourseTeacherController(){
        repo = PersistenceContext.repositories().courses();
        service = new CourseManagementService(PersistenceContext.repositories().users(),
                repo,
                PersistenceContext.repositories().newTransactionalContext(),
                AuthzRegistry.authorizationService());
    }

    public Course verifyCourse(String course){
        return repo.findByCode(CourseCode.of(course)).get();
    }

    public Set<User> getTeachersAvailable(Course course){
        return service.getTeachersAvailable(course);
    }

    public Course addTeacherToCourse(Course course, User teacher){
        return service.addTeacher(teacher, course);
    }
}