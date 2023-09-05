package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassDayOfWeekCalcTest {

    @Test
    public void testCalculateValidClassDayOfWeek() {
        String validValue = "MONDAY";

        ClassDayOfWeek classDayOfWeek = ClassDayOfWeekCalc.calculate(validValue);

        assertNotNull(classDayOfWeek);
        assertEquals(validValue, classDayOfWeek.name());
    }

    @Test
    public void testCalculateInvalidClassDayOfWeek() {
        String invalidValue = "SUNDAY";

        assertThrows(IllegalArgumentException.class,
                () -> ClassDayOfWeekCalc.calculate(invalidValue));
    }

    @Test
    public void testCalculateInvalidClassDayOfWeekWithNullValue() {
        String invalidValue = null;

        assertThrows(NullPointerException.class,
                () -> ClassDayOfWeekCalc.calculate(invalidValue));
    }

    @Test
    public void testCalculateInvalidClassDayOfWeekWithEmptyValue() {
        String invalidValue = "";

        assertThrows(IllegalArgumentException.class,
                () -> ClassDayOfWeekCalc.calculate(invalidValue));
    }

    @Test
    void ClassDayOfWeekEquals() {
        ClassDayOfWeek classDayOfWeek = ClassDayOfWeekCalc.calculate("MONDAY");
        ClassDayOfWeek classDayOfWeek2 = ClassDayOfWeekCalc.calculate("MONDAY");
        ClassDayOfWeek classDayOfWeek3 = ClassDayOfWeekCalc.calculate("TUESDAY");

        assertEquals(classDayOfWeek, classDayOfWeek2);
        assertNotEquals(classDayOfWeek, classDayOfWeek3);
        assertNotEquals(classDayOfWeek, null);
        assertNotEquals(classDayOfWeek, new Object());
    }

}