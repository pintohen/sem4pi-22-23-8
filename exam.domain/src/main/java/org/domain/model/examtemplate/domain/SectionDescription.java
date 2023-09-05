package org.domain.model.examtemplate.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SectionDescription {

    @Column(name = "section_description")
    private String value;

    private SectionDescription(String value){
        this.value = value;
    }

    protected SectionDescription() {
        // for ORM
    }

    public static SectionDescription of(String value){
        return new SectionDescription(value);
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionDescription)) return false;
        SectionDescription that = (SectionDescription) o;
        return value.equals(that.value);
    }

    public String value() {
        return value;
    }
}
