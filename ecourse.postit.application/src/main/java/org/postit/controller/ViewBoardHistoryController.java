package org.postit.controller;

import eapli.framework.validations.Preconditions;
import org.domain.model.Board;
import org.domain.model.postit.PostIt;
import org.domain.repositories.BoardRepository;
import org.usermanagement.domain.model.User;
import repositories.PostItRepository;

public class ViewBoardHistoryController {

    /**
     * The Board repository.
     */
    private final BoardRepository boardRepository;

    /**
     * The Post it repository.
     */
    private final PostItRepository postItRepository;

    /**
     * Instantiates a new View board history controller.
     * @param boardRepository the board repository
     * @param postItRepository the post it repository
     */
    public ViewBoardHistoryController(BoardRepository boardRepository,
                                      PostItRepository postItRepository) {
        this.boardRepository = boardRepository;
        this.postItRepository = postItRepository;
    }

    /**
     * View board history.
     * @param boardId the board id
     * @param authUser the auth user
     * @return Iterable<PostIt> - post-its history
     */
    public Iterable<PostIt> viewBoardHistory(Long boardId,
                                            User authUser) {

        Board board = boardRepository.ofIdentity(boardId).get();

        Preconditions.ensure(board.userHasAnyPermission(authUser),
                "User does not have permission to view this board");

        return postItRepository.getPostItsHistory(board);
    }
}
