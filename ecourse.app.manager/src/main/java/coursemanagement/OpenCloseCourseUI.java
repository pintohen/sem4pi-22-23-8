package coursemanagement;


import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.authz.application.AuthorizationService;
import org.course.controller.ChangeStateController;
import org.domain.model.Course;
import org.domain.model.CourseState;
import org.domain.model.CourseStateConstants;
import org.persistence.PersistenceContext;

public class OpenCloseCourseUI extends AbstractUI {

    private static ChangeStateController ctrl = new ChangeStateController(PersistenceContext.repositories().users(),
            PersistenceContext.repositories().courses(), new AuthorizationService());

    @Override
    protected boolean doShow() {
        try {
            final String code = Console.readLine("What is the code of the course to be opened/closed?");

            Course course = ctrl.verifyCourse(code);

            if (course != null) {
                if(ctrl.confirmForOpenClose(course)){
                    showState(course);
                }
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    private void showState(Course course){
        if(course.state().equals(CourseState.of(String.valueOf(CourseStateConstants.CLOSED)))){
            final Integer option = Console.readInteger("The course's state is currently " + CourseStateConstants.CLOSED +
                    "\nDo you want to change it to " + CourseStateConstants.OPEN + "?\n1-Yes\nAny-No");
            if(option == 1){
                ctrl.changeState(course);
                System.out.println("The state was changed successfully");
            }else{
                throw new IllegalArgumentException("The state was not changed");
            }
        }else{
            final Integer option = Console.readInteger("The course's state is currently " + CourseStateConstants.IN_PROGRESS +
                    "\nDo you want to change it to " + CourseStateConstants.CLOSED + "?\n1-Yes\nAny-No");
            if(option == 1){
                ctrl.changeState(course);
                System.out.println("The state was changed successfully");
            }else{
                throw new IllegalArgumentException("The state was not changed");
            }
        }
    }

    @Override
    public String headline() {
        return "Open or close Course";
    }
}
