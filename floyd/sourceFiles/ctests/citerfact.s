.data
# -------------------------
# Line 5: num:int
# -------------------------
	.comm _num, 4, 4
# -------------------------
# Line 6: num2:int
# -------------------------
	.comm _num2, 4, 4
# -------------------------
# Line 7: isOk:boolean
# -------------------------
	.comm _isOk, 4, 4
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
# Line 12: answer:=1
# -------------------------
	pushl  $1
	popl   %eax
	movl   %eax, -8(%ebp)
# -------------------------
# Line 13: loopwhilenum>0
# -------------------------
while0:
	pushl  8(%ebp)
	pushl  $0
	call   gt
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	cmp    $0, %eax
	jne    startwhilebody0
	jmp    endwhile0
startwhilebody0:
# -------------------------
# Line 14: answer:=answer*num
# -------------------------
	pushl  -8(%ebp)
	pushl  8(%ebp)
	popl   %ebx
	popl   %eax
	imul   %eax, %ebx
	pushl  %ebx
	popl   %eax
	movl   %eax, -8(%ebp)
# -------------------------
# Line 15: num:=num-1
# -------------------------
	pushl  8(%ebp)
	pushl  $1
	popl   %ebx
	popl   %eax
	subl   %ebx, %eax
	pushl  %eax
	popl   %eax
	movl   %eax, 8(%ebp)
	jmp    while0
endwhile0:
# -------------------------
# Line 17: Fact:=answer
# -------------------------
	pushl  -8(%ebp)
	popl   %eax
	movl   %eax, -4(%ebp)
# -------------------------
# Line 18: out.writeint(0+answer-answer)
# -------------------------
	pushl  $0
	pushl  -8(%ebp)
	popl   %ebx
	popl   %eax
	addl   %ebx, %eax
	pushl  %eax
	pushl  -8(%ebp)
	popl   %ebx
	popl   %eax
	subl   %ebx, %eax
	pushl  %eax
	call   writeint
	addl   $4, %esp

# Method Postlude
	addl   $4, %esp
	popl   %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# Line 21: start()is
# -------------------------
start:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# Line 23: num:=in.readint()
# -------------------------
	call   readint
	addl   $0, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _num
# -------------------------
# Line 24: ifnum>0then
# -------------------------
	pushl  _num
	pushl  $0
	call   gt
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif0
	jmp    falseif0
trueif0:
# -------------------------
# Line 25: num:=Fact(num)
# -------------------------
	pushl  _num
	call   Fact
	addl   $4, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _num
# -------------------------
# Line 26: out.writeint(num)
# -------------------------
	pushl  _num
	call   writeint
	addl   $4, %esp
	jmp    endif0
falseif0:
endif0:

# Method Postlude
	popl   %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
main:
	call   start
