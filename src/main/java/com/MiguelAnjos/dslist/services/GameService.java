package com.MiguelAnjos.dslist.services;

import com.MiguelAnjos.dslist.dtos.GameMinDTO;
import com.MiguelAnjos.dslist.entities.Game;
import com.MiguelAnjos.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Page<GameMinDTO> findAll(Pageable pageable) {
        Page<Game> result = gameRepository.findAll(pageable);
        return result.map(GameMinDTO::new);
    }
}
