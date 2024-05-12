package com.example.Match.MatchHub.service;

import com.example.Match.MatchHub.model.MatchEntity;
import com.example.Match.MatchHub.model.PlayerEntity;
import com.example.Match.MatchHub.model.TeamEntity;
import com.example.Match.MatchHub.repository.MatchRepository;
import com.example.Match.MatchHub.repository.PlayerRepository;
import com.example.Match.MatchHub.repository.TeamRepository;
import com.example.Match.MatchHub.request.CreateTeamRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private MatchRepository matchRepository;

    public TeamEntity getTeamByName(String teamName) {
        return teamRepository.findByNameIgnoreCase(teamName);
    }

    public Optional<TeamEntity> getTeamById(Long id) {
        return teamRepository.findById(id);

    }

    public List<MatchEntity> getPastMatchesByTeamId(Long teamId) {
        LocalDate currentDate = LocalDate.now();
        return matchRepository.findByDateBeforeAndTeamEntity1_IdOrTeamEntity2_Id(currentDate, teamId, teamId);
    }

    public TeamEntity createTeam(CreateTeamRequest teamRequest) {
        TeamEntity teamEntity1 = new TeamEntity();

        teamEntity1.setName(teamRequest.getName());
        teamEntity1.setLoses(teamRequest.getLoses());
        teamEntity1.setWins(teamRequest.getWins());
        List<PlayerEntity> player = new ArrayList<>();
        for(Long id:  teamRequest.getPlayingX1Ids()){
            player.add(playerRepository.findById(id).get());
        }
        teamEntity1.setPlayingX1(player);
        teamRepository.save(teamEntity1);

        return teamEntity1;
    }

    public TeamEntity createTeam(TeamEntity team) {
       return teamRepository.save(team);

    }

}
