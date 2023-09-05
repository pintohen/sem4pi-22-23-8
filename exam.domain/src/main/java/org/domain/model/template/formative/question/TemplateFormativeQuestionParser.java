// Generated from D:/JavaProjects/sem4pi-22-23-8/exam.domain/src/main/java/org/domain/model/template/formative/question\TemplateFormativeQuestion.g4 by ANTLR 4.12.0
package org.domain.model.template.formative.question;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TemplateFormativeQuestionParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, ID_OPTION=3, ID_SOLUTION=4, MATCHING=5, MULTIPLE_CHOICE=6, 
		SHORT_ANSWER=7, NUMERICAL=8, SELECT_WORDS=9, TRUE_FALSE=10, SOLUTION_TEXT=11, 
		TRUE_FALSE_SOLUTION_TEXT=12, SOL_DESCRIPTION=13, TRUE_FALSE_SOL_DESCRIPTION=14, 
		DESCRIPTION=15, NUMBER=16, NEWLINE=17, DECIMAL=18;
	public static final int
		RULE_start = 0, RULE_quest = 1, RULE_matching_quest = 2, RULE_multiple_choice_quest = 3, 
		RULE_short_answer_quest = 4, RULE_numerical_quest = 5, RULE_select_words_quest = 6, 
		RULE_true_false_quest = 7, RULE_create_option = 8, RULE_create_solution = 9, 
		RULE_create_true_false_solution = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "quest", "matching_quest", "multiple_choice_quest", "short_answer_quest", 
			"numerical_quest", "select_words_quest", "true_false_quest", "create_option", 
			"create_solution", "create_true_false_solution"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "';'", "'OPT'", "'SOL'", "'MQUES'", "'MCQUES'", "'SAQUES'", 
			"'NQUES'", "'SWQUES'", "'TFQUES'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "ID_OPTION", "ID_SOLUTION", "MATCHING", "MULTIPLE_CHOICE", 
			"SHORT_ANSWER", "NUMERICAL", "SELECT_WORDS", "TRUE_FALSE", "SOLUTION_TEXT", 
			"TRUE_FALSE_SOLUTION_TEXT", "SOL_DESCRIPTION", "TRUE_FALSE_SOL_DESCRIPTION", 
			"DESCRIPTION", "NUMBER", "NEWLINE", "DECIMAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "TemplateFormativeQuestion.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TemplateFormativeQuestionParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public QuestContext quest() {
			return getRuleContext(QuestContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateFormativeQuestionVisitor ) return ((TemplateFormativeQuestionVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			quest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestContext extends ParserRuleContext {
		public Matching_questContext matching_quest() {
			return getRuleContext(Matching_questContext.class,0);
		}
		public Multiple_choice_questContext multiple_choice_quest() {
			return getRuleContext(Multiple_choice_questContext.class,0);
		}
		public Short_answer_questContext short_answer_quest() {
			return getRuleContext(Short_answer_questContext.class,0);
		}
		public Numerical_questContext numerical_quest() {
			return getRuleContext(Numerical_questContext.class,0);
		}
		public Select_words_questContext select_words_quest() {
			return getRuleContext(Select_words_questContext.class,0);
		}
		public True_false_questContext true_false_quest() {
			return getRuleContext(True_false_questContext.class,0);
		}
		public QuestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).enterQuest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).exitQuest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateFormativeQuestionVisitor ) return ((TemplateFormativeQuestionVisitor<? extends T>)visitor).visitQuest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestContext quest() throws RecognitionException {
		QuestContext _localctx = new QuestContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_quest);
		try {
			setState(30);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATCHING:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				matching_quest();
				}
				break;
			case MULTIPLE_CHOICE:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				multiple_choice_quest();
				}
				break;
			case SHORT_ANSWER:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				short_answer_quest();
				}
				break;
			case NUMERICAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(27);
				numerical_quest();
				}
				break;
			case SELECT_WORDS:
				enterOuterAlt(_localctx, 5);
				{
				setState(28);
				select_words_quest();
				}
				break;
			case TRUE_FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(29);
				true_false_quest();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Matching_questContext extends ParserRuleContext {
		public TerminalNode MATCHING() { return getToken(TemplateFormativeQuestionParser.MATCHING, 0); }
		public TerminalNode DESCRIPTION() { return getToken(TemplateFormativeQuestionParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(TemplateFormativeQuestionParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TemplateFormativeQuestionParser.NEWLINE, i);
		}
		public List<Create_optionContext> create_option() {
			return getRuleContexts(Create_optionContext.class);
		}
		public Create_optionContext create_option(int i) {
			return getRuleContext(Create_optionContext.class,i);
		}
		public List<Create_solutionContext> create_solution() {
			return getRuleContexts(Create_solutionContext.class);
		}
		public Create_solutionContext create_solution(int i) {
			return getRuleContext(Create_solutionContext.class,i);
		}
		public Matching_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).enterMatching_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).exitMatching_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateFormativeQuestionVisitor ) return ((TemplateFormativeQuestionVisitor<? extends T>)visitor).visitMatching_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_questContext matching_quest() throws RecognitionException {
		Matching_questContext _localctx = new Matching_questContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_matching_quest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(MATCHING);
			setState(36);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(33);
					match(T__0);
					}
					} 
				}
				setState(38);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(39);
			match(DESCRIPTION);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(40);
					match(T__0);
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(46);
			match(T__1);
			setState(50);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(47);
					match(NEWLINE);
					}
					} 
				}
				setState(52);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(54); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(53);
				create_option();
				}
				}
				setState(56); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_OPTION );
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				create_solution();
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_SOLUTION );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Multiple_choice_questContext extends ParserRuleContext {
		public TerminalNode MULTIPLE_CHOICE() { return getToken(TemplateFormativeQuestionParser.MULTIPLE_CHOICE, 0); }
		public TerminalNode DESCRIPTION() { return getToken(TemplateFormativeQuestionParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(TemplateFormativeQuestionParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TemplateFormativeQuestionParser.NEWLINE, i);
		}
		public List<Create_optionContext> create_option() {
			return getRuleContexts(Create_optionContext.class);
		}
		public Create_optionContext create_option(int i) {
			return getRuleContext(Create_optionContext.class,i);
		}
		public List<Create_solutionContext> create_solution() {
			return getRuleContexts(Create_solutionContext.class);
		}
		public Create_solutionContext create_solution(int i) {
			return getRuleContext(Create_solutionContext.class,i);
		}
		public Multiple_choice_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).enterMultiple_choice_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).exitMultiple_choice_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateFormativeQuestionVisitor ) return ((TemplateFormativeQuestionVisitor<? extends T>)visitor).visitMultiple_choice_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_questContext multiple_choice_quest() throws RecognitionException {
		Multiple_choice_questContext _localctx = new Multiple_choice_questContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_multiple_choice_quest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			match(MULTIPLE_CHOICE);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(64);
					match(T__0);
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(70);
			match(DESCRIPTION);
			setState(74);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(71);
					match(T__0);
					}
					} 
				}
				setState(76);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(77);
			match(T__1);
			setState(81);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(78);
					match(NEWLINE);
					}
					} 
				}
				setState(83);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(85); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(84);
				create_option();
				}
				}
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_OPTION );
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(89);
				create_solution();
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_SOLUTION );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Short_answer_questContext extends ParserRuleContext {
		public TerminalNode SHORT_ANSWER() { return getToken(TemplateFormativeQuestionParser.SHORT_ANSWER, 0); }
		public TerminalNode DESCRIPTION() { return getToken(TemplateFormativeQuestionParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(TemplateFormativeQuestionParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TemplateFormativeQuestionParser.NEWLINE, i);
		}
		public List<Create_solutionContext> create_solution() {
			return getRuleContexts(Create_solutionContext.class);
		}
		public Create_solutionContext create_solution(int i) {
			return getRuleContext(Create_solutionContext.class,i);
		}
		public Short_answer_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_answer_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).enterShort_answer_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).exitShort_answer_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateFormativeQuestionVisitor ) return ((TemplateFormativeQuestionVisitor<? extends T>)visitor).visitShort_answer_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_answer_questContext short_answer_quest() throws RecognitionException {
		Short_answer_questContext _localctx = new Short_answer_questContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_short_answer_quest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(SHORT_ANSWER);
			setState(98);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(95);
					match(T__0);
					}
					} 
				}
				setState(100);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(101);
			match(DESCRIPTION);
			setState(105);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(102);
					match(T__0);
					}
					} 
				}
				setState(107);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(108);
			match(T__1);
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(109);
					match(NEWLINE);
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(116); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(115);
				create_solution();
				}
				}
				setState(118); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_SOLUTION );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Numerical_questContext extends ParserRuleContext {
		public TerminalNode NUMERICAL() { return getToken(TemplateFormativeQuestionParser.NUMERICAL, 0); }
		public TerminalNode DESCRIPTION() { return getToken(TemplateFormativeQuestionParser.DESCRIPTION, 0); }
		public Create_solutionContext create_solution() {
			return getRuleContext(Create_solutionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(TemplateFormativeQuestionParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TemplateFormativeQuestionParser.NEWLINE, i);
		}
		public Numerical_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).enterNumerical_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).exitNumerical_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateFormativeQuestionVisitor ) return ((TemplateFormativeQuestionVisitor<? extends T>)visitor).visitNumerical_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numerical_questContext numerical_quest() throws RecognitionException {
		Numerical_questContext _localctx = new Numerical_questContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_numerical_quest);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(NUMERICAL);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(121);
					match(T__0);
					}
					} 
				}
				setState(126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(127);
			match(DESCRIPTION);
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(128);
					match(T__0);
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(134);
			match(T__1);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(135);
					match(NEWLINE);
					}
					} 
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(141);
			create_solution();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Select_words_questContext extends ParserRuleContext {
		public TerminalNode SELECT_WORDS() { return getToken(TemplateFormativeQuestionParser.SELECT_WORDS, 0); }
		public TerminalNode DESCRIPTION() { return getToken(TemplateFormativeQuestionParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(TemplateFormativeQuestionParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TemplateFormativeQuestionParser.NEWLINE, i);
		}
		public List<Create_solutionContext> create_solution() {
			return getRuleContexts(Create_solutionContext.class);
		}
		public Create_solutionContext create_solution(int i) {
			return getRuleContext(Create_solutionContext.class,i);
		}
		public Select_words_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_words_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).enterSelect_words_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).exitSelect_words_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateFormativeQuestionVisitor ) return ((TemplateFormativeQuestionVisitor<? extends T>)visitor).visitSelect_words_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_words_questContext select_words_quest() throws RecognitionException {
		Select_words_questContext _localctx = new Select_words_questContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_select_words_quest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(SELECT_WORDS);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(144);
					match(T__0);
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(150);
			match(DESCRIPTION);
			setState(154);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(151);
					match(T__0);
					}
					} 
				}
				setState(156);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			setState(157);
			match(T__1);
			setState(161);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(158);
					match(NEWLINE);
					}
					} 
				}
				setState(163);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(165); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(164);
				create_solution();
				}
				}
				setState(167); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_SOLUTION );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class True_false_questContext extends ParserRuleContext {
		public TerminalNode TRUE_FALSE() { return getToken(TemplateFormativeQuestionParser.TRUE_FALSE, 0); }
		public TerminalNode DESCRIPTION() { return getToken(TemplateFormativeQuestionParser.DESCRIPTION, 0); }
		public Create_true_false_solutionContext create_true_false_solution() {
			return getRuleContext(Create_true_false_solutionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(TemplateFormativeQuestionParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TemplateFormativeQuestionParser.NEWLINE, i);
		}
		public True_false_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).enterTrue_false_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).exitTrue_false_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateFormativeQuestionVisitor ) return ((TemplateFormativeQuestionVisitor<? extends T>)visitor).visitTrue_false_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_questContext true_false_quest() throws RecognitionException {
		True_false_questContext _localctx = new True_false_questContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_true_false_quest);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(TRUE_FALSE);
			setState(173);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(170);
					match(T__0);
					}
					} 
				}
				setState(175);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(176);
			match(DESCRIPTION);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(177);
					match(T__0);
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(183);
			match(T__1);
			setState(187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(184);
					match(NEWLINE);
					}
					} 
				}
				setState(189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(190);
			create_true_false_solution();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_optionContext extends ParserRuleContext {
		public TerminalNode ID_OPTION() { return getToken(TemplateFormativeQuestionParser.ID_OPTION, 0); }
		public TerminalNode DESCRIPTION() { return getToken(TemplateFormativeQuestionParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(TemplateFormativeQuestionParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TemplateFormativeQuestionParser.NEWLINE, i);
		}
		public Create_optionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).enterCreate_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).exitCreate_option(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateFormativeQuestionVisitor ) return ((TemplateFormativeQuestionVisitor<? extends T>)visitor).visitCreate_option(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_optionContext create_option() throws RecognitionException {
		Create_optionContext _localctx = new Create_optionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_create_option);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			match(ID_OPTION);
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(193);
					match(T__0);
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(199);
			match(DESCRIPTION);
			setState(203);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(200);
					match(T__0);
					}
					} 
				}
				setState(205);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			setState(206);
			match(T__1);
			setState(210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(207);
					match(NEWLINE);
					}
					} 
				}
				setState(212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_solutionContext extends ParserRuleContext {
		public TerminalNode ID_SOLUTION() { return getToken(TemplateFormativeQuestionParser.ID_SOLUTION, 0); }
		public TerminalNode SOLUTION_TEXT() { return getToken(TemplateFormativeQuestionParser.SOLUTION_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(TemplateFormativeQuestionParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TemplateFormativeQuestionParser.NEWLINE, i);
		}
		public Create_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).enterCreate_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).exitCreate_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateFormativeQuestionVisitor ) return ((TemplateFormativeQuestionVisitor<? extends T>)visitor).visitCreate_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_solutionContext create_solution() throws RecognitionException {
		Create_solutionContext _localctx = new Create_solutionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_create_solution);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(ID_SOLUTION);
			setState(217);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(214);
					match(T__0);
					}
					} 
				}
				setState(219);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(220);
			match(SOLUTION_TEXT);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(221);
					match(T__0);
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(227);
			match(T__1);
			setState(231);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(228);
					match(NEWLINE);
					}
					} 
				}
				setState(233);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Create_true_false_solutionContext extends ParserRuleContext {
		public TerminalNode ID_SOLUTION() { return getToken(TemplateFormativeQuestionParser.ID_SOLUTION, 0); }
		public TerminalNode TRUE_FALSE_SOLUTION_TEXT() { return getToken(TemplateFormativeQuestionParser.TRUE_FALSE_SOLUTION_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(TemplateFormativeQuestionParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(TemplateFormativeQuestionParser.NEWLINE, i);
		}
		public Create_true_false_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_true_false_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).enterCreate_true_false_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TemplateFormativeQuestionListener ) ((TemplateFormativeQuestionListener)listener).exitCreate_true_false_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TemplateFormativeQuestionVisitor ) return ((TemplateFormativeQuestionVisitor<? extends T>)visitor).visitCreate_true_false_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_true_false_solutionContext create_true_false_solution() throws RecognitionException {
		Create_true_false_solutionContext _localctx = new Create_true_false_solutionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_create_true_false_solution);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(ID_SOLUTION);
			setState(238);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(235);
					match(T__0);
					}
					} 
				}
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(241);
			match(TRUE_FALSE_SOLUTION_TEXT);
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(242);
					match(T__0);
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			setState(248);
			match(T__1);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(249);
					match(NEWLINE);
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0012\u0100\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001\u001f\b\u0001\u0001\u0002\u0001\u0002\u0005\u0002#\b\u0002"+
		"\n\u0002\f\u0002&\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002*\b\u0002"+
		"\n\u0002\f\u0002-\t\u0002\u0001\u0002\u0001\u0002\u0005\u00021\b\u0002"+
		"\n\u0002\f\u00024\t\u0002\u0001\u0002\u0004\u00027\b\u0002\u000b\u0002"+
		"\f\u00028\u0001\u0002\u0004\u0002<\b\u0002\u000b\u0002\f\u0002=\u0001"+
		"\u0003\u0001\u0003\u0005\u0003B\b\u0003\n\u0003\f\u0003E\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003I\b\u0003\n\u0003\f\u0003L\t\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003P\b\u0003\n\u0003\f\u0003S\t\u0003\u0001"+
		"\u0003\u0004\u0003V\b\u0003\u000b\u0003\f\u0003W\u0001\u0003\u0004\u0003"+
		"[\b\u0003\u000b\u0003\f\u0003\\\u0001\u0004\u0001\u0004\u0005\u0004a\b"+
		"\u0004\n\u0004\f\u0004d\t\u0004\u0001\u0004\u0001\u0004\u0005\u0004h\b"+
		"\u0004\n\u0004\f\u0004k\t\u0004\u0001\u0004\u0001\u0004\u0005\u0004o\b"+
		"\u0004\n\u0004\f\u0004r\t\u0004\u0001\u0004\u0004\u0004u\b\u0004\u000b"+
		"\u0004\f\u0004v\u0001\u0005\u0001\u0005\u0005\u0005{\b\u0005\n\u0005\f"+
		"\u0005~\t\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0082\b\u0005\n\u0005"+
		"\f\u0005\u0085\t\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0089\b\u0005"+
		"\n\u0005\f\u0005\u008c\t\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0005\u0006\u0092\b\u0006\n\u0006\f\u0006\u0095\t\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006\u0099\b\u0006\n\u0006\f\u0006\u009c\t\u0006\u0001"+
		"\u0006\u0001\u0006\u0005\u0006\u00a0\b\u0006\n\u0006\f\u0006\u00a3\t\u0006"+
		"\u0001\u0006\u0004\u0006\u00a6\b\u0006\u000b\u0006\f\u0006\u00a7\u0001"+
		"\u0007\u0001\u0007\u0005\u0007\u00ac\b\u0007\n\u0007\f\u0007\u00af\t\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007\u00b3\b\u0007\n\u0007\f\u0007\u00b6"+
		"\t\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u00ba\b\u0007\n\u0007\f\u0007"+
		"\u00bd\t\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b\u00c3\b"+
		"\b\n\b\f\b\u00c6\t\b\u0001\b\u0001\b\u0005\b\u00ca\b\b\n\b\f\b\u00cd\t"+
		"\b\u0001\b\u0001\b\u0005\b\u00d1\b\b\n\b\f\b\u00d4\t\b\u0001\t\u0001\t"+
		"\u0005\t\u00d8\b\t\n\t\f\t\u00db\t\t\u0001\t\u0001\t\u0005\t\u00df\b\t"+
		"\n\t\f\t\u00e2\t\t\u0001\t\u0001\t\u0005\t\u00e6\b\t\n\t\f\t\u00e9\t\t"+
		"\u0001\n\u0001\n\u0005\n\u00ed\b\n\n\n\f\n\u00f0\t\n\u0001\n\u0001\n\u0005"+
		"\n\u00f4\b\n\n\n\f\n\u00f7\t\n\u0001\n\u0001\n\u0005\n\u00fb\b\n\n\n\f"+
		"\n\u00fe\t\n\u0001\n\u001b$+2CJQbip|\u0083\u008a\u0093\u009a\u00a1\u00ad"+
		"\u00b4\u00bb\u00c4\u00cb\u00d2\u00d9\u00e0\u00e7\u00ee\u00f5\u00fc\u0000"+
		"\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0000\u0000"+
		"\u011a\u0000\u0016\u0001\u0000\u0000\u0000\u0002\u001e\u0001\u0000\u0000"+
		"\u0000\u0004 \u0001\u0000\u0000\u0000\u0006?\u0001\u0000\u0000\u0000\b"+
		"^\u0001\u0000\u0000\u0000\nx\u0001\u0000\u0000\u0000\f\u008f\u0001\u0000"+
		"\u0000\u0000\u000e\u00a9\u0001\u0000\u0000\u0000\u0010\u00c0\u0001\u0000"+
		"\u0000\u0000\u0012\u00d5\u0001\u0000\u0000\u0000\u0014\u00ea\u0001\u0000"+
		"\u0000\u0000\u0016\u0017\u0003\u0002\u0001\u0000\u0017\u0001\u0001\u0000"+
		"\u0000\u0000\u0018\u001f\u0003\u0004\u0002\u0000\u0019\u001f\u0003\u0006"+
		"\u0003\u0000\u001a\u001f\u0003\b\u0004\u0000\u001b\u001f\u0003\n\u0005"+
		"\u0000\u001c\u001f\u0003\f\u0006\u0000\u001d\u001f\u0003\u000e\u0007\u0000"+
		"\u001e\u0018\u0001\u0000\u0000\u0000\u001e\u0019\u0001\u0000\u0000\u0000"+
		"\u001e\u001a\u0001\u0000\u0000\u0000\u001e\u001b\u0001\u0000\u0000\u0000"+
		"\u001e\u001c\u0001\u0000\u0000\u0000\u001e\u001d\u0001\u0000\u0000\u0000"+
		"\u001f\u0003\u0001\u0000\u0000\u0000 $\u0005\u0005\u0000\u0000!#\u0005"+
		"\u0001\u0000\u0000\"!\u0001\u0000\u0000\u0000#&\u0001\u0000\u0000\u0000"+
		"$%\u0001\u0000\u0000\u0000$\"\u0001\u0000\u0000\u0000%\'\u0001\u0000\u0000"+
		"\u0000&$\u0001\u0000\u0000\u0000\'+\u0005\u000f\u0000\u0000(*\u0005\u0001"+
		"\u0000\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+,\u0001"+
		"\u0000\u0000\u0000+)\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000"+
		"-+\u0001\u0000\u0000\u0000.2\u0005\u0002\u0000\u0000/1\u0005\u0011\u0000"+
		"\u00000/\u0001\u0000\u0000\u000014\u0001\u0000\u0000\u000023\u0001\u0000"+
		"\u0000\u000020\u0001\u0000\u0000\u000036\u0001\u0000\u0000\u000042\u0001"+
		"\u0000\u0000\u000057\u0003\u0010\b\u000065\u0001\u0000\u0000\u000078\u0001"+
		"\u0000\u0000\u000086\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u0000"+
		"9;\u0001\u0000\u0000\u0000:<\u0003\u0012\t\u0000;:\u0001\u0000\u0000\u0000"+
		"<=\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000"+
		"\u0000>\u0005\u0001\u0000\u0000\u0000?C\u0005\u0006\u0000\u0000@B\u0005"+
		"\u0001\u0000\u0000A@\u0001\u0000\u0000\u0000BE\u0001\u0000\u0000\u0000"+
		"CD\u0001\u0000\u0000\u0000CA\u0001\u0000\u0000\u0000DF\u0001\u0000\u0000"+
		"\u0000EC\u0001\u0000\u0000\u0000FJ\u0005\u000f\u0000\u0000GI\u0005\u0001"+
		"\u0000\u0000HG\u0001\u0000\u0000\u0000IL\u0001\u0000\u0000\u0000JK\u0001"+
		"\u0000\u0000\u0000JH\u0001\u0000\u0000\u0000KM\u0001\u0000\u0000\u0000"+
		"LJ\u0001\u0000\u0000\u0000MQ\u0005\u0002\u0000\u0000NP\u0005\u0011\u0000"+
		"\u0000ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QR\u0001\u0000"+
		"\u0000\u0000QO\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001"+
		"\u0000\u0000\u0000TV\u0003\u0010\b\u0000UT\u0001\u0000\u0000\u0000VW\u0001"+
		"\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000"+
		"XZ\u0001\u0000\u0000\u0000Y[\u0003\u0012\t\u0000ZY\u0001\u0000\u0000\u0000"+
		"[\\\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000"+
		"\u0000\u0000]\u0007\u0001\u0000\u0000\u0000^b\u0005\u0007\u0000\u0000"+
		"_a\u0005\u0001\u0000\u0000`_\u0001\u0000\u0000\u0000ad\u0001\u0000\u0000"+
		"\u0000bc\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000ce\u0001\u0000"+
		"\u0000\u0000db\u0001\u0000\u0000\u0000ei\u0005\u000f\u0000\u0000fh\u0005"+
		"\u0001\u0000\u0000gf\u0001\u0000\u0000\u0000hk\u0001\u0000\u0000\u0000"+
		"ij\u0001\u0000\u0000\u0000ig\u0001\u0000\u0000\u0000jl\u0001\u0000\u0000"+
		"\u0000ki\u0001\u0000\u0000\u0000lp\u0005\u0002\u0000\u0000mo\u0005\u0011"+
		"\u0000\u0000nm\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pq\u0001"+
		"\u0000\u0000\u0000pn\u0001\u0000\u0000\u0000qt\u0001\u0000\u0000\u0000"+
		"rp\u0001\u0000\u0000\u0000su\u0003\u0012\t\u0000ts\u0001\u0000\u0000\u0000"+
		"uv\u0001\u0000\u0000\u0000vt\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000w\t\u0001\u0000\u0000\u0000x|\u0005\b\u0000\u0000y{\u0005\u0001"+
		"\u0000\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000\u0000|}\u0001"+
		"\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}\u007f\u0001\u0000\u0000"+
		"\u0000~|\u0001\u0000\u0000\u0000\u007f\u0083\u0005\u000f\u0000\u0000\u0080"+
		"\u0082\u0005\u0001\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082"+
		"\u0085\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0083"+
		"\u0081\u0001\u0000\u0000\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0086\u008a\u0005\u0002\u0000\u0000\u0087"+
		"\u0089\u0005\u0011\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089"+
		"\u008c\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000\u008a"+
		"\u0088\u0001\u0000\u0000\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c"+
		"\u008a\u0001\u0000\u0000\u0000\u008d\u008e\u0003\u0012\t\u0000\u008e\u000b"+
		"\u0001\u0000\u0000\u0000\u008f\u0093\u0005\t\u0000\u0000\u0090\u0092\u0005"+
		"\u0001\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0095\u0001"+
		"\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0093\u0091\u0001"+
		"\u0000\u0000\u0000\u0094\u0096\u0001\u0000\u0000\u0000\u0095\u0093\u0001"+
		"\u0000\u0000\u0000\u0096\u009a\u0005\u000f\u0000\u0000\u0097\u0099\u0005"+
		"\u0001\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000\u0099\u009c\u0001"+
		"\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009a\u0098\u0001"+
		"\u0000\u0000\u0000\u009b\u009d\u0001\u0000\u0000\u0000\u009c\u009a\u0001"+
		"\u0000\u0000\u0000\u009d\u00a1\u0005\u0002\u0000\u0000\u009e\u00a0\u0005"+
		"\u0011\u0000\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u00a0\u00a3\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a2\u0001\u0000\u0000\u0000\u00a1\u009f\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a5\u0001\u0000\u0000\u0000\u00a3\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a6\u0003\u0012\t\u0000\u00a5\u00a4\u0001\u0000"+
		"\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000"+
		"\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\r\u0001\u0000\u0000"+
		"\u0000\u00a9\u00ad\u0005\n\u0000\u0000\u00aa\u00ac\u0005\u0001\u0000\u0000"+
		"\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ac\u00af\u0001\u0000\u0000\u0000"+
		"\u00ad\u00ae\u0001\u0000\u0000\u0000\u00ad\u00ab\u0001\u0000\u0000\u0000"+
		"\u00ae\u00b0\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000"+
		"\u00b0\u00b4\u0005\u000f\u0000\u0000\u00b1\u00b3\u0005\u0001\u0000\u0000"+
		"\u00b2\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b5\u00b7\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b7\u00bb\u0005\u0002\u0000\u0000\u00b8\u00ba\u0005\u0011\u0000\u0000"+
		"\u00b9\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bd\u0001\u0000\u0000\u0000"+
		"\u00bb\u00bc\u0001\u0000\u0000\u0000\u00bb\u00b9\u0001\u0000\u0000\u0000"+
		"\u00bc\u00be\u0001\u0000\u0000\u0000\u00bd\u00bb\u0001\u0000\u0000\u0000"+
		"\u00be\u00bf\u0003\u0014\n\u0000\u00bf\u000f\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c4\u0005\u0003\u0000\u0000\u00c1\u00c3\u0005\u0001\u0000\u0000\u00c2"+
		"\u00c1\u0001\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c7"+
		"\u00cb\u0005\u000f\u0000\u0000\u00c8\u00ca\u0005\u0001\u0000\u0000\u00c9"+
		"\u00c8\u0001\u0000\u0000\u0000\u00ca\u00cd\u0001\u0000\u0000\u0000\u00cb"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00ce"+
		"\u00d2\u0005\u0002\u0000\u0000\u00cf\u00d1\u0005\u0011\u0000\u0000\u00d0"+
		"\u00cf\u0001\u0000\u0000\u0000\u00d1\u00d4\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d2\u00d0\u0001\u0000\u0000\u0000\u00d3"+
		"\u0011\u0001\u0000\u0000\u0000\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d9\u0005\u0004\u0000\u0000\u00d6\u00d8\u0005\u0001\u0000\u0000\u00d7"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9"+
		"\u00da\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001\u0000\u0000\u0000\u00da"+
		"\u00dc\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc"+
		"\u00e0\u0005\u000b\u0000\u0000\u00dd\u00df\u0005\u0001\u0000\u0000\u00de"+
		"\u00dd\u0001\u0000\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0"+
		"\u00e1\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000\u0000\u00e1"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3"+
		"\u00e7\u0005\u0002\u0000\u0000\u00e4\u00e6\u0005\u0011\u0000\u0000\u00e5"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8"+
		"\u0013\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea"+
		"\u00ee\u0005\u0004\u0000\u0000\u00eb\u00ed\u0005\u0001\u0000\u0000\u00ec"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ed\u00f0\u0001\u0000\u0000\u0000\u00ee"+
		"\u00ef\u0001\u0000\u0000\u0000\u00ee\u00ec\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f1\u0001\u0000\u0000\u0000\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1"+
		"\u00f5\u0005\f\u0000\u0000\u00f2\u00f4\u0005\u0001\u0000\u0000\u00f3\u00f2"+
		"\u0001\u0000\u0000\u0000\u00f4\u00f7\u0001\u0000\u0000\u0000\u00f5\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f6\u00f8"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8\u00fc"+
		"\u0005\u0002\u0000\u0000\u00f9\u00fb\u0005\u0011\u0000\u0000\u00fa\u00f9"+
		"\u0001\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fd"+
		"\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001\u0000\u0000\u0000\u00fd\u0015"+
		"\u0001\u0000\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\"\u001e$"+
		"+28=CJQW\\bipv|\u0083\u008a\u0093\u009a\u00a1\u00a7\u00ad\u00b4\u00bb"+
		"\u00c4\u00cb\u00d2\u00d9\u00e0\u00e7\u00ee\u00f5\u00fc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}