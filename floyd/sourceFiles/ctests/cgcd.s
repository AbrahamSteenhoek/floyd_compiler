.data
# -------------------------
# Line 6: x:int
# -------------------------
	.comm _x, 4, 4
# -------------------------
# Line 7: y:int
# -------------------------
	.comm _y, 4, 4
# -------------------------
# Line 8: ans:int
# -------------------------
	.comm _ans, 4, 4
	.text
.global main
# -------------------------
# Line 10: gcd(a:int;b:int):intis
# -------------------------
gcd:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# Line 12: ifb=0then
# -------------------------
	pushl  12(%ebp)
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
# Line 13: gcd:=a
# -------------------------
	pushl  8(%ebp)
	popl   %eax
	movl   %eax, -4(%ebp)
	jmp    endif0
falseif0:
# -------------------------
# Line 15: a:=gcd(b,a-(a/b)*b)
# -------------------------
	pushl  8(%ebp)
	pushl  8(%ebp)
	pushl  12(%ebp)
	popl   %ebx
	popl   %eax
	movl   $0, %edx
	idiv   %ebx
	pushl  %eax
	pushl  12(%ebp)
	popl   %ebx
	popl   %eax
	imul   %eax, %ebx
	pushl  %ebx
	popl   %ebx
	popl   %eax
	subl   %ebx, %eax
	pushl  %eax
	pushl  12(%ebp)
	call   gcd
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, 8(%ebp)
# -------------------------
# Line 16: gcd:=a
# -------------------------
	pushl  8(%ebp)
	popl   %eax
	movl   %eax, -4(%ebp)
endif0:

# Method Postlude
	popl   %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# Line 20: displayres(ans:int)is
# -------------------------
displayres:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# Line 22: out.writeint(ans)
# -------------------------
	pushl  8(%ebp)
	call   writeint
	addl   $4, %esp

# Method Postlude
	popl   %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# Line 25: start()is
# -------------------------
start:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# Line 27: x:=in.readint()
# -------------------------
	call   readint
	addl   $0, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _x
# -------------------------
# Line 28: y:=in.readint()
# -------------------------
	call   readint
	addl   $0, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _y
# -------------------------
# Line 29: ans:=gcd(x,y)
# -------------------------
	pushl  _y
	pushl  _x
	call   gcd
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _ans
# -------------------------
# Line 30: displayres(ans)
# -------------------------
	pushl  _ans
	call   displayres
	addl   $4, %esp

# Method Postlude
	popl   %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
main:
	call   start
