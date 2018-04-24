package cps450;
import cps450.Symbol;
/*
Abraham Steenhoek
CPS 450: Phase 5
4/19/20

SymbolTable.java

Class: SymbolTable
    - The Symbol table contains all of the declared symbols in the current floyd program at specified levels of scope
    - The symbol table can perform lookups throughout the entire table (global), or the current scope(inside a class or method)
*/
import java.util.*;

public class SymbolTable {
    // each HashMap represents the collection of symbols within the current scope
    // key for HashMap represents the Symbol Name
    Stack<HashMap<String, Symbol>> stack;
    private int curScope;

    private static SymbolTable myInstance = new SymbolTable();

    public static SymbolTable getInstance() {
        return myInstance;
    }

    private SymbolTable() {
        stack = new Stack<HashMap<String, Symbol>>();
        // start with an empty collection of symbols at scope 0
        stack.push(new HashMap<String, Symbol>());
        curScope = 0;
    }

    public Symbol push(String name, Declaration decl) {
        Symbol symbol = new Symbol(curScope, name, decl);
        // add a new symbol to collection of symbols at current scope
        stack.peek().put(symbol.getName(), symbol);

        return symbol;
    }

    public Symbol lookup(String name) {
        Stack<HashMap<String, Symbol> > tempStack = new Stack<HashMap<String, Symbol>>();
        while(!stack.empty()) {
            Symbol found = stack.peek().get(name);
            // if the symbol is in the collection of symbols at this scope
            if(found != null) {
                // return all previously popped elements to stack
                while(!tempStack.empty()) {
                    stack.push(tempStack.pop());
                }
                return found;
            }
            tempStack.push(stack.pop());
        }
        // if not found, restore all popped elements to stack
        while (!tempStack.empty()) {
            stack.push(tempStack.pop());
        }
        return null;
    }

    public Symbol lookupWithinCurScope(String name) {
        // the top of the stack is the current scope
        return stack.peek().get(name);
    }

    public void beginScope() {
        // push a new empty collection of symbols for a new scope
        stack.push(new HashMap<String, Symbol>());
        ++curScope;
    }

    public void endScope() {
        if (curScope <= 0) {
            // raise exception
            throw new EmptyStackException();
        }
        else {
            stack.pop();
            --curScope;
        }
    }

    public int getScope() {
        return curScope;
    }

    public void clear() {
        while(!stack.empty()) {
            stack.pop();
        }
        stack.push(new HashMap<String, Symbol>());
        curScope = 0;
    }
}