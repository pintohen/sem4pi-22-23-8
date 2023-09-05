package org.shared.board.app.ui;

import eapli.framework.io.util.Console;
import org.shared.board.app.SharedBoardAppController;
import org.shared.board.app.Util;
import org.shared.board.common.Message;
import org.shared.board.common.MessageCodes;

import java.nio.charset.StandardCharsets;

/**
 * The type DeletePostItUI ui.
 */
public class DeletePostItUI {
    private SharedBoardAppController theController;

    /**
     * Instantiates a new delete postIt ui.
     * @param theControllerp the the controllerp
     */
    public DeletePostItUI(final SharedBoardAppController theControllerp) {
        this.theController = theControllerp;
    }

    /**
     * Ask user Row position.
     * Ask user Col position.
     * Ask user board id.
     * Call method to delete post-it.
     */
    protected void doShow() {
        final String rowPos = Console.readLine("Post-It Row position:");
        final String colPos = Console.readLine("Post-It Column position:");
        final String boardId = Console.readLine("Board Id:");

        String data = rowPos + "\0" + colPos + "\0" + boardId + "\0";

        System.out.println();

        Message result = theController.deletePostIt(data);

        if (result.code() == MessageCodes.ACK) {
            System.out.println("Post-It deleted successfully!\n");
        } else {
            String errorData;

            if (result.data().length > 0) {
                errorData = new String(result.data(),
                        StandardCharsets.US_ASCII);
            } else {
                errorData = "Invalid data!";
            }

            System.out.println(errorData + "\n");
        }
    }
}
