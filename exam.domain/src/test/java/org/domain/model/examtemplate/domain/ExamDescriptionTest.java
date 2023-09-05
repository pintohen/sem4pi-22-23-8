package org.domain.model.examtemplate.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExamDescriptionTest {

    @Test
    void testCreateValidExamDescription() {
        String description = "Exam Description";
        ExamDescription examDescription = ExamDescription.of(description);
        assertNotNull(examDescription);
        assertEquals(description, examDescription.toString());
    }

    @Test
    void testCreateInvalidExamDescriptionWithNullValue() {
        String description = null;
        assertThrows(IllegalArgumentException.class, () -> {
            ExamDescription examDescription = ExamDescription.of(description);
        });
    }

    @Test
    void testCreateInvalidExamDescriptionWithEmptyValue() {
        String description = "";
        assertThrows(IllegalArgumentException.class, () -> {
            ExamDescription examDescription = ExamDescription.of(description);
        });
    }

    @Test
    void ClassDescriptionEquals() {
        String description = "Exam Description";
        ExamDescription examDescription = ExamDescription.of(description);
        ExamDescription examDescription2 = ExamDescription.of(description);
        ExamDescription examDescription3 = ExamDescription.of("Exam Description 2");
        assertEquals(examDescription, examDescription2);
        assertNotEquals(examDescription, examDescription3);
        assertNotEquals(examDescription, null);
        assertNotEquals(examDescription, new Object());
    }

}