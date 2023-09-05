// Generated from /Users/henriquelspinto/IdeaProjects/sem4pi-22-23-8/exam.domain/src/main/java/org/domain/model/exam/Exam.g4 by ANTLR 4.12.0
package org.domain.model.exam;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExamParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExamVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExamParser#exam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExam(ExamParser.ExamContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#exam_header}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExam_header(ExamParser.Exam_headerContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#section}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSection(ExamParser.SectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#question}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuestion(ExamParser.QuestionContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#matching_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMatching_quest(ExamParser.Matching_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#multiple_choice_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_choice_quest(ExamParser.Multiple_choice_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#short_answer_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShort_answer_quest(ExamParser.Short_answer_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#numerical_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumerical_quest(ExamParser.Numerical_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#select_words_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_words_quest(ExamParser.Select_words_questContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExamParser#true_false_quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrue_false_quest(ExamParser.True_false_questContext ctx);
}