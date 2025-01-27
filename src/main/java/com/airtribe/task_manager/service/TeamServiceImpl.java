package com.airtribe.task_manager.service;

import com.airtribe.task_manager.model.Team;
import com.airtribe.task_manager.repository.TeamRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    @Override
    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    @Override
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @Override
    public Team updateTeam(Long id, Team teamDetails) {
        return teamRepository.findById(id)
                .map(existingTeam -> {
                    existingTeam.setName(teamDetails.getName());
                    return teamRepository.save(existingTeam);
                })
                .orElseThrow(() -> new RuntimeException("Team not found with id " + id));
    }

    @Override
    public void deleteTeam(Long id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
        } else {
            throw new RuntimeException("Team not found with id " + id);
        }
    }
}
