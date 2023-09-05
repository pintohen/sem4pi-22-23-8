package usermanagement;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.usermanagement.controller.ChangeUserStateController;

import java.util.NoSuchElementException;

public class EnableUserUI extends AbstractUI {
    private final ChangeUserStateController theController = new ChangeUserStateController();

    /**
     * Manager want to enable a user.
     * Ask Manager email of user to enable.
     * @return false
     */
    @Override
    protected boolean doShow() {
        try{
            final String email = Console.readLine("E-Mail:");

            EmailAddress emailAddress = EmailAddress.valueOf(email);

            theController.enableUserByEmail(emailAddress);

            System.out.println("User enabled with success!");
        } catch (NoSuchElementException | IllegalArgumentException e){
            System.out.println("This user doesn't exist");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    @Override
    public String headline() {
        return "Enable User";
    }
}
