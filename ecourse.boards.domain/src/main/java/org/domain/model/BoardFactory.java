package org.domain.model;

import org.usermanagement.domain.model.User;

import java.util.List;

public class BoardFactory {
    /**
     * BoardFactory constructor.
     */
    public BoardFactory() {

    }

    /**
     * Create BoardFactory.
     * @param boardTitlep
     * @param boardNRowp
     * @param boardNColp
     * @param allBoardEntrys
     * @param boardOwnerp
     * @return Board
     */
    public Board create(final String boardTitlep,
                        final String boardNRowp,
                        final String boardNColp,
                        final List<BoardEntry> allBoardEntrys,
                        final User boardOwnerp) {
        return new Board(
                BoardTitle.of(boardTitlep),
                BoardNRow.of(boardNRowp),
                BoardNCol.of(boardNColp),
                allBoardEntrys,
                boardOwnerp
        );
    }
}
