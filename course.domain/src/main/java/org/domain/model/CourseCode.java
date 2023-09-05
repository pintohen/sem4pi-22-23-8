package org.domain.model;


import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The type CourseCode
 */
@Embeddable
public class CourseCode implements ValueObject, Comparable<CourseCode> {
    /**
     * Unique code for the course
     */
    @Column(name = "code")
    private String value;

    /**
     * Instantiates a new Code for the course.
     */
    protected CourseCode(){ value = null;}

    private CourseCode(final String value){
        this.value = value;
    }

    /**
     * Factory method for the course code.
     * @param code the unique code of students
     * @return CourseCode
     */
    public static CourseCode of(final String code){
        Preconditions.nonNull(code, "Code can't be null");
        return new CourseCode(code);
    }

    /**
     * Get code value.
     * @return String
     */
    public String value(){return this.value;}

    @Override
    public int compareTo(final CourseCode o) {
        if(value.equals(o.value)){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(final Object o){
        if(!(o instanceof CourseCode)){
            return false;
        }
        String value = ((CourseCode) o).value;
        if(this.value.equals(value)){
            return true;
        }
        return false;
    }
}
