package com.example.Match.MatchHub.controller;

import com.example.Match.MatchHub.Response.MatchDetailsResponse;
import com.example.Match.MatchHub.model.MatchEntity;
import com.example.Match.MatchHub.request.CreateMatchRequest;
import com.example.Match.MatchHub.request.MatchCompletionRequest;
import com.example.Match.MatchHub.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@RestController
@RequestMapping("/api/matches")
public class MatchController {
    @Autowired
    private MatchService matchService;

    @GetMapping("/date/{date}")
    public ResponseEntity<List<MatchEntity>> getMatchesByDate(@PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return ResponseEntity.ok(matchService.getMatchesByDate(date));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MatchDetailsResponse> getMatchById(@PathVariable Long id) {
        return ResponseEntity.ok(matchService.getMatchDetailsById(id));
    }

    @GetMapping("/past")
    public ResponseEntity<List<MatchEntity>> getAllPastMatches() {
        List<MatchEntity> pastMatchEntities = matchService.getAllPastMatches();
        return new ResponseEntity<>(pastMatchEntities, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MatchEntity> createMatch(@RequestBody CreateMatchRequest matchRequest) {
        MatchEntity match = matchService.createMatch(matchRequest);
       return ResponseEntity.ok(match);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MatchEntity> updateMatchResult(@RequestBody MatchCompletionRequest matchCompletionRequest, @PathVariable Long id) {
        return ResponseEntity.ok(matchService.updateMatchResult(matchCompletionRequest, id));
    }

}
