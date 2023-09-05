package org.shared.board.app.ui;

import eapli.framework.io.util.Console;
import eapli.framework.presentation.console.AbstractUI;
import org.shared.board.app.SharedBoardAppController;
import org.shared.board.common.Message;
import org.shared.board.common.MessageCodes;

import java.nio.charset.StandardCharsets;

public class UndoPostItUI extends AbstractUI {

    private SharedBoardAppController ctrl;

    public UndoPostItUI(SharedBoardAppController ctrl) {
        this.ctrl = ctrl;
    }


    @Override
    protected boolean doShow() {
        String data = "";

        final String boardId = Console.readLine("Board Id:");
        final String rowPos = Console.readLine("Post-It Row position:");
        final String colPos = Console.readLine("Post-It Column position:");

        data = boardId + "\0" + rowPos + "\0" + colPos + "\0";

        System.out.println();

        Message result = this.ctrl.undoPostIt(data);

        if(result == null){
            System.out.println("Not Yet Implemented");
            return false;
        }

        if(result.code() == MessageCodes.ACK){
            System.out.println("Post-It undone successfully!\n");
        }else {
            String errorData;

            if(result.data().length > 0){
                errorData = new String(result.data(),
                        StandardCharsets.US_ASCII);
            }else {
                errorData = "Invalid data!";
            }

            System.out.println(errorData + "\n");
        }


        return true;
    }

    @Override
    public String headline() {
        return "Undo Post-It";
    }
}
