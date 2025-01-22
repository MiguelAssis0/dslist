package com.MiguelAnjos.dslist.controllers;


import com.MiguelAnjos.dslist.dtos.GameDTO;
import com.MiguelAnjos.dslist.dtos.GameListDTO;
import com.MiguelAnjos.dslist.dtos.GameMinDTO;
import com.MiguelAnjos.dslist.dtos.ListDTO;
import com.MiguelAnjos.dslist.services.GameListService;
import com.MiguelAnjos.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/lists")
@CrossOrigin(origins = "*")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @GetMapping
    public ResponseEntity<Page<GameListDTO>> findAll(@Validated @PageableDefault(size = 20) Pageable pageable) {
        Page<GameListDTO> result = gameListService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{listId}/games")
    public ResponseEntity<Page<ListDTO>> findByList(@PathVariable Long listId, @Validated @PageableDefault(size = 20) Pageable pageable) {
        Page<ListDTO> result = gameListService.findByList(listId, pageable);
        return ResponseEntity.ok(result);
    }

}
