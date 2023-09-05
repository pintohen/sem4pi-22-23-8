package org.exam.application;

import eapli.framework.validations.Preconditions;
import org.domain.model.Course;
import org.domain.model.exam.Exam;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.domain.model.examtemplate.domain.ExamTitle;
import org.domain.repositories.CourseRepository;
import org.springframework.stereotype.Service;
import org.usermanagement.domain.model.User;
import repositories.ExamRepository;
import repositories.ExamTemplateRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;

/**
 * The type Exam service.
 */
@Service
public class ExamService {
    private ExamRepository repo;
    private ExamTemplateRepository templateRepo;
    private CourseRepository courseRepo;

    /**
     * Instantiates a new Exam service.
     *
     * @param repo         the repo
     * @param templateRepo the template repo
     * @param courseRepo   the course repo
     */
    public ExamService(ExamRepository repo, ExamTemplateRepository templateRepo, CourseRepository courseRepo) {
        this.repo = repo;
        this.templateRepo = templateRepo;
        this.courseRepo = courseRepo;
    }

    /**
     * Evaluate exam from file exam.
     *
     * @param filePath  the file path
     * @param student   the student
     * @param examTitle the exam title
     * @return the exam
     * @throws IOException the io exception
     */
    public Exam evaluateExamFromFile(String filePath, User student, ExamTitle examTitle) throws IOException {

        ExamTemplate examTemplate = templateRepo.findByTitle(examTitle)
                .orElseThrow(
                        () -> new IllegalArgumentException("Exam with such title does not exist.\nTry again.")
                );

        Preconditions.ensure(
                examTemplate.containsStudent(student),
                "Student is not enrolled in this exam.\nTry again."
        );


        Exam evaluated = ExamEvaluator.evaluateFromFile(filePath, student, examTemplate);

        return this.repo.save(evaluated);
    }

    /**
     * List exam grades iterable.
     *
     * @param student the student
     * @return the iterable
     */
    public Iterable<Exam> listExamGrades(User student) {

        List<Exam> listExamGrades = new ArrayList<>();

        listExamGrades.addAll((Collection<? extends Exam>) repo.findGradesByStudentEmail(student));

        return listExamGrades;
    }

    /**
     * Get teacher courses iterable.
     *
     * @param teacher the teacher
     * @return the iterable
     */
    public Iterable<Course> getTeacherCourses(User teacher){
        return courseRepo.findCoursesThatITeach(teacher);
    }

    /**
     * List teacher grades iterable.
     *
     * @param course the course
     * @return the iterable
     */
    public Iterable<Exam> listTeacherGrades(Course course){
        return repo.findGradesByCourse(course);
    }
}
