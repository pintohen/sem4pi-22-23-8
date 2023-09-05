package enrollment;

import eapli.framework.presentation.console.AbstractUI;
import org.authz.application.AuthzRegistry;
import org.enrollment.request.application.RequestEnrollmentController;

import java.util.Scanner;

public class RequestEnrollmentUI extends AbstractUI {
    private final Scanner sc = new Scanner(System.in);
    private final RequestEnrollmentController ctrl =
            new RequestEnrollmentController(AuthzRegistry.authorizationService());
    @Override
    protected boolean doShow() {


        try{
            System.out.print("Course Code of course to enroll: ");
            String courseCode = sc.nextLine();
            System.out.println();

            ctrl.createRequest(courseCode);

            System.out.println("Request for course " + courseCode + " created successfully.");
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
        return true;
    }

    @Override
    public String headline() {
        return "Request Enrollment";
    }
}
