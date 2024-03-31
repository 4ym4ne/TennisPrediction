package com.tennisprediction.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "predictions", schema = "public")
public class Prediction {
    @Id
    @Column(name = "predictionid", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matchid")
    private Match matchid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "predictedwinnerid")
    private Player predictedwinnerid;

    @Column(name = "confidencelevel")
    private Integer confidencelevel;

    @Column(name = "predictiondate")
    private LocalDate predictiondate;

}