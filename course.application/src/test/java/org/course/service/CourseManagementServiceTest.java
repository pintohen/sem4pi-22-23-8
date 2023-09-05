package org.course.service;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.authz.application.AuthorizationService;
import org.domain.model.*;
import org.domain.repositories.CourseRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;
import org.usermanagement.domain.repositories.UserRepository;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

public class CourseManagementServiceTest {
    @Mock
    CourseRepository repo;

    @Mock
    UserRepository userRepo;

    @Mock
    TransactionalContext txt;

    UserBuilder builder;

    @InjectMocks
    CourseManagementService service;

    User user;

    @BeforeEach
    void setUp() {
        user = mock(User.class);

        userRepo = mock(UserRepository.class);

        repo = mock(CourseRepository.class);

        txt = mock(TransactionalContext.class);

        builder = new UserBuilder(new ECoursePasswordPolicy(),
                new PlainTextEncoder());

        service = new CourseManagementService(userRepo, repo, txt, new AuthorizationService());
    }
    @Test
    void confirmForEnrollmentClosedTest(){
        builder.with("Pedro","Password1","Pedro Alves","pedro@email.com", "23/05/2002", CourseRoles.TEACHER,"333333333")
                .createdOn(Calendar.getInstance())
                .withAcronym("PPA");

        final User user = builder.build();

        userRepo.save(user);

        when(userRepo.findUserByEmail(EmailAddress.valueOf("pedro@email.com"))).thenReturn(Optional.of(user));

        Course c1 = new Course(CourseName.of("Matemática"),
                CourseCode.of("MAT-1"),
                CourseEdition.of("INTRO-MAT-SEM01"),
                CourseDescription.of("Mathematics"),
                CourseState.of(CourseStateConstants.CLOSED.toString()),
                CourseMaxNumberLimit.of(100),
                CourseMinNumberLimit.of(10),
                user, new HashSet<>(), new HashSet<>());

        assertThrows(IllegalArgumentException.class,()-> service.confirmForEnrollment(c1));
    }

    @Test
    void confirmForEnrollmentInProgressTest(){
        builder.with("Pedro","Password1","Pedro Alves","pedro@email.com", "23/05/2002", CourseRoles.TEACHER,"333333333")
                .createdOn(Calendar.getInstance())
                .withAcronym("PPA");

        final User user = builder.build();

        userRepo.save(user);

        when(userRepo.findUserByEmail(EmailAddress.valueOf("pedro@email.com"))).thenReturn(Optional.of(user));

        Course c1 = new Course(CourseName.of("Matemática"),
                CourseCode.of("MAT-1"),
                CourseEdition.of("INTRO-MAT-SEM01"),
                CourseDescription.of("Mathematics"),
                CourseState.of(CourseStateConstants.IN_PROGRESS.toString()),
                CourseMaxNumberLimit.of(100),
                CourseMinNumberLimit.of(10),
                user, new HashSet<>(), new HashSet<>());

        assertThrows(IllegalArgumentException.class,()-> service.confirmForEnrollment(c1));
    }
    @Test
    void confirmForOpenCloseOpenedTest(){
        builder.with("Pedro","Password1","Pedro Alves","pedro@email.com", "23/05/2002", CourseRoles.TEACHER,"333333333")
                .createdOn(Calendar.getInstance())
                .withAcronym("PPA");

        final User user = builder.build();

        userRepo.save(user);

        when(userRepo.findUserByEmail(EmailAddress.valueOf("pedro@email.com"))).thenReturn(Optional.of(user));

        Course c1 = new Course(CourseName.of("Matemática"),
                CourseCode.of("MAT-1"),
                CourseEdition.of("INTRO-MAT-SEM01"),
                CourseDescription.of("Mathematics"),
                CourseState.of(CourseStateConstants.OPEN.toString()),
                CourseMaxNumberLimit.of(100),
                CourseMinNumberLimit.of(10),
                user, new HashSet<>(), new HashSet<>());

        assertThrows(IllegalArgumentException.class,()-> service.confirmForOpenClose(c1));
    }
    @Test
    void confirmForOpenCloseEnrollTest(){
        builder.with("Pedro","Password1","Pedro Alves","pedro@email.com", "23/05/2002", CourseRoles.TEACHER,"333333333")
                .createdOn(Calendar.getInstance())
                .withAcronym("PPA");

        final User user = builder.build();

        userRepo.save(user);

        when(userRepo.findUserByEmail(EmailAddress.valueOf("pedro@email.com"))).thenReturn(Optional.of(user));

        Course c1 = new Course(CourseName.of("Matemática"),
                CourseCode.of("MAT-1"),
                CourseEdition.of("INTRO-MAT-SEM01"),
                CourseDescription.of("Mathematics"),
                CourseState.of(CourseStateConstants.ENROLL.toString()),
                CourseMaxNumberLimit.of(100),
                CourseMinNumberLimit.of(10),
                user, new HashSet<>(), new HashSet<>());

        assertThrows(IllegalArgumentException.class,()-> service.confirmForOpenClose(c1));
    }
    @Test
    void courseStateChange(){
        builder.with("Pedro","Password1","Pedro Alves","pedro@email.com", "23/05/2002", CourseRoles.TEACHER,"333333333")
                .createdOn(Calendar.getInstance())
                .withAcronym("PPA");

        final User user = builder.build();

        userRepo.save(user);

        when(userRepo.findUserByEmail(EmailAddress.valueOf("pedro@email.com"))).thenReturn(Optional.of(user));

        Course c1 = new Course(CourseName.of("Matemática"),
                CourseCode.of("MAT-1"),
                CourseEdition.of("INTRO-MAT-SEM01"),
                CourseDescription.of("Mathematics"),
                CourseState.of(CourseStateConstants.ENROLL.toString()),
                CourseMaxNumberLimit.of(100),
                CourseMinNumberLimit.of(10),
                user, new HashSet<>(), new HashSet<>());

        Assertions.assertTrue(service.confirmForEnrollment(c1));
        service.changeState(c1);
        Assertions.assertTrue(service.confirmForOpenClose(c1));
        service.changeState(c1);
        Assertions.assertTrue(service.confirmForOpenClose(c1));
        service.changeState(c1);
        Assertions.assertTrue(service.confirmForEnrollment(c1));
    }
    @Test
    void createCourseTest(){
        builder.with("Pedro","Password1","Pedro Alves","pedro@email.com", "23/05/2002", CourseRoles.TEACHER,"333333333")
                .createdOn(Calendar.getInstance())
                .withAcronym("PPA");

        final User user = builder.build();

        userRepo.save(user);

        when(userRepo.findUserByEmail(EmailAddress.valueOf("pedro@email.com"))).thenReturn(Optional.of(user));

        Course c1 = new Course(CourseName.of("Matemática"), CourseCode.of("MAT-1"),
                CourseEdition.of("INTRO-MAT-SEM01"), CourseDescription.of("Mathematics from the beginning of time"),
                CourseState.of(String.valueOf(CourseStateConstants.CLOSED)), CourseMaxNumberLimit.of(100),
                CourseMinNumberLimit.of(10), user,
                new HashSet<>(), new HashSet<>());

        when(repo.findByCode(CourseCode.of("MAT-1"))).thenReturn(Optional.of(c1));

        ArgumentCaptor<Course> captor = ArgumentCaptor.forClass(Course.class);

        service.createCourse("Matemática", "MAT-1", "INTRO-MAT-SEM01",
                "Mathematics from the beginning of time", 100, 10, user);

        verify(repo).save(captor.capture());
    }


