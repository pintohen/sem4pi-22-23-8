package org.shared.board.app.ui;

import org.shared.board.app.SharedBoardAppController;
import org.shared.board.app.Util;
import org.shared.board.common.Message;
import org.shared.board.common.MessageCodes;

import java.nio.charset.StandardCharsets;

/**
 * The type UpdatePostItContentUI ui.
 */
public class UpdatePostItContentUI {
    private SharedBoardAppController theController;

    /**
     * Instantiates a new update postIt content ui.
     * @param theControllerp the the controllerp
     */
    public UpdatePostItContentUI(final SharedBoardAppController theControllerp) {
        this.theController = theControllerp;
    }

    /**
     * Ask user Row position.
     * Ask user Col position.
     * Ask user board id.
     * Ask user type of content.
     * Call method to Update post-it.
     */
    protected void doShow() {
        String data = Util.postItBody();

        Message result = theController.updatePostItContent(data);

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
