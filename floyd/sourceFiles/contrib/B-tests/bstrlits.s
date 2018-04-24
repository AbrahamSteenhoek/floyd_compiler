.data
	.comm _out, 4, 4
	.comm _in, 4, 4
	pushl  $8
	pushl  $1
	call   calloc
	addl   $8, %esp
	movl   %eax, _out
	pushl  $8
	pushl  $1
	call   calloc
	addl   $8, %esp
	movl   %eax, _in
	.text
.global main
# -------------------------
# stdlib.floyd:8: toString():stringis
# -------------------------
Oyd_toString:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:10: toString:="none"
# -------------------------
# AssignStmt
# -------------------------
# stdlib.floyd:10: string lit
# -------------------------
.data
stringlit0:
.string "none"
.text
	pushl  $stringlit0
	call   string_fromlit
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:toString is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:20: char:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:21: next:CharNode
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:23: init(initChar:int):CharNodeis
# -------------------------
CharNode_init:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:25: char:=initChar
# -------------------------
# AssignStmt
	pushl  12(%ebp)
	popl   %eax
	movl   8(%ebp), %ebx
	movl   %eax, 8(%ebx)
# -------------------------
# stdlib.floyd:26: next:=null
# -------------------------
# AssignStmt
	pushl  $0
	popl   %eax
	movl   8(%ebp), %ebx
	movl   %eax, 12(%ebx)
# -------------------------
# stdlib.floyd:27: init:=me
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	popl   %eax
# VARNAME:init is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:30: getChar():intis
# -------------------------
CharNode_getChar:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:32: getChar:=char
# -------------------------
# AssignStmt
	movl   8(%ebp), %ebx
	pushl  8(%ebx)
	popl   %eax
# VARNAME:getChar is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:35: getNext():CharNodeis
# -------------------------
CharNode_getNext:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:37: getNext:=next
# -------------------------
# AssignStmt
	movl   8(%ebp), %ebx
	pushl  12(%ebx)
	popl   %eax
# VARNAME:getNext is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:40: setNext(node:CharNode)is
# -------------------------
CharNode_setNext:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:42: next:=node
# -------------------------
# AssignStmt
	pushl  12(%ebp)
	popl   %eax
	movl   8(%ebp), %ebx
	movl   %eax, 12(%ebx)

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:54: charlist:CharNode
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:60: appendChar(char:int):Stringis
# -------------------------
String_appendChar:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:61: curnode:CharNode
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:62: node:CharNode
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:64: node:=(newCharNode).init(char)
# -------------------------
# AssignStmt
# MethodCallExpr
	pushl  $16
	pushl  $1
	call   calloc
	addl   $8, %esp
	pushl  %eax
	pushl  $64
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  12(%ebp)
	pushl  %ecx
	call   CharNode_init
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# VARNAME:node is a local var
	movl   %eax, -12(%ebp)
# -------------------------
# stdlib.floyd:66: ifcharlist=nullthen
# -------------------------
# EqualExpr -> ( charlist=null )
	movl   8(%ebp), %ebx
	pushl  8(%ebx)
	pushl  $0
	call   equals
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif0
	jmp    falseif0
trueif0:
# -------------------------
# stdlib.floyd:67: charlist:=node
# -------------------------
# AssignStmt
	pushl  -12(%ebp)
	popl   %eax
	movl   8(%ebp), %ebx
	movl   %eax, 8(%ebx)
	jmp    endif0
falseif0:
# -------------------------
# stdlib.floyd:69: curnode:=charlist
# -------------------------
# AssignStmt
	movl   8(%ebp), %ebx
	pushl  8(%ebx)
	popl   %eax
# VARNAME:curnode is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:70: loopwhilenot(curnode.getNext()=null)
# -------------------------
# LoopStmt
while0:
# EqualExpr -> ( curnode.getNext()=null )
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $70
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   CharNode_getNext
	addl   $4, %esp
	pushl  %eax
	pushl  $0
	call   equals
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody0
	jmp    endwhile0
startwhilebody0:
# -------------------------
# stdlib.floyd:71: curnode:=curnode.getNext()
# -------------------------
# AssignStmt
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $71
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   CharNode_getNext
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:curnode is a local var
	movl   %eax, -8(%ebp)
	jmp    while0
endwhile0:
# -------------------------
# stdlib.floyd:73: curnode.setNext(node)
# -------------------------
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $73
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  -12(%ebp)
	pushl  %ecx
	call   CharNode_setNext
	addl   $8, %esp
endif0:
# -------------------------
# stdlib.floyd:75: appendChar:=me
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	popl   %eax
# VARNAME:appendChar is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $12, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:78: catIntHelper(num:int;str:String)is
# -------------------------
String_catIntHelper:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:79: digit:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:81: digit:=num-(num/10)*10
# -------------------------
# AssignStmt
	pushl  12(%ebp)
	pushl  12(%ebp)
	pushl  $10
	popl   %ebx
	popl   %eax
	movl   $0, %edx
	idiv   %ebx
	pushl  %eax
	pushl  $10
	popl   %ebx
	popl   %eax
	imul   %eax, %ebx
	pushl  %ebx
	popl   %ebx
	popl   %eax
	subl   %ebx, %eax
	pushl  %eax
	popl   %eax
