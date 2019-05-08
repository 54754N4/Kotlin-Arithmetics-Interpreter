# Kotlin Arithmetics Interpreter

An interpreter that can parse not very complicated expressions, refer to the grammar below for details of how the parser works.

# Grammar & Production Rules

To keep things simple, only the functions from the kotlin.math package with a single argument were implemented into the grammar. It could be easy to upgrade it at some point to handle variable arity arguments, maybe for another time.

```
input = expr

expr:		complex_expr
complex_expr: 	xor_expr ('|' xor_expr)*
xor_expr: 	and_expr ('^' and_expr)*
and_expr: 	shift_expr ('&' shift_expr)*
shift_expr: 	arith_expr (('<<'|'>>') arith_expr)*
arith_expr: 	term (('+'|'-') term)*
term: 		factor (('*'|'/'|'%'|'//') factor)*
factor: 	('+'|'-'|'~') factor | power
power: 		atom ['\*\*' factor]
atom: 		func_expr
                | '(' complex_expr ')'
                | number
                | "PI"
 func_expr:     ("EXP"|"LN"|"LOG"|"SQRT"|"COS"|"SIN"|"TAN"|"ABS"|...) '(' complex_expr ')'
 ```
 
