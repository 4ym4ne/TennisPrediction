package com.tennisprediction.controllers;

import com.tennisprediction.DTO.PlayerDTO;
import com.tennisprediction.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping("/")
    public ResponseEntity<PlayerDTO> addPlayer(@RequestBody PlayerDTO playerDTO) {
        PlayerDTO newPlayer = playerService.savePlayer(playerDTO);
        return ResponseEntity.ok(newPlayer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PlayerDTO> deletePlayer(@PathVariable UUID id) {
        PlayerDTO deletedPlayer = playerService.deletePlayer(id);
        if (deletedPlayer != null) {
            return ResponseEntity.ok(deletedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable UUID id, @RequestBody PlayerDTO playerDTO) {
        PlayerDTO updatedPlayer = playerService.updatePlayer(id, playerDTO);
        if (updatedPlayer != null) {
            return ResponseEntity.ok(updatedPlayer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable UUID id) {
        PlayerDTO playerDTO = playerService.getPlayerById(id);
        if (playerDTO != null) {
            return ResponseEntity.ok(playerDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
