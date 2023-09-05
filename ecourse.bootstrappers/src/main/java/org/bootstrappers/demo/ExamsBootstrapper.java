package org.bootstrappers.demo;

import eapli.framework.general.domain.model.EmailAddress;
import org.bootstrappers.ExamsBootstrapperBase;
import org.domain.model.examtemplate.domain.ExamTitle;

public class ExamsBootstrapper extends ExamsBootstrapperBase {
    public boolean execute(){

        addExam(
                ExamTitle.of("Mathematics"),
                EmailAddress.valueOf("student1@email.com"),
                "antlr_text_files/exams/resolution_1_from_1.txt"
        );

        addExam(
                ExamTitle.of("Portuguese"),
                EmailAddress.valueOf("student1@email.com"),
                "antlr_text_files/exams/resolution_1_from_2.txt"
        );

        addExam(
                ExamTitle.of("Mathematics"),
                EmailAddress.valueOf("student2@email.com"),
                "antlr_text_files/exams/resolution_2_from_1.txt"
        );

        return true;
    }


}
