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
public class EntryTitle implements ValueObject {
    /**
     * Board Entry Title.
     */
    @Column(name = "ENTRY_TITLE")
    private final String value;

    /**
     * The constant MAX_LENGTH.
     */
    private static final Integer MAX_LENGTH = 50;


    /**
     * Instantiates a new EntryTitle.
     */
    protected EntryTitle() {
        this.value = null;
    }

    private EntryTitle(final String valuep) {
        Preconditions.nonNull(
                valuep,
                "Board Entry Title should neither be null nor empty"
        );
        Preconditions.ensure(
                valuep.length() <= MAX_LENGTH,
                "Board Entry Title should have max "
                        + MAX_LENGTH + " characters"
        );

        this.value = valuep;
    }

    /**
     * Factory method to create a EntryTitle instance.
     * @param valuep The value of the board entry title.
     * @return EntryTitle instance.
     */
    public static EntryTitle of(final String valuep) {
        return new EntryTitle(valuep);
    }

    /**
     * Value string.
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * Compare if is EntryTitle is equals to another object.
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
        EntryTitle other = (EntryTitle) obj;
        return Objects.equals(value, other.value);
    }

}
