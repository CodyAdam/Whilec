grammar testAST;
options {
	output = AST;
}

tokens {
	ROOT;
	FUNCTION;
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
}

//-------------------RULES-----------

program : ('.')*->^(FUNCTION ^(INPUT) NOP ^(VARS VARIABLE));



