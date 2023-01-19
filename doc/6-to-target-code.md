# Introduction 

Dans cette section, nous allons décrire le processus de génération de code cible à partir du code à 3 adresses.

Pour langage cible nous avons choisi Python. Il y a plusieurs raisons à cela :

- **Simplicité**: Python est connu pour sa syntaxe simple et intuitive.
  
- **Connaissance**: Nous avons une bonne connaissance de Python et sa syntaxe, ce qui facilite la génération de code cible et le développement de fonctionnalités pour notre compilateur.

- **Portabilité**: Python est disponible sur de nombreuses plateformes, y compris Windows, MacOS et Linux, ce qui facilite la portabilité du code généré par notre compilateur.

- **Interprété**: Python est un langage interprété, ce qui signifie qu'il peut être exécuté directement sans avoir besoin d'un processus de compilation séparé, ce qui facilite l'exécution du code généré par notre compilateur.


# Génération de code cible

C'est la classe abstraite `Translator` qui est responsable de la génération de code cible. Elle définit une interface commune pour tous les générateurs de code cible. La classe `PythonTranslator` implémente cette interface et génère du code cible en Python.


Le processus de génération de code cible consiste à parcourir le C3A et de mapper chaque instruction sur une instruction équivalente en Python. Chaque implémentation de `Instruction` et de `ToAssign` a donc une méthode `toPython` qui génère le code Python équivalent.

# Goto

Le seul problème que nous avons rencontré lors de la génération de code cible sont les saut avec `goto`. En effet, en Python, il n'y a pas d'instruction goto. Nous avons donc du parcourir le C3A pour trouver les patterns utilisant `goto` et les remplacer leur équivalent en Python.

Dans la classe PythonTranslator, nous avons donc une méthode `multiplexer` qui parcourt le C3A et détermine s'il y a des patterns représentant des sauts inconditionnels. Si c'est le cas il redirige le flux d'exécution vers les méthodes `ifs`, `whiles` ou `for` qui génèrent le code Python équivalent. Sinon, il génère le code Python correspondant à l'instruction avec la méthode `toPython` de l'instruction.

# For, Foreach et While

Il faut savoir que quand l'on transforme un `for`, `foreach` ou `while` du code While en Python. Cette boucle devient une boucle while. En effet, une boucle `for` ou `foreach` en Python est une boucle while avec une condition d'arrêt.

# Exemple

Voici le code Python généré pour la fonction `double` du fichier `sample/good/double.while`:

```bash
java -jar whilec.jar sample/good/double.while 3
```
> Note : Dans le code ci-dessous, nous pouvons voir la classe `BinTree` qui est utilisée pour représenté les expressions du langage While sous forme d'arbre binaire. Nous parlerons de cette classe ainsi que des instruction à la fin du programme dans la [section suivante](7-runtime-lib.md).

```python
class BinTree:
    def __init__(self, left=None, right=None, key="CONS") -> None:
        self.left = left
        self.right = right
        self.key = key

    def __str__(self) -> str:
        return self.pp()

    def copy(self):
        return BinTree(self.left, self.right, self.key)

    def pp(self) -> str:
        if self.key == "NIL":
            return "nil"
        elif self.key == "CONS":
            if self.left.key == "int":
                return str(self.right.toInt())
            elif self.left.key == "bool":
                return "true" if self.right.toBool() else "false"
            elif self.left.key == "string":
                return self.right.toString()
            else:
                return f"(cons {self.left.pp()} {self.right.pp()})"
        else:
            return self.key

    def toInt(self):
        value = 0
        cursor = self
        if cursor.key == "CONS":
            value += 1
        while cursor.right:
            cursor = cursor.right
            if cursor.key == "CONS":
                value += 1
        return value

    def toBool(self):
        value = False
        cursor = self
        if cursor.key == "CONS":
            value = True
        return value

    def toString(self):
        value = ""
        cursor = self

        if cursor.key == "CONS":
            if cursor.left:
                value += cursor.left.toString()
            if cursor.right:
                value += cursor.right.toString()
        else:
            if cursor.key != "NIL":
                value += cursor.key
        return f"{value}"


def double0():
  global stack
  output = []
  X_0 = stack.pop()
  # For
  VARIABLE_1 = X_0.copy()
  while VARIABLE_1.toInt() > 0:
    # Assign
    VARIABLE_4 = X_0.copy()
    CONS_FIRST_3 = VARIABLE_4.copy()
    NIL_6 = BinTree(key="NIL")
    CONS_5 = BinTree(left=NIL_6.copy())
    CONS_5.right = CONS_FIRST_3.copy()
    CONS_2 = CONS_5.copy()
    X_0 = CONS_2.copy()
    VARIABLE_1 = VARIABLE_1.right
    # Goto

  output.append(X_0)
  return output
def main():
  global stack
  output = []
  INT_ARG_8 = BinTree(key="NIL")
  INT_ARG_9 = BinTree(left=BinTree(key="NIL"))
  INT_ARG_9.right = INT_ARG_8.copy()
  INT_ARG_9 = INT_ARG_9.copy()
  INT_ARG_10 = BinTree(left=BinTree(key="NIL"))
  INT_ARG_10.right = INT_ARG_9.copy()
  INT_ARG_10 = INT_ARG_10.copy()
  INT_ARG_11 = BinTree(left=BinTree(key="NIL"))
  INT_ARG_11.right = INT_ARG_10.copy()
  INT_ARG_11 = INT_ARG_11.copy()
  ARG1_7 = INT_ARG_11.copy()
  stack.append(ARG1_7)
  UserInput_12 = stack.pop()
  Output_13 = BinTree(key="NIL")
  # Assign
  VARIABLE_17 = UserInput_12.copy()
  stack.append(VARIABLE_17)
  FUNCCALL_TEMP_18 = double0()
  FUNCTIONCALL_16 = FUNCCALL_TEMP_18[0]
  CONS_FIRST_15 = FUNCTIONCALL_16.copy()
  SYMBOL_20 = BinTree(key= "int")
  CONS_19 = BinTree(left=SYMBOL_20.copy())
  CONS_19.right = CONS_FIRST_15.copy()
  CONS_14 = CONS_19.copy()
  Output_13 = CONS_14.copy()
  output.append(Output_13)
  return output

if __name__ == "__main__":
    stack = []
    for i, value in enumerate(main()):
        print(value)
```

[Retour au sommaire](./readme.md)
