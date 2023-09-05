package coursemanagement;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.validations.Preconditions;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.course.controller.AddCourseTeacherController;
import org.domain.model.Course;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;

import java.util.Set;

public class AddCourseTeacherUI extends AbstractUI {

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final AddCourseTeacherController ctrl = new AddCourseTeacherController();

    @Override
    protected boolean doShow() {
        try{
            UserSession session = authz.session().orElse(null);

            Preconditions.nonNull(session);

            assert session != null;
            User user = session.authenticatedUser();

            String loggedRole = user.role();

            if (loggedRole.equals(CourseRoles.MANAGER.toString())) {
                askForCourseInformation();
            } else {
                System.out.println("Only managers can create courses");
            }
        }catch (IllegalArgumentException e){
            e.getMessage();
        }
        return true;
    }

    private void askForCourseInformation(){
        final String code = Console.readLine("What is the code for the course to add teachers?");
        if(ctrl.verifyCourse(code)!= null){
            showTeachers(ctrl.verifyCourse(code));
        }else{
            throw new IllegalArgumentException("There is no course with that code. The input code is case sensitive.");
        }
    }

    private void showTeachers(Course course){
        Set<User> teachers = ctrl.getTeachersAvailable(course);
        if(teachers.size()==0){
            System.out.println("There are no teachers available");
        }else {
            for (User user : teachers) {
                System.out.println();
                System.out.println(user.emailAddress().toString());
            }
            System.out.println();
            String email = Console.readLine("Which teacher do you want to add?(case sensitive)");
            int value = 0;

            for (User user : teachers) {
                if (user.emailAddress().toString().equals(email)) {
                    ctrl.addTeacherToCourse(course, user);
                    System.out.println("The teacher was successfully added!");
                    value++;
                    break;
                }
            }
            if (value == 0) {
                throw new IllegalArgumentException("That email was not listed. Try again with one in the list");
            }
        }
    }

    @Override
    public String headline() {
        return "Add a teacher to a course";
    }
}

