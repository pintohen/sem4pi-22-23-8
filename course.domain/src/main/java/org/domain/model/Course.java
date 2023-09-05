package org.domain.model;


import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "T_COURSE")
public class Course implements AggregateRoot<CourseCode> {

    /**
     * Version of course;
     */
    @Version
    private Long version;

    /**
     * Name of the course.
     */
    private CourseName name;

    /**
     * Code of the course.
     */
    @EmbeddedId
    private CourseCode code;

    /**
     * Edition of the course.
     */
    @Column(unique = true)
    private CourseEdition edition;

    /**
     * Description of the course.
     */
    private CourseDescription description;

    /**
     * State of the course(Open, closed, enroll or in progress)
     */
    private CourseState state;

    /**
     * Maximum number of people who can enroll in the course.
     */
    private CourseMaxNumberLimit max;

    /**
     * Minimum number of people who have to enroll in the course.
     */
    private CourseMinNumberLimit min;

    /**
     * The head teacher for the course
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "head_teacher_email")
    private User headTeacher;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "t_course_teacher",joinColumns =
    @JoinColumn(name = "course_code"), inverseJoinColumns =
    @JoinColumn(name = "teacher_email"))
    private Set<User> teachers;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "t_course_student",joinColumns =
    @JoinColumn(name = "course_code"), inverseJoinColumns =
    @JoinColumn(name = "student_email"))
    private Set<User> students;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Class> classes = new HashSet<>();

    public Course(final CourseName name,
           final CourseCode code,
           final CourseEdition edition,
           final CourseDescription description,
           final CourseState state,
           final CourseMaxNumberLimit max,
           final CourseMinNumberLimit min,
           final User headTeacher,
                  final Set<User> teachers,
                  final Set<User> students) {

        necessaryParameters(name, code, edition, max, headTeacher);
        validateMaxMin(max, min);

        this.name = name;
        this.code = code;
        this.edition = edition;
        this.description = description;
        this.state = state;
        this.max = max;
        this.min = min;
        this.headTeacher = headTeacher;
        this.teachers = teachers;
        this.students = students;
    }

    protected Course() {
    }

    private void necessaryParameters(
            final CourseName name,
            final CourseCode code,
            final CourseEdition edition,
            final CourseMaxNumberLimit max,
            final User headTeacher){
        Preconditions.nonNull(name, "Name of te course cannot be null.");
        Preconditions.nonNull(code, "Code of the course can't be null.");
        Preconditions.nonNull(edition, "Edition of the course can't be null.");
        Preconditions.nonNull(max, "The maximum number of students can't be 0.");
        Preconditions.nonNull(headTeacher, "The course must have a head teacher.");
        Preconditions.ensure(headTeacher.role().equals(CourseRoles.TEACHER.toString()));
    }

    private void validateMaxMin(CourseMaxNumberLimit max, CourseMinNumberLimit min){
        int value = max.value()-min.value();

        if(value < 0){
            throw new IllegalArgumentException("The maximum quantity of students can't be lower than the minimum quantity of students");
        }
        if(value == 0){
            throw new IllegalArgumentException("There can't be a defined number of students. There must be some interval of numbers");
        }
    }

    @Override
    public boolean sameAs(Object other) {
        if(other instanceof Course){
            if(this.edition.value().equals(((Course) other).identity().value())){
                return true;
            }
            return this.code.value().equals(((Course) other).identity().value());
        }
        return false;
    }

    @Override
    public CourseCode identity() {
        return code;
    }

    public CourseState state(){
        return state;
    }

    public void addStudent(User student){
        Preconditions.ensure(
                !students.contains(student),
                "This student is already enrolled in this course"
        );
        Preconditions.ensure(
                student.role().equals(CourseRoles.STUDENT.toString()),
                "Only students can be assigned through this option");
        Preconditions.ensure(
                this.state.equals(CourseStateConstants.ENROLL),
                "A student can only be added to this course if the state is Enrolled"
        );
        Preconditions.ensure(
                students.size() < max.value(),
                "The maximum number of students has been reached"
        );
        students.add(student);
    }

    public void removeStudent(User student){
        Preconditions.ensure(
                students.contains(student),
                "This student is not enrolled in this course");
        students.remove(student);
    }

    public Set<User> getStudents(){
        return students;
    }

    public void addTeacher(User teacher){
        Preconditions.ensure(
                teacher.role().equals(CourseRoles.TEACHER.toString()),
                "Only teachers can be assigned through this option");
        teachers.add(teacher);
    }

    public void removeTeacher(User teacher){
        Preconditions.ensure(
                teachers.contains(teacher),
                "This teacher is not enrolled in this course");
        teachers.remove(teacher);
    }

    public Set<User> teachers(){
        return teachers;
    }

    public void changeState(CourseState state){
        this.state = state;
    }

    public void addClass(Class aClass) {
        Preconditions.ensure(
                !classes.contains(aClass),
                "This class is already in this course"
        );
        Preconditions.ensure(classes.stream().noneMatch(c -> c.overlaps(aClass)),
                "The teacher already has a class at this time"
        );
        classes.add(aClass);
    }

    @Override
    public String toString() {
        return "Course   " + code.value() + "\n" +
                "Name: " + name.value() + "\n" +
                "Edition: " + edition.value() + "\n" +
                "Description: " + description.value() + "\n" +
                "State: " + state.value() + "\n" +
                "Max students: " + max.value() + "\n" +
                "Minimum students: " + min.value() + "\n" +
                "Head Teacher: " + headTeacher.emailAddress() + "\n";
    }

    public Set<User> students() {
        return this.students;
    }

    public boolean containtsTeacher(User teacher) {
        for(User t : teachers) {
            if(t.emailAddress().equals(teacher.emailAddress())) {
                return true;
            }
        }

        return false;
    }
}
