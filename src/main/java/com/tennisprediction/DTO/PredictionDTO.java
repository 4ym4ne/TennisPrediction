package com.tennisprediction.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PredictionDTO {
    private UUID id;
    private UUID matchId;
    private UUID predictedWinnerId;
    private Integer confidenceLevel;
    private LocalDate predictionDate;

}
