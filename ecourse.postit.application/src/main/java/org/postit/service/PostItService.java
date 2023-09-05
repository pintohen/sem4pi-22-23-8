package org.postit.service;

import eapli.framework.validations.Preconditions;
import exceptions.NoPreviousElementException;
import org.domain.model.AccessLevelType;
import org.domain.model.Board;
import org.domain.model.postit.*;
import org.domain.repositories.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.usermanagement.domain.model.User;
import repositories.PostItRepository;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

/**
 * The type Post-it service.
 */
@Service
public class PostItService {
    /**
     * PostItRepository.
     */
    private final PostItRepository postItRepository;

    /**
     * BoardRepository.
     */
    private final BoardRepository boardRepository;

    /**
     * Check if is a number pattern
     */
    private Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    /**
     * Instantiates a new Post-it service.
     * @param postItRepo the post-it repo
     * @param boardRepo  the board repo
     */
    @Autowired
    public PostItService(final PostItRepository postItRepo,
                         final BoardRepository boardRepo) {
        postItRepository = postItRepo;
        boardRepository = boardRepo;
    }

    /**
     * Create post-it.
     * @param postItContentp the post-it contentp
     * @param postItRowp     the post-it rowp
     * @param postItColumnp  the post-it columnp
     * @param postItOwner    the post-it owner
     * @param boardIdp       the board idp
     * @return the post-it
     * @throws NoSuchElementException the no such element exception
     */
    public PostIt createPostIt(final String postItContentp,
                               String postItRowp,
                               String postItColumnp,
                               final User postItOwner,
                               final String boardIdp)
            throws NoSuchElementException {
        Long boardId = Long.parseLong(boardIdp);
        Board board = boardRepository.ofIdentity(boardId).get();

        postItRowp = checkIfIsRowEntryTitle(postItRowp, board);
        postItColumnp = checkIfIsColumnEntryTitle(postItColumnp, board);

        Preconditions.ensure(
                postItByPosition(
                        postItRowp,
                        postItColumnp,
                        board,
                        false
                ) == null, "Already exist a Post-It in that cell!");

        Preconditions.ensure(
                board.userHasPermission(postItOwner,
                        AccessLevelType.WRITE), "You don't have "
                        + AccessLevelType.WRITE + " permission"
        );

        PostItFactory postItFactory = new PostItFactory();

        PostIt postIt = postItFactory.create(
                postItContentp,
                postItRowp,
                postItColumnp,
                postItOwner,
                board,
                PostItStateType.CREATED);

        return postItRepository.save(postIt);
    }

    /**
     * Update post-it content.
     * @param postItContentp the post-it contentp
     * @param postItRowp     the post-it rowp
     * @param postItColumnp  the post-it columnp
     * @param boardIdp       the board idp
     * @param authUser       the user updating
     * @param postItStatep   the post-it state
     * @return the post-it
     * @throws NoSuchElementException the no such element exception
     */
    public PostIt changePostIt(final String postItContentp,
                                String postItRowp,
                                String postItColumnp,
                                final String boardIdp,
                                final User authUser,
                                final PostItState postItStatep)
            throws NoSuchElementException {
        Long boardId = Long.parseLong(boardIdp);
        Board board = boardRepository.ofIdentity(boardId).get();

        postItRowp = checkIfIsRowEntryTitle(postItRowp, board);
        postItColumnp = checkIfIsColumnEntryTitle(postItColumnp, board);

        PostIt lastPostIt = postItByPosition(
                postItRowp,
                postItColumnp,
                board,
                false);

        Preconditions.ensure(
                lastPostIt != null,
                "There is no post-it in this cell!");

        checkForUserOwnership(authUser, board, lastPostIt);

        PostItFactory postItFactory = new PostItFactory();

        PostIt postItUpdated = postItFactory.createChange(
                postItContentp,
                postItRowp,
                postItColumnp,
                authUser,
                board,
                postItStatep,
                lastPostIt);

        return postItRepository.save(postItUpdated);
    }

    /**
     * Check if already exist a Post-it in that position.
     * @param postItRowp postItRowp
     * @param postItColumnp postItColumnp
     * @param boardp boardp
     * @return PostIt
     */
    private PostIt postItByPosition(final String postItRowp,
                                    final String postItColumnp,
                                    final Board boardp,
                                    final boolean isUndo){
        PostIt postIt = postItRepository.positByPosition(postItRowp,
                    postItColumnp, boardp);

        if(postIt != null
                && ((postIt.state().equals(PostItStateType.DELETED)
                || postIt.state().equals(PostItStateType.MOVED))
                && !isUndo)){
            return null;
        }

        return postIt;
    }

