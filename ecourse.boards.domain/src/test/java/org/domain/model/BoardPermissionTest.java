package org.domain.model;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;

import static org.junit.jupiter.api.Assertions.*;

class BoardPermissionTest {
    private BoardPermissionFactory factory;
    private User user;

    ECoursePasswordPolicy passwordPolicy = new ECoursePasswordPolicy();

    private static final String STRING_SHORTNAME = "shortName";
    private static final String STRING_FULLNAME = "fullName";
    private static final String STRING_PASSWORD = "Correct5";
    private static final String STRING_EMAIL = "email@email.com";

    @BeforeEach
    void setUp() {
        factory = new BoardPermissionFactory();
        user = managerUser();
    }

    @Test
    void testCreateWriteBoardPermission() {
        BoardPermission boardPermission = factory.create(user, AccessLevelType.WRITE);

        assertEquals(user, boardPermission.userWithPermission());
        assertEquals(AccessLevelType.WRITE, boardPermission.accessLevel());
    }

    @Test
    void testCreateReadBoardPermission() {
        BoardPermission boardPermission = factory.create(user, AccessLevelType.READ);

        assertEquals(user, boardPermission.userWithPermission());
        assertEquals(AccessLevelType.READ, boardPermission.accessLevel());
    }

    @Test
    public void testSameAs() {
        BoardPermission boardPermission = factory.create(user, AccessLevelType.WRITE);
        BoardPermission other = factory.create(user, AccessLevelType.WRITE);

        assertTrue(boardPermission.sameAs(other));
        assertEquals(boardPermission.identity(), other.identity());
    }
    @Test
    public void testNotSameAs() {
        BoardPermission boardPermission = factory.create(user, AccessLevelType.WRITE);
        BoardPermission other = factory.create(user, AccessLevelType.READ);

        assertFalse(boardPermission.sameAs(other));
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
}