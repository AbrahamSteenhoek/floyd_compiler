/*
Abraham Steenhoek
CPS 450: Phase 5
4/19/20

Options.java
    - Handles command-line argument processing separately from Main class
*/

package cps450;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
/*
Class: Options
    - Contains all command line arguments and file names
    - used to determine what arguments the user provides to the compiler
*/
class Options
{
    /*
    Class: FileCollection
        - Object that contains a list of files given on the command line in the order listed on the command line
        - Returns the correct filename and line number for a given line number from the concatenated stream of all files
     */
    class FileCollection {
        ArrayList<Pair<Integer, String >> fileList = new ArrayList<>();

        public Pair<Integer, String> addFile(int lineNum, String fileName) {
            int prevLineNum = 0;
            if (fileList.size() > 0)
                prevLineNum = fileList.get(fileList.size() - 1).getKey();
            Pair<Integer, String> file = new Pair<>(lineNum + prevLineNum, fileName);
            fileList.add(file);

            return file;
        }

        public ArrayList<Pair<Integer, String>> getFileList() {
            return fileList;
        }
        public Pair<Integer, String> getFileNameAndLineNum(int line) {
            int lineNum = 0;
            String fileName = "stdlib.floyd";

            for(int i = 0; i < fileList.size(); i++) {
                Pair<Integer, String> curFile = fileList.get(i);
                if(line <= curFile.getKey()) {
                    if(i > 0) {
                        fileName = curFile.getValue();
                        lineNum = fileList.get(i - 1).getKey();
                    }
                    return new Pair<>(line - lineNum, fileName);
                }
            }
            return null;
        }
    }
    // leave room for other options
    boolean _ds;
    boolean _dp;
    boolean _S;
    boolean _g;

    int curFileIndex;
    int _fileCount;
    SequenceInputStream fileStream;

    ArrayList<String> _args;
    ArrayList<String> _filenames;

    public Options(String[] args) {
        _ds = false;
        _dp = false;
        _S = false;
        _g = false;
        curFileIndex = 0;
        _fileCount = 0;
        _args = new ArrayList<String>();
        _filenames = new ArrayList<String>();

        if(args.length < 1) {
            System.out.println("usage:");
            System.out.println("  lexer [-ds] [-dp] <filename>");
            System.exit(1);
        }

        for(String arg : args) {

            if(arg.equals("-ds"))
            {
                _ds = true;
            }
            else if(arg.equals("-dp"))
            {
                _dp = true;
            }
            else if(arg.equals("-S"))
            {
                _S = true;
            }
            else if (arg.equals("-g")) {
                _g = true;
            }
            else {
                _filenames.add(arg);
                _fileCount++;
            }
            _args.add(arg);

        }

        if(_filenames.size() == 0) {
            System.out.println("error: no filename(s) given");
            System.out.println("usage:");
            System.out.println("  lexer [-ds] [-dp] <filename>");
            System.exit(1);
        }
        else {
            for(String file : fileNames()) {
                try {
                    InputStream stdlib = new FileInputStream(new File("stdlib.floyd"));

                }
                catch(FileNotFoundException e) {
                    System.out.println("error: " + e.getLocalizedMessage());
                    System.exit(1);
                }
            }
        }
    }

    public boolean ds() { return _ds; }
    public boolean dp() { return _dp; }
    public boolean S()  { return _S; }
    public boolean g()  { return _g; }
    public ArrayList<String> args() { return _args; }
    public ArrayList<String> fileNames() { return _filenames; }
    public int fileCount() { return _fileCount; }
    public void advanceFile() { curFileIndex++; _fileCount--; }
    public String curfilename() { return _filenames.get(curFileIndex); }
}