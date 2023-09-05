package org.domain.model.exam;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.domain.model.Course;
import org.domain.model.CourseFactory;
import org.domain.model.CourseStateConstants;
import org.domain.model.examtemplate.ExamTemplateBuilder;
import org.domain.model.examtemplate.ExamTemplateErrorListener;
import org.domain.model.examtemplate.ExamTemplateLexer;
import org.domain.model.examtemplate.ExamTemplateParser;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.junit.jupiter.api.Test;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;

import java.io.IOException;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ExamTest {


    private static final String STRING_SHORTNAME = "shortName";
    private static final String STRING_FULLNAME = "fullName";
    private static final String STRING_PASSWORD = "Correct5";
    private static final String STRING_EMAIL = "email@email.com";
    private static final String MEC_NUMBER = "202300001";
    private static final String STRING_ACRONYM = "TTT";
    private static final String STRING_BIRTHDATE = "16/11/2002";

    private static final String STRING_TAXPAYERNUMBER = "999999999";

    private static final String FILE_EXAM_TEMPLATE_1 = "src/test/resources/examtemplate1.txt";

    ECoursePasswordPolicy passwordPolicy = new ECoursePasswordPolicy();

    @Test
    void ensureExamCannotHaveNegativeGrade(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new Exam(
                        buildTemplate(),
                        buildStudent(),
                        -1.0,
                        1.0
                )
        );
    }

    @Test
    void ensureExamCannotHaveGradeHigherThanMaxGrade(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new Exam(
                        buildTemplate(),
                        buildStudent(),
                        1.0,
                        0.5
                )
        );
    }

    @Test
    void ensureExamCannotBeSolvedByATeacher(){
        assertThrows(
                IllegalArgumentException.class,
                () -> new Exam(
                        buildTemplate(),
                        buildTeacher(),
                        0.5,
                        1.0
                )
        );
    }

    @Test
    void ensureCanCreateValidExam() throws IOException {

        Exam exam;

        exam = new Exam(
                buildTemplate(),
                buildStudent(),
                0.5,
                1.0
        );

        assertEquals(10, exam.schoolGrade());
        System.out.println("<--Valid Exam-->\n" + exam.toString() + "<--Valid Exam-->\n");
    }

    @Test
    void ensureIfNotDBSavedIdentityIsNull() throws IOException {
        Exam exam = new Exam(
                buildTemplate(),
                buildStudent(),
                0.5,
                1.0
        );

        assertNull(exam.identity());
    }

    @Test
    void ensureSameAsIsWorking() throws IOException {
        Exam exam1 = new Exam(
                buildTemplate(),
                buildStudent(),
                0.5,
                1.0
        );

        Exam exam2 = new Exam(
                buildTemplate(),
                buildStudent(),
                0.5,
                1.0
        );

        assertTrue(exam1.sameAs(exam2));
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

    ExamTemplate buildTemplate() throws IOException {
        ExamTemplateLexer lexer = new ExamTemplateLexer(CharStreams.fromFileName(FILE_EXAM_TEMPLATE_1));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExamTemplateParser parser = new ExamTemplateParser(tokens);

        parser.addErrorListener(new ExamTemplateErrorListener());

        ParseTree tree = parser.start();
        ParseTreeWalker walker = new ParseTreeWalker();
        ExamTemplateBuilder builder = new ExamTemplateBuilder();

        builder.with(createValidCourse(), buildTeacher(), new HashSet<>());

        walker.walk(builder, tree);

        return builder.build();
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


}