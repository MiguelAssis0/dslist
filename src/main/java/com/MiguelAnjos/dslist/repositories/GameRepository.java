package com.MiguelAnjos.dslist.repositories;

import com.MiguelAnjos.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
