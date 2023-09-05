package org.usermanagement.domain.model;

import eapli.framework.domain.model.DomainFactory;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.validations.Preconditions;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Calendar;

public class UserBuilder implements DomainFactory<User> {
    /**
     * Short name of user.
     */
    private ShortName shortName;

    /**
     * Full name of user.
     */
    private FullName fullName;

    /**
     * Password of user.
     */
    private Password password;

    /**
     * Email of user.
     */
    private EmailAddress email;

    /**
     * Role of user.
     */
    private Role role;

    /**
     * Number Mecanographic only for students.
     */
    private MecanographicNumber numberMec;

    /**
     * Birthdate of user.
     */
    private BirthDate birthDate;

    /**
     * TaxPayerNumber of user.
     */
    private TaxPayerNumber taxPayerNumber;

    /**
     * Acronym of user.
     */
    private Acronym acronym;

    /**
     * Active or Desactive user.
     */
    private boolean userState;

    /**
     * Date when user got created in app.
     */
    private Calendar createdOn;

    /**
     * PasswordPolicy with rules.
     */
    private final PasswordPolicy policy;

    /**
     * PasswordEncoder.
     */
    private final PasswordEncoder encoder;

    /**
     * UserBuilder constructor.
     * @param policyp
     * @param encoderp
     */
    public UserBuilder(final PasswordPolicy policyp,
                       final PasswordEncoder encoderp) {
        this.policy = policyp;
        this.encoder = encoderp;
    }

    /**
     * Build basic user.
     * @param shortNamep
     * @param passwordp
     * @param fullNamep
     * @param emailp
     * @param rolep
     * @return UserBuilder
     */
    public UserBuilder with(final String shortNamep,
                            final String passwordp,
                            final String fullNamep,
                            final String emailp,
                            final Role rolep) {
        this.withShortName(shortNamep);
        this.withPassword(passwordp);
        this.withFullName(fullNamep);
        this.withEmail(emailp);
        this.withRole(rolep);
        return this;
    }

        /**
     * Build basic user with value objects.
     * @param shortNamep
     * @param passwordp
     * @param fullNamep
     * @param emailp
     * @param rolep
     * @return UserBuilder
     */
    public UserBuilder with(final ShortName shortNamep,
                            final Password passwordp,
                            final FullName fullNamep,
                            final EmailAddress emailp,
                            final Role rolep) {
        this.withShortName(shortNamep);
        this.withPassword(passwordp);
        this.withFullName(fullNamep);
        this.withEmail(emailp);
        this.withRole(rolep);
        return this;
    }
    /**
     * Build basic a complex user.
     * @param shortNamep
     * @param passwordp
     * @param fullNamep
     * @param emailp
     * @param birthDatep
     * @param rolep
     * @param taxPayerNumberp
     * @return UserBuilder
     */
    public UserBuilder with(final String shortNamep,
                            final String passwordp,
                            final String fullNamep,
                            final String emailp,
                            final String birthDatep,
                            final Role rolep,
                            final String taxPayerNumberp) {
        this.withShortName(shortNamep);
        this.withPassword(passwordp);
        this.withFullName(fullNamep);
        this.withEmail(emailp);
        this.withBirthDate(birthDatep);
        this.withRole(rolep);
        this.withTaxPayerNumber(taxPayerNumberp);
        return this;
    }

    /**
     * Add to User that is being build with ShortName.
     * @param shortNamep
     * @return UserBuilder
     */
    public UserBuilder withShortName(final String shortNamep) {
        this.shortName = ShortName.of(shortNamep);
        return this;
    }

    /**
     * Add to User that is being build with ShortName.
     * @param shortNamep
     * @return UserBuilder
     */
    public UserBuilder withShortName(final ShortName shortNamep) {
        this.shortName = shortNamep;
        return this;
    }

