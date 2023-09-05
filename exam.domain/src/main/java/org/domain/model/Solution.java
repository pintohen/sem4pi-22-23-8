package org.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "T_SOLUTION")
public class Solution {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "solution_id")
    private Long id;
    @Column(name = "solution_weight", nullable = false)
    private SolutionWeight weight;
    @Column(name = "solution_description", nullable = false)
    private SolutionDescription description;

    protected Solution(){
        // for ORM
        this.weight = null;
        this.description = null;
    }

    public Solution(SolutionWeight weight, SolutionDescription description) {
        this.weight = weight;
        this.description = description;
    }


    public String description() {
        return this.description.value();
    }

    public Double weight() {
        return this.weight.value();
    }
}
