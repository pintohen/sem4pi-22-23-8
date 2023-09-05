package org.domain.model.examtemplate.domain;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class CloseDateTest {

    @Test
    void testCreateValidCloseDate() {
        String date = "01-01-2024 09:00";
        CloseDate closeDate = CloseDate.of(date);
        assertNotNull(closeDate);
        assertEquals(date, closeDate.toString());
    }

    @Test
    void testCreateInvalidCloseDateWithNullValue() {
        String date = null;
        assertThrows(IllegalArgumentException.class, () -> {
            CloseDate closeDate = CloseDate.of(date);
        });
    }

    @Test
    void testCreateInvalidCloseDateWithEmptyValue() {
        String date = "";
        assertThrows(IllegalArgumentException.class, () -> {
            CloseDate closeDate = CloseDate.of(date);
        });
    }

    @Test
    void testCreateInvalidCloseDateWithInvalidFormat() {
        String date = "01-01-2024";
        assertThrows(IllegalArgumentException.class, () -> {
            CloseDate closeDate = CloseDate.of(date);
        });
    }

    @Test
    void testCreateInvalidCloseDateWithInvalidDay() {
        String date = "32-01-2024 09:00";
        assertThrows(DateTimeParseException.class, () -> {
            CloseDate closeDate = CloseDate.of(date);
        });
    }

    @Test
    void testCreateInvalidCloseDateWithInvalidMonth() {
        String date = "01-13-2024 09:00";
        assertThrows(DateTimeParseException.class, () -> {
            CloseDate closeDate = CloseDate.of(date);
        });
    }

    @Test
    void testCreateInvalidCloseDateWithInvalidHour() {
        String date = "01-01-2024 25:00";
        assertThrows(DateTimeParseException.class, () -> {
            CloseDate closeDate = CloseDate.of(date);
        });
    }

    @Test
    void testCreateInvalidCloseDateWithInvalidMinute() {
        String date = "01-01-2024 09:60";
        assertThrows(DateTimeParseException.class, () -> {
            CloseDate closeDate = CloseDate.of(date);
        });
    }

    @Test
    void testCreateInvalidCloseDateWithInvalidYear() {
        String date = "01-01-20224 09:00";
        assertThrows(IllegalArgumentException.class, () -> {
            CloseDate closeDate = CloseDate.of(date);
        });
    }

    @Test
    void testCreateInvalidCloseDateBeforeNow() {
        String date = "01-01-2019 09:00";
        assertThrows(IllegalArgumentException.class, () -> {
            CloseDate closeDate = CloseDate.of(date);
        });
    }

    @Test
    void ClassCloseDateEquals() {
        String date = "01-01-2024 09:00";
        CloseDate closeDate = CloseDate.of(date);
        CloseDate closeDate2 = CloseDate.of(date);
        CloseDate closeDate3 = CloseDate.of("01-01-2024 09:01");
        assertEquals(closeDate, closeDate2);
        assertNotEquals(closeDate, closeDate3);
        assertNotEquals(closeDate, null);
        assertNotEquals(closeDate, new Object());
    }

}