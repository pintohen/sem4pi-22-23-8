package org.domain.model.postit;

import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import org.domain.model.Board;
import org.domain.model.BoardFactory;
import org.junit.jupiter.api.Test;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.ECoursePasswordPolicy;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.model.UserBuilder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PostItTest {
    ECoursePasswordPolicy passwordPolicy = new ECoursePasswordPolicy();
    private final String POST_IT_CONTENT = "Sample Post-It Content";
    private final String POST_IT_ROW = "3";
    private final String POST_IT_COLUMN = "2";

    private final String BOARD_TITLE = "Test Board";
    private final String BOARD_N_ROW = "3";
    private final String BOARD_N_COL = "4";

    private static final String STRING_SHORTNAME = "shortName";
    private static final String STRING_FULLNAME = "fullName";
    private static final String STRING_PASSWORD = "Correct5";
    private static final String STRING_EMAIL = "email@email.com";

    @Test
    public void createValidPostIt() {
        User POST_IT_OWNER = managerUser();
        Board BOARD = createBoard();
        PostItFactory postItFactory = new PostItFactory();

        PostIt postIt = postItFactory.create(
                POST_IT_CONTENT,
                POST_IT_ROW,
                POST_IT_COLUMN,
                POST_IT_OWNER,
                BOARD,
                PostItStateType.CREATED
        );

        assertNotNull(postIt);
        assertNull(postIt.identity());
        assertEquals(POST_IT_CONTENT, postIt.content().value());
        assertEquals(Integer.parseInt(POST_IT_ROW), postIt.rowPos().value());
        assertEquals(Integer.parseInt(POST_IT_COLUMN), postIt.columnPos().value());
        assertEquals(PostItStateType.CREATED, postIt.state());
        assertEquals(POST_IT_OWNER, postIt.owner());
        assertEquals(BOARD, postIt.board());
    }

    @Test
    public void sameAsReturnsTrueForSameInstance() {
        PostIt postIt = createPostIt();
        assertTrue(postIt.sameAs(postIt));
    }

    public Board createBoard(){
        BoardFactory factory = new BoardFactory();
        Board board = factory.create(
                BOARD_TITLE,
                BOARD_N_ROW,
                BOARD_N_COL,
                new ArrayList<>(),
                managerUser());

        return board;
    }

    private User managerUser(){
        UserBuilder userBuilder = new UserBuilder(passwordPolicy, new PlainTextEncoder());

        return userBuilder.with(
                        STRING_SHORTNAME,
                        STRING_PASSWORD,
                        STRING_FULLNAME,
                        STRING_EMAIL,
                        CourseRoles.MANAGER)
                .build();
    }

    private PostIt createPostIt(){
        User POST_IT_OWNER = managerUser();
        Board BOARD = createBoard();
        PostItFactory postItFactory = new PostItFactory();

        PostIt postIt = postItFactory.create(
                POST_IT_CONTENT,
                POST_IT_ROW,
                POST_IT_COLUMN,
                POST_IT_OWNER,
                BOARD,
                PostItStateType.CREATED
        );

        return postIt;
    }
}