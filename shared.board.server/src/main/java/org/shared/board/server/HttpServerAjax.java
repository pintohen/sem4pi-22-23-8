package org.shared.board.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import eapli.framework.domain.repositories.IntegrityViolationException;
import eapli.framework.general.domain.model.EmailAddress;
import org.apache.commons.httpclient.auth.InvalidCredentialsException;
import org.boards.controller.CreateBoardController;
import org.boards.controller.GetBoardsController;
import org.boards.controller.ShareBoardController;
import org.domain.model.Board;
import org.domain.model.BoardEntry;
import org.domain.model.BoardPermission;
import org.domain.model.postit.PostIt;
import org.domain.repositories.BoardRepository;
import org.persistence.PersistenceContext;
import org.postit.controller.*;
import org.shared.board.server.gson_adapter.HibernateProxyTypeAdapter;
import org.shared.board.server.gson_adapter.LocalDateAdapter;
import org.shared.board.server.request_bodys.*;
import org.shared.board.server.session.SessionManager;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.repositories.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The type Http server ajax.
 */
public class HttpServerAjax {
    /**
     * The Session manager.
     */
    SessionManager sessionManager;

    /**
     * The Json.
     */
    Gson json;

    /**
     * The constant MIN_ROWS_COLUMNS.
     */
    private static final String MIN_ROWS_COLS = "1";

    /**
     * The Synchronizer.
     */
    Synchronizer synchronizer;



    /**
     * Instantiates a new Http server ajax.
     */
    public HttpServerAjax() {
        this.sessionManager = SessionManager.getInstance();
        this.synchronizer = Synchronizer.getInstance();

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(LocalDate.class, new LocalDateAdapter());
        gsonBuilder.registerTypeAdapterFactory(HibernateProxyTypeAdapter.FACTORY);

        this.json = gsonBuilder.create();
    }

    /**
     * Gets authenticated user.
     * @param token the token
     * @return the authenticated user
     * @throws IllegalArgumentException the illegal argument exception
     * @throws NullPointerException     the null pointer exception
     */
    public String getAuthenticatedUser(String token)
            throws IllegalArgumentException, NullPointerException {
        String textHtml = String.valueOf(sessionManager.getUserByToken(token).identity());

        return textHtml;
    }

    /**
     * Create board.
     * @param requestBody the request body
     * @param token       the token
     * @return the string
     * @throws IntegrityViolationException the integrity violation exception
     * @throws NumberFormatException       the number format exception
     */
    public String createBoard(BoardBody requestBody, String token)
            throws IntegrityViolationException, NumberFormatException {
        CreateBoardController theController = new CreateBoardController();
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        List<String> boardEntrys = requestBody.boardEntrys();
        User authUser = sessionManager.getUserByToken(token);
        int boardNColumn = Integer.parseInt(requestBody.boardNColumn());
        int boardNRow = Integer.parseInt(requestBody.boardNRow());

        for(int i = 1; i <= boardNColumn; i++) {
            BoardEntry boardEntry = theController.createBoardEntry(
                    String.valueOf(i),
                    MIN_ROWS_COLS,
                    String.valueOf(i),
                    boardEntrys.get(i - 1),
                    requestBody.boardNRow(),
                    requestBody.boardNColumn(),
                    authUser
            );

            allBoardEntrys.add(boardEntry);
        }

        int j = boardNColumn;
        for(int i = 2; i <= boardNRow; i++){
            BoardEntry boardEntry = theController.createBoardEntry(
                    String.valueOf(i),
                    String.valueOf(i),
                    MIN_ROWS_COLS,
                    boardEntrys.get(j),
                    requestBody.boardNRow(),
                    requestBody.boardNColumn(),
                    authUser
            );

            j++;
            allBoardEntrys.add(boardEntry);
        }

        Board board = theController.createBoard(
                requestBody.boardTitle(),
                requestBody.boardNRow(),
                requestBody.boardNColumn(),
                allBoardEntrys,
                authUser);

        return json.toJson(board);
    }

    /**
     * Login user and add session.
     * @param body the body
     * @return the string
     * @throws InvalidCredentialsException the invalid credentials exception
     */
    public String login(LoginBody body)
            throws InvalidCredentialsException {
        UUID token = sessionManager.login(body.email(), body.password());

        return token.toString();
    }

    /**
     * Create post it to board.
     * @param requestBody the request body
     * @param token       the token
     * @return the string
     */
    public String createPostIt(PostItBody requestBody, String token){
        CreatePostItController theController = new CreatePostItController();
        User authUser = sessionManager.getUserByToken(token);

        String lockKey = synchronizer.generateLockKey(requestBody);
        Object lock = synchronizer.getOrCreateLockObject(lockKey);
        PostIt postIt;

        synchronized (lock){
            postIt = theController.createPostIt(
                    requestBody.content(),
                    requestBody.row(),
                    requestBody.column(),
                    requestBody.boardId(),
                    authUser);
        }

        return json.toJson(postIt);
    }

    /**
     * Get user access boards.
     * @param token the token
     * @return the string
     */
    public String getUserAccessBoards(String token){
        User authUser = sessionManager.getUserByToken(token);

        GetBoardsController theController = new GetBoardsController(
                PersistenceContext.repositories().boards());

        Iterable<Board> boards = theController.getBoardsByUser(authUser);

        return json.toJson(boards);
    }

