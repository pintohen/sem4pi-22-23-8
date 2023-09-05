package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClassTitleTest {

    @Test
    public void testCreateValidClassTitle() {
        String validValue = "Class Title";

        ClassTitle classTitle = ClassTitle.of(validValue);

        assertNotNull(classTitle);
        assertEquals(validValue, classTitle.value());
    }

    @Test
    public void testCreateInvalidClassTitleWithNullValue() {
        String invalidValue = null;

        assertThrows(NullPointerException.class,
                () -> ClassTitle.of(invalidValue));
    }

    @Test
    public void testCreateInvalidClassTitleWithEmptyValue() {
        String invalidValue = "";

        assertThrows(IllegalArgumentException.class,
                () -> ClassTitle.of(invalidValue));
    }

    @Test
    void ClassTitleEquals() {
        ClassTitle classTitle = ClassTitle.of("Class Title");
        ClassTitle classTitle2 = ClassTitle.of("Class Title");
        ClassTitle classTitle3 = ClassTitle.of("Class Title 2");

        assertEquals(classTitle, classTitle2);
        assertNotEquals(classTitle, classTitle3);
        assertNotEquals(classTitle, null);
        assertNotEquals(classTitle, new Object());
    }

}