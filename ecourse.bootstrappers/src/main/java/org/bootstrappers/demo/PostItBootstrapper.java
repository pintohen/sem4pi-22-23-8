package org.bootstrappers.demo;

import eapli.framework.actions.Action;
import eapli.framework.domain.repositories.IntegrityViolationException;
import exceptions.NoPreviousElementException;
import org.domain.model.postit.PostIt;
import org.postit.controller.CreatePostItController;
import org.postit.controller.DeletePostItController;
import org.postit.controller.UndoPostItController;
import org.postit.controller.UpdatePostItController;

import java.util.NoSuchElementException;

public class PostItBootstrapper implements Action {
    CreatePostItController theController = new CreatePostItController();
    UpdatePostItController updateController = new UpdatePostItController();
    DeletePostItController deleteController = new DeletePostItController();

    UndoPostItController undoController = new UndoPostItController();
    @Override
    public boolean execute() {
        registerPostIt("Content Post-It 1", "Title Row 2", "Title Column 3", "1");
        registerPostIt("Content Post-It 2", "Title Row 2", "Title Column 2", "1");
        registerPostIt("Content Post-It 3", "Title Row 3", "Title Column 3", "1");
        registerPostIt("Content Post-It 4", "2", "2", "4");
        registerPostIt("Content Post-It 5", "2", "3", "4");
        registerPostIt("Content Post-It 6", "3", "3", "4");

        updatePostItContent("Update Post-It 1", "Title Row 2", "Title Column 3", "1");
        updatePostItContent("Update Post-It 2", "Title Row 2", "Title Column 2", "1");
        updatePostItContent("Update Post-It 3", "Title Row 3", "Title Column 3", "1");
        updatePostItContent("Update Post-It 4", "2", "2", "4");
        updatePostItContent("Update Post-It 5", "2", "3", "4");
        updatePostItContent("Update Post-It 6", "3", "3", "4");

        deletePostIt("Title Row 2", "Title Column 3", "1");
        deletePostIt("2", "2", "4");
        deletePostIt("2", "3", "4");

        rollbackPostIt("2", "2", "4");
        rollbackPostIt("3", "3", "4");
        rollbackPostIt("2", "2", "4");


        updatePostItPosition("Title Row 2", "Title Column 2", "Title Row 2", "Title Column 3", "1");
        updatePostItPosition("3", "3", "2", "3", "4");

        return true;
    }


    private void registerPostIt(final String postItContentp,
                                final String postItRowp,
                                final String postItColumnp,
                                final String boardIdp) {
        try{
            PostIt postIt = theController.createPostIt(postItContentp,
                  postItRowp, postItColumnp, boardIdp);

            System.out.println("[+] Post-It Id - " + postIt.identity());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (IntegrityViolationException e){
            System.out.println("Already exist --> Post-It Row " + postItRowp
                    + " Post-It Column --> " + postItColumnp
                    + " Board --> " + boardIdp);
        } catch (NoSuchElementException e){
            System.out.println("Board with that id doesn't exist");
        }
    }

    private void updatePostItContent(final String postItContentp,
                                     final String postItRowp,
                                     final String postItColumnp,
                                     final String boardIdp){
        try{
            PostIt postIt = updateController.updatePostItContent(postItContentp,
                    postItRowp, postItColumnp, boardIdp);

            System.out.println("[+] Post-It Id - " + postIt.identity());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e){
            System.out.println("Board with that id doesn't exist");
        }
    }

    private void deletePostIt(final String postItRowp,
                              final String postItColumnp,
                              final String boardIdp){
        try{
            PostIt postIt = deleteController.deletePostIt(postItRowp,
                    postItColumnp, boardIdp);

            System.out.println("[+] Post-It Id - " + postIt.identity());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e){
            System.out.println("Board with that id doesn't exist");
        }
    }

    private void rollbackPostIt(
            final String postItRowp,
            final String postItColumnp,
            final String boardIdp){
        try{
            PostIt postIt = undoController.undoPostIt(postItRowp,
                    postItColumnp, boardIdp);

            System.out.println("[+] Post-It Id - " + postIt.identity());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e){
            System.out.println("Board with that id doesn't exist");
        } catch(NoPreviousElementException e){
            System.out.println("There is no previous version of this post-it");
        }
    }

    private void updatePostItPosition(final String previousPostItRowp,
                                      final String previousPostItColumnp,
                                      final String newPostItRowp,
                                      final String newPostItColumnp,
                                      final String boardIdp){
        try{
            PostIt postIt = updateController.updatePostItPosition(
                    previousPostItRowp, previousPostItColumnp,
                    newPostItRowp, newPostItColumnp, boardIdp);

            System.out.println("[+] Post-It Id - " + postIt.identity());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (NoSuchElementException e){
            System.out.println("Board with that id doesn't exist");
        }
    }
}
