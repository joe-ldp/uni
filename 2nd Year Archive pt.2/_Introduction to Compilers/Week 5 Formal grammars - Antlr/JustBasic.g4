grammar JustBasic;

program : stat+;

stat :
    ('cls'
	| print_stat
	| goto_stat
	| input_stat
	| if_stat
	| block_stat
	| assign_stat)
	(COLON stat)?
	;

goto_stat : 'goto' LABEL;

block_stat: LABEL stat+ ;

input_stat : 'input' STRING SEMI ID ;

if_stat : 'if' bool_expr (bool_join bool_expr)* 'then' stat ;

bool_join : 'or' | 'and' ;
bool_expr : bool_operand BOOL_OP bool_operand ;
bool_operand : operand | expr;

cast : 'int' | 'decimal' ;
assign_stat :
    ID EQUALS cast? operand
	| ID EQUALS cast? expr
	| ID EQUALS cast? ID
	;

print_stat :
    'print' STRING SEMI ID
    | 'print' STRING
    | 'print'
    ;

expr : operand OP operand
    | operand OP expr
    | expr OP operand
    | expr OP expr
	| LPARENS expr RPARENS
	| LPARENS expr OP operand RPARENS
	| LPARENS operand OP expr RPARENS
	;

operand : ID | NUMBER ;

STRING : SPEECHMARK ( UPPERCASE | LOWERCASE | DOT | WS | EQUALS | GT | SUB | DIGIT | QUOTE )* SPEECHMARK ;
OP : MUL | DIV | ADD | SUB | POW;
LPARENS : '(' ;
RPARENS : ')' ;
BOOL_OP : GT | LT ;
LABEL : LSQBR ID RSQBR ;
LSQBR : '[' ;
RSQBR : ']' ;
SEMI : ';' ;
EQUALS : '=' ;
GT : '>' ;
LT : '<' ;
SPEECHMARK : '"' ;
QUOTE : '\'' ;
COMMA : ',' ;
COLON : ':' ;
ID : LOWERCASE+ ;
NUMBER : INTEGER | DECIMAL ;
DECIMAL : DIGIT* DOT DIGIT+;
INTEGER : DIGIT+ ;
DOT : '.' ;
DIGIT : [0-9] ;
UPPERCASE : [A-Z] ;
LOWERCASE : [a-z] ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
POW : '^' ;

WS : [ \t\r\n]+ -> skip ;
COMMENT : QUOTE .*? ->  skip;