# VARNAME:digit is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:82: ifnum/10>0then
# -------------------------
	pushl  12(%ebp)
	pushl  $10
	popl   %ebx
	popl   %eax
	movl   $0, %edx
	idiv   %ebx
	pushl  %eax
	pushl  $0
	call   gt
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif1
	jmp    falseif1
trueif1:
# -------------------------
# stdlib.floyd:83: catIntHelper(num/10,str)
# -------------------------
	pushl  16(%ebp)
	pushl  12(%ebp)
	pushl  $10
	popl   %ebx
	popl   %eax
	movl   $0, %edx
	idiv   %ebx
	pushl  %eax
	pushl  8(%ebp)
	call   String_catIntHelper
	addl   $12, %esp
	pushl  %eax
	popl   %eax
	jmp    endif1
falseif1:
endif1:
# -------------------------
# stdlib.floyd:85: str.appendChar(digit+48)
# -------------------------
# MethodCallExpr
	pushl  16(%ebp)
	pushl  $85
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  -8(%ebp)
	pushl  $48
	popl   %ebx
	popl   %eax
	addl   %ebx, %eax
	pushl  %eax
	pushl  %ecx
	call   String_appendChar
	addl   $8, %esp

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $8, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:88: getCharlist():CharNodeis
# -------------------------
String_getCharlist:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:90: getCharlist:=charlist
# -------------------------
# AssignStmt
	movl   8(%ebp), %ebx
	pushl  8(%ebx)
	popl   %eax
# VARNAME:getCharlist is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:98: copy():Stringis
# -------------------------
String_copy:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:99: newstr:String
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:100: curNode:CharNode
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:102: newstr:=newString
# -------------------------
# AssignStmt
	pushl  $12
	pushl  $1
	call   calloc
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# VARNAME:newstr is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:104: curNode:=charlist
# -------------------------
# AssignStmt
	movl   8(%ebp), %ebx
	pushl  8(%ebx)
	popl   %eax
# VARNAME:curNode is a local var
	movl   %eax, -12(%ebp)
# -------------------------
# stdlib.floyd:105: loopwhilenot(curNode=null)
# -------------------------
# LoopStmt
while1:
# EqualExpr -> ( curNode=null )
	pushl  -12(%ebp)
	pushl  $0
	call   equals
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody1
	jmp    endwhile1
startwhilebody1:
# -------------------------
# stdlib.floyd:106: newstr.appendChar(curNode.getChar())
# -------------------------
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $106
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
# MethodCallExpr
	pushl  -12(%ebp)
	pushl  $106
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   CharNode_getChar
	addl   $4, %esp
	pushl  %eax
	pushl  %ecx
	call   String_appendChar
	addl   $8, %esp
# -------------------------
# stdlib.floyd:107: curNode:=curNode.getNext()
# -------------------------
# AssignStmt
# MethodCallExpr
	pushl  -12(%ebp)
	pushl  $107
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   CharNode_getNext
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:curNode is a local var
	movl   %eax, -12(%ebp)
	jmp    while1
endwhile1:
# -------------------------
# stdlib.floyd:110: copy:=newstr
# -------------------------
# AssignStmt
	pushl  -8(%ebp)
	popl   %eax
# VARNAME:copy is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $12, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:114: cat(str:String):Stringis
# -------------------------
String_cat:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:115: newstr:String
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:116: curNode:CharNode
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:119: newstr:=copy()
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	call   String_copy
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:newstr is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:122: curNode:=str.getCharlist()
# -------------------------
# AssignStmt
# MethodCallExpr
	pushl  12(%ebp)
	pushl  $122
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   String_getCharlist
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:curNode is a local var
	movl   %eax, -12(%ebp)
# -------------------------
# stdlib.floyd:123: loopwhilenot(curNode=null)
# -------------------------
# LoopStmt
while2:
# EqualExpr -> ( curNode=null )
	pushl  -12(%ebp)
	pushl  $0
	call   equals
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody2
	jmp    endwhile2
startwhilebody2:
# -------------------------
# stdlib.floyd:124: newstr.appendChar(curNode.getChar())
# -------------------------
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $124
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
# MethodCallExpr
	pushl  -12(%ebp)
	pushl  $124
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   CharNode_getChar
	addl   $4, %esp
	pushl  %eax
	pushl  %ecx
	call   String_appendChar
	addl   $8, %esp
# -------------------------
# stdlib.floyd:125: curNode:=curNode.getNext()
# -------------------------
# AssignStmt
# MethodCallExpr
	pushl  -12(%ebp)
	pushl  $125
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   CharNode_getNext
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:curNode is a local var
	movl   %eax, -12(%ebp)
	jmp    while2
endwhile2:
# -------------------------
# stdlib.floyd:128: cat:=newstr
# -------------------------
# AssignStmt
	pushl  -8(%ebp)
	popl   %eax
# VARNAME:cat is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $12, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:133: catChar(ch:int):Stringis
# -------------------------
String_catChar:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:134: newstr:String
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:136: newstr:=copy()
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	call   String_copy
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:newstr is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:138: newstr.appendChar(ch)
# -------------------------
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $138
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  12(%ebp)
	pushl  %ecx
	call   String_appendChar
	addl   $8, %esp
# -------------------------
# stdlib.floyd:140: catChar:=newstr
# -------------------------
# AssignStmt
	pushl  -8(%ebp)
	popl   %eax
