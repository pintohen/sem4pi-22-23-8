package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class CourseCodeTest {

    @Test
    void ensureNonNull(){
        assertThrows(IllegalArgumentException.class,
                ()->CourseCode.of(null));
    }
    @Test
    void compareTo(){
        CourseCode code = CourseCode.of("MAT");
        assertEquals(1, code.compareTo(CourseCode.of("MAT")));
    }
    @Test
    void equals(){
        CourseCode code = CourseCode.of("Mat");
        CourseCode code2 = CourseCode.of("Mat");
        assertTrue(code.equals(code2));
    }
}
