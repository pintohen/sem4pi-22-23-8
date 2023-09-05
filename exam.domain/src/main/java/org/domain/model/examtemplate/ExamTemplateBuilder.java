package org.domain.model.examtemplate;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.domain.model.*;
import org.domain.model.examtemplate.domain.*;
import org.usermanagement.domain.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExamTemplateBuilder extends ExamTemplateBaseListener{

    // Exam template fields
    private ExamTitle examTitle;
    private OpenDate openDate;
    private CloseDate closeDate;
    private ExamDescription examDescription;
    private FeedbackType feedbackType;
    private GradeType gradeType;

    //Sections
    private List<Section> sections = new ArrayList<>();

    // Section fields
    private Long number = Long.valueOf(0);
    private SectionDescription sectionDescription;

    //Section dependencies
    private List<ExamTemplateQuestion> questions = new ArrayList<>();

    // Exam Template Dependencies
    private Course course;
    private User teacher;
    private Set<User> students;


    // question fields
    private QuestionDescription questionDescription;
    private QuestionType questionType;

    // question dependencies
    private List<Answer> options = new ArrayList<>();
    private List<Solution> solutions = new ArrayList<>();


    @Override
    public void enterStart(ExamTemplateParser.StartContext ctx) {
        super.enterStart(ctx);
    }

    @Override
    public void exitStart(ExamTemplateParser.StartContext ctx) {
        super.exitStart(ctx);
    }

    @Override
    public void enterExam(ExamTemplateParser.ExamContext ctx) {
        super.enterExam(ctx);
    }

    @Override
    public void exitExam(ExamTemplateParser.ExamContext ctx) {
        super.exitExam(ctx);
    }

    @Override
    public void enterCreate_section(ExamTemplateParser.Create_sectionContext ctx) {
        if(sections.size() != 0){
            questions.get(questions.size() - 1).setOptions(options);
            questions.get(questions.size() - 1).setSolutions(solutions);

            sections.get(sections.size() - 1).setQuestions(questions);

            questions = new ArrayList<>();
            options = new ArrayList<>();
            solutions = new ArrayList<>();
        }


        number++;

        sectionDescription = SectionDescription.of(ctx.DESCRIPTION().getText().replaceAll("\"", ""));

        sections.add(
                new Section(number, sectionDescription)
        );
    }

    @Override
    public void exitCreate_section(ExamTemplateParser.Create_sectionContext ctx) {
        super.exitCreate_section(ctx);
    }

    @Override
    public void enterQuest(ExamTemplateParser.QuestContext ctx) {
        if(questions.size() != 0){
            ExamTemplateQuestion question = questions.get(questions.size() - 1);

            question.setOptions(options);
            question.setSolutions(solutions);

            options = new ArrayList<>();
            solutions = new ArrayList<>();
        }
    }

    @Override
    public void exitQuest(ExamTemplateParser.QuestContext ctx) {

    }

    @Override
    public void enterMatching_quest(ExamTemplateParser.Matching_questContext ctx) {
        questionType = QuestionType.MATCHING;

        questionDescription = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                        .replace("\"", "")
        );
    }

    @Override
    public void exitMatching_quest(ExamTemplateParser.Matching_questContext ctx) {

    }

    @Override
    public void enterMultiple_choice_quest(ExamTemplateParser.Multiple_choice_questContext ctx) {
        questionType = QuestionType.MULTIPLE_CHOICE;

        questionDescription = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                        .replace("\"", "")
        );

        questions.add(
                ExamTemplateQuestion.of(
                        questionDescription,
                        questionType
                )
        );
    }

    @Override
    public void exitMultiple_choice_quest(ExamTemplateParser.Multiple_choice_questContext ctx) {
        super.exitMultiple_choice_quest(ctx);
    }

    @Override
    public void enterShort_answer_quest(ExamTemplateParser.Short_answer_questContext ctx) {
        questionType = QuestionType.SHORT_ANSWER;

        questionDescription = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                        .replace("\"", "")
        );

        questions.add(
                ExamTemplateQuestion.of(
                        questionDescription,
                        questionType
                )
        );
    }

    @Override
    public void exitShort_answer_quest(ExamTemplateParser.Short_answer_questContext ctx) {
        super.exitShort_answer_quest(ctx);
    }

    @Override
    public void enterNumerical_quest(ExamTemplateParser.Numerical_questContext ctx) {
        questionType = QuestionType.NUMERICAL;

        questionDescription = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                .replace("\"", "")
        );

        questions.add(
                ExamTemplateQuestion.of(
                        questionDescription,
                        questionType
                )
        );
    }

    @Override
    public void exitNumerical_quest(ExamTemplateParser.Numerical_questContext ctx) {
        super.exitNumerical_quest(ctx);
    }

    @Override
    public void enterSelect_words_quest(ExamTemplateParser.Select_words_questContext ctx) {
        questionType = QuestionType.MISSING_WORDS;

        questionDescription = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                        .replace("\"", "")
        );

        questions.add(
                ExamTemplateQuestion.of(
                        questionDescription,
                        questionType
                )
        );
    }

    @Override
    public void exitSelect_words_quest(ExamTemplateParser.Select_words_questContext ctx) {
        super.exitSelect_words_quest(ctx);
    }

    @Override
    public void enterTrue_false_quest(ExamTemplateParser.True_false_questContext ctx) {
        questionType = QuestionType.TRUE_FALSE;

        questionDescription = new QuestionDescription(
                ctx.DESCRIPTION().getText()
                .replace("\"", "")
        );

        questions.add(
                ExamTemplateQuestion.of(
                        questionDescription,
                        questionType
                )
        );
    }

    @Override
    public void exitTrue_false_quest(ExamTemplateParser.True_false_questContext ctx) {
        super.exitTrue_false_quest(ctx);
    }

    @Override
    public void enterCreate_option(ExamTemplateParser.Create_optionContext ctx) {
        options.add(
                new Answer(
                        ctx.DESCRIPTION().getText()
                                .replace("\"", "")
                )
        );
    }

    @Override
    public void exitCreate_option(ExamTemplateParser.Create_optionContext ctx) {
        super.exitCreate_option(ctx);
    }

    @Override
    public void enterCreate_solution(ExamTemplateParser.Create_solutionContext ctx) {
        super.enterCreate_solution(ctx);
    }

    @Override
    public void exitCreate_solution(ExamTemplateParser.Create_solutionContext ctx) {
        String solution = ctx.SOLUTION_TEXT().getText().substring(1, ctx.SOLUTION_TEXT().getText().length() - 1);

        String solutionText = solution.split("\\|")[0];
        Double solutionWeight = Double.parseDouble(solution.split("\\|")[1]);

        solutions.add(
                new Solution(
                        new SolutionWeight(solutionWeight),
                        new SolutionDescription(solutionText)
                )
        );
    }

    @Override
    public void enterCreate_true_false_solution(ExamTemplateParser.Create_true_false_solutionContext ctx) {
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

    @Override
    public void exitCreate_true_false_solution(ExamTemplateParser.Create_true_false_solutionContext ctx) {
        super.exitCreate_true_false_solution(ctx);
    }

    @Override
    public void enterCreate_exam_header(ExamTemplateParser.Create_exam_headerContext ctx) {
        super.enterCreate_exam_header(ctx);
    }

    @Override
    public void exitCreate_exam_header(ExamTemplateParser.Create_exam_headerContext ctx) {
        super.exitCreate_exam_header(ctx);
    }

    @Override
    public void enterCreate_exam(ExamTemplateParser.Create_examContext ctx) {
        examTitle = ExamTitle.of(
                ctx.DESCRIPTION().getText().replace("\"", ""));
    }

    @Override
    public void exitCreate_exam(ExamTemplateParser.Create_examContext ctx) {
        super.exitCreate_exam(ctx);
    }

    @Override
    public void enterCreate_exam_description(ExamTemplateParser.Create_exam_descriptionContext ctx) {
        examDescription = ExamDescription.of(
                ctx.DESCRIPTION().getText().replace("\"", "")
        );
    }

    @Override
    public void exitCreate_exam_description(ExamTemplateParser.Create_exam_descriptionContext ctx) {
        super.exitCreate_exam_description(ctx);
    }

    @Override
    public void enterCreate_open_date(ExamTemplateParser.Create_open_dateContext ctx) {
        openDate = OpenDate.of(ctx.DATE().getText().substring(1, ctx.DATE().getText().length() - 1));
    }

    @Override
    public void exitCreate_open_date(ExamTemplateParser.Create_open_dateContext ctx) {
        super.exitCreate_open_date(ctx);
    }

    @Override
    public void enterCreate_close_date(ExamTemplateParser.Create_close_dateContext ctx) {
        closeDate = CloseDate.of(ctx.DATE().getText().substring(1, ctx.DATE().getText().length() - 1));
    }

    @Override
    public void exitCreate_close_date(ExamTemplateParser.Create_close_dateContext ctx) {
        super.exitCreate_close_date(ctx);
    }

    @Override
    public void enterCreate_feedback_type(ExamTemplateParser.Create_feedback_typeContext ctx) {
        String feedbackTypeString = ctx.TIME_TYPE().getText();

        if(feedbackTypeString.equals("NONE")){
            feedbackType = FeedbackType.NONE;
        }else if(feedbackTypeString.equals("ONSUB")){
            feedbackType = FeedbackType.ON_SUBMISSION;
        }else if(feedbackTypeString.equals("AFTER")){
            feedbackType = FeedbackType.AFTER_CLOSING;
        }
    }

    @Override
    public void exitCreate_feedback_type(ExamTemplateParser.Create_feedback_typeContext ctx) {
        super.exitCreate_feedback_type(ctx);
    }

    @Override
    public void enterCreate_grade_type(ExamTemplateParser.Create_grade_typeContext ctx) {
        String gradeTypeString = ctx.TIME_TYPE().getText();

        if(gradeTypeString.equals("NONE")){
            gradeType = GradeType.NONE;
        }else if(gradeTypeString.equals("ONSUB")){
            gradeType = GradeType.ON_SUBMISSION;
        }else if(gradeTypeString.equals("AFTER")){
            gradeType = GradeType.AFTER_CLOSING;
        }
    }

    @Override
    public void exitCreate_grade_type(ExamTemplateParser.Create_grade_typeContext ctx) {
        super.exitCreate_grade_type(ctx);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode node) {
        super.visitTerminal(node);
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
    }

    public void with(Course course, User teacher, Set<User> students){
        this.course = course;
        this.teacher = teacher;
        this.students = students;
    }


    public ExamTemplate build(){
        questions.get(questions.size() - 1).setOptions(options);
        questions.get(questions.size() - 1).setSolutions(solutions);

        sections.get(sections.size() - 1).setQuestions(questions);


        return new ExamTemplate(
                examTitle,
                openDate,
                closeDate,
                examDescription,
                feedbackType,
                gradeType,
                sections,
                teacher,
                students,
                course
        );
    }

}
