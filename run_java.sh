#!/bin/bash
javac -cp lib/antlr3.jar -d bin/ src/**/*.java src/*.java
java -cp lib/antlr3.jar:bin/  Main