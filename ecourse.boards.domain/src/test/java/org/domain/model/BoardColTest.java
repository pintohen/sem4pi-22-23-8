package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardColTest {
    @Test
    void testCreateValidBoardCol() {
        BoardNCol boardNCol = BoardNCol.of("5");
        BoardCol boardCol = BoardCol.of("3", boardNCol);

        assertEquals(3, boardCol.value());
    }

    @Test
    void testCreateInvalidBoardColWithNegativeValue() {
        BoardNCol boardNCol = BoardNCol.of("5");

        assertThrows(IllegalArgumentException.class,
                () -> BoardCol.of("-1", boardNCol));
    }

    @Test
    void testCreateInvalidBoardColWithValueGreaterThanMaxColumns() {
        BoardNCol boardNCol = BoardNCol.of("5");

        assertThrows(IllegalArgumentException.class,
                () -> BoardCol.of("6", boardNCol));
    }

    @Test
    void testCreateInvalidBoardColWithNullValue() {
        BoardNCol boardNCol = BoardNCol.of("5");

        assertThrows(IllegalArgumentException.class,
                () -> BoardCol.of(null, boardNCol));
    }

    @Test
    void testCreateInvalidBoardColWithEmptyValue() {
        BoardNCol boardNCol = BoardNCol.of("5");

        assertThrows(IllegalArgumentException.class,
                () -> BoardCol.of("", boardNCol));
    }

    @Test
    void BoardColumnEquals() {
        BoardNCol boardNCol = BoardNCol.of("5");

        BoardCol boardCol = BoardCol.of("3", boardNCol);
        assertTrue(boardCol.equals(boardCol));

        BoardCol boardCol2 = BoardCol.of("3", boardNCol);
        assertTrue(boardCol.equals(boardCol2));

        BoardCol boardCol3 = BoardCol.of("1", boardNCol);
        assertFalse(boardCol.equals(boardCol3));

        assertFalse(boardCol.equals(null));

        assertFalse(boardCol.equals(new Object()));
    }
}