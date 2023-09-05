# US 1001 - Register User

## 1. Context

In Sprint B client wants us to develop a feature for our System. He wants that a Manager to be able to register Teachers and Students, as well as Managers.

## 2. Requirements

As Manager, I want to be able to register Teachers and Students, as well as Managers

## 3. Analysis
Information in System Specification

	All users should be identified in the system by their email. Each user should also provide its full name and short name. In order to be authenticated by the system the users must also provide a password.

	Managers - Managers (they can be also named as Administrators) manage all the users of the system

	Teacher - "A Teacher is characterized by his/her name, date of birth, tax payer number and an acronym inputed by the administrator (e.g., "AALB")"

	Student - A student is characterized by his/her name, date of birth, tax payer number and a mechanographic number assigned automatically by the system based on the year of registration and a sequential number, e.g., "202300001".

This is an excerpt of our domain Model, it provides the clear idea of how the User should be identified according to the information in System Specification.

![Domain Model Excerpt](Analysis/DomainModelExcerpt.svg)

So all users should have:
- Email
- Full Name
- Short Name
- Password
- Birth Date
- Tax Payer Number

Teachers should have Acronym

Students should have Mechanographic Number

## 4. Design

### 4.1. Realization

#### 4.1.1. Sequence Diagram Register User

![Register User SD](SD/RegisterUser-SD.svg)

### 4.2. Class Diagram Register User

![Register User CD](CD/RegisterUser-CD.svg)

### 4.3. Applied Patterns

#### 4.3.1. Factory

- Our PersistenceContext will create a RepositoryFactory based on the configuration file then the RepositoryFactory will create the repository that we need in order to persist our domain entity.

#### 4.3.2 Service

- Services are operations or functions that are not naturally in line with the responsibility of an entity or value object. They are used to model operations that involve multiple objects or complex behaviour.

#### 4.3.3 Single Responsibility Principle (SRP)

- Ensure that each object has a clear and well-defined responsibility within the domain.

#### 4.3.4 Tell, Don't Ask

- Ensure that objects do not expose their internal state or behaviour to the outside world. On the contrary, objects should receive commands telling them what they should do, rather than being asked for information about their current state.

#### 4.3.5 Singleton Pattern

- Only one instance, and provides a global point of access to that instance. 
- The Authentication Registry is a singleton, since from this class we can only get aninstance of the authentication service, the authorization service and the user management service. 

#### 4.3.6 Model-View-Controller (MVC)

- Model is responsible for managing the data and business logic of the application. (UserManagementService, AuthorizationService)
- View is responsible for presenting the data to the user in a human-readable format. (AddUserUI)
- Controller is responsible for handling the user input and updating the model and the view accordingly. (AddUserController)


### 4.4. Tests

**Test 1:** *Create a Manager Successfully*

```Java
@Test
void registerManagerSuccessfully() {
    when(userRepository.save(any(User.class))).thenReturn(managerUser());

    User newUser = userSvc.registerNewUser(STRING_SHORTNAME,
                STRING_PASSWORD,
                STRING_FULLNAME,
                STRING_EMAIL,
                CourseRoles.MANAGER,
                STRING_BIRTHDATE,
                STRING_TAXPAYERNUMBER,
                null);

    assertEquals(managerUser().identity(), newUser.identity());
    verify(userRepository, times(1)).save(any(User.class));
}
````

**Test 2:** *Create a Teacher Successfully*

```Java
@Test
void registerTeacherSuccessfully() {
    when(userRepository.save(any(User.class))).thenReturn(teacherUser());

    User newUser = userSvc.registerNewUser(STRING_SHORTNAME,
                STRING_PASSWORD,
                STRING_FULLNAME,
                STRING_EMAIL,
                CourseRoles.TEACHER,
                STRING_BIRTHDATE,
                STRING_TAXPAYERNUMBER,
                STRING_ACRONYM);

    assertNull(newUser.mecanographicNumber());
    assertNotNull(newUser.acronym());
    assertEquals(STRING_ACRONYM, newUser.acronym().value());
    verify(userRepository, times(1)).save(any(User.class));
}
````

**Test 3:** *Create a Student Successfully*

