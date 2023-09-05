package org.domain.model.template.formative.question;

import eapli.framework.domain.model.AggregateRoot;
import org.domain.model.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_TEMPLATE_FORMATIVE_QUESTION")
public class TemplateFormativeQuestion implements AggregateRoot<Long> {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "formative_question_id")
    private Long id;

    private QuestionDescription description;

    @Enumerated(EnumType.STRING)
    private QuestionType type;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "formative_question_id")
    private List<Answer> options;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "formative_question_id")
    private List<Solution> solutions;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Course course;

    public TemplateFormativeQuestion(
            QuestionDescription description,
            QuestionType type,
            List<Answer> options,
            List<Solution> solutions,
            Course course
    ) {
        this.description = description;
        this.type = type;
        this.options = options;
        this.solutions = solutions;
        this.course = course;
    }

    protected TemplateFormativeQuestion() {
        // for ORM only
    }

    @Override
    public boolean sameAs(Object other) {
        TemplateFormativeQuestion otherQuestion = (TemplateFormativeQuestion) other;
        return this.id.equals(otherQuestion.id);
    }

    @Override
    public Long identity() {
        return id;
    }
}
