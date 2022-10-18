grammar AST;


// ------------------------- RULES -------------------------


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