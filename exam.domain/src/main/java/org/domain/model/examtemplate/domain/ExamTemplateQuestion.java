package org.domain.model.examtemplate.domain;

import org.domain.model.Answer;
import org.domain.model.QuestionDescription;
import org.domain.model.QuestionType;
import org.domain.model.Solution;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "T_EXAM_TEMPLATE_QUESTION")
public class ExamTemplateQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exam_template_question_id")
    private Long id;

    private QuestionDescription description;

    @Enumerated(EnumType.STRING)
    private QuestionType type;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_template_question_id")
    private List<Answer> options;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "exam_template_question_id")
    private List<Solution> solutions;

    private ExamTemplateQuestion(
            QuestionDescription description,
            QuestionType type
    ){
        this.description = description;
        this.type = type;
    }

    public static ExamTemplateQuestion of(
            QuestionDescription description,
            QuestionType type
    ){
        return new ExamTemplateQuestion(description, type);
    }

    protected ExamTemplateQuestion() {
       // for ORM
    }

    public void setOptions(List<Answer> options) {
        this.options = options;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }

    public QuestionDescription description() {
        return this.description;
    }

    public QuestionType type() {
        return this.type;
    }

    public List<Answer> options() {
        return this.options;
    }

    public List<Solution> solutions() {
        return this.solutions;
    }
}
