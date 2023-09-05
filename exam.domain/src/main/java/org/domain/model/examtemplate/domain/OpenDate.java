package org.domain.model.examtemplate.domain;

import eapli.framework.validations.Preconditions;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Embeddable
public class OpenDate {

    @Column(name = "open_date", nullable = false)
    private LocalDateTime value;

    private OpenDate(String date){
        Preconditions.ensure(isValidFormat(date), "Invalid date format");
        Preconditions.nonNull(date);
        Preconditions.ensure(!date.isEmpty(), "Date cannot be empty.");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        LocalDateTime valueDate = LocalDateTime.parse(date, formatter);

        Preconditions.ensure(valueDate.isAfter(LocalDateTime.now()), "Date cannot be in the past.");

        this.value = valueDate;
    }

    protected OpenDate() {
        // for ORM
    }

    private static boolean isValidFormat(String date) {
        String regex = "^(\\d{2})-(\\d{2})-(\\d{4}) (\\d{2}):(\\d{2})$";
        return date.matches(regex);
    }

    public static OpenDate of(String date){
        return new OpenDate(date);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        return value.format(formatter);
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OpenDate)) return false;
        OpenDate that = (OpenDate) o;
        return value.equals(that.value);
    }

}
