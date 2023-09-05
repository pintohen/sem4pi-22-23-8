package usermanagement;

import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.user.management.CourseRoles;
import org.usermanagement.controller.AddUserController;

public class RegisterUserUI extends AbstractUI {
    private final AddUserController theController = new AddUserController();

    /**
     * Manager want to register a new User.
     * Ask manager fields.
     * ShortName, Password, Full Name, E-Mail,
     * Birth Date, Tax Payer Number
     * If is a Teacher ask Acronym
     * @return false
     */
    @Override
    protected boolean doShow() {
        Role role = chooseRole();

        final String shortName = Console.readLine("ShortName:");
        final String password = Console.readLine("Password:");
        final String fullName = Console.readLine("Full Name:");
        final String email = Console.readLine("E-Mail:");
        final String birthDate = Console.readLine("Birth Date (dd/MM/yyyy):");
        final String taxPayerNumber = Console.readLine("Tax Payer Number:");
        String acronym = null;

        if(role == CourseRoles.TEACHER){
            acronym = Console.readLine("Acronym:");
        }

        try {
            theController.addUser(shortName, password, fullName,
                    email, role, birthDate, taxPayerNumber, acronym);

            System.out.println("User Successfully created!");
        } catch (@SuppressWarnings("unused") final IntegrityViolationException e) {
            System.out.println("That email or taxpayer number is already in use.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    /**
     * Show all roles for Manager choose
     * @return Role to create User
     */
    public Role chooseRole(){
        Role[] allRoles = CourseRoles.allRoles();

        for(int i = 0; i < allRoles.length; i++){
            System.out.println((i + 1) + " - " + allRoles[i]);
        }

        final int chooseRole = Integer.parseInt(
                Console.readLine("Choose Role:"));

        if(chooseRole > 0 && chooseRole <= allRoles.length){
            return allRoles[chooseRole - 1];
        }

        return null;
    }

    /**
     * @return String to headline
     */
    @Override
    public String headline() {
        return "Register User";
    }
}
