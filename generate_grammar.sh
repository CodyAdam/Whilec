#!/bin/bash
java -jar "./lib/antlr3.jar" "./grammars/AST.g"  -o "./src"
mv ./src/grammars/* ./src/AST
rmdir ./src/grammars
sed -i "1ipackage AST;" ./src/AST/ASTLexer.java
sed -i "1ipackage AST;" ./src/AST/ASTParser.java