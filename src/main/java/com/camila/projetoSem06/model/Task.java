package com.camila.projetoSem06.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.concurrent.atomic.AtomicLong;

public class Task {

    private static final AtomicLong taskIdCounter = new AtomicLong();
    private Long id;
    private String description;

    @JsonFormat(shape = JsonFormat.Shape.STRING) // Adicionando anotação para mapear o enum Status
    private Status status;

    private Priority priority;
    private String assignee;

    // Construtor vazio
    public Task() {
        this.id = generateUniqueTaskId();
    }

    // Construtor com todos os atributos
    public Task(String description, Status status, Priority priority, String assignee) {
        this.id = generateUniqueTaskId();
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    private Long generateUniqueTaskId() {
        return taskIdCounter.getAndIncrement();
    }
}
