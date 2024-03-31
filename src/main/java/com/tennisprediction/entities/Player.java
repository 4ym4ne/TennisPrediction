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
@Table(name = "players", schema = "public")
public class Player {
    @Id
    @GeneratedValue(generator = "UUID") // Add this line
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") // Add this line
    @Column(name = "playerid", nullable = false)
    private UUID id;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "country")
    private String country;

}