package org.exam.application;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.domain.model.*;
import org.domain.model.exam.Exam;
import org.domain.model.examtemplate.ExamTemplateBuilder;
import org.domain.model.examtemplate.ExamTemplateErrorListener;
import org.domain.model.examtemplate.ExamTemplateLexer;
import org.domain.model.examtemplate.ExamTemplateParser;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.domain.model.examtemplate.domain.ExamTitle;
import org.domain.repositories.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;
import org.usermanagement.domain.repositories.UserRepository;
import repositories.ExamRepository;
import repositories.ExamTemplateRepository;

import java.io.IOException;
import java.util.*;

import static org.mockito.Mockito.*;

class ExamServiceTest {
    @Mock ExamRepository repo;
    @Mock ExamTemplateRepository templateRepo;
    @Mock CourseRepository courseRepo;

    @Mock
    UserRepository userRepo;
    private static final String STRING_SHORTNAME = "shortName";
    private static final String STRING_FULLNAME = "fullName";
    private static final String STRING_PASSWORD = "Correct5";
    private static final String STRING_EMAIL = "email@email.com";
    private static final String MEC_NUMBER = "202300001";
    private static final String STRING_ACRONYM = "TTT";
    private static final String STRING_BIRTHDATE = "16/11/2002";

    private static final String STRING_TAXPAYERNUMBER = "999999999";

    private static final String FILE_EXAM_TEMPLATE_1 = "src/test/resources/examtemplate1.txt";
    private static final String FILE_EXAM_RESOLUTION_1 = "src/test/resources/resolution_1_from_1.txt";
    private static final String FILE_EXAM_RESOLUTION_2 = "src/test/resources/resolution_2_from_1.txt";

    ECoursePasswordPolicy passwordPolicy = new ECoursePasswordPolicy();

    ExamTitle title;

    ExamTemplate template;

    ExamService service;

    User student;

    @BeforeEach
    void setUp() throws IOException {
        repo = mock(ExamRepository.class);
        templateRepo = mock(ExamTemplateRepository.class);
        courseRepo = mock(CourseRepository.class);
        userRepo = mock(UserRepository.class);

        title = ExamTitle.of("Mathematics");
        template = buildTemplate();
        student = buildStudent();

        service = new ExamService(repo, templateRepo, courseRepo);
    }

    @Test
    void testEvaluateExamFromFile() throws IOException {
        when(templateRepo.findByTitle(title)).thenReturn(Optional.of(template));

        service.evaluateExamFromFile(FILE_EXAM_RESOLUTION_1, student, title);

        verify(templateRepo, times(1)).findByTitle(title);
        verify(repo, times(1)).save(any());
    }

    @Test
    void testGetTeacherCourses(){
        final User user = buildTeacher();

        Course c1 = new Course(CourseName.of("Matemática"),
                CourseCode.of("MAT-1"),
                CourseEdition.of("INTRO-MAT-SEM01"),
                CourseDescription.of("Mathematics"),
                CourseState.of(CourseStateConstants.CLOSED.toString()),
                CourseMaxNumberLimit.of(100),
                CourseMinNumberLimit.of(10),
                user, new HashSet<>(), new HashSet<>());

        Course c2 = new Course(CourseName.of("Português"),
                CourseCode.of("PT-1"),
                CourseEdition.of("INTRO-PT-SEM01"),
                CourseDescription.of("Portuguese"),
                CourseState.of(CourseStateConstants.CLOSED.toString()),
                CourseMaxNumberLimit.of(200),
                CourseMinNumberLimit.of(10),
                user, new HashSet<>(), new HashSet<>());

        courseRepo.save(c1);
        courseRepo.save(c2);

        c1.addTeacher(user);
        c2.addTeacher(user);

        List<Course> listCoursesInside = new ArrayList<>();

        listCoursesInside.add(c1);
        listCoursesInside.add(c2);

        when(service.getTeacherCourses(user)).thenReturn(listCoursesInside);

        service.getTeacherCourses(user);

        verify(courseRepo, times(1)).findCoursesThatITeach(user);
        verify(courseRepo, times(2)).save(any());
    }

    @Test
    void listTeacherGradesTest() throws IOException {

        final User student2 = buildStudent2();

        Course c1 = template.course();

        c1.addStudent(buildStudent2());

        when(templateRepo.findByTitle(title)).thenReturn(Optional.of(template));

        Exam e1 = service.evaluateExamFromFile(FILE_EXAM_RESOLUTION_1,
                student, title);

        Exam e2 = service.evaluateExamFromFile(FILE_EXAM_RESOLUTION_2,
                student2, title);

        List<Exam> exams = new ArrayList<>();

        exams.add(e1);
        exams.add(e2);

        when(service.listTeacherGrades(c1)).thenReturn(exams);

        service.listTeacherGrades(c1);

        verify(repo, times(2)).save(any());
        verify(repo, times(1)).findGradesByCourse(c1);
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

    User buildStudent2(){
        UserBuilder userBuilder = new UserBuilder(passwordPolicy, new PlainTextEncoder());

        return userBuilder.with("Pedro","Password1","Pedro Alves","pedro@email.com", CourseRoles.STUDENT)
                .withMecanographicNumber("202300002")
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

        builder.with(createValidCourse(), buildTeacher(), new HashSet<>(Set.of(buildStudent(), buildStudent2())));

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
        course.addStudent(buildStudent());
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