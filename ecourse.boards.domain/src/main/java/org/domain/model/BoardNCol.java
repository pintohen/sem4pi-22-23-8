package org.domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import org.ecourse.Application;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * The type Acronym.
 */
@Embeddable
public class BoardNCol implements ValueObject {
    /**
     * Board Title of Entity.
     */
    @Column(name = "BOARD_N_COL")
    private final Integer value;

    /**
     * The constant MAX_LENGTH.
     */
    private static final Integer MAX_COLUMNS = Integer.valueOf(
            Application.settings().maxColumns());


    /**
     * The constant MIN_LENGTH.
     */
    private static final Integer MIN_COLUMNS = 1;

    /**
     * Instantiates a new BoardNCol.
     */
    protected BoardNCol() {
        this.value = null;
    }

    private BoardNCol(final String valuep) {
        Preconditions.nonEmpty(
                valuep,
                "The number of Columns should neither be null nor empty"
        );
        Preconditions.nonNull(
                valuep,
                "The number of Columns should neither be null nor empty"
        );

        int nColumns = Integer.parseInt(valuep);

        Preconditions.ensure(
                nColumns >= MIN_COLUMNS && nColumns <= MAX_COLUMNS,
                "The number of Columns should have between 1 and "
                        + MAX_COLUMNS
        );

        this.value = nColumns;
    }

    /**
     * Factory method to create a BoardNCol instance.
     * @param valuep The value of the board number of columns.
     * @return BoardNCol instance.
     */
    public static BoardNCol of(final String valuep) {
        return new BoardNCol(valuep);
    }

    /**
     * Value int.
     * @return the int
     */
    public int value() {
        return value;
    }

    /**
     * Compare if BoardNCol is same then another object.
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
        BoardNCol other = (BoardNCol) obj;
        return Objects.equals(value, other.value);
    }

}
