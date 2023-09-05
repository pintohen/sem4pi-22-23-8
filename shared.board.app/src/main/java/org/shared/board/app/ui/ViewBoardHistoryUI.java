package org.shared.board.app.ui;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.shared.board.app.SharedBoardAppController;
import org.shared.board.common.Message;
import org.shared.board.common.MessageCodes;
import eapli.framework.io.util.Console;
public class ViewBoardHistoryUI {

    private SharedBoardAppController theController;

    public ViewBoardHistoryUI(final SharedBoardAppController theControllerp) {
        this.theController = theControllerp;
    }

    protected void doShow() {

        try {

            String data = "";

            final String boardId = Console.readLine("What's the board you want to check? (ID)");

            Message result = theController.viewBoardHistory(boardId);

            if (result.code() == MessageCodes.RVBH) {

                data = new String(result.data(), StandardCharsets.US_ASCII);

                System.out.printf(data + "\n\n");

            } else {
                String errorData;

                if (result.data().length > 0) {
                    errorData = new String(result.data(), StandardCharsets.US_ASCII);
                } else {
                    errorData = "Invalid data";
                }

                System.out.printf("Error: %s\n\n", errorData);

            }

        } catch (final Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

}