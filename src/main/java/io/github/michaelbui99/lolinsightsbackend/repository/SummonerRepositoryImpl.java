package io.github.michaelbui99.lolinsightsbackend.repository;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SummonerRepositoryImpl implements SummonerRepository {
    public SummonerRepositoryImpl() {
    }

    @Override
    public Summoner getSummonerByName(String summonerName, Region region) {
        Summoner summoner;

        if (region == null) {
            summoner = Orianna.summonerNamed(summonerName).get();
        }else{
            summoner = Orianna.summonerNamed(summonerName).withRegion(region).get();
        }

        // DO NOT REMOVE
        summoner.getLevel(); // Summoner is only fetched when this is called for some reason?
        return summoner;
    }

    @Override
    public List<Summoner> getSummonersByName(String summonerName, Region region) {
        if (region == null) {
            return Orianna.summonersNamed(summonerName).get();
        }

        return Orianna.summonersNamed(summonerName).withRegion(region).get();
    }
}
