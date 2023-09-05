package domain.model;

import org.junit.jupiter.api.Test;
import org.usermanagement.domain.model.Acronym;

import static org.junit.jupiter.api.Assertions.*;

class AcronymTest {
    @Test
    void ensureAcronymNullIsNotValid(){

        assertThrows(
                IllegalArgumentException.class,
                () -> Acronym.of(null),
                "Short name should neither be null nor empty"
        );

    }

    @Test
    void ensureAcronymEmptyIsNotValid(){

        assertThrows(
                IllegalArgumentException.class,
                () -> Acronym.of(""),
                "Short name should neither be null nor empty"
        );

    }

    @Test
    void ensureAcronymHasBetweenTwoAndFiveCharacters(){

        assertThrows(
            IllegalArgumentException.class,
            () -> Acronym.of("A"),
            "Short name should have between 2 and 5 characters"
        );

    }

    @Test
    void ensureAcronymCanBeCreated(){

        Acronym acronym = Acronym.of("ACRO");

        assertEquals("ACRO", acronym.value());

    }
}