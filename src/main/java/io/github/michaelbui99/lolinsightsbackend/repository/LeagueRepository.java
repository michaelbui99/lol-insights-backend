package io.github.michaelbui99.lolinsightsbackend.repository;

import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import io.github.michaelbui99.lolinsightsbackend.domain.entity.QueueType;

public interface LeagueRepository {
    League getLeagueForSummoner(Summoner summoner, QueueType queueType);
}
