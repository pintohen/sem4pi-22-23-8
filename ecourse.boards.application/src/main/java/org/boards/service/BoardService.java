package org.boards.service;

import eapli.framework.validations.Preconditions;
import org.domain.model.*;
import org.domain.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.usermanagement.domain.model.User;

import java.util.List;

/**
 * The type Board service.
 */
@Service
public class BoardService {
    /**
     * UserRepository.
     */
    private final BoardRepository boardRepository;


    /**
     * Instantiates a new Board service.
     *
     * @param boardRepo the board repo
     */
    @Autowired
    public BoardService(final BoardRepository boardRepo) {
        boardRepository = boardRepo;
    }

    /**
     * Create board.
     *
     * @param boardTitlep    the board titlep
     * @param boardNRowp     the board n rowp
     * @param boardNColp     the board n colp
     * @param allBoardEntrys the all board entrys
     * @param boardOwner     the board owner
     * @return Board board
     */
    public Board createBoard(final String boardTitlep,
                            final String boardNRowp,
                            final String boardNColp,
                            final List<BoardEntry> allBoardEntrys,
                            final User boardOwner) {
        BoardFactory boardFactory = new BoardFactory();
        BoardPermissionFactory boardPerFactory = new BoardPermissionFactory();

        Board newBoard = boardFactory.create(boardTitlep, boardNRowp,
                boardNColp, allBoardEntrys, boardOwner);

        BoardPermission boardPermission = boardPerFactory.create(
                boardOwner, AccessLevelType.WRITE);

        newBoard.addPermission(boardPermission);

        return boardRepository.save(newBoard);
    }

    /**
     * Add to board to add board permission.
     *
     * @param board       the board
     * @param user        the user
     * @param accessLevel the access level
     * @return the board permission
     */
    public BoardPermission addToBoard(final Board board,
                            final User user,
                            final AccessLevel accessLevel){

        BoardPermissionFactory boardPermFactory = new BoardPermissionFactory();

        Preconditions.ensure(!board.userHasPermission(user, accessLevel), "User already had this permission");

        AccessLevel differentLevel= null;

        if(accessLevel.equals(AccessLevelType.READ)){
            differentLevel = AccessLevelType.WRITE;
        }else{
            differentLevel = AccessLevelType.READ;
        }

        if(board.userHasPermission(user, differentLevel)){

            BoardPermission permission = board.userPermission(user);

            permission.changeAccess(accessLevel);

            boardRepository.save(board);

            return permission;
        }else {
            BoardPermission permission = boardPermFactory.create(user, accessLevel);

            board.addPermission(permission);

            boardRepository.save(board);

            return permission;
        }
    }

    /**
     * Confirm level access level.
     *
     * @param accessLevel the access level
     * @return the access level
     */
    public AccessLevel confirmLevel(final String accessLevel){
        AccessLevel accessLev = null;

        if(accessLevel.equalsIgnoreCase("read")){
            accessLev = AccessLevelType.READ;
        } else if(accessLevel.equalsIgnoreCase("write")){
            accessLev = AccessLevelType.WRITE;
        }

        Preconditions.nonNull(accessLev, "The access level written must be Write or Read");

        return accessLev;
    }

}
