package exams;


import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.authz.application.AuthzRegistry;
import org.domain.model.Course;
import org.domain.model.exam.Exam;
import org.exam.application.ListCourseExamGradesController;
import org.persistence.PersistenceContext;

import java.util.List;

public class ListCourseGradesUI extends AbstractUI {

    private final ListCourseExamGradesController ctrl = new ListCourseExamGradesController(PersistenceContext.repositories().courses(),
            PersistenceContext.repositories().exams(),
            PersistenceContext.repositories().examTemplates());
    @Override
    protected boolean doShow() {

        try {
            List<Course> courses = (List<Course>) ctrl.getTeacherCourses(AuthzRegistry.authorizationService().session().get().authenticatedUser());

            System.out.println("These are all your courses\n");
            for (Course course : courses) {
                System.out.println(course.identity().value() + "\n");
            }

            String courseCode = Console.readLine("Which course would you like to get the grades from?");

            List<Exam> courseExams = (List<Exam>) ctrl.getExams(AuthzRegistry.authorizationService().session().get().authenticatedUser(),
                    courseCode);

            for (Exam exam : courseExams) {
                System.out.println(exam.toString());
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Grades of a course";
    }
}
