package org.domain.model;

import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalTime;

@Embeddable
public class ClassTime {

    /**
     * The start time of the class.
     */
    @Column(name = "start_time", columnDefinition = "TIME")
    private final LocalTime startTime;

    /**
     * The end time of the class.
     */
    @Column(name = "end_time", columnDefinition = "TIME")
    private final LocalTime endTime;

    /**
     * The duration of the class.
     */
    @Column(name = "duration")
    private Integer duration;

    /**
     * Empty constructor for ORM.
     */
    protected ClassTime() {
        startTime = null;
        endTime = null;
        duration = 0;
    }

    /**
     * Creates a new ClassTime.
     * @param startTime - the start time of the class.
     * @param endTime - the end time of the class.
     */
    private ClassTime(final LocalTime startTime, final LocalTime endTime) {

        Preconditions.noneNull(startTime, endTime);
        Preconditions.ensure(startTime.isBefore(LocalTime.of(21, 0)), "Start time must be before 21:00.");
        Preconditions.ensure(startTime.isAfter(LocalTime.of(6, 0)), "Start time must be after 06:00.");
        Preconditions.ensure(endTime.isBefore(LocalTime.of(22, 0)), "End time must be before 22:00.");
        Preconditions.ensure(endTime.isAfter(LocalTime.of(7, 0)), "End time must be after 07:00.");
        Preconditions.ensure(startTime.isBefore(endTime), "Start time must be before end time.");

        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = calculateDuration(startTime, endTime);

        Preconditions.ensure(duration >= 60 && duration <= 240, "Duration of the class must be between 1 and 4 hours,");
    }

    /**
     * Creates a new ClassTime.
     * @param time - the time of the class.
     */
    private ClassTime(final LocalTime time) {

        Preconditions.noneNull(time);
        Preconditions.ensure(time.isBefore(LocalTime.of(22, 0)), "The class must be before 22:00.");
        Preconditions.ensure(time.isAfter(LocalTime.of(6, 0)), "The class must be after 06:00.");

        this.startTime = time;
        this.endTime = time;
    }

    /**
     * Calculates the duration of the class.
     * @param startTime - the start time of the class.
     * @param endTime - the end time of the class.
     * @return - the duration of the class.
     */
    public Integer calculateDuration(final LocalTime startTime, final LocalTime endTime) {
        int duration = (endTime.getHour() - startTime.getHour()) * 60;
        duration += endTime.getMinute() - startTime.getMinute();
        return duration;
    }

    /**
     * Creates a new ClassTime.
     * @param startTime - the start time of the class.
     * @return - the new ClassTime.
     */
    public static ClassTime ofStart(final String startTime) {
        return new ClassTime(LocalTime.parse(startTime));
    }

    /**
     * Creates a new ClassTime.
     * @param endTime - the end time of the class.
     * @return - the new ClassTime.
     */
    public static ClassTime ofEnd(final String endTime) {
        return new ClassTime(LocalTime.parse(endTime));
    }

    /**
     * Creates a new ClassTime.
     * @param startTime - the start time of the class.
     * @param endTime - the end time of the class.
     * @return - the new ClassTime.
     */
    public static ClassTime of(final String startTime, final String endTime) {
        return new ClassTime(LocalTime.parse(startTime), LocalTime.parse(endTime));
    }

    /**
     * Value of startTime.
     */
    public LocalTime startTime() {
        return startTime;
    }

    /**
     * Value of endTime.
     */
    public LocalTime endTime() {
        return endTime;
    }

    /**
     * Value of duration.
     */
    public Integer duration() {
        return duration;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassTime)) return false;

        ClassTime classTime = (ClassTime) o;

        if (!startTime.equals(classTime.startTime)) return false;
        return endTime.equals(classTime.endTime);
    }

    public String valueStartTime() {
        return startTime.toString();
    }

    public String valueEndTime() {
        return endTime.toString();
    }

    public String toString() {
        return startTime.toString() + " - " + endTime.toString();
    }

    public boolean overlaps(ClassTime time) {
        return (
                this.startTime.isBefore(time.endTime) && this.startTime.isAfter(time.startTime)
                        || this.endTime.isAfter(time.startTime) && this.endTime.isBefore(time.endTime)
                        || this.startTime.equals(time.startTime) && this.endTime.equals(time.endTime)
        );
    }
}
