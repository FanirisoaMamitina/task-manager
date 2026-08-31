package com.example.taskmanager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskManagerTest {
    @Test
    void addTaskCreatesTaskWithIncrementingId() {
        TaskManager manager = new TaskManager();

        Task first = manager.addTask("Apprendre Java");
        Task second = manager.addTask("Écrire les tests");

        assertEquals(1, first.getId());
        assertEquals(2, second.getId());
        assertEquals(2, manager.getTasks().size());
    }

    @Test
    void completeTaskChangesStatus() {
        TaskManager manager = new TaskManager();
        Task task = manager.addTask("Lire la documentation");

        assertTrue(manager.completeTask(task.getId()));
        assertTrue(task.isCompleted());
    }

    @Test
    void deleteTaskRemovesExistingTask() {
        TaskManager manager = new TaskManager();
        Task task = manager.addTask("Tâche temporaire");

        assertTrue(manager.deleteTask(task.getId()));
        assertTrue(manager.getTasks().isEmpty());
        assertFalse(manager.deleteTask(task.getId()));
    }

    @Test
    void unknownTaskIdReturnsFalse() {
        TaskManager manager = new TaskManager();

        assertFalse(manager.completeTask(99));
        assertFalse(manager.deleteTask(99));
    }

    @Test
    void blankTitleIsRejected() {
        TaskManager manager = new TaskManager();

        assertThrows(IllegalArgumentException.class, () -> manager.addTask("   "));
    }
}
