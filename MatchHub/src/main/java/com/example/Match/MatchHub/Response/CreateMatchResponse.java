package com.example.Match.MatchHub.Response;

import lombok.Data;

import java.time.LocalDate;


@Data
public class CreateMatchResponse {
    private Long teamId1;
    private Long teamId;
    private LocalDate date;
    private String venue;
}


