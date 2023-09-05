package domain.model;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.representations.dto.GeneralDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.*;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

class UserTest {
    private static final PasswordEncoder ENCODER = new PlainTextEncoder();
    private static final PasswordPolicy POLICY = new ECoursePasswordPolicy();


    // mocks
    private static final String STRING_SHORTNAME = "shortName";
    private static final ShortName SHORTNAME = ShortName.of(STRING_SHORTNAME);
    private static final String STRING_FULLNAME = "fullName";

    private static final FullName FULLNAME = FullName.of(STRING_FULLNAME);
    private static final String STRING_EMAIL = "email@email.com";

    private static final EmailAddress EMAIL = EmailAddress.valueOf(STRING_EMAIL);
    private static final String STRING_ROLE = String.valueOf(CourseRoles.MANAGER);
    private static final Role ROLE = CourseRoles.MANAGER;

    private static final Role ROLE_TEACHER = CourseRoles.TEACHER;

    private static final Role ROLE_STUDENT = CourseRoles.STUDENT;


    private static final String STRING_PASS = "Correct5";
    private static final String STRING_PASS2 = "CorrectPass2";
    private static final Password PASSWORD = Password.encodedAndValid(STRING_PASS, POLICY, ENCODER).get();

    private static final Password PASSWORD2 = Password.encodedAndValid(STRING_PASS2, POLICY, ENCODER).get();
    private static final Calendar CREATED_ON = Calendar.getInstance();
    private static final Calendar DEACTIVATED_ON = Calendar.getInstance();

    private static final String STRING_ACRONYM = "TST";
    private static final String BIRTH_DATE = "10/10/2000";
    private static final String TAX_PAYER_NUMBER = "111111111";
    private static final String STRING_NUMBER_MEC = "202300001";

    private static final String STRING_ROLE_TWO = "ROLE_TWO";
    private static final Role ROLE_TWO = Role.valueOf(STRING_ROLE_TWO);
    private static final Role[] ROLES = {
            ROLE,
            ROLE_TWO
    };

    UserBuilder builder = new UserBuilder(POLICY, ENCODER);

