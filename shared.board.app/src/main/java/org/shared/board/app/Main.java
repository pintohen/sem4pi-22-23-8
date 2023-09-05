package org.shared.board.app;

import org.shared.board.app.ui.MainMenuUI;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * The type Main.
 */
public class Main {
    private static InetAddress serverIP;
    private static Socket sock;
    private static final int PORT = 9999;

    /**
     * Main.
     *
     * @param args the args
     * @throws Exception the exception
     */
    public static void main(String args[]) throws Exception {
        if (args.length != 1) {
            System.out.println("Server IPv4/IPv6 address "
                    + "or DNS name is required as argument");
            System.exit(1);
        }

        try {
            serverIP = InetAddress.getByName(args[0]);
        } catch (UnknownHostException ex) {
            System.out.println("Invalid server specified: " + args[0]);
            System.exit(1);
        }

        try {
            sock = new Socket(serverIP, PORT);
        } catch (IOException ex) {
            System.out.println("Failed to establish TCP connection");
            System.exit(1);
        }

        MainMenuUI ui = new MainMenuUI(sock);
        ui.doShow();
    }
}
