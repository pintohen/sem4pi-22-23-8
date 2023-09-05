package org.boards.controller;

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

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class GetBoardsControllerTest {
    @Mock
    private BoardRepository boardRepository;

    private GetBoardsController getBoardsController;

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
        getBoardsController = new GetBoardsController(boardRepository);
    }

    @Test
    public void testGetBoardsByUser() {
        User authUser = managerUser();
        when(boardRepository.getBoardsByUser(authUser)).thenReturn(new ArrayList<>());

        getBoardsController.getBoardsByUser(authUser);

        verify(boardRepository, times(1)).getBoardsByUser(authUser);
    }

    @Test
    public void testGetBoardsByUserWithInvalidUser() {
        assertThrows(IllegalArgumentException.class, () ->{
            getBoardsController.getBoardsByUser(null);
        });
    }

    @Test
    public void getBoardById() {
        User authUser = managerUser();
        Board board = board();

        board.addPermission(createBoardPermission(authUser));
        when(boardRepository.ofIdentity(1L)).thenReturn(Optional.ofNullable(board));

        getBoardsController.getBoardById(1L, authUser);

        verify(boardRepository, times(1)).ofIdentity(1L);
    }

    @Test
    public void getBoardByIdWithoutPermissionShouldThrowError() {
        User authUser = managerUser();
        when(boardRepository.ofIdentity(1L)).thenReturn(Optional.ofNullable(board()));

        assertThrows(IllegalArgumentException.class, () ->{
            getBoardsController.getBoardById(1L, authUser);
        });
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