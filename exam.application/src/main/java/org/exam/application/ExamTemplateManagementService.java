package org.exam.application;

import eapli.framework.validations.Preconditions;
import org.domain.model.Course;
import org.domain.model.CourseCode;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.domain.model.examtemplate.domain.ExamTitle;
import org.domain.repositories.CourseRepository;
import org.usermanagement.domain.model.User;
import repositories.ExamTemplateRepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class ExamTemplateManagementService {

    private final ExamTemplateRepository examRepo;

    private final CourseRepository courseRepo;

    public ExamTemplateManagementService(ExamTemplateRepository examRepo, CourseRepository courseRepo) {
        this.examRepo = examRepo;
        this.courseRepo = courseRepo;
    }

    public ExamTemplate createExam(
            String filePath,
            CourseCode courseCode,
            User teacher
    ) throws IOException {

        Course course = courseRepo.findByCode(courseCode)
                .orElseThrow(() -> new IllegalArgumentException("Course with code " + courseCode + " does not exist"));

        Set<User> courseStudents = course.students();


        ExamTemplate template = ExamTemplateEvaluator.evaluateFromFile(filePath, teacher, course, courseStudents);


        return examRepo.save(template);
    }

    public Iterable<ExamTemplate> listCourseExams(CourseCode courseCode, User teacher) {

        Course course = courseRepo.findByCode(courseCode)
                .orElseThrow(() -> new IllegalArgumentException("Course with code " + courseCode + " does not exist"));

        Preconditions.ensure(teacher != null, "Teacher must not be null");

        return examRepo.findByCourse(course);
    }


    public Iterable<ExamTemplate> listFutureExams(User student) {

            List<ExamTemplate> listFutureExams = new ArrayList<>();

            Preconditions.nonNull(student, "Student must not be null");

            for (Course course : courseRepo.findCoursesTakenByStudent(student)) {
                listFutureExams.addAll((Collection<? extends ExamTemplate>) examRepo.findFutureExams(course));
            }

            return listFutureExams;
    }

    public ExamTemplate updateExam(ExamTitle title,
                                   String filePath,
                                   User teacher) throws IOException {

        ExamTemplate template = examRepo.ofIdentity(title)
                .orElseThrow(() -> new IllegalArgumentException("Exam with title " + title + " does not exist"));

        Course course = template.course();

        Set<User> courseStudents = course.students();

        ExamTemplate updatedTemplate = ExamTemplateEvaluator.evaluateFromFile(filePath, teacher, course, courseStudents);

        examRepo.deleteOfIdentity(title);

        return examRepo.save(updatedTemplate);
    }
}
