package com.example.Match.MatchHub.Response;

import com.example.Match.MatchHub.model.PlayerEntity;
import com.example.Match.MatchHub.model.TeamEntity;
import lombok.Data;

import java.util.List;

@Data
public class MatchDetailsResponse {
    private TeamEntity team1;
    private TeamEntity team2;
    private String venue;
    private PlayerEntity playerOfTheMatch;
}
