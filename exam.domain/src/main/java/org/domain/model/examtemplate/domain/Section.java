package org.domain.model.examtemplate.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_SECTION")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "section_number")
    private Long number;

    private SectionDescription description;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExamTemplateQuestion> questions;

    public Section(Long number, SectionDescription description){
        this.number = number;
        this.description = description;
    }

    public Section() {
        // for ORM
    }

    public void setQuestions(List<ExamTemplateQuestion> questions){
        this.questions = questions;
    }

    public SectionDescription description() {
        return this.description;
    }

    public List<ExamTemplateQuestion> questions() {

        questions.get(0);

        return this.questions;

    }
}
