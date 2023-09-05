package org.shared.board.app.ui;

import eapli.framework.io.util.Console;
import org.shared.board.app.SharedBoardAppController;
import org.shared.board.common.Message;
import org.shared.board.common.MessageCodes;

import java.nio.charset.StandardCharsets;
import java.util.NoSuchElementException;

public class ShareBoardUI {

    private SharedBoardAppController ctrl;

    public ShareBoardUI(final SharedBoardAppController ctrl){
        this.ctrl = ctrl;
    }

    protected void doShow(){
        try{
            final String id = Console.readLine("What is the Id of the board you want to share with another person?");

            final String email = Console.readLine("What is the email of the user to be added to the system?");

            final String accessLevel = Console.readLine("What is the access level for the user?(Write/Read)");

            String data = id +"\0"+email+"\0"+accessLevel;

            Message msg = ctrl.shareABoard(data);

            if (msg.code() == MessageCodes.ACK) {
                    System.out.println("Shared the board successfully!\n");
            } else {
                String errorData;

                if (msg.data().length > 0) {
                    errorData = new String(msg.data(),
                                StandardCharsets.US_ASCII);
                } else {
                    errorData = "Invalid data!";
                }
                System.out.println(errorData + "\n");
            }
        }catch (IllegalArgumentException | NullPointerException e){
            System.out.println(e.getMessage());
        }catch (NoSuchElementException e){
            System.out.println("This user does not exist!");
        }
    }
}
