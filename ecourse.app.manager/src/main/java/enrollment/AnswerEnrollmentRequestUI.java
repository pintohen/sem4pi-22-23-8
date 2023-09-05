package enrollment;

import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.validations.Preconditions;
import org.authz.application.AuthzRegistry;
import org.enrollment.request.application.AnswerEnrollmentRequestController;
import org.enrollment.request.domain.EnrollmentRequest;
import org.persistence.PersistenceContext;

import java.util.List;
import java.util.Scanner;

public class AnswerEnrollmentRequestUI extends AbstractUI {

    private final Scanner sc = new Scanner(System.in);
    private final AnswerEnrollmentRequestController ctrl =
            new AnswerEnrollmentRequestController(
                    PersistenceContext
                            .repositories()
                            .enrollmentRequests(),
                    AuthzRegistry
                            .authorizationService()
            );
    @Override
    protected boolean doShow() {

        try{

            List<EnrollmentRequest> pendingRequests = this.ctrl.getPendingRequests();

            EnrollmentRequest selected = showAndSelect(pendingRequests, "Pending Requests");

            boolean accept = acceptOrReject();

            if(accept) {
                this.ctrl.acceptRequest(selected);

                System.out.println("Enrollment Request accepted with success!");
            }else {
                this.ctrl.rejectRequest(selected);

                System.out.println("Enrollment Request rejected with success!");
            }

        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());

            return false;
        }

        return true;
    }

    @Override
    public String headline() {
        return "Answer Request";
    }

    public EnrollmentRequest showAndSelect(List<EnrollmentRequest> requests, String message){
        int i = 0;

        System.out.println(message);

        for(EnrollmentRequest request : requests){
            System.out.println(i+1 + " - " + request.toString());
            i++;
        }

        int option;
        try{
            System.out.print("Select an option: ");
            option = Integer.parseInt(sc.nextLine());
            System.out.println();
        }catch(NumberFormatException nfe){
            throw new IllegalArgumentException("Invalid option, try again.");
        }


        Preconditions.ensure(option > 0 && option <= requests.size(), "Invalid option, try again.");

        return requests.get(option-1);
    }

    public boolean acceptOrReject(){
        System.out.println("1 - Accept");
        System.out.println("2 - Reject");
        System.out.print("Select an option: ");
        int option = Integer.parseInt(sc.nextLine());
        System.out.println();

        Preconditions.ensure(option == 1 || option == 2, "Invalid option, try again.");

        return option == 1;
    }
}
