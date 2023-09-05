package org.bootstrappers.demo;

import eapli.framework.actions.Action;
import org.bootstrappers.UsersBootstrapperBase;
import org.user.management.CourseRoles;

public class UsersBootstrapper extends UsersBootstrapperBase implements Action {
    /**
     * Password for Manager.
     */
    private static final String PASSWORD_M = "PasswordManager1";
    /**
     * Password for Teacher.
     */
    private static final String PASSWORD_T = "PasswordTeacher1";
    /**
     * Password for Student.
     */
    private static final String PASSWORD_S = "PasswordStudent1";

    /**
     * Bootstraping (Manager, Teacher, Student).
     * @return true if all execute
     */
    @Override
    public boolean execute() {
        registerManager("Samuel", PASSWORD_M, "Samuel Dias",
                "managerteste123@email.com", "10/07/2000", "111111111");
        registerTeacher("Henrique", PASSWORD_T, "Henrique Pinto",
                "teacher@email.com", "23/04/2001", "222222222", "HRP");
        registerTeacher("Maria", PASSWORD_T, "Maria Albertina",
                "teacher2@email.com", "25/05/1998", "123123123", "MAB");
        registerStudent("Pedro", PASSWORD_S, "Pedro Alves",
                 "student1@email.com", "09/12/1999",  "333333333");
        registerStudent("Bruna", PASSWORD_S, "Bruna Costa",
                "student2@email.com", "18/01/2001",  "444444444");
        registerStudent("João", PASSWORD_S, "João Silva","student3@email.com",
                "01/01/2000",  "555555555");
        registerStudent("Francisca", PASSWORD_S, "Francisca Santos",
                "student4@email.com","01/01/2000", "666666666");

        return true;
    }


    /**
     * Bootstrap to register a Manager.
     * @param shortName
     * @param password
     * @param fullName
     * @param email
     * @param birthDate
     * @param taxPayNumber
     */
    private void registerManager(final String shortName, final String password,
                                 final String fullName, final String email,
                                 final String birthDate,
                                 final String taxPayNumber) {

        registerUser(shortName, password, fullName,
                email, CourseRoles.MANAGER,
                birthDate, taxPayNumber, null);
    }

    /**
     * Bootstrap to register a Teacher.
     * @param shortName
     * @param password
     * @param fullName
     * @param email
     * @param birthDate
     * @param taxPayNumber
     * @param acronym
     */
    private void registerTeacher(final String shortName, final String password,
                                 final String fullName, final String email,
                                 final String birthDate,
                                 final String taxPayNumber,
                                 final String acronym) {

        registerUser(shortName, password, fullName,
                email, CourseRoles.TEACHER,
                birthDate, taxPayNumber, acronym);
    }

    /**
     * Bootstrap to register a Student.
     * @param shortName
     * @param password
     * @param fullName
     * @param email
     * @param birthDate
     * @param taxPayNumber
     */
    private void registerStudent(final String shortName, final String password,
                                 final String fullName, final String email,
                                 final String birthDate,
                                 final String taxPayNumber) {

        registerUser(shortName, password, fullName,
                email, CourseRoles.STUDENT,
                birthDate, taxPayNumber, null);
    }
}
