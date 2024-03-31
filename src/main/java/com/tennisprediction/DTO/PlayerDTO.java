package com.tennisprediction.DTO;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * DTO for {@link com.tennisprediction.entities.Player}
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {
    UUID id;
    String firstname;
    String lastname;
    LocalDate birthdate;
    String country;
}