package org.usermanagement.domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The type Acronym.
 */
@Embeddable
public class Acronym implements ValueObject {
    /**
     * Short name of Entity.
     */
    @Column(name = "acronym")
    private final String value;

    /**
     * The constant MAX_LENGTH.
     */
    private static final Integer MAX_LENGTH = 5;


    /**
     * The constant MIN_LENGTH.
     */
    private static final Integer MIN_LENGTH = 2;

    /**
     * Instantiates a new Acronym.
     */
    protected Acronym() {
        this.value = null;
    }

    private Acronym(final String valuep) {
        Preconditions.nonEmpty(
                valuep,
                "Acronym should neither be null nor empty"
        );
        Preconditions.nonNull(
                valuep,
                "Acronym should neither be null nor empty"
        );
        Preconditions.ensure(
                valuep.length() <= MAX_LENGTH && valuep.length() >= MIN_LENGTH,
                "Acronym should have between 2 and 5 characters"
        );
        this.value = valuep;
    }

    /**
     * Factory method to create a short name instance.
     *
     * @param valuep The value of the short name.
     * @return ShortName instance.
     */
    public static Acronym of(final String valuep) {
        return new Acronym(valuep);
    }

    /**
     * Value string.
     *
     * @return the string
     */
    public String value() {
        return value;
    }
}
