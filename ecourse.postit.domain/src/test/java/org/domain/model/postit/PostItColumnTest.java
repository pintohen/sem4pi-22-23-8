package org.domain.model.postit;

import org.domain.model.BoardNCol;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostItColumnTest {
    private static final String BOARD_N_COL = "5";
    private static final String POST_IT_COLUMN = "3";

    @Test
    public void createPostItColumnWithValueWithinRange() {
        BoardNCol boardNCol = BoardNCol.of(BOARD_N_COL);
        PostItColumn postItColumn = PostItColumn.of(POST_IT_COLUMN, boardNCol);

        assertEquals(Integer.parseInt(POST_IT_COLUMN), postItColumn.value());
    }

    @Test
    public void createPostItColumnWithNullValue() {
        BoardNCol boardNCol = BoardNCol.of(BOARD_N_COL);

        assertThrows(IllegalArgumentException.class, () -> {
            PostItColumn.of(null, boardNCol);
        });
    }

    @Test
    public void createPostItColumnWithEmptyValue() {
        BoardNCol boardNCol = BoardNCol.of(BOARD_N_COL);

        assertThrows(IllegalArgumentException.class, () -> {
            PostItColumn.of("", boardNCol);
        });
    }

    @Test
    public void createPostItColumnWithValueOutsideRange() {
        BoardNCol boardNCol = BoardNCol.of(BOARD_N_COL);

        assertThrows(IllegalArgumentException.class, () -> {
            PostItColumn.of("6", boardNCol);
        });
    }

    @Test
    public void testEquality() {
        String value1 = "3";
        String value2 = "2";
        BoardNCol boardNCol = BoardNCol.of(BOARD_N_COL);

        PostItColumn postItColumn1 = PostItColumn.of(value1, boardNCol);
        PostItColumn postItColumn2 = PostItColumn.of(value1, boardNCol);
        PostItColumn postItColumn3 = PostItColumn.of(value2, boardNCol);

        assertEquals(postItColumn1, postItColumn2);
        assertNotEquals(postItColumn1, postItColumn3);
        assertNotEquals(postItColumn1, null);
        assertEquals(postItColumn1, postItColumn1);
    }
}