    /**
     * Undo post it.
     *
     * @param postItRowp    the post it rowp
     * @param postItColumnp the post it columnp
     * @param boardIdp      the board idp
     * @param authUser      the auth user
     * @return the post it
     */
    public PostIt undoPostIt(String postItRowp,
                             String postItColumnp,
                             final Long boardIdp,
                             final User authUser) {
        Board board = boardRepository.ofIdentity(boardIdp)
                .get();

        postItRowp = checkIfIsRowEntryTitle(postItRowp, board);
        postItColumnp = checkIfIsColumnEntryTitle(postItColumnp, board);

        PostIt lastPostIt = postItByPosition(postItRowp, postItColumnp,
                board, true);

        Preconditions.ensure(!(lastPostIt == null ||
                        lastPostIt.state().equals(PostItStateType.MOVED)),
                "There is no post-it in this cell!");

        PostIt previousPostIt = lastPostIt.rollBackPostIt();

        checkForUserOwnership(authUser, board, lastPostIt);

        if(previousPostIt == null)
            throw new NoPreviousElementException(
                    "This post-it has no history");

        PostItState previousState = previousPostIt.state();

        PostItState newState = PostItStateType.UPDATED;

        if(previousState.equals(PostItStateType.DELETED)) {
            newState = PostItStateType.DELETED; // if the previous state was deleted
            // it must be deleted again
        }

        PostItFactory postItFactory = new PostItFactory();


        if(previousState.equals(PostItStateType.MOVED)) {
            lastPostIt = savePreviousPostItMoved(lastPostIt,
                    previousPostIt,
                    postItFactory);
        }

        PostIt newPostIt = postItFactory.createChange(
                previousPostIt.content(),
                previousPostIt.rowPos(),
                previousPostIt.columnPos(),
                previousPostIt.owner(),
                previousPostIt.board(),
                newState,
                lastPostIt);

        return this.postItRepository.save(newPostIt);
    }

    /**
     * If the undo-ing is a move,
     * the last post it must be
     * saved again with the moved state.
     *
     * @param lastPostIt
     * @param previousPostIt
     * @param postItFactory
     */
    private PostIt savePreviousPostItMoved(PostIt lastPostIt,
                                         PostIt previousPostIt,
                                         PostItFactory postItFactory) {

            Preconditions.ensure(
                    postItByPosition(
                            String.valueOf(previousPostIt.rowPos().value()),
                            String.valueOf(previousPostIt.columnPos().value()),
                            previousPostIt.board(),
                            false
                    ) == null,
                    "Unable to undo post-it since "
                            + "there is already another "
                            + "post-it in that cell."
            );

            PostIt movedPostIt = postItFactory.createChange(
                    lastPostIt.content(),
                    lastPostIt.rowPos(),
                    lastPostIt.columnPos(),
                    lastPostIt.owner(),
                    lastPostIt.board(),
                    PostItStateType.MOVED,
                    null
            );

            return this.postItRepository.save(movedPostIt);
    }

    private void checkForUserOwnership(User authUser, Board board, PostIt lastPostIt) {
        Preconditions.ensure(
                lastPostIt.owner().sameAs(authUser),
                "Only the owner of this post-it can change it!"
        );

        Preconditions.ensure(
                board.userHasPermission(authUser,
                        AccessLevelType.WRITE), "You don't have "
                        + AccessLevelType.WRITE + " permission"
        );
    }

    /**
     * Check if user write EntryTitle of board
     * @param postItRowp postItRowp
     * @param board board
     * @return String
     */
    private String checkIfIsRowEntryTitle(String postItRowp, Board board){
        if(!isNumeric(postItRowp)){
            String postItRow = board.findRowByEntryTitle(postItRowp);

            if(postItRow == null){
                throw new IllegalArgumentException("This board row doesn't exist");
            }

            return postItRow;
        }

        return postItRowp;
    }

    /**
     * Check if user write EntryTitle of board
     * @param postItColumnp postItColumnp
     * @param board board
     * @return String
     */
    private String checkIfIsColumnEntryTitle(String postItColumnp, Board board){
        if(!isNumeric(postItColumnp)){
            String postItColumn = board.findColumnByEntryTitle(postItColumnp);

            if(postItColumn == null){
                throw new IllegalArgumentException("This board column doesn't exist");
            }

            return postItColumn;
        }

        return postItColumnp;
    }

    /**
     * Is numeric.
     *
     * @param strNum the str num
     * @return the boolean
     */
    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }

        return pattern.matcher(strNum).matches();
    }

    public PostIt changePostItPosition(String previousPostItRowp,
                                       String previousPostItColumnp,
                                       String newPostItRowp,
                                       String newPostItColumnp,
                                       final String boardIdp,
                                       final User authUser) {
        Long boardId = Long.parseLong(boardIdp);
        Board board = boardRepository.ofIdentity(boardId).get();

        previousPostItRowp = checkIfIsRowEntryTitle(previousPostItRowp, board);
        previousPostItColumnp = checkIfIsColumnEntryTitle(previousPostItColumnp, board);

        PostIt lastPostIt = postItByPosition(
                previousPostItRowp,
                previousPostItColumnp,
                board,
                false);

        Preconditions.ensure(
                lastPostIt != null,
                "There is no post-it in this cell!");

        checkForUserOwnership(authUser, board, lastPostIt);

        newPostItRowp = checkIfIsRowEntryTitle(newPostItRowp, board);
        newPostItColumnp = checkIfIsColumnEntryTitle(newPostItColumnp, board);

        PostIt newPostItPosition = postItByPosition(
                newPostItRowp,
                newPostItColumnp,
                board,
                false);

        Preconditions.ensure(
                newPostItPosition == null,
                "Already exist a Post-It in that cell!");

        PostItFactory postItFactory = new PostItFactory();

        PostIt lastPostItMoved = postItFactory.createChange(
                lastPostIt.content().value(),
                previousPostItRowp,
                previousPostItColumnp,
                authUser,
                board,
                PostItStateType.MOVED,
                null);

        PostIt lastPostItSaved = postItRepository.save(lastPostItMoved);

        PostIt updatedPostIt = postItFactory.createChange(
                lastPostIt.content().value(),
                newPostItRowp,
                newPostItColumnp,
                authUser,
                board,
                PostItStateType.UPDATED,
                lastPostItSaved);

        return postItRepository.save(updatedPostIt);
    }
}
