/*
Abraham Steenhoek
CPS 450: Phase 5
4/19/20

MyFloydErrorListener.java

Class: MyFloydErrorListener
    - Overridden class of FloydErrorListener to allow for custom user error messages
*/
package cps450;

import org.antlr.v4.runtime.ConsoleErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class MyFloydErrorListener extends ConsoleErrorListener {

	Options opts;
	Options.FileCollection fileCollection;

	public MyFloydErrorListener(Options options, Options.FileCollection fc) {
		this.opts = options;
		this.fileCollection = fileCollection;
	}

	/*
	Method: syntaxError
		- Reports the filename, line number, and char position in line for a token that causes a syntax error
	 */
	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
							Object offendingSymbol,
							int line,
							int charPositionInLine,
							String msg,
							RecognitionException e)
	{
		if (opts.dp()) {
			Pair<Integer, String> curFile = fileCollection.getFileNameAndLineNum(line);
			System.err.println(curFile.getValue() + ":" + curFile.getKey() + "," + charPositionInLine + ":" + msg);
			if (e != null)
				e.printStackTrace();
		}
	}
}
