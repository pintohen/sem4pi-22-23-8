package org.bootstrappers.demo;

import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.IntegrityViolationException;
import org.boards.controller.CreateBoardController;
import org.domain.model.Board;
import org.domain.model.BoardEntry;

import java.util.ArrayList;
import java.util.List;

public class BoardsBootstrapper implements Action {
    CreateBoardController theController = new CreateBoardController();

    /**
     * The constant MIN_ROWS_COLUMNS.
     */
    private static final String MIN_ROWS_COLS = "1";

    /**
     * The constant BOARD_ONE_ROWS.
     */
    private static final String BOARD_ONE_ROWS = "4";

    /**
     * The constant BOARD_ONE_COLUMNS.
     */
    private static final String BOARD_ONE_COLUMNS = "4";
    /**
     * The constant BOARD_TWO_ROWS.
     */
    private static final String BOARD_TWO_ROWS = "1";

    /**
     * The constant BOARD_TWO_COLUMNS.
     */
    private static final String BOARD_TWO_COLUMNS = "3";
    /**
     * The constant BOARD_THREE_ROWS.
     */
    private static final String BOARD_THREE_ROWS = "5";

    /**
     * The constant BOARD_THREE_ROWS.
     */
    private static final String BOARD_THREE_COLUMNS = "1";
    /**
     * The constant BOARD_FOUR_ROWS.
     */
    private static final String BOARD_FOUR_ROWS = "5";

    /**
     * The constant BOARD_FOUR_COLUMNS.
     */
    private static final String BOARD_FOUR_COLUMNS = "5";
    @Override
    public boolean execute() {
        registerBoard("Board LAPR4", BOARD_ONE_ROWS, BOARD_ONE_COLUMNS, entrysBoardOne());
        registerBoard("Board LPROG", BOARD_TWO_ROWS, BOARD_TWO_COLUMNS, entrysBoardTwo());
        registerBoard("Board SCOMP", BOARD_THREE_ROWS, BOARD_THREE_COLUMNS, entrysBoardThree());
        registerBoard("Board EAPLI", BOARD_FOUR_ROWS, BOARD_FOUR_COLUMNS, entrysBoardFour());

        return true;
    }


    private void registerBoard(final String boardTitlep,
                               final String boardNRowp,
                               final String boardNColp,
                               final List<BoardEntry> allBoardEntrys) {
        try{
            Board board = theController.createBoard(boardTitlep,
                  boardNRowp, boardNColp, allBoardEntrys);

            System.out.println("[+] Board Id - " + board.identity());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IntegrityViolationException e){
            System.out.println("Already exist --> " + boardTitlep);
        }
    }

    private List<BoardEntry> entrysBoardOne(){
        return getBoardEntries(BOARD_ONE_ROWS, BOARD_ONE_COLUMNS);
    }


    private List<BoardEntry> entrysBoardTwo(){
        return getBoardEntries(BOARD_TWO_ROWS, BOARD_TWO_COLUMNS);
    }

    private List<BoardEntry> entrysBoardThree(){
        return getBoardEntries(BOARD_THREE_ROWS, BOARD_THREE_COLUMNS);
    }

    private List<BoardEntry> entrysBoardFour(){
        return getBoardEntries(BOARD_FOUR_ROWS, BOARD_FOUR_COLUMNS);
    }

    private List<BoardEntry> getBoardEntries(String boardRows, String boardColumns) {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();

        for(int i = 1; i <= Integer.parseInt(boardColumns); i++){
            BoardEntry boardEntry = theController.createBoardEntry(
                    String.valueOf(i),
                    MIN_ROWS_COLS,
                    String.valueOf(i),
                    "Title Column " + i,
                    boardRows,
                    boardColumns);

            allBoardEntrys.add(boardEntry);
        }

        for(int i = 2; i <= Integer.parseInt(boardRows); i++){
            BoardEntry boardEntry = theController.createBoardEntry(
                    String.valueOf(i),
                    String.valueOf(i),
                    MIN_ROWS_COLS,
                    "Title Row " + i,
                    boardRows,
                    boardColumns);

            allBoardEntrys.add(boardEntry);
        }

        return allBoardEntrys;
    }
}
