package com.tennisprediction.controllers;

import com.tennisprediction.DTO.MatchDTO;
import com.tennisprediction.entities.Match;
import com.tennisprediction.services.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/matches")
public class MatchController {

    private final MatchService matchService;

    @Autowired
    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @PostMapping("/")
    public ResponseEntity<Match> createMatch(@RequestBody MatchDTO matchDTO) {
        Match newMatch = matchService.createMatch(matchDTO);
        return ResponseEntity.ok(newMatch);
    }

}
