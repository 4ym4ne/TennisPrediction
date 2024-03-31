package com.tennisprediction.services;


import com.tennisprediction.DTO.MatchDTO;
import com.tennisprediction.entities.Match;
import com.tennisprediction.entities.Player;
import com.tennisprediction.entities.Tournament;
import com.tennisprediction.repositories.MatchRepository;
import com.tennisprediction.repositories.PlayerRepository;
import com.tennisprediction.repositories.TournamentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.UUID;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final TournamentRepository tournamentRepository;
    private final PlayerRepository playerRepository;

    @Autowired
    public MatchService(MatchRepository matchRepository, TournamentRepository tournamentRepository,
                        PlayerRepository playerRepository, ModelMapper modelMapper) {
        this.matchRepository = matchRepository;
        this.tournamentRepository = tournamentRepository;
        this.playerRepository = playerRepository;
    }

    public Match createMatch(MatchDTO matchDTO) {
        Match match = new Match();
        // Set Tournament and Players using their IDs
        match.setTournamentid(tournamentRepository.findById(matchDTO.getTournamentId()).orElse(null));
        match.setPlayer1id(playerRepository.findById(matchDTO.getPlayer1Id()).orElse(null));
        match.setPlayer2id(playerRepository.findById(matchDTO.getPlayer2Id()).orElse(null));
        match.setRound(matchDTO.getRound());
        match.setMatchdate(matchDTO.getMatchDate());

        match = matchRepository.save(match);
        return match;
    }

}

