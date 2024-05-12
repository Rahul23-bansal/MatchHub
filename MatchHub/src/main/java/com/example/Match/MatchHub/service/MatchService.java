package com.example.Match.MatchHub.service;

import com.example.Match.MatchHub.Response.MatchDetailsResponse;
import com.example.Match.MatchHub.model.MatchEntity;
import com.example.Match.MatchHub.model.PlayerEntity;
import com.example.Match.MatchHub.model.TeamEntity;
import com.example.Match.MatchHub.repository.MatchRepository;
import com.example.Match.MatchHub.request.CreateMatchRequest;
import com.example.Match.MatchHub.request.MatchCompletionRequest;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class MatchService {
    @Autowired
    private MatchRepository matchRepository;
    @Autowired
    private TeamService teamService;
    @Autowired
    private PlayerService playerService;

    public List<MatchEntity> getAllPastMatches() {
        LocalDate today = LocalDate.now();
        return matchRepository.findByDateBefore(today);
    }

    public MatchEntity createMatch(CreateMatchRequest matchRequest) {
        MatchEntity matchEntity = new MatchEntity();
        matchEntity.setDate(matchRequest.getDate());
        matchEntity.setVenue(matchRequest.getVenue());
        Optional<TeamEntity> team1 = teamService.getTeamById(matchRequest.getTeamId1());
        Optional<TeamEntity> team2 = teamService.getTeamById(matchRequest.getTeamId2());
        if (team1.isPresent() && team2.isPresent()) {
            matchEntity.setTeamEntity1(team1.get());
            matchEntity.setTeamEntity2(team2.get());
            matchRepository.save(matchEntity);
            return matchEntity;
        }
        return null;
    }

    public List<MatchEntity> getMatchesByDate(LocalDate date) {
        return matchRepository.findByDate(date);
    }

    public MatchDetailsResponse getMatchDetailsById(Long id) {
        Optional<MatchEntity> matchDetails =  matchRepository.findById(id);
        MatchDetailsResponse matchDetailsResponse = new MatchDetailsResponse();
        if(matchDetails.isPresent()){
            matchDetailsResponse.setTeam1(matchDetails.get().getTeamEntity1());
            matchDetailsResponse.setTeam2(matchDetails.get().getTeamEntity2());
            matchDetailsResponse.setPlayerOfTheMatch(matchDetails.get().getPlayerOfTheMatch());
            matchDetailsResponse.setVenue(matchDetails.get().getVenue());
            return matchDetailsResponse;
        }
        return null;
    }

    public MatchEntity updateMatchResult(MatchCompletionRequest matchCompletionRequest, Long matchId) {
        Optional<MatchEntity> match = matchRepository.findById(matchId);
        Optional<TeamEntity> team = teamService.getTeamById(matchCompletionRequest.getTeamId());
        Optional<PlayerEntity> player = playerService.getPlayer(matchCompletionRequest.getPlayerId());

        if(match.isPresent()){
            MatchEntity matchEntity = match.get();
            matchEntity.setPlayerOfTheMatch(player.get());
            matchEntity.setWinningTeam(team.get());
            matchEntity.setResultType(matchCompletionRequest.getResultType());

            TeamEntity team1 = matchEntity.getTeamEntity1();
            TeamEntity team2 = matchEntity.getTeamEntity2();

            if(team1 != null && team2 != null){
                if(team1.getId() == matchCompletionRequest.getTeamId()){
                    team1.setWins(team1.getWins() + 1);
                    team2.setLoses(team2.getLoses() + 1);
                }
                else{
                    team2.setWins(team2.getWins() + 1);
                    team1.setLoses(team1.getLoses() + 1);
                }
                teamService.createTeam(team1);
                teamService.createTeam(team2);
            }
            return matchEntity;
        }
        return null;
    }

}
