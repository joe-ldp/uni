grammar Calculator;

@header {
package calculator;
}

prog: defn* stat+;

defn: head body;

head:
    'function' FUNC '(' arg* ')'
    ;

body:
    '{' stat+ retstat '}'
    ;

arg:
    value | ID
   ;

retstat:
    'return' arg
    ;

stat:
    expr
    | assign
    | funcall
    ;

assign:
    ID '=' (expr | operand | funcall)
//    | ID '=' operand
    ;

expr:
    operand ADD operand # Add
	| operand SUB operand # Sub
	| operand MUL operand # Mul
	| operand DIV operand # Div
	| operand MOD operand # Mod
	;

funcall:
    FUNC '(' arg* ')'
    ;

operand:
    arg
    | '(' expr ')'
    ;

value: INT+ (DOT INT+)?
	;

FUNC : [A-Z][a-z]+;
ID : [a-z]+;
INT : [0-9]+;
ADD : '+';
SUB : '-';
MUL : '*';
DIV : '/';
MOD : '%';
DOT : '.';
WS : [ \t\r\n]+ -> skip ;

