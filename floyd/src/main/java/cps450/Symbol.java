/*
Abraham Steenhoek
CPS 450: Phase 5
4/19/20

Symbol.java

Class: Symbol
    - A Symbol represents a variable, method, or class declared in the Floyd program
    - Symbols hold the type, scope, and name of the variable, method, or class
    - Symbols are used for semantic checking and Code Generation
*/

package cps450;

public class Symbol {
    private int scope;
    private String name;
    private Declaration declaration;

    public Symbol() {
        scope = 0;
        name = "";
        declaration = new Declaration(Type.ERROR);
    }

    public Symbol(Type type) {
        scope = 0;
        name = "";
        declaration = new Declaration(type);
    }

    public Symbol(int scope, String name, Declaration declaration) {
        this.scope = scope;
        this.name = name;
        this.declaration = declaration;
    }

    public String getName() {
        return name;
    }
    public int getScope() {
        return scope;
    }
    public Declaration getDeclaration() {
        return declaration;
    }
    public Type getType() {
        return declaration.getType();
    }
}
