package com.example.Match.MatchHub.service;

import com.example.Match.MatchHub.Response.CreatePlayerResponse;
import com.example.Match.MatchHub.model.PlayerEntity;
import com.example.Match.MatchHub.repository.PlayerRepository;
import com.example.Match.MatchHub.request.CreatePlayerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public Optional<PlayerEntity> getPlayer(Long id){
        return playerRepository.findById(id);
    }

    public CreatePlayerResponse save(CreatePlayerRequest player){
        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setName(player.getPlayerName());
        playerRepository.save(playerEntity);

        CreatePlayerResponse response = new CreatePlayerResponse();
        response.setPlayerName(player.getPlayerName());
        return response;
    }
}
