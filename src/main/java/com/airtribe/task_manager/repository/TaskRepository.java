package com.airtribe.task_manager.repository;

import com.airtribe.task_manager.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Find tasks by completion status
    List<Task> findByCompleted(boolean completed);

    // Find tasks by title containing keyword (case insensitive)
    List<Task> findByTitleContainingIgnoreCase(String keyword);

    // Find tasks by due date (upcoming or past)
    List<Task> findByDueDateBetween(java.time.LocalDate startDate, java.time.LocalDate endDate);

    // Custom query to fetch tasks assigned to a specific user
    @Query("SELECT t FROM Task t WHERE t.user.id = :userId")
    List<Task> findTasksByUserId(@Param("userId") Long userId);
}
