grammar Calculator;

@header {
package calculator;
}

prog: stat+;

stat: expr
    | assign ;

expr: operand ADD operand # Add
	| operand SUB operand # Sub
	| operand MUL operand # Mul
	| operand DIV operand # Div
	| operand MOD operand # Mod
	;

assign: ID '=' expr
    | ID '=' operand
    ;

brackets: '(' expr ')';

operand: INT+ (DOT INT+)?
	| ID
	| brackets
	;

ID : [a-z]+;	
INT : [0-9]+;
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
MOD : '%';
DOT : '.';
WS : [ \t\r\n]+ -> skip ; 


