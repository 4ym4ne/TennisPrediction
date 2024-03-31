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
@Table(name = "predictions", schema = "public")
public class Prediction {
    @Id
    @GeneratedValue(generator = "UUID") // Add this line
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator") // Add this line
    @Column(name = "predictionid", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matchid")
    private Match matchid;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "predictedwinnerid")
    private Player predictedwinnerid;

    @Column(name = "confidencelevel")
    private Integer confidencelevel;

    @Column(name = "predictiondate")
    private LocalDate predictiondate;

}