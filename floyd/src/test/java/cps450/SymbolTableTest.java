package cps450;

import org.junit.Test;

import static org.junit.Assert.*;

public class SymbolTableTest {

    SymbolTable symbolTable = SymbolTable.getInstance();

    @Test
    public void push() {

        symbolTable.clear();
    }

    @Test
    public void lookup() {
        symbolTable.clear();
        Symbol testSymbol1 = symbolTable.push("test1", new Declaration(Type.STRING));
        Symbol testSymbol2 = symbolTable.push("test2", new Declaration(Type.INT));
        assertTrue(symbolTable.lookup("test1").getName().equals(testSymbol1.getName()));
        assertTrue(symbolTable.lookup("test2").getName().equals(testSymbol2.getName()));

        assertNull(symbolTable.lookup("notfoundhere"));

        // test multiple scopes
        symbolTable.beginScope();
        assertNotNull(symbolTable.lookup("test1"));
        Symbol testSymbol3 = symbolTable.push("test3", new Declaration(Type.STRING));
        Symbol testSymbol4 = symbolTable.push("test4", new Declaration(Type.INT));
        // test1 is in scope 0 but curScope is 1
        assertTrue(symbolTable.lookup("test1").getName().equals(testSymbol1.getName()));
        // test3 is in scope 1 which is current scope
        assertTrue(symbolTable.lookup("test3").getName().equals(testSymbol3.getName()));

        // test different types in same scope with same name (which comes first: should be top of the stack)
        Symbol testSymbol5_int = symbolTable.push("test5", new Declaration(Type.INT));
        Symbol testSymbol5_String = symbolTable.push("test5", new Declaration(Type.STRING));
        assertTrue(symbolTable.lookup("test5").getDeclaration().equals(testSymbol5_String.getDeclaration()));

        symbolTable.clear();
    }

    @Test
    public void lookupWithinCurScope() {
        Symbol testSymbol1 = symbolTable.push("test1", new Declaration(Type.STRING));
        assertTrue(symbolTable.lookupWithinCurScope("test1").getName().equals(testSymbol1.getName()));

        symbolTable.beginScope();
        assertNull(symbolTable.lookupWithinCurScope("test1"));

        Symbol testSymbol3 = symbolTable.push("test3", new Declaration(Type.STRING));
        assertTrue(symbolTable.lookupWithinCurScope("test3").getName().equals(testSymbol3.getName()));
        symbolTable.clear();
    }

    @Test
    public void beginScope() {
        assertTrue(symbolTable.getScope() == 0);
        assertNotNull(symbolTable.stack.peek());
        symbolTable.beginScope();
        assertTrue(symbolTable.getScope() == 1);
        assertNotNull(symbolTable.stack.peek());

        symbolTable.clear();
    }

    @Test
    public void endScope() {
        Symbol testSymbol1 = symbolTable.push("test1", new Declaration(Type.STRING));
        symbolTable.beginScope();
        Symbol testSymbol3 = symbolTable.push("test3", new Declaration(Type.STRING));
        symbolTable.endScope();
        assertTrue(symbolTable.getScope() == 0);
        symbolTable.clear();
    }

    @Test
    public void getScope() {
        assertTrue(symbolTable.getScope() == 0);
        symbolTable.beginScope();
        assertTrue(symbolTable.getScope() == 1);
        symbolTable.endScope();
        assertTrue(symbolTable.getScope() == 0);
        symbolTable.clear();
    }

    @Test
    public void clear() {
        symbolTable.push("teststring", new Declaration(Type.STRING));
        symbolTable.push("testint", new Declaration(Type.INT));
        symbolTable.beginScope();
        symbolTable.clear();
        assertTrue(symbolTable.getScope() == 0);
    }
}