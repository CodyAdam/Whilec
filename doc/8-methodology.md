Partage de travail, spécification de l'ast ensemble pour bien séparer le travail ensuite.
Utilisation Figma et discord pour la collaboration.

# Outils du projet

## Figma

Nous avons utilisé Figma pour reflechir à la conception de l'ast et à l'ensemble des tokens du langage. Grâce à cet outil, nous avons aussi determiné quelles classes java nous allions utiliser pour notre projet.

Pour chacune de ces idées Figma nous a permis discuter leur pertinence et de réflechir à de potentielles alternatives. De plus, à chaque modification de notre réflexion, l'ensemble des membres du groupe pouvait être au courant et voir les modifications.

## Discord

Nous avons utilisé Discord pour travailler à distance ensemble. Nous pouvions en direct discuter de nos idées, de nos avancées et de nos difficultés. Nous avons aussi pu partager sur cet outils nos écrans pour travailler ensemble sur le code et l'ast. Sur Discord, nous avons aussi pu regrouper l'ensemble des liens utiles pour le projet.

# Organisation du travail

## Etapes de développement

### Début du projet

Nous avons commencé par créer un grammaire while sur antlr d'un côté et de l'autre le projet java. En faisant cela, nous avons pu travailler en parallèle par groupe de 2. Nous avons fonctionné de cette manière jusqu'à avoir :
- un prémisse de grammaire capable de traiter un cas particulier du langage while.
- un projet java basique capable d'importer et lancer un déroulement d'un ast sur un fichier while.

### AST et génération du code 3 adresses

Une fois structure de la grammaire et du projet java étbalie. Nous avons commencé à travailler sur l'ast et la génération du code 3 adresses. Pour cela nous nous sommes mis d'accord sur une structure de l'ast et sur les classes java du projet sur Figma. 

En continuant à travailler en binomes, nous avons ainsi commencé à travailler sur la génération du code 3 adresses et de la grammaire. Nous faisions des retours sur les avancées de chacun régulièrement pour faire évoluer la structure de l'ast et les classes java du projet ensemble.

### Perfectionnement de l'AST et optimisation du code 3 adresses

Avec un premier code 3 adresses généré et un ast fonctionnel, nous avons commencé à travailler sur l'optimisation du code 3 adresses.(Suppression des variables inutiles / optimisation des expressions arithmétiques / etc...)

En même temps, nous avons continué à optimiser l'ast et à le rendre plus lisible.

Durant cette étape, nous avons fait des retours sur les avancées de chacun régulièrement pour faire évoluer la structure de l'ast et les classes java du projet ensemble.

### Compilation en langage cible et validation

Nous sommes ensuite passé à la compilation en langage cible. (Python) et la validation du code while de l'utilisateur.

L'implémentation de l'AST et de la compilation en langage cible ont elles aussi faites ressortir des problèmes dans l'ast et dans le code 3 adresses. Ainsi pour chaque problème rencontré, nous avons fait des points globaux pour déterminer comment les résoudre au mieux.

A la fin de cette étape, nous avons fait un point global sur l'ensemble du projet pour déterminer les dernières améliorations à apporter et nous sommes arriver au résultat final tel que présenté dans le rapport.

## Répartition des tâches

Nous avons fait deux binome stout au long du projet, de sorte à travailler plus efficacement. Nous avons ainsi pu avancer plus rapidement sur le projet. Nous avons aussi pu nous répartir les tâches de manière plus équitable.

Le premier binome était composé de Romain Briend et Arthur Allain. Ils ont travaillé sur la grammaire et sur la génération de l'ast dans un premier temps. Ils ont ensuite travaillé sur la validation.

Le second binome était composé de Thomas Delapart et Cody Adam. Ils ont travaillé sur la génération du code 3 adresses à partir de l'ast. Ils ont ensuite travaillé sur la compilation en langage cible.

## Rapports personnels

### [Cody Adam](8.2-cody-adam.md)

### [Thomas Delapart](8.3-thomas-delapart.md)

### [Arthur Allain](8.4-arthur-allain.md)

### [Romain Briend](8.1-romain-briend.md)