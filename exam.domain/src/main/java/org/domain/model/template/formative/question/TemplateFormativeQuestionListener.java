// Generated from D:/JavaProjects/sem4pi-22-23-8/exam.domain/src/main/java/org/domain/model/template/formative/question\TemplateFormativeQuestion.g4 by ANTLR 4.12.0
package org.domain.model.template.formative.question;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TemplateFormativeQuestionParser}.
 */
public interface TemplateFormativeQuestionListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TemplateFormativeQuestionParser#start}.
	 * @param ctx the parse tree
	 */
	void enterStart(TemplateFormativeQuestionParser.StartContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateFormativeQuestionParser#start}.
	 * @param ctx the parse tree
	 */
	void exitStart(TemplateFormativeQuestionParser.StartContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateFormativeQuestionParser#quest}.
	 * @param ctx the parse tree
	 */
	void enterQuest(TemplateFormativeQuestionParser.QuestContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateFormativeQuestionParser#quest}.
	 * @param ctx the parse tree
	 */
	void exitQuest(TemplateFormativeQuestionParser.QuestContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateFormativeQuestionParser#matching_quest}.
	 * @param ctx the parse tree
	 */
	void enterMatching_quest(TemplateFormativeQuestionParser.Matching_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateFormativeQuestionParser#matching_quest}.
	 * @param ctx the parse tree
	 */
	void exitMatching_quest(TemplateFormativeQuestionParser.Matching_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateFormativeQuestionParser#multiple_choice_quest}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_quest(TemplateFormativeQuestionParser.Multiple_choice_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateFormativeQuestionParser#multiple_choice_quest}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_quest(TemplateFormativeQuestionParser.Multiple_choice_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateFormativeQuestionParser#short_answer_quest}.
	 * @param ctx the parse tree
	 */
	void enterShort_answer_quest(TemplateFormativeQuestionParser.Short_answer_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateFormativeQuestionParser#short_answer_quest}.
	 * @param ctx the parse tree
	 */
	void exitShort_answer_quest(TemplateFormativeQuestionParser.Short_answer_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateFormativeQuestionParser#numerical_quest}.
	 * @param ctx the parse tree
	 */
	void enterNumerical_quest(TemplateFormativeQuestionParser.Numerical_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateFormativeQuestionParser#numerical_quest}.
	 * @param ctx the parse tree
	 */
	void exitNumerical_quest(TemplateFormativeQuestionParser.Numerical_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateFormativeQuestionParser#select_words_quest}.
	 * @param ctx the parse tree
	 */
	void enterSelect_words_quest(TemplateFormativeQuestionParser.Select_words_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateFormativeQuestionParser#select_words_quest}.
	 * @param ctx the parse tree
	 */
	void exitSelect_words_quest(TemplateFormativeQuestionParser.Select_words_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateFormativeQuestionParser#true_false_quest}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_quest(TemplateFormativeQuestionParser.True_false_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateFormativeQuestionParser#true_false_quest}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_quest(TemplateFormativeQuestionParser.True_false_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateFormativeQuestionParser#create_option}.
	 * @param ctx the parse tree
	 */
	void enterCreate_option(TemplateFormativeQuestionParser.Create_optionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateFormativeQuestionParser#create_option}.
	 * @param ctx the parse tree
	 */
	void exitCreate_option(TemplateFormativeQuestionParser.Create_optionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateFormativeQuestionParser#create_solution}.
	 * @param ctx the parse tree
	 */
	void enterCreate_solution(TemplateFormativeQuestionParser.Create_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateFormativeQuestionParser#create_solution}.
	 * @param ctx the parse tree
	 */
	void exitCreate_solution(TemplateFormativeQuestionParser.Create_solutionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TemplateFormativeQuestionParser#create_true_false_solution}.
	 * @param ctx the parse tree
	 */
	void enterCreate_true_false_solution(TemplateFormativeQuestionParser.Create_true_false_solutionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TemplateFormativeQuestionParser#create_true_false_solution}.
	 * @param ctx the parse tree
	 */
	void exitCreate_true_false_solution(TemplateFormativeQuestionParser.Create_true_false_solutionContext ctx);
}