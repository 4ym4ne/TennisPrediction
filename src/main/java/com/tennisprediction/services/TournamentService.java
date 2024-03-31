package com.tennisprediction.services;

import com.tennisprediction.DTO.TournamentDTO;
import com.tennisprediction.entities.Tournament;
import com.tennisprediction.repositories.TournamentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class TournamentService {

    private final TournamentRepository tournamentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository, ModelMapper modelMapper) {
        this.tournamentRepository = tournamentRepository;
        this.modelMapper = modelMapper;
    }

    public TournamentDTO createTournament(TournamentDTO tournamentDTO) {
        Tournament tournament = modelMapper.map(tournamentDTO, Tournament.class);
        tournament = tournamentRepository.save(tournament);
        return modelMapper.map(tournament, TournamentDTO.class);
    }

    public TournamentDTO updateTournament(UUID id, TournamentDTO tournamentDTO) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tournament not found for this id :: " + id));
        modelMapper.map(tournamentDTO, tournament);
        tournament = tournamentRepository.save(tournament);
        return modelMapper.map(tournament, TournamentDTO.class);
    }

    public TournamentDTO getTournamentById(UUID id) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tournament not found for this id :: " + id));
        return modelMapper.map(tournament, TournamentDTO.class);
    }

    public void deleteTournament(UUID id) {
        Tournament tournament = tournamentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tournament not found for this id :: " + id));
        tournamentRepository.delete(tournament);
    }
}