package com.MiguelAnjos.dslist.services;

import com.MiguelAnjos.dslist.dtos.GameDTO;
import com.MiguelAnjos.dslist.dtos.GameListDTO;
import com.MiguelAnjos.dslist.dtos.GameMinDTO;
import com.MiguelAnjos.dslist.entities.Game;
import com.MiguelAnjos.dslist.entities.GameList;
import com.MiguelAnjos.dslist.repositories.GameListRepository;
import com.MiguelAnjos.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public Page<GameListDTO> findAll(Pageable pageable) {
        Page<GameList> result = gameListRepository.findAll(pageable);
        return result.map(GameListDTO::new);
    }

}
