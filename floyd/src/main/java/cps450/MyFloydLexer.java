/*
Abraham Steenhoek
CPS 450: Phase 5
4/19/20

MyFloydLexer.java

Class: MyFloydLexer
    - overridden FloydLexer to allow for custom output when creating token stream
    - output for each token gives the filename, line number, and the text representation of the token
*/

package cps450;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;

public class MyFloydLexer extends FloydLexer {
	
	Options opts;

	public MyFloydLexer(CharStream input, Options options) {
		super(input);
		this.opts = options;
	}

	@Override
	public Token nextToken() {
		Token tok = super.nextToken();
		if (opts.ds()) {
			PrintToken printtok = new PrintToken(tok);
			System.out.println(opts.curfilename() + ":" + printtok);
		}
		else {
			if (tok.getType() == FloydLexer.UNRECOGNIZEDCHAR) {
			PrintToken printtok = new PrintToken(tok);
			System.out.println(opts.curfilename() + ":" + printtok);
			}
		}
		return tok;
	}

}
