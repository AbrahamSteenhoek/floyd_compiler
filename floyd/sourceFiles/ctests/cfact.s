.data
# -------------------------
# Line 6: num:int
# -------------------------
	.comm _num, 4, 4
# -------------------------
# Line 7: num2:int
# -------------------------
	.comm _num2, 4, 4
	.text
.global main
# -------------------------
# Line 9: Fact(num:int):intis
# -------------------------
Fact:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
	pushl  $0
# -------------------------
# Line 12: ifnum=0then
# -------------------------
	pushl  8(%ebp)
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
# Line 13: answer:=1
# -------------------------
	pushl  $1
	popl   %eax
	movl   %eax, -8(%ebp)
	jmp    endif0
falseif0:
# -------------------------
# Line 15: answer:=num*Fact(num-1)
# -------------------------
	pushl  8(%ebp)
	pushl  8(%ebp)
	pushl  $1
	popl   %ebx
	popl   %eax
	subl   %ebx, %eax
	pushl  %eax
	call   Fact
	addl   $4, %esp
	pushl  %eax
	popl   %ebx
	popl   %eax
	imul   %eax, %ebx
	pushl  %ebx
	popl   %eax
	movl   %eax, -8(%ebp)
endif0:
# -------------------------
# Line 17: Fact:=answer
# -------------------------
	pushl  -8(%ebp)
	popl   %eax
	movl   %eax, -4(%ebp)

# Method Postlude
	addl   $4, %esp
	popl   %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# Line 21: Go()is
# -------------------------
Go:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
	pushl  $0
# -------------------------
# Line 24: isOk:=false
# -------------------------
	pushl  $0
	popl   %eax
	movl   %eax, -8(%ebp)
# -------------------------
# Line 25: loopwhilenotisOk
# -------------------------
while0:
	pushl  -8(%ebp)
	popl   %eax
	not    %eax
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody0
	jmp    endwhile0
startwhilebody0:
# -------------------------
# Line 26: num:=in.readint()
# -------------------------
	call   readint
	addl   $0, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _num
# -------------------------
# Line 27: isOk:=(num>=1)
# -------------------------
	pushl  _num
	pushl  $1
	call   gte
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, -8(%ebp)
	jmp    while0
endwhile0:

# Method Postlude
	addl   $4, %esp
	popl   %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# Line 31: start()is
# -------------------------
start:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# Line 33: Go()
# -------------------------
	call   Go
	addl   $0, %esp
# -------------------------
# Line 34: num2:=Fact(num)
# -------------------------
	pushl  _num
	call   Fact
	addl   $4, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _num2
# -------------------------
# Line 35: out.writeint(num)
# -------------------------
	pushl  _num
	call   writeint
	addl   $4, %esp
# -------------------------
# Line 36: out.writeint(num2)
# -------------------------
	pushl  _num2
	call   writeint
	addl   $4, %esp

# Method Postlude
	popl   %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
main:
	call   start
