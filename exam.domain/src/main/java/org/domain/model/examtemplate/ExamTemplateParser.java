// Generated from C:/Users/bruna/IdeaProjects/sem4pi-22-23-8/exam.domain/src/main/java/org/domain/model/examtemplate\ExamTemplate.g4 by ANTLR 4.12.0
package org.domain.model.examtemplate;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExamTemplateParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, ID_OPTION=3, ID_SOLUTION=4, ID_EXAM=5, ID_EXAM_DESCRIPTION=6, 
		ID_OPEN_DATE=7, ID_CLOSE_DATE=8, ID_FEEDBACK_TYPE=9, ID_GRADE_TYPE=10, 
		ID_SECTION=11, DATE=12, TIME_TYPE=13, MATCHING=14, MULTIPLE_CHOICE=15, 
		SHORT_ANSWER=16, NUMERICAL=17, SELECT_WORDS=18, TRUE_FALSE=19, SOLUTION_TEXT=20, 
		TRUE_FALSE_SOLUTION_TEXT=21, SOL_DESCRIPTION=22, TRUE_FALSE_SOL_DESCRIPTION=23, 
		DESCRIPTION=24, NUMBER=25, NEWLINE=26, DECIMAL=27;
	public static final int
		RULE_start = 0, RULE_exam = 1, RULE_create_section = 2, RULE_quest = 3, 
		RULE_matching_quest = 4, RULE_multiple_choice_quest = 5, RULE_short_answer_quest = 6, 
		RULE_numerical_quest = 7, RULE_select_words_quest = 8, RULE_true_false_quest = 9, 
		RULE_create_option = 10, RULE_create_solution = 11, RULE_create_true_false_solution = 12, 
		RULE_create_exam_header = 13, RULE_create_exam = 14, RULE_create_exam_description = 15, 
		RULE_create_open_date = 16, RULE_create_close_date = 17, RULE_create_feedback_type = 18, 
		RULE_create_grade_type = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"start", "exam", "create_section", "quest", "matching_quest", "multiple_choice_quest", 
			"short_answer_quest", "numerical_quest", "select_words_quest", "true_false_quest", 
			"create_option", "create_solution", "create_true_false_solution", "create_exam_header", 
			"create_exam", "create_exam_description", "create_open_date", "create_close_date", 
			"create_feedback_type", "create_grade_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "' '", "';'", "'OPT'", "'SOL'", "'EXAM'", "'EXAM_DESCRIPTION'", 
			"'OPEN_DATE'", "'CLOSE_DATE'", "'FEEDBACK_TYPE'", "'GRADE_TYPE'", "'SECTION'", 
			null, null, "'MQUES'", "'MCQUES'", "'SAQUES'", "'NQUES'", "'SWQUES'", 
			"'TFQUES'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, "ID_OPTION", "ID_SOLUTION", "ID_EXAM", "ID_EXAM_DESCRIPTION", 
			"ID_OPEN_DATE", "ID_CLOSE_DATE", "ID_FEEDBACK_TYPE", "ID_GRADE_TYPE", 
			"ID_SECTION", "DATE", "TIME_TYPE", "MATCHING", "MULTIPLE_CHOICE", "SHORT_ANSWER", 
			"NUMERICAL", "SELECT_WORDS", "TRUE_FALSE", "SOLUTION_TEXT", "TRUE_FALSE_SOLUTION_TEXT", 
			"SOL_DESCRIPTION", "TRUE_FALSE_SOL_DESCRIPTION", "DESCRIPTION", "NUMBER", 
			"NEWLINE", "DECIMAL"
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
	public String getGrammarFileName() { return "ExamTemplate.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExamTemplateParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StartContext extends ParserRuleContext {
		public ExamContext exam() {
			return getRuleContext(ExamContext.class,0);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			exam();
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
	public static class ExamContext extends ParserRuleContext {
		public Create_exam_headerContext create_exam_header() {
			return getRuleContext(Create_exam_headerContext.class,0);
		}
		public List<Create_sectionContext> create_section() {
			return getRuleContexts(Create_sectionContext.class);
		}
		public Create_sectionContext create_section(int i) {
			return getRuleContext(Create_sectionContext.class,i);
		}
		public ExamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterExam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitExam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitExam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExamContext exam() throws RecognitionException {
		ExamContext _localctx = new ExamContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			create_exam_header();
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				create_section();
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_SECTION );
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
	public static class Create_sectionContext extends ParserRuleContext {
		public TerminalNode ID_SECTION() { return getToken(ExamTemplateParser.ID_SECTION, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ExamTemplateParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public List<QuestContext> quest() {
			return getRuleContexts(QuestContext.class);
		}
		public QuestContext quest(int i) {
			return getRuleContext(QuestContext.class,i);
		}
		public Create_sectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterCreate_section(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitCreate_section(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitCreate_section(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_sectionContext create_section() throws RecognitionException {
		Create_sectionContext _localctx = new Create_sectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_create_section);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(ID_SECTION);
			setState(52);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(49);
					match(T__0);
					}
					} 
				}
				setState(54);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(55);
			match(DESCRIPTION);
			setState(59);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(56);
					match(T__0);
					}
					} 
				}
				setState(61);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(62);
			match(T__1);
			setState(66);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(63);
					match(NEWLINE);
					}
					} 
				}
				setState(68);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			setState(70); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(69);
				quest();
				}
				}
				setState(72); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1032192L) != 0) );
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
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterQuest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitQuest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitQuest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestContext quest() throws RecognitionException {
		QuestContext _localctx = new QuestContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_quest);
		try {
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATCHING:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				matching_quest();
				}
				break;
			case MULTIPLE_CHOICE:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				multiple_choice_quest();
				}
				break;
			case SHORT_ANSWER:
				enterOuterAlt(_localctx, 3);
				{
				setState(76);
				short_answer_quest();
				}
				break;
			case NUMERICAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(77);
				numerical_quest();
				}
				break;
			case SELECT_WORDS:
				enterOuterAlt(_localctx, 5);
				{
				setState(78);
				select_words_quest();
				}
				break;
			case TRUE_FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(79);
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
		public TerminalNode MATCHING() { return getToken(ExamTemplateParser.MATCHING, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ExamTemplateParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
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
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterMatching_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitMatching_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitMatching_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_questContext matching_quest() throws RecognitionException {
		Matching_questContext _localctx = new Matching_questContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_matching_quest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(MATCHING);
			setState(86);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(83);
					match(T__0);
					}
					} 
				}
				setState(88);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			}
			setState(89);
			match(DESCRIPTION);
			setState(93);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(90);
					match(T__0);
					}
					} 
				}
				setState(95);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(96);
			match(T__1);
			setState(100);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(97);
					match(NEWLINE);
					}
					} 
				}
				setState(102);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(104); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(103);
				create_option();
				}
				}
				setState(106); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_OPTION );
			setState(109); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(108);
				create_solution();
				}
				}
				setState(111); 
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
		public TerminalNode MULTIPLE_CHOICE() { return getToken(ExamTemplateParser.MULTIPLE_CHOICE, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ExamTemplateParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
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
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterMultiple_choice_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitMultiple_choice_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitMultiple_choice_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_questContext multiple_choice_quest() throws RecognitionException {
		Multiple_choice_questContext _localctx = new Multiple_choice_questContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_multiple_choice_quest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(113);
			match(MULTIPLE_CHOICE);
			setState(117);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(114);
					match(T__0);
					}
					} 
				}
				setState(119);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(120);
			match(DESCRIPTION);
			setState(124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(127);
			match(T__1);
			setState(131);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(128);
					match(NEWLINE);
					}
					} 
				}
				setState(133);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(135); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(134);
				create_option();
				}
				}
				setState(137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==ID_OPTION );
			setState(140); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(139);
				create_solution();
				}
				}
				setState(142); 
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
		public TerminalNode SHORT_ANSWER() { return getToken(ExamTemplateParser.SHORT_ANSWER, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ExamTemplateParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
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
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterShort_answer_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitShort_answer_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitShort_answer_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_answer_questContext short_answer_quest() throws RecognitionException {
		Short_answer_questContext _localctx = new Short_answer_questContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_short_answer_quest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(SHORT_ANSWER);
			setState(148);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(145);
					match(T__0);
					}
					} 
				}
				setState(150);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			setState(151);
			match(DESCRIPTION);
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(152);
					match(T__0);
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(158);
			match(T__1);
			setState(162);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(159);
					match(NEWLINE);
					}
					} 
				}
				setState(164);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(166); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(165);
				create_solution();
				}
				}
				setState(168); 
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
		public TerminalNode NUMERICAL() { return getToken(ExamTemplateParser.NUMERICAL, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ExamTemplateParser.DESCRIPTION, 0); }
		public Create_solutionContext create_solution() {
			return getRuleContext(Create_solutionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public Numerical_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterNumerical_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitNumerical_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitNumerical_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numerical_questContext numerical_quest() throws RecognitionException {
		Numerical_questContext _localctx = new Numerical_questContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_numerical_quest);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			match(NUMERICAL);
			setState(174);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(171);
					match(T__0);
					}
					} 
				}
				setState(176);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
			}
			setState(177);
			match(DESCRIPTION);
			setState(181);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(178);
					match(T__0);
					}
					} 
				}
				setState(183);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			}
			setState(184);
			match(T__1);
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(185);
					match(NEWLINE);
					}
					} 
				}
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			setState(191);
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
		public TerminalNode SELECT_WORDS() { return getToken(ExamTemplateParser.SELECT_WORDS, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ExamTemplateParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
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
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterSelect_words_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitSelect_words_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitSelect_words_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_words_questContext select_words_quest() throws RecognitionException {
		Select_words_questContext _localctx = new Select_words_questContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_select_words_quest);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(SELECT_WORDS);
			setState(197);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(194);
					match(T__0);
					}
					} 
				}
				setState(199);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(200);
			match(DESCRIPTION);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(201);
					match(T__0);
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			}
			setState(207);
			match(T__1);
			setState(211);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(208);
					match(NEWLINE);
					}
					} 
				}
				setState(213);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			setState(215); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(214);
				create_solution();
				}
				}
				setState(217); 
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
		public TerminalNode TRUE_FALSE() { return getToken(ExamTemplateParser.TRUE_FALSE, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ExamTemplateParser.DESCRIPTION, 0); }
		public Create_true_false_solutionContext create_true_false_solution() {
			return getRuleContext(Create_true_false_solutionContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public True_false_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterTrue_false_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitTrue_false_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitTrue_false_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_questContext true_false_quest() throws RecognitionException {
		True_false_questContext _localctx = new True_false_questContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_true_false_quest);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(219);
			match(TRUE_FALSE);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(220);
					match(T__0);
					}
					} 
				}
				setState(225);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(226);
			match(DESCRIPTION);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(227);
					match(T__0);
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			}
			setState(233);
			match(T__1);
			setState(237);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(234);
					match(NEWLINE);
					}
					} 
				}
				setState(239);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			setState(240);
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
		public TerminalNode ID_OPTION() { return getToken(ExamTemplateParser.ID_OPTION, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ExamTemplateParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public Create_optionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_option; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterCreate_option(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitCreate_option(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitCreate_option(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_optionContext create_option() throws RecognitionException {
		Create_optionContext _localctx = new Create_optionContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_create_option);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			match(ID_OPTION);
			setState(246);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(243);
					match(T__0);
					}
					} 
				}
				setState(248);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(249);
			match(DESCRIPTION);
			setState(253);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(250);
					match(T__0);
					}
					} 
				}
				setState(255);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(256);
			match(T__1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(257);
					match(NEWLINE);
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
		public TerminalNode ID_SOLUTION() { return getToken(ExamTemplateParser.ID_SOLUTION, 0); }
		public TerminalNode SOLUTION_TEXT() { return getToken(ExamTemplateParser.SOLUTION_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public Create_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterCreate_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitCreate_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitCreate_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_solutionContext create_solution() throws RecognitionException {
		Create_solutionContext _localctx = new Create_solutionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_create_solution);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			match(ID_SOLUTION);
			setState(267);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(264);
					match(T__0);
					}
					} 
				}
				setState(269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
			}
			setState(270);
			match(SOLUTION_TEXT);
			setState(274);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(271);
					match(T__0);
					}
					} 
				}
				setState(276);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			setState(277);
			match(T__1);
			setState(281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(278);
					match(NEWLINE);
					}
					} 
				}
				setState(283);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
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
		public TerminalNode ID_SOLUTION() { return getToken(ExamTemplateParser.ID_SOLUTION, 0); }
		public TerminalNode TRUE_FALSE_SOLUTION_TEXT() { return getToken(ExamTemplateParser.TRUE_FALSE_SOLUTION_TEXT, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public Create_true_false_solutionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_true_false_solution; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterCreate_true_false_solution(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitCreate_true_false_solution(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitCreate_true_false_solution(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_true_false_solutionContext create_true_false_solution() throws RecognitionException {
		Create_true_false_solutionContext _localctx = new Create_true_false_solutionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_create_true_false_solution);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			match(ID_SOLUTION);
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(285);
					match(T__0);
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			setState(291);
			match(TRUE_FALSE_SOLUTION_TEXT);
			setState(295);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(292);
					match(T__0);
					}
					} 
				}
				setState(297);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			setState(298);
			match(T__1);
			setState(302);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(299);
					match(NEWLINE);
					}
					} 
				}
				setState(304);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
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
	public static class Create_exam_headerContext extends ParserRuleContext {
		public Create_examContext create_exam() {
			return getRuleContext(Create_examContext.class,0);
		}
		public Create_exam_descriptionContext create_exam_description() {
			return getRuleContext(Create_exam_descriptionContext.class,0);
		}
		public Create_open_dateContext create_open_date() {
			return getRuleContext(Create_open_dateContext.class,0);
		}
		public Create_close_dateContext create_close_date() {
			return getRuleContext(Create_close_dateContext.class,0);
		}
		public Create_feedback_typeContext create_feedback_type() {
			return getRuleContext(Create_feedback_typeContext.class,0);
		}
		public Create_grade_typeContext create_grade_type() {
			return getRuleContext(Create_grade_typeContext.class,0);
		}
		public Create_exam_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_exam_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterCreate_exam_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitCreate_exam_header(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitCreate_exam_header(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_exam_headerContext create_exam_header() throws RecognitionException {
		Create_exam_headerContext _localctx = new Create_exam_headerContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_create_exam_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305);
			create_exam();
			setState(306);
			create_exam_description();
			setState(307);
			create_open_date();
			setState(308);
			create_close_date();
			setState(309);
			create_feedback_type();
			setState(310);
			create_grade_type();
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
	public static class Create_examContext extends ParserRuleContext {
		public TerminalNode ID_EXAM() { return getToken(ExamTemplateParser.ID_EXAM, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ExamTemplateParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public Create_examContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_exam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterCreate_exam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitCreate_exam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitCreate_exam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_examContext create_exam() throws RecognitionException {
		Create_examContext _localctx = new Create_examContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_create_exam);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			match(ID_EXAM);
			setState(316);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(313);
					match(T__0);
					}
					} 
				}
				setState(318);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,39,_ctx);
			}
			setState(319);
			match(DESCRIPTION);
			setState(323);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(320);
					match(T__0);
					}
					} 
				}
				setState(325);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,40,_ctx);
			}
			setState(326);
			match(T__1);
			setState(330);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(327);
					match(NEWLINE);
					}
					} 
				}
				setState(332);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,41,_ctx);
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
	public static class Create_exam_descriptionContext extends ParserRuleContext {
		public TerminalNode ID_EXAM_DESCRIPTION() { return getToken(ExamTemplateParser.ID_EXAM_DESCRIPTION, 0); }
		public TerminalNode DESCRIPTION() { return getToken(ExamTemplateParser.DESCRIPTION, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public Create_exam_descriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_exam_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterCreate_exam_description(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitCreate_exam_description(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitCreate_exam_description(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_exam_descriptionContext create_exam_description() throws RecognitionException {
		Create_exam_descriptionContext _localctx = new Create_exam_descriptionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_create_exam_description);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(ID_EXAM_DESCRIPTION);
			setState(337);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(334);
					match(T__0);
					}
					} 
				}
				setState(339);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,42,_ctx);
			}
			setState(340);
			match(DESCRIPTION);
			setState(344);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(341);
					match(T__0);
					}
					} 
				}
				setState(346);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			}
			setState(347);
			match(T__1);
			setState(351);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(348);
					match(NEWLINE);
					}
					} 
				}
				setState(353);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,44,_ctx);
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
	public static class Create_open_dateContext extends ParserRuleContext {
		public TerminalNode ID_OPEN_DATE() { return getToken(ExamTemplateParser.ID_OPEN_DATE, 0); }
		public TerminalNode DATE() { return getToken(ExamTemplateParser.DATE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public Create_open_dateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_open_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterCreate_open_date(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitCreate_open_date(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitCreate_open_date(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_open_dateContext create_open_date() throws RecognitionException {
		Create_open_dateContext _localctx = new Create_open_dateContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_create_open_date);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			match(ID_OPEN_DATE);
			setState(358);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(355);
					match(T__0);
					}
					} 
				}
				setState(360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			setState(361);
			match(DATE);
			setState(365);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(362);
					match(T__0);
					}
					} 
				}
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
			}
			setState(368);
			match(T__1);
			setState(372);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(369);
					match(NEWLINE);
					}
					} 
				}
				setState(374);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
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
	public static class Create_close_dateContext extends ParserRuleContext {
		public TerminalNode ID_CLOSE_DATE() { return getToken(ExamTemplateParser.ID_CLOSE_DATE, 0); }
		public TerminalNode DATE() { return getToken(ExamTemplateParser.DATE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public Create_close_dateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_close_date; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterCreate_close_date(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitCreate_close_date(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitCreate_close_date(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_close_dateContext create_close_date() throws RecognitionException {
		Create_close_dateContext _localctx = new Create_close_dateContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_create_close_date);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			match(ID_CLOSE_DATE);
			setState(379);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(376);
					match(T__0);
					}
					} 
				}
				setState(381);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			setState(382);
			match(DATE);
			setState(386);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(383);
					match(T__0);
					}
					} 
				}
				setState(388);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,49,_ctx);
			}
			setState(389);
			match(T__1);
			setState(393);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(390);
					match(NEWLINE);
					}
					} 
				}
				setState(395);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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
	public static class Create_feedback_typeContext extends ParserRuleContext {
		public TerminalNode ID_FEEDBACK_TYPE() { return getToken(ExamTemplateParser.ID_FEEDBACK_TYPE, 0); }
		public TerminalNode TIME_TYPE() { return getToken(ExamTemplateParser.TIME_TYPE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public Create_feedback_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_feedback_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterCreate_feedback_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitCreate_feedback_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitCreate_feedback_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_feedback_typeContext create_feedback_type() throws RecognitionException {
		Create_feedback_typeContext _localctx = new Create_feedback_typeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_create_feedback_type);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(396);
			match(ID_FEEDBACK_TYPE);
			setState(400);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(397);
					match(T__0);
					}
					} 
				}
				setState(402);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			setState(403);
			match(TIME_TYPE);
			setState(407);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(404);
					match(T__0);
					}
					} 
				}
				setState(409);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			}
			setState(410);
			match(T__1);
			setState(414);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(411);
					match(NEWLINE);
					}
					} 
				}
				setState(416);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
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
	public static class Create_grade_typeContext extends ParserRuleContext {
		public TerminalNode ID_GRADE_TYPE() { return getToken(ExamTemplateParser.ID_GRADE_TYPE, 0); }
		public TerminalNode TIME_TYPE() { return getToken(ExamTemplateParser.TIME_TYPE, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(ExamTemplateParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExamTemplateParser.NEWLINE, i);
		}
		public Create_grade_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_create_grade_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).enterCreate_grade_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamTemplateListener ) ((ExamTemplateListener)listener).exitCreate_grade_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamTemplateVisitor ) return ((ExamTemplateVisitor<? extends T>)visitor).visitCreate_grade_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Create_grade_typeContext create_grade_type() throws RecognitionException {
		Create_grade_typeContext _localctx = new Create_grade_typeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_create_grade_type);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(417);
			match(ID_GRADE_TYPE);
			setState(421);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(418);
					match(T__0);
					}
					} 
				}
				setState(423);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			setState(424);
			match(TIME_TYPE);
			setState(428);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(425);
					match(T__0);
					}
					} 
				}
				setState(430);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			}
			setState(431);
			match(T__1);
			setState(435);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					{
					setState(432);
					match(NEWLINE);
					}
					} 
				}
				setState(437);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,56,_ctx);
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
		"\u0004\u0001\u001b\u01b7\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0001\u0001"+
		"\u0001\u0004\u0001-\b\u0001\u000b\u0001\f\u0001.\u0001\u0002\u0001\u0002"+
		"\u0005\u00023\b\u0002\n\u0002\f\u00026\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002:\b\u0002\n\u0002\f\u0002=\t\u0002\u0001\u0002\u0001\u0002"+
		"\u0005\u0002A\b\u0002\n\u0002\f\u0002D\t\u0002\u0001\u0002\u0004\u0002"+
		"G\b\u0002\u000b\u0002\f\u0002H\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003Q\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0005\u0004U\b\u0004\n\u0004\f\u0004X\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004\\\b\u0004\n\u0004\f\u0004_\t\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004c\b\u0004\n\u0004\f\u0004f\t\u0004\u0001\u0004\u0004"+
		"\u0004i\b\u0004\u000b\u0004\f\u0004j\u0001\u0004\u0004\u0004n\b\u0004"+
		"\u000b\u0004\f\u0004o\u0001\u0005\u0001\u0005\u0005\u0005t\b\u0005\n\u0005"+
		"\f\u0005w\t\u0005\u0001\u0005\u0001\u0005\u0005\u0005{\b\u0005\n\u0005"+
		"\f\u0005~\t\u0005\u0001\u0005\u0001\u0005\u0005\u0005\u0082\b\u0005\n"+
		"\u0005\f\u0005\u0085\t\u0005\u0001\u0005\u0004\u0005\u0088\b\u0005\u000b"+
		"\u0005\f\u0005\u0089\u0001\u0005\u0004\u0005\u008d\b\u0005\u000b\u0005"+
		"\f\u0005\u008e\u0001\u0006\u0001\u0006\u0005\u0006\u0093\b\u0006\n\u0006"+
		"\f\u0006\u0096\t\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u009a\b\u0006"+
		"\n\u0006\f\u0006\u009d\t\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u00a1"+
		"\b\u0006\n\u0006\f\u0006\u00a4\t\u0006\u0001\u0006\u0004\u0006\u00a7\b"+
		"\u0006\u000b\u0006\f\u0006\u00a8\u0001\u0007\u0001\u0007\u0005\u0007\u00ad"+
		"\b\u0007\n\u0007\f\u0007\u00b0\t\u0007\u0001\u0007\u0001\u0007\u0005\u0007"+
		"\u00b4\b\u0007\n\u0007\f\u0007\u00b7\t\u0007\u0001\u0007\u0001\u0007\u0005"+
		"\u0007\u00bb\b\u0007\n\u0007\f\u0007\u00be\t\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0005\b\u00c4\b\b\n\b\f\b\u00c7\t\b\u0001\b\u0001\b\u0005"+
		"\b\u00cb\b\b\n\b\f\b\u00ce\t\b\u0001\b\u0001\b\u0005\b\u00d2\b\b\n\b\f"+
		"\b\u00d5\t\b\u0001\b\u0004\b\u00d8\b\b\u000b\b\f\b\u00d9\u0001\t\u0001"+
		"\t\u0005\t\u00de\b\t\n\t\f\t\u00e1\t\t\u0001\t\u0001\t\u0005\t\u00e5\b"+
		"\t\n\t\f\t\u00e8\t\t\u0001\t\u0001\t\u0005\t\u00ec\b\t\n\t\f\t\u00ef\t"+
		"\t\u0001\t\u0001\t\u0001\n\u0001\n\u0005\n\u00f5\b\n\n\n\f\n\u00f8\t\n"+
		"\u0001\n\u0001\n\u0005\n\u00fc\b\n\n\n\f\n\u00ff\t\n\u0001\n\u0001\n\u0005"+
		"\n\u0103\b\n\n\n\f\n\u0106\t\n\u0001\u000b\u0001\u000b\u0005\u000b\u010a"+
		"\b\u000b\n\u000b\f\u000b\u010d\t\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u0111\b\u000b\n\u000b\f\u000b\u0114\t\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u0118\b\u000b\n\u000b\f\u000b\u011b\t\u000b\u0001\f\u0001\f\u0005"+
		"\f\u011f\b\f\n\f\f\f\u0122\t\f\u0001\f\u0001\f\u0005\f\u0126\b\f\n\f\f"+
		"\f\u0129\t\f\u0001\f\u0001\f\u0005\f\u012d\b\f\n\f\f\f\u0130\t\f\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0005\u000e\u013b\b\u000e\n\u000e\f\u000e\u013e\t\u000e\u0001\u000e\u0001"+
		"\u000e\u0005\u000e\u0142\b\u000e\n\u000e\f\u000e\u0145\t\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u0149\b\u000e\n\u000e\f\u000e\u014c\t\u000e\u0001"+
		"\u000f\u0001\u000f\u0005\u000f\u0150\b\u000f\n\u000f\f\u000f\u0153\t\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u0157\b\u000f\n\u000f\f\u000f\u015a"+
		"\t\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u015e\b\u000f\n\u000f\f\u000f"+
		"\u0161\t\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u0165\b\u0010\n\u0010"+
		"\f\u0010\u0168\t\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u016c\b\u0010"+
		"\n\u0010\f\u0010\u016f\t\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u0173"+
		"\b\u0010\n\u0010\f\u0010\u0176\t\u0010\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u017a\b\u0011\n\u0011\f\u0011\u017d\t\u0011\u0001\u0011\u0001\u0011\u0005"+
		"\u0011\u0181\b\u0011\n\u0011\f\u0011\u0184\t\u0011\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u0188\b\u0011\n\u0011\f\u0011\u018b\t\u0011\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u018f\b\u0012\n\u0012\f\u0012\u0192\t\u0012\u0001\u0012"+
		"\u0001\u0012\u0005\u0012\u0196\b\u0012\n\u0012\f\u0012\u0199\t\u0012\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u019d\b\u0012\n\u0012\f\u0012\u01a0\t\u0012"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u01a4\b\u0013\n\u0013\f\u0013\u01a7"+
		"\t\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u01ab\b\u0013\n\u0013\f\u0013"+
		"\u01ae\t\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u01b2\b\u0013\n\u0013"+
		"\f\u0013\u01b5\t\u0013\u0001\u001304;BV]du|\u0083\u0094\u009b\u00a2\u00ae"+
		"\u00b5\u00bc\u00c5\u00cc\u00d3\u00df\u00e6\u00ed\u00f6\u00fd\u0104\u010b"+
		"\u0112\u0119\u0120\u0127\u012e\u013c\u0143\u014a\u0151\u0158\u015f\u0166"+
		"\u016d\u0174\u017b\u0182\u0189\u0190\u0197\u019e\u01a5\u01ac\u01b3\u0000"+
		"\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&\u0000\u0000\u01df\u0000(\u0001\u0000\u0000\u0000"+
		"\u0002*\u0001\u0000\u0000\u0000\u00040\u0001\u0000\u0000\u0000\u0006P"+
		"\u0001\u0000\u0000\u0000\bR\u0001\u0000\u0000\u0000\nq\u0001\u0000\u0000"+
		"\u0000\f\u0090\u0001\u0000\u0000\u0000\u000e\u00aa\u0001\u0000\u0000\u0000"+
		"\u0010\u00c1\u0001\u0000\u0000\u0000\u0012\u00db\u0001\u0000\u0000\u0000"+
		"\u0014\u00f2\u0001\u0000\u0000\u0000\u0016\u0107\u0001\u0000\u0000\u0000"+
		"\u0018\u011c\u0001\u0000\u0000\u0000\u001a\u0131\u0001\u0000\u0000\u0000"+
		"\u001c\u0138\u0001\u0000\u0000\u0000\u001e\u014d\u0001\u0000\u0000\u0000"+
		" \u0162\u0001\u0000\u0000\u0000\"\u0177\u0001\u0000\u0000\u0000$\u018c"+
		"\u0001\u0000\u0000\u0000&\u01a1\u0001\u0000\u0000\u0000()\u0003\u0002"+
		"\u0001\u0000)\u0001\u0001\u0000\u0000\u0000*,\u0003\u001a\r\u0000+-\u0003"+
		"\u0004\u0002\u0000,+\u0001\u0000\u0000\u0000-.\u0001\u0000\u0000\u0000"+
		".,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/\u0003\u0001\u0000"+
		"\u0000\u000004\u0005\u000b\u0000\u000013\u0005\u0001\u0000\u000021\u0001"+
		"\u0000\u0000\u000036\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000"+
		"\u00007;\u0005\u0018\u0000\u00008:\u0005\u0001\u0000\u000098\u0001\u0000"+
		"\u0000\u0000:=\u0001\u0000\u0000\u0000;<\u0001\u0000\u0000\u0000;9\u0001"+
		"\u0000\u0000\u0000<>\u0001\u0000\u0000\u0000=;\u0001\u0000\u0000\u0000"+
		">B\u0005\u0002\u0000\u0000?A\u0005\u001a\u0000\u0000@?\u0001\u0000\u0000"+
		"\u0000AD\u0001\u0000\u0000\u0000BC\u0001\u0000\u0000\u0000B@\u0001\u0000"+
		"\u0000\u0000CF\u0001\u0000\u0000\u0000DB\u0001\u0000\u0000\u0000EG\u0003"+
		"\u0006\u0003\u0000FE\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000"+
		"HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000I\u0005\u0001\u0000"+
		"\u0000\u0000JQ\u0003\b\u0004\u0000KQ\u0003\n\u0005\u0000LQ\u0003\f\u0006"+
		"\u0000MQ\u0003\u000e\u0007\u0000NQ\u0003\u0010\b\u0000OQ\u0003\u0012\t"+
		"\u0000PJ\u0001\u0000\u0000\u0000PK\u0001\u0000\u0000\u0000PL\u0001\u0000"+
		"\u0000\u0000PM\u0001\u0000\u0000\u0000PN\u0001\u0000\u0000\u0000PO\u0001"+
		"\u0000\u0000\u0000Q\u0007\u0001\u0000\u0000\u0000RV\u0005\u000e\u0000"+
		"\u0000SU\u0005\u0001\u0000\u0000TS\u0001\u0000\u0000\u0000UX\u0001\u0000"+
		"\u0000\u0000VW\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000WY\u0001"+
		"\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000Y]\u0005\u0018\u0000\u0000"+
		"Z\\\u0005\u0001\u0000\u0000[Z\u0001\u0000\u0000\u0000\\_\u0001\u0000\u0000"+
		"\u0000]^\u0001\u0000\u0000\u0000][\u0001\u0000\u0000\u0000^`\u0001\u0000"+
		"\u0000\u0000_]\u0001\u0000\u0000\u0000`d\u0005\u0002\u0000\u0000ac\u0005"+
		"\u001a\u0000\u0000ba\u0001\u0000\u0000\u0000cf\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000db\u0001\u0000\u0000\u0000eh\u0001\u0000\u0000"+
		"\u0000fd\u0001\u0000\u0000\u0000gi\u0003\u0014\n\u0000hg\u0001\u0000\u0000"+
		"\u0000ij\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000km\u0001\u0000\u0000\u0000ln\u0003\u0016\u000b\u0000ml\u0001"+
		"\u0000\u0000\u0000no\u0001\u0000\u0000\u0000om\u0001\u0000\u0000\u0000"+
		"op\u0001\u0000\u0000\u0000p\t\u0001\u0000\u0000\u0000qu\u0005\u000f\u0000"+
		"\u0000rt\u0005\u0001\u0000\u0000sr\u0001\u0000\u0000\u0000tw\u0001\u0000"+
		"\u0000\u0000uv\u0001\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vx\u0001"+
		"\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000x|\u0005\u0018\u0000\u0000"+
		"y{\u0005\u0001\u0000\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000\u0000"+
		"\u0000|}\u0001\u0000\u0000\u0000|z\u0001\u0000\u0000\u0000}\u007f\u0001"+
		"\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0083\u0005\u0002\u0000"+
		"\u0000\u0080\u0082\u0005\u001a\u0000\u0000\u0081\u0080\u0001\u0000\u0000"+
		"\u0000\u0082\u0085\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000"+
		"\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000"+
		"\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0086\u0088\u0003\u0014\n\u0000"+
		"\u0087\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000"+
		"\u0089\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000"+
		"\u008a\u008c\u0001\u0000\u0000\u0000\u008b\u008d\u0003\u0016\u000b\u0000"+
		"\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000"+
		"\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000"+
		"\u008f\u000b\u0001\u0000\u0000\u0000\u0090\u0094\u0005\u0010\u0000\u0000"+
		"\u0091\u0093\u0005\u0001\u0000\u0000\u0092\u0091\u0001\u0000\u0000\u0000"+
		"\u0093\u0096\u0001\u0000\u0000\u0000\u0094\u0095\u0001\u0000\u0000\u0000"+
		"\u0094\u0092\u0001\u0000\u0000\u0000\u0095\u0097\u0001\u0000\u0000\u0000"+
		"\u0096\u0094\u0001\u0000\u0000\u0000\u0097\u009b\u0005\u0018\u0000\u0000"+
		"\u0098\u009a\u0005\u0001\u0000\u0000\u0099\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009d\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000"+
		"\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009e\u0001\u0000\u0000\u0000"+
		"\u009d\u009b\u0001\u0000\u0000\u0000\u009e\u00a2\u0005\u0002\u0000\u0000"+
		"\u009f\u00a1\u0005\u001a\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000"+
		"\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000"+
		"\u00a2\u00a0\u0001\u0000\u0000\u0000\u00a3\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5\u00a7\u0003\u0016\u000b\u0000"+
		"\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a6\u0001\u0000\u0000\u0000\u00a8\u00a9\u0001\u0000\u0000\u0000"+
		"\u00a9\r\u0001\u0000\u0000\u0000\u00aa\u00ae\u0005\u0011\u0000\u0000\u00ab"+
		"\u00ad\u0005\u0001\u0000\u0000\u00ac\u00ab\u0001\u0000\u0000\u0000\u00ad"+
		"\u00b0\u0001\u0000\u0000\u0000\u00ae\u00af\u0001\u0000\u0000\u0000\u00ae"+
		"\u00ac\u0001\u0000\u0000\u0000\u00af\u00b1\u0001\u0000\u0000\u0000\u00b0"+
		"\u00ae\u0001\u0000\u0000\u0000\u00b1\u00b5\u0005\u0018\u0000\u0000\u00b2"+
		"\u00b4\u0005\u0001\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b8\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b8\u00bc\u0005\u0002\u0000\u0000\u00b9"+
		"\u00bb\u0005\u001a\u0000\u0000\u00ba\u00b9\u0001\u0000\u0000\u0000\u00bb"+
		"\u00be\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bc"+
		"\u00ba\u0001\u0000\u0000\u0000\u00bd\u00bf\u0001\u0000\u0000\u0000\u00be"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c0\u0003\u0016\u000b\u0000\u00c0"+
		"\u000f\u0001\u0000\u0000\u0000\u00c1\u00c5\u0005\u0012\u0000\u0000\u00c2"+
		"\u00c4\u0005\u0001\u0000\u0000\u00c3\u00c2\u0001\u0000\u0000\u0000\u00c4"+
		"\u00c7\u0001\u0000\u0000\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c5"+
		"\u00c3\u0001\u0000\u0000\u0000\u00c6\u00c8\u0001\u0000\u0000\u0000\u00c7"+
		"\u00c5\u0001\u0000\u0000\u0000\u00c8\u00cc\u0005\u0018\u0000\u0000\u00c9"+
		"\u00cb\u0005\u0001\u0000\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00cb"+
		"\u00ce\u0001\u0000\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cc"+
		"\u00ca\u0001\u0000\u0000\u0000\u00cd\u00cf\u0001\u0000\u0000\u0000\u00ce"+
		"\u00cc\u0001\u0000\u0000\u0000\u00cf\u00d3\u0005\u0002\u0000\u0000\u00d0"+
		"\u00d2\u0005\u001a\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d8\u0003\u0016\u000b\u0000\u00d7"+
		"\u00d6\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000\u00d9"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da"+
		"\u0011\u0001\u0000\u0000\u0000\u00db\u00df\u0005\u0013\u0000\u0000\u00dc"+
		"\u00de\u0005\u0001\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de"+
		"\u00e1\u0001\u0000\u0000\u0000\u00df\u00e0\u0001\u0000\u0000\u0000\u00df"+
		"\u00dd\u0001\u0000\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1"+
		"\u00df\u0001\u0000\u0000\u0000\u00e2\u00e6\u0005\u0018\u0000\u0000\u00e3"+
		"\u00e5\u0005\u0001\u0000\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e5"+
		"\u00e8\u0001\u0000\u0000\u0000\u00e6\u00e7\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e7\u00e9\u0001\u0000\u0000\u0000\u00e8"+
		"\u00e6\u0001\u0000\u0000\u0000\u00e9\u00ed\u0005\u0002\u0000\u0000\u00ea"+
		"\u00ec\u0005\u001a\u0000\u0000\u00eb\u00ea\u0001\u0000\u0000\u0000\u00ec"+
		"\u00ef\u0001\u0000\u0000\u0000\u00ed\u00ee\u0001\u0000\u0000\u0000\u00ed"+
		"\u00eb\u0001\u0000\u0000\u0000\u00ee\u00f0\u0001\u0000\u0000\u0000\u00ef"+
		"\u00ed\u0001\u0000\u0000\u0000\u00f0\u00f1\u0003\u0018\f\u0000\u00f1\u0013"+
		"\u0001\u0000\u0000\u0000\u00f2\u00f6\u0005\u0003\u0000\u0000\u00f3\u00f5"+
		"\u0005\u0001\u0000\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f5\u00f8"+
		"\u0001\u0000\u0000\u0000\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f6\u00f4"+
		"\u0001\u0000\u0000\u0000\u00f7\u00f9\u0001\u0000\u0000\u0000\u00f8\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fd\u0005\u0018\u0000\u0000\u00fa\u00fc"+
		"\u0005\u0001\u0000\u0000\u00fb\u00fa\u0001\u0000\u0000\u0000\u00fc\u00ff"+
		"\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fd\u00fb"+
		"\u0001\u0000\u0000\u0000\u00fe\u0100\u0001\u0000\u0000\u0000\u00ff\u00fd"+
		"\u0001\u0000\u0000\u0000\u0100\u0104\u0005\u0002\u0000\u0000\u0101\u0103"+
		"\u0005\u001a\u0000\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0103\u0106"+
		"\u0001\u0000\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0104\u0102"+
		"\u0001\u0000\u0000\u0000\u0105\u0015\u0001\u0000\u0000\u0000\u0106\u0104"+
		"\u0001\u0000\u0000\u0000\u0107\u010b\u0005\u0004\u0000\u0000\u0108\u010a"+
		"\u0005\u0001\u0000\u0000\u0109\u0108\u0001\u0000\u0000\u0000\u010a\u010d"+
		"\u0001\u0000\u0000\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010b\u0109"+
		"\u0001\u0000\u0000\u0000\u010c\u010e\u0001\u0000\u0000\u0000\u010d\u010b"+
		"\u0001\u0000\u0000\u0000\u010e\u0112\u0005\u0014\u0000\u0000\u010f\u0111"+
		"\u0005\u0001\u0000\u0000\u0110\u010f\u0001\u0000\u0000\u0000\u0111\u0114"+
		"\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000\u0000\u0112\u0110"+
		"\u0001\u0000\u0000\u0000\u0113\u0115\u0001\u0000\u0000\u0000\u0114\u0112"+
		"\u0001\u0000\u0000\u0000\u0115\u0119\u0005\u0002\u0000\u0000\u0116\u0118"+
		"\u0005\u001a\u0000\u0000\u0117\u0116\u0001\u0000\u0000\u0000\u0118\u011b"+
		"\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u0119\u0117"+
		"\u0001\u0000\u0000\u0000\u011a\u0017\u0001\u0000\u0000\u0000\u011b\u0119"+
		"\u0001\u0000\u0000\u0000\u011c\u0120\u0005\u0004\u0000\u0000\u011d\u011f"+
		"\u0005\u0001\u0000\u0000\u011e\u011d\u0001\u0000\u0000\u0000\u011f\u0122"+
		"\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0120\u011e"+
		"\u0001\u0000\u0000\u0000\u0121\u0123\u0001\u0000\u0000\u0000\u0122\u0120"+
		"\u0001\u0000\u0000\u0000\u0123\u0127\u0005\u0015\u0000\u0000\u0124\u0126"+
		"\u0005\u0001\u0000\u0000\u0125\u0124\u0001\u0000\u0000\u0000\u0126\u0129"+
		"\u0001\u0000\u0000\u0000\u0127\u0128\u0001\u0000\u0000\u0000\u0127\u0125"+
		"\u0001\u0000\u0000\u0000\u0128\u012a\u0001\u0000\u0000\u0000\u0129\u0127"+
		"\u0001\u0000\u0000\u0000\u012a\u012e\u0005\u0002\u0000\u0000\u012b\u012d"+
		"\u0005\u001a\u0000\u0000\u012c\u012b\u0001\u0000\u0000\u0000\u012d\u0130"+
		"\u0001\u0000\u0000\u0000\u012e\u012f\u0001\u0000\u0000\u0000\u012e\u012c"+
		"\u0001\u0000\u0000\u0000\u012f\u0019\u0001\u0000\u0000\u0000\u0130\u012e"+
		"\u0001\u0000\u0000\u0000\u0131\u0132\u0003\u001c\u000e\u0000\u0132\u0133"+
		"\u0003\u001e\u000f\u0000\u0133\u0134\u0003 \u0010\u0000\u0134\u0135\u0003"+
		"\"\u0011\u0000\u0135\u0136\u0003$\u0012\u0000\u0136\u0137\u0003&\u0013"+
		"\u0000\u0137\u001b\u0001\u0000\u0000\u0000\u0138\u013c\u0005\u0005\u0000"+
		"\u0000\u0139\u013b\u0005\u0001\u0000\u0000\u013a\u0139\u0001\u0000\u0000"+
		"\u0000\u013b\u013e\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000"+
		"\u0000\u013c\u013a\u0001\u0000\u0000\u0000\u013d\u013f\u0001\u0000\u0000"+
		"\u0000\u013e\u013c\u0001\u0000\u0000\u0000\u013f\u0143\u0005\u0018\u0000"+
		"\u0000\u0140\u0142\u0005\u0001\u0000\u0000\u0141\u0140\u0001\u0000\u0000"+
		"\u0000\u0142\u0145\u0001\u0000\u0000\u0000\u0143\u0144\u0001\u0000\u0000"+
		"\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0144\u0146\u0001\u0000\u0000"+
		"\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0146\u014a\u0005\u0002\u0000"+
		"\u0000\u0147\u0149\u0005\u001a\u0000\u0000\u0148\u0147\u0001\u0000\u0000"+
		"\u0000\u0149\u014c\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000"+
		"\u0000\u014a\u0148\u0001\u0000\u0000\u0000\u014b\u001d\u0001\u0000\u0000"+
		"\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014d\u0151\u0005\u0006\u0000"+
		"\u0000\u014e\u0150\u0005\u0001\u0000\u0000\u014f\u014e\u0001\u0000\u0000"+
		"\u0000\u0150\u0153\u0001\u0000\u0000\u0000\u0151\u0152\u0001\u0000\u0000"+
		"\u0000\u0151\u014f\u0001\u0000\u0000\u0000\u0152\u0154\u0001\u0000\u0000"+
		"\u0000\u0153\u0151\u0001\u0000\u0000\u0000\u0154\u0158\u0005\u0018\u0000"+
		"\u0000\u0155\u0157\u0005\u0001\u0000\u0000\u0156\u0155\u0001\u0000\u0000"+
		"\u0000\u0157\u015a\u0001\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000"+
		"\u0000\u0158\u0156\u0001\u0000\u0000\u0000\u0159\u015b\u0001\u0000\u0000"+
		"\u0000\u015a\u0158\u0001\u0000\u0000\u0000\u015b\u015f\u0005\u0002\u0000"+
		"\u0000\u015c\u015e\u0005\u001a\u0000\u0000\u015d\u015c\u0001\u0000\u0000"+
		"\u0000\u015e\u0161\u0001\u0000\u0000\u0000\u015f\u0160\u0001\u0000\u0000"+
		"\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u0160\u001f\u0001\u0000\u0000"+
		"\u0000\u0161\u015f\u0001\u0000\u0000\u0000\u0162\u0166\u0005\u0007\u0000"+
		"\u0000\u0163\u0165\u0005\u0001\u0000\u0000\u0164\u0163\u0001\u0000\u0000"+
		"\u0000\u0165\u0168\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000"+
		"\u0000\u0166\u0164\u0001\u0000\u0000\u0000\u0167\u0169\u0001\u0000\u0000"+
		"\u0000\u0168\u0166\u0001\u0000\u0000\u0000\u0169\u016d\u0005\f\u0000\u0000"+
		"\u016a\u016c\u0005\u0001\u0000\u0000\u016b\u016a\u0001\u0000\u0000\u0000"+
		"\u016c\u016f\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000\u0000"+
		"\u016d\u016b\u0001\u0000\u0000\u0000\u016e\u0170\u0001\u0000\u0000\u0000"+
		"\u016f\u016d\u0001\u0000\u0000\u0000\u0170\u0174\u0005\u0002\u0000\u0000"+
		"\u0171\u0173\u0005\u001a\u0000\u0000\u0172\u0171\u0001\u0000\u0000\u0000"+
		"\u0173\u0176\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000"+
		"\u0174\u0172\u0001\u0000\u0000\u0000\u0175!\u0001\u0000\u0000\u0000\u0176"+
		"\u0174\u0001\u0000\u0000\u0000\u0177\u017b\u0005\b\u0000\u0000\u0178\u017a"+
		"\u0005\u0001\u0000\u0000\u0179\u0178\u0001\u0000\u0000\u0000\u017a\u017d"+
		"\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017b\u0179"+
		"\u0001\u0000\u0000\u0000\u017c\u017e\u0001\u0000\u0000\u0000\u017d\u017b"+
		"\u0001\u0000\u0000\u0000\u017e\u0182\u0005\f\u0000\u0000\u017f\u0181\u0005"+
		"\u0001\u0000\u0000\u0180\u017f\u0001\u0000\u0000\u0000\u0181\u0184\u0001"+
		"\u0000\u0000\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0182\u0180\u0001"+
		"\u0000\u0000\u0000\u0183\u0185\u0001\u0000\u0000\u0000\u0184\u0182\u0001"+
		"\u0000\u0000\u0000\u0185\u0189\u0005\u0002\u0000\u0000\u0186\u0188\u0005"+
		"\u001a\u0000\u0000\u0187\u0186\u0001\u0000\u0000\u0000\u0188\u018b\u0001"+
		"\u0000\u0000\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u0189\u0187\u0001"+
		"\u0000\u0000\u0000\u018a#\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000"+
		"\u0000\u0000\u018c\u0190\u0005\t\u0000\u0000\u018d\u018f\u0005\u0001\u0000"+
		"\u0000\u018e\u018d\u0001\u0000\u0000\u0000\u018f\u0192\u0001\u0000\u0000"+
		"\u0000\u0190\u0191\u0001\u0000\u0000\u0000\u0190\u018e\u0001\u0000\u0000"+
		"\u0000\u0191\u0193\u0001\u0000\u0000\u0000\u0192\u0190\u0001\u0000\u0000"+
		"\u0000\u0193\u0197\u0005\r\u0000\u0000\u0194\u0196\u0005\u0001\u0000\u0000"+
		"\u0195\u0194\u0001\u0000\u0000\u0000\u0196\u0199\u0001\u0000\u0000\u0000"+
		"\u0197\u0198\u0001\u0000\u0000\u0000\u0197\u0195\u0001\u0000\u0000\u0000"+
		"\u0198\u019a\u0001\u0000\u0000\u0000\u0199\u0197\u0001\u0000\u0000\u0000"+
		"\u019a\u019e\u0005\u0002\u0000\u0000\u019b\u019d\u0005\u001a\u0000\u0000"+
		"\u019c\u019b\u0001\u0000\u0000\u0000\u019d\u01a0\u0001\u0000\u0000\u0000"+
		"\u019e\u019f\u0001\u0000\u0000\u0000\u019e\u019c\u0001\u0000\u0000\u0000"+
		"\u019f%\u0001\u0000\u0000\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a1"+
		"\u01a5\u0005\n\u0000\u0000\u01a2\u01a4\u0005\u0001\u0000\u0000\u01a3\u01a2"+
		"\u0001\u0000\u0000\u0000\u01a4\u01a7\u0001\u0000\u0000\u0000\u01a5\u01a6"+
		"\u0001\u0000\u0000\u0000\u01a5\u01a3\u0001\u0000\u0000\u0000\u01a6\u01a8"+
		"\u0001\u0000\u0000\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000\u01a8\u01ac"+
		"\u0005\r\u0000\u0000\u01a9\u01ab\u0005\u0001\u0000\u0000\u01aa\u01a9\u0001"+
		"\u0000\u0000\u0000\u01ab\u01ae\u0001\u0000\u0000\u0000\u01ac\u01ad\u0001"+
		"\u0000\u0000\u0000\u01ac\u01aa\u0001\u0000\u0000\u0000\u01ad\u01af\u0001"+
		"\u0000\u0000\u0000\u01ae\u01ac\u0001\u0000\u0000\u0000\u01af\u01b3\u0005"+
		"\u0002\u0000\u0000\u01b0\u01b2\u0005\u001a\u0000\u0000\u01b1\u01b0\u0001"+
		"\u0000\u0000\u0000\u01b2\u01b5\u0001\u0000\u0000\u0000\u01b3\u01b4\u0001"+
		"\u0000\u0000\u0000\u01b3\u01b1\u0001\u0000\u0000\u0000\u01b4\'\u0001\u0000"+
		"\u0000\u0000\u01b5\u01b3\u0001\u0000\u0000\u00009.4;BHPV]djou|\u0083\u0089"+
		"\u008e\u0094\u009b\u00a2\u00a8\u00ae\u00b5\u00bc\u00c5\u00cc\u00d3\u00d9"+
		"\u00df\u00e6\u00ed\u00f6\u00fd\u0104\u010b\u0112\u0119\u0120\u0127\u012e"+
		"\u013c\u0143\u014a\u0151\u0158\u015f\u0166\u016d\u0174\u017b\u0182\u0189"+
		"\u0190\u0197\u019e\u01a5\u01ac\u01b3";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}