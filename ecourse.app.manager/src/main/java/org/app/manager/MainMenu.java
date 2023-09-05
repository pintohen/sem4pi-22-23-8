package org.app.manager;

import boards.CreateBoardUI;
import coursemanagement.AddCourseTeacherUI;
import coursemanagement.CreateCourseUI;
import coursemanagement.OpenCloseCourseUI;
import coursemanagement.OpenCloseEnrollmentUI;
import courses.ListCoursesUI;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;
import enrollment.AnswerEnrollmentRequestUI;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.user.management.CourseRoles;
import usermanagement.DisableUserUI;
import usermanagement.EnableUserUI;
import usermanagement.ListUsersUI;
import usermanagement.RegisterUserUI;

public class MainMenu extends AbstractUI {
    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // MANAGER SUB-MENUS
    private static final int SET_MANAGER_MANAGE_USERS_OPTION = 1;
    private static final int SET_MANAGER_MANAGE_COURSES_OPTION = 2;

    //MANAGER MANAGE USER's
    private static final int SET_MANAGER_CREATE_USERS_OPTION = 1;
    private static final int SET_MANAGER_ENABLE_USER_OPTION = 2;
    private static final int SET_MANAGER_DISABLE_USER_OPTION = 3;
    private static final int SET_MANAGER_LIST_USERS_OPTION = 4;

    // MANAGER MANAGE COURSES
    private static final int SET_MANAGER_LIST_AVAILABLE_COURSES_OPTION = 1;
    private static final int SET_MANAGER_ANSWER_ENROLLMENT_REQUEST_OPTION = 2;

    private static final int SET_MANAGER_COURSE_CREATION_OPTION = 3;
    private static final int SET_MANAGER_COURSE_ENROLMENT_OPTION = 4;
    private static final int SET_MANAGER_COURSE_OPEN_CLOSE_OPTION = 5;
    private static final int SET_MANAGER_COURSE_ADD_TEACHER_OPTION = 6;
    //SHARED BOARD
    private static final int SET_USER_BOARD_OPTION = 9;
    private static final int SET_USER_CREATE_BOARD_OPTION = 1;

    private final AuthorizationService authz = AuthzRegistry.authorizationService();

    @Override
    public boolean show() {
        drawFormTitle();
        return doShow();
    }

    /**
     * @return true if the user selected the exit option
     */
    @Override
    public boolean doShow() {
        final Menu menu = buildMainMenu();
        final MenuRenderer renderer;

        renderer = new VerticalMenuRenderer(menu, MenuItemRenderer.DEFAULT);

        return renderer.render();
    }

    private Menu buildMainMenu() {
        final Menu mainMenu = new Menu();

        if (authz.isAuthenticatedUserAuthorizedTo(CourseRoles.MANAGER)) {
            final Menu managerMenu = buildManagerMenu();
            final Menu managerManageCoursesMenu = buildManagerManageCoursesMenu();
            final Menu boardMenu = buildBoardMenu();

            mainMenu.addSubMenu(SET_MANAGER_MANAGE_USERS_OPTION, managerMenu);
            mainMenu.addSubMenu(SET_MANAGER_MANAGE_COURSES_OPTION, managerManageCoursesMenu);
            mainMenu.addSubMenu(SET_USER_BOARD_OPTION, boardMenu);
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildManagerManageCoursesMenu() {
        final Menu menu = new Menu("Manage eCourse Courses");

        menu.addItem(SET_MANAGER_LIST_AVAILABLE_COURSES_OPTION,
                "List Available Courses", new ListCoursesUI()::show);
        menu.addItem(
                SET_MANAGER_ANSWER_ENROLLMENT_REQUEST_OPTION,
                "Accept or Reject a Enrollment Request",
                new AnswerEnrollmentRequestUI()::show
        );
        menu.addItem(
                SET_MANAGER_COURSE_CREATION_OPTION,
                "Create a new Course",
                new CreateCourseUI()::show
        );
        menu.addItem(
                SET_MANAGER_COURSE_ENROLMENT_OPTION,
                "Open/Close Enrollments in a Course",
                new OpenCloseEnrollmentUI()::show
        );
        menu.addItem(
                SET_MANAGER_COURSE_OPEN_CLOSE_OPTION,
                "Open/Close a course",
                new OpenCloseCourseUI()::show
        );
        menu.addItem(
                SET_MANAGER_COURSE_ADD_TEACHER_OPTION,
                "Add a teacher to a course",
                new AddCourseTeacherUI()::show
        );

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildManagerMenu() {
        final Menu menu = new Menu("Manage eCourse Users");

        menu.addItem(SET_MANAGER_CREATE_USERS_OPTION, "Create Users",
                new RegisterUserUI()::show);
        menu.addItem(SET_MANAGER_ENABLE_USER_OPTION, "Enable User",
                new EnableUserUI()::show);
        menu.addItem(SET_MANAGER_DISABLE_USER_OPTION, "Disable User",
                new DisableUserUI()::show);
        menu.addItem(SET_MANAGER_LIST_USERS_OPTION, "List Users",
                new ListUsersUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildBoardMenu() {
        final Menu menu = new Menu("Shared Boards");

        menu.addItem(SET_USER_CREATE_BOARD_OPTION, "Create Board",
                new CreateBoardUI()::show);

        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    @Override
    public String headline() {
        return "eCourse";
    }
}
