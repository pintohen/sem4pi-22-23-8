package org.domain.model;

import eapli.framework.util.Utility;

import java.time.LocalDate;

@Utility
public class ClassDayOfWeekCalc {

    private ClassDayOfWeekCalc() {
        // utility class
    }

    public static ClassDayOfWeek calculate(final LocalDate date) {

        switch (date.getDayOfWeek()) {
            case MONDAY:
                return ClassDayOfWeek.MONDAY;
            case TUESDAY:
                return ClassDayOfWeek.TUESDAY;
            case WEDNESDAY:
                return ClassDayOfWeek.WEDNESDAY;
            case THURSDAY:
                return ClassDayOfWeek.THURSDAY;
            case FRIDAY:
                return ClassDayOfWeek.FRIDAY;
            case SATURDAY:
                throw new IllegalArgumentException("Saturday is not a valid day of the week.");
            case SUNDAY:
                throw new IllegalArgumentException("Sunday is not a valid day of the week.");
            default:
                throw new IllegalArgumentException("Unexpected value: " + date.getDayOfWeek());
        }
    }

    public static ClassDayOfWeek calculate(final Integer weekDay) {

        switch (weekDay) {
            case 1:
                return ClassDayOfWeek.MONDAY;
            case 2:
                return ClassDayOfWeek.TUESDAY;
            case 3:
                return ClassDayOfWeek.WEDNESDAY;
            case 4:
                return ClassDayOfWeek.THURSDAY;
            case 5:
                return ClassDayOfWeek.FRIDAY;
            case 6:
                throw new IllegalArgumentException("Saturday is not a valid day of the week.");
            case 7:
                throw new IllegalArgumentException("Sunday is not a valid day of the week.");
            default:
                throw new IllegalArgumentException("Unexpected value: " + weekDay);
        }
    }
    public static ClassDayOfWeek calculate(final String weekDay) {

        if(weekDay.equalsIgnoreCase("sunday")) {
            throw new IllegalArgumentException("Sunday is not a valid day of the week.");
        }
        else if (weekDay.equalsIgnoreCase("saturday")) {
            throw new IllegalArgumentException("Saturday is not a valid day of the week.");

        } else if (weekDay.equalsIgnoreCase("monday")) {
            return ClassDayOfWeek.MONDAY;

        } else if (weekDay.equalsIgnoreCase("tuesday")) {
            return ClassDayOfWeek.TUESDAY;

        } else if (weekDay.equalsIgnoreCase("wednesday")) {
            return ClassDayOfWeek.WEDNESDAY;

        } else if (weekDay.equalsIgnoreCase("thursday")) {
            return ClassDayOfWeek.THURSDAY;

        } else if (weekDay.equalsIgnoreCase("friday")) {
            return ClassDayOfWeek.FRIDAY;

        } else {
            throw new IllegalArgumentException("Unexpected value: " + weekDay);
        }
    }

}
