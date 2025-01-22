package com.MiguelAnjos.dslist.repositories;

import com.MiguelAnjos.dslist.entities.Game;
import com.MiguelAnjos.dslist.entities.GameList;
import com.MiguelAnjos.dslist.projections.GameMinProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface GameListRepository extends JpaRepository<GameList, Long> {
    @Query(nativeQuery = true, value = """
        SELECT
            tb_game.id,
            tb_game.title,
            tb_belonging.position,
            (SELECT tb_game_list.list_name
             FROM tb_game_list
             WHERE tb_game_list.id = :listId) AS list_name
        FROM
            tb_game
        INNER JOIN
            tb_belonging ON tb_game.id = tb_belonging.game_id
        WHERE
            tb_belonging.list_id = :listId
    """)
    Page<GameMinProjection> searchByList(Long listId, Pageable pageable);

}
