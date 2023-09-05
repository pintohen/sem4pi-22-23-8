package coursemanagement;

import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.validations.Preconditions;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.course.controller.AddCourseController;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;
import eapli.framework.io.util.Console;

public class CreateCourseUI extends AbstractUI {

    private static final String HEADLINE = "Creation of a course";
    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    private final AddCourseController ctrl = new AddCourseController(PersistenceContext.repositories().courses(), PersistenceContext.repositories().users(), PersistenceContext.repositories().newTransactionalContext(), AuthzRegistry.authorizationService());
    @Override
    protected boolean doShow() {
        try {
            UserSession session = authz.session().orElse(null);

            Preconditions.noneNull(session, "Please Login to access this feature");

            User user = session.authenticatedUser();

            String loggedRole = user.role();

            if (loggedRole.equals(CourseRoles.MANAGER.toString())) {
                askForCourseInformation();
            } else {
                System.out.println("Only managers can create courses");
            }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }catch (IntegrityViolationException | ConcurrencyException e ){
            System.out.println("Already exists a course with the input code");
        }
        return true;
    }

    public void askForCourseInformation(){
        final String name = Console.readLine("Name :");
        final String code = Console.readLine("Code (can't be duplicated) :");
        final String edition = Console.readLine("Edition (can't be duplicated) :");
        final String description = Console.readLine("Description :");
        final Integer maximum = Console.readInteger("Maximum number of students that can enroll :");
        final Integer minimum = Console.readInteger("Minimum number of students that can enroll :");
        final String headTeacherEmail = Console.readLine("Email of the head teacher :");

        ctrl.addCourse(name,
                code,
                edition,
                description,
                maximum,
                minimum,
                headTeacherEmail);

        System.out.println("The course with the code " + code + " has been added to the database successfully!");
    }

    @Override
    public String headline() {
        return HEADLINE;
    }
}