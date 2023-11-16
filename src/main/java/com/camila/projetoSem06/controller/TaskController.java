package com.camila.projetoSem06.controller;

import com.camila.projetoSemana06.projetoSemana06.model.Task;
import com.camila.projetoSemana06.projetoSemana06.model.Status;
import com.camila.projetoSemana06.projetoSemana06.model.Priority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        Task createdTask = taskService.createTask(task);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        List<Task> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<Task>> getTasksByStatus(@PathVariable("status") Status status) {
        List<Task> tasksByStatus = taskService.getTasksByStatus(status);
        return new ResponseEntity<>(tasksByStatus, HttpStatus.OK);
    }

    @GetMapping("/priority/{priority}")
    public ResponseEntity<List<Task>> getTasksByPriority(@PathVariable("priority") Priority priority) {
        List<Task> tasksByPriority = taskService.getTasksByPriority(priority);
        return new ResponseEntity<>(tasksByPriority, HttpStatus.OK);
    }

    @GetMapping("/assignee/{assignee}")
    public ResponseEntity<List<Task>> getTasksByAssignee(@PathVariable("assignee") String assignee) {
        List<Task> tasksByAssignee = taskService.getTasksByAssignee(assignee);
        return new ResponseEntity<>(tasksByAssignee, HttpStatus.OK);
    }
}
