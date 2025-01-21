package com.MiguelAnjos.dslist.repositories;

import com.MiguelAnjos.dslist.entities.Game;
import com.MiguelAnjos.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
