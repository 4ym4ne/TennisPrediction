package com.tennisprediction.repositories;

import com.tennisprediction.entities.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TournamentRepository extends JpaRepository<Tournament, UUID> {
}