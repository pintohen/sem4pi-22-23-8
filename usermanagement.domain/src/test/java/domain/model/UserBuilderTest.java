package domain.model;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.*;

import java.util.Calendar;

class UserBuilderTest {

    private String emailString = "email@email.com";
    private EmailAddress email = EmailAddress.valueOf(emailString);
    private String shortNameString = "Short Name";
    private ShortName shortName = ShortName.of(shortNameString);
    private String fullNameString = "Full Name";
    private FullName fullName = FullName.of(fullNameString);
    private String passwordString = "Password1";
    private Password password = Password.encodedAndValid(
            passwordString,
            new ECoursePasswordPolicy(),
            new PlainTextEncoder()
    ).get();
    private Role managerRole = CourseRoles.MANAGER;

    private String teacherRoleString = String.valueOf(CourseRoles.TEACHER);
    private Role teacherRole = CourseRoles.TEACHER;

    private String studentRoleString = String.valueOf(CourseRoles.STUDENT);
    private Role studentRole = CourseRoles.STUDENT;
    private String numberMecString = "202010230";
    private MecanographicNumber numberMec = MecanographicNumber.of(numberMecString);
    private String birthDateString = "10/08/1990";
    private BirthDate birthDate = BirthDate.of(birthDateString);
    private String taxPayerNumberString = "123456789";
    private TaxPayerNumber taxPayerNumber = TaxPayerNumber.of(taxPayerNumberString);
    private String acronymString = "ACR";
    private Acronym acronym = Acronym.of(acronymString);



    private UserBuilder builder;

    @BeforeEach
    void setUp() {
        builder = UserBuilderHelper.builder();
    }

    @Test
    void buildValidManager(){
        User manager = builder
                .withEmail(emailString)
                .withShortName(shortNameString)
                .withFullName(fullNameString)
                .withPassword(passwordString)
                .withRole(managerRole)
                .build();

        User managerValueObjects = builder
                .withEmail(email)
                .withShortName(shortName)
                .withFullName(fullName)
                .withPassword(password)
                .withRole(managerRole)
                .build();

        User managerWith = builder
                .with(
                        shortNameString,
                        passwordString,
                        fullNameString,
                        emailString,
                        managerRole
                )
                .build();

        User managerWithVO = builder
                .with(
                        shortNameString,
                        passwordString,
                        fullNameString,
                        emailString,
                        birthDateString,
                        managerRole,
                        taxPayerNumberString
                )
                .build();


    }

    @Test
    void buildValidTeacher(){
        User teacher = builder
                .withEmail(emailString)
                .withShortName(shortNameString)
                .withFullName(fullNameString)
                .withPassword(passwordString)
                .withRole(teacherRoleString)
                .withAcronym(acronymString)
                .withTaxPayerNumber(taxPayerNumberString)
                .withBirthDate(birthDateString)
                .build();

        User teacherValueObjects = builder
                .withEmail(email)
                .withShortName(shortName)
                .withFullName(fullName)
                .withPassword(password)
                .withRole(teacherRole)
                .withAcronym(acronym)
                .withTaxPayerNumber(taxPayerNumber)
                .withBirthDate(birthDate)
                .build();
    }

    @Test
    void buildValidStudent(){
        User student = builder
                .withEmail(emailString)
                .withShortName(shortNameString)
                .withFullName(fullNameString)
                .withPassword(passwordString)
                .withRole(studentRoleString)
                .withMecanographicNumber(numberMecString)
                .withTaxPayerNumber(taxPayerNumberString)
                .withBirthDate(birthDateString)
                .build();

        User studentValueObjects = builder
                .withEmail(email)
                .withShortName(shortName)
                .withFullName(fullName)
                .withPassword(password)
                .withRole(studentRole)
                .withMecanographicNumber(numberMec)
                .withTaxPayerNumber(taxPayerNumber)
                .withBirthDate(birthDate)
                .build();

        User studentValueObjects2 = builder
                .withEmail(email)
                .withShortName(shortName)
                .withFullName(fullName)
                .withPassword(password)
                .withRole(studentRole)
                .withMecanographicNumber(numberMec)
                .withTaxPayerNumber(taxPayerNumber)
                .withBirthDate(birthDate)
                .createdOn(Calendar.getInstance())
                .build();
    }
}