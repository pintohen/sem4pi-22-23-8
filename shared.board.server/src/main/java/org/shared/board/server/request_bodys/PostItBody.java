package org.shared.board.server.request_bodys;

public class PostItBody {
    private String postItContent;
    private String postItRow;
    private String postItColumn;
    private String boardId;

    public String content() {
        return postItContent;
    }

    public String row() {
        return postItRow;
    }

    public String column() {
        return postItColumn;
    }

    public String boardId() {
        return boardId;
    }
}
