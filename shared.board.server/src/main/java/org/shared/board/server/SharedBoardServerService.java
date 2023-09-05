package org.shared.board.server;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;
import org.authz.application.AuthenticationService;
import org.authz.application.AuthzRegistry;
import org.boards.controller.CreateBoardController;
import org.boards.controller.GetBoardsController;
import org.boards.controller.ShareBoardController;
import org.domain.model.Board;
import org.domain.model.BoardEntry;
import org.domain.model.postit.PostIt;
import org.persistence.PersistenceContext;
import org.postit.controller.*;
import org.shared.board.common.MessageCodes;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserSession;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * The type Shared board server service.
 */
public class SharedBoardServerService {
    /**
     * Get AuthenticationService.
     */
    private AuthenticationService authService = AuthzRegistry
            .authenticationService();

    /**
     * The Synchronizer.
     */
    Synchronizer synchronizer;

    /**
     * The constant MIN_ROWS_COLUMNS.
     */
    private static final String MIN_ROWS_COLS = "1";

    /**
     * Instantiates a new SharedBoardServerService.
     */
    public SharedBoardServerService() {
        this.synchronizer = Synchronizer.getInstance();
    }

    /**
     * Authenticate user.
     *
     * @param userData the user data
     * @return the int
     * @throws IllegalArgumentException the illegal argument exception
     */
    public int authenticateUser(final String userData)
            throws IllegalArgumentException {
        String email = userData.substring(0, userData.indexOf("\0"));
        String password = userData.substring(
                userData.indexOf("\0") + 1, userData.length() - 1);

        Optional<UserSession> session = authService
                .authenticate(email, password,
                        CourseRoles.allRoles());

        if (session.isPresent()) {
            return MessageCodes.ACK;
        }

        return MessageCodes.ERR;
    }

    /**
     * Create board.
     *
     * @param boardData the board data
     * @param authUser  the auth user
     * @return the int
     */
    public int createBoard(final String boardData,
                           final User authUser) {
        CreateBoardController boardController = new CreateBoardController();
        final String boardTitle = getStringByIndex(0, boardData);
        final String boardNCol = getStringByIndex(1, boardData);
        final String boardNRow = getStringByIndex(2, boardData);
        List<BoardEntry> allBoardEntrys = new ArrayList<>();

        int j = 3;

        for(int i = 1; i <= Integer.parseInt(boardNCol); i++){
            final String entryTitle = getStringByIndex(j, boardData);

            BoardEntry boardEntry = boardController.createBoardEntry(
                    String.valueOf(i),
                    MIN_ROWS_COLS,
                    String.valueOf(i),
                    entryTitle,
                    boardNRow,
                    boardNCol,
                    authUser
            );

            allBoardEntrys.add(boardEntry);
            j++;
        }

        for(int i = 2; i <= Integer.parseInt(boardNRow); i++){
            final String entryTitle = getStringByIndex(j, boardData);

            BoardEntry boardEntry = boardController.createBoardEntry(
                    String.valueOf(i),
                    String.valueOf(i),
                    MIN_ROWS_COLS,
                    entryTitle,
                    boardNRow,
                    boardNCol,
                    authUser
            );

            allBoardEntrys.add(boardEntry);
            j++;
        }

        boardController.createBoard(
                boardTitle,
                boardNRow,
                boardNCol,
                allBoardEntrys,
                authUser);

        return MessageCodes.ACK;
    }

    /**
     * Create post-it.
     *
     * @param postItData the post-it data
     * @param authUser   the auth user
     * @return the int
     */
    public int createPostIt(final String postItData,
                            final User authUser) {
        CreatePostItController createPostItController = new CreatePostItController();
        final String content = getStringByIndex(0, postItData);
        final String rowPos = getStringByIndex(1, postItData);
        final String colPos = getStringByIndex(2, postItData);
        final String boardId = getStringByIndex(3, postItData);

        String lockKey = synchronizer.generateLockKey(rowPos, colPos, boardId);
        Object lock = synchronizer.getOrCreateLockObject(lockKey);

        synchronized (lock){
            try{
                createPostItController.createPostIt(
                        content,
                        rowPos,
                        colPos,
                        boardId,
                        authUser);
            } catch (NoSuchElementException e){
                throw new IllegalArgumentException(
                        "There is no board with that id!");
            }
        }

        return MessageCodes.ACK;
    }

