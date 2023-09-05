package org.shared.board.server;

import eapli.framework.domain.repositories.IntegrityViolationException;
import exceptions.NoPreviousElementException;
import org.authz.application.AuthorizationService;
import org.shared.board.common.Message;
import org.shared.board.common.MessageCodes;
import org.shared.board.common.MessageFormat;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.NoSuchElementException;

/**
 * The type Tcp srv thread.
 */
public class TcpSrvThread implements Runnable {
    /**
     * The Socket.
     */
    private Socket sock;

    /**
     * The SharedBoardServerController.
     */
    private SharedBoardServerController theController;

    /**
     * The SharedBoardServerController.
     */
    private AuthorizationService authz;

    /**
     * The constant VERSION.
     */
    public static final int VERSION = 1;

    /**
     * Instantiates a new Tcp srv thread.
     *
     * @param cliSer the cli s
     */
    public TcpSrvThread(final Socket cliSer, final AuthorizationService authzp) {
        sock = cliSer;
        theController = new SharedBoardServerController(
                new SharedBoardServerService(), authzp);
        authz = authzp;
    }

    /**
     * Thread Runnable.
     */
    public void run() {
        Message message;
        InetAddress clientIP;

        clientIP = sock.getInetAddress();

        System.out.println("New client connection from "
                + clientIP.getHostAddress()
                + ", port number " + sock.getPort());


        try {
            MessageFormat mf = new MessageFormat(sock);

            do {
                message = mf.readMessage();


                if (message.code() == MessageCodes.COMMTEST) {
                    mf.sendMessage(VERSION, MessageCodes.ACK, "");
                }

                if (message.code() == MessageCodes.AUTH) {
                    try {
                        int result = theController.authenticate(message);

                        mf.sendMessage(VERSION, result, "");
                    } catch (IllegalArgumentException e) {
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                e.getMessage());
                    }
                }

                if (message.code() == MessageCodes.CB){
                    try {
                        int result = theController.createBoard(message);

                        mf.sendMessage(VERSION, result, "");
                    } catch (IllegalArgumentException e) {
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                e.getMessage());
                    } catch (IntegrityViolationException e){
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                "A board with that name already exists");
                    } catch (NoSuchElementException e){
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                "User is not authenticated!");
                    }
                }

                if (message.code() == MessageCodes.CPI) {
                    try {
                        int result = theController.createPostIt(message);

                        mf.sendMessage(VERSION, result, "");
                    } catch (IllegalArgumentException e) {
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                e.getMessage());
                    } catch (NoSuchElementException e){
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                "User is not authenticated!");
                    }
                }

                if(message.code() == MessageCodes.UPIC){
                    try{
                        int result = theController.updatePostItContent(message);

                        mf.sendMessage(VERSION, result, "");
                    } catch (IllegalArgumentException e) {
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                e.getMessage());
                    } catch (NoSuchElementException e){
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                "User is not authenticated!");
                    }
                }

                if(message.code() == MessageCodes.UPIP){
                    try{
                        int result = theController.updatePostItPosition(message);

                        mf.sendMessage(VERSION, result, "");
                    } catch (IllegalArgumentException e) {
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                e.getMessage());
                    } catch (NoSuchElementException e){
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                "User is not authenticated!");
                    }
                }

                if(message.code() == MessageCodes.DPI){
                    try{
                        int result = theController.deletePostIt(message);

                        mf.sendMessage(VERSION, result, "");
                    } catch (IllegalArgumentException e) {
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                e.getMessage());
                    } catch (NoSuchElementException e){
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                "User is not authenticated!");
                    }
                }

                if(message.code() == MessageCodes.UPI){
                    try{
                        int result = theController.undoPostIt(message);

                        mf.sendMessage(VERSION, result, "");
                    } catch (IllegalArgumentException | NoPreviousElementException e) {
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                e.getMessage());
                    } catch (NoSuchElementException e){
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                "User is not authenticated!");
                    }
                }

                if (message.code() == MessageCodes.VBH) {
                    try {
                        String result = theController.viewBoardHistory(message);

                        mf.sendMessage(VERSION, MessageCodes.RVBH, result);
                    } catch (IllegalArgumentException e) {
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                e.getMessage());
                    } catch (NoSuchElementException e){
                        mf.sendMessage(VERSION, MessageCodes.ERR,
                                "User is not authenticated!");
                    }
                }
                if(message.code() == MessageCodes.SAB){
                    try {
                        int result = theController.shareBoard(message);

                        mf.sendMessage(VERSION, result, "");
                    }catch (IllegalArgumentException|NullPointerException e){
                        mf.sendMessage(VERSION, MessageCodes.ERR, e.getMessage());
                    }catch (NoSuchElementException e){
                        mf.sendMessage(VERSION, MessageCodes.ERR, "User is not authenticated!");
                    }
                }

            } while (message.code() != MessageCodes.DISCONN);

            mf.sendMessage(VERSION, MessageCodes.ACK, "");
            System.out.println("Client " + clientIP.getHostAddress()
                    + ", port number: " + sock.getPort()
                    + " disconnected");

            sock.close();
        } catch (IOException ex) {
            System.out.println("IOException");
        }
    }
}
