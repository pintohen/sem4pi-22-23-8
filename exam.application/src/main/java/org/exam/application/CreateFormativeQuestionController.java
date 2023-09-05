package org.exam.application;

import org.domain.model.CourseCode;
import org.domain.model.template.formative.question.TemplateFormativeQuestion;
import org.persistence.PersistenceContext;

import java.io.IOException;

public class CreateFormativeQuestionController {
    private TemplateFormativeQuestionManagementService service = new TemplateFormativeQuestionManagementService(
            PersistenceContext.repositories().courses(),
            PersistenceContext.repositories().formativeQuestions()
    );

    public TemplateFormativeQuestion createTemplateFormativeQuestion(
            String filePath,
            String courseCode
    ) throws IOException {
        return service.createTemplateFormativeQuestion(filePath, CourseCode.of(courseCode));
    }
}
