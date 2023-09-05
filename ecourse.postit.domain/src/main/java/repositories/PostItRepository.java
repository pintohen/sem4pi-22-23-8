package repositories;

import eapli.framework.domain.repositories.DomainRepository;
import org.domain.model.Board;
import org.domain.model.postit.PostIt;

import java.util.Optional;

public interface PostItRepository extends DomainRepository<Long, PostIt> {
    /**
     * Persist Post-It.
     * @param postIt
     * @return PostIt
     */
    PostIt save(PostIt postIt);

    /**
     * Get Post-It with Identity (post-it id).
     * @param id post-it id
     * @return PostIt
     */
    Optional<PostIt> ofIdentity(Long id);

    /**
     * Get Post-It with pos-it row and column position.
     * @param postItRowp post-it row position
     * @param postItColumnp post-it column position
     * @return PostIt
     */
    PostIt positByPosition(final String postItRowp,
                           final String postItColumnp,
                           final Board board);

    /**
     * Get last post-its on board.
     * @param board the board
     * @return PostIt
     */
    Iterable<PostIt> lastPostItsOnBoard(final Board board);

    Iterable<PostIt> getPostItsHistory(Board board);
}