# VARNAME:catChar is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $8, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:144: catInt(num:int):Stringis
# -------------------------
String_catInt:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:145: result:String
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:146: i:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:149: ifnot(num=0)then
# -------------------------
# EqualExpr -> ( num=0 )
	pushl  12(%ebp)
	pushl  $0
	call   equals
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif2
	jmp    falseif2
trueif2:
# -------------------------
# stdlib.floyd:150: result:=newString
# -------------------------
# AssignStmt
	pushl  $12
	pushl  $1
	call   calloc
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# VARNAME:result is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:152: if(0>num)then
# -------------------------
	pushl  $0
	pushl  12(%ebp)
	call   gt
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif3
	jmp    falseif3
trueif3:
# -------------------------
# stdlib.floyd:153: result.catChar(45)
# -------------------------
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $153
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  $45
	pushl  %ecx
	call   String_catChar
	addl   $8, %esp
# -------------------------
# stdlib.floyd:154: num:=-num
# -------------------------
# AssignStmt
	pushl  12(%ebp)
# neg oper
	popl   %eax
	neg    %eax
	pushl  %eax
	popl   %eax
# VARNAME:num is a local var
	movl   %eax, 12(%ebp)
	jmp    endif3
falseif3:
endif3:
# -------------------------
# stdlib.floyd:158: catIntHelper(num,result)
# -------------------------
	pushl  -8(%ebp)
	pushl  12(%ebp)
	pushl  8(%ebp)
	call   String_catIntHelper
	addl   $12, %esp
	pushl  %eax
	popl   %eax
	jmp    endif2
falseif2:
# -------------------------
# stdlib.floyd:161: result:=(newString).catChar(48)
# -------------------------
# AssignStmt
# MethodCallExpr
	pushl  $12
	pushl  $1
	call   calloc
	addl   $8, %esp
	pushl  %eax
	pushl  $161
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  $48
	pushl  %ecx
	call   String_catChar
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# VARNAME:result is a local var
	movl   %eax, -8(%ebp)
endif2:
# -------------------------
# stdlib.floyd:164: catInt:=cat(result)
# -------------------------
# AssignStmt
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   String_cat
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# VARNAME:catInt is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $12, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:169: charAt(index:int):intis
# -------------------------
String_charAt:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:170: curNode:CharNode
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:172: curNode:=charlist
# -------------------------
# AssignStmt
	movl   8(%ebp), %ebx
	pushl  8(%ebx)
	popl   %eax
# VARNAME:curNode is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:173: loopwhileindex>0andnot(curNode=null)
# -------------------------
# LoopStmt
while3:
# AndExpr -> ( index>0andnot(curNode=null) )
	pushl  12(%ebp)
	pushl  $0
	call   gt
	addl   $8, %esp
	pushl  %eax
# EqualExpr -> ( curNode=null )
	pushl  -8(%ebp)
	pushl  $0
	call   equals
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %ebx
	popl   %eax
	and    %ebx, %eax
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody3
	jmp    endwhile3
startwhilebody3:
# -------------------------
# stdlib.floyd:174: index:=index-1
# -------------------------
# AssignStmt
	pushl  12(%ebp)
	pushl  $1
	popl   %ebx
	popl   %eax
	subl   %ebx, %eax
	pushl  %eax
	popl   %eax
# VARNAME:index is a local var
	movl   %eax, 12(%ebp)
# -------------------------
# stdlib.floyd:175: curNode:=curNode.getNext()
# -------------------------
# AssignStmt
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $175
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   CharNode_getNext
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:curNode is a local var
	movl   %eax, -8(%ebp)
	jmp    while3
endwhile3:
# -------------------------
# stdlib.floyd:178: ifnot(curNode=null)then
# -------------------------
# EqualExpr -> ( curNode=null )
	pushl  -8(%ebp)
	pushl  $0
	call   equals
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif4
	jmp    falseif4
trueif4:
# -------------------------
# stdlib.floyd:179: charAt:=curNode.getChar()
# -------------------------
# AssignStmt
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $179
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   CharNode_getChar
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:charAt is a local var
	movl   %eax, -4(%ebp)
	jmp    endif4
falseif4:
# -------------------------
# stdlib.floyd:181: charAt:=-1
# -------------------------
# AssignStmt
	pushl  $1
# neg oper
	popl   %eax
	neg    %eax
	pushl  %eax
	popl   %eax
# VARNAME:charAt is a local var
	movl   %eax, -4(%ebp)
endif4:

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $8, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:186: length():intis
# -------------------------
String_length:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:187: i:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:188: curNode:CharNode
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:190: curNode:=charlist
# -------------------------
# AssignStmt
	movl   8(%ebp), %ebx
	pushl  8(%ebx)
	popl   %eax
# VARNAME:curNode is a local var
	movl   %eax, -12(%ebp)
# -------------------------
# stdlib.floyd:191: i:=0
# -------------------------
# AssignStmt
	pushl  $0
	popl   %eax
# VARNAME:i is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:192: loopwhilenot(curNode=null)
# -------------------------
# LoopStmt
while4:
# EqualExpr -> ( curNode=null )
	pushl  -12(%ebp)
	pushl  $0
	call   equals
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody4
	jmp    endwhile4
