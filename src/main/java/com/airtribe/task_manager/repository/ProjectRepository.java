package com.airtribe.task_manager.repository;


import com.airtribe.task_manager.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Additional query methods, if needed
}