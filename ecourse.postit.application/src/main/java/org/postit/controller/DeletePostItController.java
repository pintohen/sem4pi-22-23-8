package org.postit.controller;

import eapli.framework.validations.Preconditions;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.domain.model.postit.PostIt;
import org.domain.model.postit.PostItStateType;
import org.persistence.PersistenceContext;
import org.postit.service.PostItService;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;

/**
 * The type Delete post it controller.
 */
public class DeletePostItController {
    /**
     * Authorization service instance.
     */
    private final AuthorizationService authz;

    /**
     * Create a postIt service with repository injection.
     */
    private final PostItService postItSvc = new PostItService(
            PersistenceContext.repositories().postIt(),
            PersistenceContext.repositories().boards());

    /**
     * Instantiates DeletePostItController.
     */
    public DeletePostItController() {
        authz = AuthzRegistry.authorizationService();
    }

    /**
     * Delete post-it.
     * @param postItRowp    the post-it rowp
     * @param postItColumnp the post-it columnp
     * @param boardIdp      the board idp
     * @return the post-it
     */
    public PostIt deletePostIt(final String postItRowp,
                               final String postItColumnp,
                               final String boardIdp) {
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.allRoles());

        return postItSvc.changePostIt(PostItStateType.DELETED.toString(),
                postItRowp, postItColumnp,
                boardIdp, authz.session().get().authenticatedUser(),
                PostItStateType.DELETED);
    }

    /**
     * Delete post-it.
     * @param postItRowp    the post-it rowp
     * @param postItColumnp the post-it columnp
     * @param boardIdp      the board idp
     * @param authUser      the auth user
     * @return the post-it
     */
    public PostIt deletePostIt(final String postItRowp,
                               final String postItColumnp,
                               final String boardIdp,
                               final User authUser) {
        Preconditions.ensure(authUser != null,
                "You need to authenticate first");

        return postItSvc.changePostIt(PostItStateType.DELETED.toString(),
                postItRowp, postItColumnp,
                boardIdp, authUser, PostItStateType.DELETED);
    }
}
