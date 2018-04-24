.data
# -------------------------
# Line 6: Amt:int
# -------------------------
	.comm _Amt, 4, 4
# -------------------------
# Line 7: Quarters:int
# -------------------------
	.comm _Quarters, 4, 4
# -------------------------
# Line 8: Dimes:int
# -------------------------
	.comm _Dimes, 4, 4
# -------------------------
# Line 9: Nickels:int
# -------------------------
	.comm _Nickels, 4, 4
	.text
.global main
# -------------------------
# Line 11: ComputeChange(amt:int;denom:int):intis
# -------------------------
ComputeChange:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# Line 13: ComputeChange:=amt/denom
# -------------------------
	pushl  8(%ebp)
	pushl  12(%ebp)
	popl   %ebx
	popl   %eax
	movl   $0, %edx
	idiv   %ebx
	pushl  %eax
	popl   %eax
	movl   %eax, -4(%ebp)

# Method Postlude
	popl   %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
# -------------------------
# Line 16: ComputeRemain(amt:int;denom:int;qtydenom:int):intis
# -------------------------
ComputeRemain:
# Method Preamble
	pushl  %ebp
	movl   %esp, %ebp
# reserve space for return value
	pushl  $0
# reserve space for local vars
# -------------------------
# Line 18: ComputeRemain:=amt-denom*qtydenom
# -------------------------
	pushl  8(%ebp)
	pushl  12(%ebp)
	pushl  16(%ebp)
	popl   %ebx
	popl   %eax
	imul   %eax, %ebx
	pushl  %ebx
	popl   %ebx
	popl   %eax
	subl   %ebx, %eax
	pushl  %eax
	popl   %eax
	movl   %eax, -4(%ebp)

# Method Postlude
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
# Line 23: Amt:=in.readint()
# -------------------------
	call   readint
	addl   $0, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _Amt
# -------------------------
# Line 27: Quarters:=ComputeChange(Amt,25)
# -------------------------
	pushl  $25
	pushl  _Amt
	call   ComputeChange
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _Quarters
# -------------------------
# Line 28: if(Quarters>0)then
# -------------------------
	pushl  _Quarters
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
# Line 29: out.writeint(Quarters)
# -------------------------
	pushl  _Quarters
	call   writeint
	addl   $4, %esp
	jmp    endif0
falseif0:
# -------------------------
# Line 31: out.writeint(0)
# -------------------------
	pushl  $0
	call   writeint
	addl   $4, %esp
endif0:
# -------------------------
# Line 33: Amt:=ComputeRemain(Amt,25,Quarters)
# -------------------------
	pushl  _Quarters
	pushl  $25
	pushl  _Amt
	call   ComputeRemain
	addl   $12, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _Amt
# -------------------------
# Line 36: Dimes:=ComputeChange(Amt,10)
# -------------------------
	pushl  $10
	pushl  _Amt
	call   ComputeChange
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _Dimes
# -------------------------
# Line 37: if(Dimes>0)then
# -------------------------
	pushl  _Dimes
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
# Line 38: out.writeint(Dimes)
# -------------------------
	pushl  _Dimes
	call   writeint
	addl   $4, %esp
	jmp    endif1
falseif1:
# -------------------------
# Line 40: out.writeint(0)
# -------------------------
	pushl  $0
	call   writeint
	addl   $4, %esp
endif1:
# -------------------------
# Line 42: Amt:=ComputeRemain(Amt,10,Dimes)
# -------------------------
	pushl  _Dimes
	pushl  $10
	pushl  _Amt
	call   ComputeRemain
	addl   $12, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _Amt
# -------------------------
# Line 44: Nickels:=ComputeChange(Amt,5)
# -------------------------
	pushl  $5
	pushl  _Amt
	call   ComputeChange
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _Nickels
# -------------------------
# Line 45: if(Nickels>0)then
# -------------------------
	pushl  _Nickels
	pushl  $0
	call   gt
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif2
	jmp    falseif2
trueif2:
# -------------------------
# Line 46: out.writeint(Nickels)
# -------------------------
	pushl  _Nickels
	call   writeint
	addl   $4, %esp
	jmp    endif2
falseif2:
# -------------------------
# Line 48: out.writeint(0)
# -------------------------
	pushl  $0
	call   writeint
	addl   $4, %esp
endif2:
# -------------------------
# Line 51: Amt:=ComputeRemain(Amt,5,Nickels)
# -------------------------
	pushl  _Nickels
	pushl  $5
	pushl  _Amt
	call   ComputeRemain
	addl   $12, %esp
	pushl  %eax
	popl   %eax
	movl   %eax, _Amt
# -------------------------
# Line 53: if(Amt>0)then
# -------------------------
	pushl  _Amt
	pushl  $0
	call   gt
	addl   $8, %esp
	pushl  %eax
	popl   %eax
	cmpl   $0, %eax
	jne    trueif3
	jmp    falseif3
trueif3:
# -------------------------
# Line 54: out.writeint(Amt)
# -------------------------
	pushl  _Amt
	call   writeint
	addl   $4, %esp
	jmp    endif3
falseif3:
endif3:

# Method Postlude
	popl   %eax
	movl   %ebp, %esp
	popl   %ebp
	ret
main:
	call   start
