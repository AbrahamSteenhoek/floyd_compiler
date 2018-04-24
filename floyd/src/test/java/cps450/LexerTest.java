package cps450;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import org.junit.Test;

public class LexerTest {
	FloydLexer lex;

	@Test
	public void testSuccessfulScan() throws IOException {
		CharStream input = CharStreams.fromStream(
				getClass().getResourceAsStream("lexertest.txt"));
		lex = new FloydLexer(input);

		// testing keywords
		assertNextToken(FloydLexer.IF, "if");
		assertNextToken(FloydLexer.BOOLEAN, "boolean");
		assertNextToken(FloydLexer.TRUE, "true");
		assertNextToken(FloydLexer.BEGIN, "begin");
		assertNextToken(FloydLexer.LOOP, "loop");
		assertNextToken(FloydLexer.NEWLINE);

		// testing identifiers
		assertNextToken(FloydLexer.IDENTIFIER, "_identifier");
		assertNextToken(FloydLexer.IDENTIFIER, "identifier");
		assertNextToken(FloydLexer.IDENTIFIER, "IdEnTiFiEr6789");
		assertNextToken(FloydLexer.NEWLINE);

		// testing ints mixed with identifiers
		assertNextToken(FloydLexer.INTEGER, "67");
		assertNextToken(FloydLexer.INTEGER, "-230");
		assertNextToken(FloydLexer.IDENTIFIER, "identifier");
		assertNextToken(FloydLexer.NEWLINE);

		// testing strings
		assertNextToken(FloydLexer.STRINGLITERAL,"\"Hi, \\\"Tom\\\", \\nHow are \\333things\\222 today?\"");
		assertNextToken(FloydLexer.ILLEGALSTRING, "\"illegal \\g\"");
		// values ommited here due to trouble replicating the text values in java code
		assertNextToken(FloydLexer.UNTERMINATEDSTRING);
		assertNextToken(FloydLexer.NEWLINE);

		// testing operators and Misc.
        assertNextToken(FloydLexer.MUL);
        assertNextToken(FloydLexer.PLUS);
        assertNextToken(FloydLexer.DIV);
        assertNextToken(FloydLexer.GTE);
        assertNextToken(FloydLexer.GT);
        assertNextToken(FloydLexer.EQUALS);
        assertNextToken(FloydLexer.ASSIGNMENTOP);
        assertNextToken(FloydLexer.LPAREN);
        assertNextToken(FloydLexer.LBRACKET);
        assertNextToken(FloydLexer.PERIOD);
        assertNextToken(FloydLexer.RBRACKET);
        assertNextToken(FloydLexer.RPAREN);
        assertNextToken(FloydLexer.UNRECOGNIZEDCHAR, "%");
        assertNextToken(FloydLexer.UNRECOGNIZEDCHAR, "!");
        assertNextToken(FloydLexer.UNRECOGNIZEDCHAR, "`");

        assertNextToken(FloydLexer.EOF);


	}

	private void assertNextToken(int type, String value) throws IOException {
		Token tok = lex.nextToken();
		System.err.println(tok.getLine() + ":" + tok.getCharPositionInLine() + ":" + tok.getText());
		assertTrue(tok.getType() == type);
		assertTrue(tok.getText().equals(value));

	}

	private void assertNextToken(int type) throws IOException {
		Token tok = lex.nextToken();
		System.err.println(tok.getLine() + ":" + tok.getCharPositionInLine() + ":" + tok.getText());
		assertTrue(tok.getType() == type);
	}
}
