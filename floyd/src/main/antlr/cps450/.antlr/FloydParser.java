// Generated from c:\Users\AJ Steenhoek\Documents\BJU\Spring_2018\Cps450\phase3\semantics\src\main\antlr\cps450\Floyd.g4 by ANTLR 4.7
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FloydParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SKIPCHAR=1, BOOLEAN=2, BEGIN=3, CLASS=4, ELSE=5, END=6, FROM=7, IF=8, 
		INHERITS=9, INT=10, IS=11, LOOP=12, ME=13, NEW=14, NULL=15, STRING=16, 
		THEN=17, TRUE=18, FALSE=19, WHILE=20, AND=21, OR=22, NOT=23, IDENTIFIER=24, 
		INTEGER=25, STRINGLITERAL=26, UNTERMINATEDSTRING=27, ILLEGALSTRING=28, 
		NEWLINE=29, CONCAT=30, PLUS=31, MINUS=32, MUL=33, DIV=34, GT=35, GTE=36, 
		EQUALS=37, ASSIGNMENTOP=38, LPAREN=39, RPAREN=40, LBRACKET=41, RBRACKET=42, 
		COMMA=43, SEMICOLON=44, COLON=45, PERIOD=46, UNRECOGNIZEDCHAR=47;
	public static final int
		RULE_program = 0, RULE_cr = 1, RULE_start = 2, RULE_fclass = 3, RULE_unary_op = 4, 
		RULE_expression = 5, RULE_andexpr = 6, RULE_equalexpr = 7, RULE_gtexpr = 8, 
		RULE_gteexpr = 9, RULE_concatexpr = 10, RULE_plusminexpr = 11, RULE_muldivexpr = 12, 
		RULE_unaryexpr = 13, RULE_newcallexpr = 14, RULE_parenexpr = 15, RULE_expression_list = 16, 
		RULE_method_decl = 17, RULE_argument_decl_list = 18, RULE_argument_decl = 19, 
		RULE_statement_list = 20, RULE_statement = 21, RULE_assign_stmt = 22, 
		RULE_if_stmt = 23, RULE_loop_stmt = 24, RULE_call_stmt = 25, RULE_type = 26, 
		RULE_var_decl = 27;
	public static final String[] ruleNames = {
		"program", "cr", "start", "fclass", "unary_op", "expression", "andexpr", 
		"equalexpr", "gtexpr", "gteexpr", "concatexpr", "plusminexpr", "muldivexpr", 
		"unaryexpr", "newcallexpr", "parenexpr", "expression_list", "method_decl", 
		"argument_decl_list", "argument_decl", "statement_list", "statement", 
		"assign_stmt", "if_stmt", "loop_stmt", "call_stmt", "type", "var_decl"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'boolean'", "'begin'", "'class'", "'else'", "'end'", "'from'", 
		"'if'", "'inherits'", "'int'", "'is'", "'loop'", "'me'", "'new'", "'null'", 
		"'string'", "'then'", "'true'", "'false'", "'while'", "'and'", "'or'", 
		"'not'", null, null, null, null, null, null, "'&'", "'+'", "'-'", "'*'", 
		"'/'", "'>'", "'>='", "'='", "':='", "'('", "')'", "'['", "']'", "','", 
		"';'", "':'", "'.'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "SKIPCHAR", "BOOLEAN", "BEGIN", "CLASS", "ELSE", "END", "FROM", 
		"IF", "INHERITS", "INT", "IS", "LOOP", "ME", "NEW", "NULL", "STRING", 
		"THEN", "TRUE", "FALSE", "WHILE", "AND", "OR", "NOT", "IDENTIFIER", "INTEGER", 
		"STRINGLITERAL", "UNTERMINATEDSTRING", "ILLEGALSTRING", "NEWLINE", "CONCAT", 
		"PLUS", "MINUS", "MUL", "DIV", "GT", "GTE", "EQUALS", "ASSIGNMENTOP", 
		"LPAREN", "RPAREN", "LBRACKET", "RBRACKET", "COMMA", "SEMICOLON", "COLON", 
		"PERIOD", "UNRECOGNIZEDCHAR"
	};
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
	public String getGrammarFileName() { return "Floyd.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public FloydParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public StartContext start() {
			return getRuleContext(StartContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(56);
			start();
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

	public static class CrContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(FloydParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(FloydParser.NEWLINE, i);
		}
		public CrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cr; }
	}

	public final CrContext cr() throws RecognitionException {
		CrContext _localctx = new CrContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_cr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(58);
				match(NEWLINE);
				}
				}
				setState(61); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NEWLINE );
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

	public static class StartContext extends ParserRuleContext {
		public FclassContext fclasses;
		public List<FclassContext> fclass() {
			return getRuleContexts(FclassContext.class);
		}
		public FclassContext fclass(int i) {
			return getRuleContext(FclassContext.class,i);
		}
		public List<CrContext> cr() {
			return getRuleContexts(CrContext.class);
		}
		public CrContext cr(int i) {
			return getRuleContext(CrContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_start);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(63);
				cr();
				}
			}

			setState(66);
			((StartContext)_localctx).fclasses = fclass();
			setState(72);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(67);
					cr();
					setState(68);
					((StartContext)_localctx).fclasses = fclass();
					}
					} 
				}
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(75);
				cr();
				}
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

	public static class FclassContext extends ParserRuleContext {
		public Var_declContext var_decls;
		public Method_declContext method_decls;
		public TerminalNode CLASS() { return getToken(FloydParser.CLASS, 0); }
		public List<TerminalNode> IDENTIFIER() { return getTokens(FloydParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FloydParser.IDENTIFIER, i);
		}
		public TerminalNode IS() { return getToken(FloydParser.IS, 0); }
		public CrContext cr() {
			return getRuleContext(CrContext.class,0);
		}
		public TerminalNode END() { return getToken(FloydParser.END, 0); }
		public TerminalNode INHERITS() { return getToken(FloydParser.INHERITS, 0); }
		public TerminalNode FROM() { return getToken(FloydParser.FROM, 0); }
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public List<Method_declContext> method_decl() {
			return getRuleContexts(Method_declContext.class);
		}
		public Method_declContext method_decl(int i) {
			return getRuleContext(Method_declContext.class,i);
		}
		public FclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fclass; }
	}

	public final FclassContext fclass() throws RecognitionException {
		FclassContext _localctx = new FclassContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fclass);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(CLASS);
			setState(79);
			match(IDENTIFIER);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(80);
				match(INHERITS);
				setState(81);
				match(FROM);
				setState(82);
				match(IDENTIFIER);
				}
			}

			setState(85);
			match(IS);
			setState(86);
			cr();
			setState(90);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(87);
					((FclassContext)_localctx).var_decls = var_decl();
					}
					} 
				}
				setState(92);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(93);
				((FclassContext)_localctx).method_decls = method_decl();
				}
				}
				setState(98);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(99);
			match(END);
			setState(100);
			match(IDENTIFIER);
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

	public static class Unary_opContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(FloydParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FloydParser.MINUS, 0); }
		public TerminalNode NOT() { return getToken(FloydParser.NOT, 0); }
		public Unary_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_op; }
	}

	public final Unary_opContext unary_op() throws RecognitionException {
		Unary_opContext _localctx = new Unary_opContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_unary_op);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NOT) | (1L << PLUS) | (1L << MINUS))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
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

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IdExprContext extends ExpressionContext {
		public TerminalNode IDENTIFIER() { return getToken(FloydParser.IDENTIFIER, 0); }
		public List<TerminalNode> LBRACKET() { return getTokens(FloydParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(FloydParser.LBRACKET, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(FloydParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(FloydParser.RBRACKET, i);
		}
		public IdExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class AndSubExprContext extends ExpressionContext {
		public AndexprContext andexpr() {
			return getRuleContext(AndexprContext.class,0);
		}
		public AndSubExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	public static class OrExprContext extends ExpressionContext {
		public ExpressionContext e1;
		public AndexprContext e2;
		public TerminalNode OR() { return getToken(FloydParser.OR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AndexprContext andexpr() {
			return getRuleContext(AndexprContext.class,0);
		}
		public OrExprContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(105);
				match(IDENTIFIER);
				setState(110); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(106);
						match(LBRACKET);
						setState(107);
						expression(0);
						setState(108);
						match(RBRACKET);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(112); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				{
				_localctx = new AndSubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(114);
				andexpr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(122);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState));
					((OrExprContext)_localctx).e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(117);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(118);
					match(OR);
					setState(119);
					((OrExprContext)_localctx).e2 = andexpr(0);
					}
					} 
				}
				setState(124);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class AndexprContext extends ParserRuleContext {
		public AndexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andexpr; }
	 
		public AndexprContext() { }
		public void copyFrom(AndexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqSubExprContext extends AndexprContext {
		public EqualexprContext equalexpr() {
			return getRuleContext(EqualexprContext.class,0);
		}
		public EqSubExprContext(AndexprContext ctx) { copyFrom(ctx); }
	}
	public static class AndExprContext extends AndexprContext {
		public AndexprContext e1;
		public EqualexprContext e2;
		public TerminalNode AND() { return getToken(FloydParser.AND, 0); }
		public AndexprContext andexpr() {
			return getRuleContext(AndexprContext.class,0);
		}
		public EqualexprContext equalexpr() {
			return getRuleContext(EqualexprContext.class,0);
		}
		public AndExprContext(AndexprContext ctx) { copyFrom(ctx); }
	}
	public static class GteSubExprContext extends AndexprContext {
		public GteexprContext gteexpr() {
			return getRuleContext(GteexprContext.class,0);
		}
		public GteSubExprContext(AndexprContext ctx) { copyFrom(ctx); }
	}
	public static class GtSubExprContext extends AndexprContext {
		public GtexprContext gtexpr() {
			return getRuleContext(GtexprContext.class,0);
		}
		public GtSubExprContext(AndexprContext ctx) { copyFrom(ctx); }
	}

	public final AndexprContext andexpr() throws RecognitionException {
		return andexpr(0);
	}

	private AndexprContext andexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		AndexprContext _localctx = new AndexprContext(_ctx, _parentState);
		AndexprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_andexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				_localctx = new EqSubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(126);
				equalexpr(0);
				}
				break;
			case 2:
				{
				_localctx = new GtSubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(127);
				gtexpr(0);
				}
				break;
			case 3:
				{
				_localctx = new GteSubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(128);
				gteexpr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(136);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AndExprContext(new AndexprContext(_parentctx, _parentState));
					((AndExprContext)_localctx).e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_andexpr);
					setState(131);
					if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
					setState(132);
					match(AND);
					setState(133);
					((AndExprContext)_localctx).e2 = equalexpr(0);
					}
					} 
				}
				setState(138);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class EqualexprContext extends ParserRuleContext {
		public EqualexprContext e1;
		public ConcatexprContext e2;
		public ConcatexprContext concatexpr() {
			return getRuleContext(ConcatexprContext.class,0);
		}
		public TerminalNode EQUALS() { return getToken(FloydParser.EQUALS, 0); }
		public EqualexprContext equalexpr() {
			return getRuleContext(EqualexprContext.class,0);
		}
		public EqualexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalexpr; }
	}

	public final EqualexprContext equalexpr() throws RecognitionException {
		return equalexpr(0);
	}

	private EqualexprContext equalexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		EqualexprContext _localctx = new EqualexprContext(_ctx, _parentState);
		EqualexprContext _prevctx = _localctx;
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_equalexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(140);
			concatexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new EqualexprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_equalexpr);
					setState(142);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(143);
					match(EQUALS);
					setState(144);
					((EqualexprContext)_localctx).e2 = concatexpr(0);
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GtexprContext extends ParserRuleContext {
		public GtexprContext e1;
		public ConcatexprContext e2;
		public ConcatexprContext concatexpr() {
			return getRuleContext(ConcatexprContext.class,0);
		}
		public TerminalNode GT() { return getToken(FloydParser.GT, 0); }
		public GtexprContext gtexpr() {
			return getRuleContext(GtexprContext.class,0);
		}
		public GtexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gtexpr; }
	}

	public final GtexprContext gtexpr() throws RecognitionException {
		return gtexpr(0);
	}

	private GtexprContext gtexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GtexprContext _localctx = new GtexprContext(_ctx, _parentState);
		GtexprContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_gtexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(151);
			concatexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GtexprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_gtexpr);
					setState(153);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(154);
					match(GT);
					setState(155);
					((GtexprContext)_localctx).e2 = concatexpr(0);
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class GteexprContext extends ParserRuleContext {
		public GteexprContext e1;
		public ConcatexprContext e2;
		public ConcatexprContext concatexpr() {
			return getRuleContext(ConcatexprContext.class,0);
		}
		public TerminalNode GTE() { return getToken(FloydParser.GTE, 0); }
		public GteexprContext gteexpr() {
			return getRuleContext(GteexprContext.class,0);
		}
		public GteexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gteexpr; }
	}

	public final GteexprContext gteexpr() throws RecognitionException {
		return gteexpr(0);
	}

	private GteexprContext gteexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GteexprContext _localctx = new GteexprContext(_ctx, _parentState);
		GteexprContext _prevctx = _localctx;
		int _startState = 18;
		enterRecursionRule(_localctx, 18, RULE_gteexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(162);
			concatexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(169);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GteexprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_gteexpr);
					setState(164);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(165);
					match(GTE);
					setState(166);
					((GteexprContext)_localctx).e2 = concatexpr(0);
					}
					} 
				}
				setState(171);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class ConcatexprContext extends ParserRuleContext {
		public ConcatexprContext e1;
		public PlusminexprContext e2;
		public PlusminexprContext plusminexpr() {
			return getRuleContext(PlusminexprContext.class,0);
		}
		public TerminalNode CONCAT() { return getToken(FloydParser.CONCAT, 0); }
		public ConcatexprContext concatexpr() {
			return getRuleContext(ConcatexprContext.class,0);
		}
		public ConcatexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatexpr; }
	}

	public final ConcatexprContext concatexpr() throws RecognitionException {
		return concatexpr(0);
	}

	private ConcatexprContext concatexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConcatexprContext _localctx = new ConcatexprContext(_ctx, _parentState);
		ConcatexprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_concatexpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(173);
			plusminexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(180);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ConcatexprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_concatexpr);
					setState(175);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(176);
					match(CONCAT);
					setState(177);
					((ConcatexprContext)_localctx).e2 = plusminexpr(0);
					}
					} 
				}
				setState(182);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class PlusminexprContext extends ParserRuleContext {
		public PlusminexprContext e1;
		public MuldivexprContext e2;
		public MuldivexprContext muldivexpr() {
			return getRuleContext(MuldivexprContext.class,0);
		}
		public PlusminexprContext plusminexpr() {
			return getRuleContext(PlusminexprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(FloydParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(FloydParser.MINUS, 0); }
		public PlusminexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_plusminexpr; }
	}

	public final PlusminexprContext plusminexpr() throws RecognitionException {
		return plusminexpr(0);
	}

	private PlusminexprContext plusminexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PlusminexprContext _localctx = new PlusminexprContext(_ctx, _parentState);
		PlusminexprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_plusminexpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(184);
			muldivexpr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(191);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PlusminexprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_plusminexpr);
					setState(186);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(187);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(188);
					((PlusminexprContext)_localctx).e2 = muldivexpr(0);
					}
					} 
				}
				setState(193);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class MuldivexprContext extends ParserRuleContext {
		public MuldivexprContext e1;
		public UnaryexprContext e2;
		public UnaryexprContext unaryexpr() {
			return getRuleContext(UnaryexprContext.class,0);
		}
		public MuldivexprContext muldivexpr() {
			return getRuleContext(MuldivexprContext.class,0);
		}
		public TerminalNode MUL() { return getToken(FloydParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(FloydParser.DIV, 0); }
		public MuldivexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_muldivexpr; }
	}

	public final MuldivexprContext muldivexpr() throws RecognitionException {
		return muldivexpr(0);
	}

	private MuldivexprContext muldivexpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		MuldivexprContext _localctx = new MuldivexprContext(_ctx, _parentState);
		MuldivexprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_muldivexpr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(195);
			unaryexpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(202);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new MuldivexprContext(_parentctx, _parentState);
					_localctx.e1 = _prevctx;
					_localctx.e1 = _prevctx;
					pushNewRecursionContext(_localctx, _startState, RULE_muldivexpr);
					setState(197);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(198);
					_la = _input.LA(1);
					if ( !(_la==MUL || _la==DIV) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(199);
					((MuldivexprContext)_localctx).e2 = unaryexpr();
					}
					} 
				}
				setState(204);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnaryexprContext extends ParserRuleContext {
		public Unary_opContext unary_op() {
			return getRuleContext(Unary_opContext.class,0);
		}
		public UnaryexprContext unaryexpr() {
			return getRuleContext(UnaryexprContext.class,0);
		}
		public NewcallexprContext newcallexpr() {
			return getRuleContext(NewcallexprContext.class,0);
		}
		public UnaryexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryexpr; }
	}

	public final UnaryexprContext unaryexpr() throws RecognitionException {
		UnaryexprContext _localctx = new UnaryexprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_unaryexpr);
		try {
			setState(209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
			case PLUS:
			case MINUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(205);
				unary_op();
				setState(206);
				unaryexpr();
				}
				break;
			case ME:
			case NEW:
			case NULL:
			case TRUE:
			case FALSE:
			case IDENTIFIER:
			case INTEGER:
			case STRINGLITERAL:
			case LPAREN:
				enterOuterAlt(_localctx, 2);
				{
				setState(208);
				newcallexpr();
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

	public static class NewcallexprContext extends ParserRuleContext {
		public NewcallexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newcallexpr; }
	 
		public NewcallexprContext() { }
		public void copyFrom(NewcallexprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PeriodExprContext extends NewcallexprContext {
		public TerminalNode IDENTIFIER() { return getToken(FloydParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(FloydParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FloydParser.RPAREN, 0); }
		public ParenexprContext parenexpr() {
			return getRuleContext(ParenexprContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(FloydParser.PERIOD, 0); }
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public PeriodExprContext(NewcallexprContext ctx) { copyFrom(ctx); }
	}
	public static class NewExprContext extends NewcallexprContext {
		public TerminalNode NEW() { return getToken(FloydParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public NewExprContext(NewcallexprContext ctx) { copyFrom(ctx); }
	}
	public static class ParenSubExprContext extends NewcallexprContext {
		public ParenexprContext parenexpr() {
			return getRuleContext(ParenexprContext.class,0);
		}
		public ParenSubExprContext(NewcallexprContext ctx) { copyFrom(ctx); }
	}

	public final NewcallexprContext newcallexpr() throws RecognitionException {
		NewcallexprContext _localctx = new NewcallexprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_newcallexpr);
		int _la;
		try {
			setState(225);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				_localctx = new NewExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(211);
				match(NEW);
				setState(212);
				type(0);
				}
				break;
			case 2:
				_localctx = new PeriodExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(213);
					parenexpr();
					setState(214);
					match(PERIOD);
					}
					break;
				}
				setState(218);
				match(IDENTIFIER);
				setState(219);
				match(LPAREN);
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ME) | (1L << NEW) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << IDENTIFIER) | (1L << INTEGER) | (1L << STRINGLITERAL) | (1L << PLUS) | (1L << MINUS) | (1L << LPAREN))) != 0)) {
					{
					setState(220);
					expression_list();
					}
				}

				setState(223);
				match(RPAREN);
				}
				break;
			case 3:
				_localctx = new ParenSubExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(224);
				parenexpr();
				}
				break;
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

	public static class ParenexprContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(FloydParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(FloydParser.RPAREN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FloydParser.IDENTIFIER, 0); }
		public TerminalNode STRINGLITERAL() { return getToken(FloydParser.STRINGLITERAL, 0); }
		public TerminalNode INTEGER() { return getToken(FloydParser.INTEGER, 0); }
		public TerminalNode TRUE() { return getToken(FloydParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(FloydParser.FALSE, 0); }
		public TerminalNode NULL() { return getToken(FloydParser.NULL, 0); }
		public TerminalNode ME() { return getToken(FloydParser.ME, 0); }
		public ParenexprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenexpr; }
	}

	public final ParenexprContext parenexpr() throws RecognitionException {
		ParenexprContext _localctx = new ParenexprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_parenexpr);
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(227);
				match(LPAREN);
				setState(228);
				expression(0);
				setState(229);
				match(RPAREN);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(231);
				match(IDENTIFIER);
				}
				break;
			case STRINGLITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(232);
				match(STRINGLITERAL);
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(233);
				match(INTEGER);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 5);
				{
				setState(234);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 6);
				{
				setState(235);
				match(FALSE);
				}
				break;
			case NULL:
				enterOuterAlt(_localctx, 7);
				{
				setState(236);
				match(NULL);
				}
				break;
			case ME:
				enterOuterAlt(_localctx, 8);
				{
				setState(237);
				match(ME);
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

	public static class Expression_listContext extends ParserRuleContext {
		public ExpressionContext exprs;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(FloydParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(FloydParser.COMMA, i);
		}
		public Expression_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_list; }
	}

	public final Expression_listContext expression_list() throws RecognitionException {
		Expression_listContext _localctx = new Expression_listContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_expression_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(245);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(240);
					((Expression_listContext)_localctx).exprs = expression(0);
					setState(241);
					match(COMMA);
					}
					} 
				}
				setState(247);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			}
			setState(248);
			((Expression_listContext)_localctx).exprs = expression(0);
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

	public static class Method_declContext extends ParserRuleContext {
		public Var_declContext var_decls;
		public List<TerminalNode> IDENTIFIER() { return getTokens(FloydParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(FloydParser.IDENTIFIER, i);
		}
		public TerminalNode LPAREN() { return getToken(FloydParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FloydParser.RPAREN, 0); }
		public TerminalNode IS() { return getToken(FloydParser.IS, 0); }
		public List<CrContext> cr() {
			return getRuleContexts(CrContext.class);
		}
		public CrContext cr(int i) {
			return getRuleContext(CrContext.class,i);
		}
		public TerminalNode BEGIN() { return getToken(FloydParser.BEGIN, 0); }
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode END() { return getToken(FloydParser.END, 0); }
		public Argument_decl_listContext argument_decl_list() {
			return getRuleContext(Argument_decl_listContext.class,0);
		}
		public TerminalNode COLON() { return getToken(FloydParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<Var_declContext> var_decl() {
			return getRuleContexts(Var_declContext.class);
		}
		public Var_declContext var_decl(int i) {
			return getRuleContext(Var_declContext.class,i);
		}
		public Method_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_method_decl; }
	}

	public final Method_declContext method_decl() throws RecognitionException {
		Method_declContext _localctx = new Method_declContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_method_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(250);
			match(IDENTIFIER);
			setState(251);
			match(LPAREN);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(252);
				argument_decl_list();
				}
			}

			setState(255);
			match(RPAREN);
			setState(258);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(256);
				match(COLON);
				setState(257);
				type(0);
				}
			}

			setState(260);
			match(IS);
			setState(261);
			cr();
			setState(265);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(262);
				((Method_declContext)_localctx).var_decls = var_decl();
				}
				}
				setState(267);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(268);
			match(BEGIN);
			setState(269);
			cr();
			setState(270);
			statement_list();
			setState(271);
			match(END);
			setState(272);
			match(IDENTIFIER);
			setState(273);
			cr();
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

	public static class Argument_decl_listContext extends ParserRuleContext {
		public Argument_declContext args;
		public List<Argument_declContext> argument_decl() {
			return getRuleContexts(Argument_declContext.class);
		}
		public Argument_declContext argument_decl(int i) {
			return getRuleContext(Argument_declContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(FloydParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(FloydParser.SEMICOLON, i);
		}
		public Argument_decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_decl_list; }
	}

	public final Argument_decl_listContext argument_decl_list() throws RecognitionException {
		Argument_decl_listContext _localctx = new Argument_decl_listContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_argument_decl_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(275);
					((Argument_decl_listContext)_localctx).args = argument_decl();
					setState(276);
					match(SEMICOLON);
					}
					} 
				}
				setState(282);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(283);
			((Argument_decl_listContext)_localctx).args = argument_decl();
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

	public static class Argument_declContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FloydParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(FloydParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Argument_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_decl; }
	}

	public final Argument_declContext argument_decl() throws RecognitionException {
		Argument_declContext _localctx = new Argument_declContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_argument_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(285);
			match(IDENTIFIER);
			setState(286);
			match(COLON);
			setState(287);
			type(0);
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

	public static class Statement_listContext extends ParserRuleContext {
		public StatementContext stmts;
		public List<CrContext> cr() {
			return getRuleContexts(CrContext.class);
		}
		public CrContext cr(int i) {
			return getRuleContext(CrContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Statement_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_list; }
	}

	public final Statement_listContext statement_list() throws RecognitionException {
		Statement_listContext _localctx = new Statement_listContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_statement_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << IF) | (1L << LOOP) | (1L << ME) | (1L << NEW) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << IDENTIFIER) | (1L << INTEGER) | (1L << STRINGLITERAL) | (1L << PLUS) | (1L << MINUS) | (1L << LPAREN))) != 0)) {
				{
				{
				setState(289);
				((Statement_listContext)_localctx).stmts = statement();
				setState(290);
				cr();
				}
				}
				setState(296);
				_errHandler.sync(this);
				_la = _input.LA(1);
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

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatementContext extends StatementContext {
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public IfStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class LoopStatementContext extends StatementContext {
		public Loop_stmtContext loop_stmt() {
			return getRuleContext(Loop_stmtContext.class,0);
		}
		public LoopStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class CallStatementContext extends StatementContext {
		public Call_stmtContext call_stmt() {
			return getRuleContext(Call_stmtContext.class,0);
		}
		public CallStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}
	public static class AssignStatementContext extends StatementContext {
		public Assign_stmtContext assign_stmt() {
			return getRuleContext(Assign_stmtContext.class,0);
		}
		public AssignStatementContext(StatementContext ctx) { copyFrom(ctx); }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_statement);
		try {
			setState(301);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				_localctx = new AssignStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				assign_stmt();
				}
				break;
			case 2:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				if_stmt();
				}
				break;
			case 3:
				_localctx = new LoopStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				loop_stmt();
				}
				break;
			case 4:
				_localctx = new CallStatementContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				call_stmt();
				}
				break;
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

	public static class Assign_stmtContext extends ParserRuleContext {
		public ExpressionContext exprs;
		public TerminalNode IDENTIFIER() { return getToken(FloydParser.IDENTIFIER, 0); }
		public TerminalNode ASSIGNMENTOP() { return getToken(FloydParser.ASSIGNMENTOP, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> LBRACKET() { return getTokens(FloydParser.LBRACKET); }
		public TerminalNode LBRACKET(int i) {
			return getToken(FloydParser.LBRACKET, i);
		}
		public List<TerminalNode> RBRACKET() { return getTokens(FloydParser.RBRACKET); }
		public TerminalNode RBRACKET(int i) {
			return getToken(FloydParser.RBRACKET, i);
		}
		public Assign_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_stmt; }
	}

	public final Assign_stmtContext assign_stmt() throws RecognitionException {
		Assign_stmtContext _localctx = new Assign_stmtContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assign_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(IDENTIFIER);
			setState(310);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACKET) {
				{
				{
				setState(304);
				match(LBRACKET);
				setState(305);
				((Assign_stmtContext)_localctx).exprs = expression(0);
				setState(306);
				match(RBRACKET);
				}
				}
				setState(312);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(313);
			match(ASSIGNMENTOP);
			setState(314);
			((Assign_stmtContext)_localctx).exprs = expression(0);
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

	public static class If_stmtContext extends ParserRuleContext {
		public Statement_listContext if_stmtlist;
		public Statement_listContext else_stmtlist;
		public List<TerminalNode> IF() { return getTokens(FloydParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(FloydParser.IF, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode THEN() { return getToken(FloydParser.THEN, 0); }
		public List<CrContext> cr() {
			return getRuleContexts(CrContext.class);
		}
		public CrContext cr(int i) {
			return getRuleContext(CrContext.class,i);
		}
		public TerminalNode END() { return getToken(FloydParser.END, 0); }
		public List<Statement_listContext> statement_list() {
			return getRuleContexts(Statement_listContext.class);
		}
		public Statement_listContext statement_list(int i) {
			return getRuleContext(Statement_listContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(FloydParser.ELSE, 0); }
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			match(IF);
			setState(317);
			expression(0);
			setState(318);
			match(THEN);
			setState(319);
			cr();
			setState(320);
			((If_stmtContext)_localctx).if_stmtlist = statement_list();
			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(321);
				match(ELSE);
				setState(322);
				cr();
				setState(323);
				((If_stmtContext)_localctx).else_stmtlist = statement_list();
				}
			}

			setState(327);
			match(END);
			setState(328);
			match(IF);
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

	public static class Loop_stmtContext extends ParserRuleContext {
		public List<TerminalNode> LOOP() { return getTokens(FloydParser.LOOP); }
		public TerminalNode LOOP(int i) {
			return getToken(FloydParser.LOOP, i);
		}
		public TerminalNode WHILE() { return getToken(FloydParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CrContext cr() {
			return getRuleContext(CrContext.class,0);
		}
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public TerminalNode END() { return getToken(FloydParser.END, 0); }
		public Loop_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loop_stmt; }
	}

	public final Loop_stmtContext loop_stmt() throws RecognitionException {
		Loop_stmtContext _localctx = new Loop_stmtContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_loop_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			match(LOOP);
			setState(331);
			match(WHILE);
			setState(332);
			expression(0);
			setState(333);
			cr();
			setState(334);
			statement_list();
			setState(335);
			match(END);
			setState(336);
			match(LOOP);
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

	public static class Call_stmtContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FloydParser.IDENTIFIER, 0); }
		public TerminalNode LPAREN() { return getToken(FloydParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(FloydParser.RPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PERIOD() { return getToken(FloydParser.PERIOD, 0); }
		public Expression_listContext expression_list() {
			return getRuleContext(Expression_listContext.class,0);
		}
		public Call_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_stmt; }
	}

	public final Call_stmtContext call_stmt() throws RecognitionException {
		Call_stmtContext _localctx = new Call_stmtContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_call_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				setState(338);
				expression(0);
				setState(339);
				match(PERIOD);
				}
				break;
			}
			setState(343);
			match(IDENTIFIER);
			setState(344);
			match(LPAREN);
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ME) | (1L << NEW) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << IDENTIFIER) | (1L << INTEGER) | (1L << STRINGLITERAL) | (1L << PLUS) | (1L << MINUS) | (1L << LPAREN))) != 0)) {
				{
				setState(345);
				expression_list();
				}
			}

			setState(348);
			match(RPAREN);
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

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(FloydParser.INT, 0); }
		public TerminalNode STRING() { return getToken(FloydParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(FloydParser.BOOLEAN, 0); }
		public TerminalNode IDENTIFIER() { return getToken(FloydParser.IDENTIFIER, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode LBRACKET() { return getToken(FloydParser.LBRACKET, 0); }
		public TerminalNode RBRACKET() { return getToken(FloydParser.RBRACKET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		return type(0);
	}

	private TypeContext type(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeContext _localctx = new TypeContext(_ctx, _parentState);
		TypeContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_type, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(355);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				{
				setState(351);
				match(INT);
				}
				break;
			case STRING:
				{
				setState(352);
				match(STRING);
				}
				break;
			case BOOLEAN:
				{
				setState(353);
				match(BOOLEAN);
				}
				break;
			case IDENTIFIER:
				{
				setState(354);
				match(IDENTIFIER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(365);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_type);
					setState(357);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(358);
					match(LBRACKET);
					setState(360);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << ME) | (1L << NEW) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NOT) | (1L << IDENTIFIER) | (1L << INTEGER) | (1L << STRINGLITERAL) | (1L << PLUS) | (1L << MINUS) | (1L << LPAREN))) != 0)) {
						{
						setState(359);
						expression(0);
						}
					}

					setState(362);
					match(RBRACKET);
					}
					} 
				}
				setState(367);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Var_declContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(FloydParser.IDENTIFIER, 0); }
		public CrContext cr() {
			return getRuleContext(CrContext.class,0);
		}
		public TerminalNode COLON() { return getToken(FloydParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ASSIGNMENTOP() { return getToken(FloydParser.ASSIGNMENTOP, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(368);
			match(IDENTIFIER);
			setState(371);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(369);
				match(COLON);
				setState(370);
				type(0);
				}
			}

			setState(375);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGNMENTOP) {
				{
				setState(373);
				match(ASSIGNMENTOP);
				setState(374);
				expression(0);
				}
			}

			setState(377);
			cr();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 6:
			return andexpr_sempred((AndexprContext)_localctx, predIndex);
		case 7:
			return equalexpr_sempred((EqualexprContext)_localctx, predIndex);
		case 8:
			return gtexpr_sempred((GtexprContext)_localctx, predIndex);
		case 9:
			return gteexpr_sempred((GteexprContext)_localctx, predIndex);
		case 10:
			return concatexpr_sempred((ConcatexprContext)_localctx, predIndex);
		case 11:
			return plusminexpr_sempred((PlusminexprContext)_localctx, predIndex);
		case 12:
			return muldivexpr_sempred((MuldivexprContext)_localctx, predIndex);
		case 26:
			return type_sempred((TypeContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean andexpr_sempred(AndexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}
	private boolean equalexpr_sempred(EqualexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean gtexpr_sempred(GtexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean gteexpr_sempred(GteexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean concatexpr_sempred(ConcatexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean plusminexpr_sempred(PlusminexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean muldivexpr_sempred(MuldivexprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean type_sempred(TypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\61\u017e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\6\3>\n\3\r\3\16\3"+
		"?\3\4\5\4C\n\4\3\4\3\4\3\4\3\4\7\4I\n\4\f\4\16\4L\13\4\3\4\5\4O\n\4\3"+
		"\5\3\5\3\5\3\5\3\5\5\5V\n\5\3\5\3\5\3\5\7\5[\n\5\f\5\16\5^\13\5\3\5\7"+
		"\5a\n\5\f\5\16\5d\13\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\6\7"+
		"q\n\7\r\7\16\7r\3\7\5\7v\n\7\3\7\3\7\3\7\7\7{\n\7\f\7\16\7~\13\7\3\b\3"+
		"\b\3\b\3\b\5\b\u0084\n\b\3\b\3\b\3\b\7\b\u0089\n\b\f\b\16\b\u008c\13\b"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\7\t\u0094\n\t\f\t\16\t\u0097\13\t\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\7\n\u009f\n\n\f\n\16\n\u00a2\13\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\7\13\u00aa\n\13\f\13\16\13\u00ad\13\13\3\f\3\f\3\f\3\f\3\f\3\f\7"+
		"\f\u00b5\n\f\f\f\16\f\u00b8\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00c0\n\r"+
		"\f\r\16\r\u00c3\13\r\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00cb\n\16\f\16"+
		"\16\16\u00ce\13\16\3\17\3\17\3\17\3\17\5\17\u00d4\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\5\20\u00db\n\20\3\20\3\20\3\20\5\20\u00e0\n\20\3\20\3\20\5"+
		"\20\u00e4\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\5\21\u00f1\n\21\3\22\3\22\3\22\7\22\u00f6\n\22\f\22\16\22\u00f9\13\22"+
		"\3\22\3\22\3\23\3\23\3\23\5\23\u0100\n\23\3\23\3\23\3\23\5\23\u0105\n"+
		"\23\3\23\3\23\3\23\7\23\u010a\n\23\f\23\16\23\u010d\13\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\7\24\u0119\n\24\f\24\16\24\u011c"+
		"\13\24\3\24\3\24\3\25\3\25\3\25\3\25\3\26\3\26\3\26\7\26\u0127\n\26\f"+
		"\26\16\26\u012a\13\26\3\27\3\27\3\27\3\27\5\27\u0130\n\27\3\30\3\30\3"+
		"\30\3\30\3\30\7\30\u0137\n\30\f\30\16\30\u013a\13\30\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u0148\n\31\3\31\3\31"+
		"\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\5\33\u0158"+
		"\n\33\3\33\3\33\3\33\5\33\u015d\n\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u0166\n\34\3\34\3\34\3\34\5\34\u016b\n\34\3\34\7\34\u016e\n\34\f"+
		"\34\16\34\u0171\13\34\3\35\3\35\3\35\5\35\u0176\n\35\3\35\3\35\5\35\u017a"+
		"\n\35\3\35\3\35\3\35\2\13\f\16\20\22\24\26\30\32\66\36\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\5\4\2\31\31!\"\3\2!\""+
		"\3\2#$\2\u0194\2:\3\2\2\2\4=\3\2\2\2\6B\3\2\2\2\bP\3\2\2\2\nh\3\2\2\2"+
		"\fu\3\2\2\2\16\u0083\3\2\2\2\20\u008d\3\2\2\2\22\u0098\3\2\2\2\24\u00a3"+
		"\3\2\2\2\26\u00ae\3\2\2\2\30\u00b9\3\2\2\2\32\u00c4\3\2\2\2\34\u00d3\3"+
		"\2\2\2\36\u00e3\3\2\2\2 \u00f0\3\2\2\2\"\u00f7\3\2\2\2$\u00fc\3\2\2\2"+
		"&\u011a\3\2\2\2(\u011f\3\2\2\2*\u0128\3\2\2\2,\u012f\3\2\2\2.\u0131\3"+
		"\2\2\2\60\u013e\3\2\2\2\62\u014c\3\2\2\2\64\u0157\3\2\2\2\66\u0165\3\2"+
		"\2\28\u0172\3\2\2\2:;\5\6\4\2;\3\3\2\2\2<>\7\37\2\2=<\3\2\2\2>?\3\2\2"+
		"\2?=\3\2\2\2?@\3\2\2\2@\5\3\2\2\2AC\5\4\3\2BA\3\2\2\2BC\3\2\2\2CD\3\2"+
		"\2\2DJ\5\b\5\2EF\5\4\3\2FG\5\b\5\2GI\3\2\2\2HE\3\2\2\2IL\3\2\2\2JH\3\2"+
		"\2\2JK\3\2\2\2KN\3\2\2\2LJ\3\2\2\2MO\5\4\3\2NM\3\2\2\2NO\3\2\2\2O\7\3"+
		"\2\2\2PQ\7\6\2\2QU\7\32\2\2RS\7\13\2\2ST\7\t\2\2TV\7\32\2\2UR\3\2\2\2"+
		"UV\3\2\2\2VW\3\2\2\2WX\7\r\2\2X\\\5\4\3\2Y[\58\35\2ZY\3\2\2\2[^\3\2\2"+
		"\2\\Z\3\2\2\2\\]\3\2\2\2]b\3\2\2\2^\\\3\2\2\2_a\5$\23\2`_\3\2\2\2ad\3"+
		"\2\2\2b`\3\2\2\2bc\3\2\2\2ce\3\2\2\2db\3\2\2\2ef\7\b\2\2fg\7\32\2\2g\t"+
		"\3\2\2\2hi\t\2\2\2i\13\3\2\2\2jk\b\7\1\2kp\7\32\2\2lm\7+\2\2mn\5\f\7\2"+
		"no\7,\2\2oq\3\2\2\2pl\3\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2sv\3\2\2\2"+
		"tv\5\16\b\2uj\3\2\2\2ut\3\2\2\2v|\3\2\2\2wx\f\4\2\2xy\7\30\2\2y{\5\16"+
		"\b\2zw\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2}\r\3\2\2\2~|\3\2\2\2\177"+
		"\u0080\b\b\1\2\u0080\u0084\5\20\t\2\u0081\u0084\5\22\n\2\u0082\u0084\5"+
		"\24\13\2\u0083\177\3\2\2\2\u0083\u0081\3\2\2\2\u0083\u0082\3\2\2\2\u0084"+
		"\u008a\3\2\2\2\u0085\u0086\f\6\2\2\u0086\u0087\7\27\2\2\u0087\u0089\5"+
		"\20\t\2\u0088\u0085\3\2\2\2\u0089\u008c\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\17\3\2\2\2\u008c\u008a\3\2\2\2\u008d\u008e\b\t\1"+
		"\2\u008e\u008f\5\26\f\2\u008f\u0095\3\2\2\2\u0090\u0091\f\4\2\2\u0091"+
		"\u0092\7\'\2\2\u0092\u0094\5\26\f\2\u0093\u0090\3\2\2\2\u0094\u0097\3"+
		"\2\2\2\u0095\u0093\3\2\2\2\u0095\u0096\3\2\2\2\u0096\21\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0098\u0099\b\n\1\2\u0099\u009a\5\26\f\2\u009a\u00a0\3"+
		"\2\2\2\u009b\u009c\f\4\2\2\u009c\u009d\7%\2\2\u009d\u009f\5\26\f\2\u009e"+
		"\u009b\3\2\2\2\u009f\u00a2\3\2\2\2\u00a0\u009e\3\2\2\2\u00a0\u00a1\3\2"+
		"\2\2\u00a1\23\3\2\2\2\u00a2\u00a0\3\2\2\2\u00a3\u00a4\b\13\1\2\u00a4\u00a5"+
		"\5\26\f\2\u00a5\u00ab\3\2\2\2\u00a6\u00a7\f\4\2\2\u00a7\u00a8\7&\2\2\u00a8"+
		"\u00aa\5\26\f\2\u00a9\u00a6\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab\u00a9\3"+
		"\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\25\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ae"+
		"\u00af\b\f\1\2\u00af\u00b0\5\30\r\2\u00b0\u00b6\3\2\2\2\u00b1\u00b2\f"+
		"\4\2\2\u00b2\u00b3\7 \2\2\u00b3\u00b5\5\30\r\2\u00b4\u00b1\3\2\2\2\u00b5"+
		"\u00b8\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b6\u00b7\3\2\2\2\u00b7\27\3\2\2"+
		"\2\u00b8\u00b6\3\2\2\2\u00b9\u00ba\b\r\1\2\u00ba\u00bb\5\32\16\2\u00bb"+
		"\u00c1\3\2\2\2\u00bc\u00bd\f\4\2\2\u00bd\u00be\t\3\2\2\u00be\u00c0\5\32"+
		"\16\2\u00bf\u00bc\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c1"+
		"\u00c2\3\2\2\2\u00c2\31\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4\u00c5\b\16\1"+
		"\2\u00c5\u00c6\5\34\17\2\u00c6\u00cc\3\2\2\2\u00c7\u00c8\f\4\2\2\u00c8"+
		"\u00c9\t\4\2\2\u00c9\u00cb\5\34\17\2\u00ca\u00c7\3\2\2\2\u00cb\u00ce\3"+
		"\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2\2\2\u00cd\33\3\2\2\2\u00ce"+
		"\u00cc\3\2\2\2\u00cf\u00d0\5\n\6\2\u00d0\u00d1\5\34\17\2\u00d1\u00d4\3"+
		"\2\2\2\u00d2\u00d4\5\36\20\2\u00d3\u00cf\3\2\2\2\u00d3\u00d2\3\2\2\2\u00d4"+
		"\35\3\2\2\2\u00d5\u00d6\7\20\2\2\u00d6\u00e4\5\66\34\2\u00d7\u00d8\5 "+
		"\21\2\u00d8\u00d9\7\60\2\2\u00d9\u00db\3\2\2\2\u00da\u00d7\3\2\2\2\u00da"+
		"\u00db\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00dd\7\32\2\2\u00dd\u00df\7"+
		")\2\2\u00de\u00e0\5\"\22\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e1\3\2\2\2\u00e1\u00e4\7*\2\2\u00e2\u00e4\5 \21\2\u00e3\u00d5\3\2"+
		"\2\2\u00e3\u00da\3\2\2\2\u00e3\u00e2\3\2\2\2\u00e4\37\3\2\2\2\u00e5\u00e6"+
		"\7)\2\2\u00e6\u00e7\5\f\7\2\u00e7\u00e8\7*\2\2\u00e8\u00f1\3\2\2\2\u00e9"+
		"\u00f1\7\32\2\2\u00ea\u00f1\7\34\2\2\u00eb\u00f1\7\33\2\2\u00ec\u00f1"+
		"\7\24\2\2\u00ed\u00f1\7\25\2\2\u00ee\u00f1\7\21\2\2\u00ef\u00f1\7\17\2"+
		"\2\u00f0\u00e5\3\2\2\2\u00f0\u00e9\3\2\2\2\u00f0\u00ea\3\2\2\2\u00f0\u00eb"+
		"\3\2\2\2\u00f0\u00ec\3\2\2\2\u00f0\u00ed\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0"+
		"\u00ef\3\2\2\2\u00f1!\3\2\2\2\u00f2\u00f3\5\f\7\2\u00f3\u00f4\7-\2\2\u00f4"+
		"\u00f6\3\2\2\2\u00f5\u00f2\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5\3\2"+
		"\2\2\u00f7\u00f8\3\2\2\2\u00f8\u00fa\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa"+
		"\u00fb\5\f\7\2\u00fb#\3\2\2\2\u00fc\u00fd\7\32\2\2\u00fd\u00ff\7)\2\2"+
		"\u00fe\u0100\5&\24\2\u00ff\u00fe\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u0104\7*\2\2\u0102\u0103\7/\2\2\u0103\u0105\5\66\34\2\u0104"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\7\r"+
		"\2\2\u0107\u010b\5\4\3\2\u0108\u010a\58\35\2\u0109\u0108\3\2\2\2\u010a"+
		"\u010d\3\2\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c\u010e\3\2"+
		"\2\2\u010d\u010b\3\2\2\2\u010e\u010f\7\5\2\2\u010f\u0110\5\4\3\2\u0110"+
		"\u0111\5*\26\2\u0111\u0112\7\b\2\2\u0112\u0113\7\32\2\2\u0113\u0114\5"+
		"\4\3\2\u0114%\3\2\2\2\u0115\u0116\5(\25\2\u0116\u0117\7.\2\2\u0117\u0119"+
		"\3\2\2\2\u0118\u0115\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\5("+
		"\25\2\u011e\'\3\2\2\2\u011f\u0120\7\32\2\2\u0120\u0121\7/\2\2\u0121\u0122"+
		"\5\66\34\2\u0122)\3\2\2\2\u0123\u0124\5,\27\2\u0124\u0125\5\4\3\2\u0125"+
		"\u0127\3\2\2\2\u0126\u0123\3\2\2\2\u0127\u012a\3\2\2\2\u0128\u0126\3\2"+
		"\2\2\u0128\u0129\3\2\2\2\u0129+\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u0130"+
		"\5.\30\2\u012c\u0130\5\60\31\2\u012d\u0130\5\62\32\2\u012e\u0130\5\64"+
		"\33\2\u012f\u012b\3\2\2\2\u012f\u012c\3\2\2\2\u012f\u012d\3\2\2\2\u012f"+
		"\u012e\3\2\2\2\u0130-\3\2\2\2\u0131\u0138\7\32\2\2\u0132\u0133\7+\2\2"+
		"\u0133\u0134\5\f\7\2\u0134\u0135\7,\2\2\u0135\u0137\3\2\2\2\u0136\u0132"+
		"\3\2\2\2\u0137\u013a\3\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139"+
		"\u013b\3\2\2\2\u013a\u0138\3\2\2\2\u013b\u013c\7(\2\2\u013c\u013d\5\f"+
		"\7\2\u013d/\3\2\2\2\u013e\u013f\7\n\2\2\u013f\u0140\5\f\7\2\u0140\u0141"+
		"\7\23\2\2\u0141\u0142\5\4\3\2\u0142\u0147\5*\26\2\u0143\u0144\7\7\2\2"+
		"\u0144\u0145\5\4\3\2\u0145\u0146\5*\26\2\u0146\u0148\3\2\2\2\u0147\u0143"+
		"\3\2\2\2\u0147\u0148\3\2\2\2\u0148\u0149\3\2\2\2\u0149\u014a\7\b\2\2\u014a"+
		"\u014b\7\n\2\2\u014b\61\3\2\2\2\u014c\u014d\7\16\2\2\u014d\u014e\7\26"+
		"\2\2\u014e\u014f\5\f\7\2\u014f\u0150\5\4\3\2\u0150\u0151\5*\26\2\u0151"+
		"\u0152\7\b\2\2\u0152\u0153\7\16\2\2\u0153\63\3\2\2\2\u0154\u0155\5\f\7"+
		"\2\u0155\u0156\7\60\2\2\u0156\u0158\3\2\2\2\u0157\u0154\3\2\2\2\u0157"+
		"\u0158\3\2\2\2\u0158\u0159\3\2\2\2\u0159\u015a\7\32\2\2\u015a\u015c\7"+
		")\2\2\u015b\u015d\5\"\22\2\u015c\u015b\3\2\2\2\u015c\u015d\3\2\2\2\u015d"+
		"\u015e\3\2\2\2\u015e\u015f\7*\2\2\u015f\65\3\2\2\2\u0160\u0161\b\34\1"+
		"\2\u0161\u0166\7\f\2\2\u0162\u0166\7\22\2\2\u0163\u0166\7\4\2\2\u0164"+
		"\u0166\7\32\2\2\u0165\u0160\3\2\2\2\u0165\u0162\3\2\2\2\u0165\u0163\3"+
		"\2\2\2\u0165\u0164\3\2\2\2\u0166\u016f\3\2\2\2\u0167\u0168\f\3\2\2\u0168"+
		"\u016a\7+\2\2\u0169\u016b\5\f\7\2\u016a\u0169\3\2\2\2\u016a\u016b\3\2"+
		"\2\2\u016b\u016c\3\2\2\2\u016c\u016e\7,\2\2\u016d\u0167\3\2\2\2\u016e"+
		"\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170\3\2\2\2\u0170\67\3\2\2"+
		"\2\u0171\u016f\3\2\2\2\u0172\u0175\7\32\2\2\u0173\u0174\7/\2\2\u0174\u0176"+
		"\5\66\34\2\u0175\u0173\3\2\2\2\u0175\u0176\3\2\2\2\u0176\u0179\3\2\2\2"+
		"\u0177\u0178\7(\2\2\u0178\u017a\5\f\7\2\u0179\u0177\3\2\2\2\u0179\u017a"+
		"\3\2\2\2\u017a\u017b\3\2\2\2\u017b\u017c\5\4\3\2\u017c9\3\2\2\2)?BJNU"+
		"\\bru|\u0083\u008a\u0095\u00a0\u00ab\u00b6\u00c1\u00cc\u00d3\u00da\u00df"+
		"\u00e3\u00f0\u00f7\u00ff\u0104\u010b\u011a\u0128\u012f\u0138\u0147\u0157"+
		"\u015c\u0165\u016a\u016f\u0175\u0179";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}