package org.exam.application;

import org.domain.model.Course;
import org.domain.model.CourseCode;
import org.domain.model.template.formative.question.TemplateFormativeQuestion;
import org.domain.repositories.CourseRepository;
import repositories.TemplateFormativeQuestionRepository;

import java.io.IOException;

public class TemplateFormativeQuestionManagementService {
    private CourseRepository courseRepo;
    private TemplateFormativeQuestionRepository repo;

    public TemplateFormativeQuestionManagementService(
            CourseRepository courseRepo,
            TemplateFormativeQuestionRepository repo
    ) {
        this.courseRepo = courseRepo;
        this.repo = repo;
    }

    public TemplateFormativeQuestion createTemplateFormativeQuestion(
            String filePath,
            CourseCode courseCode
    ) throws IOException {

        Course course = courseRepo.findByCode(courseCode).orElseThrow(
                () -> new IllegalArgumentException(
                        "Course with code " + courseCode + " does not exist.\nTry again."
                )
        );

        TemplateFormativeQuestion question = TemplateFormativeQuestionEvaluator.evaluateFromFile(filePath, course);



        return repo.save(question);
    }
}