    @Test
    void ensureUserHasShortNameWhenCreated() {
        assertThrows(
                IllegalArgumentException.class,
                () -> builder.with(
                        null,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE
                ).build()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> builder.with(
                        null,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                        .createdOn(CREATED_ON)
                        .build()
        );
    }

    @Test
    void ensureUserHasFullNameWhenCreated() {
        assertThrows(
                IllegalArgumentException.class,
                () -> builder.with(
                                SHORTNAME,
                                PASSWORD,
                                null,
                                EMAIL,
                                ROLE)
                        .build()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> builder.with(
                                SHORTNAME,
                                PASSWORD,
                                null,
                                EMAIL,
                                ROLE)
                        .createdOn(CREATED_ON)
                        .build()
        );
    }

    @Test
    void ensureUserHasPasswordWhenCreated() {
        assertThrows(
                IllegalArgumentException.class,
                () -> builder.with(
                                SHORTNAME,
                                null,
                                FULLNAME,
                                EMAIL,
                                ROLE)
                        .build()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> builder.with(
                                SHORTNAME,
                                null,
                                FULLNAME,
                                EMAIL,
                                ROLE)
                        .createdOn(CREATED_ON)
                        .build()
        );
    }

    @Test
    void ensureUserHasEmailWhenCreated() {
        assertThrows(
                IllegalArgumentException.class,
                () -> builder.with(
                                SHORTNAME,
                                PASSWORD,
                                FULLNAME,
                                null,
                                ROLE)
                        .build()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> builder.with(
                                SHORTNAME,
                                PASSWORD,
                                FULLNAME,
                                null,
                                ROLE)
                        .createdOn(CREATED_ON)
                        .build()
        );
    }

    @Test
    void ensureUserHasRoleWhenCreated() {
        assertThrows(
                IllegalArgumentException.class,
                () -> builder.with(
                                SHORTNAME,
                                PASSWORD,
                                FULLNAME,
                                EMAIL,
                                null)
                        .build()
        );

        assertThrows(
                IllegalArgumentException.class,
                () -> builder.with(
                                SHORTNAME,
                                PASSWORD,
                                FULLNAME,
                                EMAIL,
                                null)
                        .createdOn(CREATED_ON)
                        .build()
        );
    }

    @Test
    void ensureUserHasCreatedOnWhenCreated() {
        User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                .build();

        assertEquals(Calendar.getInstance(), user.createdOn());
    }

    @Test
    void ensureUserCanBeCreatedWhenValid() {
        User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                .createdOn(CREATED_ON)
                .build();

        assertTrue(user.isActive());
        assertTrue(user.passwordMatches(STRING_PASS, ENCODER));
        assertTrue(user.hasAnyOf(ROLES));
    }

    @Test
    void ensureCantChangeToNullPassword(){
        final User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                .createdOn(CREATED_ON)
                .build();

        assertThrows(IllegalArgumentException.class,
                () -> user.changePassword(null));
    }

    @Test
    void ensureCanChangeToValidPassword(){
        final User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                .createdOn(CREATED_ON)
                .build();

        user.changePassword(PASSWORD2);

        assertEquals(PASSWORD2, user.password());
    }

    @Test
    void ensureReturnsCorrectIdentity(){
        final User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                .createdOn(CREATED_ON)
                .build();

        assertEquals(EMAIL, user.identity());
        assertEquals(EMAIL, user.emailAddress());
    }

    @Test
    void testSameAs() {
        final User user = builder.with(
                        STRING_SHORTNAME,
                        STRING_PASS,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        BIRTH_DATE,
                        ROLE,
                        TAX_PAYER_NUMBER)
                .createdOn(CREATED_ON)
                .build();
        final User user2 = user;

        assertTrue(user.sameAs(user2));

        final User user3 = builder.with(
                        STRING_SHORTNAME,
                        STRING_PASS,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        BIRTH_DATE,
                        ROLE,
                        TAX_PAYER_NUMBER)
                .createdOn(CREATED_ON)
                .build();

        assertTrue(user.sameAs(user3));
    }

    @Test
    void ensureNotPossibleToDeactivateDeactivetedUser() {
        final User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                .createdOn(CREATED_ON)
                .build();

        user.disable(DEACTIVATED_ON);

        assertThrows(IllegalStateException.class,
                () -> user.disable(DEACTIVATED_ON));

    }

    @Test
    void ensureNotPossibleToActivateActiveUser() {
        final User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                .createdOn(CREATED_ON)
                .build();

        assertThrows(IllegalStateException.class,
                () -> user.enable());
    }

    @Test
    void ensureUserCanBeDeactivated() {
        final User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                .createdOn(CREATED_ON)
                .build();

        user.disable(DEACTIVATED_ON);

        assertFalse(user.isActive());
    }

    @Test
    void ensureUserCanBeActivated() {
        final User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                .createdOn(CREATED_ON)
                .build();

        user.disable(DEACTIVATED_ON);
        user.enable();

        assertTrue(user.isActive());
    }

    @Test
    void ensureUserHasCorrectRoles() {
        final User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                .createdOn(CREATED_ON)
                .build();

        assertEquals(STRING_ROLE, user.role());
    }

    @Test
    void ensureAcronymIsWorking() {
        final User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE_TEACHER)
                .withAcronym(STRING_ACRONYM)
                .createdOn(CREATED_ON)
                .build();

        assertEquals(STRING_ACRONYM, user.acronym().value());
    }

    @Test
    void ensureTeacherAllwaysHaveAcronym() {
        assertThrows(IllegalStateException.class,
                () -> builder.with(
                                SHORTNAME,
                                PASSWORD,
                                FULLNAME,
                                EMAIL,
                                ROLE_TEACHER)
                        .createdOn(CREATED_ON)
                        .build());
    }

    @Test
    void failRegisterManagerWithAcronym() {
        assertThrows(IllegalStateException.class,
                () -> builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE)
                .withAcronym(STRING_ACRONYM)
                .createdOn(CREATED_ON)
                .build());
    }

    @Test
    void ensureMecNumberIsWorking() {
        final User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE_STUDENT)
                .withMecanographicNumber(STRING_NUMBER_MEC)
                .createdOn(CREATED_ON)
                .build();

        assertEquals(STRING_NUMBER_MEC, user.mecanographicNumber().toString());
    }

    @Test
    void ensureStudentAllwaysHaveMecNumber() {
        assertThrows(IllegalStateException.class,
                () -> builder.with(
                                SHORTNAME,
                                PASSWORD,
                                FULLNAME,
                                EMAIL,
                                ROLE_STUDENT)
                        .createdOn(CREATED_ON)
                        .build());
    }

    @Test
    void failRegisterManagerWithMecNumber() {
        assertThrows(IllegalStateException.class,
                () -> builder.with(
                                SHORTNAME,
                                PASSWORD,
                                FULLNAME,
                                EMAIL,
                                ROLE)
                        .withMecanographicNumber(STRING_NUMBER_MEC)
                        .createdOn(CREATED_ON)
                        .build());
    }

    @Test
    void testToDTO() {
        final User user = builder.with(
                        SHORTNAME,
                        PASSWORD,
                        FULLNAME,
                        EMAIL,
                        ROLE_STUDENT)
                .withMecanographicNumber(STRING_NUMBER_MEC)
                .createdOn(CREATED_ON)
                .build();

        GeneralDTO dto = user.toDTO();

        assertEquals(5, dto.values().size());
    }
}