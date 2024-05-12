package com.example.Match.MatchHub.request;

import com.example.Match.MatchHub.model.PlayerEntity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class CreateTeamRequest {
    private String name;
    private List<Long> PlayingX1Ids;
    private int wins;
    private int loses;
}