    /**
     * Update content of post-it.
     * @param requestBody the request body
     * @param token       the token
     * @return the string
     */
    public String updatePostItContent(PostItBody requestBody, String token){
        UpdatePostItController theController = new UpdatePostItController();
        User authUser = sessionManager.getUserByToken(token);

        String lockKey = synchronizer.generateLockKey(requestBody);
        Object lock = synchronizer.getOrCreateLockObject(lockKey);
        PostIt postIt;

        synchronized (lock){
            postIt = theController.updatePostItContent(
                    requestBody.content(),
                    requestBody.row(),
                    requestBody.column(),
                    requestBody.boardId(),
                    authUser);
        }

        return json.toJson(postIt);
    }

    /**
     * Delete post-it.
     * @param requestBody the request body
     * @param token       the token
     * @return the string
     */
    public String deletePostIt(PostItBody requestBody, String token){
        DeletePostItController theController = new DeletePostItController();
        User authUser = sessionManager.getUserByToken(token);

        String lockKey = synchronizer.generateLockKey(requestBody);
        Object lock = synchronizer.getOrCreateLockObject(lockKey);
        PostIt postIt;

        synchronized (lock){
            postIt = theController.deletePostIt(
                    requestBody.row(),
                    requestBody.column(),
                    requestBody.boardId(),
                    authUser);
        }

        return json.toJson(postIt);
    }

    /**
     * Undo post-it.
     * @param requestBody the request body
     * @param token       the token
     * @return the string
     */
    public String undoPostIt(PostItBody requestBody, String token) {
        UndoPostItController ctrl = new UndoPostItController();
        User authenticated = sessionManager.getUserByToken(token);

        String lockKey = synchronizer.generateLockKey(requestBody);
        Object lock = synchronizer.getOrCreateLockObject(lockKey);

        PostIt postIt;

        synchronized (lock) {
            postIt = ctrl.undoPostIt(
                    requestBody.row(),
                    requestBody.column(),
                    requestBody.boardId(),
                    authenticated
            );
        }

        return json.toJson(postIt);
    }

    /**
     * Update post-it position.
     * @param requestBody the request body
     * @param token       the token
     * @return the string
     */
    public String updatePostItPosition(PostItPositionBody requestBody, String token){
        UpdatePostItController theController = new UpdatePostItController();
        User authUser = sessionManager.getUserByToken(token);
        String lockKey;
        PostIt postIt;

        //lock previous cell
        lockKey = synchronizer.generateLockKey(
                requestBody.previousPostItRow(),
                requestBody.previousPostItColumn(),
                requestBody.boardId());

        Object lockPrevious = synchronizer.getOrCreateLockObject(lockKey);

        //lock new cell
        lockKey = synchronizer.generateLockKey(
                requestBody.newPostItRow(),
                requestBody.newPostItColumn(),
                requestBody.boardId()
        );

        Object lockNew = synchronizer.getOrCreateLockObject(lockKey);

        synchronized (lockPrevious){
            synchronized (lockNew){
                postIt = theController.updatePostItPosition(
                        requestBody.previousPostItRow(),
                        requestBody.previousPostItColumn(),
                        requestBody.newPostItRow(),
                        requestBody.newPostItColumn(),
                        requestBody.boardId(),
                        authUser);
            }
        }

        return json.toJson(postIt);
    }

    /**
     * Get board by id.
     * @param boardId the board id
     * @param token   the token
     * @return the string
     */
    public String getBoardById(String boardId, String token){
        GetBoardsController theController = new GetBoardsController(
                PersistenceContext.repositories().boards());
        User authUser = sessionManager.getUserByToken(token);

        Board board = theController.getBoardById(Long.valueOf(boardId), authUser);

        return json.toJson(board);
    }

    public String shareABoard(ShareBoardBody body){


        Object lockObject = synchronizer
                .getOrCreateLockObject(body.getBoardId());

        long boardId = Long.parseLong(body.getBoardId());
        String userEmail = body.getUserEmail();
        String accessLevel = body.getPermission();
        String token = body.getToken();

        BoardRepository repo = PersistenceContext.repositories().boards();
        UserRepository userRepo = PersistenceContext.repositories().users();

        ShareBoardController ctrl = new ShareBoardController(
                userRepo,
                repo
        );

        User boardOwner = sessionManager.getUserByToken(token);

        User user = userRepo.findUserByEmail(EmailAddress.valueOf(userEmail)).get();

        BoardPermission perm;

        synchronized (lockObject) {
            perm = ctrl.shareBoard(boardId, user, boardOwner, accessLevel);
        }
        return json.toJson(perm);
    }
    /**
     * Get last post its by board.
     * @param boardId the board id
     * @param token   the token
     * @return the string
     */
    public String getLastPostItsByBoard(String boardId, String token){
        GetPostItsController theController = new GetPostItsController(
                PersistenceContext.repositories().postIt(),
                PersistenceContext.repositories().boards());
        User authUser = sessionManager.getUserByToken(token);

        Iterable<PostIt> postIts = theController.getLastPostItsByBoard(
                Long.valueOf(boardId), authUser);

        return json.toJson(postIts);
    }

    public String viewBoardHistory(Long boardId, String token) {
        ViewBoardHistoryController ctrl = new ViewBoardHistoryController(
                PersistenceContext.repositories().boards(),
                PersistenceContext.repositories().postIt());

        User authUser = sessionManager.getUserByToken(token);

        Iterable<PostIt> history = ctrl.viewBoardHistory(boardId, authUser);

        return json.toJson(history);
    }

    public String logout(String tokenValue) {
        User loggedOut = sessionManager.logout(tokenValue);

        return "Logged out successfully with email " + loggedOut.identity().toString();
    }
}
