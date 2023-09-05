package org.persistence;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.infrastructure.repositories.impl.jpa.JpaAutoTxRepository;
import org.domain.model.Board;
import org.domain.model.postit.PostIt;
import org.domain.model.postit.PostItColumn;
import org.domain.model.postit.PostItRow;
import org.enrollment.request.domain.EnrollmentRequest;
import org.usermanagement.domain.model.MecanographicNumber;
import org.usermanagement.domain.model.User;
import repositories.PostItRepository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.Map;
import java.util.Optional;

/**
 * The type Jpa auto tx post it repository.
 */
public class JpaAutoTxPostItRepository
        extends JpaAutoTxRepository<PostIt, Long, Long>
        implements PostItRepository {

    /**
     * Constructs a JpaAutoTxUserRepository.
     *
     * @param autoTx TransactionalContext
     */
    public JpaAutoTxPostItRepository(final TransactionalContext autoTx) {
        super(autoTx, "postItId");
    }

    /**
     * Constructs a JpaAutoTxUserRepository.
     *
     * @param puname     the persistence unit name
     * @param properties the properties for EntityManagerFactory
     */
    public JpaAutoTxPostItRepository(final String puname, final Map properties) {
        super(puname, properties, "postItId");
    }

    /**
     * Saves the given PostIt entity to the repository.
     * @param postIt postIt
     * @return PostIt
     */
    @Override
    public PostIt save(final PostIt postIt) {
        return this.repo.save(postIt);
    }

    /**
     * Retrieves an Optional of PostIt entity by the given postItId.
     * @param id postIt id
     * @return Optional<PostIt>
     */
    @Override
    public Optional<PostIt> ofIdentity(final Long id) {
        return this.repo.ofIdentity(id);
    }

    /**
     * Retrieves an PostIt entity by the given Row, Column and Board.
     * @param postItRowp postIt row
     * @param postItColumnp postIt column
     * @param board board
     * @return PostIt
     */
    @Override
    public PostIt positByPosition(final String postItRowp,
                                  final String postItColumnp,
                                  final Board board) {
        final TypedQuery<PostIt> query = createQuery(
                "SELECT p " +
                        "FROM PostIt p " +
                        "WHERE p.postItColumn = :postItColumn " +
                        "AND p.postItRow = :postItRow " +
                        "AND p.boardId = :boardId " +
                        "AND p.postItTimeStamp = ( " +
                        "SELECT MAX(p2.postItTimeStamp) " +
                        "FROM PostIt p2 " +
                        "WHERE p2.postItColumn = :postItColumn " +
                        "AND p2.postItRow = :postItRow " +
                        "AND p2.boardId = :boardId" +
                        ")",
                PostIt.class);


        query.setParameter("postItColumn", PostItColumn.of(postItColumnp, board.boardNCol()));
        query.setParameter("postItRow", PostItRow.of(postItRowp, board.boardNRow()));
        query.setParameter("boardId", board);

        try{
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     * Retrieves an Iterable<PostIt> entity by the given Board.
     * Only Max timestamp in every Row and Column combination.
     * @param board board
     * @return PostIt
     */
    @Override
    public Iterable<PostIt> lastPostItsOnBoard(final Board board) {
        TypedQuery<PostIt> query = createQuery(
                "SELECT p " +
                        "FROM PostIt p " +
                        "WHERE p.boardId = :board " +
                        "AND p.postItTimeStamp = (" +
                        "   SELECT MAX(p2.postItTimeStamp) " +
                        "   FROM PostIt p2 " +
                        "   WHERE p2.boardId = :board " +
                        "   AND p2.postItRow = p.postItRow " +
                        "   AND p2.postItColumn = p.postItColumn" +
                        ")",
                PostIt.class);

        query.setParameter("board", board);

        return query.getResultList();
    }

    /**
     * Retrieves an Iterable<PostIt> entity by the given Board.
     * @param board board
     * @return PostIt
     */
    @Override
    public Iterable<PostIt> getPostItsHistory(Board board) {
        TypedQuery<PostIt> query = createQuery(
                "SELECT p " +
                        "FROM PostIt p " +
                        "WHERE p.boardId = :board " +
                        "ORDER BY p.postItTimeStamp",
                PostIt.class);

        query.setParameter("board", board);

        return query.getResultList();
    }

}
