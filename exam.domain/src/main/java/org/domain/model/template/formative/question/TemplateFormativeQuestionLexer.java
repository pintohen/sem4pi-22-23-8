// Generated from D:/JavaProjects/sem4pi-22-23-8/exam.domain/src/main/java/org/domain/model/template/formative/question\TemplateFormativeQuestion.g4 by ANTLR 4.12.0
package org.domain.model.template.formative.question;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class TemplateFormativeQuestionLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, ID_OPTION=3, ID_SOLUTION=4, MATCHING=5, MULTIPLE_CHOICE=6, 
		SHORT_ANSWER=7, NUMERICAL=8, SELECT_WORDS=9, TRUE_FALSE=10, SOLUTION_TEXT=11, 
		TRUE_FALSE_SOLUTION_TEXT=12, SOL_DESCRIPTION=13, TRUE_FALSE_SOL_DESCRIPTION=14, 
		DESCRIPTION=15, NUMBER=16, NEWLINE=17, DECIMAL=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "ID_OPTION", "ID_SOLUTION", "MATCHING", "MULTIPLE_CHOICE", 
			"SHORT_ANSWER", "NUMERICAL", "SELECT_WORDS", "TRUE_FALSE", "SOLUTION_TEXT", 
			"TRUE_FALSE_SOLUTION_TEXT", "SOL_DESCRIPTION", "TRUE_FALSE_SOL_DESCRIPTION", 
			"DESCRIPTION", "NUMBER", "NEWLINE", "DECIMAL"
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


	public TemplateFormativeQuestionLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "TemplateFormativeQuestion.g4"; }

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
		"\u0004\u0000\u0012\u0098\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f\u0005\fg\b\f\n\f\f"+
		"\fj\t\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0003\ru\b\r\u0001\u000e\u0001\u000e\u0005\u000ey\b\u000e\n"+
		"\u000e\f\u000e|\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f"+
		"\u0005\u000f\u0082\b\u000f\n\u000f\f\u000f\u0085\t\u000f\u0001\u000f\u0001"+
		"\u000f\u0004\u000f\u0089\b\u000f\u000b\u000f\f\u000f\u008a\u0003\u000f"+
		"\u008d\b\u000f\u0001\u0010\u0003\u0010\u0090\b\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0003"+
		"hz\u0083\u0000\u0012\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"+
		"\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"+
		"\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012\u0001\u0000"+
		"\u0002\u0001\u000019\u0001\u000009\u009e\u0000\u0001\u0001\u0000\u0000"+
		"\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000"+
		"\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000"+
		"\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000"+
		"\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000"+
		"\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000"+
		"\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000"+
		"\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000"+
		"\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001"+
		"\u0000\u0000\u0000\u0001%\u0001\u0000\u0000\u0000\u0003\'\u0001\u0000"+
		"\u0000\u0000\u0005)\u0001\u0000\u0000\u0000\u0007-\u0001\u0000\u0000\u0000"+
		"\t1\u0001\u0000\u0000\u0000\u000b7\u0001\u0000\u0000\u0000\r>\u0001\u0000"+
		"\u0000\u0000\u000fE\u0001\u0000\u0000\u0000\u0011K\u0001\u0000\u0000\u0000"+
		"\u0013R\u0001\u0000\u0000\u0000\u0015Y\u0001\u0000\u0000\u0000\u0017_"+
		"\u0001\u0000\u0000\u0000\u0019h\u0001\u0000\u0000\u0000\u001bt\u0001\u0000"+
		"\u0000\u0000\u001dv\u0001\u0000\u0000\u0000\u001f\u007f\u0001\u0000\u0000"+
		"\u0000!\u008f\u0001\u0000\u0000\u0000#\u0093\u0001\u0000\u0000\u0000%"+
		"&\u0005 \u0000\u0000&\u0002\u0001\u0000\u0000\u0000\'(\u0005;\u0000\u0000"+
		"(\u0004\u0001\u0000\u0000\u0000)*\u0005O\u0000\u0000*+\u0005P\u0000\u0000"+
		"+,\u0005T\u0000\u0000,\u0006\u0001\u0000\u0000\u0000-.\u0005S\u0000\u0000"+
		"./\u0005O\u0000\u0000/0\u0005L\u0000\u00000\b\u0001\u0000\u0000\u0000"+
		"12\u0005M\u0000\u000023\u0005Q\u0000\u000034\u0005U\u0000\u000045\u0005"+
		"E\u0000\u000056\u0005S\u0000\u00006\n\u0001\u0000\u0000\u000078\u0005"+
		"M\u0000\u000089\u0005C\u0000\u00009:\u0005Q\u0000\u0000:;\u0005U\u0000"+
		"\u0000;<\u0005E\u0000\u0000<=\u0005S\u0000\u0000=\f\u0001\u0000\u0000"+
		"\u0000>?\u0005S\u0000\u0000?@\u0005A\u0000\u0000@A\u0005Q\u0000\u0000"+
		"AB\u0005U\u0000\u0000BC\u0005E\u0000\u0000CD\u0005S\u0000\u0000D\u000e"+
		"\u0001\u0000\u0000\u0000EF\u0005N\u0000\u0000FG\u0005Q\u0000\u0000GH\u0005"+
		"U\u0000\u0000HI\u0005E\u0000\u0000IJ\u0005S\u0000\u0000J\u0010\u0001\u0000"+
		"\u0000\u0000KL\u0005S\u0000\u0000LM\u0005W\u0000\u0000MN\u0005Q\u0000"+
		"\u0000NO\u0005U\u0000\u0000OP\u0005E\u0000\u0000PQ\u0005S\u0000\u0000"+
		"Q\u0012\u0001\u0000\u0000\u0000RS\u0005T\u0000\u0000ST\u0005F\u0000\u0000"+
		"TU\u0005Q\u0000\u0000UV\u0005U\u0000\u0000VW\u0005E\u0000\u0000WX\u0005"+
		"S\u0000\u0000X\u0014\u0001\u0000\u0000\u0000YZ\u0005|\u0000\u0000Z[\u0003"+
		"\u0019\f\u0000[\\\u0005|\u0000\u0000\\]\u0003#\u0011\u0000]^\u0005|\u0000"+
		"\u0000^\u0016\u0001\u0000\u0000\u0000_`\u0005<\u0000\u0000`a\u0003\u001b"+
		"\r\u0000ab\u0005|\u0000\u0000bc\u0003#\u0011\u0000cd\u0005>\u0000\u0000"+
		"d\u0018\u0001\u0000\u0000\u0000eg\t\u0000\u0000\u0000fe\u0001\u0000\u0000"+
		"\u0000gj\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000hf\u0001\u0000"+
		"\u0000\u0000i\u001a\u0001\u0000\u0000\u0000jh\u0001\u0000\u0000\u0000"+
		"kl\u0005T\u0000\u0000lm\u0005r\u0000\u0000mn\u0005u\u0000\u0000nu\u0005"+
		"e\u0000\u0000op\u0005F\u0000\u0000pq\u0005a\u0000\u0000qr\u0005l\u0000"+
		"\u0000rs\u0005s\u0000\u0000su\u0005e\u0000\u0000tk\u0001\u0000\u0000\u0000"+
		"to\u0001\u0000\u0000\u0000u\u001c\u0001\u0000\u0000\u0000vz\u0005\"\u0000"+
		"\u0000wy\t\u0000\u0000\u0000xw\u0001\u0000\u0000\u0000y|\u0001\u0000\u0000"+
		"\u0000z{\u0001\u0000\u0000\u0000zx\u0001\u0000\u0000\u0000{}\u0001\u0000"+
		"\u0000\u0000|z\u0001\u0000\u0000\u0000}~\u0005\"\u0000\u0000~\u001e\u0001"+
		"\u0000\u0000\u0000\u007f\u0083\u0007\u0000\u0000\u0000\u0080\u0082\u0007"+
		"\u0001\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0085\u0001"+
		"\u0000\u0000\u0000\u0083\u0084\u0001\u0000\u0000\u0000\u0083\u0081\u0001"+
		"\u0000\u0000\u0000\u0084\u008c\u0001\u0000\u0000\u0000\u0085\u0083\u0001"+
		"\u0000\u0000\u0000\u0086\u0088\u0005.\u0000\u0000\u0087\u0089\u0007\u0001"+
		"\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008a\u0001\u0000"+
		"\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"+
		"\u0000\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c\u0086\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d \u0001\u0000\u0000"+
		"\u0000\u008e\u0090\u0005\r\u0000\u0000\u008f\u008e\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000\u0000"+
		"\u0091\u0092\u0005\n\u0000\u0000\u0092\"\u0001\u0000\u0000\u0000\u0093"+
		"\u0094\u0007\u0001\u0000\u0000\u0094\u0095\u0005.\u0000\u0000\u0095\u0096"+
		"\u0007\u0001\u0000\u0000\u0096\u0097\u0007\u0001\u0000\u0000\u0097$\u0001"+
		"\u0000\u0000\u0000\b\u0000htz\u0083\u008a\u008c\u008f\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}