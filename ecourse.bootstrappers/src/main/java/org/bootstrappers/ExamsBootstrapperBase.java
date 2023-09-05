package org.bootstrappers;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import org.domain.model.exam.Exam;
import org.domain.model.examtemplate.domain.ExamTitle;
import org.exam.application.ExamService;
import org.persistence.PersistenceContext;
import org.usermanagement.domain.repositories.UserRepository;
import repositories.ExamRepository;
import repositories.ExamTemplateRepository;

import java.io.IOException;

public class ExamsBootstrapperBase {

    private final ExamRepository examRepo =
            PersistenceContext.repositories().exams();
    private final ExamTemplateRepository examTemplateRepo =
            PersistenceContext.repositories().examTemplates();
    private final UserRepository userRepo =
            PersistenceContext.repositories().users();

    private final ExamService svc =
            new ExamService(examRepo, examTemplateRepo, PersistenceContext.repositories().courses());


    public Exam addExam(ExamTitle title, EmailAddress email, String filePath){
        try {
            Exam exam = this.svc.evaluateExamFromFile(filePath, userRepo.findUserByEmail(email).get(), title);

            System.out.println("[+] Exam: " + exam.identity());

            return exam;
        } catch (final IntegrityViolationException
                      | ConcurrencyException e){
            System.out.println("[-] Exam already exists");
            return null;
        } catch (IOException e) {
            System.out.println("[-] Exam file not found");
            return null;
        } catch(IllegalArgumentException iae){
            System.out.println("[-] Exam not added");
            return null;
        }

    }

}

