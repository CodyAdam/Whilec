grammar AST;


// ------------------------- RULES -------------------------
program :	 (function program) | function;

function
	:	 'function 'SYMBOL' : 'definition;
	
definition 
	:	'read 'input' % 'commands' % write 'output;
	
input 	:	 inputsub | '';

inputsub 
	:	 VARIABLE' , 'inputsub | VARIABLE;
	
output 	:	 VARIABLE' , 'output | VARIABLE;

commands 
	:	 (command' ; 'commands)|command;
	
command	 :	 'nop'|(vars' := 'exprs)|
		('if 'expression' then 'commands(' else 'commands)?' fi')|
		('while 'expression' do 'commands' od')|
		('for 'expression' do 'commands' od')|
		('foreach 'VARIABLE' in 'expression' do 'commands' od');

vars 	:	 (VARIABLE' , 'vars)|VARIABLE;

exprs 	:	(expression' , 'exprs)|expression;

exprbase 
    :    'nil' | VARIABLE | SYMBOL | '(''cons 'lexpr')'|'(''list 'lexpr')'|'(''hd 'exprbase')'|'(''tl 'exprbase')'|'('SYMBOL lexpr')';

expression 
    :    exprbase | exprbase ' = '? exprbase;

lexpr     :    exprbase lexpr | '' ;

// ------------------------- LEXEMES -------------------------


SYMBOL 
	:	MINISCULE(MAJUSCULE|MINISCULE|DIGIT)*('!'|'?')?;

VARIABLE
 	:	MAJUSCULE(MAJUSCULE|MINISCULE|DIGIT)*('!'|'?')?;
	
MINISCULE
	:	('a'..'z');
	
MAJUSCULE 
	:	 ('A'..'Z');
	
DIGIT 	:	 ('0'..'9');