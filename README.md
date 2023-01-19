# 🧱 While Compiler

This is a compiler for the While language. It is written in Java and compile to python.
This project has been realised by a group of 4 students of ESIR. The goal of this project is to learn how works and how to write a compiler.

Team member : [Cody ADAM](https://github.com/CodyAdam) ,[Arthur ALLAIN](https://github.com/Pataubeur), [Romain BRIEND](https://github.com/yami2200), [Thomas DELAPART](https://github.com/Thomega35)

## 🔨 Build the compiler jar

```bash
mvn clean
mvn package
```

## 📟 Run the compiler

```bash
java -jar target/whilec.jar filepath [options]
```

filepath is required. The filepath correspond to the path of the file to compile.

Options :

* `-x` : execute the program at the end of the compilation
* `-v` : verbose mode, display compilation steps with more details
* `-d` : debug mode, print AST into a PlantUML file and display the intermediate code in the console

## 📂 Structure du projet

```
📦while-lang
 ┣ 📂doc                  // Documentation
 ┣ 📂grammar              // ANTLR grammar
 ┃ ┗ 📜AST.g
 ┣ 📂resources            // Runtime target libraries
 ┃ ┣ 📜base.py            // Default python runtime
 ┃ ┗ 📜base_verbose.py    // Verbose python runtime
 ┣ 📂src/main/java
 ┃ ┣ 📂runner             // Main program
 ┃ ┣ 📂AST                // Generated AST
 ┃ ┣ 📂C3A                // Generated 3AC 
 ┃ ┣ 📂translate          // Generated target from 3AC
 ┃ ┗ 📂Validation         // Validation system
 ┣ 📂sample                 // Sample while files
 ┃ ┣ 📂bad                // Should raise compiler error
 ┃ ┗ 📂good               // Should compile
 ┣ 📜.gitignore
 ┣ 📜ASTPrinted.puml      // AST diagram PlantUML for debugging
 ┣ 📜README.md
 ┣ 📜generate_grammar.sh  // Generate ANTLR grammar
 ┗ 📜pom.xml              // Maven project configuration
```