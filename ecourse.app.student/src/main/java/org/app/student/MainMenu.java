package org.app.student;

import boards.CreateBoardUI;
import courses.ListCoursesUI;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;
import enrollment.RequestEnrollmentUI;
import exams.ListExamGradesUI;
import exams.ListFutureExamsUI;
import exams.TakeExamUI;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.user.management.CourseRoles;

public class MainMenu extends AbstractUI {
    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // STUDENT SUB-MENUS
    private static final int SET_STUDENT_MANAGE_COURSES_OPTION = 1;

    // STUDENT MANAGE COURSES
    private static final int SET_STUDENT_LIST_AVAILABLE_COURSES_OPTION = 1;
    private static final int SET_STUDENT_ENROLL_COURSE_OPTION = 2;

    //SHARED BOARD
    private static final int SET_USER_BOARD_OPTION = 9;
    private static final int SET_USER_CREATE_BOARD_OPTION = 1;

    //EXAMS

    private static final int SET_EXAM_OPTION = 2;
    private static final int SET_STUDENT_LIST_FUTURE_EXAMS_OPTION = 1;
    private static final int SET_STUDENT_TAKE_EXAM_OPTION = 2;
    private static final int SET_STUDENT_LIST_EXAM_GRADES_OPTION = 3;


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

        if (authz.isAuthenticatedUserAuthorizedTo(CourseRoles.STUDENT)) {
            final Menu studentMenu = buildStudentMenu();
            final Menu examMenu = buildExamMenu();
            final Menu boardMenu = buildBoardMenu();

            mainMenu.addSubMenu(SET_STUDENT_MANAGE_COURSES_OPTION, studentMenu);
            mainMenu.addSubMenu(SET_EXAM_OPTION, examMenu);
            mainMenu.addSubMenu(SET_USER_BOARD_OPTION, boardMenu);
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildStudentMenu() {
        final Menu menu = new Menu("Manage eCourse Courses");

        menu.addItem(SET_STUDENT_LIST_AVAILABLE_COURSES_OPTION,
                "List Available Courses", new ListCoursesUI()::show);

        menu.addItem(
                SET_STUDENT_ENROLL_COURSE_OPTION,
                "Request Enrollment in a Course",
                new RequestEnrollmentUI()::show
        );

        return menu;
    }

    private Menu buildExamMenu(){
        final Menu menu = new Menu("Exams");

        menu.addItem(SET_STUDENT_LIST_FUTURE_EXAMS_OPTION, "List Future Exams",
                new ListFutureExamsUI()::show);
        menu.addItem(SET_STUDENT_TAKE_EXAM_OPTION, "Take an Exam",
                new TakeExamUI()::show);
        menu.addItem(SET_STUDENT_LIST_EXAM_GRADES_OPTION, "List Exam Grades", new ListExamGradesUI()::show);
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
