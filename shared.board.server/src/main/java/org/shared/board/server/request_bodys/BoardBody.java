package org.shared.board.server.request_bodys;

import org.domain.model.Board;

import java.util.ArrayList;
import java.util.List;

public class BoardBody {
    private String boardTitle;
    private String boardNRow;
    private String boardNColumn;
    private List<String> allBoardEntrys = new ArrayList<>();

    public String boardTitle() {
        return boardTitle;
    }

    public String boardNRow() {
        return boardNRow;
    }

    public String boardNColumn() {
        return boardNColumn;
    }

    public List<String> boardEntrys() {
        return allBoardEntrys;
    }
}
