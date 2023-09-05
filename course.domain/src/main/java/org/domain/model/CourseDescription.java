package org.domain.model;


import eapli.framework.domain.model.ValueObject;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The type Course Description.
 */
@Embeddable
public class CourseDescription implements ValueObject{
    /**
     * Description of the given course.
     */
    @Column(name = "description")
    private String value;

    /**
     * Instantiates a new Description
     */
    protected CourseDescription(){
        value = null;
    }

    private CourseDescription(final String value){
        this.value = value;
    }

    /**
     * Factory method for CourseDescription creation.
     *
     * @param description, description of the course
     * @return CourseDescription
     */
    public static CourseDescription of(final String description){ return new CourseDescription(description);}

    /**
     * Get description of the course
     * @return String
     */
    public String value(){return this.value;}
}
