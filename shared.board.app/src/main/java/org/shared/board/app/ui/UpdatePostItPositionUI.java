package org.shared.board.app.ui;

import eapli.framework.io.util.Console;
import org.shared.board.app.SharedBoardAppController;
import org.shared.board.common.Message;
import org.shared.board.common.MessageCodes;

import java.nio.charset.StandardCharsets;

/**
 * The type UpdatePostItPositionUI ui.
 */
public class UpdatePostItPositionUI {
    private SharedBoardAppController theController;

    /**
     * Instantiates a new update postIt position ui.
     * @param theControllerp the the controllerp
     */
    public UpdatePostItPositionUI(final SharedBoardAppController theControllerp) {
        this.theController = theControllerp;
    }

    /**
     * Ask user previous Row position.
     * Ask user previous Col position.
     * Ask user new Row position.
     * Ask user new Col position.
     * Ask user board id.
     * Call method to move post-it.
     */
    protected void doShow() {
        final String previousRowPos = Console.readLine("Post-It Row position:");
        final String previousColPos = Console.readLine("Post-It Column position:");
        final String newRowPos = Console.readLine("Post-It Row new position:");
        final String newColPos = Console.readLine("Post-It Column new position:");
        final String boardId = Console.readLine("Board Id:");

        String data = previousRowPos + "\0" + previousColPos + "\0"
                + newRowPos + "\0" + newColPos + "\0" + boardId + "\0";

        System.out.println();

        Message result = theController.updatePostItPosition(data);

        if (result.code() == MessageCodes.ACK) {
            System.out.println("Post-It updated successfully!\n");
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
