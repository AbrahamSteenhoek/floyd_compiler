/*
Abraham Steenhoek
CPS 450: Phase 5
4/19/20

CodeGen.java
Class: CodeGen
    - Generates 32-bit linux assembly for Floyd files that pass syntax and semantic error checking
    - All methods are declared, but the only called method is the start method in the last class of the file
    - Creates a new assembly(.s) file with the same name as the given Floyd(.floyd) input file
    - Generated assembly is output to STDOUT, but STDOUT is redirected to the created assembly file
*/
package cps450;

import java.io.*;
import java.io.PrintStream;
import java.lang.annotation.Target;
import java.util.*;

public class CodeGen extends FloydBaseVisitor{
    Options opts;
    Options.FileCollection fileCollection;
    ArrayList<TargetInstruction> instructions;
    static int ifCounter;
    static int loopCounter;
    static int strCounter;
    private String curClass;

    // contains all the calculated offsets for local vars/params in the CURRENT method being declared
    HashMap<String, String> localOffsets;
    HashMap<String, String> classInstanceOffsets;



    public ArrayList<TargetInstruction> getInstructions() {
        return instructions;
    }

    /*
    Method: emit
        Receives a variety of parameters and instantiates a TargetInstruction object that represents an assembly.
        Lines of assembly generated include:
            - single-line commands
            - unary and binary operator commands
            - directives
            - labels
            - comments
    */
    public void emit(String id) {
        TargetInstruction instr = new TargetInstruction(id);
        instructions.add(instr);
        System.out.println(instr);
    }
    public void emitComment(String comment) {
        TargetInstruction instr = new TargetInstruction("# " + comment);
        instructions.add(instr);
        System.out.println(instr);
    }
    public void emitLineComment(int lineNum, String comment) {
        Pair<Integer, String> curFile = fileCollection.getFileNameAndLineNum(lineNum);
        emitComment("-------------------------");
        emitComment(String.format("%s:%d: %s", curFile.getValue(), curFile.getKey(), comment.split("\n")[0]));
        emitComment("-------------------------");
    }
    public void emitLabel(String label) {
        TargetInstruction instr = new TargetInstruction(String.format("%s:", label));
        instructions.add(instr);
        System.out.println(instr);
    }

    public void emit(String instruction, String operand) {
        TargetInstruction instr = new TargetInstruction(String.format("\t%-6s", instruction), operand);
        instructions.add(instr);
        System.out.println(instr);
    }
    public void emit(String binaryInstruction, String op1, String op2) {
        TargetInstruction instr = new TargetInstruction(String.format("\t%-6s", binaryInstruction), op1, op2);
        instructions.add(instr);
        System.out.println(instr);
    }
    public void emit(String directive, String varName, int b1, int b2) {
        TargetInstruction instr = new TargetInstruction("\t" + directive, varName, b1, b2);
        instructions.add(instr);
        System.out.println(instr);
    }

    /*
    Method: printcode
        Printcode method prints each generated assembly instruction to STDOUT
     */
    public void printCode() {
        for(TargetInstruction instr : instructions) {
            System.out.println(instr);
        }
    }

    public CodeGen(Options opts, Options.FileCollection fc) {
        //System.out.println("starting codegen...");
        this.opts = opts;
        this.fileCollection = fc;
        String asmFilename = opts.curfilename().replace(".floyd", ".s");
        try {
            PrintStream asmFile = new PrintStream(new File(asmFilename));
            System.setOut(asmFile);
        }
        catch (FileNotFoundException ex) {
            System.out.println("Error: file not found: " + ex.getMessage());
        }

        // remember to change System.out back to stdout later!

        instructions = new ArrayList<>();
        ifCounter = 0;
        loopCounter = 0;
        strCounter = 0;
        localOffsets = new HashMap<>();
        classInstanceOffsets = new HashMap<>();
    }

