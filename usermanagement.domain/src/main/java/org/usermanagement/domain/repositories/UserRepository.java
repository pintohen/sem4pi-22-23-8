package org.usermanagement.domain.repositories;

import org.usermanagement.domain.model.MecanographicNumber;
import org.usermanagement.domain.model.User;
import eapli.framework.domain.repositories.DomainRepository;
import eapli.framework.general.domain.model.EmailAddress;

import java.util.Optional;

public interface UserRepository extends DomainRepository<EmailAddress, User> {
    /**
     * Find active users.
     * @param active
     * @return Iterable of users
     */
    Iterable<User> findByActive(boolean active);

    /**
     * Persist user.
     * @param user
     * @return User
     */
    User save(User user);

    /**
     * Get User with Identity (Email Address).
     * @param id EmailAddress
     * @return User
     */
    Optional<User> ofIdentity(EmailAddress id);

    /**
     * Get User with Email.
     * @param email
     * @return User
     */
    default Optional<User> findUserByEmail(
            final EmailAddress email) {
        return ofIdentity(email);
    }

    /**
     * Fina max MecanographicNumber in current year.
     * @return MecanographicNumber
     */
    MecanographicNumber findMaxYearMecanographicNumber();
}
