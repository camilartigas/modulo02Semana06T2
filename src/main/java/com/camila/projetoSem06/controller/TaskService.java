package com.camila.projetoSem06.controller;


import com.camila.projetoSem06.model.Priority;
import com.camila.projetoSem06.model.Status;
import com.camila.projetoSem06.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TaskService {

    private final List<Task> taskList = new ArrayList<>();
    private final AtomicLong taskIdCounter = new AtomicLong(1);

    public Task createTask(Task task) {
        task.setId(taskIdCounter.getAndIncrement());
        taskList.add(task);
        return task;
    }

    public List<Task> getAllTasks() {
        return taskList;
    }

    public List<Task> getTasksByStatus(Status status) {
        List<Task> tasksByStatus = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getStatus().equals(status)){
                tasksByStatus.add(task);
            }
        }
        return tasksByStatus;
    }

    public List<Task> getTasksByPriority(Priority priority) {
        List<Task> tasksByPriority = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getPriority().equals(priority)) {
                tasksByPriority.add(task);
            }
        }
        return tasksByPriority;
    }

    public List<Task> getTasksByAssignee(String assignee) {
        List<Task> tasksByAssignee = new ArrayList<>();
        for (Task task : taskList) {
            if (task.getAssignee().equals(assignee)) {
                tasksByAssignee.add(task);
            }
        }
        return tasksByAssignee;
    }

    public Task getTaskById(Long taskId) {
        for (Task task : taskList) {
            if (task.getId().equals(taskId)) {
                return task;
            }
        }
        return null;
    }

    public Task updateTask(Task updatedTask) {
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getId().equals(updatedTask.getId())) {
                taskList.set(i, updatedTask);
                return updatedTask;
            }
        }
        return null;
    }

    public boolean deleteTaskById(Long taskId) {
        for (Task task : taskList) {
            if (task.getId().equals(taskId)) {
                taskList.remove(task);
                return true;
            }
        }
        return false;
    }

}

