package org.enrollment.request.domain;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.domain.model.Course;
import org.domain.model.CourseFactory;
import org.domain.model.CourseStateConstants;
import org.junit.jupiter.api.Test;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;

import static org.junit.jupiter.api.Assertions.*;

class EnrollmentRequestTest {



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
    @Test
    void create() {

        user = buildStudent();
        course = createValidCourse();

        EnrollmentRequest.create(user, course);

    }

    @Test
    void ensureNotTeacher(){
        // needs to be a student
        user = buildTeacher();
        course = createValidCourse();

        assertThrows(
                IllegalArgumentException.class,
                () -> EnrollmentRequest.create(user, course)
        );
    }

    @Test
    void ensureCanOnlyEnrollIfEnrollState(){
        // needs to be in enroll state
        user = buildStudent();
        course = createInvalidCourse();

        assertThrows(
                IllegalArgumentException.class,
                () -> EnrollmentRequest.create(user, course)
        );
    }

    @Test
    void ensureCannotAcceptAlreadyAccepted(){
        // cant accept already accepted enrollment request
        user = buildStudent();
        course = createValidCourse();

        EnrollmentRequest req = EnrollmentRequest.create(user, course);

        req.accept();

        assertThrows(
                IllegalArgumentException.class,
                () -> req.accept()
        );
    }

    @Test
    void ensureCannotRejectAlreadyRejected(){
        // cant reject already rejected enrollment request
        user = buildStudent();
        course = createValidCourse();

        EnrollmentRequest req = EnrollmentRequest.create(user, course);

        req.reject();

        assertThrows(
                IllegalArgumentException.class,
                () -> req.reject()
        );
    }

    @Test
    void ensureNeedsToHaveArguments(){
        // needs to have arguments
        assertThrows(
                IllegalArgumentException.class,
                () -> EnrollmentRequest.create(null, null)
        );
    }

    @Test
    void equals(){
        user = buildStudent();
        course = createValidCourse();
        //makes sure equals is set by user and course and not memory location
        assertEquals(EnrollmentRequest.create(user, course), EnrollmentRequest.create(user, course));
        assert EnrollmentRequest.create(user, course).sameAs(EnrollmentRequest.create(user, course));

        EnrollmentRequest req = EnrollmentRequest.create(user, course);
        req.toString();
        req.identity();
        req.hashCode();
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