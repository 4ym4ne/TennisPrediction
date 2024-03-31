package com.tennisprediction.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "tournaments", schema = "public")
public class Tournament {
    @Id
    @GeneratedValue(generator = "UUID") // Add this line
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") // Add this line
    @Column(name = "tournamentid", nullable = false)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "surface", length = 50)
    private String surface;

}