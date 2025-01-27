package com.airtribe.task_manager.util;

import com.airtribe.task_manager.model.Project;
import com.airtribe.task_manager.model.Task;
import com.airtribe.task_manager.model.TaskStatus;
import com.airtribe.task_manager.model.Team;
import com.airtribe.task_manager.model.User;
import com.airtribe.task_manager.repository.ProjectRepository;
import com.airtribe.task_manager.repository.TaskRepository;
import com.airtribe.task_manager.repository.TeamRepository;
import com.airtribe.task_manager.repository.UserRepository;
import com.task_master.task_management.model.*;
import com.task_master.task_management.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;

@Configuration
public class DataInitializationConfig {

    @Bean
    CommandLineRunner initData(
            UserRepository userRepository,
            TeamRepository teamRepository,
            ProjectRepository projectRepository,
            TaskRepository taskRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {
            // Initialize Teams
            Team devTeam = new Team(null, "Development Team", Collections.emptySet());
            Team qaTeam = new Team(null, "QA Team", Collections.emptySet());
            devTeam = teamRepository.save(devTeam);
            qaTeam = teamRepository.save(qaTeam);

            // Initialize Users with BCrypt password encoding
            User admin = new User(null, "admin", passwordEncoder.encode("admin123"), "admin@example.com", Set.of(devTeam), Collections.emptySet());
            User user1 = new User(null, "user1", passwordEncoder.encode("user123"), "user1@example.com", Set.of(devTeam), Collections.emptySet());
            User user2 = new User(null, "user2", passwordEncoder.encode("user123"), "user2@example.com", Set.of(qaTeam), Collections.emptySet());
            admin = userRepository.save(admin);
            user1 = userRepository.save(user1);
            user2 = userRepository.save(user2);

            // Initialize Projects with correct constructor
            Project taskManagementProject = new Project(null, "Task Management System", "Build and maintain task management app", Set.of(admin, user1), devTeam);
            Project qaAutomationProject = new Project(null, "QA Automation", "Implement automated tests for all projects", Set.of(user2), qaTeam);
            taskManagementProject = projectRepository.save(taskManagementProject);
            qaAutomationProject = projectRepository.save(qaAutomationProject);

            // Initialize Tasks with appropriate associations
            Task task1 = new Task(null, "Setup Project", "Initialize the project repository and setup environment", LocalDate.parse("2024-01-05"), false, admin, taskManagementProject, TaskStatus.IN_PROGRESS, Collections.emptySet());
            Task task2 = new Task(null, "Design Database Schema", "Create an ERD and define database schema", LocalDate.parse("2024-01-10"), false, admin, taskManagementProject, TaskStatus.PENDING, Collections.emptySet());
            Task task3 = new Task(null, "Implement Login", "Develop user authentication and authorization", LocalDate.parse("2024-01-15"), false, user1, taskManagementProject, TaskStatus.PENDING, Collections.emptySet());
            Task task4 = new Task(null, "Create Test Cases", "Write test cases for all modules", LocalDate.parse("2024-02-10"), false, user2, qaAutomationProject, TaskStatus.PENDING, Collections.emptySet());
            taskRepository.save(task1);
            taskRepository.save(task2);
            taskRepository.save(task3);
            taskRepository.save(task4);
        };
    }
}
