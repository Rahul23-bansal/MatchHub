package com.example.Match.MatchHub.model;

import com.example.Match.MatchHub.enums.ResultType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Data
@Entity
@Table(name="matches")
public class MatchEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private TeamEntity teamEntity1;

    @ManyToOne
    private TeamEntity teamEntity2;
    private LocalDate date;
    private String venue;

    @ManyToOne
    private PlayerEntity playerOfTheMatch;

    @Enumerated(EnumType.STRING)
    private ResultType resultType;

    @ManyToOne
    private TeamEntity winningTeam;
}
