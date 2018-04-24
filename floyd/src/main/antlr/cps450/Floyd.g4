grammar Floyd;

program : start;

cr
    : (NEWLINE)+
    ;

start
    : (cr)? fclass_list (cr)?
    ;

fclass_list
    : fclasses+=fclass (cr fclasses+=fclass)*
    ;

fclass returns [ClassDecl classDecl]
    : CLASS classid=IDENTIFIER (INHERITS FROM inheritid=IDENTIFIER)? IS cr
        var_decl_list
        (method_decls+=method_decl)*
        END IDENTIFIER
    ;


// start of expression production definition (it's long because of precedence rules)
expression returns [Symbol ClassSymbol]
    : arrayid=IDENTIFIER ( LBRACKET expression RBRACKET ) +         # ArrayExpr
    | e1=expression OR e2=andexpression                     # OrExpr
    | andexpression                                         # AndSubExpr
    ;
andexpression returns [Symbol ClassSymbol]
    : e1=andexpression AND e2=equalexpression   # AndExpr
    | equalexpression                           # EqSubExpr
    | gtexpression                              # GtSubExpr
    | gteexpression                             # GteSubExpr
    ;
equalexpression returns [Symbol ClassSymbol]
    : e1=equalexpression EQUALS e2=concatexpression # EqualExpr
    | concatexpression                              # EqualPass
    ;
gtexpression returns [Symbol ClassSymbol]
    : e1=gtexpression GT e2=concatexpression        # GTExpr
    | concatexpression                              # GTPass
    ;
gteexpression returns [Symbol ClassSymbol]
    : e1=gteexpression GTE e2=concatexpression      # GTEExpr
    | concatexpression                              # GTEPass
    ;
concatexpression returns [Symbol ClassSymbol]
    : e1=concatexpression CONCAT e2=plusminexpression # ConcatExpr
    | plusminexpression                                 # ConcatPass
    ;
plusminexpression returns [Symbol ClassSymbol]
    : e1=plusminexpression (addop) e2=muldivexpression # PlusMinExpr
    | muldivexpression                                          # PlusMinPass
    ;
addop
    : PLUS | MINUS
    ;
muldivexpression returns [Symbol ClassSymbol]
    : e1=muldivexpression (mulop) e2=unaryexpression      # MulDivExpr
    | unaryexpression                                         # MulDivPass
    ;
mulop
    : MUL | DIV
    ;

unaryexpression returns [Symbol ClassSymbol]
    : unary_op unaryexpression    # UnaryOpExpr
    | methodcallexpression             # UnaryPass
    ;
unary_op
    : PLUS | MINUS | NOT
    ;

methodcallexpression returns [Symbol classSymbol]
    : methodcallexpression PERIOD methid=IDENTIFIER LPAREN (expression_list)? RPAREN   # MethodCallExpr
    | methodcall                               # MethodCallExpr2
    | parenexpression                          # MethodCallPass
    ;

methodcall
    : methid=IDENTIFIER LPAREN (expression_list)? RPAREN
    ;

parenexpression returns [ Symbol ClassSymbol ]
    : LPAREN expression RPAREN    # ParenExpr
    | NEW type                    # NewExpr
    | id=IDENTIFIER               # IdExpr
    | str=STRINGLITERAL           # StringExpr
    | i=INTEGER                   # IntExpr
    | t=TRUE                      # TrueExpr
    | f=FALSE                     # FalseExpr
    | n=NULL                      # NullExpr
    | m=ME                        # MeExpr
    ;
// end of expression production definition

expression_list
    : (exprs+=expression COMMA)* exprs+=expression
    ;

method_decl returns [MethodDecl methodDecl]
    : methid=IDENTIFIER LPAREN (argument_decl_list)? RPAREN (COLON type)? IS cr
        var_decl_list
        BEGIN cr
        statement_list
        END IDENTIFIER cr
    ;

argument_decl_list returns [ArrayList<Symbol> paramSymbolList]
    : args+=argument_decl (SEMICOLON args+=argument_decl)*
    ;

argument_decl returns [Symbol paramSymbol]
    : IDENTIFIER COLON type
    ;

var_decl_list returns [ArrayList<Symbol> varList]
    : (vardecls+=var_decl)*
    ;

statement_list
    : (stmts+=statement cr)*
    ;

