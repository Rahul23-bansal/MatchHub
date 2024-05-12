package com.example.Match.MatchHub.repository;

import com.example.Match.MatchHub.model.MatchEntity;
import com.example.Match.MatchHub.model.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {

}