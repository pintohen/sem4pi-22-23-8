package org.shared.board.app.ui;

import eapli.framework.io.util.Console;
import org.shared.board.app.SharedBoardAppController;
import org.shared.board.common.Message;
import org.shared.board.common.MessageCodes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * The type CreateBoard ui.
 */
public class CreateBoardUI {
    private BufferedReader in = new BufferedReader(
            new InputStreamReader(System.in));
    private SharedBoardAppController theController;

    /**
     * The constant MIN_ROWS_COLUMNS.
     */
    private static final String MIN_ROWS_COLS = "1";

    /**
     * Instantiates a new create board ui.
     * @param theControllerp the the controllerp
     */
    public CreateBoardUI(final SharedBoardAppController theControllerp) {
        this.theController = theControllerp;
    }

    /**
     * Ask user Email and Password to authenticate.
     */
    protected void doShow() {
        try{
            String data = "";

            final String boardTitle = Console.readLine("Board Title:");
            final String boardNCol = Console.readLine("Board Number of Columns:");
            final String boardNRow = Console.readLine("Board Number of Rows:");

            data = boardTitle + "\0" + boardNCol + "\0" + boardNRow + "\0";

            System.out.println("----COLUMNS ENTRYS----");
            for(int i = 1; i <= Integer.parseInt(boardNCol); i++){
                System.out.println("Board Row position -> " + MIN_ROWS_COLS);
                System.out.println("Board Column position -> " + i);

                final String entryTitle = Console.readLine("Entry Title:");
                data = data + entryTitle + "\0";
            }

            System.out.println("----ROWS ENTRYS----");
            for(int i = 2; i <= Integer.parseInt(boardNRow); i++){
                System.out.println("Board Row position -> " + i);
                System.out.println("Board Column position -> " + MIN_ROWS_COLS);

                final String entryTitle = Console.readLine("Entry Title:");
                data = data + entryTitle + "\0";
            }

            System.out.println();

            Message result = theController.createBoard(data);

            if (result.code() == MessageCodes.ACK) {
                System.out.println("Board created successfully!\n");
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
        } catch (NumberFormatException e){
            System.out.println("Bad input for number of Columns or Rows");
        }
    }
}
