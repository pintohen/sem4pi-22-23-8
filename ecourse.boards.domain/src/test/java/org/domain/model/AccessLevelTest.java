package org.domain.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccessLevelTest {

    @Test
    public void testAccessLevelCreation() {
        String accessLevel = String.valueOf(AccessLevelType.WRITE);
        AccessLevel al = AccessLevel.valueOf(accessLevel);

        assertNotNull(al);
        assertEquals(accessLevel, al.toString());
    }

    @Test
    public void testAccessLevelCreationWithNull() {
        String accessLevel = null;

        assertThrows(IllegalArgumentException.class,
                () -> AccessLevel.valueOf(accessLevel));
    }
    @Test
    public void testAccessLevelEquality() {
        AccessLevel accessLevel1 = AccessLevelType.WRITE;
        AccessLevel accessLevel2 = AccessLevelType.READ;
        AccessLevel accessLevel3 = AccessLevelType.WRITE;
        Object object = null;

        assertFalse(accessLevel1.equals(accessLevel2));
        assertFalse(accessLevel1.equals(object));
        assertTrue(accessLevel1.equals(accessLevel3));
    }

    @Test
    public void getAllAccessLevelTypes(){
        AccessLevel[] allAccessLevels = AccessLevelType.allAccessLevelTypes();

        assertEquals(allAccessLevels.length, 2);
    }
}