    /*
    Method: visitFclass_list
        - instantiates out and in, global variables in each Floyd program
        - visits each class in the file sequentially and generates the code for variable and method declarations in that class
        - Calls the start function of the last class declared in the file
     */
    @Override
    public Object visitFclass_list(FloydParser.Fclass_listContext ctx) {
        localOffsets.put("out", "_out");
        localOffsets.put("in", "_in");
        emit(".data");
        emit(".comm", "_out", 4,4);
        emit(".comm", "_in", 4,4);

        emit("pushl", "$8");
        emit("pushl", "$1");
        emit("call", "calloc");
        emit("addl", "$8", "%esp");
        emit("movl", "%eax", "_out");

        emit("pushl", "$8");
        emit("pushl", "$1");
        emit("call", "calloc");
        emit("addl", "$8", "%esp");
        emit("movl", "%eax", "_in");

        emit("\t.text");
        emit(".global main");
        int i = 0;
        for(FloydParser.FclassContext fclass : ctx.fclasses) {
            visit(fclass);
            localOffsets.clear();
            classInstanceOffsets.clear();
            localOffsets.put("out", "_out");
            localOffsets.put("in", "_in");
            i++;
        }
        emitLabel("main");


        ClassDecl lastClass = ctx.fclasses.get(i - 1).classDecl;
        int numVars = lastClass.getVarList().size();
        // reserve 8 bytes for A level
        emit("pushl", String.format("$%d", (8 + numVars * 4)));
        emit("pushl", "$1");
        emit("call", "calloc");
        emit("addl", "$8", "%esp");
        // push address to allocated memory in the heap
        emit("pushl", "%eax");

        // push new instance of last class
        emit("call", String.format("%s_start", curClass));
        emit("addl", "$4", "%esp");
        //String prefix = curClass + "_";
        return null;
    }

    @Override
    public Object visitFclass(FloydParser.FclassContext ctx) {
        // kdbg info
        // optional: emit STABS debugging info for global vars.
        if(opts.g()) {
            //String[] filepath = opts.curfilename().split("[\\/]");
            File file = new File(opts.curfilename());
            String filename = file.getName();

            emit(String.format("\t.file \"%s\"", filename));
            emit(String.format("\t.stabs  \"%s\",100,0,2,.Ltext0", filename));
            emit(".Ltext0:");
            emit("\t.stabs  \"int:t(0,1)=r(0,1);-2147483648;2147483647;\",128,0,0,0");
        }

        // the label for each method declared in curClass is prefixed with "curClass_"
        curClass = ctx.classid.getText();

        // visit class instance vars
        if(ctx.var_decl_list() != null) {
            visit(ctx.var_decl_list());
        }

        // visit class's declared methods
        ArrayList<String> methList = new ArrayList<>();
        if(ctx.method_decls != null) {
            for (FloydParser.Method_declContext methDecl : ctx.method_decls) {
                String methName = methDecl.methid.getText();
                methList.add(methName);

                //emit(String.format(".global %s", methName));
                visit(methDecl);
            }
        }
        return null;
    }


