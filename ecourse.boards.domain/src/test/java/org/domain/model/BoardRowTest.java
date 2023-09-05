package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardRowTest {
    @Test
    void testCreateValidBoardRow() {
        BoardNRow boardNRow = BoardNRow.of("5");
        BoardRow boardRow = BoardRow.of("3", boardNRow);

        assertEquals(3, boardRow.value());
    }

    @Test
    void testCreateInvalidBoardRowWithNegativeValue() {
        BoardNRow boardNRow = BoardNRow.of("5");

        assertThrows(IllegalArgumentException.class,
                () -> BoardRow.of("-1", boardNRow));
    }

    @Test
    void testCreateInvalidBoardRowWithValueGreaterThanMaxColumns() {
        BoardNRow boardNRow = BoardNRow.of("5");

        assertThrows(IllegalArgumentException.class,
                () -> BoardRow.of("6", boardNRow));
    }

    @Test
    void testCreateInvalidBoardRowWithNullValue() {
        BoardNRow boardNRow = BoardNRow.of("5");

        assertThrows(IllegalArgumentException.class,
                () -> BoardRow.of(null, boardNRow));
    }

    @Test
    void testCreateInvalidBoardRowWithEmptyValue() {
        BoardNRow boardNRow = BoardNRow.of("5");

        assertThrows(IllegalArgumentException.class,
                () -> BoardRow.of("", boardNRow));
    }

    @Test
    void BoardRowEquals() {
        BoardNRow boardNRow = BoardNRow.of("5");

        BoardRow boardRow = BoardRow.of("3", boardNRow);
        assertTrue(boardRow.equals(boardRow));

        BoardRow boardRow2 = BoardRow.of("3", boardNRow);
        assertTrue(boardRow.equals(boardRow2));

        BoardRow boardRow3 = BoardRow.of("1", boardNRow);
        assertFalse(boardRow.equals(boardRow3));

        assertFalse(boardRow.equals(null));

        assertFalse(boardRow.equals(new Object()));
    }
}