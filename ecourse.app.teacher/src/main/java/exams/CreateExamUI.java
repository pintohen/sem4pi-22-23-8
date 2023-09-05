package exams;

import eapli.framework.presentation.console.AbstractUI;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.exam.application.CreateExamController;
import org.authz.application.AuthzRegistry;

import java.io.IOException;
import java.util.Scanner;

public class CreateExamUI extends AbstractUI {

    Scanner scanner = new Scanner(System.in);

    private final CreateExamController ctrl = new CreateExamController(AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {
        try {
            System.out.println("For which course do you want to create an exam?");

            String courseCode = scanner.nextLine();

            System.out.println("What is the exam file?");

            String filePath = scanner.nextLine();

            ExamTemplate exam = ctrl.createExam(courseCode, filePath);

            System.out.println("Exam created successfully!");


        } catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        } catch(IOException ioe){
            System.out.println("File doesn't exist or is not accessible.\nTry again.");
        }
        return true;
    }

    @Override
    public String headline() {
        return "Create Exam UI";
    }
}
