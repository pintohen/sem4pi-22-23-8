package exams;

import eapli.framework.presentation.console.AbstractUI;
import org.authz.application.AuthzRegistry;
import org.domain.model.exam.Exam;
import org.exam.application.ListExamGradesController;

public class ListExamGradesUI extends AbstractUI {

    private final ListExamGradesController ctrl = new ListExamGradesController(AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {
        try {

            Iterable<Exam> exams = ctrl.listExamGrades();

            if (exams.iterator().hasNext()) {
                for (Exam exam : exams) {
                    System.out.println(exam);
                }
            } else {
                System.out.println("The student did not take any exams yet");
            }

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        return true;

    }

    @Override
    public String headline() {
        return "List Exam Grades";
    }
}
