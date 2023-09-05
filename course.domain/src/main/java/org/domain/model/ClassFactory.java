package org.domain.model;

import org.usermanagement.domain.model.User;

import javax.persistence.Embeddable;
import java.util.Set;

@Embeddable
public class ClassFactory {

    public ClassFactory() {
    }

    public Class createClass(String classTitle,
                             String classDayOfWeek,
                             String startTime,
                             String endTime,
                             User teacher,
                             Set<User> students) {

        return new Class(ClassTitle.of(classTitle),
                ClassDayOfWeekCalc.calculate(classDayOfWeek),
                ClassTime.of(startTime, endTime),
                teacher,
                students);
    }
}
