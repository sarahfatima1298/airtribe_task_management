package com.airtribe.task_manager.service;

import com.airtribe.task_manager.model.Team;

import java.util.List;
import java.util.Optional;

public interface TeamService {
    Team createTeam(Team team);
    Optional<Team> getTeamById(Long id);
    List<Team> getAllTeams();
    Team updateTeam(Long id, Team teamDetails);
    void deleteTeam(Long id);
}