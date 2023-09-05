package org.domain.model;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The type CourseMaxNumberLimit.
 */
@Embeddable
public class CourseMaxNumberLimit implements ValueObject {
    /**
     * Maximum number of students than can be enrolled in a course
     */
    @Column(name = "maximum_students")
    private Integer value;

    /**
     * Instantiates a new Course max number limit.
     */

    public CourseMaxNumberLimit(final Integer value){
        this.value = value;
    }

    public CourseMaxNumberLimit() {

    }


    /**
     * Factory method for coursemaxnumberlimit creation
     *
     * @param maxValue the maximum number of students
     * @return CourseMaxNumberLimit
     */
    public static CourseMaxNumberLimit of(final Integer  maxValue){
        Preconditions.nonNull(maxValue, "Maximum value must be higher than 0");
        return new CourseMaxNumberLimit(maxValue);}

    /**
     * Get maximum number of students' value.
     * @return Integer
     */
    public Integer value(){return this.value;}
}
