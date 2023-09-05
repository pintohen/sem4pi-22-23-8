package org.usermanagement.domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * The type Short name.
 */
@Embeddable
public class ShortName implements ValueObject {
    /**
     * Short name of Entity.
     */
    @Column(name = "short_name")
    private final String value;

    /**
     * Instantiates a new Short name.
     */
    protected ShortName() {
        value = null;
    }

    /**
     * Minimum number of characters for a short name.
     */
    private static final int MIN_NUMBER_OF_CHARACTERS = 3;
    private ShortName(final String valuep) {
        this.value = valuep;
    }

    /**
     * Factory method to create a short name instance.
     *
     * @param valuep The value of the short name.
     * @return ShortName instance.
     */
    public static ShortName of(final String valuep) {
        Preconditions.nonNull(valuep, "Short Name can't be null.");
        Preconditions.nonEmpty(valuep, "Short Name can't be empty.");
        Preconditions.ensure(valuep.length() > MIN_NUMBER_OF_CHARACTERS,
                    "Short name must have "
                        + MIN_NUMBER_OF_CHARACTERS + " characters or more");
        return new ShortName(valuep);
    }

    /**
     * Return Short Name value in String.
     *
     * @return String string
     */
    public String value() {
        return this.value;
    }


    /**
     * Equals boolean.
     *
     * @param o the o
     * @return the boolean
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        ShortName shortName = (ShortName) o;

        return Objects.equals(value, shortName.value);
    }

    /**
     * Hash code int.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return value != null ? value.hashCode() : 0;
    }
}
