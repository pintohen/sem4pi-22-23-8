package org.domain.model.examtemplate.domain;

import org.junit.jupiter.api.Test;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

class OpenDateTest {

    @Test
    void testCreateValidOpenDate() {
        String date = "01-01-2024 09:00";
        OpenDate openDate = OpenDate.of(date);
        assertNotNull(openDate);
        assertEquals(date, openDate.toString());
    }

    @Test
    void testCreateInvalidOpenDateWithNullValue() {
        String date = null;
        assertThrows(NullPointerException.class, () -> {
            OpenDate openDate = OpenDate.of(date);
        });
    }

    @Test
    void testCreateInvalidOpenDateWithEmptyValue() {
        String date = "";
        assertThrows(IllegalArgumentException.class, () -> {
            OpenDate openDate = OpenDate.of(date);
        });
    }

    @Test
    void testCreateInvalidOpenDateWithInvalidFormat() {
        String date = "01-01-2024";
        assertThrows(IllegalArgumentException.class, () -> {
            OpenDate openDate = OpenDate.of(date);
        });
    }

    @Test
    void testCreateInvalidOpenDateWithInvalidDay() {
        String date = "32-01-2024 09:00";
        assertThrows(DateTimeParseException.class, () -> {
            OpenDate openDate = OpenDate.of(date);
        });
    }

    @Test
    void testCreateInvalidOpenDateWithInvalidMonth() {
        String date = "01-13-2024 09:00";
        assertThrows(DateTimeParseException.class, () -> {
            OpenDate openDate = OpenDate.of(date);
        });
    }

    @Test
    void testCreateInvalidOpenDateWithInvalidYear() {
        String date = "01-01-20244 09:00";
        assertThrows(IllegalArgumentException.class, () -> {
            OpenDate openDate = OpenDate.of(date);
        });
    }

    @Test
    void testCreateInvalidOpenDateWithInvalidHour() {
        String date = "01-01-2024 25:00";
        assertThrows(DateTimeParseException.class, () -> {
            OpenDate openDate = OpenDate.of(date);
        });
    }

    @Test
    void testCreateInvalidOpenDateWithInvalidMinute() {
        String date = "01-01-2024 09:60";
        assertThrows(DateTimeParseException.class, () -> {
            OpenDate openDate = OpenDate.of(date);
        });
    }

    @Test
    void testCreateInvalidOpenDateBeforeNow() {
        String date = "01-01-2020 09:00";
        assertThrows(IllegalArgumentException.class, () -> {
            OpenDate openDate = OpenDate.of(date);
        });
    }

    @Test
    void ClassOpenDateEquals() {
        String date = "01-01-2024 09:00";
        OpenDate openDate = OpenDate.of(date);
        OpenDate openDate2 = OpenDate.of(date);
        OpenDate openDate3 = OpenDate.of("01-01-2024 10:00");
        assertEquals(openDate, openDate2);
        assertNotEquals(openDate, openDate3);
        assertNotEquals(openDate, null);
        assertNotEquals(openDate, new Object());
    }

}