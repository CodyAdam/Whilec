# Introduction

Le but de faire une code 3 adresses est de pouvoir générer un code machine plus facilement dans plusieurs langages de programmation en réutilisant le même code intermédiaire et l'optimisation qui va avec.

Le code 3 adresses est une succession d'instructions de bas niveau qui peuvent être facilement mappés sur des instructions machine.

# Instructions

Pour représenter une instruction du C3A, nous utilisons une classe `C3A.Instruction`.
Et pour représenter une liste d'instructions, nous utilisons une classe `C3A.Instructions`.

Toutes les instructions possible du C3A héritent de la classe `C3A.Instruction` et implémentent la méthode `to_string` qui permet d'afficher l'instruction sous forme de chaîne de caractères lisibles.

Nous avons les instructions suivantes:

| Instruction | Description                                      | Exemple                      |
| ----------- | ------------------------------------------------ | ---------------------------- |
| Assign      | Affectation d'une valeur à une variable          | `A = nil`                    |
| AssignTab   | Affectation d'une valeur à une case d'un tableau | `A[1] = 2`                   |
| Comment     | Commentaire (pour débuguer)                      | `// Ceci est un commentaire` |
| FuncBegin   | Début d'une fonction                             | `func begin main`            |
| FuncEnd     | Fin d'une fonction                               | `func end`                   |
| FuncReturn  | Variable de retour (multiple par fonction)       | `return Variable1`           |
| Goto        | Saut inconditionnel                              | `goto label1`                |
| IfzGoto     | Saut conditionnel                                | `ifz Variable1 goto label1`  |
| Label       | Définition d'un label                            | `label1:`                    |
| Nop         | Instruction vide                                 | `nop`                        |
| Push        | Empiler une valeur (pour les param. de func.)    | `push Variable1`             |
| Unop        | Opération unaire (tail ou head)                  | `A = tl Variable1`           |


# Assignement

L'affectation est représentée par la classe `Assign` qui est représentée par la structure suivante `Variable = ToAssign`.

`ToAssign` est une classe abstraite qui peut être soit une :

| ToAssign | Description                                   | Exemple              |
| -------- | --------------------------------------------- | -------------------- |
| FuncCall | Appel d'une fonction avec nb. param.          | `A = call double0 1` |
| Nil      | Valeur null du langue                         | `A = nil`            |
| Pop      | Dépiler une valeur (pour les param. de func.) | `A = pop`            |
| Symbol   | Une chaine ou nom de fonction                 | `A = "hello"`        |
| TabValue | Une valeur d'un tableau                       | `A = A[1]`           |
| Unop     | Une opération unaire (tail ou head)           | `A = tl Variable1`   |
| Variable | Une variable                                  | `A = B`              |


# Génération du code 3 adresses

Pour générer les instructions du C3A, nous utilisons une classe `C3A.Generator`. Cette classe utilise le pattern `Visitor` pour parcourir l'AST et générer les instructions du C3A.

Pour chaque TOKEN de l'AST, nous avons une méthode qui génère une classe `Instructions` qui contient les instructions du C3A.

# Exemple 

Voici le code 3 adresses généré pour la fonction `double` du fichier `sample/good/double.while`:

```bash
java -jar whilec.jar sample/good/double.while 3 -d
```

> Note : Pour afficher le code 3 adresses, il faut utiliser l'option `-d` (Debug) de la commande `whilec`.

```
--- 3 Adress Code Start ---
func begin double0
X_0 = pop
// For
VARIABLE_1 = X_0
for_start_0:
ifz VARIABLE_1 goto for_end_1:
// Assign
VARIABLE_4 = X_0
CONS_FIRST_3 = VARIABLE_4
NIL_6 = nil
CONS_5[0] = NIL_6
CONS_5[1] = CONS_FIRST_3
CONS_2 = CONS_5
X_0 = CONS_2
VARIABLE_1 = tl VARIABLE_1
goto for_start_0
for_end_1:
return X_0
func end

func begin main
INT_ARG_8 = nil
INT_ARG_9[0] = nil
INT_ARG_9[1] = INT_ARG_8
INT_ARG_9 = INT_ARG_9
INT_ARG_10[0] = nil
INT_ARG_10[1] = INT_ARG_9
INT_ARG_10 = INT_ARG_10
INT_ARG_11[0] = nil
INT_ARG_11[1] = INT_ARG_10
INT_ARG_11 = INT_ARG_11
ARG1_7 = INT_ARG_11
push ARG1_7
UserInput_12 = pop
Output_13 = nil
// Assign
VARIABLE_17 = UserInput_12
push VARIABLE_17
FUNCCALL_TEMP_18 = call double0 1
FUNCTIONCALL_16 = FUNCCALL_TEMP_18[0]
CONS_FIRST_15 = FUNCTIONCALL_16
SYMBOL_20 = "int"
CONS_19[0] = SYMBOL_20
CONS_19[1] = CONS_FIRST_15
CONS_14 = CONS_19
Output_13 = CONS_14
return Output_13
func end

--- 3 Adress Code End ---
```


[Retour au sommaire](./readme.md)