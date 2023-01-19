# Introduction

Pour que le programme Python généré puisse être exécuté, il faut que le programme Python qui l'exécute soit capable de manipuler les expressions du langage While. Pour cela, nous avons créé une bibliothèque de fonctions qui permettent de manipuler les expressions du langage While. 

Cette bibliothèque est disponible dans le fichier [`resources/base.py`](../resources/base.py). Nous allons voir dans cette section comment cette bibliothèque est utilisée.

# La base de code (Librairie runtime)

Notre bibliothèque de fonctions pour le runtime est directement intégré avec le code Python généré pour faciliter son utilisation.

Pour cela, nous ouvrons le fichier `resources/base.py` et nous le copions dans le code Python généré à la place de la ligne `# CODE INSERTED HERE`.

### BinTree

Dans la librairie runtime nous avons la classe `BinTree` qui est utilisée pour représenter les expressions du langage While sous forme d'arbre binaire. 

Cette classe est aussi utilisée pour convertir les expressions du langage While (arbre binaire) en expressions lisibles par l'humain (le "Pretty Printer").

Le Pretty Printer permet d'afficher l'arbre binaire en 3 formats différents:
- `string` : Affiche l'arbre binaire sous forme de chaîne de caractères.
- `int` : Affiche l'arbre binaire sous forme d'entier.
- `bool` : Affiche l'arbre binaire sous forme de booléen.

Pour l'utilisation du Pretty Printer dans le langage While, je vous laisse vous référer à la [spécification du langage](Specifications_while.pdf).

### Main

En While, la fonction principale est appelée `main`. Cette fonction est appelée par le code Python.

Pour lancer cette fonction principale, nous utilisons les lignes suivantes:

```python
if __name__ == "__main__":
    stack = []
    for i, value in enumerate(main()):
        print(value)
```

Ce bout de code va appeler la fonction principale `main` et afficher les valeurs de retour de cette fonction en appelant le Pretty Printer.

### Les arguments de l'entrée standard

Nous pouvons voir avec la section précédente que les arguments de l'entrée standard ne sont pas utilisés dans le code Python généré.

Cela est du au fait que durant la compilation, nous avons converti les arguments de l'entrée standard en expressions du langage While. Ces expressions sont stockées directement dans le code Python généré (au début de la fonction `main`). 

Ce choix a été fait pour faciliter l'utilisation de la librairie runtime ainsi que pour facilement pouvoir convertir avec ANTLR les arguments de l'entrée standard en expressions du langage While durant la compilation.

**Exemple** : 
  
Le script While `sample/good/double.while` nécessite un argument de l'entrée standard.

```bash
$ java -jar target/whilec.jar sample/good/double.while 3
$ python output.py 
6
```

Ici, le compilateur va convertir l'argument `3` en une expression du langage While et l'insérer dans le code Python généré. C'est pour cela que nous lançons le code Python généré sans argument.


# Verbosité

Si le compilateur est lancé avec l'option `-v`, le code Python généré sera plus verbeux. En effet, il affichera plus de détails sur les valeurs de retour de la fonction principale `main` avec une visualisation de l'arbre binaire.

Pour cette option, le compilateur va utiliser la librairie runtime `resources/base_verbose.py` à la place de `resources/base.py`.

# Exemple avec et sans verbosité

Voici un exemple d'execution du compilateur **sans** l'option `-v`:

```bash
$ java -jar whilec.jar sample/good/double.while 3
$ python output.py 
6
```

Voici un exemple d'execution du compilateur **avec** l'option `-v`:

```bash
$ java -jar whilec.jar sample/good/double.while 3 -v
$ python output.py 
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


[Retour au sommaire](./readme.md)