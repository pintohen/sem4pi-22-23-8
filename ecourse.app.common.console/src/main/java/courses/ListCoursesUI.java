package courses;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.validations.Preconditions;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.course.controller.RetrieveCoursesController;
import org.domain.model.Course;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;

public class ListCoursesUI extends AbstractUI {
    private static final String HEADLINE = "List Courses available to me";
    private final AuthorizationService authzSvc =
            AuthzRegistry.authorizationService();

    private RetrieveCoursesController ctrl =
            new RetrieveCoursesController(PersistenceContext.repositories().courses());


    @Override
    protected boolean doShow() {
        UserSession session = authzSvc.session().orElse(null);

        Preconditions.noneNull(session, "Please Login to access this feature");

        User user = session.authenticatedUser();

        String loggedRole = user.role();

        if(loggedRole.equals(CourseRoles.MANAGER.toString())){

            Iterable<Course> courses = ctrl.getAllCourses();
            printCourses(courses, "All Courses existent");

        }else if(loggedRole.equals(CourseRoles.TEACHER.toString())){

            Iterable<Course> leadingCourses = ctrl
                    .getCoursesThatILead(user);

            Iterable<Course> teachingCourses = ctrl
                    .getCoursesThatITeach(user);

            printCourses(leadingCourses, "Courses that I lead");

            printCourses(teachingCourses, "Courses that I teach");

        }else if(loggedRole.equals(CourseRoles.STUDENT.toString())){

            Iterable<Course> courses = ctrl
                    .getCoursesAvailableForStudent(user);

            Iterable<Course> takenCourses = ctrl.getCoursesTakenByStudent(user);

            printCourses(courses, "Courses available for me");

            printCourses(takenCourses, "Courses that I am taking or took");

        }else{
            System.out.println("This role is not supported yet");
        }

        return true;
    }

    @Override
    public String headline() {
        return HEADLINE;
    }

    private void printCourses(Iterable<Course> courses, String context){
        System.out.println("\n" + context + "\n");

        if(!courses.iterator().hasNext())
            System.out.println("No courses found");
        else for (Course c : courses) {
                System.out.println(c);
            }

        System.out.println();
    }
}
