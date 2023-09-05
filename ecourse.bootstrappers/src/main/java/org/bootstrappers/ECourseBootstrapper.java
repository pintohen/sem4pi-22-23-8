package org.bootstrappers;

import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.ConcurrencyException;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.validations.Invariants;
import org.authz.application.AuthenticationService;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.bootstrappers.demo.*;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;
import org.usermanagement.domain.model.UserBuilderHelper;
import org.usermanagement.domain.repositories.UserRepository;

public class ECourseBootstrapper implements Action {
    /**
     * The repository for managing user entities.
     */
    private final UserRepository userRepository = PersistenceContext
                                                .repositories().users();
    /**
     * The authorization service for managing user authorization.
     */
    private final AuthorizationService authz = AuthzRegistry
                                                .authorizationService();
    /**
     * The authentication service for managing user authentication.
     */
    private final AuthenticationService authenticationService = AuthzRegistry
                                                    .authenticationService();

    /**
     * The short name for the manager user used during bootstrapping.
     */
    private static final String M_BOOTSTRAP_SHORT_NAME = "manager";

    /**
     * The full name for the manager user used during bootstrapping.
     */
    private static final String M_BOOTSTRAP_FULL_NAME = "manager bootstrap";

    /**
     * The password for the manager user used during bootstrapping.
     */
    private static final String M_BOOTSTRAP_EMAIL = "managerbootstr@email.com";

    /**
     * The password for the manager user used during bootstrapping.
     */
    private static final String M_BOOTSTRAP_PASSWORD = "ManagerPassword1";

    /**
     * Executes the bootstrapping action by registering the manager user.
     * Invoke the users bootstrapper.
     * @return true if the bootstrapping action is successful, false otherwise.
     */
    @Override
    public boolean execute() {
        registerManagerUser(userRepository);
        authenticateForBootstrapping();

        executeUsers();
        executeCourses();
        executeBoards();
        executeEnrollmentRequests();
        executeExamTemplates();
        executeExamSubmissions();
        executePostIts();

        return true;
    }

    private boolean executeExamSubmissions() {
        ExamsBootstrapper bootstrapper = new ExamsBootstrapper();

        System.out.println("Bootstrapper --> " + bootstrapper.getClass().getSimpleName());

        return bootstrapper.execute();
    }

    /**
     * Bootstrap for enrollment requests.
     * @return true/false
     */
    private boolean executeEnrollmentRequests() {
        EnrollmentRequestsBootstrapper bootstrapper =
                new EnrollmentRequestsBootstrapper();

        System.out.println("Bootstrapper --> "
                + bootstrapper.getClass().getSimpleName());

        return bootstrapper.execute();
    }

    /**
     * Boostrap for Users.
     * @return true/false
     */
    public boolean executeUsers(){
        UsersBootstrapper usersBootstrapper = new UsersBootstrapper();
        System.out.println("Bootstrapper --> "
                + usersBootstrapper.getClass().getSimpleName());

        return usersBootstrapper.execute();
    }

    /**
     * Boostrap for Courses.
     * @return true/false
     */
    public boolean executeCourses(){
        CoursesBootstrapper bootstrapper = new CoursesBootstrapper();
        System.out.println("Bootstrapper --> " + bootstrapper.getClass().getSimpleName());

        return bootstrapper.execute();
    }

    /**
     * Boostrap for Exam Templates.
     * @return true/false
     */
    public boolean executeExamTemplates() {
        ExamTemplatesBootstrapper bootstrapper = new ExamTemplatesBootstrapper();
        System.out.println("Bootstrapper --> " + bootstrapper.getClass().getSimpleName());

        return bootstrapper.execute();
    }

    /**
     * Boostrap for Boards.
     * @return true/false
     */
    public boolean executeBoards() {
        BoardsBootstrapper bootstrapper = new BoardsBootstrapper();
        System.out.println("Bootstrapper --> " + bootstrapper.getClass().getSimpleName());

        return bootstrapper.execute();
    }

    /**
     * Boostrap for post-its.
     * @return true/false
     */
    public boolean executePostIts() {
        PostItBootstrapper bootstrapper = new PostItBootstrapper();
        System.out.println("Bootstrapper --> " + bootstrapper.getClass().getSimpleName());

        return bootstrapper.execute();
    }

    /**
     * Registers the manager user in the system during bootstrapping.
     * @param userRepository the repository for managing user entities.
     * @return true if the registration is successful, false otherwise.
     */
    public static boolean registerManagerUser(
                            final UserRepository userRepository) {
        final UserBuilder userBuilder = UserBuilderHelper.builder();

        userBuilder
                .withShortName(M_BOOTSTRAP_SHORT_NAME)
                .withFullName(M_BOOTSTRAP_FULL_NAME)
                .withPassword(M_BOOTSTRAP_PASSWORD)
                .withEmail(M_BOOTSTRAP_EMAIL)
                .withRole(CourseRoles.MANAGER)
                .withTaxPayerNumber("999999999")
                .withBirthDate("16/11/2002");
        final User newUser = userBuilder.build();

        try {
            final User managerUser = userRepository.save(newUser);
            assert managerUser != null;
            return true;
        } catch (ConcurrencyException | IntegrityViolationException e) {
            return false;
        }
    }

    /**
     * Authenticates the manager user.
     */
    protected void authenticateForBootstrapping() {
        authenticationService.authenticate(M_BOOTSTRAP_EMAIL,
                M_BOOTSTRAP_PASSWORD);
        Invariants.ensure(authz.hasSession());
    }
}
