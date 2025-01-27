package com.airtribe.task_manager.controller;

import com.airtribe.task_manager.model.Team;
import com.airtribe.task_manager.model.User;
import com.airtribe.task_manager.repository.TeamRepository;
import com.airtribe.task_manager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/{teamId}/addUser/{userId}")
    public ResponseEntity<String> addUserToTeam(@PathVariable Long teamId, @PathVariable Long userId) {
        Optional<Team> teamOpt = teamRepository.findById(teamId);
        Optional<User> userOpt = userRepository.findById(userId);

        if (teamOpt.isPresent() && userOpt.isPresent()) {
            Team team = teamOpt.get();
            User user = userOpt.get();
            team.getMembers().add(user);
            teamRepository.save(team);
            return ResponseEntity.ok("User added to team");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
