package com.camila.projetoSem06.controller;

import com.camila.projetoSem06.model.Priority;
import com.camila.projetoSem06.model.Status;
import com.camila.projetoSem06.model.Task;
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
    public ResponseEntity<List<Task>> getTasksByFilters(
            @RequestParam(value = "status", required = false) Status status,
            @RequestParam(value = "priority", required = false) Priority priority,
            @RequestParam(value = "assignee", required = false) String assignee) {

        if (status != null) {
            List<Task> tasksByStatus = taskService.getTasksByStatus(status);
            return new ResponseEntity<>(tasksByStatus, HttpStatus.OK);
        } else if (priority != null) {
            List<Task> tasksByPriority = taskService.getTasksByPriority(priority);
            return new ResponseEntity<>(tasksByPriority, HttpStatus.OK);
        } else if (assignee != null) {
            List<Task> tasksByAssignee = taskService.getTasksByAssignee(assignee);
            return new ResponseEntity<>(tasksByAssignee, HttpStatus.OK);
        } else {
            List<Task> allTasks = taskService.getAllTasks();
            return new ResponseEntity<>(allTasks, HttpStatus.OK);
        }
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<Task> updateTask(
            @PathVariable Long taskId,
            @RequestBody Task updatedTask) {
        Task existingTask = taskService.getTaskById(taskId);

        if (existingTask == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Atualiza os campos da tarefa existente com os novos valores recebidos
        existingTask.setDescription(updatedTask.getDescription());
        existingTask.setStatus(updatedTask.getStatus());
        existingTask.setPriority(updatedTask.getPriority());
        existingTask.setAssignee(updatedTask.getAssignee());

        Task updated = taskService.updateTask(existingTask);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long taskId) {
        boolean isRemoved = taskService.deleteTaskById(taskId);

        if (isRemoved) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
