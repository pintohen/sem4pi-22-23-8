// Generated from /Users/henriquelspinto/IdeaProjects/sem4pi-22-23-8/exam.domain/src/main/java/org/domain/model/exam/Exam.g4 by ANTLR 4.12.0
package org.domain.model.exam;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExamParser}.
 */
public interface ExamListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExamParser#exam}.
	 * @param ctx the parse tree
	 */
	void enterExam(ExamParser.ExamContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#exam}.
	 * @param ctx the parse tree
	 */
	void exitExam(ExamParser.ExamContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#exam_header}.
	 * @param ctx the parse tree
	 */
	void enterExam_header(ExamParser.Exam_headerContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#exam_header}.
	 * @param ctx the parse tree
	 */
	void exitExam_header(ExamParser.Exam_headerContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#section}.
	 * @param ctx the parse tree
	 */
	void enterSection(ExamParser.SectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#section}.
	 * @param ctx the parse tree
	 */
	void exitSection(ExamParser.SectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#question}.
	 * @param ctx the parse tree
	 */
	void enterQuestion(ExamParser.QuestionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#question}.
	 * @param ctx the parse tree
	 */
	void exitQuestion(ExamParser.QuestionContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#matching_quest}.
	 * @param ctx the parse tree
	 */
	void enterMatching_quest(ExamParser.Matching_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#matching_quest}.
	 * @param ctx the parse tree
	 */
	void exitMatching_quest(ExamParser.Matching_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#multiple_choice_quest}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_choice_quest(ExamParser.Multiple_choice_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#multiple_choice_quest}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_choice_quest(ExamParser.Multiple_choice_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#short_answer_quest}.
	 * @param ctx the parse tree
	 */
	void enterShort_answer_quest(ExamParser.Short_answer_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#short_answer_quest}.
	 * @param ctx the parse tree
	 */
	void exitShort_answer_quest(ExamParser.Short_answer_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#numerical_quest}.
	 * @param ctx the parse tree
	 */
	void enterNumerical_quest(ExamParser.Numerical_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#numerical_quest}.
	 * @param ctx the parse tree
	 */
	void exitNumerical_quest(ExamParser.Numerical_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#select_words_quest}.
	 * @param ctx the parse tree
	 */
	void enterSelect_words_quest(ExamParser.Select_words_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#select_words_quest}.
	 * @param ctx the parse tree
	 */
	void exitSelect_words_quest(ExamParser.Select_words_questContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExamParser#true_false_quest}.
	 * @param ctx the parse tree
	 */
	void enterTrue_false_quest(ExamParser.True_false_questContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExamParser#true_false_quest}.
	 * @param ctx the parse tree
	 */
	void exitTrue_false_quest(ExamParser.True_false_questContext ctx);
}