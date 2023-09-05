package org.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardEntryTest {
    @Test
    public void testCreateBoardEntry() {
        BoardEntryFactory factory = new BoardEntryFactory();

        BoardEntry entry = factory.create("1", "1", "1", "Entry 1", "3", "3");

        assertEquals(null, entry.identity());
        assertEquals(EntryNumber.of("1",
                BoardRow.of("1", BoardNRow.of("3")),
                BoardCol.of("1", BoardNCol.of("3")),
                BoardNRow.of("3"), BoardNCol.of("3"))
                .value(), entry.entryNumber().value());
        assertEquals(BoardRow.of("1", BoardNRow.of("3")).value(),
                entry.boardRow().value());
        assertEquals(BoardCol.of("1", BoardNCol.of("3")).value(),
                entry.boardCol().value());
        assertEquals(EntryTitle.of("Entry 1").value(),
                entry.entryTitle().value());
    }

    @Test
    public void testCreateBoardEntryWithInvalidEntryNumber() {
        BoardEntryFactory factory = new BoardEntryFactory();

       assertThrows(IllegalArgumentException.class,
               () -> factory.create("-1",
                       "1",
                       "1",
                       "Entry 1",
                       "3",
                       "3"));
    }

    @Test
    public void testCreateBoardEntryWithInvalidBoardRow() {
        BoardEntryFactory factory = new BoardEntryFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create("1",
                        "-1",
                        "1",
                        "Entry 1",
                        "3",
                        "3"));
    }

    @Test
    public void testCreateBoardEntryWithInvalidBoardCol() {
        BoardEntryFactory factory = new BoardEntryFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create("1",
                        "1",
                        "-1",
                        "Entry 1",
                        "3",
                        "3"));
    }

    @Test
    public void testCreateBoardEntryWithInvalidEntryTitle() {
        BoardEntryFactory factory = new BoardEntryFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create("1",
                        "1",
                        "1",
                        "This title has more than fifty characters"
                                + " and should throw an exception",
                        "3",
                        "3"));
    }

    @Test
    public void testCreateBoardEntryWithInvalidNumberOfRows() {
        BoardEntryFactory factory = new BoardEntryFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create("1",
                        "1",
                        "1",
                        "Entry 1",
                        "-1",
                        "3"));
    }

    @Test
    public void testCreateBoardEntryWithInvalidNumberOfColumns() {
        BoardEntryFactory factory = new BoardEntryFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create("1",
                        "1",
                        "1",
                        "Entry 1",
                        "3",
                        "-1"));
    }

    @Test
    public void testCreateBoardEntryWithMoreRowsThenNumberOfRows() {
        BoardEntryFactory factory = new BoardEntryFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create("1",
                        "4",
                        "1",
                        "Entry 1",
                        "3",
                        "3"));
    }

    @Test
    public void testCreateBoardEntryWithMoreColumnsThenNumberOfColumns() {
        BoardEntryFactory factory = new BoardEntryFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create("1",
                        "1",
                        "4",
                        "Entry 1",
                        "3",
                        "3"));
    }

    @Test
    public void boardEntrySameAs() {
        BoardEntryFactory factory = new BoardEntryFactory();

        BoardEntry boardEntry1 = factory.create("1",
                "1", "1", "Entry 1",
                "3", "3");
        assertTrue(boardEntry1.sameAs(boardEntry1));

        BoardEntry boardEntry2 = factory.create("1",
                "1", "1", "Entry 1",
                "3", "3");
        assertTrue(boardEntry1.sameAs(boardEntry2));

        BoardEntry boardEntry3 = factory.create("2",
                "2", "1", "Entry 1",
                "3", "3");
        assertFalse(boardEntry1.sameAs(boardEntry3));

        assertFalse(boardEntry1.sameAs(null));

        assertFalse(boardEntry1.sameAs(new Object()));
    }
}