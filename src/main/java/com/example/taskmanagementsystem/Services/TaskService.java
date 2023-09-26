package com.example.taskmanagementsystem.Services;

import com.example.taskmanagementsystem.Model.Task;
import com.example.taskmanagementsystem.Reposiotry.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getPendingTasks() {
        return taskRepository.findByCompletedFalse();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
    }
}
