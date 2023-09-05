package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

public class CourseNameTest {
    @Test
    void ensureNonNull(){
        assertThrows(IllegalArgumentException.class,
                ()->CourseName.of(null));
    }

}
