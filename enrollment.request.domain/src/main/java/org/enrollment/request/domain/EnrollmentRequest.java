package org.enrollment.request.domain;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import org.domain.model.Course;
import org.domain.model.CourseStateConstants;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import java.util.Objects;

/**
 * The type Enrollment request.
 */
@Entity
@Table(
    name = "t_enrollment_request",
    uniqueConstraints = @UniqueConstraint(
            columnNames = {
                    "student_email",
                    "course_code"
            }
    )
)
public class EnrollmentRequest implements AggregateRoot<Long> {

    /**
     * The id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The Student.
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "student_email")
    private User student;

    /**
     * The Course.
     */
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "course_code")
    private Course course;

    /**
     * The Requested date.
     */
    private RequestedDate requestedDate;
    /**
     * The Answered date.
     */
    private AnsweredDate answeredDate;

    /**
     * The State.
     */
    @Enumerated(EnumType.STRING)
    private RequestState state;


    /**
     * Instantiates a new Enrollment request.
     */
    protected EnrollmentRequest() {
        // for ORM
    }

    private EnrollmentRequest(final User studentp, final Course coursep) {
        this.student = studentp;
        this.course = coursep;
        this.requestedDate = RequestedDate.init();
        this.state = RequestState.PENDING;
        this.answeredDate = null;
    }

    /**
     * Create enrollment request.
     *
     * @param student the student
     * @param course  the course
     * @return the enrollment request
     */
    public static EnrollmentRequest create(
            final User student,
            final Course course
    ) {
        Preconditions.noneNull(student, course);
        Preconditions.ensure(
                student.role().equals(CourseRoles.STUDENT.toString()),
                "Only students can be enrolled"
        );
        Preconditions.ensure(
                course.state().equals(CourseStateConstants.ENROLL),
                "This course is not available for enrollment"
        );
        return new EnrollmentRequest(student, course);
    }

    /**
     * equals method.
     * @param o
     * @return
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EnrollmentRequest that = (EnrollmentRequest) o;

        if (!Objects.equals(student, that.student)) {
            return false;
        }
        return Objects.equals(course, that.course);
    }

    /**
     * sameAs method.
     * @param other
     * @return
     */
    @Override
    public boolean sameAs(final Object other) {
        EnrollmentRequest that = (EnrollmentRequest) other;

        if (!Objects.equals(student, that.student)) {
            return false;
        }
        return Objects.equals(course, that.course);
    }

    /**
     * Accept request.
     */
    public void accept() {
        Preconditions.ensure(
                !this.state.equals(RequestState.ACCEPTED),
                "Already accepted requests cannot be accepted again"
        );
        this.state = RequestState.ACCEPTED;
        this.answeredDate = AnsweredDate.init();
        this.course.addStudent(this.student);
    }

    /**
     * Reject request.
     */
    public void reject() {
        Preconditions.ensure(
                !this.state.equals(RequestState.REJECTED),
                "Already rejected requests cannot be rejected again"
        );
        this.state = RequestState.REJECTED;
        this.answeredDate = AnsweredDate.init();
    }

    /**
     * Identity long.
     * @return the id
     */
    @Override
    public Long identity() {
        return id;
    }

    /**
     * Gets student.
     *
     * @return the student
     */
    public User student() {
        return student;
    }

    /**
     * Gets course.
     *
     * @return the course
     */
    public Course course() {
        return course;
    }

    /**
     * toString method.
     * @return the string
     */
    @Override
    public String toString() {
        return "Request " + this.id + "\n"
                + "Student: " + this.student.emailAddress() + "\n"
                + "Course: " + this.course.identity().value() + "\n";
    }

    /**
     * Hash code int.
     * @return the int
     */
    @Override
    public int hashCode() {
        final int hashConstant = 31;
        int result = student.hashCode();
        result = hashConstant * result + course.hashCode();
        return result;
    }
}
