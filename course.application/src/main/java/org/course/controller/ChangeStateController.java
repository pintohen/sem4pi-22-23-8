package org.course.controller;


import eapli.framework.application.UseCaseController;
import org.authz.application.AuthorizationService;
import org.course.service.CourseManagementService;
import org.domain.model.*;
import org.domain.repositories.CourseRepository;
import org.persistence.PersistenceContext;
import org.usermanagement.domain.repositories.UserRepository;

@UseCaseController
public class ChangeStateController {


    /**
     * The authorization service for managing user authorization.
     */
    private final AuthorizationService authz;
    /**
     * The repository for managing course entities.
     */
    private final CourseRepository repo;

    /**
     * The repository for managing user entities.
     */
    private final UserRepository userRepo;

    /**
     * The service for creating course entities.
     */
    private final CourseManagementService service;

    public ChangeStateController(UserRepository userRepo,
                                 CourseRepository repo,
                                 AuthorizationService authz){
        this.authz = authz;
        this.userRepo = userRepo;
        this.repo = repo;
        service = new CourseManagementService(userRepo, repo, PersistenceContext.repositories().newTransactionalContext(), authz);
    }

    public Course verifyCourse(String course){
        return repo.findByCode(CourseCode.of(course)).get();
    }

    public boolean confirmForEnrollment(Course course){
        return service.confirmForEnrollment(course);
    }
    public boolean confirmForOpenClose(Course course){
        return service.confirmForOpenClose(course);
    }

    public Course changeState(Course course){
        return service.changeState(course);
    }
}
