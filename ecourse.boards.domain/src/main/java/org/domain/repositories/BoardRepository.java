package org.domain.repositories;

import eapli.framework.domain.repositories.DomainRepository;
import org.domain.model.Board;
import org.domain.model.BoardPermission;
import org.usermanagement.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends DomainRepository<Long, Board> {
    /**
     * Persist board.
     * @param board
     * @return Board
     */
    Board save(Board board);

    /**
     * Get Board with Identity (board id).
     * @param id Board id
     * @return Board
     */
    Optional<Board> ofIdentity(Long id);

    /**
     * Get boards that user have permission.
     * @param user user
     * @return List<Board>
     */
    Iterable<Board> getBoardsByUser(User user);
}
