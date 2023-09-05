// Generated from D:/JavaProjects/sem4pi-22-23-8/exam.domain/src/main/java/org/domain/model/template/formative/question\TemplateFormativeQuestion.g4 by ANTLR 4.12.0
package org.domain.model.template.formative.question;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TemplateFormativeQuestionParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TemplateFormativeQuestionVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TemplateFormativeQuestionParser#start}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStart(TemplateFormativeQuestionParser.StartContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateFormativeQuestionParser#quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuest(TemplateFormativeQuestionParser.QuestContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateFormativeQuestionParser#matching_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_quest(TemplateFormativeQuestionParser.Matching_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateFormativeQuestionParser#multiple_choice_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_quest(TemplateFormativeQuestionParser.Multiple_choice_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateFormativeQuestionParser#short_answer_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_quest(TemplateFormativeQuestionParser.Short_answer_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateFormativeQuestionParser#numerical_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_quest(TemplateFormativeQuestionParser.Numerical_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateFormativeQuestionParser#select_words_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_words_quest(TemplateFormativeQuestionParser.Select_words_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateFormativeQuestionParser#true_false_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_quest(TemplateFormativeQuestionParser.True_false_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateFormativeQuestionParser#create_option}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_option(TemplateFormativeQuestionParser.Create_optionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateFormativeQuestionParser#create_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_solution(TemplateFormativeQuestionParser.Create_solutionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TemplateFormativeQuestionParser#create_true_false_solution}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreate_true_false_solution(TemplateFormativeQuestionParser.Create_true_false_solutionContext ctx);
}