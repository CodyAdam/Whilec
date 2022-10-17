grammar AST;


// ------------------------- RULES -------------------------
delegateGrammars
    :   IMPORT delegateGrammar (COMMA delegateGrammar)* SEMI
    ;

delegateGrammar
    :   id ASSIGN id
    |   id
    ;

id  :   RULE_REF
    |   TOKEN_REF
    ;

// ------------------------- LEXEMES -------------------------


