package org.enrollment.request.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

/**
 * The type Answered date.
 */
@Embeddable
public class AnsweredDate {
    /**
     * The Value.
     */
    @Column(name = "answered_date")
    private LocalDate value;

    /**
     * Instantiates a new Answered date.
     */
    public AnsweredDate() {
        // for ORM
    }

    private AnsweredDate(final LocalDate valuep) {
        this.value = valuep;
    }

    /**
     * Init answered date.
     *
     * @return the answered date
     */
    public static AnsweredDate init() {
        return new AnsweredDate(LocalDate.now());
    }

    /**
     * Init answered date.
     *
     * @param date the date
     * @return the answered date
     */
    public static AnsweredDate init(final LocalDate date) {
        return new AnsweredDate(date);
    }

    /**
     * Value local date.
     *
     * @return the local date
     */
    public LocalDate value() {
        return this.value;
    }

}
