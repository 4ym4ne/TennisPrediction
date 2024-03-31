package com.tennisprediction.controllers;

import com.tennisprediction.DTO.TournamentDTO;
import com.tennisprediction.services.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/tournaments")
public class TournamentController {

    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping("/")
    public ResponseEntity<TournamentDTO> createTournament(@RequestBody TournamentDTO tournamentDTO) {
        TournamentDTO newTournament = tournamentService.createTournament(tournamentDTO);
        return ResponseEntity.ok(newTournament);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TournamentDTO> updateTournament(@PathVariable UUID id, @RequestBody TournamentDTO tournamentDTO) {
        TournamentDTO updatedTournament = tournamentService.updateTournament(id, tournamentDTO);
        return ResponseEntity.ok(updatedTournament);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TournamentDTO> getTournamentById(@PathVariable UUID id) {
        TournamentDTO tournamentDTO = tournamentService.getTournamentById(id);
        return ResponseEntity.ok(tournamentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTournament(@PathVariable UUID id) {
        tournamentService.deleteTournament(id);
        return ResponseEntity.ok().build();
    }
}