startwhilebody4:
# -------------------------
# stdlib.floyd:193: i:=i+1
# -------------------------
# AssignStmt
	pushl  -8(%ebp)
	pushl  $1
	popl   %ebx
	popl   %eax
	addl   %ebx, %eax
	pushl  %eax
	popl   %eax
# VARNAME:i is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:194: curNode:=curNode.getNext()
# -------------------------
# AssignStmt
# MethodCallExpr
	pushl  -12(%ebp)
	pushl  $194
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   CharNode_getNext
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:curNode is a local var
	movl   %eax, -12(%ebp)
	jmp    while4
endwhile4:
# -------------------------
# stdlib.floyd:196: length:=i
# -------------------------
# AssignStmt
	pushl  -8(%ebp)
	popl   %eax
# VARNAME:length is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $12, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:200: eq(str:String):booleanis
# -------------------------
String_eq:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:201: i:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:202: len:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:204: len:=length()
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	call   String_length
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:len is a local var
	movl   %eax, -12(%ebp)
# -------------------------
# stdlib.floyd:205: ifnot(len=str.length())then
# -------------------------
# EqualExpr -> ( len=str.length() )
	pushl  -12(%ebp)
# MethodCallExpr
	pushl  12(%ebp)
	pushl  $205
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   String_length
	addl   $4, %esp
	pushl  %eax
	call   equals
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif5
	jmp    falseif5
trueif5:
# -------------------------
# stdlib.floyd:206: eq:=false
# -------------------------
# AssignStmt
	pushl  $0
	popl   %eax
# VARNAME:eq is a local var
	movl   %eax, -4(%ebp)
	jmp    endif5
falseif5:
# -------------------------
# stdlib.floyd:208: i:=0
# -------------------------
# AssignStmt
	pushl  $0
	popl   %eax
# VARNAME:i is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:209: loopwhilenot(i>=len)and(charAt(i)=str.charAt(i))
# -------------------------
# LoopStmt
while5:
# AndExpr -> ( not(i>=len)and(charAt(i)=str.charAt(i)) )
	pushl  -8(%ebp)
	pushl  -12(%ebp)
	call   gte
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
# EqualExpr -> ( charAt(i)=str.charAt(i) )
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   String_charAt
	addl   $8, %esp
	pushl  %eax
# MethodCallExpr
	pushl  12(%ebp)
	pushl  $209
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  -8(%ebp)
	pushl  %ecx
	call   String_charAt
	addl   $8, %esp
	pushl  %eax
	call   equals
	addl   $8, %esp
	pushl  %eax
	popl   %ebx
	popl   %eax
	and    %ebx, %eax
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody5
	jmp    endwhile5
startwhilebody5:
# -------------------------
# stdlib.floyd:210: i:=i+1
# -------------------------
# AssignStmt
	pushl  -8(%ebp)
	pushl  $1
	popl   %ebx
	popl   %eax
	addl   %ebx, %eax
	pushl  %eax
	popl   %eax
# VARNAME:i is a local var
	movl   %eax, -8(%ebp)
	jmp    while5
endwhile5:
# -------------------------
# stdlib.floyd:212: eq:=(i=len)
# -------------------------
# AssignStmt
# EqualExpr -> ( i=len )
	pushl  -8(%ebp)
	pushl  -12(%ebp)
	call   equals
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# VARNAME:eq is a local var
	movl   %eax, -4(%ebp)
endif5:

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $12, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:216: gt(str:String):booleanis
# -------------------------
String_gt:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:217: i:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:218: len:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:220: len:=length()
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	call   String_length
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:len is a local var
	movl   %eax, -12(%ebp)
# -------------------------
# stdlib.floyd:221: i:=0
# -------------------------
# AssignStmt
	pushl  $0
	popl   %eax
# VARNAME:i is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:222: loopwhilenot(i>=len)andnot(i>=str.length())and(charAt(i)=str.charAt(i))
# -------------------------
# LoopStmt
while6:
# AndExpr -> ( not(i>=len)andnot(i>=str.length())and(charAt(i)=str.charAt(i)) )
# AndExpr -> ( not(i>=len)andnot(i>=str.length()) )
	pushl  -8(%ebp)
	pushl  -12(%ebp)
	call   gte
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	pushl  -8(%ebp)
# MethodCallExpr
	pushl  12(%ebp)
	pushl  $222
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   String_length
	addl   $4, %esp
	pushl  %eax
	call   gte
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %ebx
	popl   %eax
	and    %ebx, %eax
	pushl  %eax
# EqualExpr -> ( charAt(i)=str.charAt(i) )
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   String_charAt
	addl   $8, %esp
	pushl  %eax
# MethodCallExpr
	pushl  12(%ebp)
	pushl  $222
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  -8(%ebp)
	pushl  %ecx
	call   String_charAt
	addl   $8, %esp
	pushl  %eax
	call   equals
	addl   $8, %esp
	pushl  %eax
	popl   %ebx
	popl   %eax
	and    %ebx, %eax
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody6
	jmp    endwhile6
startwhilebody6:
# -------------------------
# stdlib.floyd:223: i:=i+1
# -------------------------
# AssignStmt
	pushl  -8(%ebp)
	pushl  $1
	popl   %ebx
	popl   %eax
	addl   %ebx, %eax
	pushl  %eax
	popl   %eax
