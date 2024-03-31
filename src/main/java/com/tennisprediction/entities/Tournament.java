package com.tennisprediction.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tournaments", schema = "public")
public class Tournament {
    @Id
    @Column(name = "tournamentid", nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "surface", length = 50)
    private String surface;

}