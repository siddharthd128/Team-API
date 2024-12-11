package com.TeamManagement.Team.service;

import com.TeamManagement.Team.model.Team;
import com.TeamManagement.Team.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team createTeam(Team team) {
        if (teamRepository.existsByName(team.getName())) {
            throw new IllegalArgumentException("Team name already exists!");
        }
        return teamRepository.save(team);
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long id) {
        return teamRepository.findById(id);
    }

    public Team updateTeam(Long id, Team updatedTeam) {
        return teamRepository.findById(id).map(team -> {
            team.setName(updatedTeam.getName());
            team.setDescription(updatedTeam.getDescription());
            team.setUsers(updatedTeam.getUsers());
            return teamRepository.save(team);
        }).orElseThrow(() -> new IllegalArgumentException("Team not found!"));
    }

    public void deleteTeam(Long id) {
        if (!teamRepository.existsById(id)) {
            throw new IllegalArgumentException("Team not found!");
        }
        teamRepository.deleteById(id);
    }
}
