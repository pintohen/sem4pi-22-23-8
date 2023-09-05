package exams;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import org.authz.application.AuthzRegistry;
import org.domain.model.exam.Exam;
import org.exam.application.EvaluateExamController;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Scanner;

public class TakeExamUI extends AbstractUI {
    private final Scanner sc = new Scanner(System.in);
    private final EvaluateExamController ctrl =
            new EvaluateExamController(AuthzRegistry.authorizationService());
    @Override
    protected boolean doShow() {

        try{
            System.out.print("Enter the exam title: ");
            String examTitle = sc.nextLine();
            System.out.print("\nEnter the path to the file: ");
            String filePath = sc.nextLine();
            System.out.println();

            Exam exam = ctrl.evaluateExamFromFile(filePath, examTitle);

            System.out.println("Final grade is: "
                    + String.format("%.1f", exam.schoolGrade())
                    + "/20.\n");
        }
        catch(IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }
        catch(NoSuchFileException nsfe){
            System.out.println("File not found.\nTry again.");
        }
        catch (IOException e) {
            System.out.println("Error reading file.\nTry again.");
        }
        catch (final IntegrityViolationException | ConcurrencyException e){
            System.out.println("You already took this exam.\nTry again.");
        }


        return true;
    }

    @Override
    public String headline() {
        return "Take an Exam";
    }
}
