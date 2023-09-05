package org.enrollment.request.application;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.domain.model.Course;
import org.domain.model.CourseCode;
import org.domain.model.CourseFactory;
import org.domain.model.CourseStateConstants;
import org.domain.repositories.CourseRepository;
import org.enrollment.request.repositories.EnrollmentRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.enrollment.request.domain.EnrollmentRequest;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class EnrollmentRequestManagementServiceTest {


    @Mock CourseRepository courseRepo;
    @Mock
    EnrollmentRequestRepository enrollmentRequestRepo;


    @Mock CourseCode courseCode;

    @Mock EnrollmentRequest request;


    EnrollmentRequestManagementService service;

    User user;
    Course course;
    private static final String STRING_SHORTNAME = "shortName";
    private static final String STRING_FULLNAME = "fullName";
    private static final String STRING_PASSWORD = "Correct5";
    private static final String STRING_EMAIL = "email@email.com";
    private static final String MEC_NUMBER = "202300001";
    private static final String STRING_ACRONYM = "TTT";
    private static final String STRING_BIRTHDATE = "16/11/2002";

    private static final String STRING_TAXPAYERNUMBER = "999999999";

    ECoursePasswordPolicy passwordPolicy = new ECoursePasswordPolicy();

    @BeforeEach
    void setUp() {
        courseCode = mock(CourseCode.class);
        this.request = mock(EnrollmentRequest.class);

        courseRepo = mock(CourseRepository.class);
        enrollmentRequestRepo = mock(EnrollmentRequestRepository.class);

        service = new EnrollmentRequestManagementService(
                courseRepo,
                enrollmentRequestRepo
        );
    }

    @Test
    void createRequest() {
        user = buildStudent();
        course = createValidCourse();


        when(courseRepo.findByCode(courseCode)).thenReturn(Optional.of(course));
        when(enrollmentRequestRepo.findByCourseAndStudent(course, user)).thenReturn(null);
        when(enrollmentRequestRepo.save(any())).thenReturn(this.request);

        service.createRequest(courseCode, user);

        verify(courseRepo).findByCode(courseCode);
        verify(enrollmentRequestRepo).findByCourseAndStudent(course, user);
        verify(enrollmentRequestRepo).save(any());
    }

    @Test
    void acceptRequest() {
        EnrollmentRequest request = mock(EnrollmentRequest.class);

        when(enrollmentRequestRepo.save(request)).thenReturn(request);

        service.acceptRequest(request);

        verify(request).accept();
        verify(enrollmentRequestRepo).save(request);
        verify(courseRepo).save(request.course());
    }

    @Test
    void rejectRequest() {
        EnrollmentRequest request = mock(EnrollmentRequest.class);

        when(enrollmentRequestRepo.save(request)).thenReturn(request);

        service.rejectRequest(request);

        verify(request).reject();
        verify(enrollmentRequestRepo).save(request);
        verifyNoInteractions(courseRepo);
    }

    User buildStudent(){
        UserBuilder userBuilder = new UserBuilder(passwordPolicy, new PlainTextEncoder());

        return userBuilder.with(STRING_SHORTNAME,
                        STRING_PASSWORD,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        CourseRoles.STUDENT)
                .withMecanographicNumber(MEC_NUMBER)
                .build();
    }

    User buildTeacher(){

        UserBuilder userBuilder = new UserBuilder(passwordPolicy, new PlainTextEncoder());

        return userBuilder.with(STRING_SHORTNAME,
                            STRING_PASSWORD,
                            STRING_FULLNAME,
                            STRING_EMAIL,
                            CourseRoles.TEACHER)
                    .withAcronym(STRING_ACRONYM)
                    .build();
    }

    Course createValidCourse(){
        CourseFactory factory = new CourseFactory();
        Course course = factory.createCourse(
                "Test Course",
                "TC",
                "Test Course Edition",
                "TCE",
                100,
                10,
                buildTeacher()
        );
        course.changeState(CourseStateConstants.ENROLL);
        return course;
    }



    Course createInvalidCourse(){
        CourseFactory factory = new CourseFactory();
        Course course = factory.createCourse(
                "Test Course",
                "TC",
                "Test Course Edition",
                "TCE",
                100,
                10,
                buildTeacher()
        );
        return course;
    }
}