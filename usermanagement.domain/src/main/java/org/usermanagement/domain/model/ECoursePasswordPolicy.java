package org.usermanagement.domain.model;

import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.strings.util.StringPredicates;

public class ECoursePasswordPolicy implements PasswordPolicy {
    /**
     * Minimum number of characters for password.
     */
    private static final int MIN_NUMBER_OF_CHARACTERS = 6;


    /**
     * Checkers for a password.
     * @param rawPassword
     * @return boolean true/false
     */
    @Override
    public boolean isSatisfiedBy(final String rawPassword) {
        //Empty string or null
        if (StringPredicates.isNullOrEmpty(rawPassword)) {
            return false;
        }
        // at least 6 characters long
        if (rawPassword.length() < MIN_NUMBER_OF_CHARACTERS) {
            return false;
        }

        // at least one digit
        if (!StringPredicates.containsDigit(rawPassword)) {
            return false;
        }

        // at least one capital letter
        return StringPredicates.containsCapital(rawPassword);
    }
}