statement
    : assign_stmt   # AssignStatement
    | if_stmt       # IfStatement
    | loop_stmt     # LoopStatement
    | call_stmt     # CallStatement
    ;

assign_stmt
    : IDENTIFIER (LBRACKET exprs+=expression RBRACKET)* ASSIGNMENTOP rhexpr=expression
    ;

if_stmt
    : IF expression THEN cr
        if_stmtlist=statement_list
        (ELSE cr else_stmtlist=statement_list)?
      END IF
    ;

loop_stmt
    : LOOP WHILE expression cr
        statement_list
      END LOOP
    ;

call_stmt returns [Symbol classSymbol]
    : methodcallexpression PERIOD methid=IDENTIFIER LPAREN (expression_list)? RPAREN    # call_stmt1
    | methodcall                                # call_stmt2
    ;

type
    : i=INT
    | str=STRING
    | bool=BOOLEAN
    | id=IDENTIFIER
    | t=type LBRACKET (expression)? RBRACKET
    ;

var_decl returns [Symbol varSymbol]
    : varid=IDENTIFIER (COLON t=type)? (ASSIGNMENTOP expr=expression)? cr
    ;


// SKIP CHARACTERS
// added NLSKIP character here because all of these are skipped
// idea: make a SKIP character that has fragments defining specific chars that get skipped
SKIPCHAR
    : (COMMENT | WS) -> skip
    ;

// A comment begins with a tilde ~ and continues to the end of the line (NEWLINE)
fragment COMMENT
    : '~' ~[\r\n]* //'\r'? '\n'
    ;

fragment WS
   : (([ \t] +) | ('_' ( '\r' ? ) '\n') )
   ;


// keywords

BOOLEAN
    : 'boolean'
    ;
BEGIN
    : 'begin'
    ;
CLASS
    : 'class'
    ;
ELSE
    : 'else'
    ;
END
    : 'end'
    ;
FROM
    : 'from'
    ;
IF
    : 'if'
    ;
INHERITS
    : 'inherits'
    ;
INT
    : 'int'
    ;
IS
    : 'is'
    ;
LOOP
    : 'loop'
    ;
ME
    : 'me'
    ;
NEW
    : 'new'
    ;
NULL
    : 'null'
    ;
STRING
    : 'string'
    ;
THEN
    : 'then'
    ;
TRUE
    : 'true'
    ;
FALSE
    : 'false'
    ;
WHILE
    : 'while'
    ;
AND
    : 'and'
    ;
OR
    : 'or'
    ;
NOT
    : 'not'
    ;
// end of keywords


// An identifier is a sequence of letters, digits, and underscores (_) starting with an underscore or letter
IDENTIFIER
    : ( '_' | [a-zA-Z] ) ([_a-zA-Z0-9]) *
    ;

// An integer literal is any nonempty sequence of decimal digits
// negative signs are now in the unary operator production
INTEGER
    : ([0-9]) +
    ;

// a string literal is a double quote (") followed either by an escaped options or a non-quote character, and is ended with a double quote (")
STRINGLITERAL
    : ('"') ( ESCAPES | ~([\\"\n]) )* ('"')
    ;
fragment ESCAPES
    : '\\'([tnrf\\"] | [0-7][0-7][0-7])
    ;

UNTERMINATEDSTRING
    : ('"') ( '\\'. | ~([\\"\n]) )*
    ;

ILLEGALSTRING
    : ('"') ( ~(["\n]) )* ('"')
    ;


// UNICODE 10, or UNICODE 13 followed by UNICODE 10
NEWLINE
    : ([\r]?'\n')
    ;

// Predefined Operators
CONCAT
    : '&'
    ;

PLUS
   : '+'
   ;

MINUS
   : '-'
   ;

MUL
   : '*'
   ;

DIV
   : '/'
   ;

GT
   : '>'
   ;

GTE
    : '>='
    ;

EQUALS  
    : '='
    ;

// MISC Tokens
ASSIGNMENTOP
    : ':='
    ;

LPAREN
   : '('
   ;


RPAREN
   : ')'
   ;

LBRACKET
    : '['
    ;

RBRACKET
    : ']'
    ;
COMMA
    : ','
    ;
SEMICOLON
    : ';'
    ;
COLON
    : ':'
    ;
PERIOD
    : '.'
    ;

UNRECOGNIZEDCHAR
    : . -> channel(HIDDEN)
    ;