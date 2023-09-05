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
public class BoardRow implements ValueObject {
    /**
     * Board Row position.
     */
    @Column(name = "BOARD_ROW")
    private final Integer value;

    /**
     * The constant MIN_LENGTH.
     */
    private static final Integer MIN_ROWS = 1;

    /**
     * Instantiates a new BoardRow.
     */
    protected BoardRow() {
        this.value = null;
    }

    private BoardRow(final String valuep,
                     final BoardNRow boardNRowp) {
        Preconditions.nonEmpty(
                valuep,
                "Row position should neither be null nor empty"
        );
        Preconditions.nonNull(
                valuep,
                "Row position should neither be null nor empty"
        );

        int nRows = Integer.parseInt(valuep);
        int MAX_ROWS = boardNRowp.value();

        Preconditions.ensure(
                nRows >= MIN_ROWS && nRows <= MAX_ROWS,
                "Row position should have between 1 and "
                        + MAX_ROWS
        );

        this.value = nRows;
    }

    /**
     * Factory method to create a BoardRow instance.
     * @param valuep The value of the board row position.
     * @param boardNRowp
     * @return BoardRow instance.
     */
    public static BoardRow of(final String valuep,
                              final BoardNRow boardNRowp) {
        return new BoardRow(valuep, boardNRowp);
    }

    /**
     * Value int.
     * @return the int
     */
    public int value() {
        return value;
    }

    /**
     * Compare BoardRow with another object.
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
        BoardRow other = (BoardRow) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public String toString(){
        return String.valueOf(value);
    }
}
