package com.example.taskmanagementsystem.Controller;

import com.example.taskmanagementsystem.Model.Task;
import com.example.taskmanagementsystem.Services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/pending")
    public List<Task> getPendingTasks() {
        return taskService.getPendingTasks();
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable String taskId, @RequestBody Task task) {
        task.setId(taskId);
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable String taskId) {
        taskService.deleteTask(taskId);
    }
}
