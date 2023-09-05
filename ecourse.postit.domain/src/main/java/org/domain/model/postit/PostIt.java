package org.domain.model.postit;

import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.time.util.CurrentTimeCalendars;
import org.domain.model.Board;
import org.usermanagement.domain.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

/**
 * The type Post it.
 */
@Entity
@Table(name = "T_POST_IT")
public class PostIt
        implements AggregateRoot<Long>,
        Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Version of board.
     */
    @Version
    private Long version;

    /**
     * Post-It Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postItId;

    /**
     * Date when user created post-it.
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar postItTimeStamp;

    /**
     * Post-It content.
     */
    private PostItContent postItContent;

    /**
     * Post-It row position.
     */
    private PostItRow postItRow;

    /**
     * Post-It Column position.
     */
    private PostItColumn postItColumn;

    /**
     * CREATED, UPDATED, MOVED, DELETED.
     */
    private PostItState postItState;

    /**
     * Post-It Owner.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_email")
    private User postItOwner;

    /**
     * Post-It Board.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board boardId;

    /**
     * Moved from post it.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "last_post_it")
    private PostIt lastPostIt;

    /**
     * Instantiates a new Post-It.
     */
    protected PostIt() {

    }

    /**
     * Instantiates a new Post-It.
     * @param postItContentp the post-it contentp
     * @param postItRowp     the post-it rowp
     * @param postItColumnp  the post-it columnp
     * @param postItOwnerp   the post-it ownerp
     * @param boardIdp       the board idp
     * @param postItStatep   the post-it state
     */
    PostIt(final PostItContent postItContentp,
           final PostItRow postItRowp,
           final PostItColumn postItColumnp,
           final User postItOwnerp,
           final Board boardIdp,
           final PostItState postItStatep) {
        this.postItContent = postItContentp;
        this.postItRow = postItRowp;
        this.postItColumn = postItColumnp;
        this.postItOwner = postItOwnerp;
        this.boardId = boardIdp;
        this.postItState = postItStatep;
        this.postItTimeStamp = CurrentTimeCalendars.now();
    }

    /**
     * Instantiates a new Post-It.
     * @param postItContentp the post-it contentp
     * @param postItRowp     the post-it rowp
     * @param postItColumnp  the post-it columnp
     * @param postItOwnerp   the post-it ownerp
     * @param boardIdp       the board idp
     * @param postItStatep   the post-it state
     * @param lastPostItp    the last post-it
     */
    PostIt(final PostItContent postItContentp,
           final PostItRow postItRowp,
           final PostItColumn postItColumnp,
           final User postItOwnerp,
           final Board boardIdp,
           final PostItState postItStatep,
           final PostIt lastPostItp) {
        this.postItContent = postItContentp;
        this.postItRow = postItRowp;
        this.postItColumn = postItColumnp;
        this.postItOwner = postItOwnerp;
        this.boardId = boardIdp;
        this.postItState = postItStatep;
        this.postItTimeStamp = CurrentTimeCalendars.now();
        this.lastPostIt = lastPostItp;
    }

    /**
     * Get Post-It content.
     * @return PostItContent post-it content
     */
    public PostItContent content() {
        return postItContent;
    }

    /**
     * Get Post-It column.
     * @return PostItColumn post-it column
     */
    public PostItColumn columnPos() {
        return postItColumn;
    }

    /**
     * Get Post-It row.
     * @return PostItRow post-it row
     */
    public PostItRow rowPos() {
        return postItRow;
    }

    /**
     * Get Post-It owner.
     * @return User post-it owner
     */
    public User owner() {
        return postItOwner;
    }

    /**
     * Get Post-It board.
     * @return Board post-it board
     */
    public Board board() {
        return boardId;
    }

    /**
     * Get Post-It state.
     * @return CREATED, UPDATED, MOVED, DELETED
     */
    public PostItState state() {
        return postItState;
    }

    public PostIt rollBackPostIt(){
        return lastPostIt;
    }

    /**
     * Format the timestamp
     * @return String timestamp
     */

    public String formatTimestamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return sdf.format(this.postItTimeStamp.getTime());
    }

    /**
     * Check if some Board is the same object then other.
     * @param other
     * @return true/false
     */
    @Override
    public boolean sameAs(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof PostIt)) {
            return false;
        }

        PostIt that = (PostIt) other;

        return Objects.equals(postItId, that.postItId)
                && Objects.equals(postItTimeStamp, that.postItTimeStamp)
                && Objects.equals(postItContent, that.postItContent)
                && Objects.equals(postItRow, that.postItRow)
                && Objects.equals(postItColumn, that.postItColumn)
                && postItState == that.postItState
                && Objects.equals(postItOwner, that.postItOwner)
                && Objects.equals(boardId, that.boardId);
    }

    /**
     * Get postItId.
     * @return postItId
     */
    @Override
    public Long identity() {
        return postItId;
    }
}
