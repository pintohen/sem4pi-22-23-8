package org.domain.model;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.junit.jupiter.api.Test;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    ECoursePasswordPolicy passwordPolicy = new ECoursePasswordPolicy();
    private final String boardTitle = "Test Board";
    private final String boardNRow = "3";
    private final String boardNCol = "4";

    private static final String STRING_SHORTNAME = "shortName";
    private static final String STRING_FULLNAME = "fullName";
    private static final String STRING_PASSWORD = "Correct5";
    private static final String STRING_EMAIL = "email@email.com";

    @Test
    public void testCreateValidBoard() {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();

        BoardFactory factory = new BoardFactory();
        Board board = factory.create(boardTitle, boardNRow, boardNCol, allBoardEntrys, boardOwner);

        BoardPermissionFactory factoryBP = new BoardPermissionFactory();
        board.addPermission(factoryBP.create(boardOwner, AccessLevelType.WRITE));

        assertNotNull(board);
        assertEquals(null, board.identity());
        assertEquals(boardTitle, board.boardTitle().value());
        assertEquals(Integer.parseInt(boardNRow), board.boardNRow().value());
        assertEquals(Integer.parseInt(boardNCol), board.boardNCol().value());
        assertEquals(boardOwner, board.boardOwner());
    }
    @Test
    public void testCreateBoardWithInvalidNumberOfRows() {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();

        BoardFactory factory = new BoardFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create(boardTitle,
                        "-1",
                        boardNCol,
                        allBoardEntrys,
                        boardOwner));
    }

    @Test
    public void testCreateBoardWithInvalidNumberOfColumns() {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();

        BoardFactory factory = new BoardFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create(boardTitle,
                        boardNRow,
                        "-1",
                        allBoardEntrys,
                        boardOwner));
    }

    @Test
    public void testCreateBoardWithEntry() {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        BoardEntryFactory factory = new BoardEntryFactory();

        BoardEntry entry = factory.create(
                "1", "1",
                "1", "Entry 1",
                "3", "3");

        allBoardEntrys.add(entry);

        User boardOwner = managerUser();

        BoardFactory factoryBoard = new BoardFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factoryBoard.create(boardTitle,
                        boardNRow,
                        "-1",
                        allBoardEntrys,
                        boardOwner));
    }

    @Test
    public void testSameBoard() {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();

        BoardFactory factory = new BoardFactory();
        Board board = factory.create(boardTitle, boardNRow, boardNCol, allBoardEntrys, boardOwner);
        Board board2 = factory.create(boardTitle, boardNRow, boardNCol, allBoardEntrys, boardOwner);

        assertTrue(board.sameAs(board2));
    }

    @Test
    public void testSameBoardWithNull() {
        BoardFactory factory = new BoardFactory();

        Board board = factory.create(boardTitle, boardNRow, boardNCol, new ArrayList<>(), managerUser());

        assertFalse(board.sameAs(null));
    }

    @Test
    public void testNotSameAsDifferentTitles() {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();

        BoardFactory factory = new BoardFactory();
        Board board = factory.create(boardTitle, boardNRow, boardNCol, allBoardEntrys, boardOwner);
        Board board2 = factory.create("Different Title", boardNRow, boardNCol, allBoardEntrys, boardOwner);

        assertFalse(board.sameAs(board2));
    }

    private User managerUser(){
        UserBuilder userBuilder = new UserBuilder(passwordPolicy, new PlainTextEncoder());

        return userBuilder.with(STRING_SHORTNAME,
                        STRING_PASSWORD,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        CourseRoles.MANAGER)
                .build();
    }
}