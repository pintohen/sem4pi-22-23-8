package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class BoardTitleTest {
    @Test
    public void testCreateBoardTitleWithValidValue() {
        BoardTitle boardTitle = BoardTitle.of("My Board Title");

        assertEquals("My Board Title", boardTitle.value());
    }

    @Test
    public void testCreateBoardTitleWithNullValue() {
        assertThrows(IllegalArgumentException.class,
                () -> BoardTitle.of(null));
    }

    @Test
    public void testCreateBoardTitleWithEmptyValue() {
        assertThrows(IllegalArgumentException.class,
                () -> BoardTitle.of(""));
    }

    @Test
    public void testCreateBoardTitleWithTooShortValue() {
        assertThrows(IllegalArgumentException.class,
                () -> BoardTitle.of("abc"));
    }

    @Test
    public void testCreateBoardTitleWithTooLongValue() {
        String longTitle = "This is a really long board title that exceeds"
                + "the maximum allowed length of 50 characters";

        assertThrows(IllegalArgumentException.class,
                () -> BoardTitle.of(longTitle));
    }

    @Test
    public void testBoardTitleEquals() {
        BoardTitle title1 = BoardTitle.of("Title 1");
        BoardTitle title2 = BoardTitle.of("Title 1");
        BoardTitle title3 = BoardTitle.of("Title 2");
        BoardTitle title4 = null;
        String title5 = "Title 1";

        assertEquals(title1, title1);

        assertEquals(title1, title2);

        assertNotEquals(title1, title4);

        assertNotEquals(title1, title5);
    }
}