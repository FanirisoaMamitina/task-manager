package com.example.taskmanager;

import java.util.Objects;

public class Task {
    private final int id;
    private final String title;
    private boolean completed;

    public Task(int id, String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Le titre de la tâche ne peut pas être vide.");
        }
        this.id = id;
        this.title = title.trim();
        this.completed = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }

    public void markCompleted() { completed = true; }

    @Override
    public String toString() {
        return String.format("[%s] %d - %s", completed ? "X" : " ", id, title);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Task task)) return false;
        return id == task.id;
    }

    @Override
    public int hashCode() { return Objects.hash(id); }
}
