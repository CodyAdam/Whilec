grammar AST;
options {
	output = AST;
}

tokens  {
	ROOT;
	COMMANDS;
	COMMAND;
	ASSIGN;
	IF;
	FOR;
	WHILE;
	FOREACH;
	FUNC;
	FUNCDEF;
	
}



// ------------------------- RULES -------------------------

program: function+ -> function+;

function: WS? 'function' WS SYMBOL WS? ':' WSNL definition -> ^(FUNC SYMBOL definition);

definition:
	'read' WS? input WSNL '%' WSNL commands WSNL '%' WSNL 'write' output WSNL -> ^(FUNCDEF input commands output);

input: inputsub? -> inputsub?;

inputsub: (WS? VARIABLE WS? ',' inputsub) -> VARIABLE | WS? VARIABLE -> VARIABLE;

output: (WS? VARIABLE WS? ',' output) -> VARIABLE | WS? VARIABLE -> VARIABLE;

commands: 
	   WSNL? command (WS? ';' WSNL? command)* (';')? -> command+;

command:
	  ('nop') -> 'nop'
	| (vars WS ':=' WS exprs) -> ^(ASSIGN vars exprs)
	| ('if' WS expression WS 'then' WSNL commands WSNL (WS? 'else' WSNL commands WSNL)? 'fi') -> ^(IF expression commands (commands)?)
	| ('while' WS expression WS 'do' WSNL commands WSNL 'od') -> ^(WHILE expression commands)
	| ('for' WS expression 'do' WSNL commands WSNL 'od') -> ^(FOR expression commands)
	| ('foreach' WS VARIABLE WS 'in' WS expression WS 'do' WSNL commands WSNL ' od') -> ^(FOREACH VARIABLE expression commands);

vars 	:	 
	  (VARIABLE WS? ',' vars) -> VARIABLE 
	| VARIABLE -> VARIABLE;

exprs 	: 
	  (WS? expression WS? ',' exprs) -> expression
	| WS? expression -> expression;

expression: 'true';

/*exprbase
 : 'nil' | VARIABLE | SYMBOL | '(cons 'lexpr')'|'(list 'lexpr')'|'(hd 'exprbase')'|'(tl
 'exprbase')'|'('SYMBOL lexpr')';
 */

/*exprbase
 : '(hd 'sub_exprbase')'|'(tl 'sub_exprbase')'|sub_exprbase;
 
 sub_exprbase : 'nil' | VARIABLE | SYMBOL | '(cons 'lexpr')'|'(list 'lexpr')'|'('SYMBOL lexpr')';
 

 

 

 

 expression : exprbase | exprbase ' = '? exprbase;
 
 lexpr : exprbase* ;
 */

// ------------------------- LEXEMES -------------------------

SYMBOL: ('a' ..'z') (('A' ..'Z') | ('a' ..'z') | DIGIT)* ('!'|'?')?;

VARIABLE: ('A' ..'Z') (('A' ..'Z') | ('a' ..'z') | DIGIT)* ('!'| '?'	)?;

DIGIT: ('0' ..'9');

WS: (' ' | '\t')+; // Short for White Space

WSNL: (WS | '\r'? '\n')+; // Short for White Space or New Line
