package org.usermanagement.domain.model;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.util.Utility;

@Utility
public final class UserBuilderHelper {
    private UserBuilderHelper() {
    }

    /**
     * @return SystemUserBuilder
     */
    public static UserBuilder builder() {
        return new UserBuilder(new ECoursePasswordPolicy(),
                new PlainTextEncoder());
    }
}
