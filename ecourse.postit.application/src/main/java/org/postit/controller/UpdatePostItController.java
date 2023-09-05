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
 * The type Update post it controller.
 */
public class UpdatePostItController {
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
     * Instantiates UpdatePostItController.
     */
    public UpdatePostItController() {
        authz = AuthzRegistry.authorizationService();
    }

    /**
     * Update post-it content.
     * @param postItContentp the post-it contentp
     * @param postItRowp     the post-it rowp
     * @param postItColumnp  the post-it columnp
     * @param boardIdp       the board idp
     * @return the post-it
     */
    public PostIt updatePostItContent(final String postItContentp,
                                      final String postItRowp,
                                      final String postItColumnp,
                                      final String boardIdp) {
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.allRoles());

        return postItSvc.changePostIt(postItContentp, postItRowp, postItColumnp,
                boardIdp, authz.session().get().authenticatedUser(),
                PostItStateType.UPDATED);
    }

    /**
     * Update post-it content.
     * @param postItContentp the post-it contentp
     * @param postItRowp     the post-it rowp
     * @param postItColumnp  the post-it columnp
     * @param boardIdp       the board idp
     * @param authUser       the auth user
     * @return the postit
     */
    public PostIt updatePostItContent(final String postItContentp,
                                      final String postItRowp,
                                      final String postItColumnp,
                                      final String boardIdp,
                                      final User authUser) {
        Preconditions.ensure(authUser != null,
                "You need to authenticate first");

        return postItSvc.changePostIt(postItContentp, postItRowp, postItColumnp,
                boardIdp, authUser, PostItStateType.UPDATED);
    }

    /**
     * Update post-it position.
     * @param previousPostItRowp    the previous post-it rowp
     * @param previousPostItColumnp the previous post-it columnp
     * @param newPostItRowp         the new post-it rowp
     * @param newPostItColumnp      the new post-it columnp
     * @param boardIdp              the board idp
     * @return the post it
     */
    public PostIt updatePostItPosition(final String previousPostItRowp,
                                       final String previousPostItColumnp,
                                       final String newPostItRowp,
                                       final String newPostItColumnp,
                                       final String boardIdp) {
        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.allRoles());

        return postItSvc.changePostItPosition(
                previousPostItRowp, previousPostItColumnp,
                newPostItRowp, newPostItColumnp,
                boardIdp, authz.session().get().authenticatedUser());
    }

    /**
     * Update post-it position.
     * @param previousPostItRowp    the previous post-it rowp
     * @param previousPostItColumnp the previous post-it columnp
     * @param newPostItRowp         the new post-it rowp
     * @param newPostItColumnp      the new post-it columnp
     * @param boardIdp              the board idp
     * @param authUser              the auth user
     * @return the post it
     */
    public PostIt updatePostItPosition(final String previousPostItRowp,
                                       final String previousPostItColumnp,
                                       final String newPostItRowp,
                                       final String newPostItColumnp,
                                       final String boardIdp,
                                       final User authUser) {
        Preconditions.ensure(authUser != null,
                "You need to authenticate first");

        return postItSvc.changePostItPosition(
                previousPostItRowp, previousPostItColumnp,
                newPostItRowp, newPostItColumnp,
                boardIdp, authUser);
    }
}
