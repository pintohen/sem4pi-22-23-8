package org.domain.model;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ClassTest {

    private final String classTitle = "Class Title";

    private final String classDayOfWeek = "MONDAY";

    private final String classStartTime = "10:00";

    private final String classEndTime = "12:00";

    private User teacher;

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
    void setup(){
        teacher = buildTeacher();
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

    @Test
    public void testCreateValidClass() {

        ClassFactory classFactory = new ClassFactory();

        Class aClass = classFactory.createClass(classTitle, classDayOfWeek, classStartTime, classEndTime, teacher, new HashSet<>());

        assertEquals(classTitle, aClass.title().toString());
        assertEquals(classDayOfWeek, aClass.dayOfWeek().toString());
        assertEquals(classStartTime, aClass.time().startTime().toString());
        assertEquals(classEndTime, aClass.time().endTime().toString());

    }

    @Test
    public void testCreateInvalidClassWithNullClassTitle() {

        ClassFactory classFactory = new ClassFactory();
        assertThrows(NullPointerException.class,
                () -> classFactory.createClass(null, classDayOfWeek, classStartTime, classEndTime, teacher, new HashSet<>()));
    }

    @Test
    public void testCreateInvalidClassWithNullClassDay() {

        ClassFactory classFactory = new ClassFactory();
        assertThrows(NullPointerException.class,
                () -> classFactory.createClass(classTitle, null, classStartTime, classEndTime, teacher, new HashSet<>()));
    }

    @Test
    public void testCreateInvalidClassWithNullClassStartTime() {

        ClassFactory classFactory = new ClassFactory();
        assertThrows(NullPointerException.class,
                () -> classFactory.createClass(classTitle, classDayOfWeek, null, classEndTime, teacher, new HashSet<>()));
    }

    @Test
    public void testCreateInvalidClassWithNullClassEndTime() {

        ClassFactory classFactory = new ClassFactory();
        assertThrows(NullPointerException.class,
                () -> classFactory.createClass(classTitle, classDayOfWeek, classStartTime, null, teacher, new HashSet<>()));
    }

    @Test
    public void testCreateInvalidClassWithInvalidClassStartTime() {

        ClassFactory classFactory = new ClassFactory();
        assertThrows(IllegalArgumentException.class,
                () -> classFactory.createClass(classTitle, classDayOfWeek, "05:00", classEndTime, teacher, new HashSet<>()));
    }

    @Test
    public void testCreateInvalidClassWithInvalidClassEndTime() {

        ClassFactory classFactory = new ClassFactory();
        assertThrows(IllegalArgumentException.class,
                () -> classFactory.createClass(classTitle, classDayOfWeek, classStartTime, "05:00", teacher, new HashSet<>()));
    }

    @Test
    public void testCreateInvalidClassWithSameClassStartTimeAndEndTime() {

        ClassFactory classFactory = new ClassFactory();
        assertThrows(IllegalArgumentException.class,
                () -> classFactory.createClass(classTitle, classDayOfWeek, "05:00", "05:00", teacher, new HashSet<>()));
    }

    @Test
    public void testCompareTwoEqualClasses() {

        ClassFactory classFactory = new ClassFactory();
        Class aClass = classFactory.createClass(classTitle, classDayOfWeek, classStartTime, classEndTime, teacher, new HashSet<>());
        Class anotherClass = classFactory.createClass(classTitle, classDayOfWeek, classStartTime, classEndTime, teacher, new HashSet<>());

        assertEquals(aClass, anotherClass);
    }

    @Test
    public void testCompareTwoDifferentClassTitleClasses() {

        ClassFactory classFactory = new ClassFactory();
        Class aClass = classFactory.createClass(classTitle, classDayOfWeek, classStartTime, classEndTime, teacher, new HashSet<>());
        Class anotherClass = classFactory.createClass("Another Class Title", classDayOfWeek, classStartTime, classEndTime, teacher, new HashSet<>());

        assertNotEquals(aClass, anotherClass);
    }

    @Test
    public void testCompareTwoDifferentClassDayOfWeekClasses() {

        ClassFactory classFactory = new ClassFactory();
        Class aClass = classFactory.createClass(classTitle, classDayOfWeek, classStartTime, classEndTime, teacher, new HashSet<>());
        Class anotherClass = classFactory.createClass(classTitle, "TUESDAY", classStartTime, classEndTime, teacher, new HashSet<>());

        assertNotEquals(aClass, anotherClass);
    }

    @Test
    public void testCompareTwoDifferentStartTimeClasses() {

        ClassFactory classFactory = new ClassFactory();
        Class aClass = classFactory.createClass(classTitle, classDayOfWeek, classStartTime, classEndTime, teacher, new HashSet<>());
        Class anotherClass = classFactory.createClass(classTitle, classDayOfWeek, "09:00", classEndTime, teacher, new HashSet<>());

        assertNotEquals(aClass, anotherClass);
    }

    @Test
    public void testCompareTwoDifferentEndTimeClasses() {

        ClassFactory classFactory = new ClassFactory();
        Class aClass = classFactory.createClass(classTitle, classDayOfWeek, classStartTime, classEndTime, teacher, new HashSet<>());
        Class anotherClass = classFactory.createClass(classTitle, classDayOfWeek, classStartTime, "11:00", teacher, new HashSet<>());

        assertNotEquals(aClass, anotherClass);
    }

    @Test
    public void testCompareClassWithNull() {

        ClassFactory classFactory = new ClassFactory();
        Class aClass = classFactory.createClass(classTitle, classDayOfWeek, classStartTime, classEndTime, teacher, new HashSet<>());

        assertNotEquals(aClass, null);
    }

    @Test
    public void testCompareClassWithDifferentClass() {

        ClassFactory classFactory = new ClassFactory();
        Class aClass = classFactory.createClass(classTitle, classDayOfWeek, classStartTime, classEndTime, teacher, new HashSet<>());

        assertNotEquals(aClass, new Object());
    }
}