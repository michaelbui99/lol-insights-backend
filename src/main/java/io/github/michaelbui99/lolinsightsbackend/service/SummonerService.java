package io.github.michaelbui99.lolinsightsbackend.service;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public interface SummonerService {
    /**
     * Returns a summoner with the provided summonerName in the specified region
     *
     * @param summonerName name of the summoner
     * @param region       region of the summoner
     * @throws IllegalArgumentException                                                      if summonerName is null,
     *                                                                                       empty or white space only
     * @throws io.github.michaelbui99.lolinsightsbackend.exception.SummonerNotFoundException if summoner was not found
     */
    public Summoner getSummonerByName(String summonerName, Region region);
}
