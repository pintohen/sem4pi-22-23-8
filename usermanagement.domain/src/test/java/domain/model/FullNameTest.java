package domain.model;

import org.junit.jupiter.api.Test;
import org.usermanagement.domain.model.FullName;

import static org.junit.jupiter.api.Assertions.*;

class FullNameTest {
    @Test
    void ensureFullNameIsCreated() {
        FullName fullName = FullName.of("John Doe");
        assertEquals("John Doe", fullName.value());
    }

    @Test
    void ensureFullNameIsNotEmpty() {
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> FullName.of(""));

        assertEquals("Full Name can't be empty.", thr.getMessage());
    }

    @Test
    void ensureFullNameHasMoreThanThreeCharacters() {
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> FullName.of("Jo"));

        assertEquals("Full name must have 3 characters or more", thr.getMessage());
    }
}