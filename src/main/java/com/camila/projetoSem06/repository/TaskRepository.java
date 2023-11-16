package com.camila.projetoSem06.repository;

import com.camila.projetoSemana06.projetoSemana06.model.Priority;
import com.camila.projetoSemana06.projetoSemana06.model.Status;
import com.camila.projetoSemana06.projetoSemana06.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskRepository {
    private static List<Task> taskList = new ArrayList<>();

    public static void saveTask(Task task) {
        taskList.add(task);
    }

    public static void removeTaskById(Long taskId) {
        taskList.removeIf(task -> task.getId().equals(taskId));
    }

    public static List<Task> getAllTasks() {
        return new ArrayList<>(taskList);
    }

    public static List<Task> getTasksByStatus(Status status) {
        return taskList.stream()
                .filter(task -> task.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    public static List<Task> getTasksByPriority(Priority priority) {
        return taskList.stream()
                .filter(task -> task.getPriority().equals(priority))
                .collect(Collectors.toList());
    }


    public static List<Task> getTasksByAssignee(String assignee) {
        return taskList.stream()
                .filter(task -> task.getAssignee().equals(assignee))
                .collect(Collectors.toList());
    }
}
