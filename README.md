# Project_TLC
Project in team of 4 members during our studies at the engineering school of ESIR

# How to run

## Build

```bash
mvn clean
mvn package
```

## Run in Debug

```bash
mvn clean
mvn exec:java
```


# I. Introduction

Pour ce projet, nous allons essayer de fabriquer un compilateur du langage "While" décrit dans le sujet. Ce langage est un langage de programmation fonctionnel, il est donc composé de fonctions et de variables. Il est également possible de faire des boucles et des conditions. 

# II. Etude du langage While

Afin de pouvoir nous concentrer sur la partie compilation, nous allons analyser plus en détail le langage "While".

## 1. les types de données

Tout les types de données du langage While sont représentés par des arbres binaires.

### 1.1. Les entiers

Nous allons commencer par voir comment sont représentés les entiers dans le langage While. Les entiers représentent ici uniquement des nombres entiers positifs. La valeur d'un entier correspond au nombre de noeuds sur la branche droite de l'arbre.

![](int.png)

### 1.2. Les booléens

Les booléens sont représentés par des arbres binaires. La valeur d'un booléen vaut 0 (False) si l'arbre est vide et 1 (True) si l'arbre contient des noeuds sur la branche droite.

![](bool.png)

### 1.3. Les chaînes de caractères

Les chaînes de caractères sont représentées par des arbres binaires. La valeur d'une chaîne de caractères est la concaténation des caractères présentes dans l'arbre binaire de gauche à droite.

![](string.png)

### 1.4. Les listes

Les listes sont représentées par des arbres binaires. Une liste contient des éléments de même type. Les valeurs de la liste sont les valeurs des fils gauche de l'arbre.

![](list.png)

## 2. Les commandes et structures de contrôle

- nop
- point virgule
- if then fi
- if then else fi
- while
- for
- foreach
- assignation de variable
- évalution de fonction



https://theantlrguy.atlassian.net/wiki/spaces/ANTLR3/pages/2687087/Interfacing+AST+with+Java
https://theantlrguy.atlassian.net/wiki/spaces/ANTLR3/pages/2687232/How+do+I+use+ANTLR+v3+generated+Lexer+and+Parser+from+Java

## ?. Validation du langage :

Liste des erreurs vérifiées par le compilateur :
- Foreach : ERROR : la variable qu'on itère n'est pas une liste
- While : ERROR : la condition n'est pas un booléen
- If : ERROR : la condition n'est pas un booléen
- For : ERROR : l'expression de départ n'est pas un entier
- Assign : ERROR : une variable est assignée à un appel de fonction qui retourne plusieurs valeurs
- Assign : ERROR : le nombre de variables à assigner est différent du nombre de valeurs assignées
- Variable : WARNING : une variable en input n'est pas utilisée dans la fonction
- Variable : WARNING : une variable en output n'est pas assignée dans la fonction
- Variable : ERROR : plusieurs variables de l'input ont le même nom
- Variable : ERROR : plusieurs variables de l'output ont le même nom
- TODO Function : ERROR : plusieurs fonctions ont le même nom
- TODO Function : ERROR : le nom d'une fonction n'est pas valide
- TODO Function : ERROR : une fonction utilisée dans un appel n'est pas définie
- TODO Function : ERROR : une fonction appelées avec le mauvais nombre d'input
- TODO Program : ERROR : le programme doit avoir une fonction main