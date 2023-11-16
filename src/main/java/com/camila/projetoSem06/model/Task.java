package com.camila.projetoSem06.model;

import ch.qos.logback.core.status.Status;
import jakarta.annotation.Priority;

import java.util.concurrent.atomic.AtomicLong;

public class Task {

    //declaracao de variáveis

    private static final AtomicLong taskIdCounter = new AtomicLong();
    private Long id;
    private String description;
    private Status status; //representa o status de uma tarefa (pendente, em andamento, concluída).
    private Priority priority; //representa a prioridade de uma tarefa (baixa, média, alta).
    private String assignee; //nome do responsável pela tarefa.

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

    // Métodos Getters e Setters para os atributos

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

