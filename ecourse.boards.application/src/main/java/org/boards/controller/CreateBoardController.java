package org.boards.controller;

import eapli.framework.application.UseCaseController;
import eapli.framework.validations.Preconditions;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.boards.service.BoardService;
import org.domain.model.Board;
import org.domain.model.BoardEntry;
import org.domain.model.BoardEntryFactory;
import org.persistence.PersistenceContext;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;

import java.util.List;

/**
 * Controller class for adding a new user to the system.
 */
@UseCaseController
public class CreateBoardController {
    /**
     * Authorization service instance.
     */
    private final AuthorizationService authz;

    /**
     * Create a board service with repository injection.
     */
    private final BoardService boardSvc = new BoardService(
            PersistenceContext.repositories().boards());

    public CreateBoardController() {
        authz = AuthzRegistry.authorizationService();
    }

    /**
     * Create shared board.
     * @param boardTitlep Board Title
     * @param boardNRowp Board number of rows
     * @param boardNColp Board number of columns
     * @param allBoardEntrys Board entrys
     * @return Board
     */
    public Board createBoard(final String boardTitlep,
                             final String boardNRowp,
                             final String boardNColp,
                             final List<BoardEntry> allBoardEntrys) {
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.allRoles());

        return boardSvc.createBoard(boardTitlep, boardNRowp, boardNColp,
                allBoardEntrys, authz.session().get().authenticatedUser());
    }

    /**
     * Create shared board.
     * @param boardTitlep Board Title
     * @param boardNRowp Board number of rows
     * @param boardNColp Board number of columns
     * @param allBoardEntrys Board entrys
     * @param authUser authenticated user
     * @return Board
     */
    public Board createBoard(final String boardTitlep,
                             final String boardNRowp,
                             final String boardNColp,
                             final List<BoardEntry> allBoardEntrys,
                             final User authUser) {
        Preconditions.ensure(authUser != null,
                "You need to authenticate first");

        return boardSvc.createBoard(boardTitlep, boardNRowp, boardNColp,
                allBoardEntrys, authUser);
    }

    /**
     * Create board entry.
     * @param entryNumberp Entry number
     * @param boardRowp Row position
     * @param boardColp Column position
     * @param entryTitlep Entry Title
     * @param boardNRowp Board number of rows
     * @param boardNColps Board number of columns
     * @return BoardEntry
     */
    public BoardEntry createBoardEntry(final String entryNumberp,
                                       final String boardRowp,
                                       final String boardColp,
                                       final String entryTitlep,
                                       final String boardNRowp,
                                       final String boardNColps) {
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.allRoles());

        return new BoardEntryFactory().create(
                entryNumberp,
                boardRowp,
                boardColp,
                entryTitlep,
                boardNRowp,
                boardNColps
        );
    }

    /**
     * Create board entry.
     * @param entryNumberp Entry number
     * @param boardRowp Row position
     * @param boardColp Column position
     * @param entryTitlep Entry Title
     * @param boardNRowp Board number of rows
     * @param boardNColps Board number of columns
     * @return BoardEntry
     */
    public BoardEntry createBoardEntry(final String entryNumberp,
                                       final String boardRowp,
                                       final String boardColp,
                                       final String entryTitlep,
                                       final String boardNRowp,
                                       final String boardNColps,
                                       final User authUser ) {
        Preconditions.ensure(authUser != null,
                "You need to authenticate first");

        return new BoardEntryFactory().create(
                entryNumberp,
                boardRowp,
                boardColp,
                entryTitlep,
                boardNRowp,
                boardNColps
        );
    }
}
