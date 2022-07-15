package io.github.michaelbui99.lolinsightsbackend.controller;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import io.github.michaelbui99.lolinsightsbackend.domain.Constants;
import io.github.michaelbui99.lolinsightsbackend.domain.entity.QueueType;
import io.github.michaelbui99.lolinsightsbackend.domain.entity.RegionMap;
import io.github.michaelbui99.lolinsightsbackend.domain.exception.SummonerNotFoundException;
import io.github.michaelbui99.lolinsightsbackend.service.LeagueService;
import io.github.michaelbui99.lolinsightsbackend.service.SummonerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// TODO: Create DTOs and expose the DTOs instead of the domain objects
@RestController
@RequestMapping("api/v1")
@CrossOrigin
public class SummonersController {
    private final Logger logger = LoggerFactory.getLogger(SummonersController.class);
    private final SummonerService summonerService;
    private final LeagueService leagueService;
    private final Map<String, Region> regionMappings;

    @Autowired
    public SummonersController(SummonerService summonerService, LeagueService leagueService) {
        this.summonerService = summonerService;
        this.leagueService = leagueService;
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

    @GetMapping("summoners/{region}/{summonerName}/league/{queueType}")
    public ResponseEntity<League> getLeagueBySummonerName(@PathVariable String summonerName,
                                                          @PathVariable String region,
                                                          @PathVariable String queueType) {
        try {
            logger.info("GET request received for /summoners/:region/:summonerName/league");
            QueueType chosenQueueType = null;

            if (!isValidQueueType(queueType)) {
                return ResponseEntity.badRequest().build();
            }

            if (queueType.toLowerCase().equals(QueueType.SOLO.name().toLowerCase())) {
                chosenQueueType = QueueType.SOLO;
            } else {
                chosenQueueType = QueueType.FLEX;
            }

            League league = leagueService.getLeagueForSummonerByName(summonerName, regionMappings.get(region),
                    chosenQueueType);
            return ResponseEntity.ok(league);
        } catch (SummonerNotFoundException e) {
            logger.error(e.getMessage());
            return ResponseEntity.notFound().build();
        } catch (IllegalArgumentException e) {
            logger.error(e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            logger.error(e.getMessage());
            return ResponseEntity.internalServerError().build();
        }
    }

    private boolean isValidQueueType(String queueType) {
        if (queueType.toLowerCase().equals("solo")) {
            return true;
        }

        if (queueType.toLowerCase().equals("flex")) {
            return true;
        }

        return false;
    }
}
