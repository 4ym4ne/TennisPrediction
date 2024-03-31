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
public class MatchDTO {
    private UUID id;
    private UUID tournamentId;
    private String round;
    private UUID player1Id;
    private UUID player2Id;
    private LocalDate matchDate;
    private String result;
    private String score;

}
