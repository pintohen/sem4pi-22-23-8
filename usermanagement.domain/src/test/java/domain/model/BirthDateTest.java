package domain.model;

import org.junit.jupiter.api.Test;
import org.usermanagement.domain.model.BirthDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class BirthDateTest {

    final static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Test
    void ensureBirthDateIsNotInTheFuture() {
        Throwable thr = assertThrows(
                IllegalArgumentException.class,
                () -> BirthDate.of(
                        LocalDate.
                                now().
                                plusDays(1).format(formatter)
                )
        );

        Throwable thrLocaldate = assertThrows(
                IllegalArgumentException.class,
                () -> BirthDate.of(
                        LocalDate.
                                now().
                                plusDays(1)
                )
        );

        assertEquals("Birthdate cannot be in the future", thr.getMessage());
        assertEquals("Birthdate cannot be in the future", thrLocaldate.getMessage());
    }

    @Test
    void ensureBirthDateIsNotMoreThan120YearsAgo() {
        Throwable thr = assertThrows(
                IllegalArgumentException.class,
                () -> BirthDate.of(
                        LocalDate.
                                now().
                                minusYears(121).format(formatter)
                )
        );

        Throwable thrLocalDate = assertThrows(
                IllegalArgumentException.class,
                () -> BirthDate.of(
                        LocalDate.
                                now().
                                minusYears(121)
                )
        );

        assertEquals("Birthdate cannot be more than 120 years ago", thr.getMessage());
        assertEquals("Birthdate cannot be more than 120 years ago", thrLocalDate.getMessage());

    }

    @Test
    void ensureBirthDateCanBeCreatedWhenValueIsInThePast() {
        LocalDate expected = LocalDate.now().minusYears(16);
        BirthDate date = BirthDate.of(
                LocalDate.now().minusYears(16).format(formatter)
        );

        BirthDate dateLocalDateInjected = BirthDate.of(
                LocalDate.now().minusYears(16)
        );
        assertEquals(expected, date.value());
        assertEquals(expected, dateLocalDateInjected.value());
    }
}