package org.domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * The type Acronym.
 */
@Embeddable
public class EntryNumber implements ValueObject {
    /**
     * Board Entry number.
     */
    @Column(name = "ENTRY_NUMBER")
    private final Integer value;

    /**
     * The constant MIN_ROWS and MIN_COLUMNS.
     */
    private static final Integer MIN_ROWS_COL = 1;

    /**
     * Instantiates a new EntryNumber.
     */
    protected EntryNumber() {
        this.value = null;
    }

    private EntryNumber(final String valuep,
                        final BoardRow boardRowPosp,
                        final BoardCol boardColPosp,
                        final BoardNRow boardNRowp,
                        final BoardNCol boardNColp) {
        Preconditions.nonEmpty(
                valuep,
                "The number of Columns should neither be null nor empty"
        );
        Preconditions.nonNull(
                valuep,
                "The number of Columns should neither be null nor empty"
        );

        int entryNumber = Integer.parseInt(valuep);
        int MAX_ROWS = boardNRowp.value();
        int MAX_COLUMNS = boardNColp.value();
        int boardRowPos = boardRowPosp.value();
        int boardColPos = boardColPosp.value();

        Preconditions.ensure(
                (entryNumber >= MIN_ROWS_COL && entryNumber <= MAX_ROWS
                && boardColPos == MIN_ROWS_COL)
                || (entryNumber >= MIN_ROWS_COL && entryNumber <= MAX_COLUMNS
                        && boardRowPos == MIN_ROWS_COL),
                "The Entry Number should be on Board Grid"
        );

        this.value = entryNumber;
    }

    /**
     * Factory method to create a EntryNumber instance.
     * @param valuep The value of the entry.
     * @param boardColPosp
     * @param boardRowPosp
     * @param boardNRowp
     * @param boardNColp
     * @return EntryNumber instance.
     */
    public static EntryNumber of(final String valuep,
                                 final BoardRow boardRowPosp,
                                 final BoardCol boardColPosp,
                                 final BoardNRow boardNRowp,
                                 final BoardNCol boardNColp) {
        return new EntryNumber(valuep, boardRowPosp,
                boardColPosp, boardNRowp, boardNColp);
    }

    /**
     * Value int.
     * @return the int
     */
    public int value() {
        return value;
    }

    /**
     * Compare if EntryNumber is equals to another object.
     * @param obj
     * @return true/false
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        EntryNumber other = (EntryNumber) obj;
        return Objects.equals(value, other.value);
    }

}
