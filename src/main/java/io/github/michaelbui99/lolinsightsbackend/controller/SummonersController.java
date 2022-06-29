package io.github.michaelbui99.lolinsightsbackend.controller;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import io.github.michaelbui99.lolinsightsbackend.domain.entity.RegionMap;
import io.github.michaelbui99.lolinsightsbackend.domain.exception.SummonerNotFoundException;
import io.github.michaelbui99.lolinsightsbackend.service.SummonerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class SummonersController {
    private final Logger logger = LoggerFactory.getLogger(SummonersController.class);
    private final SummonerService summonerService;
    private final Map<String, Region> regionMappings;

    @Autowired
    public SummonersController(SummonerService summonerService) {
        this.summonerService = summonerService;
        this.regionMappings = RegionMap.getInstance().getRegionMappings();
    }

    @GetMapping("summoner/{region}/{summonerName}")
    public ResponseEntity<Summoner> getSummonerByName(@PathVariable String summonerName,
                                                      @PathVariable String region) {
        Region chosenRegion = null;

        if (region != null) {
            chosenRegion = regionMappings.get(region);
        }

        try {
            logger.info("GET request for /summoners/" + summonerName + " has been received");
            Summoner summoner = summonerService.getSummonerByName(summonerName, chosenRegion);
            return ResponseEntity.ok(summoner);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (SummonerNotFoundException e) {
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("summoners/{region}/{summonerName}")
    public ResponseEntity<List<Summoner>> getSummonersByName(@PathVariable String summonerName,
                                                             @PathVariable String region) {
        logger.info("GET request for /summoners/" + summonerName + "has been received");
        Region chosenRegion = null;

        if (region != null) {
            chosenRegion = regionMappings.get(region);
        }

        try {
            List<Summoner> summoners = summonerService.getSummonersByName(summonerName, chosenRegion);
            return ResponseEntity.ok(summoners);
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().build();
        }
    }
}
