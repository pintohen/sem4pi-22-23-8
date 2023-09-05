package org.usermanagement.controller;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.authz.application.AuthzRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;
import org.usermanagement.domain.model.UserManagementService;
import org.usermanagement.domain.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class UserManagementServiceTest {
    @Mock
    UserRepository userRepository;

    private UserManagementService userSvc;

    ECoursePasswordPolicy passwordPolicy = new ECoursePasswordPolicy();

    private static final String STRING_SHORTNAME = "shortName";
    private static final String STRING_FULLNAME = "fullName";
    private static final String STRING_PASSWORD = "Correct5";
    private static final String STRING_EMAIL = "email@email.com";
    private static final String MEC_NUMBER = "202300001";
    private static final String STRING_ACRONYM = "TTT";
    private static final String STRING_BIRTHDATE = "16/11/2002";

    private static final String STRING_TAXPAYERNUMBER = "999999999";

    @BeforeEach
    void setUp(){
        userRepository = mock(UserRepository.class);;

        AuthzRegistry.configure(userRepository,
                new PlainTextEncoder(),
                new ECoursePasswordPolicy());

        userSvc = AuthzRegistry
                .userService();
    }


    @Test
    void registerManagerSuccessfully() {
        when(userRepository.save(any(User.class))).thenReturn(managerUser());

        User newUser = userSvc.registerNewUser(STRING_SHORTNAME,
                STRING_PASSWORD,
                STRING_FULLNAME,
                STRING_EMAIL,
                CourseRoles.MANAGER,
                STRING_BIRTHDATE,
                STRING_TAXPAYERNUMBER,
                null);

        assertEquals(managerUser().identity(), newUser.identity());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void registerTeacherSuccessfully() {
        when(userRepository.save(any(User.class))).thenReturn(teacherUser());

        User newUser = userSvc.registerNewUser(STRING_SHORTNAME,
                STRING_PASSWORD,
                STRING_FULLNAME,
                STRING_EMAIL,
                CourseRoles.TEACHER,
                STRING_BIRTHDATE,
                STRING_TAXPAYERNUMBER,
                STRING_ACRONYM);

        assertNull(newUser.mecanographicNumber());
        assertNotNull(newUser.acronym());
        assertEquals(STRING_ACRONYM, newUser.acronym().value());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void registerStudentSuccessfully() {
        when(userRepository.save(any(User.class))).thenReturn(studentUser());

        User newUser = userSvc.registerNewUser(STRING_SHORTNAME,
                STRING_PASSWORD,
                STRING_FULLNAME,
                STRING_EMAIL,
                CourseRoles.STUDENT,
                STRING_BIRTHDATE,
                STRING_TAXPAYERNUMBER,
                null);

        assertNull(newUser.acronym());
        assertNotNull(newUser.mecanographicNumber());
        assertEquals(String.valueOf(LocalDateTime.now().getYear() * 100000 + 1), newUser.mecanographicNumber().value());
        verify(userRepository, times(1)).save(any(User.class));
        verify(userRepository, times(1)).findMaxYearMecanographicNumber();
    }

    @Test
    void failRegisterStudentWithAcronym() {
        assertThrows(IllegalStateException.class,
                () -> userSvc.registerNewUser(STRING_SHORTNAME,
                        STRING_PASSWORD,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        CourseRoles.STUDENT,
                        STRING_BIRTHDATE,
                        STRING_TAXPAYERNUMBER,
                        STRING_ACRONYM));

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void failRegisterManagerWithAcronym() {
        assertThrows(IllegalStateException.class,
                () -> userSvc.registerNewUser(STRING_SHORTNAME,
                        STRING_PASSWORD,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        CourseRoles.MANAGER,
                        STRING_BIRTHDATE,
                        STRING_TAXPAYERNUMBER,
                        STRING_ACRONYM));

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void failRegisterTeacherWithMecanographicNumber() {
        assertThrows(IllegalStateException.class,
                () -> teacherUserWithMecanographicNumber());
    }

    @Test
    void failRegisterManagerWithMecanographicNumber() {
        assertThrows(IllegalStateException.class,
                () -> managerUserWithMecanographicNumber());
    }

    @Test
    void registerNewUserWithInvalidEmailThenThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () ->
                        userSvc.registerNewUser(
                                STRING_SHORTNAME,
                                STRING_PASSWORD,
                                STRING_FULLNAME,
                                "invalid_email",
                                CourseRoles.TEACHER,
                                STRING_BIRTHDATE,
                                STRING_TAXPAYERNUMBER,
                                STRING_ACRONYM,
                                Calendar.getInstance()));

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void registerNewUserWithInvalidPasswordThenThrowException() {
        assertThrows(
                IllegalArgumentException.class,
                () ->
                        userSvc.registerNewUser(
                                STRING_SHORTNAME,
                                "invalid",
                                STRING_FULLNAME,
                                STRING_EMAIL,
                                CourseRoles.TEACHER,
                                STRING_BIRTHDATE,
                                STRING_TAXPAYERNUMBER,
                                STRING_ACRONYM,
                                Calendar.getInstance()));

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void enableUserWhenEmailAddressNotFoundThenThrowException() {
        EmailAddress userEmail = EmailAddress.valueOf(STRING_EMAIL);
        when(userRepository.findUserByEmail(userEmail)).thenReturn(Optional.empty());

        assertThrows(
                NoSuchElementException.class,
                () -> {
                    userSvc.enableUser(userEmail);
                });

        verify(userRepository, times(1)).findUserByEmail(userEmail);
    }

    @Test
    void enableUserThatIsAlreadyEnableThenThrowException() {
        EmailAddress userEmail = EmailAddress.valueOf(STRING_EMAIL);
        User user = managerUser();
        when(userRepository.findUserByEmail(userEmail)).thenReturn(Optional.of(user));

        assertThrows(IllegalStateException.class,
                () ->userSvc.enableUser(userEmail));
    }

    @Test
    void inputInvalidEmailThenThrowException() {
        assertThrows(IllegalArgumentException.class,
                () -> EmailAddress.valueOf("invalid_email"));
    }

    @Test
    void enableUserWhenValidEmailAddressProvided() {
        EmailAddress userEmail = EmailAddress.valueOf(STRING_EMAIL);
        User user = mock(User.class);
        when(userRepository.findUserByEmail(userEmail)).thenReturn(Optional.of(user));
        when(userRepository.save(eq(user))).thenReturn(user);

        User enabledUser = userSvc.enableUser(userEmail);

        verify(userRepository, times(1)).findUserByEmail(userEmail);
        verify(user, times(1)).enable();
        verify(userRepository, times(1)).save(user);
        assertEquals(user, enabledUser);
    }

    @Test
    void disableUserWhenEmailAddressNotFoundThenThrowException() {
        EmailAddress userEmail = EmailAddress.valueOf(STRING_EMAIL);
        when(userRepository.findUserByEmail(userEmail)).thenReturn(Optional.empty());

        assertThrows(
                NoSuchElementException.class,
                () -> {
                    userSvc.disableUser(userEmail);
                });

        verify(userRepository, times(1)).findUserByEmail(userEmail);
    }

    @Test
    void disableUserThatIsAlreadyDisableThenThrowException() {
        EmailAddress userEmail = EmailAddress.valueOf(STRING_EMAIL);
        User user = managerUser();
        when(userRepository.findUserByEmail(userEmail)).thenReturn(Optional.of(user));

        user.disable(CurrentTimeCalendars.now());

        assertThrows(IllegalStateException.class,
                () ->userSvc.disableUser(userEmail));
    }

    @Test
    void disableUserWhenValidEmailAddressProvided() {
        EmailAddress userEmail = EmailAddress.valueOf(STRING_EMAIL);
        User user = mock(User.class);
        when(userRepository.findUserByEmail(userEmail)).thenReturn(Optional.of(user));
        when(userRepository.save(eq(user))).thenReturn(user);

        User disabledUser = userSvc.disableUser(userEmail);

        verify(userRepository, times(1)).findUserByEmail(userEmail);
        verify(user, times(1)).disable(any());
        verify(userRepository, times(1)).save(user);
        assertEquals(user, disabledUser);
    }

    @Test
    void testAllUsersReturnsEmptyList() {
        when(userRepository.findAll()).thenReturn(new ArrayList<>());

        Iterable<User> allUsers = userSvc.allUsers();

        assertTrue(((List<User>) allUsers).isEmpty());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testAllUsersReturnsNonEmptyList() {
        List<User> users = new ArrayList<>();
        User user1 = managerUser();
        User user2 = studentUser();
        users.add(user1);
        users.add(user2);

        when(userRepository.findAll()).thenReturn(users);

        Iterable<User> allUsers = userSvc.allUsers();

        assertEquals(users, allUsers);
        verify(userRepository, times(1)).findAll();
    }


    private User managerUser(){
        UserBuilder userBuilder = new UserBuilder(passwordPolicy, new PlainTextEncoder());

        return userBuilder.with(STRING_SHORTNAME,
                        STRING_PASSWORD,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        CourseRoles.MANAGER)
                .build();
    }

    private User managerUserWithMecanographicNumber(){
        UserBuilder userBuilder = new UserBuilder(passwordPolicy, new PlainTextEncoder());

        return userBuilder.with(STRING_SHORTNAME,
                        STRING_PASSWORD,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        CourseRoles.MANAGER)
                .withMecanographicNumber(MEC_NUMBER)
                .build();
    }

    private User teacherUser(){
        UserBuilder userBuilder = new UserBuilder(passwordPolicy, new PlainTextEncoder());

        return userBuilder.with(STRING_SHORTNAME,
                        STRING_PASSWORD,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        CourseRoles.TEACHER)
                .withAcronym(STRING_ACRONYM)
                .build();
    }

    private User teacherUserWithMecanographicNumber(){
        UserBuilder userBuilder = new UserBuilder(passwordPolicy, new PlainTextEncoder());

        return userBuilder.with(STRING_SHORTNAME,
                        STRING_PASSWORD,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        CourseRoles.TEACHER)
                .withAcronym(STRING_ACRONYM)
                .withMecanographicNumber(MEC_NUMBER)
                .build();
    }

    private User studentUser(){
        UserBuilder userBuilder = new UserBuilder(passwordPolicy, new PlainTextEncoder());

        return userBuilder.with(STRING_SHORTNAME,
                        STRING_PASSWORD,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        CourseRoles.STUDENT)
                .withMecanographicNumber(MEC_NUMBER)
                .build();
    }
}