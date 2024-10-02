package com.empManagement.EmpManagement.controllers;

import com.empManagement.EmpManagement.entities.Team;
import com.empManagement.EmpManagement.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping
    public ResponseEntity<?> saveTeam(@RequestBody Team team) {
        teamService.insertTeam(team);
        return ResponseEntity.ok("Team created successfully");
    }

    @GetMapping
    public ResponseEntity<?> getAllTeams() {
        return ResponseEntity.ok(teamService.getAllTeams());
    }
}
