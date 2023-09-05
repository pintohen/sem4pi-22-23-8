package org.domain.model;

/**
 * All users can create and use boards as well as meetings.
 */
public final class AccessLevelType {

    /**
     * Ensures Utility class.
     */
    private AccessLevelType() {
        // utility class
    }
    /**
     * Can read and write in board.
     */
    public static final AccessLevel WRITE = AccessLevel.valueOf("WRITE");

    /**
     * Can read but can't write in board.
     */
    public static final AccessLevel READ = AccessLevel.valueOf("READ");

    /**
     * Get available access level type in board.
     * @return all AccessLevel types
     */
    public static AccessLevel[] allAccessLevelTypes() {
        return new AccessLevel[] {WRITE, READ};
    }
}
