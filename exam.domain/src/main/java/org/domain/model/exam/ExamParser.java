// Generated from /Users/henriquelspinto/IdeaProjects/sem4pi-22-23-8/exam.domain/src/main/java/org/domain/model/exam/Exam.g4 by ANTLR 4.12.0
package org.domain.model.exam;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExamParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, MATCHING=7, MULTIPLE_CHOICE=8, 
		SHORT_ANSWER=9, NUMERICAL=10, SELECT_WORDS=11, TRUE_FALSE=12, SUBMISSION_TITLE=13, 
		SECTION_TITLE=14, NAME=15, NULL_OPERATOR=16, NUMBER=17, TRUE_FALSE_OPT=18, 
		WS=19;
	public static final int
		RULE_exam = 0, RULE_exam_header = 1, RULE_section = 2, RULE_question = 3, 
		RULE_matching_quest = 4, RULE_multiple_choice_quest = 5, RULE_short_answer_quest = 6, 
		RULE_numerical_quest = 7, RULE_select_words_quest = 8, RULE_true_false_quest = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"exam", "exam_header", "section", "question", "matching_quest", "multiple_choice_quest", 
			"short_answer_quest", "numerical_quest", "select_words_quest", "true_false_quest"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'['", "','", "']'", "';'", "'MQUES'", "'MCQUES'", 
			"'SAQUES'", "'NQUES'", "'SWQUES'", "'TFQUES'", "'EXAM SUBMISSION'", "'SECTION'", 
			null, "'null'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, "MATCHING", "MULTIPLE_CHOICE", 
			"SHORT_ANSWER", "NUMERICAL", "SELECT_WORDS", "TRUE_FALSE", "SUBMISSION_TITLE", 
			"SECTION_TITLE", "NAME", "NULL_OPERATOR", "NUMBER", "TRUE_FALSE_OPT", 
			"WS"
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
	public String getGrammarFileName() { return "Exam.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExamParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExamContext extends ParserRuleContext {
		public Exam_headerContext exam_header() {
			return getRuleContext(Exam_headerContext.class,0);
		}
		public List<SectionContext> section() {
			return getRuleContexts(SectionContext.class);
		}
		public SectionContext section(int i) {
			return getRuleContext(SectionContext.class,i);
		}
		public ExamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterExam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitExam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitExam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExamContext exam() throws RecognitionException {
		ExamContext _localctx = new ExamContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_exam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			exam_header();
			setState(21);
			match(T__0);
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				section();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==SECTION_TITLE );
			setState(27);
			match(T__1);
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
	public static class Exam_headerContext extends ParserRuleContext {
		public TerminalNode SUBMISSION_TITLE() { return getToken(ExamParser.SUBMISSION_TITLE, 0); }
		public TerminalNode NAME() { return getToken(ExamParser.NAME, 0); }
		public Exam_headerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exam_header; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterExam_header(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitExam_header(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitExam_header(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exam_headerContext exam_header() throws RecognitionException {
		Exam_headerContext _localctx = new Exam_headerContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exam_header);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(SUBMISSION_TITLE);
			setState(30);
			match(NAME);
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
	public static class SectionContext extends ParserRuleContext {
		public TerminalNode SECTION_TITLE() { return getToken(ExamParser.SECTION_TITLE, 0); }
		public TerminalNode NAME() { return getToken(ExamParser.NAME, 0); }
		public List<QuestionContext> question() {
			return getRuleContexts(QuestionContext.class);
		}
		public QuestionContext question(int i) {
			return getRuleContext(QuestionContext.class,i);
		}
		public SectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_section; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SectionContext section() throws RecognitionException {
		SectionContext _localctx = new SectionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_section);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			match(SECTION_TITLE);
			setState(33);
			match(NAME);
			setState(34);
			match(T__0);
			setState(36); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(35);
				question();
				}
				}
				setState(38); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8064L) != 0) );
			setState(40);
			match(T__1);
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
	public static class QuestionContext extends ParserRuleContext {
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
		public QuestionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_question; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterQuestion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitQuestion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitQuestion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestionContext question() throws RecognitionException {
		QuestionContext _localctx = new QuestionContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_question);
		try {
			setState(48);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MATCHING:
				enterOuterAlt(_localctx, 1);
				{
				setState(42);
				matching_quest();
				}
				break;
			case MULTIPLE_CHOICE:
				enterOuterAlt(_localctx, 2);
				{
				setState(43);
				multiple_choice_quest();
				}
				break;
			case SHORT_ANSWER:
				enterOuterAlt(_localctx, 3);
				{
				setState(44);
				short_answer_quest();
				}
				break;
			case NUMERICAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(45);
				numerical_quest();
				}
				break;
			case SELECT_WORDS:
				enterOuterAlt(_localctx, 5);
				{
				setState(46);
				select_words_quest();
				}
				break;
			case TRUE_FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(47);
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
		public TerminalNode MATCHING() { return getToken(ExamParser.MATCHING, 0); }
		public List<TerminalNode> NAME() { return getTokens(ExamParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ExamParser.NAME, i);
		}
		public TerminalNode NULL_OPERATOR() { return getToken(ExamParser.NULL_OPERATOR, 0); }
		public Matching_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matching_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterMatching_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitMatching_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitMatching_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Matching_questContext matching_quest() throws RecognitionException {
		Matching_questContext _localctx = new Matching_questContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_matching_quest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			match(MATCHING);
			setState(51);
			match(NAME);
			setState(63);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(52);
				match(T__2);
				setState(53);
				match(NAME);
				setState(58);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(54);
					match(T__3);
					setState(55);
					match(NAME);
					}
					}
					setState(60);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(61);
				match(T__4);
				}
				}
				break;
			case NULL_OPERATOR:
				{
				setState(62);
				match(NULL_OPERATOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(65);
			match(T__5);
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
		public TerminalNode MULTIPLE_CHOICE() { return getToken(ExamParser.MULTIPLE_CHOICE, 0); }
		public List<TerminalNode> NAME() { return getTokens(ExamParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ExamParser.NAME, i);
		}
		public TerminalNode NULL_OPERATOR() { return getToken(ExamParser.NULL_OPERATOR, 0); }
		public Multiple_choice_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_choice_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterMultiple_choice_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitMultiple_choice_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitMultiple_choice_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_choice_questContext multiple_choice_quest() throws RecognitionException {
		Multiple_choice_questContext _localctx = new Multiple_choice_questContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_multiple_choice_quest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(MULTIPLE_CHOICE);
			setState(68);
			match(NAME);
			setState(80);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(69);
				match(T__2);
				setState(70);
				match(NAME);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(71);
					match(T__3);
					setState(72);
					match(NAME);
					}
					}
					setState(77);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(78);
				match(T__4);
				}
				}
				break;
			case NULL_OPERATOR:
				{
				setState(79);
				match(NULL_OPERATOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(82);
			match(T__5);
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
		public TerminalNode SHORT_ANSWER() { return getToken(ExamParser.SHORT_ANSWER, 0); }
		public List<TerminalNode> NAME() { return getTokens(ExamParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ExamParser.NAME, i);
		}
		public TerminalNode NULL_OPERATOR() { return getToken(ExamParser.NULL_OPERATOR, 0); }
		public Short_answer_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_short_answer_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterShort_answer_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitShort_answer_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitShort_answer_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Short_answer_questContext short_answer_quest() throws RecognitionException {
		Short_answer_questContext _localctx = new Short_answer_questContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_short_answer_quest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(SHORT_ANSWER);
			setState(85);
			match(NAME);
			setState(90);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				{
				setState(86);
				match(T__2);
				setState(87);
				match(NAME);
				setState(88);
				match(T__4);
				}
				}
				break;
			case NULL_OPERATOR:
				{
				setState(89);
				match(NULL_OPERATOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(92);
			match(T__5);
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
		public TerminalNode NUMERICAL() { return getToken(ExamParser.NUMERICAL, 0); }
		public TerminalNode NAME() { return getToken(ExamParser.NAME, 0); }
		public TerminalNode NUMBER() { return getToken(ExamParser.NUMBER, 0); }
		public TerminalNode NULL_OPERATOR() { return getToken(ExamParser.NULL_OPERATOR, 0); }
		public Numerical_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numerical_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterNumerical_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitNumerical_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitNumerical_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Numerical_questContext numerical_quest() throws RecognitionException {
		Numerical_questContext _localctx = new Numerical_questContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_numerical_quest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(NUMERICAL);
			setState(95);
			match(NAME);
			setState(96);
			_la = _input.LA(1);
			if ( !(_la==NULL_OPERATOR || _la==NUMBER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(97);
			match(T__5);
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
		public TerminalNode SELECT_WORDS() { return getToken(ExamParser.SELECT_WORDS, 0); }
		public List<TerminalNode> NAME() { return getTokens(ExamParser.NAME); }
		public TerminalNode NAME(int i) {
			return getToken(ExamParser.NAME, i);
		}
		public TerminalNode NULL_OPERATOR() { return getToken(ExamParser.NULL_OPERATOR, 0); }
		public Select_words_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_words_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterSelect_words_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitSelect_words_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitSelect_words_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_words_questContext select_words_quest() throws RecognitionException {
		Select_words_questContext _localctx = new Select_words_questContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_select_words_quest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(SELECT_WORDS);
			setState(100);
			match(NAME);
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__2:
				{
				setState(101);
				match(T__2);
				setState(102);
				match(NAME);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__3) {
					{
					{
					setState(103);
					match(T__3);
					setState(104);
					match(NAME);
					}
					}
					setState(109);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(110);
				match(T__4);
				}
				break;
			case NULL_OPERATOR:
				{
				setState(111);
				match(NULL_OPERATOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(114);
			match(T__5);
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
		public TerminalNode TRUE_FALSE() { return getToken(ExamParser.TRUE_FALSE, 0); }
		public TerminalNode NAME() { return getToken(ExamParser.NAME, 0); }
		public TerminalNode TRUE_FALSE_OPT() { return getToken(ExamParser.TRUE_FALSE_OPT, 0); }
		public TerminalNode NULL_OPERATOR() { return getToken(ExamParser.NULL_OPERATOR, 0); }
		public True_false_questContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_true_false_quest; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).enterTrue_false_quest(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExamListener ) ((ExamListener)listener).exitTrue_false_quest(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExamVisitor ) return ((ExamVisitor<? extends T>)visitor).visitTrue_false_quest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final True_false_questContext true_false_quest() throws RecognitionException {
		True_false_questContext _localctx = new True_false_questContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_true_false_quest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
			match(TRUE_FALSE);
			setState(117);
			match(NAME);
			setState(118);
			_la = _input.LA(1);
			if ( !(_la==NULL_OPERATOR || _la==TRUE_FALSE_OPT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(119);
			match(T__5);
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
		"\u0004\u0001\u0013z\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0001\u0000\u0001\u0000\u0001\u0000\u0004\u0000"+
		"\u0018\b\u0000\u000b\u0000\f\u0000\u0019\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0004\u0002%\b\u0002\u000b\u0002\f\u0002&\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0003\u00031\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0005\u00049\b\u0004\n\u0004\f\u0004<\t\u0004"+
		"\u0001\u0004\u0001\u0004\u0003\u0004@\b\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0005\u0005J\b\u0005\n\u0005\f\u0005M\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0003\u0005Q\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006[\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0005\bj"+
		"\b\b\n\b\f\bm\t\b\u0001\b\u0001\b\u0003\bq\b\b\u0001\b\u0001\b\u0001\t"+
		"\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0000\u0000\n\u0000\u0002\u0004"+
		"\u0006\b\n\f\u000e\u0010\u0012\u0000\u0002\u0001\u0000\u0010\u0011\u0002"+
		"\u0000\u0010\u0010\u0012\u0012}\u0000\u0014\u0001\u0000\u0000\u0000\u0002"+
		"\u001d\u0001\u0000\u0000\u0000\u0004 \u0001\u0000\u0000\u0000\u00060\u0001"+
		"\u0000\u0000\u0000\b2\u0001\u0000\u0000\u0000\nC\u0001\u0000\u0000\u0000"+
		"\fT\u0001\u0000\u0000\u0000\u000e^\u0001\u0000\u0000\u0000\u0010c\u0001"+
		"\u0000\u0000\u0000\u0012t\u0001\u0000\u0000\u0000\u0014\u0015\u0003\u0002"+
		"\u0001\u0000\u0015\u0017\u0005\u0001\u0000\u0000\u0016\u0018\u0003\u0004"+
		"\u0002\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018\u0019\u0001\u0000"+
		"\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019\u001a\u0001\u0000"+
		"\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b\u001c\u0005\u0002"+
		"\u0000\u0000\u001c\u0001\u0001\u0000\u0000\u0000\u001d\u001e\u0005\r\u0000"+
		"\u0000\u001e\u001f\u0005\u000f\u0000\u0000\u001f\u0003\u0001\u0000\u0000"+
		"\u0000 !\u0005\u000e\u0000\u0000!\"\u0005\u000f\u0000\u0000\"$\u0005\u0001"+
		"\u0000\u0000#%\u0003\u0006\u0003\u0000$#\u0001\u0000\u0000\u0000%&\u0001"+
		"\u0000\u0000\u0000&$\u0001\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000"+
		"\'(\u0001\u0000\u0000\u0000()\u0005\u0002\u0000\u0000)\u0005\u0001\u0000"+
		"\u0000\u0000*1\u0003\b\u0004\u0000+1\u0003\n\u0005\u0000,1\u0003\f\u0006"+
		"\u0000-1\u0003\u000e\u0007\u0000.1\u0003\u0010\b\u0000/1\u0003\u0012\t"+
		"\u00000*\u0001\u0000\u0000\u00000+\u0001\u0000\u0000\u00000,\u0001\u0000"+
		"\u0000\u00000-\u0001\u0000\u0000\u00000.\u0001\u0000\u0000\u00000/\u0001"+
		"\u0000\u0000\u00001\u0007\u0001\u0000\u0000\u000023\u0005\u0007\u0000"+
		"\u00003?\u0005\u000f\u0000\u000045\u0005\u0003\u0000\u00005:\u0005\u000f"+
		"\u0000\u000067\u0005\u0004\u0000\u000079\u0005\u000f\u0000\u000086\u0001"+
		"\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		":;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000=@\u0005\u0005\u0000\u0000>@\u0005\u0010\u0000\u0000?4\u0001\u0000"+
		"\u0000\u0000?>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0005"+
		"\u0006\u0000\u0000B\t\u0001\u0000\u0000\u0000CD\u0005\b\u0000\u0000DP"+
		"\u0005\u000f\u0000\u0000EF\u0005\u0003\u0000\u0000FK\u0005\u000f\u0000"+
		"\u0000GH\u0005\u0004\u0000\u0000HJ\u0005\u000f\u0000\u0000IG\u0001\u0000"+
		"\u0000\u0000JM\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001"+
		"\u0000\u0000\u0000LN\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000"+
		"NQ\u0005\u0005\u0000\u0000OQ\u0005\u0010\u0000\u0000PE\u0001\u0000\u0000"+
		"\u0000PO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RS\u0005\u0006"+
		"\u0000\u0000S\u000b\u0001\u0000\u0000\u0000TU\u0005\t\u0000\u0000UZ\u0005"+
		"\u000f\u0000\u0000VW\u0005\u0003\u0000\u0000WX\u0005\u000f\u0000\u0000"+
		"X[\u0005\u0005\u0000\u0000Y[\u0005\u0010\u0000\u0000ZV\u0001\u0000\u0000"+
		"\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000\u0000\u0000\\]\u0005\u0006"+
		"\u0000\u0000]\r\u0001\u0000\u0000\u0000^_\u0005\n\u0000\u0000_`\u0005"+
		"\u000f\u0000\u0000`a\u0007\u0000\u0000\u0000ab\u0005\u0006\u0000\u0000"+
		"b\u000f\u0001\u0000\u0000\u0000cd\u0005\u000b\u0000\u0000dp\u0005\u000f"+
		"\u0000\u0000ef\u0005\u0003\u0000\u0000fk\u0005\u000f\u0000\u0000gh\u0005"+
		"\u0004\u0000\u0000hj\u0005\u000f\u0000\u0000ig\u0001\u0000\u0000\u0000"+
		"jm\u0001\u0000\u0000\u0000ki\u0001\u0000\u0000\u0000kl\u0001\u0000\u0000"+
		"\u0000ln\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000nq\u0005\u0005"+
		"\u0000\u0000oq\u0005\u0010\u0000\u0000pe\u0001\u0000\u0000\u0000po\u0001"+
		"\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000rs\u0005\u0006\u0000\u0000"+
		"s\u0011\u0001\u0000\u0000\u0000tu\u0005\f\u0000\u0000uv\u0005\u000f\u0000"+
		"\u0000vw\u0007\u0001\u0000\u0000wx\u0005\u0006\u0000\u0000x\u0013\u0001"+
		"\u0000\u0000\u0000\n\u0019&0:?KPZkp";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}