    /**
     * Add to User that is being build with Password.
     * @param rawPassword
     * @return UserBuilder
     */
    public UserBuilder withPassword(final String rawPassword) {
        this.password = (Password) Password.encodedAndValid(rawPassword,
                this.policy, this.encoder)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Password not valid"
                        + "\n* At least 6 characters long"
                        + "\n* At least one digit"
                        + "\n* At least one capital letter"));

        return this;
    }

    /**
     * Add to User that is being build with Password.
     * @param passwordp
     * @return UserBuilder
     */
    public UserBuilder withPassword(final Password passwordp) {
        Preconditions.nonNull(passwordp);
        this.password = passwordp;
        return this;
    }

    /**
     * Add to User that is being build with FullName.
     * @param fullNamep
     * @return UserBuilder
     */
    public UserBuilder withFullName(final String fullNamep) {
        this.fullName = FullName.of(fullNamep);
        return this;
    }

    /**
     * Add to User that is being build with FullName.
     * @param fullNamep
     * @return UserBuilder
     */
    public UserBuilder withFullName(final FullName fullNamep) {
        this.fullName = fullNamep;
        return this;
    }

    /**
     * Add to User that is being build with EmailAddress.
     * @param emailp
     * @return UserBuilder
     */
    public UserBuilder withEmail(final String emailp) {
        this.email = EmailAddress.valueOf(emailp);
        return this;
    }

    /**
     * Add to User that is being build with EmailAddress.
     * @param emailp
     * @return UserBuilder
     */
    public UserBuilder withEmail(final EmailAddress emailp) {
        this.email = emailp;
        return this;
    }

    /**
     * Add to User that is being build with Role.
     * @param rolep
     * @return UserBuilder
     */
    public UserBuilder withRole(final String rolep) {
        this.role = Role.valueOf(rolep);
        return this;
    }

    /**
     * Add to User that is being build with Role.
     * @param rolep
     * @return UserBuilder
     */
    public UserBuilder withRole(final Role rolep) {
        this.role = rolep;
        return this;
    }

    /**
     * Add to User that is being build with Mecanographic Number.
     * @param numberMecp
     * @return UserBuilder
     */
    public UserBuilder withMecanographicNumber(final String numberMecp) {
        if (numberMecp != null) {
            this.numberMec = MecanographicNumber.of(numberMecp);
        }

        return this;
    }

    /**
     * Add to User that is being build with Mecanographic Number.
     * @param numberMecp
     * @return UserBuilder
     */
    public UserBuilder withMecanographicNumber(
            final MecanographicNumber numberMecp) {
        this.numberMec = numberMecp;
        return this;
    }

    /**
     * Add to User that is being build with CreatedOn.
     * @param createdOnp
     * @return UserBuilder
     */
    public UserBuilder createdOn(final Calendar createdOnp) {
        this.createdOn = createdOnp;
        return this;
    }

    /**
     * Add to User that is being build with birthdate.
     * @param birthDatep
     * @return UserBuilder
     */
    public UserBuilder withBirthDate(final String birthDatep) {
        if (birthDatep != null) {
            this.birthDate = BirthDate.of(birthDatep);
        }

        return this;
    }

    /**
     * Add to User that is being build with birthdate.
     * @param birthDatep
     * @return UserBuilder
     */
    public UserBuilder withBirthDate(final BirthDate birthDatep) {
        this.birthDate = birthDatep;
        return this;
    }

    /**
     * Add to User that is being build with TaxPayerNumber.
     * @param taxPayerNumberp
     * @return UserBuilder
     */
    public UserBuilder withTaxPayerNumber(final String taxPayerNumberp) {
        if (taxPayerNumberp != null) {
            this.taxPayerNumber = TaxPayerNumber.of(taxPayerNumberp);
        }

        return this;
    }

    /**
     * Add to User that is being build with TaxPayerNumber.
     * @param taxPayerNumberp
     * @return UserBuilder
     */
    public UserBuilder withTaxPayerNumber(
            final TaxPayerNumber taxPayerNumberp) {
        this.taxPayerNumber = taxPayerNumberp;
        return this;
    }

    /**
     * Add to User tha8t is being build with Acronym.
     * @param acronymp
     * @return UserBuilder
     */
    public UserBuilder withAcronym(final String acronymp) {
        if (acronymp != null) {
            this.acronym = Acronym.of(acronymp);
        }

        return this;
    }

    /**
     * Add to User tha8t is being build with Acronym.
     * @param acronymp
     * @return UserBuilder
     */
    public UserBuilder withAcronym(final Acronym acronymp) {
        this.acronym = acronymp;
        return this;
    }

    /**
     * Build User.
     * @return User
     */
    @Override
    public User build() {
        User user;

        if (createdOn != null) {
            user = new User(shortName, fullName, password, email,
                    role, birthDate, numberMec, taxPayerNumber,
                    acronym, createdOn);
        } else {
            user = new User(shortName, fullName, password, email,
                    role, birthDate, numberMec, taxPayerNumber,
                    acronym);
        }

        return user;
    }
}
