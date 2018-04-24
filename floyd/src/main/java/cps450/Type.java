/*
Abraham Steenhoek
CPS 450: Phase 5
4/19/20

Type.java

Class: Type
    - The Type class contains all valid types supported in the Floyd language
    - Contains a Hashmap holding all of the user-defined types, along with the primitive types, in a Floyd program
*/
package cps450;

import java.util.HashMap;

public class Type {
    private ClassDecl classDecl;
    // default supported types
    public static final Type
            ERROR = new Type("<error>"),
            INT = new Type("int"),
            BOOLEAN = new Type("boolean"),
            STRING = new Type("string"),
            VOID = new Type("void"),
            NULL = new Type("null"),
            CLASS = new Type("class");

    // typeMap holds all supported types in a container
    // stored in a HashMap for error checking (use of unsupported types)
    public static HashMap<String, Type> typeMap;

    static
    {
        //typeMap.put("null", Type.NULL);
        //typeMap.put("string", Type.STRING);
        typeMap.put("int", Type.INT);
        typeMap.put("boolean", Type.BOOLEAN);
    }

    private String name;

    // used for user-defined types
    public Type(String name) {
        if (typeMap == null)
            typeMap = new HashMap<String, Type>();
        if(name.equals("string"))
            name = "String";
        this.name = name;

        // insert user-defined type into typeMap for error-checking later
        typeMap.put(name, this);
    }

    public Type(ClassDecl decl) {
        this.classDecl = decl;
    }

    public static Type createType(String typeName) {
        Type type = new Type(typeName);
        typeMap.put(typeName, type);

        return type;
    }

    public static Type getTypeForName(String className) {
        if(className.equals("string"))
            return Type.STRING;
        return typeMap.get(className);
    }

    public void setClassDecl(ClassDecl classDecl) {
        this.classDecl = classDecl;
    }

    public ClassDecl getClassDecl() {
        return classDecl;
    }

    public String getText() {
        return name;
    }
    public boolean equals(Type type) {
        return type.getText().toLowerCase().equals(this.name.toLowerCase());
    }
}