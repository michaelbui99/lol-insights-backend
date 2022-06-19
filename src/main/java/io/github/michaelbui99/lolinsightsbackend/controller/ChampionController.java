package io.github.michaelbui99.lolinsightsbackend.controller;

import io.github.michaelbui99.lolinsightsbackend.entity.Champion;
import io.github.michaelbui99.lolinsightsbackend.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/champions")
public class ChampionController {
    private final ChampionService championService;

    @Autowired
    public ChampionController(ChampionService championService) {
        this.championService = championService;
    }

    @GetMapping
    public ResponseEntity<List<Champion>> getAll() {
        try {
            List<Champion> allChampions = championService.getAll();
            return ResponseEntity.ok(allChampions);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
