package org.shared.board.app;

import org.shared.board.common.Message;
import org.shared.board.common.MessageCodes;
import org.shared.board.common.MessageFormat;

import java.net.Socket;

/**
 * The type Shared board app controller.
 */
public class SharedBoardAppController {
    private Socket sock;
    private MessageFormat mf;

    /**
     * The constant VERSION.
     */
    public static final int VERSION = 1;

    /**
     * Instantiates a new Shared board app controller.
     * @param sock the sock
     */
    public SharedBoardAppController(Socket sock) {
        this.sock = sock;
        this.mf = new MessageFormat(sock);
    }

    /**
     * Send communication test.
     * @return the int
     */
    public int sendCommunicationTest(){
        mf.sendMessage(VERSION, MessageCodes.COMMTEST, "");

        Message result = mf.readMessage();

        return result.code();
    }

    /**
     * Send end of session.
     * @return the int
     */
    public int sendEndOfSession(){
        mf.sendMessage(VERSION, MessageCodes.DISCONN, "");

        Message result = mf.readMessage();

        return result.code();
    }

    /**
     * Authenticate.
     * @param data the data
     * @return the message
     */
    public Message authenticate(String data){
        mf.sendMessage(VERSION, MessageCodes.AUTH, data);

        return mf.readMessage();
    }

    /**
     * Create board.
     * @param data the data
     * @return the message
     */
    public Message createBoard(String data){
        mf.sendMessage(VERSION, MessageCodes.CB, data);

        return mf.readMessage();
    }

    /**
     * Create post-it.
     * @param data the data
     * @return the message
     */
    public Message createPostIt(String data){
        mf.sendMessage(VERSION, MessageCodes.CPI, data);

        return mf.readMessage();
    }

    /**
     * Update post-it content.
     * @param data the data
     * @return the message
     */
    public Message updatePostItContent(String data){
        mf.sendMessage(VERSION, MessageCodes.UPIC, data);

        return mf.readMessage();
    }

    /**
     * Update post-it position.
     * @param data the data
     * @return the message
     */
    public Message updatePostItPosition(String data){
        mf.sendMessage(VERSION, MessageCodes.UPIP, data);

        return mf.readMessage();
    }

    /**
     * Delete post-it.
     * @param data the data
     * @return the message
     */
    public Message deletePostIt(String data){
        mf.sendMessage(VERSION, MessageCodes.DPI, data);

        return mf.readMessage();
    }

    /**
     * Undo post-it.
     * @param data the data
     * @return the message
     */
    public Message undoPostIt(String data) {
        mf.sendMessage(VERSION, MessageCodes.UPI, data);

        return mf.readMessage();
    }

    /**
     * View the history of a board.
     * @param data the data
     * @return the message
     */

    public Message viewBoardHistory(String data) {
        mf.sendMessage(VERSION, MessageCodes.VBH, data);

        return mf.readMessage();
    }

    public Message shareABoard(String data){
        mf.sendMessage(VERSION, MessageCodes.SAB, data);

        return mf.readMessage();
    }
}
