package org.usermanagement.domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class MecanographicNumber
        implements ValueObject, Comparable<MecanographicNumber> {

    /**
     * Number is year + value.
     */
    @Column(name = "number_mec", unique = true)
    private String number;

    /**
     * Year that Student got registered.
     */
    @Transient
    private Integer year;

    /**
     * Increment number.
     */
    @Transient
    private Integer value;

    /**
     * Substring 4 character.
     */
    private static final int SUB_STRING = 4;

    /**
     * Max valid MecanographicNumber.
     */
    private static final int MAX_VALID = 100000;

    /**
     * Build number MecanographicNumber.
     */
    private static final int BUILD_NUMBER = 5;

    /**
     * Hash number multiplier.
     */
    private static final int HASH_NUMBER = 31;

    protected MecanographicNumber(final String mecanographicNumberp) {
        int yearT = Integer.parseInt(
                    mecanographicNumberp.substring(0, SUB_STRING));
        int valueT = Integer.parseInt(
                     mecanographicNumberp.substring(SUB_STRING));
        ensureValid(yearT, valueT, mecanographicNumberp);
        this.number = mecanographicNumberp;

    }

    private MecanographicNumber(final Integer yearp, final Integer valuep) {
        String numberT = buildNumber(yearp, valuep);
        ensureValid(yearp, valuep, numberT);
        this.year = yearp;
        this.value = valuep;
        this.number = numberT;
    }

    private void ensureValid(final Integer yearp,
                             final Integer valuep,
                             final String numberp) {
        Preconditions.ensure(
                yearp <= LocalDate.now().getYear(),
                "Year cannot be greater than current year"
        );
        Preconditions.ensure(
                valuep > 0,
                "Value cannot be negative or zero"
        );
        Preconditions.ensure(
                valuep < MAX_VALID,
                "Value cannot be greater than 99999 (have more than 5 digits)"
        );
    }

    private String buildNumber(final Integer yearp, final Integer valuep) {
        StringBuilder sb = new StringBuilder();
        int lenVal = valuep.toString().length();

        for (int i = lenVal; i < BUILD_NUMBER; i++) {
            sb.append("0");
        }

        sb.append(valuep);

        return yearp.toString() + sb;
    }

    protected MecanographicNumber() {
        // for ORM
    }

    /**
     * Transform String into MecanographicNumber object.
     * @param mecanographicNumber
     * @return MecanographicNumber
     */
    public static MecanographicNumber of(final String mecanographicNumber) {
        return new MecanographicNumber(mecanographicNumber);
    }

    /**
     * Transform year and value into MecanographicNumber object.
     * @param year
     * @param value
     * @return MecanographicNumber
     */
    public static MecanographicNumber of(final Integer year,
                                         final Integer value) {
        return new MecanographicNumber(year, value);
    }

    /**
     * Transform value into MecanographicNumber object.
     * @param value
     * @return MecanographicNumber
     */
    public static MecanographicNumber of(final Integer value) {
        return new MecanographicNumber(LocalDate.now().getYear(), value);
    }

    /**
     * Show number in a String.
     * @return String of number
     */
    @Override
    public String toString() {
        return this.number;
    }

    /**
     * Compare two MecanographicNumber.
     * @param arg0 the object to be compared.
     * @return -1/0/1
     */
    @Override
    public int compareTo(final MecanographicNumber arg0) {
        return number.compareTo(arg0.number);
    }

    /**
     * Get MecanographicNumber.
     * @return String
     */
    public String value() {
        return this.number;
    }

    /**
     * Check if two MecanographicNumber are the same.
     * @param o
     * @return
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        MecanographicNumber that = (MecanographicNumber) o;

        if (!Objects.equals(number, that.number)) {
            return false;
        }

        if (!Objects.equals(year, that.year)) {
            return false;
        }

        return Objects.equals(value, that.value);
    }

    /**
     * Hash Code function.
     * @return int
     */
    @Override
    public int hashCode() {
        int result = number != null ? number.hashCode() : 0;
        result = HASH_NUMBER * result + (year != null ? year.hashCode() : 0);
        result = HASH_NUMBER * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    /**
     * Generate next number.
     */
    public void nextNumber() {
        this.number = String.valueOf(Integer.parseInt(this.number) + 1);
    }
}
