package org.domain.model;

import org.domain.repositories.CourseRepository;
import org.usermanagement.domain.model.User;
import org.usermanagement.domain.repositories.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CourseFactory {

    public CourseFactory(){

    }
    public Course createCourse(final String name,
                               final String code,
                               final String edition,
                               final String description,
                               final Integer max,
                               final Integer min,
                               final User headTeacher){
        return new Course(CourseName.of(name),
                CourseCode.of(code),
                CourseEdition.of(edition),
                CourseDescription.of(description),
                CourseStateConstants.CLOSED,
                CourseMaxNumberLimit.of(max),
                CourseMinNumberLimit.of(min),
                headTeacher,
                new HashSet<>(),
                new HashSet<>()
        );
    }
}
