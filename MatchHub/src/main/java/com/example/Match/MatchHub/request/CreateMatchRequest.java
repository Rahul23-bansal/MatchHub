package com.example.Match.MatchHub.request;

import com.example.Match.MatchHub.enums.ResultType;
import com.example.Match.MatchHub.model.PlayerEntity;
import com.example.Match.MatchHub.model.TeamEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
public class CreateMatchRequest {
    private Long teamId1;
    private Long teamId2;
    private LocalDate date;
    private String venue;
}
