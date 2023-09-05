package org.domain.model.postit;

/**
 * All users can create and use boards as well as meetings.
 */
public final class PostItStateType {

    /**
     * Ensures Utility class.
     */
    private PostItStateType() {
        // utility class
    }
    /**
     * User create a new post-it in a free cell.
     */
    public static final PostItState CREATED = PostItState.valueOf("CREATED");

    /**
     * User updated a post-it that already exist.
     */
    public static final PostItState UPDATED = PostItState.valueOf("UPDATED");

    /**
     * User moved a post-it to another cell.
     */
    public static final PostItState MOVED = PostItState.valueOf("MOVED");

    /**
     * User deleted post-it.
     */
    public static final PostItState DELETED = PostItState.valueOf("DELETED");

    /**
     * Get available post-it state in post-it.
     * @return all PostItState types
     */
    public static PostItState[] allPostItStateTypes() {
        return new PostItState[] {CREATED, UPDATED, MOVED, DELETED};
    }
}
