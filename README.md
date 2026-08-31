# Task Manager — Java Console avec Maven et JUnit

Application de gestion de tâches en console, réalisée en Java avec Maven. Elle ne nécessite aucune base de données : les tâches sont conservées en mémoire pendant l’exécution du programme.

## Fonctionnalités

| Choix | Fonction |
|---|---|
| 1 | Ajouter une tâche avec un titre |
| 2 | Afficher toutes les tâches avec leur état |
| 3 | Marquer une tâche comme terminée à partir de son identifiant |
| 4 | Supprimer une tâche à partir de son identifiant |
| 5 | Quitter l’application |

## Architecture

```text
task-manager/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/example/taskmanager/
│   │           ├── Main.java
│   │           ├── Task.java
│   │           └── TaskManager.java
│   │
│   └── test/
│       └── java/
│           └── com/example/taskmanager/
│               └── TaskManagerTest.java
│
├── pom.xml
└── README.md
```

## Prérequis

Installez **IntelliJ IDEA**, un **JDK 17 ou plus récent**, et Maven. IntelliJ peut télécharger et gérer Maven automatiquement à partir du fichier `pom.xml`.

Vérifiez l’installation dans un terminal :

```bash
java -version
mvn -version
```

## Ouvrir le projet dans IntelliJ IDEA

1. Décompressez l’archive du projet.
2. Dans IntelliJ IDEA, sélectionnez **File > Open**.
3. Choisissez le dossier `task-manager`.
4. IntelliJ détecte automatiquement le fichier `pom.xml` et propose de charger le projet Maven.
5. Acceptez l’importation Maven.
6. Dans **File > Project Structure > Project**, sélectionnez votre JDK, idéalement JDK 17 ou 21.
7. Vérifiez que le dossier `src/main/java` est reconnu comme dossier de sources et que `src/test/java` est reconnu comme dossier de tests.

## Exécuter l’application

Ouvrez :

```text
src/main/java/com/example/taskmanager/Main.java
```

Cliquez sur le triangle vert situé à côté de la méthode `main`, puis sélectionnez **Run 'Main.main()'**.

Exemple d’utilisation :

```text
=== Task Manager ===

1. Ajouter une tâche
2. Afficher les tâches
3. Marquer une tâche comme terminée
4. Supprimer une tâche
5. Quitter
Votre choix : 1
Titre de la tâche : Apprendre Maven
Tâche ajoutée avec l'identifiant 1.
```

Les identifiants commencent à 1 et augmentent automatiquement. Une tâche affichée avec `[X]` est terminée ; une tâche affichée avec `[ ]` est encore active.

## Exécuter les tests JUnit

Dans IntelliJ, faites un clic droit sur `TaskManagerTest.java`, puis choisissez **Run 'TaskManagerTest'**.

Depuis un terminal à la racine du projet, utilisez :

```bash
mvn test
```

Les tests vérifient l’ajout avec identifiants, la terminaison, la suppression, les identifiants inexistants et le refus d’un titre vide.

## Commandes Maven utiles

```bash
mvn clean
mvn compile
mvn test
mvn clean test
```

La commande `mvn clean test` supprime les fichiers générés, recompile le projet et exécute tous les tests.

## Classes principales

`Task` représente une tâche et contient son identifiant, son titre et son état terminé ou non. `TaskManager` centralise la liste des tâches ainsi que les opérations métier. `Main` gère l’affichage du menu et la communication avec l’utilisateur dans la console. `TaskManagerTest` contient les tests unitaires JUnit 5.

## Limitation actuelle

Les tâches sont stockées uniquement en mémoire. Elles disparaissent lorsque le programme est fermé. Une amélioration possible serait d’ajouter une sauvegarde dans un fichier JSON ou texte, puis de charger les tâches au démarrage.