    /*
    Method: visitMethodDecl
        - generates the assembly for each parameter and the return value
        - visits list of parameters from RIGHT to LEFT, which is done manually to maintain correct stack order.
        - Each method has an identical Preamble and Postlude that handles passing ebp to esp and return calls
     */
    @Override
    public Object visitMethod_decl(FloydParser.Method_declContext ctx) {
        String methName = ctx.methid.getText();
        String methodPrefix = curClass + "_";

        //System.out.println(methName);
        emitLineComment(ctx.methid.getLine(), ctx.getText());
        // debugging mode (kdbg)
        if(opts.g()) {
            emit(String.format("\t.stabs \"%s:F\",36,0,0,%s", methName, methName));
            emit(String.format("\t.type   %s, @function", methName));
        }
        // each method has a method label made unique with its respective classname prefix
        emitLabel(String.format("%s%s", methodPrefix, methName));

        // Preamble
        emit("# Method Preamble");
        emit("pushl", "%ebp");
        emit("movl", "%esp", "%ebp");

        // assign ebp offsets to param references
        if(ctx.argument_decl_list() != null) {
            ArrayList<Symbol> paramList = ctx.methodDecl.getParamList();
            // save +4 for ret addr and +8 for class ptr(implement later)
            int offset = 8 + paramList.size() * 4;
            for(int i = paramList.size() - 1; i >= 0; i--) {
                Symbol param = paramList.get(i);
                String ebpOffset = String.format("%d(%%ebp)", offset);
                // add these into a hashmap to reference later when these params are used in the method
                localOffsets.put(param.getName(), ebpOffset);
                offset -= 4;
            }
            // TODO: figure out what to do for class ptr = 8(%ebp)
        }

        localOffsets.put(methName, "-4(%ebp)");

        String defaultRetVal = "$0";

        // -4(%ebp) is reserved for return value
        emit("# reserve space for return value");
        emit("pushl", defaultRetVal);

        int localVarReserve = 0;
        emit("# reserve space for local vars");
        if(ctx.var_decl_list() != null) {
            visit(ctx.var_decl_list());
            localVarReserve = ctx.var_decl_list().vardecls.size() * 4;
        }

        //emit("movl", "8(%ebp)", "%ecx");
        if(ctx.statement_list() != null) {
            visit(ctx.statement_list());
        }


        emit("\n# Method Postlude");
        // leave return value in %eax
        emit("movl", "-4(%ebp)","%eax");
        if(localVarReserve > 0)
            // add 4 to localVarReserve to account for return value
            emit("addl", String.format("$%d", localVarReserve + 4), "%esp");

        // Postlude
        emit("movl", "%ebp", "%esp");
        emit("popl", "%ebp");
        emit("\tret");
        return null;
    }


    @Override
    public Object visitStatement_list(FloydParser.Statement_listContext ctx) {
        for(FloydParser.StatementContext stmt : ctx.stmts) {
            int lineNum = stmt.getStart().getLine();
            emitLineComment(lineNum, stmt.getText());
            if(opts.g()) {
                String uniqueLabel = ".line" + lineNum;
                emit(String.format("\t.stabn 68,0,%d,%s-start", lineNum, uniqueLabel));
                emit(uniqueLabel + ":");
            }
            visit(stmt);
        }
        return null;
    }

    @Override
    public Object visitVar_decl_list(FloydParser.Var_decl_listContext ctx) {
        for(FloydParser.Var_declContext var : ctx.vardecls) {
            visit(var);
        }

        return null;
    }

    /*
    Method: assignVarFromEAX
        - Moves the value of the eax register to the variable represented by varname
        - handles 2 cases: local variables & class instance variables
     */
    public void assignVarFromEAX(String varname) {
        if(localOffsets.get(varname) != null) {
            emitComment("VARNAME:" + varname + " is a local var");
            emit("movl", "%eax", localOffsets.get(varname));
        }
        // if its an instance var in a class
        else {
            emit("movl", "8(%ebp)", "%ebx");
            emit("movl", "%eax", classInstanceOffsets.get(varname));
        }
    }

    /*
    Method: visitVar_decl
        - Generates assembly to declare a new variable
        - Handles two cases of declarations:
            - User defines value in the declaration
            - Variable is assigned default value
     */
    @Override
    public Object visitVar_decl(FloydParser.Var_declContext ctx) {
        emitLineComment(ctx.varid.getLine(), ctx.getText());
        String varname = ctx.varid.getText();
        int offset = ((VarDecl) ctx.varSymbol.getDeclaration()).getOffset();
        int scope = ctx.varSymbol.getScope();
        String offsetStr = "";

        emit("pushl", "$0");

        // if it's a class instance var
        if (scope <= 1) {
            offsetStr = String.format("%d(%%ebx)", offset);
            classInstanceOffsets.put(varname, offsetStr);
        }
        // if its a local var
        else {
            offsetStr = String.format("%d(%%ebp)", offset * -1);
            localOffsets.put(varname, offsetStr);
        }

        // if var declaration has an assignment statement
        if(ctx.ASSIGNMENTOP() != null) {
            visit(ctx.expression());
            emit("popl", "%eax");
            // if its a local var
            assignVarFromEAX(varname);
            //emit("movl", "8(%ebp)", "%ecx");
            //emit("movl", "%eax", offsetStr);
        }

        // TODO: handle var declarations that have assignment statments in them
        return null;
    }

