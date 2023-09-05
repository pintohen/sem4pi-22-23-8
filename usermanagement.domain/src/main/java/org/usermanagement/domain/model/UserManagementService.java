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