# VARNAME:i is a local var
	movl   %eax, -8(%ebp)
	jmp    while6
endwhile6:
# -------------------------
# stdlib.floyd:225: if(i>=len)or(i>=str.length())then
# -------------------------
# OrExpr -> ( (i>=len)or(i>=str.length()) )
	pushl  -8(%ebp)
	pushl  -12(%ebp)
	call   gte
	addl   $8, %esp
	pushl  %eax
	pushl  -8(%ebp)
# MethodCallExpr
	pushl  12(%ebp)
	pushl  $225
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   String_length
	addl   $4, %esp
	pushl  %eax
	call   gte
	addl   $8, %esp
	pushl  %eax
	popl   %ebx
	popl   %eax
	or     %ebx, %eax
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif6
	jmp    falseif6
trueif6:
# -------------------------
# stdlib.floyd:226: gt:=len>str.length()
# -------------------------
# AssignStmt
	pushl  -12(%ebp)
# MethodCallExpr
	pushl  12(%ebp)
	pushl  $226
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   String_length
	addl   $4, %esp
	pushl  %eax
	call   gt
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# VARNAME:gt is a local var
	movl   %eax, -4(%ebp)
	jmp    endif6
falseif6:
# -------------------------
# stdlib.floyd:228: gt:=(charAt(i)>str.charAt(i))
# -------------------------
# AssignStmt
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   String_charAt
	addl   $8, %esp
	pushl  %eax
# MethodCallExpr
	pushl  12(%ebp)
	pushl  $228
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  -8(%ebp)
	pushl  %ecx
	call   String_charAt
	addl   $8, %esp
	pushl  %eax
	call   gt
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# VARNAME:gt is a local var
	movl   %eax, -4(%ebp)
endif6:

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $12, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:233: gteq(str:String):booleanis
# -------------------------
String_gteq:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:235: gteq:=gt(str)oreq(str)
# -------------------------
# AssignStmt
# OrExpr -> ( gt(str)oreq(str) )
	pushl  12(%ebp)
	pushl  8(%ebp)
	call   String_gt
	addl   $8, %esp
	pushl  %eax
	pushl  12(%ebp)
	pushl  8(%ebp)
	call   String_eq
	addl   $8, %esp
	pushl  %eax
	popl   %ebx
	popl   %eax
	or     %ebx, %eax
	pushl  %eax
	popl   %eax
# VARNAME:gteq is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:239: toString():stringis
# -------------------------
String_toString:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:241: toString:=me
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	popl   %eax
# VARNAME:toString is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:259: readline():Stringis
# -------------------------
Reader_readline:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:260: char:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:261: s:String
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:263: s:=newString
# -------------------------
# AssignStmt
	pushl  $12
	pushl  $1
	call   calloc
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# VARNAME:s is a local var
	movl   %eax, -12(%ebp)
# -------------------------
# stdlib.floyd:265: char:=io_read()
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	call   Reader_io_read
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:char is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:266: loopwhilenot(char=10)
# -------------------------
# LoopStmt
while7:
# EqualExpr -> ( char=10 )
	pushl  -8(%ebp)
	pushl  $10
	call   equals
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody7
	jmp    endwhile7
startwhilebody7:
# -------------------------
# stdlib.floyd:267: ifnot(char=13)then
# -------------------------
# EqualExpr -> ( char=13 )
	pushl  -8(%ebp)
	pushl  $13
	call   equals
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif7
	jmp    falseif7
trueif7:
# -------------------------
# stdlib.floyd:268: s.appendChar(char)
# -------------------------
# MethodCallExpr
	pushl  -12(%ebp)
	pushl  $268
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  -8(%ebp)
	pushl  %ecx
	call   String_appendChar
	addl   $8, %esp
	jmp    endif7
falseif7:
endif7:
# -------------------------
# stdlib.floyd:270: char:=io_read()
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	call   Reader_io_read
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:char is a local var
	movl   %eax, -8(%ebp)
	jmp    while7
endwhile7:
# -------------------------
# stdlib.floyd:273: readline:=s
# -------------------------
# AssignStmt
	pushl  -12(%ebp)
	popl   %eax
# VARNAME:readline is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $12, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:280: readint():intis
# -------------------------
Reader_readint:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:281: s:String
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:282: i:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:283: num:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:284: len:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:285: mult:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:287: s:=readline()
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	call   Reader_readline
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:s is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:288: ifs.length()>0then
# -------------------------
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $288
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   String_length
	addl   $4, %esp
	pushl  %eax
	pushl  $0
	call   gt
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif8
	jmp    falseif8
trueif8:
# -------------------------
# stdlib.floyd:289: ifs.charAt(0)=45then
# -------------------------
# EqualExpr -> ( s.charAt(0)=45 )
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $289
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  $0
	pushl  %ecx
	call   String_charAt
	addl   $8, %esp
	pushl  %eax
	pushl  $45
	call   equals
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif9
	jmp    falseif9
trueif9:
# -------------------------
# stdlib.floyd:290: mult:=-1
# -------------------------
# AssignStmt
	pushl  $1
# neg oper
	popl   %eax
	neg    %eax
	pushl  %eax
	popl   %eax
# VARNAME:mult is a local var
	movl   %eax, -24(%ebp)
# -------------------------
# stdlib.floyd:291: i:=1
# -------------------------
# AssignStmt
	pushl  $1
	popl   %eax
