package org.usermanagement.domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class FullName implements ValueObject {
    /**
     * Complete name of entity.
     */
    @Column(name = "full_name")
    private final String value;

    protected FullName() {
        value = null;
    }

    /**
     * Minimum number of characters for a full name.
     */
    private static final int MIN_NUMBER_OF_CHARACTERS = 3;

    /**
     * Constructor for FullName.
     *
     * @param valuep The value of the full name.
     */
    private FullName(final String valuep) {
        this.value = valuep;
    }

    /**
     * Factory method to create a FullName instance.
     *
     * @param valuep The value of the full name.
     * @return FullName instance.
     */
    public static FullName of(final String valuep) {
        Preconditions.nonEmpty(valuep, "Full Name can't be empty.");
        Preconditions.ensure(valuep.length() > MIN_NUMBER_OF_CHARACTERS,
                    "Full name must have "
                        + MIN_NUMBER_OF_CHARACTERS + " characters or more");
        return new FullName(valuep);
    }

    /**
     * Get fullName value.
     * @return String with full name
     */
    public String value() {
        return this.value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FullName fullName = (FullName) o;

        return Objects.equals(value, fullName.value);
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
