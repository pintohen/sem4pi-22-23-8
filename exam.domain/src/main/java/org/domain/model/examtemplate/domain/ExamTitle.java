package org.domain.model.examtemplate.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.StringMixin;
import eapli.framework.validations.Preconditions;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class ExamTitle implements Serializable, ValueObject, Comparable<ExamTitle>, StringMixin {

    /**
     * The title of the exam.
     */
    @Column(name = "exam_title", unique = true)
    private final String title;

    /**
     * Constructor for ORM.
     */
    protected ExamTitle() {
        title = "";
    }

    /**
     * Creates a new ExamTitle.
     * @param title - the title of the exam.
     */
    private ExamTitle(final String title) {
        Preconditions.noneNull("Title cannot be null.");
        Preconditions.ensure(!title.isEmpty(), "Title cannot be empty.");
        Preconditions.ensure(title.length() <= 25, "Title cannot be bigger than 25 characters.");
        Preconditions.ensure(title.length() >= 3, "Title cannot be smaller than 3 characters.");
        this.title = title;
    }

    /**
     * Creates a new ExamTitle.
     * @param title - the title of the exam.
     * @return - the title of the exam.
     */
    public static ExamTitle of(final String title) {
        return new ExamTitle(title);
    }

    /**
     * Returns the title of the exam.
     * @return - the title of the exam.
     */
    @Override
    public String toString() {
        return title;
    }

    /**
     * Compares two ExamTitle objects.
     * @param o the object to be compared.
     * @return - the title of the exam.
     */
    @Override
    public int compareTo(ExamTitle o) {
        return title.compareTo(String.valueOf(o));
    }

    /**
     * Gets the value of the title.
     * @return - the title of the exam.
     */
    public String value() {
        return title;
    }
}
