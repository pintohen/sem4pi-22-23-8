package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;

class EntryTitleTest {
    @Test
    void createEntryTitleWithValue() {
        String title = "Test Entry Title";
        EntryTitle entryTitle = EntryTitle.of(title);

        assertNotNull(entryTitle);
        assertEquals(title, entryTitle.value());
    }

    @Test
    void createEntryTitleWithNullValue() {
        assertThrows(IllegalArgumentException.class,
                () -> EntryTitle.of(null));
    }

    @Test
    void createEntryTitleWithEmptyValue() {
        String title = "";
        EntryTitle entryTitle = EntryTitle.of(title);

        assertNotNull(entryTitle);
        assertEquals(title, entryTitle.value());
    }

    @Test
    void createEntryTitleWithValueExceedingMaxLength() {
        String title = "This title has more than fifty characters"
                + " and should throw an exception";

        assertThrows(IllegalArgumentException.class,
                () -> EntryTitle.of(title));
    }

    @Test
    public void testBoardTitleEquals() {
        EntryTitle title1 = EntryTitle.of("Title 1");
        EntryTitle title2 = EntryTitle.of("Title 1");
        EntryTitle title3 = EntryTitle.of("Title 2");
        EntryTitle title4 = null;

        assertEquals(title1, title1);

        assertEquals(title1, title2);

        assertNotEquals(title1, title3);
        assertNotEquals(title1, title4);
    }
}