    /*
    Method: visitAssign_stmt
        - evaluates expression on the RHS and assigns the evaluated value to the correct variable on the LHS
     */
    @Override
    public Object visitAssign_stmt(FloydParser.Assign_stmtContext ctx) {
        emitComment("AssignStmt");
        // generate code for expression to be assigned
        visit(ctx.rhexpr);
        // move the value of the RHS expression to the variable
        emit("popl", "%eax");

        // assign RHS to LHS variable
        String varname = ctx.IDENTIFIER().getText();
        assignVarFromEAX(varname);

        return null;
    }

    /*
    Method: visitIf_stmt
        - generates a unique set of labels to handle conditional branching
        - unique labels have a suffix of an integer that is incremented every time an if statement is visited.
     */
    @Override
    public Object visitIf_stmt(FloydParser.If_stmtContext ctx) {
        //emitComment("IfStmt");
        int curIntLabel = ifCounter++;
        String trueIF = String.format("trueif%d", curIntLabel);
        String falseIF = String.format("falseif%d", curIntLabel);
        String endIF = String.format("endif%d", curIntLabel);

        //emitComment(ctx.getText());
        visit(ctx.expression());

        // test the if conditional expression
        emit("popl", "%eax");
        emit("cmpl", "$0", "%eax");
        emit("jne", trueIF);
        emit("jmp", falseIF);
        // true stmts
        emitLabel(trueIF);
        visit(ctx.if_stmtlist);
        emit("jmp", endIF);
        // false stmts (optional)
        emitLabel(falseIF);
        if(ctx.else_stmtlist != null)
            visit(ctx.else_stmtlist);
        emitLabel(endIF);
        return null;
    }

    /*
    Method: visitLoop_stmt
        - generates a unique set of labels to handle conditional branching for loops
        - unique labels have a suffix of an integer that is incremented every time a loop is visited.
     */
    @Override
    public Object visitLoop_stmt(FloydParser.Loop_stmtContext ctx) {
        emitComment("LoopStmt");
        int curLoopLabel = loopCounter++;
        String whileStart = String.format("while%d", curLoopLabel);
        String startWhileBody = String.format("startwhilebody%d", curLoopLabel);
        String endWhile = String.format("endwhile%d", curLoopLabel);

        emitLabel(whileStart);
        // evaluate loop expression
        visit(ctx.expression());
        // test if true/false
        emit("popl", "%eax");
        emit("cmp", "$0", "%eax");
        emit("jne", startWhileBody);
        emit("jmp", endWhile);
        emitLabel(startWhileBody);

        visit(ctx.statement_list());

        emit("jmp", whileStart);
        emitLabel(endWhile);

        return null;
    }


    /*
    Method: visitMethodCallExpr & visitCall_stmt1
        - Precedes every method call with a null pointer check for the object calling the method
        - pushes the parameters onto the stack from RIGHT to LEFT to keep correct stack order
        - pushes the pointer to the object calling the method after parameters
     */
    @Override
    public Object visitMethodCallExpr(FloydParser.MethodCallExprContext ctx) {
        emitComment("MethodCallExpr");
        // TODO: visit preceding methodcall expression before calling method
        visit(ctx.methodcallexpression());
        // ptr to calling object is on the stack

        if(!(ctx.methodcallexpression().getText().equals("out") || ctx.methodcallexpression().getText().equals("in"))) {
            int linenum = fileCollection.getFileNameAndLineNum(ctx.methid.getLine()).getKey();
            emit("pushl", String.format("$%d", linenum));
            emit("call", "nullpointertest");
            emit("addl", "$4", "%esp");
        }
        // store class ptr in %ebx
        emit("popl", "%ecx");

        //Type type = ctx.classSymbol.getType();

        String methodPrefix = Type.getTypeForName(ctx.classSymbol.getType().getText()).getText() + "_";
        if(Type.getTypeForName(ctx.classSymbol.getType().getText()).equals(Type.CLASS)) {
            methodPrefix = ctx.classSymbol.getName() + "_";
        }
        String methodName = ctx.methid.getText();

        // save an extra 4 for class ptr
        int restoreBytes = 4;

        // TODO: push parameters onto the stack
        if(ctx.expression_list() != null) {
            ListIterator<FloydParser.ExpressionContext> iter = ctx.expression_list().exprs.listIterator(ctx.expression_list().exprs.size());
            while(iter.hasPrevious()) {
                visit(iter.previous());
                restoreBytes += 4;
            }
        }

        // push class ptr in %ebx
        emit("pushl", "%ecx");

        emit("call", String.format("%s%s", methodPrefix, methodName));

        // restore space reserved for parameters
        emit("addl", String.format("$%d", restoreBytes), "%esp");

        // return value
        emit("pushl", "%eax");

        return null;
    }