# VARNAME:i is a local var
	movl   %eax, -12(%ebp)
	jmp    endif9
falseif9:
# -------------------------
# stdlib.floyd:293: mult:=1
# -------------------------
# AssignStmt
	pushl  $1
	popl   %eax
# VARNAME:mult is a local var
	movl   %eax, -24(%ebp)
# -------------------------
# stdlib.floyd:294: i:=0
# -------------------------
# AssignStmt
	pushl  $0
	popl   %eax
# VARNAME:i is a local var
	movl   %eax, -12(%ebp)
endif9:
# -------------------------
# stdlib.floyd:297: num:=0
# -------------------------
# AssignStmt
	pushl  $0
	popl   %eax
# VARNAME:num is a local var
	movl   %eax, -16(%ebp)
# -------------------------
# stdlib.floyd:298: len:=s.length()
# -------------------------
# AssignStmt
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $298
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   String_length
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:len is a local var
	movl   %eax, -20(%ebp)
# -------------------------
# stdlib.floyd:299: loopwhilenot(i>=len)
# -------------------------
# LoopStmt
while8:
	pushl  -12(%ebp)
	pushl  -20(%ebp)
	call   gte
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody8
	jmp    endwhile8
startwhilebody8:
# -------------------------
# stdlib.floyd:300: num:=num*10+(s.charAt(i)-48)
# -------------------------
# AssignStmt
	pushl  -16(%ebp)
	pushl  $10
	popl   %ebx
	popl   %eax
	imul   %eax, %ebx
	pushl  %ebx
# MethodCallExpr
	pushl  -8(%ebp)
	pushl  $300
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  -12(%ebp)
	pushl  %ecx
	call   String_charAt
	addl   $8, %esp
	pushl  %eax
	pushl  $48
	popl   %ebx
	popl   %eax
	subl   %ebx, %eax
	pushl  %eax
	popl   %ebx
	popl   %eax
	addl   %ebx, %eax
	pushl  %eax
	popl   %eax
# VARNAME:num is a local var
	movl   %eax, -16(%ebp)
# -------------------------
# stdlib.floyd:301: i:=i+1
# -------------------------
# AssignStmt
	pushl  -12(%ebp)
	pushl  $1
	popl   %ebx
	popl   %eax
	addl   %ebx, %eax
	pushl  %eax
	popl   %eax
# VARNAME:i is a local var
	movl   %eax, -12(%ebp)
	jmp    while8
endwhile8:
# -------------------------
# stdlib.floyd:304: readint:=num*mult
# -------------------------
# AssignStmt
	pushl  -16(%ebp)
	pushl  -24(%ebp)
	popl   %ebx
	popl   %eax
	imul   %eax, %ebx
	pushl  %ebx
	popl   %eax
# VARNAME:readint is a local var
	movl   %eax, -4(%ebp)
	jmp    endif8
falseif8:
# -------------------------
# stdlib.floyd:306: readint:=-1
# -------------------------
# AssignStmt
	pushl  $1
# neg oper
	popl   %eax
	neg    %eax
	pushl  %eax
	popl   %eax
# VARNAME:readint is a local var
	movl   %eax, -4(%ebp)
endif8:

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $24, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:324: writechar(char:int):Writeris
# -------------------------
Writer_writechar:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:326: io_write(char)
# -------------------------
	pushl  12(%ebp)
	pushl  8(%ebp)
	call   Writer_io_write
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# stdlib.floyd:327: writechar:=me
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	popl   %eax
# VARNAME:writechar is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:332: writeintHelper(num:int)is
# -------------------------
Writer_writeintHelper:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:333: digit:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:335: digit:=num-(num/10)*10
# -------------------------
# AssignStmt
	pushl  12(%ebp)
	pushl  12(%ebp)
	pushl  $10
	popl   %ebx
	popl   %eax
	movl   $0, %edx
	idiv   %ebx
	pushl  %eax
	pushl  $10
	popl   %ebx
	popl   %eax
	imul   %eax, %ebx
	pushl  %ebx
	popl   %ebx
	popl   %eax
	subl   %ebx, %eax
	pushl  %eax
	popl   %eax
# VARNAME:digit is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:336: ifnum/10>0then
# -------------------------
	pushl  12(%ebp)
	pushl  $10
	popl   %ebx
	popl   %eax
	movl   $0, %edx
	idiv   %ebx
	pushl  %eax
	pushl  $0
	call   gt
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif10
	jmp    falseif10
trueif10:
# -------------------------
# stdlib.floyd:337: writeintHelper(num/10)
# -------------------------
	pushl  12(%ebp)
	pushl  $10
	popl   %ebx
	popl   %eax
	movl   $0, %edx
	idiv   %ebx
	pushl  %eax
	pushl  8(%ebp)
	call   Writer_writeintHelper
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	jmp    endif10
falseif10:
endif10:
# -------------------------
# stdlib.floyd:339: io_write(digit+48)
# -------------------------
	pushl  -8(%ebp)
	pushl  $48
	popl   %ebx
	popl   %eax
	addl   %ebx, %eax
	pushl  %eax
	pushl  8(%ebp)
	call   Writer_io_write
	addl   $8, %esp
	pushl  %eax
	popl   %eax

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $8, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:343: writeint(num:int):Writeris
# -------------------------
Writer_writeint:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:345: if(num=0)then
# -------------------------
# EqualExpr -> ( num=0 )
	pushl  12(%ebp)
	pushl  $0
	call   equals
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif11
	jmp    falseif11
