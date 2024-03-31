package com.tennisprediction.services;

import com.tennisprediction.DTO.PredictionDTO;
import com.tennisprediction.entities.Prediction;
import com.tennisprediction.repositories.MatchRepository;
import com.tennisprediction.repositories.PlayerRepository;
import com.tennisprediction.repositories.PredictionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class PredictionService {

    private final PredictionRepository predictionRepository;
    private final MatchRepository matchRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public PredictionService(PredictionRepository predictionRepository, MatchRepository matchRepository,
                             PlayerRepository playerRepository) {
        this.predictionRepository = predictionRepository;
        this.matchRepository = matchRepository;
        this.playerRepository = playerRepository;
    }

    public Prediction createPrediction(PredictionDTO predictionDTO) {
        Prediction prediction = new Prediction();

        // Manually set match and predicted winner
        prediction.setMatchid(matchRepository.findById(predictionDTO.getMatchId()).orElse(null));
        prediction.setPredictedwinnerid(playerRepository.findById(predictionDTO.getPredictedWinnerId())
                .orElse(null));
        prediction.setPredictiondate(predictionDTO.getPredictionDate());
        prediction.setConfidencelevel(predictionDTO.getConfidenceLevel());

        prediction = predictionRepository.save(prediction);
        return prediction;
    }

}
