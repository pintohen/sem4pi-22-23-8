package org.domain.model;

import org.junit.jupiter.api.Test;
import java.time.format.DateTimeParseException;
import static org.junit.jupiter.api.Assertions.*;

class ClassTimeTest {

    @Test
    void testStartTime() {
        ClassTime classTime = ClassTime.ofStart("09:00");
        assertEquals("09:00", classTime.startTime().toString());
    }

    @Test
    void testEndTime() {
        ClassTime classTime = ClassTime.ofEnd("10:00");
        assertEquals("10:00", classTime.endTime().toString());
    }

    @Test
    void testFullTimeClass() {
        ClassTime classTime = ClassTime.of("07:00", "10:00");
        assertEquals("07:00", classTime.startTime().toString());
        assertEquals("10:00", classTime.endTime().toString());
    }

    @Test
    void testStartTimeWithNull() {
        assertThrows(NullPointerException.class, () -> ClassTime.ofStart(null));
    }

    @Test
    void testEndTimeWithNull() {
        assertThrows(NullPointerException.class, () -> ClassTime.ofEnd(null));
    }

    @Test
    void testFullTimeClassWithNull() {
        assertThrows(NullPointerException.class, () -> ClassTime.of(null, null));
    }

    @Test
    void testStartTimeWithInvalidTime() {
        assertThrows(IllegalArgumentException.class, () -> ClassTime.ofStart("05:00"));
    }

    @Test
    void testEndTimeWithInvalidTime() {
        assertThrows(IllegalArgumentException.class, () -> ClassTime.ofEnd("05:00"));
    }

    @Test
    void testFullTimeClassWithInvalidTime() {
        assertThrows(DateTimeParseException.class, () -> ClassTime.of("05:00", "24:00"));
    }

    @Test
    void testFullTimeClassWithSameStartAndEndTime() {
        assertThrows(IllegalArgumentException.class, () -> ClassTime.of("05:00", "05:00"));
    }

    @Test
    void testFullTimeClassWithEndTimeBeforeStartTime() {
        assertThrows(IllegalArgumentException.class, () -> ClassTime.of("05:00", "04:00"));
    }

    @Test
    void ClassTimeEquals() {
        ClassTime classTime = ClassTime.of("07:00", "11:00");
        ClassTime classTime2 = ClassTime.of("07:00", "11:00");
        ClassTime classTime3 = ClassTime.of("08:00", "12:00");

        assertEquals(classTime, classTime2);
        assertNotEquals(classTime, classTime3);
        assertNotEquals(classTime, null);
        assertNotEquals(classTime, new Object());

    }





}