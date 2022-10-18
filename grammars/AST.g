grammar AST;


// ------------------------- RULES -------------------------
program :	 function+;

function
	:	 'function 'SYMBOL' : 'definition;
	
//definition 
//	:	'read 'input' % 'commands' % write 'output;
definition 
	:	 'read 'input' % 'commands' % write 'input;
	
input 	:	 inputsub?;

//inputsub 
//	:	 VARIABLE' , 'inputsub | VARIABLE;
inputsub 
	:	 VARIABLE;
	
//output 	:	 VARIABLE' , 'output | VARIABLE;

/*commands 
	:	 (command' ; 'commands)|command;*/
commands 
	:	 command+;
	
command	 :	 'nop'|(vars' := 'exprs)|
		('if 'expression' then 'commands(' else 'commands)?' fi')|
		('while 'expression' do 'commands' od')|
		('for 'expression' do 'commands' od')|
		('foreach 'VARIABLE' in 'expression' do 'commands' od');

vars 	:	 (VARIABLE' , 'vars)|VARIABLE;

exprs 	:	(expression' , 'exprs)|expression;
//exprs 	:	 expression+;

/*exprbase 
    :    'nil' | VARIABLE | SYMBOL | '(cons 'lexpr')'|'(list 'lexpr')'|'(hd 'exprbase')'|'(tl 'exprbase')'|'('SYMBOL lexpr')';*/
    
exprbase 
    :    '(hd 'sub_exprbase')'|'(tl 'sub_exprbase')'|sub_exprbase;
    
sub_exprbase 
	:	exprbase|'nil' | VARIABLE | SYMBOL | '(cons 'lexpr')'|'(list 'lexpr')'|'('SYMBOL lexpr')';

expression 
    :    exprbase | exprbase ' = '? exprbase;

lexpr     :    exprbase* ;

// ------------------------- LEXEMES -------------------------


SYMBOL 
	:	('a'..'z')(('A'..'Z')|('a'..'z')|DIGIT)*('!'|'?')?;

VARIABLE
 	:	('A'..'Z')(('A'..'Z')|('a'..'z')|DIGIT)*('!'|'?')?;
	
DIGIT 	:	 ('0'..'9');