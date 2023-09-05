package org.shared.board.server;

import org.authz.application.AuthorizationService;
import org.shared.board.common.Message;

import java.nio.charset.StandardCharsets;

/**
 * The type Shared board server controller.
 */
public class SharedBoardServerController {
    /**
     * SharedBoardServerService.
     */
    private SharedBoardServerService sbSvc;

    /**
     * AuthorizationService.
     */
    private AuthorizationService authz;

    /**
     * Instantiates a new Shared board server controller.
     *
     * @param sbSvcp the sb svcp
     * @param authzp the authzp
     */
    public SharedBoardServerController(final SharedBoardServerService sbSvcp,
                                       final AuthorizationService authzp) {
        this.sbSvc = sbSvcp;
        this.authz = authzp;
    }

    /**
     * Authenticate.
     *
     * @param data the data
     * @return the int
     */
    public int authenticate(final Message data) {
        String result = new String(data.data(), StandardCharsets.US_ASCII);

        return sbSvc.authenticateUser(result);
    }

    /**
     * Create board.
     *
     * @param data the data
     * @return the int
     */
    public int createBoard(final Message data) {
        String result = new String(data.data(), StandardCharsets.US_ASCII);

        return sbSvc.createBoard(result, authz.session().get().authenticatedUser());
    }

    /**
     * Create post-it.
     *
     * @param data the data
     * @return the int
     */
    public int createPostIt(final Message data) {
        String result = new String(data.data(), StandardCharsets.US_ASCII);

        return sbSvc.createPostIt(result, authz.session().get().authenticatedUser());
    }

    /**
     * Update post-it content.
     *
     * @param data the data
     * @return the int
     */
    public int updatePostItContent(final Message data) {
        String result = new String(data.data(), StandardCharsets.US_ASCII);

        return sbSvc.updatePostItContent(result, authz.session().get().authenticatedUser());
    }

    /**
     * Update post-it position.
     *
     * @param data the data
     * @return the int
     */
    public int updatePostItPosition(final Message data) {
        String result = new String(data.data(), StandardCharsets.US_ASCII);

        return sbSvc.updatePostItPosition(result, authz.session().get().authenticatedUser());
    }

    /**
     * Delete post-it.
     *
     * @param data the data
     * @return the int
     */
    public int deletePostIt(final Message data) {
        String result = new String(data.data(), StandardCharsets.US_ASCII);

        return sbSvc.deletePostIt(result, authz.session().get().authenticatedUser());
    }

    /**
     * Undo post-it last change.
     *
     * @param data the data
     * @return the int
     */
    public int undoPostIt(final Message data) {
        String result = new String(data.data(), StandardCharsets.US_ASCII);

        return sbSvc.undoPostIt(result, authz.session().get().authenticatedUser());
    }

    /**
     * View board history string.
     *
     * @param data the data
     * @return the string
     */
    public String viewBoardHistory(final Message data) {
        String result = new String(data.data(), StandardCharsets.US_ASCII);

        return sbSvc.viewBoardHistory(result, authz.session().get().authenticatedUser());
    }

    /**
     * Share board int.
     *
     * @param data the data
     * @return the int
     */
    public int shareBoard(final Message data){
        String result = new String(data.data(), StandardCharsets.US_ASCII);

        return sbSvc.shareABoard(result, authz.session().get().authenticatedUser());
    }
}
