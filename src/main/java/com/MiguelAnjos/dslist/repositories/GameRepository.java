package com.MiguelAnjos.dslist.repositories;

import com.MiguelAnjos.dslist.entities.Game;
import com.MiguelAnjos.dslist.projections.GameMinProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameRepository extends JpaRepository<Game, Long> {

}
