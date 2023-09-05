package org.domain.model.exam;

import eapli.framework.validations.Preconditions;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.domain.model.QuestionType;
import org.domain.model.Solution;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.domain.model.examtemplate.domain.ExamTemplateQuestion;
import org.user.management.CourseRoles;
import org.usermanagement.domain.model.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExamBuilder extends ExamBaseListener{
    private ExamTemplate examTemplate;
    private Double grade = 0.0;
    private User student;

    private int currentSection = 0;

    private int currentQuestion = 0;

    private Double totalGrade = 0.0;

    @Override
    public void enterExam_header(ExamParser.Exam_headerContext ctx) {
        Preconditions.ensure(
                ctx.NAME().getText().replaceAll("\"", "").equals(examTemplate.identity().value()),
                "Invalid Exam Submission.\nTry again."
        );
    }

    @Override
    public void enterSection(ExamParser.SectionContext ctx) {
        String sectionTitle = examTemplate.sections().get(currentSection).description().value();

        String titleReceived = ctx.NAME().getText().replaceAll("\"", "");
        Preconditions.ensure(
                titleReceived.equals(sectionTitle),
                "Invalid Exam Submission.\nTry again."
        );
    }

    @Override
    public void exitSection(ExamParser.SectionContext ctx) {
        currentSection++;
        currentQuestion = 0;
    }

    @Override
    public void exitQuestion(ExamParser.QuestionContext ctx) {
        currentQuestion++;
    }

    @Override
    public void enterMatching_quest(ExamParser.Matching_questContext ctx) {

        ExamTemplateQuestion question = examTemplate.sections()
                .get(currentSection).questions().get(currentQuestion);

        String questionText = ctx.NAME(0).getText().replaceAll("\"", "");

        Preconditions.ensure(
                question.type()
                        .equals(QuestionType.MATCHING) &&
                questionText.equals(question.description().value()),
                "Invalid Exam Submission.\nTry again."
        );

        if(ctx.NULL_OPERATOR() == null){
            for (int i = 0; i < ctx.NAME().size(); i++) {
                if(
                        ctx.NAME(i).getText()
                                .replaceAll("\"", "")
                                .equals(question.solutions().get(i).description())
                ){
                    grade += question.solutions().get(i).weight();
                }
            }
        }

        for (Solution solution : question.solutions()) {
            totalGrade += solution.weight();
        }
    }

    @Override
    public void enterMultiple_choice_quest(ExamParser.Multiple_choice_questContext ctx) {



        ExamTemplateQuestion question = examTemplate.sections()
                .get(currentSection).questions().get(currentQuestion);

        List<String> answers = question
                .solutions()
                .stream()
                .map(Solution::description)
                .collect(Collectors.toList());

        String questionText = ctx.NAME(0).getText().replaceAll("\"", "");

        Preconditions.ensure(
                question.type()
                        .equals(QuestionType.MULTIPLE_CHOICE) &&
                        questionText.equals(question.description().value()),
                "Invalid Exam Submission.\nTry again."
        );

        double weight = 0;

        if(ctx.NULL_OPERATOR() == null){

            for (int i = 1; i < ctx.NAME().size(); i++) {
                String answerGiven = ctx.NAME(i).getText().replaceAll("\"", "");
                if(answers.contains(answerGiven)){
                    weight += question.solutions().get(answers.indexOf(answerGiven)).weight();
                }else{
                    weight = 0;
                    break; // if option is not on the solutions, student automatically gets 0
                }
            }

            grade += weight;
        }

        for (int i = 0; i < question.solutions().size(); i++) {
            totalGrade += question.solutions().get(i).weight();
        }


    }

    @Override
    public void enterShort_answer_quest(ExamParser.Short_answer_questContext ctx) {

        double total = 0;

        ExamTemplateQuestion question = examTemplate.sections()
                .get(currentSection).questions().get(currentQuestion);

        String questionText = ctx.NAME(0).getText().replaceAll("\"", "");

        Preconditions.ensure(
                question.type()
                        .equals(QuestionType.SHORT_ANSWER) &&
                        questionText.equals(question.description().value()),
                "Invalid Exam Submission.\nTry again."
        );

        if (ctx.NULL_OPERATOR() == null) {
            for (Solution sol : question.solutions()) {
                if (sol.description().equals(
                        ctx.NAME(1).getText().replaceAll("\"", "")
                )) {
                    grade += sol.weight();
                }
            }
        }

        for (Solution sol : question.solutions()) {
            if (sol.weight() > total) {
                total = sol.weight();
            }
        }

        totalGrade += total;
    }

    @Override
    public void enterNumerical_quest(ExamParser.Numerical_questContext ctx) {

        ExamTemplateQuestion question = examTemplate.sections()
                .get(currentSection).questions().get(currentQuestion);

        String questionText = ctx.NAME().getText().replaceAll("\"", "");

        Preconditions.ensure(
                question.type()
                        .equals(QuestionType.NUMERICAL) &&
                        questionText.equals(question.description().value()),
                "Invalid Exam Submission.\nTry again."
        );

        if(ctx.NULL_OPERATOR() == null){

            if(question.solutions().get(0).description().equals(ctx.NUMBER().getText())){
                grade += question.solutions().get(0).weight();
            }
        }
        totalGrade += question.solutions().get(0).weight();
    }

    @Override
    public void enterSelect_words_quest(ExamParser.Select_words_questContext ctx) {

        ExamTemplateQuestion question = examTemplate.sections()
                .get(currentSection).questions().get(currentQuestion);

        String questionText = ctx.NAME(0).getText().replaceAll("\"", "");

        Preconditions.ensure(
                question.type()
                        .equals(QuestionType.MISSING_WORDS) &&
                        questionText.equals(question.description().value()),
                "Invalid Exam Submission.\nTry again."
        );

        if(ctx.NULL_OPERATOR() == null){
            for (int i = 1; i < ctx.NAME().size(); i++) {
                if(
                        ctx.NAME(i).getText()
                                .replaceAll("\"", "")
                                .equals(question.solutions().get(i-1).description())
                ){
                    grade += question.solutions().get(i-1).weight();
                }

            }
        }

        for (int i = 0; i < question.solutions().size(); i++) {
            totalGrade += question.solutions().get(i).weight();
        }
    }

    @Override
    public void exitSelect_words_quest(ExamParser.Select_words_questContext ctx) {
        super.exitSelect_words_quest(ctx);
    }

    @Override
    public void enterTrue_false_quest(ExamParser.True_false_questContext ctx) {

        ExamTemplateQuestion question = examTemplate.sections()
                .get(currentSection).questions().get(currentQuestion);

        String questionText = ctx.NAME().getText().replaceAll("\"", "");

        Preconditions.ensure(
                question.type()
                        .equals(QuestionType.TRUE_FALSE) &&
                        questionText.equals(question.description().value()),
                "Invalid Exam Submission.\nTry again."
        );

        if(ctx.NULL_OPERATOR() == null){
            if(question.solutions().get(0).description().equals(ctx.TRUE_FALSE_OPT().getText())){
                grade += question.solutions().get(0).weight();
            }
        }

        totalGrade += question.solutions().get(0).weight();
    }

    public ExamBuilder withTemplate(ExamTemplate examTemplate){
        this.examTemplate = examTemplate;
        return this;
    }

    public ExamBuilder withStudent(User student){
        this.student = student;
        return this;
    }

    public Exam build(){
        return new Exam(examTemplate, student, grade, totalGrade);
    }
}
