// Generated from C:/Users/bruna/IdeaProjects/sem4pi-22-23-8/exam.domain/src/main/java/org/domain/model/examtemplate\ExamTemplate.g4 by ANTLR 4.12.0
package org.domain.model.examtemplate;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExamTemplateParser}.
 */
public interface ExamTemplateListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(ExamTemplateParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(ExamTemplateParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#exam}.
	 * @param ctx the parse tree
	 */
	void enterExam(ExamTemplateParser.ExamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#exam}.
	 * @param ctx the parse tree
	 */
	void exitExam(ExamTemplateParser.ExamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#create_section}.
	 * @param ctx the parse tree
	 */
	void enterCreate_section(ExamTemplateParser.Create_sectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#create_section}.
	 * @param ctx the parse tree
	 */
	void exitCreate_section(ExamTemplateParser.Create_sectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#quest}.
	 * @param ctx the parse tree
	 */
	void enterQuest(ExamTemplateParser.QuestContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#quest}.
	 * @param ctx the parse tree
	 */
	void exitQuest(ExamTemplateParser.QuestContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#matching_quest}.
	 * @param ctx the parse tree
	 */
	void enterMatching_quest(ExamTemplateParser.Matching_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#matching_quest}.
	 * @param ctx the parse tree
	 */
	void exitMatching_quest(ExamTemplateParser.Matching_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#multiple_choice_quest}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_quest(ExamTemplateParser.Multiple_choice_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#multiple_choice_quest}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_quest(ExamTemplateParser.Multiple_choice_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#short_answer_quest}.
	 * @param ctx the parse tree
	 */
	void enterShort_answer_quest(ExamTemplateParser.Short_answer_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#short_answer_quest}.
	 * @param ctx the parse tree
	 */
	void exitShort_answer_quest(ExamTemplateParser.Short_answer_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#numerical_quest}.
	 * @param ctx the parse tree
	 */
	void enterNumerical_quest(ExamTemplateParser.Numerical_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#numerical_quest}.
	 * @param ctx the parse tree
	 */
	void exitNumerical_quest(ExamTemplateParser.Numerical_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#select_words_quest}.
	 * @param ctx the parse tree
	 */
	void enterSelect_words_quest(ExamTemplateParser.Select_words_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#select_words_quest}.
	 * @param ctx the parse tree
	 */
	void exitSelect_words_quest(ExamTemplateParser.Select_words_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#true_false_quest}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_quest(ExamTemplateParser.True_false_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#true_false_quest}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_quest(ExamTemplateParser.True_false_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#create_option}.
	 * @param ctx the parse tree
	 */
	void enterCreate_option(ExamTemplateParser.Create_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#create_option}.
	 * @param ctx the parse tree
	 */
	void exitCreate_option(ExamTemplateParser.Create_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#create_solution}.
	 * @param ctx the parse tree
	 */
	void enterCreate_solution(ExamTemplateParser.Create_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#create_solution}.
	 * @param ctx the parse tree
	 */
	void exitCreate_solution(ExamTemplateParser.Create_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#create_true_false_solution}.
	 * @param ctx the parse tree
	 */
	void enterCreate_true_false_solution(ExamTemplateParser.Create_true_false_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#create_true_false_solution}.
	 * @param ctx the parse tree
	 */
	void exitCreate_true_false_solution(ExamTemplateParser.Create_true_false_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#create_exam_header}.
	 * @param ctx the parse tree
	 */
	void enterCreate_exam_header(ExamTemplateParser.Create_exam_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#create_exam_header}.
	 * @param ctx the parse tree
	 */
	void exitCreate_exam_header(ExamTemplateParser.Create_exam_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#create_exam}.
	 * @param ctx the parse tree
	 */
	void enterCreate_exam(ExamTemplateParser.Create_examContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#create_exam}.
	 * @param ctx the parse tree
	 */
	void exitCreate_exam(ExamTemplateParser.Create_examContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#create_exam_description}.
	 * @param ctx the parse tree
	 */
	void enterCreate_exam_description(ExamTemplateParser.Create_exam_descriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#create_exam_description}.
	 * @param ctx the parse tree
	 */
	void exitCreate_exam_description(ExamTemplateParser.Create_exam_descriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#create_open_date}.
	 * @param ctx the parse tree
	 */
	void enterCreate_open_date(ExamTemplateParser.Create_open_dateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#create_open_date}.
	 * @param ctx the parse tree
	 */
	void exitCreate_open_date(ExamTemplateParser.Create_open_dateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#create_close_date}.
	 * @param ctx the parse tree
	 */
	void enterCreate_close_date(ExamTemplateParser.Create_close_dateContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#create_close_date}.
	 * @param ctx the parse tree
	 */
	void exitCreate_close_date(ExamTemplateParser.Create_close_dateContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#create_feedback_type}.
	 * @param ctx the parse tree
	 */
	void enterCreate_feedback_type(ExamTemplateParser.Create_feedback_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#create_feedback_type}.
	 * @param ctx the parse tree
	 */
	void exitCreate_feedback_type(ExamTemplateParser.Create_feedback_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamTemplateParser#create_grade_type}.
	 * @param ctx the parse tree
	 */
	void enterCreate_grade_type(ExamTemplateParser.Create_grade_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamTemplateParser#create_grade_type}.
	 * @param ctx the parse tree
	 */
	void exitCreate_grade_type(ExamTemplateParser.Create_grade_typeContext ctx);
}