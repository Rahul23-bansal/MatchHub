package com.example.Match.MatchHub.request;

import com.example.Match.MatchHub.enums.ResultType;
import com.example.Match.MatchHub.model.PlayerEntity;
import lombok.Data;

@Data
public class MatchCompletionRequest {
    private long playerId;
    private long teamId;
    private ResultType resultType;
}
