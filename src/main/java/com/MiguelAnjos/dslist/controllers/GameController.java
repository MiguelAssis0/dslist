package com.MiguelAnjos.dslist.controllers;


import com.MiguelAnjos.dslist.dtos.GameDTO;
import com.MiguelAnjos.dslist.dtos.GameMinDTO;
import com.MiguelAnjos.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping
    public ResponseEntity<Page<GameMinDTO>> findAll(@Validated @PageableDefault(size = 20) Pageable pageable) {
        Page<GameMinDTO> result = gameService.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<GameDTO> findById(@Validated @PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return ResponseEntity.ok(result);
    }

}
