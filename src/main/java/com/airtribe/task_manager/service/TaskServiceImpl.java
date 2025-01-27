package com.airtribe.task_manager.service;

import com.airtribe.task_manager.model.Task;
import com.airtribe.task_manager.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Long id, Task task) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            Task updatedTask = existingTask.get();
            updatedTask.setTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setDueDate(task.getDueDate());
            updatedTask.setCompleted(task.isCompleted());
            return taskRepository.save(updatedTask);
        } else {
            throw new RuntimeException("Task not found with id " + id);
        }
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    // Implementing the new methods
    @Override
    public List<Task> getTasksByStatus(boolean completed) {
        return taskRepository.findByCompleted(completed);
    }

    @Override
    public List<Task> getTasksByKeyword(String keyword) {
        return taskRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Override
    public List<Task> getTasksBetweenDates(java.time.LocalDate startDate, java.time.LocalDate endDate) {
        return taskRepository.findByDueDateBetween(startDate, endDate);
    }

    @Override
    public List<Task> getTasksByUserId(Long userId) {
        return taskRepository.findTasksByUserId(userId);
    }
}
