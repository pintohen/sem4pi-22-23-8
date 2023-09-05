// Generated from /Users/henriquelspinto/IdeaProjects/sem4pi-22-23-8/exam.domain/src/main/java/org/domain/model/exam/Exam.g4 by ANTLR 4.12.0
package org.domain.model.exam;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class ExamLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, MATCHING=7, MULTIPLE_CHOICE=8, 
		SHORT_ANSWER=9, NUMERICAL=10, SELECT_WORDS=11, TRUE_FALSE=12, SUBMISSION_TITLE=13, 
		SECTION_TITLE=14, NAME=15, NULL_OPERATOR=16, NUMBER=17, TRUE_FALSE_OPT=18, 
		WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "MATCHING", "MULTIPLE_CHOICE", 
			"SHORT_ANSWER", "NUMERICAL", "SELECT_WORDS", "TRUE_FALSE", "SUBMISSION_TITLE", 
			"SECTION_TITLE", "NAME", "NULL_OPERATOR", "NUMBER", "TRUE_FALSE_OPT", 
			"WS"
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


	public ExamLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Exam.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0013\u00a2\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0005\u000e"+
		"v\b\u000e\n\u000e\f\u000ey\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0005\u0010\u0084\b\u0010\n\u0010\f\u0010\u0087\t\u0010\u0001\u0010\u0001"+
		"\u0010\u0004\u0010\u008b\b\u0010\u000b\u0010\f\u0010\u008c\u0003\u0010"+
		"\u008f\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u009a\b\u0011"+
		"\u0001\u0012\u0004\u0012\u009d\b\u0012\u000b\u0012\f\u0012\u009e\u0001"+
		"\u0012\u0001\u0012\u0001w\u0000\u0013\u0001\u0001\u0003\u0002\u0005\u0003"+
		"\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015"+
		"\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012"+
		"%\u0013\u0001\u0000\u0003\u0001\u000019\u0001\u000009\u0003\u0000\t\n"+
		"\r\r  \u00a7\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000"+
		"\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000"+
		"\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000"+
		"\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000"+
		"\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000"+
		"\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000"+
		"\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000"+
		"\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000"+
		"\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%"+
		"\u0001\u0000\u0000\u0000\u0001\'\u0001\u0000\u0000\u0000\u0003)\u0001"+
		"\u0000\u0000\u0000\u0005+\u0001\u0000\u0000\u0000\u0007-\u0001\u0000\u0000"+
		"\u0000\t/\u0001\u0000\u0000\u0000\u000b1\u0001\u0000\u0000\u0000\r3\u0001"+
		"\u0000\u0000\u0000\u000f9\u0001\u0000\u0000\u0000\u0011@\u0001\u0000\u0000"+
		"\u0000\u0013G\u0001\u0000\u0000\u0000\u0015M\u0001\u0000\u0000\u0000\u0017"+
		"T\u0001\u0000\u0000\u0000\u0019[\u0001\u0000\u0000\u0000\u001bk\u0001"+
		"\u0000\u0000\u0000\u001ds\u0001\u0000\u0000\u0000\u001f|\u0001\u0000\u0000"+
		"\u0000!\u0081\u0001\u0000\u0000\u0000#\u0099\u0001\u0000\u0000\u0000%"+
		"\u009c\u0001\u0000\u0000\u0000\'(\u0005{\u0000\u0000(\u0002\u0001\u0000"+
		"\u0000\u0000)*\u0005}\u0000\u0000*\u0004\u0001\u0000\u0000\u0000+,\u0005"+
		"[\u0000\u0000,\u0006\u0001\u0000\u0000\u0000-.\u0005,\u0000\u0000.\b\u0001"+
		"\u0000\u0000\u0000/0\u0005]\u0000\u00000\n\u0001\u0000\u0000\u000012\u0005"+
		";\u0000\u00002\f\u0001\u0000\u0000\u000034\u0005M\u0000\u000045\u0005"+
		"Q\u0000\u000056\u0005U\u0000\u000067\u0005E\u0000\u000078\u0005S\u0000"+
		"\u00008\u000e\u0001\u0000\u0000\u00009:\u0005M\u0000\u0000:;\u0005C\u0000"+
		"\u0000;<\u0005Q\u0000\u0000<=\u0005U\u0000\u0000=>\u0005E\u0000\u0000"+
		">?\u0005S\u0000\u0000?\u0010\u0001\u0000\u0000\u0000@A\u0005S\u0000\u0000"+
		"AB\u0005A\u0000\u0000BC\u0005Q\u0000\u0000CD\u0005U\u0000\u0000DE\u0005"+
		"E\u0000\u0000EF\u0005S\u0000\u0000F\u0012\u0001\u0000\u0000\u0000GH\u0005"+
		"N\u0000\u0000HI\u0005Q\u0000\u0000IJ\u0005U\u0000\u0000JK\u0005E\u0000"+
		"\u0000KL\u0005S\u0000\u0000L\u0014\u0001\u0000\u0000\u0000MN\u0005S\u0000"+
		"\u0000NO\u0005W\u0000\u0000OP\u0005Q\u0000\u0000PQ\u0005U\u0000\u0000"+
		"QR\u0005E\u0000\u0000RS\u0005S\u0000\u0000S\u0016\u0001\u0000\u0000\u0000"+
		"TU\u0005T\u0000\u0000UV\u0005F\u0000\u0000VW\u0005Q\u0000\u0000WX\u0005"+
		"U\u0000\u0000XY\u0005E\u0000\u0000YZ\u0005S\u0000\u0000Z\u0018\u0001\u0000"+
		"\u0000\u0000[\\\u0005E\u0000\u0000\\]\u0005X\u0000\u0000]^\u0005A\u0000"+
		"\u0000^_\u0005M\u0000\u0000_`\u0005 \u0000\u0000`a\u0005S\u0000\u0000"+
		"ab\u0005U\u0000\u0000bc\u0005B\u0000\u0000cd\u0005M\u0000\u0000de\u0005"+
		"I\u0000\u0000ef\u0005S\u0000\u0000fg\u0005S\u0000\u0000gh\u0005I\u0000"+
		"\u0000hi\u0005O\u0000\u0000ij\u0005N\u0000\u0000j\u001a\u0001\u0000\u0000"+
		"\u0000kl\u0005S\u0000\u0000lm\u0005E\u0000\u0000mn\u0005C\u0000\u0000"+
		"no\u0005T\u0000\u0000op\u0005I\u0000\u0000pq\u0005O\u0000\u0000qr\u0005"+
		"N\u0000\u0000r\u001c\u0001\u0000\u0000\u0000sw\u0005\"\u0000\u0000tv\t"+
		"\u0000\u0000\u0000ut\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000"+
		"wx\u0001\u0000\u0000\u0000wu\u0001\u0000\u0000\u0000xz\u0001\u0000\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000z{\u0005\"\u0000\u0000{\u001e\u0001\u0000"+
		"\u0000\u0000|}\u0005n\u0000\u0000}~\u0005u\u0000\u0000~\u007f\u0005l\u0000"+
		"\u0000\u007f\u0080\u0005l\u0000\u0000\u0080 \u0001\u0000\u0000\u0000\u0081"+
		"\u0085\u0007\u0000\u0000\u0000\u0082\u0084\u0007\u0001\u0000\u0000\u0083"+
		"\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000\u0000\u0085"+
		"\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000\u0000\u0086"+
		"\u008e\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000\u0000\u0088"+
		"\u008a\u0005.\u0000\u0000\u0089\u008b\u0007\u0001\u0000\u0000\u008a\u0089"+
		"\u0001\u0000\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008a"+
		"\u0001\u0000\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u008f"+
		"\u0001\u0000\u0000\u0000\u008e\u0088\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0001\u0000\u0000\u0000\u008f\"\u0001\u0000\u0000\u0000\u0090\u0091\u0005"+
		"T\u0000\u0000\u0091\u0092\u0005r\u0000\u0000\u0092\u0093\u0005u\u0000"+
		"\u0000\u0093\u009a\u0005e\u0000\u0000\u0094\u0095\u0005F\u0000\u0000\u0095"+
		"\u0096\u0005a\u0000\u0000\u0096\u0097\u0005l\u0000\u0000\u0097\u0098\u0005"+
		"s\u0000\u0000\u0098\u009a\u0005e\u0000\u0000\u0099\u0090\u0001\u0000\u0000"+
		"\u0000\u0099\u0094\u0001\u0000\u0000\u0000\u009a$\u0001\u0000\u0000\u0000"+
		"\u009b\u009d\u0007\u0002\u0000\u0000\u009c\u009b\u0001\u0000\u0000\u0000"+
		"\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000"+
		"\u009e\u009f\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0006\u0012\u0000\u0000\u00a1&\u0001\u0000\u0000\u0000\u0007"+
		"\u0000w\u0085\u008c\u008e\u0099\u009e\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}