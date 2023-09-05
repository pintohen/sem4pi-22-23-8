package org.domain.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SolutionWeight {

    @Column(name = "solution_weight", nullable = false)
    private final double value;


    protected SolutionWeight(){
        this.value = 0;
    }

    public SolutionWeight(double value) {
        // for ORM
        this.value = value;
    }

    public double value() {
        return value;
    }
}