    /**
     * Update post-it content.
     *
     * @param postItData the post-it data
     * @param authUser   the auth user
     * @return the int
     */
    public int updatePostItContent(final String postItData,
                            final User authUser) {
        UpdatePostItController updatePostItController = new UpdatePostItController();
        final String content = getStringByIndex(0, postItData);
        final String rowPos = getStringByIndex(1, postItData);
        final String colPos = getStringByIndex(2, postItData);
        final String boardId = getStringByIndex(3, postItData);

        String lockKey = synchronizer.generateLockKey(rowPos, colPos, boardId);
        Object lock = synchronizer.getOrCreateLockObject(lockKey);

        synchronized (lock){
            try{
                updatePostItController.updatePostItContent(
                        content,
                        rowPos,
                        colPos,
                        boardId,
                        authUser);
            } catch (NoSuchElementException e){
                throw new IllegalArgumentException(
                        "There is no board with that id!");
            }
        }

        return MessageCodes.ACK;
    }

    /**
     * Update post-it position.
     *
     * @param postItData the post-it data
     * @param authUser   the auth user
     * @return the int
     */
    public int updatePostItPosition(final String postItData,
                                    final User authUser) {
        UpdatePostItController updatePostItController = new UpdatePostItController();
        final String previousRowPos = getStringByIndex(0, postItData);
        final String previousColPos = getStringByIndex(1, postItData);
        final String newRowPos = getStringByIndex(2, postItData);
        final String newColPos = getStringByIndex(3, postItData);
        final String boardId = getStringByIndex(4, postItData);

        String lockKeyPrevious = synchronizer.generateLockKey(
                previousRowPos, previousColPos, boardId);
        Object previousLock = synchronizer.getOrCreateLockObject(lockKeyPrevious);

        String lockKeyNew = synchronizer.generateLockKey(
                newRowPos, newColPos, boardId);
        Object newLock = synchronizer.getOrCreateLockObject(lockKeyNew);

        synchronized (previousLock){
            synchronized (newLock){
                try{
                    updatePostItController.updatePostItPosition(
                            previousRowPos,
                            previousColPos,
                            newRowPos,
                            newColPos,
                            boardId,
                            authUser);
                } catch (NoSuchElementException e){
                    throw new IllegalArgumentException(
                            "There is no board with that id!");
                }
            }
        }

        return MessageCodes.ACK;
    }

    /**
     * Delete post-it.
     *
     * @param postItData the post-it data
     * @param authUser   the auth user
     * @return the int
     */
    public int deletePostIt(final String postItData,
                                   final User authUser) {
        DeletePostItController deletePostItController = new DeletePostItController();
        final String rowPos = getStringByIndex(0, postItData);
        final String colPos = getStringByIndex(1, postItData);
        final String boardId = getStringByIndex(2, postItData);

        String lockKey = synchronizer.generateLockKey(rowPos, colPos, boardId);
        Object lock = synchronizer.getOrCreateLockObject(lockKey);

        synchronized (lock){
            try{
                deletePostItController.deletePostIt(
                        rowPos,
                        colPos,
                        boardId,
                        authUser);
            } catch (NoSuchElementException e){
                throw new IllegalArgumentException(
                        "There is no board with that id!");
            }
        }

        return MessageCodes.ACK;
    }

    /**
     * Undo post-it.
     *
     * @param postItData the post-it data
     * @param user       the auth user
     * @return the int
     */
    public int undoPostIt(String postItData, User user) {
        UndoPostItController ctrl = new UndoPostItController();

        final String boardId = getStringByIndex(0, postItData);
        final String rowPos = getStringByIndex(1, postItData);
        final String colPos = getStringByIndex(2, postItData);

        String lockKey = synchronizer.generateLockKey(rowPos, colPos, boardId);
        Object lock = synchronizer.getOrCreateLockObject(lockKey);

        synchronized (lock) {
            try{
                ctrl.undoPostIt(
                        rowPos,
                        colPos,
                        boardId,
                        user
                );
            } catch (NoSuchElementException e){
                throw new IllegalArgumentException(
                        "There is no board with that id!");
            }
        }

        return MessageCodes.ACK;
    }

