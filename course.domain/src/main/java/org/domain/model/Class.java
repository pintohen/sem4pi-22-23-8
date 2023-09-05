package org.domain.model;

import eapli.framework.validations.Preconditions;
import org.usermanagement.domain.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * The type Class.
 */
@Entity
@Table(name = "T_CLASS")
public class Class implements Serializable {

    /**
     * The title of the class.
     */
    @EmbeddedId
    @Column (unique = true)
    private final ClassTitle title;

    /**
     * The day of the week the class occurs.
     */
    @Column(name = "day_of_week", nullable = false)
    @Enumerated(EnumType.STRING)
    private ClassDayOfWeek dayOfWeek;

    /**
     * The time the class ends.
     */
    private final ClassTime time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_email")
    private final User teacher;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "t_class_student",joinColumns =
    @JoinColumn(name = "class_title"), inverseJoinColumns =
    @JoinColumn(name = "student_email"))
    private Set<User> students = new HashSet<>();



    /**
     * Empty constructor for ORM.
     */
    protected Class() {
        title = null;
        time = null;
        teacher = null;
    }

    /**
     * Creates a new Class.
     * @param title - the title of the class.
     * @param dayOfWeek - the day of the week the class occurs.
     * @param time - the time the class ends.
     */
    public Class(
            final ClassTitle title,
            final ClassDayOfWeek dayOfWeek,
            final ClassTime time,
            final User teacher,
            final Set<User> students
    ) {

        Preconditions.noneNull(title, dayOfWeek, time, teacher, students);

        this.title = title;
        this.time = time;
        this.dayOfWeek = dayOfWeek;
        this.teacher = teacher;
        this.students.addAll(students);
    }

    /**
     * Returns the title of the class.
     *
     * @return - the title of the class.
     */
    protected ClassTitle title() {
        return title;
    }

    /**
     * Returns the day of the week the class occurs.
     *
     * @return - the day of the week the class occurs.
     */
    public ClassDayOfWeek dayOfWeek() {
        return dayOfWeek;
    }

    /**
     * Returns the time the class occurs.
     *
     * @return - the time the class occurs.
     */
    public ClassTime time() {
        return time;
    }

    /**
     * Identity class title.
     *
     * @return the class title
     */
    public ClassTitle identity() {
        return title();
    }

    /**
     * Returns the course the class is part of.
     * @return - the course the class is part of.
     */
    @Override
    public String toString() {
        return "Title: " + title + "\n" +
                "Day of the week: " + dayOfWeek + "\n" +
                "Time: " + time + "\n";

    }

    /**
     * Compares two classes.
     * @return - true if the classes are equal, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Class)) return false;

        Class aClass = (Class) o;
        if (!title.equals(aClass.title)) return false;
        if (!dayOfWeek.equals(aClass.dayOfWeek)) return false;
        return time.equals(aClass.time);
    }

    public boolean overlaps(Class c) {
        return this.dayOfWeek.equals(c.dayOfWeek) && this.time.overlaps(c.time);
    }
}
