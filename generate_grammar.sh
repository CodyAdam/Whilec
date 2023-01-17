#!/bin/bash
java -jar "./lib/antlr3.jar" "./grammar/AST.g"  -o "./grammar/java"
mv ./grammar/java/grammar/* ./src/main/java/AST -f
rmdir ./grammar/java/grammar
rm ./grammar/java/AST.tokens
rmdir ./grammar/java
sed -i "1ipackage AST;" ./src/main/java/AST/ASTLexer.java
sed -i "1ipackage AST;" ./src/main/java/AST/ASTParser.java