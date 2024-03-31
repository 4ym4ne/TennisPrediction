package com.tennisprediction.services;

import com.tennisprediction.DTO.PlayerDTO;
import com.tennisprediction.entities.Player;
import com.tennisprediction.repositories.PlayerRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, ModelMapper modelMapper) {
        this.playerRepository = playerRepository;
        this.modelMapper = modelMapper;
        // Configure ModelMapper to ignore the id field when mapping from PlayerDTO to Player
        this.modelMapper.addMappings(new PropertyMap<PlayerDTO, Player>() {
            @Override
            protected void configure() {
                skip(destination.getId());
            }
        });
    }

    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
        Player player = modelMapper.map(playerDTO, Player.class);
        player = playerRepository.save(player);
        return modelMapper.map(player, PlayerDTO.class);
    }

    public PlayerDTO deletePlayer(UUID id) {
        return playerRepository.findById(id).map(player -> {
            playerRepository.delete(player);
            return modelMapper.map(player, PlayerDTO.class);
        }).orElse(null);
    }

    public PlayerDTO updatePlayer(UUID id, PlayerDTO playerDTO) {
        return playerRepository.findById(id).map(player -> {
            modelMapper.map(playerDTO, player);
            Player updatedPlayer = playerRepository.save(player);
            return modelMapper.map(updatedPlayer, PlayerDTO.class);
        }).orElse(null);
    }

    public PlayerDTO getPlayerById(UUID id) {
        return playerRepository.findById(id)
                .map(player -> modelMapper.map(player, PlayerDTO.class))
                .orElse(null);
    }
}