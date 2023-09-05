package org.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class QuestionDescription {
    @Column(name = "question_description", nullable = false)
    private final String value;

    protected QuestionDescription(){
        // for ORM
        this.value = "";
    }

    public QuestionDescription(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
