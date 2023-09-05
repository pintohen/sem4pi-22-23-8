package org.boards.controller;

import eapli.framework.validations.Preconditions;
import org.domain.model.Board;
import org.domain.repositories.BoardRepository;
import org.usermanagement.domain.model.User;

import java.util.Optional;

/**
 * The type Get boards controller.
 */
public class GetBoardsController {
    /**
     * Create a board repository.
     */
    private final BoardRepository boardRepository;

    /**
     * Instantiates a new Get boards controller.
     * @param repository the repository
     */
    public GetBoardsController(BoardRepository repository) {
        boardRepository = repository;
    }

    /**
     * Gets boards by user.
     * @param authUser the auth user
     * @return the boards by user
     */
    public Iterable<Board> getBoardsByUser(final User authUser) {
        Preconditions.ensure(authUser != null,
                "You need to authenticate first");

        return boardRepository.getBoardsByUser(authUser);
    }


    /**
     * Gets board by id.
     * @param boardId  the board id
     * @param authUser the auth user
     * @return the board by id
     */
    public Board getBoardById(final Long boardId,
                              final User authUser) {
        Optional<Board> board = boardRepository.ofIdentity(boardId);
        Preconditions.ensure(
                board.get().userHasAnyPermission(authUser),
                "You don't have permission to access that board");


        return board.get();
    }
}
