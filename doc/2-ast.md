## Description de l'AST :

Dans cette section nous allons décrire l'AST, c'est-à-dire la représentation formelle de notre langage par des tokens.

###Structure du programme

Tout d'abord, un programme est représenté par une racine ayant pour fils des fonctions :

![img_1.png](assets/img_1.png)

Une fonction a tout d'abord un nom, puis un token définition de fonction. Celui-ci a optionnellement une entrée, des commandes, c'est-à-dire le corps de la fonction et obligatoirement une sortie :

![img_3.png](assets/img_3.png)

L'entrée et la sortie correspondent directement à des variables comme on peut le voir :

![img_4.png](assets/img_4.png)

###Commandes


Les commandes, soit les instructions du corps de la fonction peuvent correspondre à des instructions comme des boucles ou des conditions, à des déclarations/modifications de variables ou l'instruction vide 'nop'. Il faut au moins une commande :

![img_6.png](assets/img_6.png)

L'affectation de variables peut être effectuée sur plusieurs variables à partir d'expressions :

![img_7.png](assets/img_7.png)

Les conditionnelles peuvent sont composées d'une expression à vérifier, de commandes et d'éventuelles commandes à effectuer en cas de non-respect de la première expression :

![img_8.png](assets/img_8.png)

Pour les boucles 'for' et 'while', la structure est la même :

for:

![img_9.png](assets/img_9.png)

while:

![img_10.png](assets/img_10.png)

Les boucles 'foreach' prennent elles en entrée une variable qui est la structure à parcourir :

![img_11.png](assets/img_11.png)

Enfin, l'instruction 'nop' correspond juste au token 'NOP'.

###Expressions 

Les expressions sont tout d'abord représentées par une suite d'expressions :

![img_12.png](assets/img_12.png)

Une expression peut correspondre à une variable, une liste, une queue, un tas, un appel de fonction, une valeur, un symbole ou la valeur 'nil' :

![img_14.png](assets/img_14.png)

Comme on peut le voir, les symboles et variables sont décrits directement par un nom de variable.
Les structures comme les listes, les queues, les tas et l'appel de fonctions contiennent d'autres expressions dans la hiérarchie correspondant à leurs données :

Par exemple pour les listes : 

![img_15.png](assets/img_15.png)

On peut remarquer que l'on peut imbriquer n'importe quelle expression comme un appel de fonction ou une autre liste dedans.
