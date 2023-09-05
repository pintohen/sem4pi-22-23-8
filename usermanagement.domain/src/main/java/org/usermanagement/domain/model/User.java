package org.usermanagement.domain.model;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.representations.dto.DTOable;
import eapli.framework.representations.dto.GeneralDTO;
import eapli.framework.time.util.CurrentTimeCalendars;
import eapli.framework.validations.Preconditions;
import eapli.framework.visitor.Visitable;
import eapli.framework.visitor.Visitor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.user.management.CourseRoles;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;

@Entity
@Table(name = "T_COURSEUSER")
public class User
        implements AggregateRoot<EmailAddress>, DTOable<GeneralDTO>,
        Visitable<GeneralDTO>,
        Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Version of user.
     */
    @Version
    private Long version;
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
    @EmbeddedId
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
    @Temporal(TemporalType.DATE)
    private Calendar createdOn;

    /**
     * Date when user got deactivated in app.
     */
    @Temporal(TemporalType.DATE)
    private Calendar deactivatedOn;

    /**
     * Reset token to password.
     */
    private String resetToken;

    protected User() {

    }

     User(final ShortName shortNamep,
                final FullName fullNamep,
                final Password passwordp,
                final EmailAddress emailp,
                final Role rolep,
                final BirthDate birthDatep,
                final MecanographicNumber numberMecp,
                final TaxPayerNumber taxPayNumberp,
                final Acronym acronymp) {
        validateParameters(
                shortNamep,
                fullNamep,
                emailp,
                rolep,
                passwordp);
        validateMecNumber(numberMecp, rolep);
        validateAcronym(acronymp, rolep);

        this.shortName = shortNamep;
        this.fullName = fullNamep;
        this.password = passwordp;
        this.email = emailp;
        this.role = rolep;
        this.birthDate = birthDatep;
        this.numberMec = numberMecp;
        this.taxPayerNumber = taxPayNumberp;
        this.acronym = acronymp;
        this.userState = true;
        this.createdOn = CurrentTimeCalendars.now();
    }

    private void validateParameters(
            final ShortName shortNamep,
            final FullName fullNamep,
            final EmailAddress emailp,
            final Role rolep,
            final Password passwordp
    ) {
        Preconditions.nonNull(shortNamep, "Short name cannot be null");
        Preconditions.nonNull(fullNamep, "Full name cannot be null");
        Preconditions.nonNull(emailp, "Email cannot be null");
        Preconditions.nonNull(rolep, "Role cannot be null");
        Preconditions.nonNull(passwordp, "Password cannot be null");
    }

    User(final ShortName shortNamep,
                final FullName fullNamep,
                final Password passwordp,
                final EmailAddress emailp,
                final Role rolep,
                final BirthDate birthDatep,
                final MecanographicNumber numberMecp,
                final TaxPayerNumber taxPayNumberp,
                final Acronym acronymp,
                final Calendar createdOnp) {
        validateParameters(
                shortNamep,
                fullNamep,
                emailp,
                rolep,
                passwordp,
                createdOnp
        );
        validateMecNumber(numberMecp, rolep);
        validateAcronym(acronymp, rolep);

        this.shortName = shortNamep;
        this.fullName = fullNamep;
        this.password = passwordp;
        this.email = emailp;
        this.role = rolep;
        this.birthDate = birthDatep;
        this.numberMec = numberMecp;
        this.taxPayerNumber = taxPayNumberp;
        this.acronym = acronymp;
        this.userState = true;
        this.createdOn = createdOnp;
    }

    private void validateParameters(
            final ShortName shortNamep,
            final FullName fullNamep,
            final EmailAddress emailp,
            final Role rolep,
            final Password passwordp,
            final Calendar createdOnp
    ) {
        Preconditions.nonNull(shortNamep, "Short name cannot be null");
        Preconditions.nonNull(fullNamep, "Full name cannot be null");
        Preconditions.nonNull(emailp, "Email cannot be null");
        Preconditions.nonNull(rolep, "Role cannot be null");
        Preconditions.nonNull(passwordp, "Password cannot be null");
        Preconditions.nonNull(createdOnp, "CreatedOn cannot be null");
    }

    /**
     * Student always need to have MecanographicNumber.
     * Only Student can have mecanographic number
     * @param numberMecp user mecanographic number
     * @param rolep role of user
     */
    private void validateMecNumber(final MecanographicNumber numberMecp,
                                   final Role rolep) {
        if (!rolep.equals(CourseRoles.STUDENT) && numberMecp != null) {
            throw new IllegalStateException("Only Users with role "
                    + CourseRoles.STUDENT + " can have MecanographicNumber");
        }

        if (rolep.equals(CourseRoles.STUDENT) && numberMecp == null) {
            throw new IllegalStateException(CourseRoles.STUDENT
                    + " have a null MecanographicNumber");
        }
    }

    /**
     * Teacher always need to have Acronym.
     * Only Teacher can have acronym
     * @param acronymp user acronym
     * @param rolep role of user
     */
    private void validateAcronym(final Acronym acronymp, final Role rolep) {
        if (!rolep.equals(CourseRoles.TEACHER) && acronymp != null) {
            throw new IllegalStateException("Only Users with role "
                    + CourseRoles.TEACHER + " can have Acronym");
        }

        if (rolep.equals(CourseRoles.TEACHER) && acronymp == null) {
            throw new IllegalStateException(CourseRoles.TEACHER
                    + " have a null Acronym");
        }
    }


    /**
     * Disable the user.
     * @param now
     * @throws IllegalStateException user is already deactivated.
     */
    public void disable(final Calendar now) {
        if (!this.userState) {
            throw new IllegalStateException("Cannot deactivate "
                    + "an already deactivated user.");
        }
        this.deactivatedOn = CurrentTimeCalendars.now();
        this.userState = false;
    }

    /**
     * Enable the user.
     * @throws IllegalArgumentException user is already active.
     */
    public void enable() {
        if (this.userState) {
            throw new IllegalStateException("Cannot activate "
                    + "an already active user.");
        }
        this.deactivatedOn = null;
        this.userState = true;
    }

    /**
     * Check if password match.
     * @param rawPassword
     * @param encoder
     * @return true/false
     */
    public boolean passwordMatches(final String rawPassword,
                                   final PasswordEncoder encoder) {
        return encoder.matches(rawPassword, password.value());
    }

    /**
     * Get if user is Active.
     * @return userState
     */
    public boolean isActive() {
        return userState;
    }

    /**
     * Check if user has any of Roles.
     * @param requiredRoles array of roles
     * @return have role return true
     */
    public boolean hasAnyOf(final Role[] requiredRoles) {
        return Arrays.asList(requiredRoles).contains(this.role);
    }

    /**
     * Change user password.
     * @param newPasswordp new user password
     */
    public void changePassword(final Password newPasswordp) {
        Preconditions.nonNull(newPasswordp, "Password cannot be null.");
        password = newPasswordp;
    }

    /**
     * User indentity is email.
     * @return user identity
     */
    public EmailAddress identity() {
        return email;
    }

    /**
     * Get email address.
     * @return EmailAddress
     */
    public EmailAddress emailAddress() {
        return this.email;
    }

        /**
     * Get mecanographic number.
     * @return MecanographicNumber
     */
    public MecanographicNumber mecanographicNumber() {
        return this.numberMec;
    }

    /**
     * Get password.
     * @return Password
     */
    public Password password() {
        return this.password;
    }

    /**
     * Get createdOn.
     * @return Calendar
     */
    public Calendar createdOn() {
        return this.createdOn;
    }

    /**
     * Get Short Name.
     * @return ShortName
     */
    public ShortName shortName() {
        return this.shortName;
    }

    /**
     * Get deactivatedOn.
     * @return Calendar
     */
    public Calendar deactivatedOn() {
        return this.deactivatedOn;
    }

    /**
     * Get acronym.
     * @return Acronym
     */
    public Acronym acronym() {
        return this.acronym;
    }
    /**
     * Check if some User is the same object then other.
     * @param other
     * @return true/false
     */
    @Override
    public boolean sameAs(final Object other) {
        if (!(other instanceof User)) {
            return false;
        } else {
            User that = (User) other;

            if (this == that) {
                return true;
            } else if (this.shortName.equals(that.shortName)
                    && this.fullName.equals(that.fullName)
                    && this.password.equals(that.password)
                    && this.email.equals(that.email)
                    && this.role.equals(that.role)
                    && this.birthDate.equals(that.birthDate)) {
                return this.resetToken == null
                        ? that.resetToken == null
                        : this.resetToken.equals(that.resetToken);
            } else {
                return false;
            }
        }
    }

    /**
     * Parse User to DTO.
     * @return GeneralDTO
     */
    @Override
    public GeneralDTO toDTO() {
        final GeneralDTO ret = new GeneralDTO("user");

        ret.put("shortName", shortName.toString());
        ret.put("fullName", fullName.toString());
        ret.put("email", email.toString());
        ret.put("role", role.toString());
        ret.put("userState", isActive());

        return ret;
    }

    /**
     * Accept method.
     * @param visitor
     */
    @Override
    public void accept(final Visitor<GeneralDTO> visitor) {
        visitor.visit(toDTO());
    }

    /**
     * Get role of User.
     * @return String
     */
    public String role() {
        return role.toString();
    }
}
