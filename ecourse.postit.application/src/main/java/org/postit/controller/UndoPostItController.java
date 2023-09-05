package org.postit.controller;

import eapli.framework.validations.Preconditions;
import org.authz.application.AuthorizationService;
import org.authz.application.AuthzRegistry;
import org.domain.model.postit.PostIt;
import org.persistence.PersistenceContext;
import org.postit.service.PostItService;
import org.springframework.stereotype.Controller;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;

@Controller
public class UndoPostItController {

    private final PostItService service = new PostItService(
            PersistenceContext.repositories().postIt(),
            PersistenceContext.repositories().boards()
    );

    private final AuthorizationService authz = AuthzRegistry.authorizationService();


    public PostIt undoPostIt(String row,
                             String column,
                             String boardId,
                             User authenticated){
        Preconditions.ensure(authenticated != null,
                "User must be authenticated");



        return this.service.undoPostIt(row, column, Long.parseLong(boardId), authenticated);
    }

    public PostIt undoPostIt(String row,
                             String column,
                             String boardId){

        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.allRoles());


        return this.service.undoPostIt(row,
                column,
                Long.parseLong(boardId),
                authz.session()
                        .get()
                        .authenticatedUser());
    }
}
