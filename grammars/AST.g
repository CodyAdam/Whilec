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

function: WS? 'function' WS SYMBOL WS? ':' WS definition-> ^(FUNC SYMBOL definition);

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

	
exprs 	:	expression (WS? ','expression)* ;

//expression: 'true';
expression : exprbase(' = ' exprbase)?;
/*
//exprbase:	 ('('('cons'|'list'|'hd'|'tl')WS) ('nil'|VARIABLE|SYMBOL) WS ')';

//exprbase:	 ('('('cons'|'list'|'hd'|'tl')WS)* ('nil'|VARIABLE|SYMBOL)+ (')');

exprbase:	 exprbase_low | ('nil'|VARIABLE|SYMBOL);

exprbase_low:	 ('('('cons'|'list')WS) lexpr WS ')';

/*exprbase
 : 'nil' | VARIABLE | SYMBOL | '(cons 'lexpr')'|'(list 'lexpr')'|'(hd 'exprbase')'|'(tl
 'exprbase')'|'('SYMBOL lexpr')';
 */

exprbase
 : '(hd 'exprbase')'|'(tl 'exprbase')'| '(cons ' lexpr')'|'(list ' lexpr')'|'('SYMBOL WS lexpr')' | 'nil' | VARIABLE | SYMBOL;
 
 lexpr
    : (WS? (exprbase WS?)*);
 
 //lexpr : exprbase* ;

// ------------------------- LEXEMES -------------------------

SYMBOL: ('a' ..'z') (('A' ..'Z') | ('a' ..'z') | DIGIT)* ('!'|'?')?;

VARIABLE: ('A' ..'Z') (('A' ..'Z') | ('a' ..'z') | DIGIT)* ('!'| '?')?;

DIGIT: ('0' ..'9');

WS: (' ' | '\r'? '\n')+; // Short for White Space or New Line

//WS: (' ' | '\t')+; // Short for White Space
