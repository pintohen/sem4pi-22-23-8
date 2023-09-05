package org.domain.model.postit;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import org.domain.model.BoardNCol;
import org.ecourse.Application;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * The PostItColumn.
 */
@Embeddable
public class PostItColumn implements ValueObject {
    /**
     * Post-It Column of Entity.
     */
    @Column(name = "POST_IT_COL")
    private final Integer value;

    /**
     * The constant MIN_LENGTH.
     */
    private static final Integer MIN_COLUMNS = 2;

    /**
     * Instantiates a new BoardNCol.
     */
    protected PostItColumn() {
        this.value = null;
    }

    private PostItColumn(final String valuep, final BoardNCol boardNCol) {
        Preconditions.nonEmpty(
                valuep,
                "The Post-It Column position should neither be null nor empty"
        );
        Preconditions.nonNull(
                valuep,
                "The Post-It Column position should neither be null nor empty"
        );

        int nColumns = Integer.parseInt(valuep);
        int maxColumns = boardNCol.value();

        Preconditions.ensure(
                nColumns >= MIN_COLUMNS && nColumns <= maxColumns,
                "The Post-It Column position should have between " + MIN_COLUMNS
                        + " and " + maxColumns
        );

        this.value = nColumns;
    }

    /**
     * Factory method to create a PostItColumn instance.
     * @param valuep The value of the Post-It Column position.
     * @return BoardNCol instance.
     */
    public static PostItColumn of(final String valuep, final BoardNCol boardNCol) {
        return new PostItColumn(valuep, boardNCol);
    }

    /**
     * Value int.
     * @return the int
     */
    public int value() {
        return value;
    }

    /**
     * Compare if PostItColumn is same then another object.
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
        PostItColumn other = (PostItColumn) obj;
        return Objects.equals(value, other.value);
    }
}
