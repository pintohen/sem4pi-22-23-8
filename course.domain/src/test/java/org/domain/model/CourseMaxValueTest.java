package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;

public class CourseMaxValueTest {
    @Test
    void ensureNonNull(){
        assertThrows(IllegalArgumentException.class,
                ()->CourseMaxNumberLimit.of(null));
    }
}
