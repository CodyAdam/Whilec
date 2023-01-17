echo 'TODO script need to be changed since project structure changed'

@REM java -jar ".\lib\antlr3.jar" ".\grammars\AST.g"  -o ".\src"
@REM move .\src\grammars\* .\src\AST
@REM rmdir .\src\grammars

@REM copy .\src\AST\ASTLexer.java .\src\AST\ASTLexer.txt
@REM echo.package AST;>.\src\AST\ASTLexer.java
@REM type .\src\AST\ASTLexer.txt >>.\src\AST\ASTLexer.java
@REM del .\src\AST\ASTLexer.txt

@REM copy .\src\AST\ASTParser.java .\src\AST\ASTParser.txt
@REM echo.package AST;>.\src\AST\ASTParser.java
@REM type .\src\AST\ASTParser.txt >>.\src\AST\ASTParser.java
@REM del .\src\AST\ASTParser.txt