trueif11:
# -------------------------
# stdlib.floyd:346: io_write(48)
# -------------------------
	pushl  $48
	pushl  8(%ebp)
	call   Writer_io_write
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	jmp    endif11
falseif11:
# -------------------------
# stdlib.floyd:348: ifnot(num>=0)then
# -------------------------
	pushl  12(%ebp)
	pushl  $0
	call   gte
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif12
	jmp    falseif12
trueif12:
# -------------------------
# stdlib.floyd:349: io_write(45)
# -------------------------
	pushl  $45
	pushl  8(%ebp)
	call   Writer_io_write
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# stdlib.floyd:350: num:=-num
# -------------------------
# AssignStmt
	pushl  12(%ebp)
# neg oper
	popl   %eax
	neg    %eax
	pushl  %eax
	popl   %eax
# VARNAME:num is a local var
	movl   %eax, 12(%ebp)
	jmp    endif12
falseif12:
endif12:
# -------------------------
# stdlib.floyd:352: writeintHelper(num)
# -------------------------
	pushl  12(%ebp)
	pushl  8(%ebp)
	call   Writer_writeintHelper
	addl   $8, %esp
	pushl  %eax
	popl   %eax
endif11:
# -------------------------
# stdlib.floyd:355: io_write(13)
# -------------------------
	pushl  $13
	pushl  8(%ebp)
	call   Writer_io_write
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# stdlib.floyd:356: io_write(10)
# -------------------------
	pushl  $10
	pushl  8(%ebp)
	call   Writer_io_write
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# stdlib.floyd:358: writeint:=me
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	popl   %eax
# VARNAME:writeint is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:362: write(str:String):Writeris
# -------------------------
Writer_write:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:363: i:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:364: len:int
# -------------------------
	pushl  $0
# -------------------------
# stdlib.floyd:366: len:=str.length()
# -------------------------
# AssignStmt
# MethodCallExpr
	pushl  12(%ebp)
	pushl  $366
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  %ecx
	call   String_length
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:len is a local var
	movl   %eax, -12(%ebp)
# -------------------------
# stdlib.floyd:367: i:=0
# -------------------------
# AssignStmt
	pushl  $0
	popl   %eax
# VARNAME:i is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# stdlib.floyd:368: loopwhilenot(i>=len)
# -------------------------
# LoopStmt
while9:
	pushl  -8(%ebp)
	pushl  -12(%ebp)
	call   gte
	addl   $8, %esp
	pushl  %eax
# not oper
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody9
	jmp    endwhile9
startwhilebody9:
# -------------------------
# stdlib.floyd:369: io_write(str.charAt(i))
# -------------------------
# MethodCallExpr
	pushl  12(%ebp)
	pushl  $369
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  -8(%ebp)
	pushl  %ecx
	call   String_charAt
	addl   $8, %esp
	pushl  %eax
	pushl  8(%ebp)
	call   Writer_io_write
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# stdlib.floyd:370: i:=i+1
# -------------------------
# AssignStmt
	pushl  -8(%ebp)
	pushl  $1
	popl   %ebx
	popl   %eax
	addl   %ebx, %eax
	pushl  %eax
	popl   %eax
# VARNAME:i is a local var
	movl   %eax, -8(%ebp)
	jmp    while9
endwhile9:
# -------------------------
# stdlib.floyd:373: write:=me
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	popl   %eax
# VARNAME:write is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $12, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# stdlib.floyd:377: writeln(str:String):Writeris
# -------------------------
Writer_writeln:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# stdlib.floyd:379: write(str)
# -------------------------
	pushl  12(%ebp)
	pushl  8(%ebp)
	call   Writer_write
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# stdlib.floyd:380: io_write(13)
# -------------------------
	pushl  $13
	pushl  8(%ebp)
	call   Writer_io_write
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# stdlib.floyd:381: io_write(10)
# -------------------------
	pushl  $10
	pushl  8(%ebp)
	call   Writer_io_write
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# stdlib.floyd:382: writeln:=me
# -------------------------
# AssignStmt
	pushl  8(%ebp)
	popl   %eax
# VARNAME:writeln is a local var
	movl   %eax, -4(%ebp)

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# contrib\B-tests\bstrlits.floyd:6: s:String
# -------------------------
	pushl  $0
# -------------------------
# contrib\B-tests\bstrlits.floyd:8: print(q:String):Stringis
# -------------------------
Bstrlits_print:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# contrib\B-tests\bstrlits.floyd:10: out.write("q = ".cat(q).cat("\n"))
# -------------------------
# MethodCallExpr
	pushl  _out
	popl   %ecx
# MethodCallExpr
# MethodCallExpr
# -------------------------
# contrib\B-tests\bstrlits.floyd:10: string lit
# -------------------------
.data
stringlit1:
.string "q = "
.text
	pushl  $stringlit1
	call   string_fromlit
	addl   $4, %esp
	pushl  %eax
	pushl  $10
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
	pushl  12(%ebp)
	pushl  %ecx
	call   String_cat
	addl   $8, %esp
	pushl  %eax
	pushl  $10
	call   nullpointertest
	addl   $4, %esp
	popl   %ecx
