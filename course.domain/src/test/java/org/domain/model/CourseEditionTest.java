package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertEquals;
public class CourseEditionTest {
    @Test
    void ensureNonNull(){
        assertThrows(IllegalArgumentException.class,
                ()->CourseEdition.of(null));
    }

    @Test
    void compareTo(){
        CourseEdition edition = CourseEdition.of("MAT-SEM01");
        assertEquals(1, edition.compareTo(CourseEdition.of("MAT-SEM01")));
    }
}