    @Override
    public Object visitCall_stmt1(FloydParser.Call_stmt1Context ctx) {
        emitComment("MethodCallExpr");
        // TODO: visit preceding methodcall expression before calling method
        visit(ctx.methodcallexpression());
        // store class ptr in %ecx
        if(!(ctx.methodcallexpression().getText().equals("out") || ctx.methodcallexpression().getText().equals("in"))) {
            int linenum = fileCollection.getFileNameAndLineNum(ctx.methid.getLine()).getKey();
            emit("pushl", String.format("$%d", linenum));
            emit("call", "nullpointertest");
            emit("addl", "$4", "%esp");
        }
        emit("popl", "%ecx");

        //Type type = ctx.classSymbol.getType();

        // if caller is an object variable
        String methodPrefix = Type.getTypeForName(ctx.classSymbol.getType().getText()).getText() + "_";
        // if object is type class, then use name of object as prefix
        if(Type.getTypeForName(ctx.classSymbol.getType().getText()).equals(Type.CLASS)) {
            methodPrefix = ctx.classSymbol.getName() + "_";
        }
        String methodName = ctx.methid.getText();

        // save an extra 4 for class ptr
        int restoreBytes = 4;

        // TODO: push parameters onto the stack
        if(ctx.expression_list() != null) {
            ListIterator<FloydParser.ExpressionContext> iter = ctx.expression_list().exprs.listIterator(ctx.expression_list().exprs.size());
            while(iter.hasPrevious()) {
                visit(iter.previous());
                restoreBytes += 4;
            }
        }

        // push class ptr
        emit("pushl", "%ecx");

        emit("call", String.format("%s%s", methodPrefix, methodName));

        // restore space reserved for parameters
        emit("addl", String.format("$%d", restoreBytes), "%esp");

        // no return value for call_stmt
        //emit("pushl", "%eax");

        return null;
    }

    @Override
    public Object visitMethodCallExpr2(FloydParser.MethodCallExpr2Context ctx) {
        visit(ctx.methodcall());
        return null;
    }

    @Override
    public Object visitCall_stmt2(FloydParser.Call_stmt2Context ctx) {
        visit(ctx.methodcall());
        emit("popl", "%eax");

        return null;
    }

    /*
    Method: visitMethodcall
        - similar to visitMethodCallExpr and visitCall_stmt1, but is only visited when a method with no explicit caller is called
        - pushes the parameters onto the stack from RIGHT to LEFT to keep correct stack order
        - pushes the pointer to the current class after the parameters
     */
    @Override
    public Object visitMethodcall(FloydParser.MethodcallContext ctx) {
        String prefix = curClass + "_";
        // classptr is me, in 8(%ebp)
        String methodName = ctx.methid.getText();

        // save an extra 4 for class ptr
        int restoreBytes = 4;

        // TODO: push parameters onto the stack
        if(ctx.expression_list() != null) {
            ListIterator<FloydParser.ExpressionContext> iter = ctx.expression_list().exprs.listIterator(ctx.expression_list().exprs.size());
            while(iter.hasPrevious()) {
                visit(iter.previous());
                restoreBytes += 4;
            }
        }

        // push class ptr (me ptr)
        emit("pushl", "8(%ebp)");

        emit("call", String.format("%s%s", prefix, methodName));

        // restore space reserved for parameters
        emit("addl", String.format("$%d", restoreBytes), "%esp");

        // return value
        emit("pushl", "%eax");

        return null;
    }

