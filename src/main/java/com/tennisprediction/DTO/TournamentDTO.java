package com.tennisprediction.DTO;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link com.tennisprediction.entities.Tournament}
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TournamentDTO {
    UUID id;
    String name;
    String location;
    String surface;
}