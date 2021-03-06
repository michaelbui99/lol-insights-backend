package io.github.michaelbui99.lolinsightsbackend.service;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.league.League;
import io.github.michaelbui99.lolinsightsbackend.domain.entity.QueueType;

public interface LeagueService {
    /**
     * Fetches Ranked Solo Queue 5v5 league for a summoner
     *
     * @param summonerName Name of the summoner
     * @param region       Region of the summoner
     * @param queueType    Queue type of the desired league. If null is provided as queue type, then Ranked Solo
     *                     Queue will be used as the Queue type
     * @throws IllegalArgumentException                                                             if <code
     *                                                                                              >summonerName</code> is empty or null
     * @throws io.github.michaelbui99.lolinsightsbackend.domain.exception.SummonerNotFoundException if no summoner
     *                                                                                              with the provided
     *                                                                                              summoner name exists
     */
    League getLeagueForSummonerByName(String summonerName, Region region, QueueType queueType);
}
