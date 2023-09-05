package org.domain.model;

public class BoardEntryFactory {

    /**
     * BoardEntryFactory constructor.
     */
    public BoardEntryFactory() {

    }

    /**
     * Create BoardEntry.
     * @param entryNumberp
     * @param boardRowp
     * @param boardColp
     * @param entryTitlep
     * @param boardNRowp
     * @param boardNColp
     * @return BoardEntry
     */
    public BoardEntry create(final String entryNumberp,
                             final String boardRowp,
                             final String boardColp,
                             final String entryTitlep,
                             final String boardNRowp,
                             final String boardNColp) {
        BoardNRow boardNRow = BoardNRow.of(boardNRowp);
        BoardNCol boardNCol = BoardNCol.of(boardNColp);

        BoardRow boardRow = BoardRow.of(boardRowp, boardNRow);
        BoardCol boardCol = BoardCol.of(boardColp, boardNCol);


        return new BoardEntry(
                EntryNumber.of(entryNumberp, boardRow,
                        boardCol, boardNRow, boardNCol),
                boardRow,
                boardCol,
                EntryTitle.of(entryTitlep)
        );
    }
}