```Java
@Test
void registerStudentSuccessfully() {
	when(userRepository.save(any(User.class))).thenReturn(studentUser());

	User newUser = userSvc.registerNewUser(STRING_SHORTNAME,
	STRING_PASSWORD,
	STRING_FULLNAME,
	STRING_EMAIL,
	CourseRoles.STUDENT,
	STRING_BIRTHDATE,
	STRING_TAXPAYERNUMBER,
	null);

	assertNull(newUser.acronym());
	assertNotNull(newUser.mecanographicNumber());
	assertEquals(String.valueOf(LocalDateTime.now().getYear() * 100000 + 1), newUser.mecanographicNumber().value());
	verify(userRepository, times(1)).save(any(User.class));
	verify(userRepository, times(1)).findMaxYearMecanographicNumber();
}
````

**Test 4:** *Register a User with invalid email*

```Java
@Test
void registerNewUserWithInvalidEmailThenThrowException() {
    assertThrows(
            IllegalArgumentException.class,
            () ->
                userSvc.registerNewUser(
                                STRING_SHORTNAME,
                                STRING_PASSWORD,
                                STRING_FULLNAME,
                                "invalid_email",
                                CourseRoles.TEACHER,
                                STRING_BIRTHDATE,
                                STRING_TAXPAYERNUMBER,
                                STRING_ACRONYM,
                                Calendar.getInstance()));

    verify(userRepository, never()).save(any(User.class));
}
````

**Test 5:** *Register a User with invalid password*

```Java
@Test
void registerNewUserWithInvalidPasswordThenThrowException() {
    assertThrows(
            IllegalArgumentException.class,
            () ->
                userSvc.registerNewUser(
                                STRING_SHORTNAME,
                                "invalid",
                                STRING_FULLNAME,
                                STRING_EMAIL,
                                CourseRoles.TEACHER,
                                STRING_BIRTHDATE,
                                STRING_TAXPAYERNUMBER,
                                STRING_ACRONYM,
                                Calendar.getInstance()));

    verify(userRepository, never()).save(any(User.class));
}
````

## 5. Implementation

**RegisterUserUI**

```Java
package presentation;

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

}
````

**RegisterUserController**

```Java
package org.usermanagement.controller;

import eapli.framework.application.UseCaseController;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserManagementService;

import java.util.Calendar;

/**
 * Controller class for adding a new user to the system.
 */
@UseCaseController
public class AddUserController {
    /**
     * Authorization service instance.
     */
    private final AuthorizationService authz = AuthzRegistry
                                            .authorizationService();
    /**
     * User management service instance.
     */
    private final UserManagementService userSvc = AuthzRegistry.userService();


    /**
     * Add a new user to the system with the provided details.
     * @param shortName  short name of the new user.
     * @param password  password of the new user.
     * @param fullName full name of the new user.
     * @param email     email of the new user.
     * @param role     roles of the new user.
     * @param birthDate     birthdate of the new user.
     * @param taxPayerNumber     taxPayerNumber of the new user.
     * @param acronym     acronym of the new user.
     * @param createdOn creation date of the new user.
     * @return SystemUser object.
     */
    public User addUser(final String shortName, final String password,
                        final String fullName, final String email,
                        final Role role, final String birthDate,
                        final String taxPayerNumber,
                        final String acronym, final Calendar createdOn) {
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.MANAGER);

        return userSvc.registerNewUser(shortName, password, fullName,
                                    email, role, birthDate,
                                    taxPayerNumber, acronym, createdOn);
    }

    /**
     * Add a new user to the system with the provided details.
     * @param shortName  short name of the new user.
     * @param password  password of the new user.
     * @param fullName full name of the new user.
     * @param email     email of the new user.
     * @param role     roles of the new user.
     * @param birthDate     birthdate of the new user.
     * @param taxPayerNumber     taxPayerNumber of the new user.
     * @param acronym     acronym of the new user.
     * @return User
     */
    public User addUser(final String shortName, final String password,
                        final String fullName, final String email,
                        final Role role, final String birthDate,
                        final String taxPayerNumber, final String acronym) {

        return addUser(shortName, password, fullName,
                        email, role, birthDate,
                        taxPayerNumber, acronym, CurrentTimeCalendars.now());
    }
}

````

**UserManagementService**

```Java
package org.usermanagement.domain.model;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.user.management.CourseRoles;
import org.usermanagement.domain.repositories.UserRepository;

import java.time.LocalDateTime;
import java.util.Calendar;

@Service
public class UserManagementService {
    /**
     * UserRepository.
     */
    private final UserRepository userRepository;
    /**
     * PasswordEncoder.
     */
    private final PasswordEncoder encoder;
    /**
     * PasswordPolicy with rules.
     */
    private final PasswordPolicy policy;

    /**
     * Generate MecanographicNumber Multiplier.
     */
    private static final int GENERATE_MUL = 100000;

    /**
     *
     * @param userRepo
     * @param encoderp
     * @param policyp
     */
    @Autowired
    public UserManagementService(final UserRepository userRepo,
                                 final PasswordPolicy policyp,
                                 final PasswordEncoder encoderp) {
        userRepository = userRepo;
        this.policy = policyp;
        this.encoder = encoderp;
    }