    /**
     * View board history string.
     *
     * @param boardId  the board id
     * @param authUser the auth user
     * @return the string
     */
    public String viewBoardHistory(final String boardId,
                                   final User authUser) {

        Board board;
        Iterable<PostIt> postItsList;
        String result = "";

        ViewBoardHistoryController ctrl = new ViewBoardHistoryController(
                PersistenceContext.repositories().boards(),
                PersistenceContext.repositories().postIt()
        );

        GetBoardsController getBoardsController = new GetBoardsController(
                PersistenceContext.repositories().boards()
        );

        try {
            board = getBoardsController.getBoardById(Long.valueOf(boardId), authUser);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(
                    "There is no board with that id!");
        }

        try {
            postItsList = ctrl.viewBoardHistory(Long.valueOf(boardId), authUser);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(
                    "There is no board with that id!");
        }

        List<PostIt> postIts = new ArrayList<>();
        postItsList.forEach(postIts::add);

        result += "-------- BOARD CREATED --------\n";
        result += "Board ID: " + boardId + "\n";
        result += "Board Name: " + board.boardTitle().value() + "\n";
        result += "Columns: " + board.boardNCol().value() + "\n";
        result += "Rows: " + board.boardNRow().value() + "\n";
        result += "By: " + board.boardOwner().emailAddress().toString() + "\n";
        result += "Created at: " + board.formatCreatedOn() + "\n";

        for (int i = 0; i < postIts.size(); i++) {
            PostIt postIt = postIts.get(i);

            if (postIt.state().toString().equals("CREATED")) {
                result += "\n-------- POST-IT CREATED --------\n";
                result += "Content: " + postIt.content().value() + "\n";
                result += "Column: " + postIt.columnPos().value() + "\n";
                result += "Row: " + postIt.rowPos().value() + "\n";
                result += "By: " + postIt.owner().emailAddress().toString() + "\n";
                result += "Created at: " + postIt.formatTimestamp() + "\n";
            }

            if (postIt.state().toString().equals("UPDATED")) {
                result += "\n-------- POST-IT UPDATED --------\n";
                result += "Content: " + postIt.content().value() + "\n";
                result += "Column: " + postIt.columnPos().value() + "\n";
                result += "Row: " + postIt.rowPos().value() + "\n";
                result += "By: " + postIt.owner().emailAddress().toString() + "\n";
                result += "Updated at: " + postIt.formatTimestamp() + "\n";
            }

            if (postIt.state().toString().equals("DELETED")) {
                result += "\n-------- POST-IT DELETED --------\n";
                result += "Column: " + postIt.columnPos().value() + "\n";
                result += "Row: " + postIt.rowPos().value() + "\n";
                result += "By: " + postIt.owner().emailAddress().toString() + "\n";
                result += "Deleted at: " + postIt.formatTimestamp() + "\n";
            }

            if (postIt.state().toString().equals("MOVED")) {

                PostIt moved = postIts.get(i + 1);

                result += "\n-------- POST-IT MOVED --------\n";
                result += "Old Column: " + postIt.columnPos().value() + "\n";
                result += "Old Row: " + postIt.rowPos().value() + "\n";
                result += "New Column: " + moved.columnPos().value() + "\n";
                result += "New Row: " + moved.rowPos().value() + "\n";
                result += "By: " + postIt.owner().emailAddress().toString() + "\n";
                result += "Moved at: " + postIt.formatTimestamp() + "\n";
                i++;
            }
        }

        return result;
    }

    /**
     * Share a board int.
     *
     * @param data the data
     * @param user the user
     * @return the int
     */
    public int shareABoard(String data,
                              User user){

        ShareBoardController ctrl = new ShareBoardController(
                PersistenceContext.repositories().users(),
                PersistenceContext.repositories().boards());

        final String boardId = getStringByIndex(0, data);
        final String email = getStringByIndex(1, data);
        final String accessLevel = getStringByIndex(2, data);

        final User userAdded;

        try {
            userAdded = PersistenceContext.repositories().users().findUserByEmail(EmailAddress.valueOf(email)).get();
        }catch (NoSuchElementException e){
            throw new IllegalArgumentException("The user is not registered in the system!");
        }

        Object lockObject = synchronizer
                .getOrCreateLockObject(boardId);

        synchronized (lockObject){
            try{
                ctrl.shareBoard(Long.parseLong(boardId),
                        userAdded,
                        user,
                        accessLevel);
            } catch (NoSuchElementException e){
                throw new IllegalArgumentException(
                        "There is no board with that id!");
            }
        }

        return MessageCodes.ACK;
    }

    /**
     * All data is separated by \0.
     * So we want to split data to specific position.
     * @param index
     * @param input
     * @return
     */
    private static String getStringByIndex(int index, String input) {
        String[] substrings = input.split("\0");

        if (index < 0 || index >= substrings.length) {
            return "";
        }

        return substrings[index];
    }

}
