package org.app.teacher;

import boards.CreateBoardUI;
import courses.ListCoursesUI;
import eapli.framework.actions.Actions;
import eapli.framework.actions.menu.Menu;
import eapli.framework.presentation.console.AbstractUI;
import eapli.framework.presentation.console.ExitWithMessageAction;
import eapli.framework.presentation.console.menu.MenuItemRenderer;
import eapli.framework.presentation.console.menu.MenuRenderer;
import eapli.framework.presentation.console.menu.VerticalMenuRenderer;
import exams.CreateExamUI;
import exams.ListCourseExamsUI;
import exams.ListCourseGradesUI;
import exams.UpdateExamUI;
import formative.questions.CreateFormativeQuestionsUI;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.user.management.CourseRoles;
import scheduleclasses.ScheduleClassUI;

public class MainMenu extends AbstractUI {
    private static final String RETURN_LABEL = "Return ";

    private static final int EXIT_OPTION = 0;

    // TEACHER SUB-MENUS
    private static final int SET_TEACHER_MANAGE_COURSES_OPTION = 1;

    // TEACHER MANAGE COURSES
    private static final int SET_TEACHER_LIST_AVAILABLE_COURSES_OPTION = 1;

    //SHARED BOARD
    private static final int SET_USER_BOARD_OPTION = 9;
    private static final int SET_USER_CREATE_BOARD_OPTION = 1;

    private static final int SET_TEACHER_SCHEDULE_CLASS_OPTION = 2;


    // FORMATIVE QUESTIONS
    private static final int SET_USER_CREATE_FORMATIVE_QUESTION_OPTION = 1;
    private static final int SET_FORMATIVE_QUESTION_OPTION = 2;

    //EXAMS
    private static final int SET_TEACHER_CREATE_EXAM_OPTION = 1;
    private static final int SET_TEACHER_UPDATE_EXAM_OPTION = 2;

    private static final int SET_TEACHER_LIST_COURSE_EXAMS_OPTION = 3;
    private static final int SET_EXAM_OPTION = 3;

    private static final int SET_TEACHER_EXAM_GRADES_OPTION = 4;
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

        if(authz.isAuthenticatedUserAuthorizedTo(CourseRoles.TEACHER)) {
            final Menu teacherMenu = buildTeacherMenu();
            final Menu formativeQuestionsMenu = buildFormativeQuestionsMenu();
            final Menu examMenu = buildExamMenu();
            final Menu boardMenu = buildBoardMenu();

            mainMenu.addSubMenu(SET_TEACHER_MANAGE_COURSES_OPTION, teacherMenu);
            mainMenu.addSubMenu(SET_FORMATIVE_QUESTION_OPTION, formativeQuestionsMenu);
            mainMenu.addSubMenu(SET_EXAM_OPTION, examMenu);
            mainMenu.addSubMenu(SET_USER_BOARD_OPTION, boardMenu);
        }

        mainMenu.addItem(EXIT_OPTION, "Exit", new ExitWithMessageAction("Bye, Bye"));

        return mainMenu;
    }

    private Menu buildTeacherMenu() {
        final Menu menu = new Menu("Manage eCourse Courses");

        menu.addItem(SET_TEACHER_LIST_AVAILABLE_COURSES_OPTION,
                "List Available Courses", new ListCoursesUI()::show);
        menu.addItem(SET_TEACHER_SCHEDULE_CLASS_OPTION,
                "Schedule Class", new ScheduleClassUI()::show);

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

    private Menu buildFormativeQuestionsMenu() {
        final Menu menu = new Menu("Formative Questions");

        menu.addItem(SET_USER_CREATE_FORMATIVE_QUESTION_OPTION, "Create Formative Question",
                new CreateFormativeQuestionsUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    private Menu buildExamMenu(){
        final Menu menu = new Menu("Exams");

        menu.addItem(SET_TEACHER_CREATE_EXAM_OPTION, "Create Exam",
                new CreateExamUI()::show);
        menu.addItem(SET_TEACHER_UPDATE_EXAM_OPTION, "Update Exam",
                new UpdateExamUI()::show);
        menu.addItem(SET_TEACHER_LIST_COURSE_EXAMS_OPTION,
                "List Course Exams", new ListCourseExamsUI()::show);
        menu.addItem(SET_TEACHER_EXAM_GRADES_OPTION, "Get Course Grades",
                new ListCourseGradesUI()::show);
        menu.addItem(EXIT_OPTION, RETURN_LABEL, Actions.SUCCESS);

        return menu;
    }

    @Override
    public String headline() {
        return "eCourse";
    }
}
