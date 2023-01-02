java -jar ".\lib\antlr3.jar" ".\grammars\AST.g"  -o ".\src"
move .\src\grammars\* .\src\AST
rmdir .\src\grammars

copy .\src\AST\ASTLexer.java .\src\AST\ASTLexer.txt
echo.package AST;>.\src\AST\ASTLexer.java
type .\src\AST\ASTLexer.txt >>.\src\AST\ASTLexer.java
del .\src\AST\ASTLexer.txt

copy .\src\AST\ASTParser.java .\src\AST\ASTParser.txt
echo.package AST;>.\src\AST\ASTParser.java
type .\src\AST\ASTParser.txt >>.\src\AST\ASTParser.java
del .\src\AST\ASTParser.txt