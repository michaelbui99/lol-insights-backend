package io.github.michaelbui99.lolinsightsbackend.repository;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

public interface SummonerRepository {
    public Summoner getSummonerByName(String summonerName, Region region);
}
