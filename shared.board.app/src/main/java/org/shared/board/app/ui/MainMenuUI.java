package org.shared.board.app.ui;

import org.shared.board.app.SharedBoardAppController;
import org.shared.board.common.MessageCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * The type Main menu ui.
 */
public class MainMenuUI {
    private Socket sock;
    private SharedBoardAppController theController;

    /**
     * Instantiates a new Main menu ui.
     * @param sockp the sockp
     */
    public MainMenuUI(final Socket sockp) {
        this.sock = sockp;
        this.theController = new SharedBoardAppController(sockp);
    }

    /**
     * Handle ack.
     * @param codeResult the code result
     * @param messageOK  the message ok
     * @param messageBAD the message bad
     */
    public void handleACK(final int codeResult,
                          final String messageOK,
                          final String messageBAD) {
        if (codeResult == MessageCodes.ACK) {
            System.out.println(messageOK);
        } else {
            System.out.println(messageBAD);
        }
    }

    /**
     * Do show.
     * @throws IOException the io exception
     */
    public void doShow() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int choice = 0, codeResult;

        do {
            System.out.println("1 - Communication test");
            System.out.println("2 - Authenticate");
            System.out.println("3 - Create Board");
            System.out.println("4 - Create Post-It");
            System.out.println("5 - Update Post-It content");
            System.out.println("6 - Update Post-It position");
            System.out.println("7 - Delete Post-It");
            System.out.println("8 - Undo Post-It");
            System.out.println("9 - View Board History");
            System.out.println("10 - Share a board owned");
            System.out.println("0 - End of session request");
            System.out.println("\nOption - ");
            try {
                input = in.readLine();
                choice = Integer.parseInt(input);
            } catch(NumberFormatException ex) {
                choice = -1;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            switch (choice) {
                case 1:
                    codeResult = theController.sendCommunicationTest();

                    handleACK(codeResult,
                            "Communication test with success!\n",
                            "Problem with communication test!\n");

                    break;
                case 2:
                    LoginUI loginUI = new LoginUI(theController);
                    loginUI.doShow();
                    break;
                case 3:
                    CreateBoardUI boardUI = new CreateBoardUI(theController);
                    boardUI.doShow();
                    break;
                case 4:
                    CreatePostItUI createPostItUI = new CreatePostItUI(theController);
                    createPostItUI.doShow();
                    break;
                case 5:
                    UpdatePostItContentUI updatePostItContentUI =
                            new UpdatePostItContentUI(theController);
                    updatePostItContentUI.doShow();
                    break;
                case 6:
                    UpdatePostItPositionUI updatePostItPositionUI =
                            new UpdatePostItPositionUI(theController);
                    updatePostItPositionUI.doShow();
                    break;
                case 7:
                    DeletePostItUI deletePostItUI =
                            new DeletePostItUI(theController);
                    deletePostItUI.doShow();
                    break;
                case 8:
                    UndoPostItUI undoPostItUI = new UndoPostItUI(theController);
                    undoPostItUI.doShow();
                    break;
                case 9:
                    ViewBoardHistoryUI viewBoardHistoryUI =
                            new ViewBoardHistoryUI(theController);
                    viewBoardHistoryUI.doShow();
                    break;

                case 10:
                    ShareBoardUI shareBoardUI = new ShareBoardUI(theController);
                    shareBoardUI.doShow();
                    break;
                case 0:
                    codeResult = theController.sendEndOfSession();

                    if(codeResult == MessageCodes.ACK){
                        System.out.println("End of session request with success!\n");
                        choice = -1;
                    } else {
                        System.out.println("Problem with end of session request!\n");
                    }

                    break;
                default:
                    System.out.println("Invalid choice!\n");
                    choice = 0;
                    break;
            }

        } while(choice != -1);

        sock.close();
    }
}
