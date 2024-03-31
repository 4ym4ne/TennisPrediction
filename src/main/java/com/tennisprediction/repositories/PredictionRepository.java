package com.tennisprediction.repositories;

import com.tennisprediction.entities.Prediction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PredictionRepository extends JpaRepository<Prediction, UUID> {
}