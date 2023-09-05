//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.usermanagement.domain.model;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.validations.Preconditions;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Optional;

/**
 * The type Password.
 */
@Embeddable
public final class Password implements ValueObject, Serializable {
    /**
     * Password value.
     */
    @Column(
            name = "password"
    )
    private final String value;

    /**
     * Instantiates a new Password.
     */
    protected Password() {
        this.value = null;
    }

    /**
     * Instantiates a new Password.
     *
     * @param password the password
     */
    Password(final String password) {
        Preconditions.nonNull(password);
        this.value = password;
    }

    /**
     * Encoded and valid optional.
     *
     * @param rawPassword the raw password
     * @param policy      the policy
     * @param encoder     the encoder
     * @return the optional
     */
    public static Optional<Password> encodedAndValid(
            final String rawPassword,
            final PasswordPolicy policy,
            final PasswordEncoder encoder
    ) {
        Preconditions.nonEmpty(rawPassword,
                "password should neither be null nor empty");
        Preconditions.noneNull(new Object[]{policy, encoder});
        return policy.isSatisfiedBy(rawPassword)
                ? Optional.of(new Password(encoder.encode(rawPassword)))
                : Optional.empty();
    }

    /**
     * Password never return with value.
     * @return String
     */
    public String toString() {
        return "************";
    }

    /**
     * Value string.
     *
     * @return the string
     */
    public String value() {
        return this.value;
    }

    /**
     * Check if password is equals to another.
     * @param o password object
     * @return true or false
     */
    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Password)) {
            return false;
        } else {
            Password other = (Password) o;
            Object this$value = this.value;
            Object other$value = other.value;
            if (this$value == null) {
                if (other$value != null) {
                    return false;
                }
            } else if (!this$value.equals(other$value)) {
                return false;
            }

            return true;
        }
    }

    /**
     * Hash Code function.
     * @return int
     */
    public int hashCode() {
        boolean prime = true;
        int result = 1;
        Object $value = this.value;
        result = result * 59 + ($value == null ? 43 : $value.hashCode());
        return result;
    }
}
