grammar AST;
options {
	output = AST;
}

tokens  {
	TOKENS;
	ROOT;
	FUNCTION;
	FUNCDEF;
	COMMANDS;
	COMMAND;
	INPUT;
	OUTPUT;
	 VARS;
	VARIABLE;
	SYMBOL;
	IF;
	WHILE;
	NOP;
	FOR;
	ASSIGN;
	FOREACH;
	EXPRS;
	EXPR_BASE;
	EXPRESSION;
	EQUALS;
	NIL;
	LIST;
	HEAD;
	TAIL;
	CONS;
}

// ------------------------- RULES -------------------------

program: function+ -> function+;

function: WS? 'function' WS SYMBOL WS? ':' WS definition-> ^(FUNCTION SYMBOL definition);

definition:
	'read' WS (input WS)? '%' WS commands WS '%' WS 'write' output -> ^(FUNCDEF input? commands output); //

input: inputsub? -> inputsub?;

inputsub: (WS? VARIABLE WS? ',' inputsub) -> VARIABLE | WS? VARIABLE -> VARIABLE;

output: (WS? VARIABLE WS? ',' output) -> VARIABLE | WS? VARIABLE -> VARIABLE;

commands: 
	   WS? command (WS? ';' WS? command)* (';')? -> command+;

command:
	  ('nop') -> 'nop'
	| (vars WS ':=' WS exprs) -> ^(ASSIGN vars exprs)
	| ('if' WS expression WS 'then' WS commands WS (WS? 'else' WS commands WS)? 'fi') -> ^(IF expression commands (commands)?)
	| ('while' WS expression WS 'do' WS commands WS 'od') -> ^(WHILE expression commands)
	| ('for' WS expression WS 'do' WS commands WS 'od') -> ^(FOR expression commands)
	| ('foreach' WS VARIABLE WS 'in' WS expression WS 'do' WS commands WS 'od') -> ^(FOREACH VARIABLE expression commands);

vars 	:	 
	  (VARIABLE WS? ',' vars) -> VARIABLE 
	| VARIABLE -> VARIABLE;

	
exprs 	:	expression (WS? ','expression)* -> expression+;
	
expression 
	:	 e1=exprbase(
		' = 'e2=exprbase -> ^(EXPRESSION ^(EQUALS $e1 $e2))
		| -> ^(EXPRESSION $e1)
 	);

exprbase
 : '(hd 'exprbase')' -> ^(HEAD exprbase)
 	|'(tl 'exprbase')' -> ^(TAIL exprbase)
 	| '(cons ' lexpr')' -> ^(CONS lexpr)
 	|'(list ' lexpr')' -> ^(LIST lexpr)
 	|'('SYMBOL WS lexpr')' -> SYMBOL lexpr
	| 'nil' -> NIL
 	| VARIABLE -> VARIABLE
 	| SYMBOL -> SYMBOL; 
 
 lexpr
    : (WS? (exprbase WS?)*) -> exprbase*;
// ------------------------- LEXEMES -------------------------

SYMBOL: ('a' ..'z') (('A' ..'Z') | ('a' ..'z') | DIGIT)* ('!'|'?')?;

VARIABLE: ('A' ..'Z') (('A' ..'Z') | ('a' ..'z') | DIGIT)* ('!'| '?')?;

DIGIT: ('0' ..'9');

WS: (' ' | '\r'? '\n')+;
