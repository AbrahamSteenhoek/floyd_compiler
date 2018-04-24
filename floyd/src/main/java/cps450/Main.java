/*
Abraham Steenhoek
CPS 450: Phase 5
4/19/20

Main.java

Class: Main
    - Creates an Options class and FileCollection class to handle command line arguments and multiple files
    - Creates a scanner to form a sentence to be parsed
    - Creates a parser to form a parse tree from the sentence produced by the scanner and check for syntax errors
    - Creates a semantic checker to decorate the parse tree with declarations and symbols and check for semantic errors
    - Creates a FloydBaseListener to generate assembly code from the decorated parse tree
*/
package cps450;
import java.io.*;
import java.util.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.sound.midi.SysexMessage;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class Main
{
    public static void main(String[] arguments) throws IOException {

        Options opts = new Options(arguments);
        Options.FileCollection fileCollection = opts.new FileCollection();

        File stdlibFile = new File("stdlib.floyd");
        BufferedReader r = new BufferedReader(new FileReader(stdlibFile));
        int l = 0;
        while (r.readLine() != null) l++;
        r.close();

        // stdlib is the first file to be scanned in this compiler
        fileCollection.addFile(l, "stdlib.floyd");

        // TODO: implement multiple files
        InputStream fileStream = new FileInputStream(stdlibFile);
        for(String fileName : opts.fileNames()) {
            File file = new File(fileName);

            // count number of lines in the file
            BufferedReader reader = new BufferedReader(new FileReader(file));
            int lines = 0;
            while (reader.readLine() != null) lines++;
            reader.close();

            fileCollection.addFile(lines, fileName);
            FileInputStream fileStream2 = new FileInputStream(file);
            fileStream = new SequenceInputStream(fileStream, fileStream2);
        }

        // currently set to take 1 input file
        // TODO: make it possible to accept multiple input files
        String file = opts.curfilename();

        CharStream input = CharStreams.fromStream(fileStream);
        // for ( String curfile : opts.fileNames() ) {

        MyFloydLexer lexer = new MyFloydLexer(input, opts);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FloydParser parser = new FloydParser(tokens);


        // parser.setErrorHandler(new FloydErrorHandler());
        // Suppress default error messages
        parser.removeErrorListener(ConsoleErrorListener.INSTANCE);
        // Register my own error handler
        parser.addErrorListener(new MyFloydErrorListener(opts, fileCollection));

        ParseTree tree = parser.program();

        if (opts.dp()) {
            // Display graphical tree
            Trees.inspect(tree, parser);
        }

        if (parser.getNumberOfSyntaxErrors() > 0)
            System.out.println(parser.getNumberOfSyntaxErrors() + " syntax error(s)");

        else {
            SemanticChecker checker = new SemanticChecker(fileCollection);
            checker.visit(tree);
            if (checker.getErrCount() > 0) {
                System.out.println(checker.getErrCount() + " semantic error(s)");
            }
            else {
                // if no semantic errors, then traverse tree again for codegen
                // implement -S option in instance of codeGen by passing in options class
                // start codegen
                CodeGen generator = new CodeGen(opts, fileCollection);
                generator.visit(tree);
                System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
                //*
                if(!opts.S()) {
                    //generator.printCode();
                    try {
                        String filename = opts.curfilename();
                        Process gcc = new ProcessBuilder("gcc","-m32", "-o" + filename.replace(".floyd", ""), filename.replace(".floyd", ".s"), "stdlib.o").start();
                        int errorcode = gcc.waitFor();
                        //System.out.println("Executed gcc with code " + errorcode);

                        BufferedReader reader = new BufferedReader(new InputStreamReader(gcc.getErrorStream()));
                        String line = reader.readLine();
                        if (line != null)
                            System.out.println(line);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //*/
            }
        }
    }
}

