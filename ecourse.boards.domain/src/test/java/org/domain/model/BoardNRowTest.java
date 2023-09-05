package org.domain.model;

import org.ecourse.Application;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardNRowTest {
    @Test
    public void testCreateValidboardNRow() {
        String validValue = "5";

        BoardNRow boardNRow = BoardNRow.of(validValue);

        assertNotNull(boardNRow);
        assertEquals(Integer.parseInt(validValue), boardNRow.value());
    }

    @Test
    public void testCreateInvalidboardNRowWithNegativeValue() {
        String invalidValue = "-1";

        assertThrows(IllegalArgumentException.class,
                () -> BoardNRow.of(invalidValue));
    }

    @Test
    public void testCreateInvalidboardNRowWithZeroValue() {
        String invalidValue = "0";

        assertThrows(IllegalArgumentException.class,
                () -> BoardNRow.of(invalidValue));
    }

    @Test
    public void testCreateInvalidboardNRowWithValueGreaterThanMax() {
        String invalidValue = Application.settings().maxRows() + 1;

        assertThrows(IllegalArgumentException.class,
                () -> BoardNRow.of(invalidValue));
    }

    @Test
    void BoardNRowEquals() {
        BoardNRow boardNRow = BoardNRow.of("5");
        assertTrue(boardNRow.equals(boardNRow));

        BoardNRow boardNRow2 = BoardNRow.of("5");
        assertTrue(boardNRow.equals(boardNRow2));

        BoardNRow boardNRow3 = BoardNRow.of("1");
        assertFalse(boardNRow.equals(boardNRow3));

        assertFalse(boardNRow.equals(null));

        assertFalse(boardNRow.equals(new Object()));
    }
}