package org.domain.model;

import javax.persistence.*;

@Entity
@Table(name = "T_ANSWER")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    private Long id;

    @Column(name = "answer", nullable = false)

    private String value;

    public Answer(String value) {
        this.value = value;
    }

    public Answer() {
        // for ORM
        this.value = null;
    }

    public String value() {
        return value;
    }
}
