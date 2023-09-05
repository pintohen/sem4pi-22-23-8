package org.domain.model;

import org.usermanagement.domain.model.User;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "T_BOARD_PERMISSION")
public class BoardPermission
        implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Version of board.
     */
    @Version
    private Long version;

    /**
     * Board Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardPermissionId;

    /**
     * User that have permission in specific board.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_email")
    private User user;

    /**
     * Board title.
     */
    private AccessLevel accessLevel;


    protected BoardPermission() {

    }

    BoardPermission(final User userp,
                    final AccessLevel accessLevelp) {
        this.user = userp;
        this.accessLevel = accessLevelp;
    }

    /**
     * User that have a specific permission in board.
     * @return User
     */
    public User userWithPermission() {
        return user;
    }

    /**
     * Type of permission in board.
     * @return AccessLevel
     */
    public AccessLevel accessLevel() {
        return accessLevel;
    }

    public AccessLevel changeAccess(AccessLevel newLevel){
        accessLevel=newLevel;

        return accessLevel;
    }
    /**
     * Check if some BoardPermission is the same object then other.
     * @param other
     * @return true/false
     */
    public boolean sameAs(final Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof BoardPermission)) {
            return false;
        }

        BoardPermission that = (BoardPermission) other;

        return Objects.equals(this.boardPermissionId, that.boardPermissionId)
                && Objects.equals(this.user, that.user)
                && this.accessLevel == that.accessLevel;
    }

    /**
     * @return boardPermissionId
     */
    public Long identity() {
        return boardPermissionId;
    }
}
