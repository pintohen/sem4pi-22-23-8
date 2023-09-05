package org.bootstrappers;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import org.domain.model.CourseCode;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.domain.repositories.CourseRepository;
import org.exam.application.ExamTemplateManagementService;
import org.persistence.PersistenceContext;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.repositories.UserRepository;

import java.io.IOException;

public class ExamTemplatesBootstrapperBase {

    private final ExamTemplateManagementService service =
            new ExamTemplateManagementService(
                    PersistenceContext.repositories().examTemplates(),
                    PersistenceContext.repositories().courses()
            );

    private final UserRepository userRepo =
            PersistenceContext.repositories().users();

    private final CourseRepository courseRepo =
            PersistenceContext.repositories().courses();

    protected User findUserByEmail(final String email) {
        return userRepo.findUserByEmail(
                EmailAddress.valueOf(email)).get();
    }

    protected ExamTemplate createExam(
            String filePath,
            String courseCode,
            User teacherEmail) {

        ExamTemplate examTemplate = null;

        try {
            examTemplate = service.createExam(filePath, CourseCode.of(courseCode), teacherEmail);
            System.out.println("[+] Added an exam template for " + courseCode);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (final IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (final IntegrityViolationException | ConcurrencyException e) {
            System.out.println("The exam for --> " + courseCode + " already exists");
        }
        return examTemplate;
    }
}
