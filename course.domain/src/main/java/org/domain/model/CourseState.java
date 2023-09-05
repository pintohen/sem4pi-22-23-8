package org.domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * The type CourseState.
 */
@Embeddable
public class CourseState implements ValueObject {
    /**
     * The state of the current course.
     * Can be open, closed, enroll and in progress.
     */
    @Column(name = "state")
    private String value;

    /**
     * Instatiates a new State for the course.
     */
    protected CourseState(){value = "Open";}

    private CourseState(final String value){
        Preconditions.nonNull(value);
        this.value = value;
    }

    /**
     * Factory method for coursestate creation.
     *
     * @param state, the state of the course
     * @return CourseState
     */

    public static CourseState of(final String state){ return new CourseState(state);}

    /**
     * Get the state's value.
     * @return String
     */
    public String value(){ return this.value;}

    /**
     * Verifies if the state is the same as the one passed as parameter.
     * @param o
     * @return isEqual boolean
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseState that = (CourseState) o;

        return Objects.equals(value, that.value);
    }
    @Override
    public String toString(){
        return this.value;
    }
}

