package org.domain.model.examtemplate.domain;


import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExamDescription {

    @Column(name = "exam_description", nullable = false)
    private final String value;

    private ExamDescription(final String value){

        Preconditions.nonNull(value);
        Preconditions.ensure(!value.isEmpty(), "Description cannot be empty.");

        this.value = value;
    }

    protected ExamDescription() {
        // for ORM
        value = "";
    }

    public static ExamDescription of(final String value){
        return new ExamDescription(value);
    }

    public String toString() {
        return value;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExamDescription)) return false;
        ExamDescription that = (ExamDescription) o;
        return value.equals(that.value);
    }
}
