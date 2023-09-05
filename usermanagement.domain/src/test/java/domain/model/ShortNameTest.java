package domain.model;

import org.junit.jupiter.api.Test;
import org.usermanagement.domain.model.ShortName;

import static org.junit.jupiter.api.Assertions.*;

class ShortNameTest {

    @Test
    void ensureShortNameIsNotNull() {
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> {
            ShortName.of(null);
        });

        assertEquals("Short Name can't be null.", thr.getMessage());
    }

    @Test
    void ensureShortNameIsNotEmpty() {
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> {
            ShortName.of("");
        });

        assertEquals("Short Name can't be empty.", thr.getMessage());
    }

    @Test
    void ensureShortNameHasMoreThanThreeCharacters() {
        Throwable thr = assertThrows(IllegalArgumentException.class, () -> {
            ShortName.of("abc");
        });

        assertEquals("Short name must have 3 characters or more", thr.getMessage());
    }

    @Test
    void ensureCreationOfValid() {
        ShortName.of("example");
    }

    @Test
    void ensureEqualsIsWorking() {
        ShortName s1 = ShortName.of("example");
        ShortName s2 = ShortName.of("example");
        ShortName s3 = ShortName.of("example2");

        assertEquals(s1, s2);
        assertEquals(s1.hashCode(), s2.hashCode());
        assertNotEquals(s1, s3);
        assertNotEquals(s1.hashCode(), s3.hashCode());
        assertEquals(s1.value(), s2.value());
        assertNotEquals(s1.value(), s3.value());
    }

}