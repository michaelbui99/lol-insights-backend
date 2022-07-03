package io.github.michaelbui99.lolinsightsbackend.repository;

import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public interface LeagueRepository {
    League getLeagueForSummoner(Summoner summoner);
}
