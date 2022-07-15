package io.github.michaelbui99.lolinsightsbackend.service;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import io.github.michaelbui99.lolinsightsbackend.domain.Constants;
import io.github.michaelbui99.lolinsightsbackend.domain.entity.QueueType;
import io.github.michaelbui99.lolinsightsbackend.domain.exception.SummonerNotFoundException;
import io.github.michaelbui99.lolinsightsbackend.domain.validation.SummonerNameValidator;
import io.github.michaelbui99.lolinsightsbackend.repository.LeagueRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeagueServiceImpl implements LeagueService {
    private final LeagueRepository leagueRepository;
    private final SummonerService summonerService;
    private final SummonerNameValidator summonerNameValidator;
    private final Logger logger = LoggerFactory.getLogger(LeagueServiceImpl.class);

    @Autowired
    public LeagueServiceImpl(LeagueRepository leagueRepository, SummonerService summonerService,
                             SummonerNameValidator summonerNameValidator) {
        this.leagueRepository = leagueRepository;
        this.summonerService = summonerService;
        this.summonerNameValidator = summonerNameValidator;
    }

    @Override
    public League getLeagueForSummonerByName(String summonerName, Region region, QueueType queueType) {
        try {
            summonerNameValidator.validateName(summonerName);

            Region chosenRegion = Constants.DEFAULT_REGION;
            if (region != null) {
                chosenRegion = region;
            }

            QueueType chosenQueueType = Constants.DEFAULT_QUEUE_TYPE;
            if (queueType != null){
                chosenQueueType = queueType;
            }

            Summoner summoner = summonerService.getSummonerByName(summonerName, chosenRegion);
            League league = leagueRepository.getLeagueForSummoner(summoner, chosenQueueType);
            league.getName(); // Fixes a bug in the Orianna library where all entities are not initialized before
                             // actually calling a method on the entity
            return league;
        } catch (SummonerNotFoundException e) {
            e.printStackTrace();
            logger.error("Failed to retrieve summoner: " + e.getMessage());
            throw e;
        }
    }
}
