package org.postit.controller;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.domain.model.*;
import org.domain.repositories.BoardRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;
import repositories.PostItRepository;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class GetPostItsControllerTest {
    @Mock
    private BoardRepository boardRepository;

    @Mock
    private PostItRepository postItRepository;


    private GetPostItsController getPostItsController;

    ECoursePasswordPolicy passwordPolicy = new ECoursePasswordPolicy();

    private static final String STRING_SHORTNAME = "shortName";
    private static final String STRING_FULLNAME = "fullName";
    private static final String STRING_PASSWORD = "Correct5";
    private static final String STRING_EMAIL = "email@email.com";
    private final String boardTitle = "Test Board";
    private final String boardNRow = "3";
    private final String boardNCol = "4";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        boardRepository = mock(BoardRepository.class);
        postItRepository = mock(PostItRepository.class);
        getPostItsController = new GetPostItsController(postItRepository, boardRepository);
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

    @Test
    public void getLastPostItsByBoard() {
        User authUser = managerUser();
        Board board = board();

        board.addPermission(createBoardPermission(authUser));
        when(boardRepository.ofIdentity(1L)).thenReturn(Optional.ofNullable(board));
        when(postItRepository.lastPostItsOnBoard(board)).thenReturn(new ArrayList<>());

        getPostItsController.getLastPostItsByBoard(1L, authUser);

        verify(boardRepository, times(1)).ofIdentity(1L);
        verify(postItRepository, times(1)).lastPostItsOnBoard(board);
    }

    @Test
    public void getLastPostItsByBoardWithoutPermissionShouldThrowError() {
        User authUser = managerUser();
        Board board = board();

        when(boardRepository.ofIdentity(1L)).thenReturn(Optional.ofNullable(board));
        when(postItRepository.lastPostItsOnBoard(board)).thenReturn(new ArrayList<>());

        assertThrows(IllegalArgumentException.class, () ->{
            getPostItsController.getLastPostItsByBoard(1L, authUser);
        });
    }


    private Board board() {
        BoardFactory factory = new BoardFactory();
        Board board = factory.create(boardTitle, boardNRow, boardNCol, new ArrayList<>(), managerUser());

        return board;
    }

    public BoardPermission createBoardPermission(User user){
        BoardPermissionFactory factory = new BoardPermissionFactory();
        BoardPermission boardPermission = factory.create(user, AccessLevelType.WRITE);

        return boardPermission;
    }
}