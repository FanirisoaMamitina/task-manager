package com.example.taskmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Task Manager ===");
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> addTask(manager, scanner);
                case "2" -> displayTasks(manager);
                case "3" -> completeTask(manager, scanner);
                case "4" -> deleteTask(manager, scanner);
                case "5" -> running = false;
                default -> System.out.println("Choix invalide. Sélectionnez un numéro de 1 à 5.");
            }
        }

        scanner.close();
        System.out.println("Au revoir !");
    }

    private static void printMenu() {
        System.out.println("\n1. Ajouter une tâche");
        System.out.println("2. Afficher les tâches");
        System.out.println("3. Marquer une tâche comme terminée");
        System.out.println("4. Supprimer une tâche");
        System.out.println("5. Quitter");
        System.out.print("Votre choix : ");
    }

    private static void addTask(TaskManager manager, Scanner scanner) {
        System.out.print("Titre de la tâche : ");
        String title = scanner.nextLine();
        try {
            Task task = manager.addTask(title);
            System.out.println("Tâche ajoutée avec l'identifiant " + task.getId() + ".");
        } catch (IllegalArgumentException exception) {
            System.out.println("Erreur : " + exception.getMessage());
        }
    }

    private static void displayTasks(TaskManager manager) {
        if (manager.getTasks().isEmpty()) {
            System.out.println("Aucune tâche enregistrée.");
            return;
        }
        System.out.println("\n--- Liste des tâches ---");
        manager.getTasks().forEach(System.out::println);
    }

    private static void completeTask(TaskManager manager, Scanner scanner) {
        int id = readId(scanner, "Identifiant de la tâche à terminer : ");
        System.out.println(manager.completeTask(id)
                ? "Tâche marquée comme terminée."
                : "Tâche introuvable.");
    }

    private static void deleteTask(TaskManager manager, Scanner scanner) {
        int id = readId(scanner, "Identifiant de la tâche à supprimer : ");
        System.out.println(manager.deleteTask(id)
                ? "Tâche supprimée."
                : "Tâche introuvable.");
    }

    private static int readId(Scanner scanner, String message) {
        System.out.print(message);
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException exception) {
            return -1;
        }
    }
}
