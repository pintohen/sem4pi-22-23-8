package org.usermanagement.domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TaxPayerNumber
        implements ValueObject, Comparable<TaxPayerNumber> {
    /**
     * Short name of Entity.
     */
    @Column(name = "tax_payer_number", unique = true)
    private final String value;

    protected TaxPayerNumber() {
        value = null;
    }

    /**
     * Minimum number of characters for a Tax Payer Number.
     */
    private static final int MIN_NUMBER_OF_CHARACTERS = 9;
    private TaxPayerNumber(final String valuep) {
        this.value = valuep;
    }

    /**
     * Factory method to create a short name instance.
     *
     * @param valuep The value of the short name.
     * @return ShortName instance.
     */
    public static TaxPayerNumber of(final String valuep) {
        String regexPT = "[0-9]{9}";
        Preconditions.nonEmpty(valuep, "Tax payer number can't be empty.");
        Preconditions.ensure(
                valuep.matches(regexPT),
                "Tax payer number must follow portuguese format."
        );
        return new TaxPayerNumber(valuep);
    }

    /**
     * Return TaxPayerNumber value in String.
     * @return String
     */
    public String value() {
        return this.value;
    }

    /**
     * TaxPayerNumber should be unique.
     * @param o the object to be compared.
     * @return equals or not
     */
    @Override
    public int compareTo(final TaxPayerNumber o) {
        return this.value.compareTo(o.value);
    }
}