# -------------------------
# contrib\B-tests\bstrlits.floyd:10: string lit
# -------------------------
.data
stringlit2:
.string "\n"
.text
	pushl  $stringlit2
	call   string_fromlit
	addl   $4, %esp
	pushl  %eax
	pushl  %ecx
	call   String_cat
	addl   $8, %esp
	pushl  %eax
	pushl  %ecx
	call   Writer_write
	addl   $8, %esp

# Method Postlude
	movl   -4(%ebp), %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# contrib\B-tests\bstrlits.floyd:13: start()is
# -------------------------
Bstrlits_start:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# contrib\B-tests\bstrlits.floyd:14: s:String
# -------------------------
	pushl  $0
# -------------------------
# contrib\B-tests\bstrlits.floyd:16: s:="This is a test."
# -------------------------
# AssignStmt
# -------------------------
# contrib\B-tests\bstrlits.floyd:16: string lit
# -------------------------
.data
stringlit3:
.string "This is a test."
.text
	pushl  $stringlit3
	call   string_fromlit
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:s is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# contrib\B-tests\bstrlits.floyd:17: print(s)
# -------------------------
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   Bstrlits_print
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# contrib\B-tests\bstrlits.floyd:18: s:="This is a\ttab."
# -------------------------
# AssignStmt
# -------------------------
# contrib\B-tests\bstrlits.floyd:18: string lit
# -------------------------
.data
stringlit4:
.string "This is a\ttab."
.text
	pushl  $stringlit4
	call   string_fromlit
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:s is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# contrib\B-tests\bstrlits.floyd:19: print(s)
# -------------------------
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   Bstrlits_print
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# contrib\B-tests\bstrlits.floyd:20: s:="This is a\rcarriage return."
# -------------------------
# AssignStmt
# -------------------------
# contrib\B-tests\bstrlits.floyd:20: string lit
# -------------------------
.data
stringlit5:
.string "This is a\rcarriage return."
.text
	pushl  $stringlit5
	call   string_fromlit
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:s is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# contrib\B-tests\bstrlits.floyd:21: print(s)
# -------------------------
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   Bstrlits_print
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# contrib\B-tests\bstrlits.floyd:22: s:="This is a\nnewline."
# -------------------------
# AssignStmt
# -------------------------
# contrib\B-tests\bstrlits.floyd:22: string lit
# -------------------------
.data
stringlit6:
.string "This is a\nnewline."
.text
	pushl  $stringlit6
	call   string_fromlit
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:s is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# contrib\B-tests\bstrlits.floyd:23: print(s)
# -------------------------
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   Bstrlits_print
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# contrib\B-tests\bstrlits.floyd:24: s:="This is a\fform feed."
# -------------------------
# AssignStmt
# -------------------------
# contrib\B-tests\bstrlits.floyd:24: string lit
# -------------------------
.data
stringlit7:
.string "This is a\fform feed."
.text
	pushl  $stringlit7
	call   string_fromlit
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:s is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# contrib\B-tests\bstrlits.floyd:25: print(s)
# -------------------------
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   Bstrlits_print
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# contrib\B-tests\bstrlits.floyd:26: s:="This is a\\backslash."
# -------------------------
# AssignStmt
# -------------------------
# contrib\B-tests\bstrlits.floyd:26: string lit
# -------------------------
.data
stringlit8:
.string "This is a\\backslash."
.text
	pushl  $stringlit8
	call   string_fromlit
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:s is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# contrib\B-tests\bstrlits.floyd:27: print(s)
# -------------------------
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   Bstrlits_print
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# contrib\B-tests\bstrlits.floyd:28: s:="This is a \"quote\""
# -------------------------
# AssignStmt
# -------------------------
# contrib\B-tests\bstrlits.floyd:28: string lit
# -------------------------
.data
stringlit9:
.string "This is a \"quote\""
.text
	pushl  $stringlit9
	call   string_fromlit
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:s is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# contrib\B-tests\bstrlits.floyd:29: print(s)
# -------------------------
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   Bstrlits_print
	addl   $8, %esp
	pushl  %eax
	popl   %eax
# -------------------------
# contrib\B-tests\bstrlits.floyd:30: s:="This is an\011octal tab."
# -------------------------
# AssignStmt
# -------------------------
# contrib\B-tests\bstrlits.floyd:30: string lit
# -------------------------
.data
stringlit10:
.string "This is an\011octal tab."
.text
	pushl  $stringlit10
	call   string_fromlit
	addl   $4, %esp
	pushl  %eax
	popl   %eax
# VARNAME:s is a local var
	movl   %eax, -8(%ebp)
# -------------------------
# contrib\B-tests\bstrlits.floyd:31: print(s)
# -------------------------
	pushl  -8(%ebp)
	pushl  8(%ebp)
	call   Bstrlits_print
	addl   $8, %esp
	pushl  %eax
	popl   %eax

# Method Postlude
	movl   -4(%ebp), %eax
	addl   $8, %esp
	movl   %ebp, %esp
	popl   %ebp
	ret
main:
	pushl  $12
	pushl  $1
	call   calloc
	addl   $8, %esp
	pushl  %eax
	call   Bstrlits_start
	addl   $4, %esp
