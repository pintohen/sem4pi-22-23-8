package org.domain.model.examtemplate.domain;

import eapli.framework.domain.model.AggregateRoot;
import org.domain.model.Course;
import org.usermanagement.domain.model.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "T_EXAM_TEMPLATE")
public class ExamTemplate implements AggregateRoot<ExamTitle> {


    /**
     * Title of the exam.
     */
    @EmbeddedId
    private ExamTitle title;

    private OpenDate openDate;

    private CloseDate closeDate;

    private ExamDescription description;

    @Enumerated(EnumType.STRING)
    private FeedbackType feedbackType;

    @Enumerated(EnumType.STRING)
    private GradeType gradeType;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "exam_title")
    private List<Section> sections;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_email")
    private final User teacher;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "t_exam_student", joinColumns =
    @JoinColumn(name = "exam_title"), inverseJoinColumns =
    @JoinColumn(name = "student_email"))
    private Set<User> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_code")
    private Course course;


    /**
     * Constructor for ORM.
     */
    protected ExamTemplate() {
        // for ORM only
        title = null;
        teacher = null;
    }

    public ExamTemplate(
            ExamTitle title,
            OpenDate openDate,
            CloseDate closeDate,
            ExamDescription description,
            FeedbackType feedbackType,
            GradeType gradeType,
            List<Section> sections,
            User teacher,
            Set<User> students,
            Course course
    ){
        this.title = title;
        this.openDate = openDate;
        this.closeDate = closeDate;
        this.description = description;
        this.feedbackType = feedbackType;
        this.gradeType = gradeType;
        this.sections = sections;
        this.teacher = teacher;
        this.students.addAll(students);
        this.course = course;
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public ExamTitle identity() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        return false;
    }

    public boolean overlaps(ExamTemplate examTemplate) {
        return false;
    }

    @Override
    public String toString() {
        return "title: " + title +
                " || " + openDate +
                " || " + closeDate +
                 '\n';
    }

    public User teacher() {
        return this.teacher;
    }

    public Course course() {
        return this.course;
    }

    public List<Section> sections() {
        return this.sections;
    }

    public boolean containsStudent(User student) {
        for (User s : students) {
            if (s.emailAddress().equals(student.emailAddress())) {
                return true;
            }
        }
        return false;
    }
}
