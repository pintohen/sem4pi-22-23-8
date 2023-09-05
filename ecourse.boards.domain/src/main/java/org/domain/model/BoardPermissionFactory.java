package org.domain.model;

import org.usermanagement.domain.model.User;

public class BoardPermissionFactory {
    /**
     * BoardPermissionFactory constructor.
     */
    public BoardPermissionFactory() {

    }

    /**
     * Create a BoardPermission.
     * @param userp
     * @param accessLevelp
     * @return BoardPermission
     */
    public BoardPermission create(final User userp,
                        final AccessLevel accessLevelp) {
        return new BoardPermission(
                userp,
                accessLevelp
        );
    }
}
