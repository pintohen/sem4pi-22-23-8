package org.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SolutionDescription {
    @Column(name = "solution_description", nullable = false)
    private final String value;

    protected SolutionDescription(){
        // for ORM
        this.value = "";
    }

    public SolutionDescription(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