    /*
    Method: visitExpression_list
        - visits each expression in the list of expressions sequentially
        - generates assembly for all legal expressions, except for array expressions, in the Floyd grammar
            - each expression is evaluated, and the resulting value is pushed onto the stack
     */
    @Override
    public Object visitExpression_list(FloydParser.Expression_listContext ctx) {
        emitComment("Expression_List");
        for(FloydParser.ExpressionContext expr : ctx.exprs) {
            visit(expr);
        }
        return null;
    }

    @Override
    public Object visitOrExpr(FloydParser.OrExprContext ctx) {
        emitComment(String.format("OrExpr -> ( %s )", ctx.getText()));
        visit(ctx.e1);
        visit(ctx.e2);
        emit("popl", "%ebx"); // operand 2
        emit("popl", "%eax"); // operand 1
        emit("or", "%ebx", "%eax");
        emit("pushl", "%eax");
        return null;
    }

    @Override
    public Object visitAndExpr(FloydParser.AndExprContext ctx) {
        emitComment(String.format("AndExpr -> ( %s )", ctx.getText()));
        visit(ctx.e1);
        visit(ctx.e2);
        emit("popl", "%ebx"); // operand 2
        emit("popl", "%eax"); // operand 1
        emit("and", "%ebx", "%eax");
        emit("pushl", "%eax");
        return null;
    }

    @Override
    public Object visitEqualExpr(FloydParser.EqualExprContext ctx) {
        emitComment(String.format("EqualExpr -> ( %s )", ctx.getText()));
        visit(ctx.e1); // pushed operand 1
        visit(ctx.e2); // pushed operand 2
        // 2 params pushed for call to c function
        //emit("popl", "%ebx");  // second operand
        //emit("popl", "%eax");  // first operand
        emit("call", "equals");
        // restore stack pointer (2 params)
        emit("addl", "$8", "%esp");
        emit("pushl", "%eax");
        return null;
    }

    @Override
    public Object visitGTExpr(FloydParser.GTExprContext ctx) {
        //emitComment(String.format("GTExpr -> ( %s )", ctx.getText()));
        visit(ctx.e1); // pushed operand 1
        visit(ctx.e2); // pushed operand 2
        //emit("popl", "%ebx");  // second operand
        //emit("popl", "%eax");  // first operand
        emit("call", "gt");
        // restore stack pointer (2 params)
        emit("addl", "$8", "%esp");
        emit("pushl", "%eax");
        return null;
    }

    @Override
    public Object visitGTEExpr(FloydParser.GTEExprContext ctx) {
        //emitComment(String.format("GTEExpr -> ( %s )", ctx.getText()));
        visit(ctx.e1); // pushed operand 1
        visit(ctx.e2); // pushed operand 2
        //emit("popl", "%ebx");  // second operand
        //emit("popl", "%eax");  // first operand
        emit("call", "gte");
        // restore stack pointer (2 params)
        emit("addl", "$8", "%esp");
        emit("pushl", "%eax");
        return null;
    }
// concat expression not implemented yet because phase 4 does not involve strings...

    @Override
    public Object visitPlusMinExpr(FloydParser.PlusMinExprContext ctx) {
        //emitComment(String.format("PlusMinExpr -> ( %s )", ctx.getText()));
        visit(ctx.e1);
        visit(ctx.e2);
        emit("popl", "%ebx");  // second operand
        emit("popl", "%eax");  // first operand
        switch(ctx.addop().getText()) {
            case "+":
                emit("addl", "%ebx", "%eax");
                emit("pushl", "%eax");
                break;
            case "-":
                emit("subl", "%ebx", "%eax");
                emit("pushl", "%eax");
                break;
        }
        return null;
    }

