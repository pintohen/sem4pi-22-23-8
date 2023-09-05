package org.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "T_BOARD_ENTRY")
public class BoardEntry
        implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Version of board.
     */
    @Version
    private Long version;

    /**
     * Board Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long entryId;

    /**
     * Board Entry Number.
     */
    private EntryNumber entryNumber;

    /**
     * Board Row position.
     */
    private BoardRow boardRow;

    /**
     * Board Column position.
     */
    private BoardCol boardCol;

    /**
     * Board EntryTitle position.
     */
    private EntryTitle entryTitle;


    protected BoardEntry() {

    }

    BoardEntry(final EntryNumber entryNumberp,
               final BoardRow boardRowp,
               final BoardCol boardColp,
               final EntryTitle entryTitlep) {
        this.entryNumber = entryNumberp;
        this.boardRow = boardRowp;
        this.boardCol = boardColp;
        this.entryTitle = entryTitlep;
    }

    /**
     * Board row position get.
     * @return BoardRow
     */
    public BoardRow boardRow() {
        return boardRow;
    }

    /**
     * Board column position get.
     * @return BoardCol
     */
    public BoardCol boardCol() {
        return boardCol;
    }

    /**
     * Board entry title get.
     * @return EntryTitle
     */
    public EntryTitle entryTitle() {
        return entryTitle;
    }

    /**
     * Board entry number get.
     * @return EntryNumber
     */
    public EntryNumber entryNumber() {
        return entryNumber;
    }

    /**
     * Check if some BoardEntry is the same object then other.
     * @param other
     * @return true/false
     */
    public boolean sameAs(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof BoardEntry)) {
            return false;
        }

        BoardEntry that = (BoardEntry) other;

        return Objects.equals(this.entryId, that.entryId)
                && Objects.equals(this.entryNumber, that.entryNumber)
                && Objects.equals(this.boardRow, that.boardRow)
                && Objects.equals(this.boardCol, that.boardCol)
                && Objects.equals(this.entryTitle, that.entryTitle);
    }

    /**
     * @return entryId
     */
    public Long identity() {
        return entryId;
    }
}
