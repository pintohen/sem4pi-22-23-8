package domain.model;

import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import org.junit.jupiter.api.Test;
import org.usermanagement.domain.model.ECoursePasswordPolicy;

import static org.junit.jupiter.api.Assertions.*;

class ECoursePasswordPolicyTest {
    private final PasswordPolicy subject = new ECoursePasswordPolicy();

    @Test
    void ensurePasswordHasAtLeastOneDigitOneCapitalAnd6CharactersLong() {
        assertTrue(subject.isSatisfiedBy("abCfefgh1"));
    }

    @Test
    void ensurePasswordsSmallerThan6CharactersAreNotAllowed() {
        assertFalse(subject.isSatisfiedBy("ab1c"));
    }

    @Test
    void ensurePasswordsWithoutDigitsAreNotAllowed() {
        assertFalse(subject.isSatisfiedBy("abcefghi"));
    }

    @Test
    void ensurePasswordsWithoutCapitalLetterAreNotAllowed() {
        assertFalse(subject.isSatisfiedBy("abcefghi1"));
    }

    @Test
    void ensureNotNullIsNotAccepted() {
        assertFalse(subject.isSatisfiedBy(""));
    }
}