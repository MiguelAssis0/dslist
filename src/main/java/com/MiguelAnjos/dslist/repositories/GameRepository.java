package com.MiguelAnjos.dslist.repositories;

import com.MiguelAnjos.dslist.entities.Game;
import com.MiguelAnjos.dslist.projections.GameMinProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends JpaRepository<Game, Long> {
    @Query(nativeQuery = true, value = """
    SELECT
        g.id,
        g.title,
        b.position,
        l.list_name
    FROM
        tb_game g
    INNER JOIN
        tb_belonging b ON g.id = b.game_id
    INNER JOIN
        tb_game_list l ON b.list_id = l.id
    WHERE
        b.list_id = :listId
    ORDER BY
        b.position
""")
    List<GameMinProjection> searchByList(@Param("listId") Long listId);
}
