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
	FUNCTIONCALL;
	ELSECOMMANDS;
	EXPRESSIONS;
}

// ------------------------- RULES -------------------------

program: WS* (function WS*)+ -> ^(ROOT function+);

function: 'function' WS SYMBOL_LEX WS? ':' WS definition-> ^(FUNCTION ^(SYMBOL_LEX definition));

definition:
	'read' WS (input WS)? '%' WS commands WS '%' WS 'write' output -> ^(FUNCDEF input? ^(COMMANDS commands) ^(OUTPUT output)); //

input: inputsub? -> ^(INPUT inputsub?);

inputsub: (WS? VARIABLE_LEX WS? ',' inputsub) -> VARIABLE_LEX inputsub | WS? VARIABLE_LEX -> VARIABLE_LEX;

output: (WS? VARIABLE_LEX WS? ',' output) -> VARIABLE_LEX output | WS? VARIABLE_LEX -> VARIABLE_LEX; 

commands: 
	   WS? command (WS? ';' WS? command)* (';')? -> command+;

command:
	  ('nop') -> NOP
	| (vars WS? ':=' WS? exprs) -> ^(ASSIGN ^(VARS vars) ^(EXPRESSIONS exprs))
	| ('if' WS expression WS 'then' WS commands WS(WS? 'else'WS commands WS)? 'fi') -> ^(IF expression ^(COMMANDS commands) ^(ELSECOMMANDS commands)?)
	| ('while' WS expression WS 'do' WS commands WS 'od') -> ^(WHILE expression ^(COMMANDS commands))
	| ('for' WS expression WS 'do' WS commands WS 'od') -> ^(FOR expression ^(COMMANDS commands))
	| ('foreach' WS VARIABLE_LEX WS 'in' WS expression WS 'do' WS commands WS 'od') -> ^(FOREACH VARIABLE_LEX expression ^(COMMANDS commands));

vars 	:	 
	  (VARIABLE_LEX WS? ',' WS? vars) -> VARIABLE_LEX vars
	| VARIABLE_LEX -> VARIABLE_LEX;

	
exprs 	:	expression (WS? ',' WS? expression)* -> expression+;
	
expression 
	:	 e1=exprbase(
		' = 'e2=exprbase -> ^(EXPRESSION ^(EQUALS $e1 $e2))
		| -> ^(EXPRESSION $e1)
 	);

exprbase
 : 	'(' WS? (
 	SYMBOL_LEX WS lexpr')' -> ^(FUNCTIONCALL ^(SYMBOL_LEX lexpr))
 	| SYMBOL_LEX')' -> ^(FUNCTIONCALL SYMBOL_LEX)
 	|'hd 'exprbase WS?')' -> ^(HEAD exprbase)
 	|'tl 'exprbase WS?')' -> ^(TAIL exprbase)
 	|'cons 'lexpr')' -> ^(CONS lexpr)
 	|'list 'lexpr')' -> ^(LIST lexpr)
 	)
	| 'nil' -> NIL
 	| VARIABLE_LEX -> ^(VARIABLE VARIABLE_LEX)
 	| SYMBOL_LEX -> ^(SYMBOL SYMBOL_LEX);
 
 lexpr
    : (WS? (exprbase WS?)*) -> exprbase*;
// ------------------------- LEXEMES -------------------------

SYMBOL_LEX: ('a' ..'z')(('A' ..'Z') | ('a' ..'z') | DIGIT)* ('!'|'?')?;

VARIABLE_LEX: ('A' ..'Z') (('A' ..'Z') | ('a' ..'z') | DIGIT)* ('!'| '?')?;

DIGIT: ('0' ..'9');

WS: (' ' | '\t' | '\r'? '\n')+;
