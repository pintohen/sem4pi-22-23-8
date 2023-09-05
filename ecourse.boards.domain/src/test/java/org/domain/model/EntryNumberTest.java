package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryNumberTest {
    private final BoardNRow boardNRow = BoardNRow.of("5");
    private final BoardRow boardRow = BoardRow.of("1", boardNRow);
    private final BoardNCol boardNCol = BoardNCol.of("5");
    private final BoardCol boardCol = BoardCol.of("2", boardNCol);

    @Test
    void testValidEntryNumber() {
        EntryNumber entryNumber = EntryNumber.of("5", boardRow,
                boardCol, boardNRow, boardNCol);

        assertEquals(5, entryNumber.value());
    }

    @Test
    void testMoreThenValidEntryNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> EntryNumber.of("10",
                        boardRow, boardCol, boardNRow, boardNCol));
    }

    @Test
    void testInvalidEntryNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> EntryNumber.of("-1",
                        boardRow, boardCol, boardNRow, boardNCol));
    }

    @Test
    void testNullEntryNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> EntryNumber.of(null,
                        boardRow, boardCol, boardNRow, boardNCol));
    }

    @Test
    void testEmptyEntryNumber() {
        assertThrows(IllegalArgumentException.class,
                () -> EntryNumber.of("",
                        boardRow, boardCol, boardNRow, boardNCol));
    }

    @Test
    void testEntryNumberEquals() {
        EntryNumber entryNumber1 = EntryNumber.of("5", boardRow,
                boardCol, boardNRow, boardNCol);
        EntryNumber entryNumber2 = EntryNumber.of("5", boardRow,
                boardCol, boardNRow, boardNCol);
        EntryNumber entryNumber3 = EntryNumber.of("3", boardRow,
                boardCol, boardNRow, boardNCol);;

        assertTrue(entryNumber1.equals(entryNumber1));

        assertTrue(entryNumber1.equals(entryNumber2));;

        // test non-equality
        assertFalse(entryNumber1.equals(entryNumber3));
        assertFalse(entryNumber1.equals(null));
    }
}