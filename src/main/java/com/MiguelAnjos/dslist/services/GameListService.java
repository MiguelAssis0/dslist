package com.MiguelAnjos.dslist.services;

import com.MiguelAnjos.dslist.dtos.GameDTO;
import com.MiguelAnjos.dslist.dtos.GameListDTO;
import com.MiguelAnjos.dslist.dtos.GameMinDTO;
import com.MiguelAnjos.dslist.dtos.ListDTO;
import com.MiguelAnjos.dslist.entities.Game;
import com.MiguelAnjos.dslist.entities.GameList;
import com.MiguelAnjos.dslist.projections.GameMinProjection;
import com.MiguelAnjos.dslist.repositories.GameListRepository;
import com.MiguelAnjos.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public Page<GameListDTO> findAll(Pageable pageable) {
        Page<GameList> result = gameListRepository.findAll(pageable);
        return result.map(GameListDTO::new);
    }

    public Page<ListDTO> findByList(Long listId, Pageable pageable) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        Page<GameMinProjection> page = new PageImpl<>(result, pageable, result.size());
        return page.map(ListDTO::new);
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
