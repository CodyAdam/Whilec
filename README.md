Team members : [Cody ADAM](https://github.com/CodyAdam) ,[Arthur ALLAIN](https://github.com/Pataubeur), [Romain BRIEND](https://github.com/yami2200), [Thomas DELAPART](https://github.com/Thomega35)

- [🧱 While Compiler](#-while-compiler)
  - [⭐ Features](#-features)
  - [🧪 Example](#-example)
  - [🔨 Build the compiler jar](#-build-the-compiler-jar)
  - [📟 Run the compiler](#-run-the-compiler)
  - [📂 Project Structure](#-project-structure)


# 🧱 While Compiler

The goal of this project is to create a new programming language and a compiler for it. The language is called While and is a simple imperative language. The compiler is written in Java and compile to Python.

This project has been realised by a group of 4 students of ESIR. The goal of this project is to learn how works and how to write a compiler.



## ⭐ Features

- [x] Grammar lexer and parser (ANTLR)
- [x] AST generation
- [x] AST Validation
- [x] Three Adress Code generation
- [x] Optimisation
- [x] Target code generation
- [x] Runtime library
- [x] Command line interface   


## 🧪 Example

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


## 🔨 Build the compiler jar

**Requirements**
- Maven *(building only)*
- Java 11 *(build and run)*

**Build the jar**

```bash
mvn clean
mvn package
```

The jar is generated in the `target` folder as `whilec.jar`.

## 📟 Run the compiler

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
  - example : `java -jar whilec.jar sample/good/for.while -x -v -d`

**Example**

```bash
java -jar whilec.jar sample/good/double.while 5 -x -v
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

File output.py generated at /home/cody/Git/Project_TLC/output.py
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

    as Integer:  11   
    as Boolean:  1    
     as String:  "int"

  Pretty print:  10   
```


## 📂 Project Structure

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
 ┣ 📂sample               // Sample while files
 ┃ ┣ 📂bad                // Should raise compiler error
 ┃ ┗ 📂good               // Should compile
 ┣ 📜.gitignore
 ┣ 📜ASTPrinted.puml      // AST diagram PlantUML for debugging
 ┣ 📜README.md
 ┣ 📜generate_grammar.sh  // Generate ANTLR grammar
 ┗ 📜pom.xml              // Maven project configuration
```