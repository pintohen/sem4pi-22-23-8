package org.domain.model.postit;

import org.domain.model.BoardNRow;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class PostItRowTest {
    private static final String BOARD_N_ROW = "3";
    private static final String POST_IT_ROW = "2";
    @Test
    public void createPostItRowWithValueWithinRange() {
        BoardNRow boardNRow = BoardNRow.of(BOARD_N_ROW);
        PostItRow postItRow = PostItRow.of(POST_IT_ROW, boardNRow);

        assertEquals(Integer.parseInt(POST_IT_ROW), postItRow.value());
    }

    @Test
    public void createPostItRowWithNullValue() {
        BoardNRow boardNRow = BoardNRow.of(BOARD_N_ROW);

        assertThrows(IllegalArgumentException.class, () -> {
            PostItRow.of(null, boardNRow);
        });
    }

    @Test
    public void createPostItRowWithEmptyValue() {
        BoardNRow boardNRow = BoardNRow.of(BOARD_N_ROW);

        assertThrows(IllegalArgumentException.class, () -> {
            PostItRow.of("", boardNRow);
        });
    }

    @Test
    public void createPostItRowWithValueOutsideRange() {
        BoardNRow boardNRow = BoardNRow.of(BOARD_N_ROW);

        assertThrows(IllegalArgumentException.class, () -> {
            PostItRow.of("6", boardNRow);
        });
    }

    @Test
    public void testEquality() {
        String value1 = "3";
        String value2 = "2";
        BoardNRow boardNRow = BoardNRow.of(BOARD_N_ROW);

        PostItRow postItRow1 = PostItRow.of(value1, boardNRow);
        PostItRow postItRow2 = PostItRow.of(value1, boardNRow);
        PostItRow postItRow3 = PostItRow.of(value2, boardNRow);

        assertEquals(postItRow1, postItRow2);
        assertNotEquals(postItRow1, postItRow3);
        assertNotEquals(postItRow1, null);
        assertEquals(postItRow1, postItRow1);
    }
}