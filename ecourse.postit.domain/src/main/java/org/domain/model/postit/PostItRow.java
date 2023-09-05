package org.domain.model.postit;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import org.domain.model.BoardNRow;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * The PostItRow.
 */
@Embeddable
public class PostItRow implements ValueObject {
    /**
     * Post-It Row of Entity.
     */
    @Column(name = "POST_IT_ROW")
    private final Integer value;

    /**
     * The constant MIN_LENGTH.
     */
    private static final Integer MIN_ROWS = 2;

    /**
     * Instantiates a new PostItRow.
     */
    protected PostItRow() {
        this.value = null;
    }

    private PostItRow(final String valuep, BoardNRow boardNRow) {
        Preconditions.nonEmpty(
                valuep,
                "The Post-It Row position should neither be null nor empty"
        );
        Preconditions.nonNull(
                valuep,
                "The Post-It Row position should neither be null nor empty"
        );

        int rowPos = Integer.parseInt(valuep);
        int maxRows = boardNRow.value();

        Preconditions.ensure(
                rowPos >= MIN_ROWS && rowPos <= maxRows,
                "The Post-It Row position should have between " + MIN_ROWS
                        + " and " + maxRows
        );

        this.value = rowPos;
    }

    /**
     * Factory method to create a PostItRow instance.
     * @param valuep The value of the post-it row position.
     * @return BoardNCol instance.
     */
    public static PostItRow of(final String valuep, final BoardNRow boardNRow) {
        return new PostItRow(valuep, boardNRow);
    }

    /**
     * Value int.
     * @return the int
     */
    public int value() {
        return value;
    }

    /**
     * Compare if PostItRow is same then another object.
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
        PostItRow other = (PostItRow) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
