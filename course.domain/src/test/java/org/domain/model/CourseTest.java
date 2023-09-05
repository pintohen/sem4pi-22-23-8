package org.domain.model;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.domain.repositories.CourseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

public class CourseTest {
    @Mock
    CourseRepository repo;

    @Mock
    UserRepository userRepo;

    @Mock
    TransactionalContext txt;

    UserBuilder builder;

    @InjectMocks
    CourseFactory factory;

    User user;

    @BeforeEach
    void setUp() {
        user = mock(User.class);

        userRepo = mock(UserRepository.class);

        repo = mock(CourseRepository.class);

        txt = mock(TransactionalContext.class);

        builder = new UserBuilder(new ECoursePasswordPolicy(),
                new PlainTextEncoder());

        factory = new CourseFactory();
    }

    @Test
    void createCourse() {
        builder.with("Pedro", "Password1", "Pedro Alves", "pedro@email.com", "23/05/2002", CourseRoles.TEACHER, "333333333")
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

        repo.save(c1);

        verify(repo).save(c1);
    }

    @Test
    void ensureHasName() {
        assertThrows(IllegalArgumentException.class, () ->
                factory.createCourse(null,
                        "MAT-1",
                        "INTRO-MAT-SEM01",
                        "Mathematics",
                        100,
                        10,
                        user));
    }
    @Test
    void ensureHasCode() {
        assertThrows(IllegalArgumentException.class, () ->
                factory.createCourse("Mathematics",
                        null,
                        "INTRO-MAT-SEM01",
                        "Mathematics",
                        100,
                        10,
                        user));
    }
    @Test
    void ensureHasEdition() {
        assertThrows(IllegalArgumentException.class, () ->
                factory.createCourse("Mathematics",
                        "MAT-1",
                        null,
                        "Mathematics",
                        100,
                        10,
                        user));
    }
    @Test
    void ensureHasMaximum() {
        assertThrows(NullPointerException.class, () ->
                factory.createCourse("Mathematics",
                        "MAT-1",
                        "INTRO-MAT-SEM01",
                        "Mathematics",
                        0,
                        0,
                        user));
    }
    @Test
    void ensureMaximumBiggerMinimum() {
        assertThrows(NullPointerException.class, () ->
                factory.createCourse("Mathematics",
                        "MAT-1",
                        "INTRO-MAT-SEM01",
                        "Mathematics",
                        10,
                        20,
                        user));
    }
    @Test
    void ensureHasTeacher() {
        assertThrows(IllegalArgumentException.class, () ->
                factory.createCourse("Mathematics",
                        "MAT-1",
                        "INTRO-MAT-SEM01",
                        "Mathematics",
                        100,
                        10,
                        null));
    }
}
