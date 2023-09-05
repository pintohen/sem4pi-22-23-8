package org.domain.model.postit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostItStateTypeTest {
    @Test
    public void testAllPostItStateTypes() {
        PostItState[] allStates = PostItStateType.allPostItStateTypes();

        assertEquals(4, allStates.length);
    }
}