    @Override
    public Object visitMulDivExpr(FloydParser.MulDivExprContext ctx) {
        //emitComment(String.format("MulDivExpr -> ( %s )", ctx.getText()));
        visit(ctx.e1);
        visit(ctx.e2);
        emit("popl", "%ebx");
        emit("popl", "%eax");
        switch(ctx.mulop().getText()) {
            case "*":
                emit("imul", "%eax", "%ebx");
                emit("pushl", "%ebx");
                break;
            case "/":
                // divide EAX by contents of EBX
                emit("movl", "$0", "%edx");
                emit("idiv", "%ebx");
                // quotient result is left in eax
                emit("pushl", "%eax");
                break;
        }
        return null;
    }

    @Override
    public Object visitUnaryOpExpr(FloydParser.UnaryOpExprContext ctx) {
        //emitComment(String.format("UnaryOpExpr -> ( %s )", ctx.getText()));
        visit(ctx.unaryexpression());
        String unaryOp = ctx.unary_op().getText();
        switch(unaryOp) {
            case "+":
                break;
            case "-":
                emitComment("neg oper");
                emit("popl", "%eax");
                emit("neg", "%eax");
                emit("pushl", "%eax");
                break;
            case "not":
                emitComment("not oper");
                emit("popl", "%eax");
                emit("not", "%eax");
                emit("pushl", "%eax");
                break;

        }
        return null;
    }

    @Override
    public Object visitParenExpr(FloydParser.ParenExprContext ctx) {
        //emitComment(String.format("ParenExpr -> ( %s )", ctx.getText()));
        visit(ctx.expression());
        return null;
    }

    @Override
    public Object visitNewExpr(FloydParser.NewExprContext ctx) {
        ClassDecl classDecl = Type.getTypeForName(ctx.type().getText()).getClassDecl();
        int numVars = classDecl.getVarList().size();

        // reserve 8 bytes for A level
        emit("pushl", String.format("$%d", (8 + numVars * 4)));
        emit("pushl", "$1");
        emit("call", "calloc");
        emit("addl", "$8", "%esp");
        // push address to allocated memory in the heap
        emit("pushl", "%eax");

        //System.out.print("new " + Type.getTypeForName(ctx.type().getText()).getText());
        //System.out.println(" with " + classDecl.getVarList().size() + " vars");
        return null;
    }

    @Override
    public Object visitIdExpr(FloydParser.IdExprContext ctx) {
        // TODO: allow method decls to generate code for class instance vars too
        String varname = ctx.IDENTIFIER().getText();

        // if its a local var, use this offset
        if(localOffsets.get(varname) != null)
            emit("pushl", localOffsets.get(varname));
        // else, it must be a class instance var and requires THIS offset
        else {
            emit("movl", "8(%ebp)", "%ebx");
            emit("pushl", classInstanceOffsets.get(varname));
        }
        return null;
    }

    @Override
    public Object visitIntExpr(FloydParser.IntExprContext ctx) {
        emit("pushl", "$" + ctx.INTEGER().getText());
        return null;
    }

    // TODO: implement strings.  for now just pushes null
    @Override
    public Object visitStringExpr(FloydParser.StringExprContext ctx) {
        emitLineComment(ctx.str.getLine(), "string lit");
        String newStrLit = String.format("stringlit%d", strCounter++);
        emit(".data");
        emitLabel(newStrLit);
        emit(String.format(".string %s", ctx.str.getText()));

        emit(".text");
        emit("pushl", String.format("$%s", newStrLit));
        emit("call", "string_fromlit");
        emit("addl", "$4", "%esp");
        emit("pushl", "%eax");

        // for now strings are just null
        //emit("pushl", "$0");
        return null;
    }

    @Override
    public Object visitTrueExpr(FloydParser.TrueExprContext ctx) {
        emit("pushl", "$-1");
        return null;
    }

    @Override
    public Object visitFalseExpr(FloydParser.FalseExprContext ctx) {
        emit("pushl", "$0");
        return null;
    }

    @Override
    public Object visitNullExpr(FloydParser.NullExprContext ctx) {
        emit("pushl", "$0");
        return null;
    }

    @Override
    public Object visitMeExpr(FloydParser.MeExprContext ctx) {
        emit("pushl","8(%ebp)");
        return null;
    }
}
