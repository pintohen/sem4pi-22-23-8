package org.domain.model.postit;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

/**
 * The PostItContent.
 */
@Embeddable
public class PostItContent implements ValueObject {
    /**
     * Post-It content of Entity.
     */
    @Column(name = "POST_IT_CONTENT")
    private final String value;

    /**
     * The constant MAX_LENGTH.
     */
    private static final Integer MAX_LENGTH = 100;

    /**
     * The constant MIN_LENGTH.
     */
    private static final Integer MIN_LENGTH = 5;

    /**
     * Instantiates a new Post-It.
     */
    protected PostItContent() {
        this.value = null;
    }

    private PostItContent(final String valuep) {
        Preconditions.nonEmpty(
                valuep,
                "Post-It Content should neither be null nor empty"
        );
        Preconditions.nonNull(
                valuep,
                "Post-It Content should neither be null nor empty"
        );
        Preconditions.ensure(
                valuep.length() <= MAX_LENGTH && valuep.length() >= MIN_LENGTH,
                "Post-It Content should have between "
                        + MIN_LENGTH + " and "
                        + MAX_LENGTH + " characters"
        );

        this.value = valuep;
    }

    /**
     * Factory method to create a PostItContent instance.
     * @param valuep The value of the post-it content.
     * @return PostItContent instance.
     */
    public static PostItContent of(final String valuep) {
        return new PostItContent(valuep);
    }

    /**
     * Value string.
     *
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * Compare if PostItContent is equals to another object.
     * @param obj
     * @return true/false
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PostItContent other = (PostItContent) obj;
        return Objects.equals(value, other.value);
    }
}
