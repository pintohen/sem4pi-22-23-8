package org.course.controller;

import eapli.framework.application.UseCaseController;
import org.domain.model.Course;
import org.domain.repositories.CourseRepository;
import org.persistence.PersistenceContext;
import org.usermanagement.domain.model.User;

import java.util.List;

@UseCaseController
public class RetrieveCoursesController {

    private final CourseRepository repo;

    public RetrieveCoursesController(CourseRepository repo) {
        this.repo = repo;
    }

    public Iterable<Course> getAllCourses(){
        return repo.findAll();
    }

    public Iterable<Course> getCoursesThatITeach(User teacher){
        return repo.findCoursesThatITeach(teacher);
    }

    public Iterable<Course> getCoursesThatILead(User teacher){
        return repo.findCoursesThatILead(teacher);
    }

    public Iterable<Course> getCoursesAvailableForStudent(User student){
        List<Course> courses = (List<Course>) repo.findOpenForEnrolment();

        courses.removeAll((List<Course>) getCoursesTakenByStudent(student));

        return courses;
    }

    public Iterable<Course> getCoursesTakenByStudent(User student){
        return repo.findCoursesTakenByStudent(student);
    }

}
