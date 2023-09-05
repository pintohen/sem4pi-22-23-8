package org.domain.model.exam;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.validations.Preconditions;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;

import javax.persistence.*;

@Entity
@Table(
        name = "T_EXAM",
        uniqueConstraints = @UniqueConstraint(
                columnNames = {
                        "exam_template_title",
                        "student_email"
                }
        )
)

public class Exam implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_id")
    private Long id;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exam_template_title")
    private ExamTemplate examTemplate;
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "student_email")
    private User student;
    @Column(name = "grade")
    private Double grade;
    @Column(name = "total_grade")
    private Double totalGrade;

    protected Exam() {
        // for ORM
    }

    public Exam(
            ExamTemplate examTemplate,
            User student,
            Double grade,
            Double totalGrade
    ) {
        Preconditions.ensure(
                student.role().equals(CourseRoles.STUDENT.toString()),
                "The user must be a student"
        );
        Preconditions.ensure(
                grade >= 0 && grade <= totalGrade,
                "The grade must be between 0 and the total grade"
        );
        this.examTemplate = examTemplate;
        this.student = student;
        this.grade = grade;
        this.totalGrade = totalGrade;
    }

    @Override
    public boolean sameAs(Object other) {
        Exam exam = (Exam) other;

        return this.student.identity().equals(exam.student.identity())
                && this.examTemplate.identity().value()
                .equals(exam.examTemplate.identity().value());
    }

    @Override
    public Long identity() {
        return id;
    }

    public Double schoolGrade(){
        return (this.grade / this.totalGrade) * 20;
    }

    @Override
    public String toString() {

        return
        "Exam: " + this.examTemplate.identity().value() + "\n"
        + "Course: " + this.examTemplate.course().identity().value() + "\n"
        + "Student: " + this.student.identity() + "\n"
        + "Grade: " + String.format("%.1f",this.schoolGrade()) + "\n";
    }
}
