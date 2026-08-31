package com.example.taskmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();
    private int nextId = 1;

    public Task addTask(String title) {
        Task task = new Task(nextId++, title);
        tasks.add(task);
        return task;
    }

    public List<Task> getTasks() {
        return Collections.unmodifiableList(tasks);
    }

    public boolean completeTask(int id) {
        return findTask(id).map(task -> {
            task.markCompleted();
            return true;
        }).orElse(false);
    }

    public boolean deleteTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    public Task getTask(int id) {
        return findTask(id).orElse(null);
    }

    private java.util.Optional<Task> findTask(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst();
    }
}
