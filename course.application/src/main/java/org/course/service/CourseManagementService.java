package org.course.service;

import eapli.framework.domain.repositories.TransactionalContext;
import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.validations.Preconditions;
import org.authz.application.AuthorizationService;
import org.domain.model.*;
import org.domain.model.Class;
import org.domain.repositories.CourseRepository;
import org.springframework.stereotype.Service;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.repositories.UserRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.StreamSupport;

@Service
public class CourseManagementService{
    private final ClassFactory classFactory = new ClassFactory();

    private final UserRepository userRepo;
    private final CourseRepository courseRepo;

    private final TransactionalContext txt;

    private final AuthorizationService authz;

    private final CourseFactory factory = new CourseFactory();
    public CourseManagementService(UserRepository userRepo, CourseRepository courseRepo, TransactionalContext txt, AuthorizationService authz) {
        this.userRepo = userRepo;
        this.courseRepo = courseRepo;
        this.txt = txt;
        this.authz = authz;
    }
    public Course createCourse(final String name,
                               final String code,
                               final String edition,
                               final String description,
                               final Integer max,
                               final Integer min,
                               final User headTeacher){
        Course course = factory.createCourse(name,
                code,
                edition,
                description,
                max,
                min,
                headTeacher);

        return courseRepo.save(course);
    }
    public Course addStudent(String emailStudent, String c){
        txt.beginTransaction();

        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.MANAGER);

        User student = userRepo.findUserByEmail(EmailAddress.valueOf(emailStudent))
                .orElse(null);

        Course course = courseRepo.findByCode(CourseCode.of(c)).
                orElse(null);

        Preconditions.nonNull(course, "Course with code " + c + " does not exist");

        course.addStudent(student);

        txt.commit();

        return courseRepo.save(course);
    }

    public Course addTeacher(String emailTeacher, String c){
        txt.beginTransaction();

        authz.ensureAuthenticatedUserHasAnyOf(CourseRoles.MANAGER);

        User teacher = userRepo.findUserByEmail(EmailAddress.valueOf(emailTeacher))
                .orElse(null);

        Course course = courseRepo.findByCode(CourseCode.of(c)).
                orElse(null);

        Preconditions.nonNull(course, "Course with code " + c + " does not exist");

        course.addTeacher(teacher);

        txt.commit();

        return courseRepo.save(course);
    }

    public Course addTeacher(User user, Course c){
        c.addTeacher(user);

        return courseRepo.save(c);
    }

    public boolean confirmForEnrollment(Course c){
        if(c.state().toString().equals(String.valueOf(CourseStateConstants.OPEN))||
                c.state().toString().equals(String.valueOf(CourseStateConstants.ENROLL))){
            return true;
        }else{
            throw new IllegalArgumentException("This course is in the state " + c.state().toString() + ", so it can't be changed");
        }
    }
    public boolean confirmForOpenClose(Course c){
        if(c.state().toString().equals(String.valueOf(CourseStateConstants.CLOSED))||
                c.state().toString().equals(String.valueOf(CourseStateConstants.IN_PROGRESS))){
            return true;
        }else{
            throw new IllegalArgumentException("This course is in the state " + c.state().toString() + ", so it can't be changed");
        }
    }
    public Course changeState(Course c){
        txt.beginTransaction();
        CourseState state = c.state();

        if(state.equals(CourseStateConstants.CLOSED)) {

            c.changeState(CourseStateConstants.OPEN);

        } else if(state.equals(CourseStateConstants.OPEN)) {

            c.changeState(CourseStateConstants.ENROLL);

        } else if(state.equals(CourseStateConstants.ENROLL)) {

            c.changeState(CourseStateConstants.IN_PROGRESS);

        } else {
            c.changeState(CourseStateConstants.CLOSED);
        }

        txt.commit();

        return courseRepo.save(c);
    }


    public Course changeState(CourseCode courseCode, CourseState state) {
        txt.beginTransaction();

        Course course = courseRepo.findByCode(courseCode).orElse(null);
        Preconditions.ensure(
                course != null,
                "Course with code " + courseCode + " does not exist"
        );

        course.changeState(state);

        txt.commit();

        return courseRepo.save(course);
    }

    public Course scheduleNewClass(String courseCode,
                                   String classTitle,
                                   String classDayOfWeek,
                                   String classStartTime,
                                   String classEndTime,
                                   User teacher) {
        Course course = courseRepo.findByCode(CourseCode.of(courseCode)).
                orElse(null);
        Preconditions.nonNull(course, "Course with code " + courseCode + " does not exist");

        Preconditions.ensure(
                course.containtsTeacher(teacher),
                "You can not add a class to course " + courseCode + " because you are not a teacher there"
        );

        Class newClass = classFactory.createClass(classTitle, classDayOfWeek, classStartTime, classEndTime, teacher, course.students());

        Iterable<Class> classesThatITeach = courseRepo.findClassesThatITeach(teacher);

        Preconditions.ensure(
                StreamSupport.stream(classesThatITeach.spliterator(), false)
                        .noneMatch(c -> c.overlaps(newClass)),
                "You are already teaching a class at that time"
        );

        course.addClass(newClass);

        return courseRepo.save(course);
    }

    public Set<User> getTeachersAvailable(Course course){
        Set<User> inCourse = course.teachers();

        Set<User> allTeachersAvailable = new HashSet<>();

        Set<User> allUsers = getTeachers();

        for(User user: allUsers){
            int count = 0;

            for(User inUser : inCourse){
                if(user.emailAddress().toString().equals(inUser.emailAddress().toString())){
                    count++;
                    break;
                }
            }

            if(count==0){
                allTeachersAvailable.add(user);
            }
        }

        return allTeachersAvailable;
    }

    public Set<User> getTeachers(){
        Set<User> users = new HashSet<>();

        for(User user: userRepo.findAll()){
            if(user.role().equals(CourseRoles.TEACHER.toString())){
                users.add(user);
            }
        }

        return users;
    }
}