Team members : [Cody ADAM](https://github.com/CodyAdam) ,[Arthur ALLAIN](https://github.com/Pataubeur), [Romain BRIEND](https://github.com/yami2200), [Thomas DELAPART](https://github.com/Thomega35)

- [๐งฑ While Compiler](#-while-compiler)
  - [โญ Features](#-features)
  - [๐งช Example](#-example)
  - [๐จ Build the compiler jar](#-build-the-compiler-jar)
  - [๐ Run the compiler](#-run-the-compiler)
  - [๐ Project Structure](#-project-structure)
  
# Documentation [here](doc/readme.md)


# ๐งฑ While Compiler

The goal of this project is to create a new programming language and a compiler for it. The language is called While and is a simple imperative language. The compiler is written in Java and compile to Python.

This project has been realised by a group of 4 students of ESIR. The goal of this project is to learn how works and how to write a compiler.



## โญ Features

- [x] Grammar lexer and parser (ANTLR)
- [x] AST generation
- [x] AST Validation
- [x] Three Adress Code generation
- [x] Optimization
- [x] Target code generation
- [x] Runtime library
- [x] Command line interface   


## ๐งช Example

This is an example of a While program that compute the the double of a number.

```
function double : 
read X 
%
  for X do 
    X := (cons nil X) 
  od 
% 
write X

function main:
read UserInput
%
  Output := (cons int (double UserInput))
%
write Output
```

> Note : Standard input and output are available through the `main` function. Thus the `main` function is mandatory.


## ๐จ Build the compiler jar

**Requirements**
- Maven *(building only)*
- Java 11 *(build and run)*

**Build the jar**

```bash
mvn clean
mvn package
```

The jar is generated in the `target` folder as `whilec.jar`.

## ๐ Run the compiler

The goal of the `whilec.jar` is to compile a While program into a Python program. 

```bash
java -jar whilec.jar [filepath] [...arguments?] [...options?]
```
- `filepath` : the path of the file to compile (example : `java -jar whilec.jar sample/good/for.while`)
- `arguments` *optional* : there are two ways for format the arguments of the program (seperated by a space)
    - `2 0` : using integers that are converted into binary tree (2 become `(cons nil (cons nil nil))`)
    - `(cons nil (cons nil nil)) (cons nil nil)` : using the binary tree format directly
  - example : `java -jar whilec.jar sample/good/double.while 5`
- `options` *optional* : the options of the compiler (seperated by a space)
  - `-x` : execute the program at the end of the compilation
  - `-v` : verbose mode, display compilation steps with more details
  - `-d` : debug mode, print AST into a PlantUML file and display the intermediate code in the console
  - `-o` : optimisation mode, enable optimisation of the intermediate code, during the compilation
  - example : `java -jar target/whilec.jar sample/good/for.while -x -v -d -o`

**Example**

```bash
java -jar target/whilec.jar sample/good/double.while 5 -x -v -o
```

**Output**

```
###########################################
### STARTING VALIDATION OF double.while ###
###########################################

###########################
###  VALIDATION REPORT  ###
###  0 ERROR(S) FOUND   ###
###########################

File output.py generated at /Project_TLC/output.py
Output value 0 :
 
  _CONS_____                                        
 /          \                                       
int      _CONS_____                                 
        /          \                                
       NIL      _CONS_____                          
               /          \                         
              NIL      _CONS_____                   
                      /          \                  
                     NIL      _CONS_____            
                             /          \           
                            NIL      _CONS_____     
                                    /          \    
                                   NIL      _CONS_  
                                           /      \ 
                                          NIL    NIL

    as Integer:  7    
    as Boolean:  1    
     as String:  "int"

  Pretty print:  6    
```


## ๐ Project Structure

```
๐ฆwhile-lang
 โฃ ๐doc                  // Documentation
 โฃ ๐grammar              // ANTLR grammar
 โ โ ๐AST.g
 โฃ ๐resources            // Runtime target libraries
 โ โฃ ๐base.py            // Default python runtime
 โ โ ๐base_verbose.py    // Verbose python runtime
 โฃ ๐src/main/java
 โ โฃ ๐runner             // Main program
 โ โฃ ๐AST                // Generated AST
 โ โฃ ๐C3A                // Generated 3AC 
 โ โฃ ๐translate          // Generated target from 3AC
 โ โ ๐Validation         // Validation system
 โ โ ๐Optimization       // 3AC code optimization system
 โฃ ๐sample               // Sample while files
 โ โฃ ๐bad                // Should raise compiler error
 โ โ ๐good               // Should compile
 โฃ ๐.gitignore
 โฃ ๐ASTPrinted.puml      // AST diagram PlantUML for debugging
 โฃ ๐README.md
 โฃ ๐generate_grammar.sh  // Generate ANTLR grammar
 โ ๐pom.xml              // Maven project configuration
```
