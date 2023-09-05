package org.enrollment.request.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

/**
 * The type Requested date.
 */
@Embeddable
public class RequestedDate {
    /**
     * The Value.
     */
    @Column(name = "requested_date", nullable = false)
    private LocalDate value;

    /**
     * Instantiates a new Requested date.
     */
    protected RequestedDate() {
        // for ORM
    }

    private RequestedDate(final LocalDate valuep) {
        Preconditions.ensure(
                valuep != null,
                "A request should have a date it was made"
        );
        this.value = valuep;
    }

    /**
     * Init requested date.
     *
     * @return the requested date
     */
    public static RequestedDate init() {
        return new RequestedDate(LocalDate.now());
    }

    /**
     * Init requested date.
     *
     * @param date the date
     * @return the requested date
     */
    public static RequestedDate init(final LocalDate date) {
        return new RequestedDate(date);
    }
}
