package cps450;

import java.util.ArrayList;
import java.io.IOException;
import java.util.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

/*
    Class: PrintToken
        - makes a Token printable for Floyd lexer output
        - formats a token from the Floyd grammar into a printable string
    toString: returns String
        - represents the String form of the enum parameter with respect to the FloydLexer vocabulary
*/
class PrintToken
{
    String text;
    String desc;
    int num;
    Token token;
    boolean legal;

    public PrintToken(Token tok) {

        token = tok;
        text = tok.getText();
        desc = "";
        num = token.getType();
        legal = true;

        // assign description and text values
        if (num >= FloydLexer.BOOLEAN && num <= FloydLexer.WHILE) {
            desc = "keyword";
        }
        else if (num == FloydLexer.NEWLINE) {
            desc = "";
            text = "cr";
        }
        else if (num == FloydLexer.IDENTIFIER) {
            desc = "identifier";
        }
        else if (num == FloydLexer.INTEGER) {
            desc = "int lit";
        }
        else if (num == FloydLexer.STRINGLITERAL) {
            desc = "string lit";
        }
        else if (num == FloydLexer.ILLEGALSTRING) {
            desc = "Illegal string";
        }
        else if (num == FloydLexer.UNTERMINATEDSTRING) {
            desc = "Unterminated String";
        }
        else if (num >= FloydLexer.CONCAT && num <= FloydLexer.EQUALS) {
            desc = "operator";
            text = String.format("'%s'", text);
        }
        else if (num >= FloydLexer.ASSIGNMENTOP && num <= FloydLexer.PERIOD) {
            desc = "";
            text = String.format("'%s'", text);
        }
        else if (num == FloydLexer.UNRECOGNIZEDCHAR) {
            desc = "Unrecognized char";
            text = String.format(" %s", text);
        }

        // handle lexical errors
        switch(num) {
            case FloydLexer.ILLEGALSTRING:
            case FloydLexer.UNTERMINATEDSTRING:
            case FloydLexer.UNRECOGNIZEDCHAR:
                legal = false;
                break;
            default:
                break;
        }

    }

    public boolean isLegal() { return legal; }

    public String toString() {
        // String.format(line,charpos:type|text)
        String colon = "";
        if(!desc.equals(""))
            colon = ":";
        return String.format("%d,%d:%s%s%s", token.getLine(), (token.getCharPositionInLine() + 1), this.desc, colon, this.text);
    }
}