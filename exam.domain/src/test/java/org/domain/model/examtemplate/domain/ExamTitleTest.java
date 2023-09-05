package org.domain.model.examtemplate.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExamTitleTest {

    @Test
    void testCreateValidExamTitle() {
        String title = "Exam Title";
        ExamTitle examTitle = ExamTitle.of(title);
        assertNotNull(examTitle);
        assertEquals(title, examTitle.toString());
    }

    @Test
    void testCreateInvalidExamTitleWithNullValue() {
        String title = null;
        assertThrows(NullPointerException.class, () -> {
            ExamTitle examTitle = ExamTitle.of(title);
        });
    }

    @Test
    void testCreateInvalidExamTitleWithEmptyValue() {
        String title = "";
        assertThrows(IllegalArgumentException.class, () -> {
            ExamTitle examTitle = ExamTitle.of(title);
        });
    }

    @Test
    void testCreateInvalidExamDescriptionLengthSmall() {
        String title = "he";
        assertThrows(IllegalArgumentException.class, () -> {
            ExamTitle examTitle = ExamTitle.of(title);
        });
    }

    @Test
    void testCreateInvalidExamDescriptionLengthBig() {
        String title = "This is a very big exam title for testing purposes.";
        assertThrows(IllegalArgumentException.class, () -> {
            ExamTitle examTitle = ExamTitle.of(title);
        });
    }

    @Test
    void ClassTitleEquals() {
        String title = "Exam Title";
        ExamTitle examTitle = ExamTitle.of(title);
        ExamTitle examTitle2 = ExamTitle.of(title);
        ExamTitle examTitle3 = ExamTitle.of("Exam Title 2");
        assertEquals(examTitle, examTitle2);
        assertNotEquals(examTitle, examTitle3);
        assertNotEquals(examTitle, null);
        assertNotEquals(examTitle, new Object());
    }

}