    @Test
    void getTeachersAvailableTest(){
        builder.with("Pedro","Password1","Pedro Alves","pedro@email.com", "23/05/2002", CourseRoles.TEACHER,"333333333")
                .createdOn(Calendar.getInstance())
                .withAcronym("PPA");

        final User user = builder.build();

        builder.with("Joao","Password2","Joao Alves","joao@email.com", "23/05/1992", CourseRoles.TEACHER,"333223333")
                .createdOn(Calendar.getInstance())
                .withAcronym("PAP");

        final User user2 = builder.build();

        Course c1 = new Course(CourseName.of("Matemática"), CourseCode.of("MAT-1"),
                CourseEdition.of("INTRO-MAT-SEM01"), CourseDescription.of("Mathematics from the beginning of time"),
                CourseState.of(String.valueOf(CourseStateConstants.CLOSED)), CourseMaxNumberLimit.of(100),
                CourseMinNumberLimit.of(10), user,
                new HashSet<>(), new HashSet<>());

        service.addTeacher(user, c1);

        Set<User> users = new HashSet<>();
        users.add(user2);

        when(service.getTeachersAvailable(c1)).thenReturn(users);
    }

    @Test
    void addTeacherTest(){
        builder.with("Pedro","Password1","Pedro Alves","pedro@email.com", "23/05/2002", CourseRoles.TEACHER,"333333333")
                .createdOn(Calendar.getInstance())
                .withAcronym("PPA");

        final User user = builder.build();

        builder.with("Joao","Password2","Joao Alves","joao@email.com", "23/05/1992", CourseRoles.TEACHER,"333223333")
                .createdOn(Calendar.getInstance())
                .withAcronym("PAP");

        final User user2 = builder.build();

        Course c1 = new Course(CourseName.of("Matemática"), CourseCode.of("MAT-1"),
                CourseEdition.of("INTRO-MAT-SEM01"), CourseDescription.of("Mathematics from the beginning of time"),
                CourseState.of(String.valueOf(CourseStateConstants.CLOSED)), CourseMaxNumberLimit.of(100),
                CourseMinNumberLimit.of(10), user,
                new HashSet<>(), new HashSet<>());


        when(service.addTeacher(user2, c1)).thenReturn(c1);
    }
}
