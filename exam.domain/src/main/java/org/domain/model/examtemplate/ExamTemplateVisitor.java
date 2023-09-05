// Generated from C:/Users/bruna/IdeaProjects/sem4pi-22-23-8/exam.domain/src/main/java/org/domain/model/examtemplate\ExamTemplate.g4 by ANTLR 4.12.0
package org.domain.model.examtemplate;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExamTemplateParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExamTemplateVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(ExamTemplateParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#exam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExam(ExamTemplateParser.ExamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#create_section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_section(ExamTemplateParser.Create_sectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuest(ExamTemplateParser.QuestContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#matching_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_quest(ExamTemplateParser.Matching_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#multiple_choice_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_quest(ExamTemplateParser.Multiple_choice_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#short_answer_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_quest(ExamTemplateParser.Short_answer_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#numerical_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_quest(ExamTemplateParser.Numerical_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#select_words_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_words_quest(ExamTemplateParser.Select_words_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#true_false_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_quest(ExamTemplateParser.True_false_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#create_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_option(ExamTemplateParser.Create_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#create_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_solution(ExamTemplateParser.Create_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#create_true_false_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_true_false_solution(ExamTemplateParser.Create_true_false_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#create_exam_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_exam_header(ExamTemplateParser.Create_exam_headerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#create_exam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_exam(ExamTemplateParser.Create_examContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#create_exam_description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_exam_description(ExamTemplateParser.Create_exam_descriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#create_open_date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_open_date(ExamTemplateParser.Create_open_dateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#create_close_date}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_close_date(ExamTemplateParser.Create_close_dateContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#create_feedback_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_feedback_type(ExamTemplateParser.Create_feedback_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamTemplateParser#create_grade_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_grade_type(ExamTemplateParser.Create_grade_typeContext ctx);
}