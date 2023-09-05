package org.domain.model;

public enum QuestionType {
    MATCHING,
    MULTIPLE_CHOICE,
    SHORT_ANSWER,
    NUMERICAL,
    MISSING_WORDS,
    TRUE_FALSE;

    @Override
    public String toString() {
        return this.name();
    }
}
