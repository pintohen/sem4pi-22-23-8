package org.persistence;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.domain.model.Board;
import org.domain.model.BoardPermission;
import org.domain.model.Course;
import org.domain.model.postit.PostIt;
import org.domain.model.postit.PostItColumn;
import org.domain.model.postit.PostItRow;
import org.domain.repositories.BoardRepository;
import org.usermanagement.domain.model.User;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class JpaAutoTxBoardRepository
        extends JpaAutoTxRepository<Board, Long, Long>
        implements BoardRepository {

    /**
     * Constructs a JpaAutoTxUserRepository.
     * @param autoTx TransactionalContext
     */
    public JpaAutoTxBoardRepository(final TransactionalContext autoTx) {
        super(autoTx, "boardId");
    }

    /**
     * Constructs a JpaAutoTxUserRepository.
     * @param puname the persistence unit name
     * @param properties the properties for EntityManagerFactory
     */
    public JpaAutoTxBoardRepository(final String puname, final Map properties) {
        super(puname, properties, "boardId");
    }


    /**
     * Saves the given Board entity to the repository.
     * @param board
     * @return
     */
    @Override
    public Board save(final Board board) {
        return this.repo.save(board);
    }

    /**
     * Retrieves an Optional of Board entity by the given boardId.
     * @param id board id Optional<Board>
     * @return Optional<Board>
     */
    @Override
    public Optional<Board> ofIdentity(final Long id) {
        return this.repo.ofIdentity(id);
    }

    /**
     * Get boards that user have permission.
     * @param user user
     * @return List<Board>
     */
    @Override
    public Iterable<Board> getBoardsByUser(User user) {
        TypedQuery<Board> query = createQuery(
                "SELECT DISTINCT b "
                        + "FROM Board b "
                        + "JOIN b.boardPermissions bp "
                        + "WHERE bp.user = :user",
                Board.class);

        query.setParameter("user", user);

        return query.getResultList();
    }
}
