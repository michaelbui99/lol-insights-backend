package io.github.michaelbui99.lolinsightsbackend.repository;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;

import java.util.List;

public interface SummonerRepository {
    public Summoner getSummonerByName(String summonerName, Region region);
    public List<Summoner> getSummonersByName(String summonerName, Region region);
}
