package com.example.Match.MatchHub.controller;

import com.example.Match.MatchHub.model.MatchEntity;
import com.example.Match.MatchHub.model.TeamEntity;
import com.example.Match.MatchHub.request.CreateTeamRequest;
import com.example.Match.MatchHub.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("/{id}")
    public ResponseEntity<TeamEntity> getTeamById(@PathVariable Long id) {
        return ResponseEntity.of(teamService.getTeamById(id));
    }

    @GetMapping("/past/{teamId}")
    public ResponseEntity<List<MatchEntity>> getPastMatchesForTeam(@PathVariable Long teamId) {
        List<MatchEntity> pastMatches = teamService.getPastMatchesByTeamId(teamId);
        return ResponseEntity.ok(pastMatches);
    }

    @PostMapping("/create")
    public ResponseEntity<TeamEntity> createTeam(@RequestBody CreateTeamRequest teamEntity) {
         return ResponseEntity.ok(teamService.createTeam(teamEntity));

    }
}