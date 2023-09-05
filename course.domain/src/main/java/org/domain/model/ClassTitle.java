package org.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import eapli.framework.domain.model.ValueObject;
import eapli.framework.strings.StringMixin;
import eapli.framework.validations.Preconditions;
import lombok.EqualsAndHashCode;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class ClassTitle implements ValueObject, Serializable, Comparable<ClassTitle>, StringMixin {

    /**
     * The title of the class.
     */
    @JsonProperty
    private final String title;

    /**
     * Constructor for ORM.
     */
    protected ClassTitle() {
        title = "";
    }

    /**
     * Constructor for ClassTitle.
     * @param title - the title of the class.
     */

    private ClassTitle(final String title) {
        Preconditions.noneNull("Title cannot be null.");
        Preconditions.ensure(!title.isEmpty(), "Title cannot be empty.");
        this.title = title;
    }

    /**
     * Creates a new ClassTitle.
     * @param title - the title of the class.
     * @return - the new ClassTitle.
     */
    public static ClassTitle of(final String title) {
        return new ClassTitle(title);
    }

    /**
     * Returns the title of the class.
     * @return - the title of the class.
     */
    @Override
    public String toString() {
        return title;
    }

    /**
     * Compares two ClassTitle objects.
     * @param o the object to be compared.
     * @return 0 if the objects are equal, a negative integer if this object is less than the other, or a positive
     */

    @Override
    public int compareTo(final ClassTitle o) {
        return title.compareTo(o.title);
    }

    /**
     * Returns the value of the ClassTitle.
     * @return - the value of the ClassTitle.
     */
    public String value() {
        return title;
    }
}
