package org.domain.model.postit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostItStateTest {
    @Test
    public void testValueOf() {
        PostItState state = PostItState.valueOf("CREATED");
        assertEquals("CREATED", state.toString());
    }

    @Test
    public void testEquals() {
        PostItState state1 = PostItState.valueOf("UPDATED");
        PostItState state2 = PostItState.valueOf("UPDATED");
        PostItState state3 = PostItState.valueOf("MOVED");

        assertEquals(state1, state2);
        assertEquals(state2, state1);

        assertNotEquals(state1, state3);
        assertNotEquals(state2, state3);
        assertEquals(state1, state1);
        assertNotEquals(state1, null);
    }

    @Test
    public void testAllPostItStateTypes() {
        PostItState[] allStates = PostItStateType.allPostItStateTypes();

        assertEquals(4, allStates.length);
        assertEquals(PostItState.valueOf("CREATED"), allStates[0]);
        assertEquals(PostItState.valueOf("UPDATED"), allStates[1]);
        assertEquals(PostItState.valueOf("MOVED"), allStates[2]);
        assertEquals(PostItState.valueOf("DELETED"), allStates[3]);
    }
}