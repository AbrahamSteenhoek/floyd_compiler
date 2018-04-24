/*
Abraham Steenhoek
CPS 450: Phase 5
4/19/20

SemanticChecker.java

Class: SemanticChecker
    - Performs all the semantic checking for Floyd files that pass syntax error checking
    - Reports all semantic errors to STDOUT and increments an error counter by traversing the parse tree
    - Decorates the parse tree with Symbols and Declarations for use later in Code Generation
    - uses the FloydBaseVisitor class to traverse the parse tree and mixes it with a listener approach by 'decorating' the tree nodes with symbols and declarations
*/
package cps450;

import org.antlr.v4.runtime.Token;

import javax.sound.midi.SysexMessage;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SemanticChecker extends FloydBaseVisitor<Type> {
    private int errCount;
    SymbolTable table = SymbolTable.getInstance();
    // a reference to the Class Declaration of the class currently being visited.
    // used to add instance variables and methods
    String curClass;
    Options.FileCollection fileCollection;

    /*
    Enum: ErrorMsg
        - Categorizes all possible semantic errors into predefined messages
        - Used to aid readability when reporting semantic errors
     */
    public enum ErrorMsg {
        REDECL_VAR("Redeclared variable: "),
        REDECL_CLASS("Redeclared class: "),
        REDECL_METH("Redeclared method: "),
        FEAT_UNSUPP("Feature unsupported: "),
        VAR_NOTYPE("Type required for var: "),
        UNDECL_VAR("Use of undeclared variable: "),
        UNDECL_ID("Use of undeclared identifier: "),
        UNDECL_CLASS("Use of undeclared class: "),
        UNDECL_METH("Use of undeclared method: "),
        METHCALL_EXPR_VOID("Method call expression must be non-void: "),
        ASSIGN_VOID_RET_VAL("Cannot assign a return value to a method with a void return type: "),
        WRONG_NUM_PARAMS("Wrong number of params for method: "),
        MISMATCH_PARAMS("Mismatched parameter types: Actuals do not match formals: "),
        NO_START_METH("Last class must contain a start method: "),
        INVALID_TYPE("Type has not been declared: ");

        private ErrorMsg(String msg) {
            this.msg = msg;
        }
        private String msg = "";
        public String getText() {
            return msg;
        }
    }

    public SemanticChecker(Options.FileCollection fileCollection) {
        this.fileCollection = fileCollection;
        errCount = 0;
        curClass = null;
        //curMethod = null;
    }
    public int getErrCount() { return errCount; }

    /*
    Method: reportError
        - Function used to report all types of semantic errors
        - Displays the error message from ErrorMsg enum, the token that causes the
          semantic error, and the appropriate line number and char position
     */
    private void reportError(String msg, Token tok) {
        int lineNum = tok.getLine();
        Pair<Integer, String> curFile = fileCollection.getFileNameAndLineNum(lineNum);

        //System.out.println("line num: " + lineNum);
        System.out.println(String.format("%s:%d,%d:%s", curFile.getValue(), curFile.getKey(), (tok.getCharPositionInLine() + 1), msg));
        ++errCount;
    }

    /*
    Method: errorFormat
        - formats and error message and the subject of the message into a string
     */
    private String errorFormat(ErrorMsg errmsg, String subject) {
        return String.format("%s'%s'", errmsg.getText(), subject);
    }

    /*
    Method: checkConditionalStmt & checkBinaryExpr
        - Checks all conditional stmts
            - Checks if the expression evaluated by a conditional statement is a boolean type
        - Checks all binary operator expressions
            - Checks if the type of LHS and the RHS are the same, or if LHS is an object and RHS is null
     */
    public void checkConditionalStmt(String desc, Type expr, Token tok) {
        if (!expr.equals(Type.BOOLEAN)) {
            reportError(String.format("Incorrect type for %s: expecting boolean, got %s", desc, expr.getText()), tok);
        }
    }

    public Type checkBinaryExpr(Type op1, Type op2, String opName, Type returnType, Token tok) {
        // if there are no errors in the leaves
        if(!op1.equals(Type.ERROR) && !op1.equals(Type.ERROR)) {
            if(!(op1.equals(returnType) && op2.equals(returnType))) {
                reportError(String.format("Incorrect type for '%s': requires %ss, given %s and %s", opName, returnType.getText(), op1.getText(), op2.getText()), tok);
            }
        }
        return returnType;
    }

    // Override VISIT methods

    //TODO: Externally implement io_read & io_write
    @Override
    public Type visitStart(FloydParser.StartContext ctx) {
        /*
        // TODO: use these classes to do error checking for readint and writeint instead of the current method of hardcoding the identifiers
        ClassDecl in = new ClassDecl(new Type("in"));
        ClassDecl out = new ClassDecl(new Type("out"));
        MethodDecl readint = new MethodDecl(Type.INT);
        MethodDecl writeint = new MethodDecl(Type.VOID);
        writeint.addParam(new Symbol(2,  "param", new Declaration(Type.INT)));
        in.addMethod(new Symbol(1, "readint", readint));
        out.addMethod(new Symbol(1, "writeint", writeint));

        table.push("in", in);
        table.push("out", out);

        //*/

        visit(ctx.fclass_list());
        return null;
    }

    /*
    Method: visitFclass_list
        - pushes io_write & io_read methods onto the symbol table because they are global exceptions to normally declared methods
        - The last class declared in the file must contain a start method
        - out and in are global instances of the Writer and Reader class, respectively
    */
    @Override
    public Type visitFclass_list(FloydParser.Fclass_listContext ctx) {
        // io_write & io_read are globally declared methods
        MethodDecl io_write = new MethodDecl(Type.VOID);
        io_write.addParam(new Symbol(Type.INT));

        MethodDecl io_read = new MethodDecl(Type.INT);

        table.push("io_write", io_write);
        table.push("io_read", io_read);

        int i = 0;
        for (FloydParser.FclassContext fclass : ctx.fclasses) {

            String className = fclass.classid.getText();

            visit(fclass);

            // last class declared must contain a start method
            if(i++ == ctx.fclasses.size() - 1) {
                ClassDecl lastClass = (ClassDecl) table.lookup(className).getDeclaration();
                if(lastClass.contains("start") == null) {
                    reportError(errorFormat(ErrorMsg.NO_START_METH, className), fclass.classid);
                }
            }
        }
        return null;
    }

    @Override
    public Type visitFclass(FloydParser.FclassContext ctx) {
        // if we have scanned the stdlib.floyd class already
        if(!fileCollection.getFileNameAndLineNum(ctx.classid.getLine()).getValue().equals("stdlib.floyd")) {
            VarDecl out = new VarDecl(Type.getTypeForName("Writer"));
            VarDecl in = new VarDecl(Type.getTypeForName("Reader"));

            table.push("out", out);
            table.push("in", in);
        }

        String className = ctx.classid.getText();

        ClassDecl classDecl = new ClassDecl(className);
        curClass = className;
        ctx.classDecl = classDecl;

        // if class has already been declared
        if(table.lookup(className) != null) {
            reportError(errorFormat(ErrorMsg.REDECL_CLASS, className), ctx.classid);
        }

        table.push(className, classDecl);
        table.beginScope();

        // instance vars
        // visit variable declarations in the class
        if(ctx.var_decl_list() != null) {
            visit(ctx.var_decl_list());
            classDecl.setVarList(ctx.var_decl_list().varList);
        }

        for(FloydParser.Method_declContext methoddecl : ctx.method_decls) {
            visit(methoddecl);
            classDecl.addMethod(new Symbol(table.getScope(), methoddecl.methid.getText(), methoddecl.methodDecl));
        }

        table.endScope();

        //classDecl.getType().setClassDecl(classDecl);
        return classDecl.getType();
    }

    @Override
    public Type visitVar_decl_list(FloydParser.Var_decl_listContext ctx) {
        ctx.varList = new ArrayList<Symbol>();

        // offsets start with an absolute value of 8 from the pointer to the object/ebp
        int offset = 8;
        for(FloydParser.Var_declContext var : ctx.vardecls) {
            visit(var);
            // set the offset from ebp for CodeGen
            if(var.varSymbol != null)
                ((VarDecl) var.varSymbol.getDeclaration()).setOffset(offset);

            ctx.varList.add(var.varSymbol);
            offset += 4;
        }
        return null;
    }


    /*
    Method: visitVarDecl
        - Checks for the following errors:
            - redeclared variables
            - vars declared with no type
            - assigning vars to void type
            - type mismatch in var decls if assignment statement in included
        - Leaves a symbol on the table representing the variable just declared for use in Code Generation
     */
    @Override
    public Type visitVar_decl(FloydParser.Var_declContext ctx) {
        String varname = ctx.varid.getText();
        //System.out.println("Declaring var: " + varname + " of type " + ctx.type().getText());
        Symbol symbol = table.lookupWithinCurScope(varname);
        Type vartype = Type.ERROR;// = Type.typeMap.get(ctx.type().getText());

        if (symbol != null) {
            // throw redeclared variable ID error
            reportError(errorFormat(ErrorMsg.REDECL_VAR, varname), ctx.varid);
        }
        else if (ctx.type() == null) {
            reportError(errorFormat(ErrorMsg.VAR_NOTYPE, varname), ctx.varid);
            vartype = Type.ERROR;
        }
        else {
            vartype = visit(ctx.type());
            // TODO: implement this unsupported feature
            if (ctx.ASSIGNMENTOP() != null) {
                Type LHS = vartype;
                Type RHS = visit(ctx.expression());
                if(LHS.equals(Type.VOID))
                    reportError(errorFormat(ErrorMsg.ASSIGN_VOID_RET_VAL, varname), ctx.IDENTIFIER().getSymbol());

                if (!LHS.equals(RHS)) {
                    if((!LHS.equals(Type.INT) || !LHS.equals(Type.BOOLEAN)) && RHS.equals(Type.NULL)) {
                        // it's ok to assign objects to null
                    }
                    else {
                        reportError(String.format("Type mismatch in assignment statement: expected %s on RHS, got %s", LHS.getText(), RHS.getText()), ctx.expr.getStop());
                    }
                }

            }

            VarDecl varDecl = new VarDecl(vartype);
            // pushes var to symbol table and adds it to curClass simultaneously
            ctx.varSymbol = table.push(varname, varDecl);
            // curClass.addMethod(table.push(varname, varDecl));
        }
        return vartype;
    }

    /*
    Method: visitMethod_decl
        - checks for the following errors
            - Redeclared method
            - valid types for each parameter (visits Argument_decl nodes)
        - decorates the tree with a method declaration for Code Generation
     */
    @Override
    public Type visitMethod_decl(FloydParser.Method_declContext ctx) {
        String methodName = ctx.methid.getText();
        if(table.lookup(methodName) != null) {
            reportError(errorFormat(ErrorMsg.REDECL_METH, methodName), ctx.methid);
        }

        // Type temp = null;
        Type methType;
        if(ctx.type() != null)
            methType = visit(ctx.type());
        else
            methType = Type.VOID;

        MethodDecl methodDecl = new MethodDecl(methType);
        table.push(methodName, methodDecl);
        table.beginScope();

        // visit method params
        // handle this here instead of separate visit method to get access to methodDecl (consider using global var curMethod)
        // this for loop serves as a visitArgDecl_List method
        if (ctx.argument_decl_list() != null) {
            visit(ctx.argument_decl_list());
            methodDecl.setParamList(ctx.argument_decl_list().paramSymbolList);
        }

        if(ctx.var_decl_list() != null) {
            visit(ctx.var_decl_list());
            methodDecl.setVarList(ctx.var_decl_list().varList);
        }

        visit(ctx.statement_list());

        table.endScope();

        // decorate the tree to use later for CodeGen
        ctx.methodDecl = methodDecl;

        return methType;
    }

    @Override
    public Type visitArgument_decl_list(FloydParser.Argument_decl_listContext ctx) {
        ArrayList<Symbol> paramList = new ArrayList<>();
        for(FloydParser.Argument_declContext arg : ctx.args) {
            visit(arg);
            paramList.add(arg.paramSymbol);
        }
        ctx.paramSymbolList = paramList;
        return null;
    }

    @Override
    public Type visitArgument_decl(FloydParser.Argument_declContext ctx) {
        String argName = ctx.IDENTIFIER().getText();
        Type argType = visit(ctx.type());
        ctx.paramSymbol = new Symbol(table.getScope(), argName, new VarDecl(argType));
        table.push(argName, new Declaration(argType));
        return argType;
    }



    /*
    Method: checkMethodCallParams
        - used to check if the called method matches the declared definition of the method
     */
    public Type checkMethodCallParams(String methodName, Symbol declaredMethod, List<FloydParser.ExpressionContext> exprs, Token tok) {
        ArrayList<Symbol> dMethodPList = ((MethodDecl) declaredMethod.getDeclaration()).getParamList();

        if (dMethodPList.size() != exprs.size()) {
            String errMsg = String.format("%s.  Expecting %d params, got %d params", errorFormat(ErrorMsg.WRONG_NUM_PARAMS, methodName), dMethodPList.size(), exprs.size());
            reportError(errMsg, tok);
        }
        // check if called method has correct sequence of parameter types
        else {
            int i = 0;
            for (FloydParser.ExpressionContext expr : exprs) {
                Type checkType = dMethodPList.get(i).getType();
                // testType must be same as checkType
                Type testType = visit(expr);
                if (!testType.equals(checkType)) {
                    String errMsg = String.format("%s.  Expecting %s, got %s", errorFormat(ErrorMsg.MISMATCH_PARAMS, methodName), checkType.getText(), testType.getText());
                    reportError(errMsg, expr.getStart());
                    break;
                }
                i++;
            }
        }

        return null;
    }

    /*
    Method: visitMethodCallExpr & visit_Call_stmt1
         - checks for the following errors:
               - method is undeclared
               - sequence of types in called method does not match sequence of params in declared method
               - wrong number of parameters in called method
               - Object that calls method is not a class type
               - the method expression returns void (allowed for call statements, not method call expressions)
         - leaves a method declaration on the tree node for later use in Code Generation
     */
    @Override
    public Type visitMethodCallExpr(FloydParser.MethodCallExprContext ctx) {

        String methodName = ctx.methid.getText();

        Symbol declaredMethod = table.lookup(methodName);
        Token methToken = ctx.methid;

        Type classType = visit(ctx.methodcallexpression());
        if(classType.equals(Type.INT) || classType.equals(Type.BOOLEAN) || classType.equals(Type.VOID)) {
            reportError(String.format("Identifier '%s' must be compatible object type, given: '%s'",ctx.methodcallexpression().getText(), classType.getText()), ctx.methodcallexpression().getStop());
            return Type.ERROR;
        }
        // store the object type of the caller to use for CodeGen later
        ctx.classSymbol = ctx.methodcallexpression().classSymbol;

        // determine return type of the method
        Type methType = Type.ERROR;

        if(declaredMethod == null) {
            ClassDecl classDecl = classType.getClassDecl();
            if(classDecl == null) {
                reportError(errorFormat(ErrorMsg.UNDECL_METH, methodName), methToken);
                return Type.ERROR;
            }
            // declared method is the method previously declared using a MethodDeclStmt
            declaredMethod = classDecl.contains(methodName);
            // if class does NOT have the method in its list of declared methods
            if(declaredMethod == null) {
                reportError(errorFormat(ErrorMsg.UNDECL_METH, methodName), methToken);
                return Type.ERROR;
            }
            else {
                methType = declaredMethod.getType();
            }
        }
        else {
            methType = table.lookup(methodName).getType();
        }

        if(methType.equals(Type.VOID)) {
            reportError(errorFormat(ErrorMsg.METHCALL_EXPR_VOID, methodName), methToken);
            return Type.VOID;
        }

        // check to see if params given in method call match params of declared method
        if (ctx.expression_list() != null)
            checkMethodCallParams(methodName, declaredMethod, ctx.expression_list().exprs, methToken);

        return methType;
    }

    @Override
    public Type visitMethodCallPass(FloydParser.MethodCallPassContext ctx) {
        Type type = visit(ctx.parenexpression());
        ctx.classSymbol = ctx.parenexpression().ClassSymbol;

        return type;
    }

    @Override
    public Type visitCall_stmt1(FloydParser.Call_stmt1Context ctx) {
        String methodName = ctx.methid.getText();

        Symbol declaredMethod = table.lookup(methodName);
        Token methToken = ctx.methid;

        Type classType = visit(ctx.methodcallexpression());

        if(classType.equals(Type.INT) || classType.equals(Type.BOOLEAN) || classType.equals(Type.VOID)) {
            reportError(String.format("Identifier '%s' must be compatible object type, given: '%s'",ctx.methodcallexpression().getText(), classType.getText()), ctx.methodcallexpression().getStop());
            return Type.ERROR;
        }
        // store the object type of the caller to use for CodeGen later
        ctx.classSymbol = new Symbol(classType);

        // determine return type of the method
        Type methType = Type.ERROR;

        if(declaredMethod == null) {

            ClassDecl classDecl = classType.getClassDecl();
            if(classDecl == null) {
                reportError(errorFormat(ErrorMsg.UNDECL_METH, methodName), methToken);
                return Type.ERROR;
            }
            // declared method is the method previously declared using a MethodDeclStmt
            declaredMethod = classDecl.contains(methodName);
            // if class does NOT have the method in its list of declared methods
            if(declaredMethod == null) {
                reportError(errorFormat(ErrorMsg.UNDECL_METH, methodName), methToken);
                return Type.ERROR;
            }
            else {
                methType = declaredMethod.getType();
            }
        }
        else {
            methType = table.lookup(methodName).getType();
        }

        // check to see if params given in method call match params of declared method
        if (ctx.expression_list() != null)
            checkMethodCallParams(methodName, declaredMethod, ctx.expression_list().exprs, methToken);

        return null;
    }

    /*
    Method: visitMethodCall
        - checks for the same errors as visitMethodCallExpr & visitCall_stmt1, just not errors involving objects calling the method
        - leaves a method declaration on the tree node for later use in Code Generation
     */
    @Override
    public Type visitMethodcall(FloydParser.MethodcallContext ctx) {
        String methodName = ctx.methid.getText();
        Symbol declaredMethod = table.lookup(methodName);
        Token methToken = ctx.methid;

        if(declaredMethod == null) {
            reportError(errorFormat(ErrorMsg.UNDECL_METH, methodName), methToken);
            return Type.ERROR;
        }

        Type methType = Type.getTypeForName(declaredMethod.getType().getText());

        // check to see if params given in method call match params of declared method
        if (ctx.expression_list() != null)
            checkMethodCallParams(methodName, declaredMethod, ctx.expression_list().exprs, methToken);

        return methType;
    }

    @Override
    public Type visitStatement_list(FloydParser.Statement_listContext ctx) {
        for(FloydParser.StatementContext stmt : ctx.stmts) {
            visit(stmt);
        }
        return null;
    }

    /*
    Method: visitAssign_stmt
        - checks for the following errors:
            - Type on the LHS matches the RHS, unless it is an object on the LHS and the null type on the RHS
            - Array indexing is not supported, so its use is flagged as an error to avoid NullPointerExceptions
     */
    @Override
    public Type visitAssign_stmt(FloydParser.Assign_stmtContext ctx) {
        String varname = ctx.IDENTIFIER().getText();
        Symbol LHSsymbol = table.lookup(varname);
        if(LHSsymbol == null) {
            // throw undeclared variable error
            reportError(errorFormat(ErrorMsg.UNDECL_VAR, varname), ctx.IDENTIFIER().getSymbol());
            return null;
        }

        Type LHS = LHSsymbol.getType();
        //System.out.println("visit expr: " + ctx.rhexpr.getText());
        Type RHS = visit(ctx.rhexpr);

        if(LHS.equals(Type.VOID))
            reportError(errorFormat(ErrorMsg.ASSIGN_VOID_RET_VAL, varname), ctx.IDENTIFIER().getSymbol());
        // brackets on LHS are not allowed yet
        if(ctx.exprs.size() > 0) {
            reportError(errorFormat(ErrorMsg.FEAT_UNSUPP, "array indexing on LHS of assignment statement"), ctx.IDENTIFIER().getSymbol());
        }
        else {
            if (!LHS.equals(RHS)) {
                if((!LHS.equals(Type.INT) || !LHS.equals(Type.BOOLEAN)) && RHS.equals(Type.NULL)) {
                    // it's ok to assign objects to null
                }
                else {
                    reportError(String.format("Type mismatch in assignment statement: expected %s on RHS, got %s", LHS.getText(), RHS.getText()), ctx.rhexpr.getStart());
                }
            }
        }

        return null;
    }

    /*
    Method: visitIf_stmt & visitLoop_stmt
        - checks for the following errors:
            - expression in the conditional statement must be a boolean type
     */
    @Override
    public Type visitIf_stmt(FloydParser.If_stmtContext ctx) {
        Type type = visit(ctx.expression());
        checkConditionalStmt("if statement", type, ctx.expression().getStart());
        visit(ctx.if_stmtlist);
        if(ctx.else_stmtlist != null) {
            visit(ctx.else_stmtlist);
        }
        return null;
    }

    @Override
    public Type visitLoop_stmt(FloydParser.Loop_stmtContext ctx) {
        Type type = visit(ctx.expression());
        checkConditionalStmt("loop", type, ctx.expression().getStart());
        visit(ctx.statement_list());
        return null;
    }


    /*
    Method: ALL visiting methods for expression nodes
        - checks for the following errors:
            - mismatching types for binary operators
            - mismatching type for unary operators
            - undeclared class in new expression
            - undeclared identifiers in id expression
        - passes a symbol representing the class calling a method in method call expressions up the tree to the top expression node for Code Generation
     */

    @Override
    public Type visitArrayExpr(FloydParser.ArrayExprContext ctx) {
        String arrayID = ctx.arrayid.getText();
        reportError(errorFormat(ErrorMsg.FEAT_UNSUPP, arrayID), ctx.arrayid);
        //featureUnsupported("array indexing");
        return Type.ERROR;
    }

    @Override
    public Type visitOrExpr(FloydParser.OrExprContext ctx) {
        Type op1 = visit(ctx.e1);
        Type op2 = visit(ctx.e2);
        Type returnType = checkBinaryExpr(op1, op2, ctx.OR().getText(), Type.BOOLEAN, ctx.OR().getSymbol());
        ctx.ClassSymbol = ctx.andexpression().ClassSymbol;
        return returnType;
    }

    @Override
    public Type visitAndSubExpr(FloydParser.AndSubExprContext ctx) {
        Type type = visit(ctx.andexpression());
        ctx.ClassSymbol = ctx.andexpression().ClassSymbol;
        return type;
    }
    @Override
    public Type visitAndExpr(FloydParser.AndExprContext ctx) {
        Type op1 = visit(ctx.e1);
        Type op2 = visit(ctx.e2);
        Type returnType = checkBinaryExpr(op1, op2, ctx.AND().getText(), Type.BOOLEAN, ctx.AND().getSymbol());
        ctx.ClassSymbol = ctx.equalexpression().ClassSymbol;
        return returnType;
    }

    @Override
    public Type visitEqSubExpr(FloydParser.EqSubExprContext ctx) {
        Type type = visit(ctx.equalexpression());
        ctx.ClassSymbol = ctx.equalexpression().ClassSymbol;
        return type;
    }

    @Override
    public Type visitGteSubExpr(FloydParser.GteSubExprContext ctx) {
        Type type = visit(ctx.gteexpression());
        ctx.ClassSymbol = ctx.gteexpression().ClassSymbol;
        return type;
    }

    @Override
    public Type visitGtSubExpr(FloydParser.GtSubExprContext ctx) {
        Type type = visit(ctx.gtexpression());
        ctx.ClassSymbol = ctx.gtexpression().ClassSymbol;
        return type;
    }

    @Override
    public Type visitEqualExpr(FloydParser.EqualExprContext ctx) {
        Type op1 = visit(ctx.e1);
        Type op2 = visit(ctx.e2);
        // if types mismatch OR types given match but are not comparable for operator
        if(!op1.equals(op2)) {
            // if LHS is not a primitive data type
            if (op1.equals(Type.INT) || op1.equals(Type.BOOLEAN) || op2.equals(Type.INT) || op2.equals(Type.BOOLEAN)) {
                reportError(String.format("Type mismatch for operator '=': primitive types (ints & booleans) require same types, given %s and %s", op1.getText(), op2.getText()), ctx.EQUALS().getSymbol());
            }
            else {

            }
        }
        ctx.ClassSymbol = ctx.concatexpression().ClassSymbol;
        return Type.BOOLEAN;
    }
    @Override
    public Type visitEqualPass(FloydParser.EqualPassContext ctx) {
        Type type = visit(ctx.concatexpression());
        ctx.ClassSymbol = ctx.concatexpression().ClassSymbol;
        return type;
    }

    @Override
    public Type visitGTExpr(FloydParser.GTExprContext ctx) {
        Type op1 = visit(ctx.e1);
        Type op2 = visit(ctx.e2);
        // if types mismatch OR types given match but are not legal types for operator
        if(!op1.equals(op2) || (!op1.equals(Type.INT) && !op1.equals(Type.STRING))) {
            reportError(String.format("Type mismatch for operator '>': requires ints, strings, or booleans, given %s and %s", op1.getText(), op2.getText()), ctx.GT().getSymbol());
        }
        ctx.ClassSymbol = ctx.concatexpression().ClassSymbol;
        return Type.BOOLEAN;
    }
    @Override
    public Type visitGTPass(FloydParser.GTPassContext ctx) {
        Type type = visit(ctx.concatexpression());
        ctx.ClassSymbol = ctx.concatexpression().ClassSymbol;
        return type;
    }

    @Override
    public Type visitGTEExpr(FloydParser.GTEExprContext ctx) {
        Type op1 = visit(ctx.e1);
        Type op2 = visit(ctx.e2);
        // if types mismatch OR types given match but are not legal types for operator
        if(!op1.equals(op2) || (!op1.equals(Type.INT) && !op1.equals(Type.STRING))) {
            reportError(String.format("Type mismatch for operator '>=': requires ints, strings, or booleans, given %s and %s", op1.getText(), op2.getText()), ctx.GTE().getSymbol());
        }
        ctx.ClassSymbol = ctx.concatexpression().ClassSymbol;
        return Type.BOOLEAN;
    }
    @Override
    public Type visitGTEPass(FloydParser.GTEPassContext ctx) {
        Type type = visit(ctx.concatexpression());
        ctx.ClassSymbol = ctx.concatexpression().ClassSymbol;
        return type;
    }

    @Override
    public Type visitConcatExpr(FloydParser.ConcatExprContext ctx) {
        Type op1 = visit(ctx.e1);
        Type op2 = visit(ctx.e2);
        Type returnType = checkBinaryExpr(op1, op2, ctx.CONCAT().getText(), Type.STRING, ctx.CONCAT().getSymbol());
        ctx.ClassSymbol = ctx.plusminexpression().ClassSymbol;
        return returnType;
    }
    @Override
    public Type visitConcatPass(FloydParser.ConcatPassContext ctx) {
        Type type = visit(ctx.plusminexpression());
        ctx.ClassSymbol = ctx.plusminexpression().ClassSymbol;
        return type;
    }

    @Override
    public Type visitPlusMinExpr(FloydParser.PlusMinExprContext ctx) {
        Type op1 = visit(ctx.e1);
        Type op2 = visit(ctx.e2);
        Type returnType = checkBinaryExpr(op1, op2, ctx.addop().getText(), Type.INT, ctx.addop().getStart());
        ctx.ClassSymbol = ctx.muldivexpression().ClassSymbol;
        return returnType;
    }
    @Override
    public Type visitPlusMinPass(FloydParser.PlusMinPassContext ctx) {
        Type type = visit(ctx.muldivexpression());
        ctx.ClassSymbol = ctx.muldivexpression().ClassSymbol;
        return type;
    }

    @Override
    public Type visitMulDivExpr(FloydParser.MulDivExprContext ctx) {
        Type op1 = visit(ctx.e1);
        Type op2 = visit(ctx.e2);
        Type returnType = checkBinaryExpr(op1, op2, ctx.mulop().getText(), Type.INT, ctx.mulop().getStart());
        ctx.ClassSymbol = ctx.unaryexpression().ClassSymbol;
        return returnType;
    }
    @Override
    public Type visitMulDivPass(FloydParser.MulDivPassContext ctx) {
        Type type = visit(ctx.unaryexpression());
        ctx.ClassSymbol = ctx.unaryexpression().ClassSymbol;
        return type;
    }

    @Override
    public Type visitUnaryOpExpr(FloydParser.UnaryOpExprContext ctx) {
        return visit(ctx.unaryexpression());
    }

    @Override
    public Type visitUnaryPass(FloydParser.UnaryPassContext ctx) {
        Type type = visit(ctx.methodcallexpression());
        ctx.ClassSymbol = ctx.methodcallexpression().classSymbol;
        return type;
    }

    @Override
    public Type visitNewExpr(FloydParser.NewExprContext ctx) {
        Type type = visit(ctx.type());
        Symbol classSymbol = table.lookup(ctx.type().getText());
        if(classSymbol == null) {
            // undeclared class
            reportError(errorFormat(ErrorMsg.UNDECL_CLASS, ctx.type().getText()), ctx.type().getStart());
            ctx.ClassSymbol = new Symbol(0, "", new ClassDecl(""));
            return Type.ERROR;
        }

        ctx.ClassSymbol = classSymbol;

        return type;
    }

    @Override
    public Type visitUnary_op(FloydParser.Unary_opContext ctx) {
        return super.visitUnary_op(ctx);
    }

    @Override
    public Type visitParenExpr(FloydParser.ParenExprContext ctx) {
        Type type = visit(ctx.expression());
        ctx.ClassSymbol = ctx.expression().ClassSymbol;
        return type;
    }

    @Override
    public Type visitIdExpr(FloydParser.IdExprContext ctx) {
        String id = ctx.getText();
        Symbol symbol = table.lookup(id);
        if (symbol == null) {
            reportError(errorFormat(ErrorMsg.UNDECL_ID, id), ctx.IDENTIFIER().getSymbol());
            return Type.ERROR;
        }
        Type type = symbol.getType();
        ctx.ClassSymbol = symbol;
        return type;
    }

    @Override
    public Type visitStringExpr(FloydParser.StringExprContext ctx) {
        ctx.ClassSymbol = new Symbol(Type.STRING);
        return Type.STRING;
    }
    @Override
    public Type visitIntExpr(FloydParser.IntExprContext ctx) {
        return Type.INT;
    }
    @Override
    public Type visitTrueExpr(FloydParser.TrueExprContext ctx) {
        return Type.BOOLEAN;
    }

    @Override
    public Type visitFalseExpr(FloydParser.FalseExprContext ctx) {
        return Type.BOOLEAN;
    }

    @Override
    public Type visitNullExpr(FloydParser.NullExprContext ctx) {
        return Type.NULL;
    }

    @Override
    public Type visitMeExpr(FloydParser.MeExprContext ctx) {
        ctx.ClassSymbol = table.lookup(curClass);
        return Type.getTypeForName(curClass);
    }

    /*
    Method: visitType
        - checks for the following errors:
            - invalid types: object types that have not been declared
            - array indexing is not supported and is flagged as an error
     */
    @Override
    public Type visitType(FloydParser.TypeContext ctx) {
        if(ctx.id != null) {
            String idType = ctx.id.getText();
            if (Type.getTypeForName(idType) == null) {
                reportError(errorFormat(ErrorMsg.INVALID_TYPE, String.format("%s type", idType)), ctx.IDENTIFIER().getSymbol());
            }
            return Type.getTypeForName(idType);
        }
        else if(ctx.str != null) {
            //reportError(errorFormat(ErrorMsg.FEAT_UNSUPP, "string type"), ctx.str);
            return Type.STRING;
        }
        else if(ctx.i != null) {
            return Type.INT;
        }
        else if(ctx.bool != null) {
            return Type.BOOLEAN;
        }
        else {
            reportError(errorFormat(ErrorMsg.FEAT_UNSUPP, "array indexing"), ctx.type().IDENTIFIER().getSymbol());
            return Type.ERROR;
        }
    }
}
