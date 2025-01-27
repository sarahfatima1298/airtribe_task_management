package com.airtribe.task_manager.service;

import com.airtribe.task_manager.model.Task;
import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task createTask(Task task);
    Optional<Task> getTaskById(Long id);
    List<Task> getAllTasks();
    Task updateTask(Long id, Task task);
    void deleteTask(Long id);

    // New methods for filtering, sorting, and searching
    List<Task> getTasksByStatus(boolean completed);
    List<Task> getTasksByKeyword(String keyword);
    List<Task> getTasksBetweenDates(java.time.LocalDate startDate, java.time.LocalDate endDate);
    List<Task> getTasksByUserId(Long userId);
}
