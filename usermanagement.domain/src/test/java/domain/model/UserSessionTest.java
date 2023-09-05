
package domain.model;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;
import org.usermanagement.domain.model.UserSession;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

class UserSessionTest {
    UserSession userSession;

    ECoursePasswordPolicy policy = new ECoursePasswordPolicy();
    UserBuilder builder = new UserBuilder(policy, new PlainTextEncoder());

    private static final String STRING_SHORTNAME = "shortName";
    private static final String STRING_PASSWORD = "Correct5";
    private static final String STRING_FULLNAME = "fullName";
    private static final String STRING_EMAIL = "email@email.com";
    private static final Role ROLE = CourseRoles.MANAGER;

    @Mock
    User user = builder.with(STRING_SHORTNAME,
            STRING_PASSWORD,
            STRING_FULLNAME,
            STRING_EMAIL,
            ROLE)
            .build();

    @Test
    void userSessionNull() {
        assertThrows(IllegalArgumentException.class, () -> new UserSession(null));
    }

    @Test
    void authenticatedUser() {
        userSession = new UserSession(user);
        User authUser = userSession.authenticatedUser();

        assertEquals(user, authUser);
    }
}
