package exams;

import eapli.framework.presentation.console.AbstractUI;
import org.authz.application.AuthzRegistry;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.exam.application.ListCourseExamsController;

import java.util.Scanner;

public class ListCourseExamsUI extends AbstractUI {

    Scanner scanner = new Scanner(System.in);

    private final ListCourseExamsController ctrl = new ListCourseExamsController(AuthzRegistry.authorizationService());


    @Override
    protected boolean doShow() {

        try {

            System.out.println("Which course do you want to see the exams of?");

            String courseCode = scanner.nextLine();

            Iterable<ExamTemplate> exams = ctrl.listCourseExams(courseCode);

            if (exams.iterator().hasNext()){
                for (ExamTemplate exam : exams) {
                    System.out.println(exam);
                }
            } else {
                System.out.println("There are no exams for this course");
            }

        } catch (IllegalArgumentException iae) {
            System.out.println(iae.getMessage());
        }

        return true;
    }

        @Override
        public String headline () {
            return "List Course Exams UI";
        }
    }
