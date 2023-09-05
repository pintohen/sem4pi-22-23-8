package org.shared.board.server.request_bodys;

public class PostItPositionBody {
    private String previousPostItRow;
    private String previousPostItColumn;

    private String newPostItRow;
    private String newPostItColumn;
    private String boardId;

    public String previousPostItRow() {
        return previousPostItRow;
    }

    public String previousPostItColumn() {
        return previousPostItColumn;
    }

    public String newPostItRow() {
        return newPostItRow;
    }

    public String newPostItColumn() {
        return newPostItColumn;
    }

    public String boardId() {
        return boardId;
    }
}
