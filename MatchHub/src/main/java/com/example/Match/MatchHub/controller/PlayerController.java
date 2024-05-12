package com.example.Match.MatchHub.controller;

import com.example.Match.MatchHub.Response.CreatePlayerResponse;
import com.example.Match.MatchHub.model.PlayerEntity;
import com.example.Match.MatchHub.request.CreatePlayerRequest;
import com.example.Match.MatchHub.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/player")

public class PlayerController {
    @Autowired
    PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<CreatePlayerResponse> createPlayer(@RequestBody CreatePlayerRequest player) {
        return ResponseEntity.ok(playerService.save(player));
    }
}
