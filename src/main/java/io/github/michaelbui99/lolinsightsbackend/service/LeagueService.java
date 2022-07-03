package io.github.michaelbui99.lolinsightsbackend.service;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.league.League;

public interface LeagueService {
    League getLeagueForSummonerByName(String summonerName, Region region);
}
