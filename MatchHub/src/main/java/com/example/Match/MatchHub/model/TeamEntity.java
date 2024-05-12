package com.example.Match.MatchHub.model;

import jakarta.persistence.*;
import lombok.Data;


import java.util.List;
@Entity
@Data
@Table(name="teams")
public class TeamEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    List<MatchEntity> matches;

    @ManyToMany
    private List<PlayerEntity> PlayingX1;
    private int wins;
    private int loses;
}
