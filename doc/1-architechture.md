Dans cette section, nous allons décrire l'architecture du compilateur et la chaîne de compilation utilisée pour transformer le code source écrit en langage While en un programme exécutable en Python. 

Voici les étapes de la chaîne de compilation:

- **Analyse lexical et syntaxique du fichier d'entrée**: Cette étape consiste à utiliser un analyseur lexical et syntaxique pour analyser le fichier source et générer un arbre de syntaxe abstraite (AST). L'AST représente la structure logique du programme en utilisant des nœuds qui correspondent aux différentes constructions syntaxiques du langage While. Il est utilisé comme une représentation intermédiaire pour les étapes suivantes.

- **Impression de l'AST en PlantUML**: Cette étape consiste à imprimer l'AST généré en utilisant le format PlantUML, qui permet une meilleure visualisation de la structure du code. Il est utilisé uniquement si l'option `-d` (Debug) est spécifiée pour faciliter le débogage en cas de besoin.
  
- **Validation de l'AST**: Cette étape consiste à valider l'AST généré pour vérifier qu'il respecte la spécification du langage While. Cela permet de détecter les erreurs de syntaxe ou de sémantique dans le code source.
  

- **Génération de code à 3 adresses**: Cette étape consiste à générer un code intermédiaire à 3 adresses à partir de l'AST valide. Le code à 3 adresses est une représentation intermédiaire qui facilite l'optimisation et la génération de code cible. Il est composé de codes de bas niveau qui peuvent être facilement mappés sur des instructions machine.

- **Optimisation du code 3 adresses**: Cette étape consiste à optimiser le code à 3 adresses généré pour améliorer les performances de l'exécution. Il peut inclure des techniques telles que la suppression de code mort, la fusion d'instructions, la propagation de constantes, et ainsi de suite.

- **Génération de code cible:** Cette étape consiste à générer le code cible en Python à partir du code à 3 adresses. Il utilise les instructions à 3 adresses pour générer les instructions Python équivalentes, en utilisant une table de correspondance pour chaque instruction à 3 adresses.

- **Écriture du fichier de sortie**: Cette étape consiste à écrire le code cible généré dans un fichier de sortie. Il peut être utilisé pour sauvegarder le fichier pour une utilisation ultérieure.

- **Exécution du fichier de sortie**: Cette étape consiste à exécuter le fichier de sortie en utilisant l'interpréteur Python pour vérifier son bon fonctionnement. Cette étape est effectée uniquement si l'option `-x` (Execute) est spécifiée, cela permet de tester rapidement le fichier de sortie généré. Cette étape est importante pour s'assurer que le code généré est fonctionnel et qu'il produit les résultats escomptés.


Dans les sections suivantes, nous allons décrire les détails de chaque étape de la chaîne de compilation.

[Retour au sommaire](./readme.md)