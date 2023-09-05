package org.persistence;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.usermanagement.domain.model.MecanographicNumber;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.repositories.UserRepository;

import javax.persistence.TypedQuery;
import java.util.Map;
import java.util.Optional;

public class JpaAutoTxUserRepository
        extends JpaAutoTxRepository<User, EmailAddress, EmailAddress>
        implements UserRepository {

    /**
     * Constructs a JpaAutoTxUserRepository.
     * @param autoTx TransactionalContext
     */
    public JpaAutoTxUserRepository(final TransactionalContext autoTx) {
        super(autoTx, "email");
    }

    /**
     * Constructs a JpaAutoTxUserRepository.
     * @param puname the persistence unit name
     * @param properties the properties for EntityManagerFactory
     */
    public JpaAutoTxUserRepository(final String puname, final Map properties) {
        super(puname, properties, "email");
    }

    /**
     * Returns all User entities that match the given active status.
     * @param active
     * @return an Iterable of User entities
     */
    public Iterable<User> findByActive(final boolean active) {
        return this.match("e.active=:active", new Object[]{"active", active});
    }

    @Override
    public MecanographicNumber findMaxYearMecanographicNumber() {
        final TypedQuery<MecanographicNumber> query = createQuery(
                "SELECT MAX(ce.numberMec) FROM User ce WHERE ce.numberMec > (YEAR(CURRENT_DATE()) * 100000)",
                MecanographicNumber.class);

        return query.getSingleResult();
    }


    /**
     * Saves the given User entity to the repository.
     * @param user
     * @return
     */
    @Override
    public User save(final User user) {
        return this.repo.save(user);
    }

    /**
     * Retrieves an Optional of User entity by the given EmailAddress identity.
     * @param id
     * @return
     */
    @Override
    public Optional<User> ofIdentity(final EmailAddress id) {
        return this.repo.ofIdentity(id);
    }

    /**
     * Deletes the User entity with the given EmailAddress.
     * @param entityId the EmailAddress identity of the User to delete
     */
    @Override
    public void deleteOfIdentity(final EmailAddress entityId) {

    }
}
