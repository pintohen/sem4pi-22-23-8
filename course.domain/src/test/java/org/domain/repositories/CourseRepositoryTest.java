package org.domain.repositories;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;
import org.usermanagement.domain.repositories.UserRepository;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class CourseRepositoryTest {

    @Mock
    CourseRepository repo;

    @Mock
    UserRepository userRepo;

    UserBuilder builder;

    User user;

    @BeforeEach
    void setUp() {
        user = mock(User.class);

        userRepo = mock(UserRepository.class);

        repo = mock(CourseRepository.class);

        builder = new UserBuilder(new ECoursePasswordPolicy(),
                new PlainTextEncoder());
    }

    @Test
    void courseOf(){
        builder.with("Pedro","Password1","Pedro Alves","pedro@email.com", "23/05/2002", CourseRoles.TEACHER,"333333333")
                .createdOn(Calendar.getInstance())
                .withAcronym("PPA");

        final User user = builder.build();

        userRepo.save(user);

        when(userRepo.findUserByEmail(EmailAddress.valueOf("pedro@email.com"))).thenReturn(Optional.of(user));

        builder.with("João", "Password2", "João Santiago", "joao@email.com", "25/06/1999", CourseRoles.TEACHER, "111111111")
                .createdOn(Calendar.getInstance())
                .withAcronym("JPA");

        final User user2 = builder.build();

        userRepo.save(user2);

        when(userRepo.findUserByEmail(EmailAddress.valueOf("joao@email.com"))).thenReturn(Optional.of(user2));

        Course c1 = new Course(CourseName.of("Matemática"), CourseCode.of("MAT-1"),
                CourseEdition.of("INTRO-MAT-SEM01"), CourseDescription.of("Mathematics from the beginning of time"),
                CourseState.of(String.valueOf(CourseStateConstants.CLOSED)), CourseMaxNumberLimit.of(100),
                CourseMinNumberLimit.of(10), user,
                new HashSet<>(), new HashSet<>());

        when(repo.findByCode(CourseCode.of("MAT-1"))).thenReturn(Optional.of(c1));

        repo.save(c1);

        verify(repo).save(c1);

        Course c2 = new Course(CourseName.of("Português"), CourseCode.of("PT-1"),
                CourseEdition.of("INTRO-PT-01"),CourseDescription.of("Portuguese for every ERASMUS student"),
                CourseState.of(String.valueOf(CourseStateConstants.CLOSED)), CourseMaxNumberLimit.of(200),
                CourseMinNumberLimit.of(20), user2 ,
                new HashSet<>(), new HashSet<>());

        when(repo.findByCode(CourseCode.of("PT-1"))).thenReturn(Optional.of(c2));

        repo.save(c2);

        verify(repo).save(c2);
    }
}
