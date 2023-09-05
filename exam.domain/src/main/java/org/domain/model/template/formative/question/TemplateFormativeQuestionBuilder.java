package org.domain.model.template.formative.question;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class TemplateFormativeQuestionBuilder extends TemplateFormativeQuestionBaseListener{


    private QuestionDescription description;
    private QuestionType type;
    private List<Answer> options = new ArrayList<>();
    private List<Solution> solutions = new ArrayList<>();

    private Course course;

    @Override
    public void enterMultiple_choice_quest(TemplateFormativeQuestionParser.Multiple_choice_questContext ctx) {
        type = QuestionType.MULTIPLE_CHOICE;

        description = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                        .replace("\"", "")
        );
    }

    @Override
    public void enterMatching_quest(TemplateFormativeQuestionParser.Matching_questContext ctx) {
        type = QuestionType.MATCHING;

        description = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                        .replace("\"", "")
        );
    }

    @Override
    public void enterShort_answer_quest(TemplateFormativeQuestionParser.Short_answer_questContext ctx) {
        type = QuestionType.SHORT_ANSWER;

        description = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                        .replace("\"", "")
        );
    }

    @Override
    public void enterNumerical_quest(TemplateFormativeQuestionParser.Numerical_questContext ctx) {
        type = QuestionType.NUMERICAL;

        description = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                        .replace("\"", "")
        );
    }

    @Override
    public void enterSelect_words_quest(TemplateFormativeQuestionParser.Select_words_questContext ctx) {
        type = QuestionType.MISSING_WORDS;

        description = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                        .replace("\"", "")
        );
    }

    @Override
    public void enterTrue_false_quest(TemplateFormativeQuestionParser.True_false_questContext ctx) {
        type = QuestionType.TRUE_FALSE;

        description = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                        .replace("\"", "")
        );
    }

    @Override
    public void enterCreate_option(TemplateFormativeQuestionParser.Create_optionContext ctx) {
        options.add(
                new Answer(
                        ctx.DESCRIPTION().getText()
                                .replace("\"", "")
                )
        );
    }

    @Override
    public void enterCreate_solution(TemplateFormativeQuestionParser.Create_solutionContext ctx) {
        String solution = ctx.SOLUTION_TEXT().getText().substring(1, ctx.SOLUTION_TEXT().getText().length() - 1);

        String solutionText = solution.split("\\|")[0];
        Double solutionWeight = Double.parseDouble(solution.split("\\|")[1]);

        if(type.equals(QuestionType.NUMERICAL)){
            try{
                Double.parseDouble(solutionText);
            }catch (NumberFormatException e){
                throw new IllegalArgumentException("The solution text must be a number for a numerical question");
            }
        }

        solutions.add(
                new Solution(
                        new SolutionWeight(solutionWeight),
                        new SolutionDescription(solutionText)
                )
        );
    }

    @Override
    public void enterCreate_true_false_solution(TemplateFormativeQuestionParser.Create_true_false_solutionContext ctx) {
        // no need for validation now, it's done in the parser
        String solution = ctx.TRUE_FALSE_SOLUTION_TEXT().getText().substring(1, ctx.TRUE_FALSE_SOLUTION_TEXT().getText().length() - 1);

        String solutionText = solution.split("\\|")[0];
        Double solutionWeight = Double.parseDouble(solution.split("\\|")[1]);

        solutions.add(
                new Solution(
                        new SolutionWeight(solutionWeight),
                        new SolutionDescription(solutionText)
                )
        );
    }

    public void withCourse(Course course) {
        this.course = course;
    }


    public TemplateFormativeQuestion build() {
        return new TemplateFormativeQuestion(description, type, options, solutions, course);
    }
}
