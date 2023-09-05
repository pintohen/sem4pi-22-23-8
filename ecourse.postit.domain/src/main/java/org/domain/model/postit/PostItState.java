package org.domain.model.postit;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Embeddable;

/**
 * The type PostItState.
 */
@Embeddable
public class PostItState implements ValueObject {
    private static final long serialVersionUID = 1L;
    /**
     * PostItState type for users.
     */
    private final String postItState;

    private PostItState(final String postItStatep) {
        Preconditions.nonEmpty(postItStatep);
        this.postItState = postItStatep;
    }

    /**
     * Instantiates a new PostItState.
     */
    protected PostItState() {
        this.postItState = null;
    }

    /**
     * @return String of PostItState
     */
    public String toString() {
        return this.postItState;
    }

    /**
     * Parse string to PostItState.
     * @param postItStatep
     * @return PostItState
     */
    public static PostItState valueOf(final String postItStatep) {
        return new PostItState(postItStatep);
    }

    /**
     * Check if two objects are the Same.
     * @param o object
     * @return true/false
     */
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof PostItState)) {
            return false;
        } else {
            PostItState other = (PostItState) o;

            if (!other.canEqual(this)) {
                return false;
            } else {
                Object thisPostItState = this.postItState;
                Object otherPostItState = other.postItState;

                if (thisPostItState == null) {
                    if (otherPostItState != null) {
                        return false;
                    }
                } else if (!thisPostItState.equals(otherPostItState)) {
                    return false;
                }

                return true;
            }
        }
    }

    /**
     * Can be equals.
     * @param other
     * @return true/false
     */
    protected boolean canEqual(final Object other) {
        return other instanceof PostItState;
    }
}