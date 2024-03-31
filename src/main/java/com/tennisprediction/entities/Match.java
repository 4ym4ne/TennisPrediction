package com.tennisprediction.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "matches", schema = "public")
public class Match {
    @Id
    @GeneratedValue(generator = "UUID") // Add this line
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "matchid", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tournamentid")
    private Tournament tournamentid;

    @Column(name = "round", length = 50)
    private String round;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player1id")
    private Player player1id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player2id")
    private Player player2id;

    @Column(name = "matchdate")
    private LocalDate matchdate;

    @Column(name = "result")
    private String result;

    @Column(name = "score")
    private String score;

}