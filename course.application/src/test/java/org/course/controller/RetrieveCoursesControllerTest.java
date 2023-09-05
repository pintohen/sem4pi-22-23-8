package org.course.controller;

import org.domain.model.Course;
import org.domain.repositories.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.usermanagement.domain.model.User;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class RetrieveCoursesControllerTest {
    @Mock
    CourseRepository repoMock;

    RetrieveCoursesController ctrl;
    Iterable<Course> courses;
    User user;

    @BeforeEach
    void setUp() {
        repoMock = mock(CourseRepository.class);

        ctrl = new RetrieveCoursesController(repoMock);

        courses = new ArrayList<>();

        user = mock(User.class);
    }

    @Test
    void getAllCourses() {
        when(repoMock.findAll())
                .thenReturn(courses);

        ctrl.getAllCourses();

        verify(repoMock)
                .findAll();
    }

    @Test
    void getCoursesThatITeach() {
        when(repoMock.findCoursesThatITeach(user))
                .thenReturn(courses);

        ctrl.getCoursesThatITeach(user);

        verify(repoMock)
                .findCoursesThatITeach(user);
    }

    @Test
    void getCoursesThatILead() {
        when(repoMock.findCoursesThatILead(user))
                .thenReturn(new ArrayList<>());

        ctrl.getCoursesThatILead(user);

        verify(repoMock)
                .findCoursesThatILead(user);
    }

    @Test
    void getCoursesAvailableForStudent() {



        when(repoMock.findOpenForEnrolment())
                .thenReturn(courses);
        when(repoMock.findCoursesTakenByStudent(user))
                .thenReturn(courses);

        ctrl.getCoursesAvailableForStudent(user);

        verify(repoMock)
                .findOpenForEnrolment();
        verify(repoMock)
                .findCoursesTakenByStudent(user);
    }

    @Test
    void getCoursesTakenByStudent() {
        when(repoMock.findCoursesTakenByStudent(user))
                .thenReturn(courses);

        ctrl.getCoursesTakenByStudent(user);

        verify(repoMock)
                .findCoursesTakenByStudent(user);
    }

}