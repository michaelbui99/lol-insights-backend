package io.github.michaelbui99.lolinsightsbackend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.michaelbui99.lolinsightsbackend.entity.Champion;
import io.github.michaelbui99.lolinsightsbackend.service.ChampionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/champions")
public class ChampionsController {
    private final ChampionService championService;
    private final Logger logger = LoggerFactory.getLogger(ChampionsController.class);

    @Autowired
    public ChampionsController(ChampionService championService) {
        this.championService = championService;
    }

    @GetMapping
    public ResponseEntity<List<Champion>> getAll() {
        try {
            logger.info("Received GET request for /champions");
            List<Champion> allChampions = championService.getAll();
            return ResponseEntity.ok(allChampions);
        } catch (Exception e) {
            logger.error("Failed to retrieve all champions.." + e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
