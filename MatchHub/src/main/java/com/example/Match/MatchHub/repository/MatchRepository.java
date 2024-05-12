package com.example.Match.MatchHub.repository;

import com.example.Match.MatchHub.model.MatchEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<MatchEntity, Long> {
    List<MatchEntity> findByDate(LocalDate date);
    List<MatchEntity> findByDateBefore(LocalDate date);
    List<MatchEntity> findByDateBeforeAndTeamEntity1_IdOrTeamEntity2_Id(LocalDate date, Long teamId1, Long teamId2);
}