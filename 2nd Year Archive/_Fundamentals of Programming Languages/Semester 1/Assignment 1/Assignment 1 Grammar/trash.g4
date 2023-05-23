grammar trash;

@header
{
    package assignment;
}

//prule: 'hello ' CHAR+;
//CHAR: 'a'..'z';

program:
'In the beginning';
statement+;
'Amen';
;

statement:

;

identifier:
LETTER+;

operator:
  MUL # mul
| DIV # div
| ADD # add
| SUB # sub;

expr:
LPARENS? operand operator operand RPARENS?;

operand:
  value
| variable;

value:
DECIMAL | STRING;

variable:
identifier;



STRING: '"' LETTER+ '"';
fragment DIGIT: [0-9];
DECIMAL: DIGIT+ POINT DIGIT+;
POINT: '.';
LPARENS: '(';
RPARENS: ')';
MUL: '*';
DIV: '/';
ADD: '+';
SUB: '-';
EQUALS: '=';
LETTER: [a-z];
WS: [ \t\n\r]+ -> skip;
