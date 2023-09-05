package usermanagement;

import eapli.framework.presentation.console.AbstractUI;
import org.usermanagement.controller.ListUsersController;
import org.usermanagement.domain.model.User;

public class ListUsersUI extends AbstractUI {
    private final ListUsersController theController = new ListUsersController();

    /**
     * Manager want to list all users.
     * @return false
     */
    @Override
    protected boolean doShow() {
        Iterable<User> allUsers = theController.listAllUsers();

        for (User user : allUsers) {
            System.out.println(user.shortName().value()
                    + " | " + user.emailAddress()
                    + " | " + user.role()
                    + " | " + user.isActive());
        }

        return false;
    }

    @Override
    public String headline() {
        return "List Users (Short Name | Email | Role | User State)";
    }
}
