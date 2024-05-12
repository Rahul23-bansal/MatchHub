package com.example.Match.MatchHub.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePlayerRequest {
    @NotNull
    private String playerName;
}
