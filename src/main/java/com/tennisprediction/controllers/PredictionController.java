package com.tennisprediction.controllers;

import com.tennisprediction.DTO.PredictionDTO;
import com.tennisprediction.entities.Prediction;
import com.tennisprediction.services.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/predictions")
public class PredictionController {

    private final PredictionService predictionService;

    @Autowired
    public PredictionController(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @PostMapping("/")
    public ResponseEntity<Prediction> createPrediction(@RequestBody PredictionDTO predictionDTO) {
        Prediction newPrediction = predictionService.createPrediction(predictionDTO);
        return ResponseEntity.ok(newPrediction);
    }

}
