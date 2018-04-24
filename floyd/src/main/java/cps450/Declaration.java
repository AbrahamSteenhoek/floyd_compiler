/*
Abraham Steenhoek
CPS 450: Phase 5
4/19/20

Declaration.java
    - Declaration represents a variable, method, or class when it is declared in the floyd file
    - These declarations are used to provide information later in the error checking and code generation process
    - All declarations by default include a type
 */

package cps450;

import java.util.ArrayList;

public class Declaration {
    Type type; // all symbols have a type
    public Declaration(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }
}

/*
Class: VarDecl
    - Contains the type of the variable
    - Includes the offset of the variable from the base pointer for use in Code Generation
 */
class VarDecl extends Declaration {
    private int offset;
    public VarDecl(Type type) {
        super(type);
        offset = 0;
    }
    public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getOffset() {
        return this.offset;
    }
}

/*
Class: MethodDecl
    - Type for MethodDecl is the return type of the method
    - Contains a list of symbols for parameters, and a list of symbols for local variables
 */
class MethodDecl extends Declaration {
    private ArrayList<Symbol> paramList, varList;

    public MethodDecl(Type type) {
        super(type);
        paramList = new ArrayList<>();
        varList = new ArrayList<>();
    }

    public void addParam(Symbol param) { paramList.add(param); }
    public void addVar(Symbol var) { varList.add(var); }
    public int getParamCount() { return paramList.size(); }

    public ArrayList<Symbol> getParamList() { return paramList; }
    public ArrayList<Symbol> getVarList() {
        return varList;
    }

    public void setParamList(ArrayList<Symbol> newParamList) { paramList = newParamList; }
    public void setVarList(ArrayList<Symbol> vl) { this.varList = vl; }

}

/*
Class: ClassDecl
    - Type for ClassDecl is always Type.CLASS
    - ClassDecl creates a new type in the available types for use that is the type that this ClassDecl represents
    - Contains a list of symbols for methods, and a list of symbols for instance variables
 */
class ClassDecl extends Declaration {
    // methodList holds all of the declared methods inside the class
    ClassDecl inheritsFrom;
    public ArrayList<Symbol> varList, methodList;

    // ClassDecls initially have no vars and methods.  They are added later.
    // Therefore, passing arrays into the constructor is unnecessary
    public ClassDecl(Type type) {
        super(type);
        this.methodList = new ArrayList<>();
        this.varList = new ArrayList<>();
    }

    public ClassDecl(String className) {
        super(Type.CLASS);
        Type type = Type.createType(className);

        if (className.equals("String")) Type.STRING.setClassDecl(this);
        type.setClassDecl(this);

        this.methodList = new ArrayList<>();
        this.varList = new ArrayList<>();
    }

    public void addVar (Symbol var) {
        varList.add(var);
    }
    public void addMethod (Symbol method) {
        methodList.add(method);
    }

    public ArrayList<Symbol> getMethodList() {
        return methodList;
    }
    public ArrayList<Symbol> getVarList() {
        return varList;
    }
    public void setVarList(ArrayList<Symbol> vl) {
        this.varList = vl;
    }
    public void setMethodList(ArrayList<Symbol> ml) {
        this.methodList = ml;
    }

    // returns method symbol if the class has it in its declaration.  NULL if not found
    public Symbol contains(String methodName) {
        for(Symbol declaredMethod : methodList) {
            if (declaredMethod.getName().equals(methodName))
                return declaredMethod;
        }
        return null;
    }
}
