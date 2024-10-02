package com.empManagement.EmpManagement.services;

import com.empManagement.EmpManagement.entities.Team;
import com.empManagement.EmpManagement.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;

    public void insertTeam(Team team) {
        teamRepository.save(team);
    }
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(Long teamId) {
        return teamRepository.findById(teamId);
    }

}
