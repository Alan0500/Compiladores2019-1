.data
True : .word 1
 false : .word 0
.text
main: 
li $t0,3
li $t1,3
li $t2,-4
div $t1, $t1, $t2
add $t0, $t0, $t1
move $a0,$t0
li $v0, 1 
syscall
 .data
 temp0: .asciiz "gato" 
.text
la $a0,temp0
li $v0, 4 
syscall
 end: jr $ra