    /**
     * Registers a new user in the system allowing to
     * specify when the user account was created.
     * @param shortName
     * @param rawPassword
     * @param fullName
     * @param email
     * @param role
     * @param birthDate
     * @param taxPayerNumber
     * @param acronym
     * @param createdOn
     * @return User
     */
    public User registerNewUser(final String shortName,
                                final String rawPassword,
                                final String fullName, final String email,
                                final Role role, final String birthDate,
                                final String taxPayerNumber,
                                final String acronym,
                                final Calendar createdOn) {
        final var userBuilder = new UserBuilder(policy, encoder);

        userBuilder.with(shortName, rawPassword, fullName,
                        email, birthDate, role, taxPayerNumber)
                .createdOn(createdOn)
                .withAcronym(acronym);

        if (CourseRoles.STUDENT.equals(role)) {
            userBuilder.withMecanographicNumber(generateMecNumber());
        }

        final var newUser = userBuilder.build();

        return userRepository.save(newUser);
    }

    /**
     * Generate MecanographicNumber for users with role Student.
     * @return String for builder create MecanographicNumber
     */
    private String generateMecNumber() {
        MecanographicNumber mecanographicNumber = userRepository
                                .findMaxYearMecanographicNumber();

        if (mecanographicNumber == null) {
            return String.valueOf(
                    LocalDateTime.now().getYear() * GENERATE_MUL + 1);
        }

        mecanographicNumber.nextNumber();

        return mecanographicNumber.value();
    }

    /**
     * Registers a new user in the system.
     * @param shortName
     * @param rawPassword
     * @param fullName
     * @param email
     * @param role
     * @param birthDate
     * @param taxPayerNumber
     * @param acronym
     * @return User
     */
    public User registerNewUser(final String shortName,
                                final String rawPassword,
                                final String fullName, final String email,
                                final Role role, final String birthDate,
                                final String taxPayerNumber,
                                final String acronym) {
        return registerNewUser(shortName, rawPassword, fullName, email,
                role, birthDate, taxPayerNumber,
                acronym, CurrentTimeCalendars.now());
    }

    /**
     *
     * @return all users no matter their status
     */
    public Iterable<User> allUsers() {
        return userRepository.findAll();
    }

    /**
     * Find user by email and enable.
     * @param userEmail EmailAddress of user
     * @return the user enabled.
     */
    public User enableUser(final EmailAddress userEmail) {
        final User userToEnable = userRepository
                .findUserByEmail(userEmail).get();

        userToEnable.enable();

        return userRepository.save(userToEnable);
    }

    /**
     * Find user by email and disable.
     * @param userEmail EmailAddress of user
     * @return the user disabled.
     */
    public User disableUser(final EmailAddress userEmail) {
        final User userToDisable = userRepository
                .findUserByEmail(userEmail).get();

        userToDisable.disable(CurrentTimeCalendars.now());

        return userRepository.save(userToDisable);
    }
}
````

## 6. Integration/Demonstration

Login as a Manager

```txt
+= Login ======================================================================+

Email: managerteste123@email.com

Password: PasswordManager1


+==============================================================================+
```

Menu Manager choose "Create Users"

```txt
+= eCourse ====================================================================+

1. Manage eCourse Users
2. Manage eCourse Courses
0. Exit

Please choose an option
1

>> Manage eCourse Users
1. Create Users
2. Enable User
3. Disable User
4. List Users
0. Return 

Please choose an option
```

Form to register new Manager

```txt
+= Register User ==============================================================+

1 - MANAGER
2 - TEACHER
3 - STUDENT
Choose Role:
1
ShortName:
Manager
Password:
PasswordManager5
Full Name:
Manager Register
E-Mail:
manager_register@gmail.com
Birth Date (dd/MM/yyyy):
10/10/1990
Tax Payer Number:
111212333
User Successfully created!
+==============================================================================+
```

Form to register new Teacher

```txt
+= Register User ==============================================================+

1 - MANAGER
2 - TEACHER
3 - STUDENT
Choose Role:
2
ShortName:
Teacher
Password:
PasswordTeacher9
Full Name:
Teacher Register
E-Mail:
teacher_register@gmail.com
Birth Date (dd/MM/yyyy):
21/02/1997
Tax Payer Number:
989888123
Acronym:
TRH
User Successfully created!
+==============================================================================+
```

Form to register new Student

```txt
+= Register User ==============================================================+

1 - MANAGER
2 - TEACHER
3 - STUDENT
Choose Role:
3
ShortName:
Student
Password:
PasswordStudent8
Full Name:
Student Register
E-Mail:
student_register@gmail.com
Birth Date (dd/MM/yyyy):
10/04/2000
Tax Payer Number:
773111719
User Successfully created!
+==============================================================================+
```