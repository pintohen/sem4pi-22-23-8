package org.boards.service;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.domain.model.*;
import org.domain.repositories.BoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class BoardServiceTest {
    ECoursePasswordPolicy passwordPolicy = new ECoursePasswordPolicy();
    private BoardService boardService;
    @Mock
    private BoardRepository boardRepositoryMock;

    private static final String STRING_SHORTNAME = "shortName";
    private static final String STRING_SHORTNAME_2 = "shortName2";
    private static final String STRING_FULLNAME = "fullName";
    private static final String STRING_FULLNAME_2 ="fullName2";

    private static final String STRING_PASSWORD = "Correct5";
    private static final String STRING_EMAIL = "email@email.com";
    private static final String STRING_EMAIL_2="email2@email.com";
    private final String boardTitle = "Test Board";
    private final String boardNRow = "3";
    private final String boardNCol = "4";


    @BeforeEach
    void setUp() {
        boardRepositoryMock = mock(BoardRepository.class);
        boardService = new BoardService(boardRepositoryMock);
    }

    @Test
    void testCreateBoardValid() {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();

        BoardFactory factory = new BoardFactory();
        Board board = factory.create(boardTitle, boardNRow, boardNCol, allBoardEntrys, boardOwner);

        when(boardRepositoryMock.save(any(Board.class))).thenReturn(board);

        Board result = boardService.createBoard(
                boardTitle, boardNRow, boardNCol,
                allBoardEntrys, boardOwner);

        assertEquals(boardTitle, result.boardTitle().value());
        assertEquals(Integer.parseInt(boardNRow), result.boardNRow().value());
        assertEquals(Integer.parseInt(boardNCol), result.boardNCol().value());
        assertEquals(boardOwner, result.boardOwner());
        verify(boardRepositoryMock, times(1)).save(any(Board.class));
    }

    @Test
    void testCreateBoardWithInvalidBoardNRow() {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();

        BoardFactory factory = new BoardFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create(boardTitle, "-1", boardNCol, allBoardEntrys, boardOwner));

        verify(boardRepositoryMock, times(0)).save(any(Board.class));
    }

    @Test
    void testCreateBoardWithInvalidBoardNColumn() {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();

        BoardFactory factory = new BoardFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create(boardTitle, boardNRow, "-1", allBoardEntrys, boardOwner));

        verify(boardRepositoryMock, times(0)).save(any(Board.class));
    }

    @Test
    void testCreateBoardWithInvalidBoardTitle() {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();

        BoardFactory factory = new BoardFactory();

        assertThrows(IllegalArgumentException.class,
                () -> factory.create("", boardNRow, boardNCol, allBoardEntrys, boardOwner));

        verify(boardRepositoryMock, times(0)).save(any(Board.class));
    }

    @Test
    void testCreateBoardAddBoardPermissionAndEntrys() {
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();

        BoardEntryFactory factoryBE = new BoardEntryFactory();
        BoardEntry entry = factoryBE.create("1",
                "1", "1", "Entry 1",
                "3", "3");
        allBoardEntrys.add(entry);

        BoardFactory factory = new BoardFactory();
        Board board = factory.create(boardTitle, boardNRow, boardNCol, allBoardEntrys, boardOwner);

        BoardPermissionFactory factoryBPF = new BoardPermissionFactory();
        BoardPermission boardPermission = factoryBPF.create(boardOwner, AccessLevelType.WRITE);

        board.addPermission(boardPermission);

        when(boardRepositoryMock.save(any(Board.class))).thenReturn(board);

        boardService.createBoard(
                boardTitle, boardNRow, boardNCol,
                allBoardEntrys, boardOwner);

        verify(boardRepositoryMock, times(1)).save(any(Board.class));
    }

    @Test
    void confirmCorrectLevel() {
        assertEquals(AccessLevelType.WRITE, boardService.confirmLevel("Write"));

        assertEquals(AccessLevelType.READ, boardService.confirmLevel("Read"));
    }

    @Test
    void confirmWrongLevel(){
        assertThrows(IllegalArgumentException.class, ()-> boardService.confirmLevel("Readable"));
        assertThrows(IllegalArgumentException.class, ()-> boardService.confirmLevel("Wrong"));
        assertThrows(IllegalArgumentException.class, ()-> boardService.confirmLevel("Sentence"));
        assertThrows(IllegalArgumentException.class, ()-> boardService.confirmLevel("Blabla1213"));
    }

    @Test
    void shareABoard(){
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();
        User teacher = teacherUser();

        BoardEntryFactory factoryBE = new BoardEntryFactory();
        BoardEntry entry = factoryBE.create("1",
                "1", "1", "Entry 1",
                "3", "3");
        allBoardEntrys.add(entry);

        BoardFactory factory = new BoardFactory();
        Board board = factory.create(boardTitle, boardNRow, boardNCol, allBoardEntrys, boardOwner);

        BoardPermissionFactory factoryBPF = new BoardPermissionFactory();
        BoardPermission boardPermission = factoryBPF.create(boardOwner, AccessLevelType.WRITE);

        board.addPermission(boardPermission);

        boardService.createBoard(
                boardTitle, boardNRow, boardNCol,
                allBoardEntrys, boardOwner);

        boardService.addToBoard(board, teacher, AccessLevelType.READ);

        List<Board> boards = new ArrayList<>();
        boards.add(board);

        when(boardRepositoryMock.getBoardsByUser(teacher)).thenReturn(boards);

        assertTrue(board.userHasAnyPermission(teacher));
    }

    @Test
    void shareABoardAgain(){
        List<BoardEntry> allBoardEntrys = new ArrayList<>();
        User boardOwner = managerUser();
        User teacher = teacherUser();

        BoardEntryFactory factoryBE = new BoardEntryFactory();
        BoardEntry entry = factoryBE.create("1",
                "1", "1", "Entry 1",
                "3", "3");
        allBoardEntrys.add(entry);

        BoardFactory factory = new BoardFactory();
        Board board = factory.create(boardTitle, boardNRow, boardNCol, allBoardEntrys, boardOwner);

        BoardPermissionFactory factoryBPF = new BoardPermissionFactory();
        BoardPermission boardPermission = factoryBPF.create(boardOwner, AccessLevelType.WRITE);

        board.addPermission(boardPermission);

        boardService.createBoard(
                boardTitle, boardNRow, boardNCol,
                allBoardEntrys, boardOwner);

        boardService.addToBoard(board, teacher, AccessLevelType.READ);

        assertThrows(IllegalArgumentException.class,
                () -> boardService.addToBoard(board, teacher, AccessLevelType.READ));
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

    private User teacherUser(){
        UserBuilder builder = new UserBuilder(passwordPolicy, new PlainTextEncoder());

        return builder.with(STRING_SHORTNAME_2,
                STRING_PASSWORD,
                STRING_FULLNAME_2,
                STRING_EMAIL_2,
                CourseRoles.TEACHER).withAcronym("TTP")
                .build();
    }

}