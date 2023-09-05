package org.boards.controller;

import eapli.framework.application.UseCaseController;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;
import org.boards.service.BoardService;
import org.domain.model.AccessLevel;
import org.domain.model.Board;
import org.domain.model.BoardPermission;
import org.domain.repositories.BoardRepository;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.repositories.UserRepository;

/**
 * The type Share board controller.
 */
@UseCaseController
public class ShareBoardController {

    private final UserRepository userRepo;
    private final BoardRepository boardRepo;

    private final BoardService service;

    /**
     * Instantiates a new Share board controller.
     *
     * @param userRepo  the user repo
     * @param boardRepo the board repo
     */
    public ShareBoardController(UserRepository userRepo,
                                BoardRepository boardRepo){
        this.userRepo = userRepo;
        this.boardRepo = boardRepo;
        service = new BoardService(boardRepo);
    }

    /**
     * Share board and give board permission.
     *
     * @param boardId     the board id
     * @param user        the user
     * @param boardOwner  the board owner
     * @param accessLevel the access level
     * @return the board permission
     */
    public BoardPermission shareBoard(final long boardId,
                                      final User user,
                                      final User boardOwner,
                                      final String accessLevel){
        Board board = boardRepo.ofIdentity(boardId).orElse(null);

        Preconditions.nonNull(board, "The board is not on the system");

        Preconditions.ensure(board.boardOwner().emailAddress().toString().equals(boardOwner.emailAddress().toString()),
                "The user is not the owner of this board");

        AccessLevel access = service.confirmLevel(accessLevel);

        return service.addToBoard(board, user, access);
    }
}