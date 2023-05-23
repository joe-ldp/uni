grammar assignment;

@header
{
    package com.assignment;
}

program:
PROGBEGIN
(stat_assignment | stat_assign_array)*
(block | function_definition)*
PROGEND
;

block: LCURLY statement* RCURLY;

statement:
( stat_assignment
| stat_assign_array
| stat_input
| stat_output
| stat_if
| stat_for
| stat_while
| function_call SCOLON)
;

stat_assignment: 'const'? IDENTIFIER EQUALS value SCOLON;
stat_assign_array: 'const'? IDENTIFIER EQUALS array SCOLON;
stat_input: 'input' value SCOLON;
stat_output: 'print' value SCOLON;
stat_if: 'if' expr_boolean 'then' block (('else if' expr_boolean 'then' block)* 'else' block)? 'end if';
stat_for: 'for' IDENTIFIER 'in' NUMBER COMMA NUMBER block 'end for';
stat_while: 'while' expr_boolean block 'end while';


value: operand #OPVALUE | expression #EXPRESSION | IDENTIFIER #VARVAL | IDENTIFIER LSQUARE NUMBER+ RSQUARE #ARRAY | function_call #FUNCRETURN;

expression:
  operand OP operand
| operand OP expression
| expression OP operand
| LPARENS expression RPARENS
| LPARENS operand OP expression RPARENS
| LPARENS expression OP operand RPARENS
;

operand: VALUE #VAL | IDENTIFIER #VARNAME;

array: LSQUARE VALUE (COMMA VALUE)* RSQUARE;

expr_boolean: bool_operand (BOOL_OP bool_operand)*;
bool_operand: operand | expression | TRUE | FALSE;

function_definition: function_signature funcblock;

function_signature: 'function' IDENTIFIER LPARENS (IDENTIFIER? (COMMA IDENTIFIER)*) RPARENS;
funcblock: LCURLY statement+ return? RCURLY;

function_call: IDENTIFIER LPARENS args RPARENS;
args: value (COMMA value)*;
return: 'return' value SCOLON;

PROGBEGIN: 'A long time ago in a galaxy far far away...';
PROGEND: 'The End';

IDENTIFIER: LETTER+;

VALUE: STRING | FLOAT;

STRING: SPEECHMARK (LETTER | DIGIT | POINT | WHITESPACE | EQUALS | GTHAN | LTHAN | QUOTEMARK )+ SPEECHMARK;

LETTER: UPPERCASE | LOWERCASE;
UPPERCASE: [A-Z];
LOWERCASE: [a-z];

FLOAT: NUMBER POINT NUMBER;
NUMBER: DIGIT+;
DIGIT: [0-9];

OP: ADD | SUB | MUL | DIV | POW;
ADD: '+';
SUB: '-';
MUL: '*';
DIV: '/';
POW: '^';
EQUALS: '=';

BOOL_OP: COMPEQUALS | OR | AND | GTHAN | LTHAN;
COMPEQUALS: '==';
OR: '||';
AND: '&&';
GTHAN: '>';
LTHAN: '<';

LPARENS: '(';
RPARENS: ')';
LCURLY: '{';
RCURLY: '}';
LSQUARE: '[';
RSQUARE: ']';
SCOLON: ';';
COLON: ':';
COMMA: ',';
POINT: '.';
SPEECHMARK: '"';
QUOTEMARK: '\'';
TRUE: 'true';
FALSE: 'false';

WHITESPACE: [ \t\n\r]+ -> skip;