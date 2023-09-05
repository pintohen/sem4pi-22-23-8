package formative.questions;

import eapli.framework.presentation.console.AbstractUI;
import org.domain.model.template.formative.question.TemplateFormativeQuestion;
import org.exam.application.CreateFormativeQuestionController;

import java.io.IOException;
import java.util.Scanner;

public class CreateFormativeQuestionsUI extends AbstractUI {

    private final CreateFormativeQuestionController ctrl = new CreateFormativeQuestionController();
    private final Scanner sc = new Scanner(System.in);
    @Override
    protected boolean doShow() {

        try{
            System.out.print("Insert the Course Code: ");
            String courseCode = sc.nextLine();
            System.out.println();

            System.out.print("Insert the path to the file: ");
            String filePath = sc.nextLine();
            System.out.println();

            TemplateFormativeQuestion question = ctrl.createTemplateFormativeQuestion(filePath, courseCode);

            System.out.println("Question created successfully!");

        }
        catch(IOException ioe){
            System.out.println("File was not found or not acessible.\nTry again.");
        }
        catch(IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }


        return true;
    }

    @Override
    public String headline() {
        return "Create a Formative Question for a Course";
    }
}
