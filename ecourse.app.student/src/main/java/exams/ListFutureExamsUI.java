package exams;

import eapli.framework.presentation.console.AbstractUI;
import org.exam.application.ListFutureExamsController;
import org.authz.application.AuthzRegistry;
import org.domain.model.examtemplate.domain.ExamTemplate;
public class ListFutureExamsUI extends AbstractUI {

    private final ListFutureExamsController ctrl = new ListFutureExamsController(AuthzRegistry.authorizationService());

    @Override
    protected boolean doShow() {

        try {

            Iterable<ExamTemplate> exams = ctrl.listFutureExams();

            if (exams.iterator().hasNext()) {
                for (ExamTemplate exam : exams) {
                    System.out.println(exam);
                }
            } else {
                System.out.println("The student does not have future exams");
            }
        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        return true;
    }

    @Override
    public String headline() {
        return "Find Future Exams";
    }
}
