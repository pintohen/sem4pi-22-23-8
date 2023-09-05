package org.shared.board.app;

import eapli.framework.io.util.Console;

public class Util {
    public static String postItBody() {
        String content = "";
        final String rowPos = Console.readLine("Post-It Row position:");
        final String colPos = Console.readLine("Post-It Column position:");
        final String boardId = Console.readLine("Board Id:");

        String opt = "";

        do {
            System.out.println("1 - Text Content");
            System.out.println("2 - Image Content");
            opt = Console.readLine("Option - ");

            switch (opt) {
                case "1":
                    content = Console.readLine("Post-It Content:");
                    break;
                case "2":
                    String filePath = Console.readLine("Image path:");
                    content = ImgurUpload.uploadImage(filePath);
                    break;
                default:
                    opt = "-1";
                    break;
            }
        } while ("-1".compareTo(opt) == 0);

        System.out.println();

        return content + "\0" + rowPos + "\0" + colPos + "\0" + boardId + "\0";
    }
}
