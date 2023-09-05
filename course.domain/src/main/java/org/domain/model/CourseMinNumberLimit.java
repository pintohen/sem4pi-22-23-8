package org.domain.model;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The type CourseMaxNumberLimit.
 */
@Embeddable
public class CourseMinNumberLimit implements ValueObject {
    /**
     * Minimum number of students than can be enrolled in a course
     */
    @Column(name = "minimum_students")
    private Integer value;

    /**
     * Instantiates a new Course min number limit.
     */
    protected CourseMinNumberLimit(){ value = null;}

    private CourseMinNumberLimit(final Integer value){
        // Preconditions ensurrance
        this.value = value;
    }

    /**
     * Factory method for courseminnumberlimit creation
     *
     * @param minValue the minimum number of students
     * @return CourseMinNumberLimit
     */
    public static CourseMinNumberLimit of(final Integer  minValue){ return new CourseMinNumberLimit(minValue);}

    /**
     * Get minimum number of students' value.
     * @return Integer
     */
    public Integer value(){return this.value;}
}
