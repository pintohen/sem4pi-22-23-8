package exams;

import eapli.framework.presentation.console.AbstractUI;
import org.authz.application.AuthzRegistry;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.exam.application.UpdateExamController;

import java.io.IOException;
import java.util.Scanner;

public class UpdateExamUI extends AbstractUI {

    Scanner scanner = new Scanner(System.in);

    private final UpdateExamController ctrl = new UpdateExamController(AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {

        try {

            System.out.println("Which exam do you want to update? (Title)");
            String title = scanner.nextLine();

            System.out.println("What is the new exam file?");
            String filePath = scanner.nextLine();

            ExamTemplate exam = ctrl.updateExam(title, filePath);

            System.out.println("Exam updated successfully!");

        } catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        } catch(IOException ioe){
            System.out.println("File doesn't exist or is not accessible.\nTry again.");
        }

        return true;

    }

    @Override
    public String headline() {
        return "Update Exam UI";
    }

}
