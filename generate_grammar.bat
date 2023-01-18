java -jar ".\lib\antlr3.jar" ".\grammar\AST.g"  -o ".\grammar\java"
move .\grammar\java\grammar\* .\src\main\java\AST
rmdir .\grammar\java\grammar\
del .\grammar\java\AST.tokens
rmdir .\grammar\java\

copy .\src\main\java\AST\ASTLexer.java .\src\main\java\AST\ASTLexer.txt
echo.package AST;>.\src\main\java\AST\ASTLexer.java
type .\src\main\java\AST\ASTLexer.txt >>.\src\main\java\AST\ASTLexer.java
del .\src\main\java\AST\ASTLexer.txt

copy .\src\main\java\AST\ASTParser.java .\src\main\java\AST\ASTParser.txt
echo.package AST;>.\src\main\java\AST\ASTParser.java
type .\src\main\java\AST\ASTParser.txt >>.\src\main\java\AST\ASTParser.java
del .\src\main\java\AST\ASTParser.txt