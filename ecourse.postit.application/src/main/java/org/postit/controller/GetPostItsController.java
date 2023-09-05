package org.postit.controller;

import eapli.framework.validations.Preconditions;
import org.domain.model.Board;
import org.domain.model.postit.PostIt;
import org.domain.repositories.BoardRepository;
import org.usermanagement.domain.model.User;
import repositories.PostItRepository;

/**
 * The type Get Post-Its controller.
 */
public class GetPostItsController {
    /**
     * Create a post-it repository.
     */
    private final PostItRepository postItRepository;

    /**
     * Create a board repository.
     */
    private final BoardRepository boardRepository;


    /**
     * Instantiates a new Get post its controller.
     * @param repository       the repository
     * @param boardRepositoryp the board repositoryp
     */
    public GetPostItsController(PostItRepository repository,
                                BoardRepository boardRepositoryp) {
        postItRepository = repository;
        boardRepository = boardRepositoryp;
    }

    /**
     * Gets last post its by board.
     * @param boardId  the board id
     * @param authUser the auth user
     * @return the last post its by board
     */
    public Iterable<PostIt> getLastPostItsByBoard(final Long boardId,
                                                  final User authUser) {
        Board board = boardRepository.ofIdentity(boardId).get();
        Preconditions.ensure(
                board.userHasAnyPermission(authUser),
                "You don't have permission to access that board");

        return postItRepository.lastPostItsOnBoard(board);
    }
}
