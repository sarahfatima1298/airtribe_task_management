package com.airtribe.task_manager.service;

import com.airtribe.task_manager.model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    Project createProject(Project project);
    Optional<Project> getProjectById(Long id);
    List<Project> getAllProjects();
    Project updateProject(Long id, Project projectDetails);
    void deleteProject(Long id);
}