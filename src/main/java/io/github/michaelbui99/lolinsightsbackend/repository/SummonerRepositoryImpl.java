package io.github.michaelbui99.lolinsightsbackend.repository;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.springframework.stereotype.Repository;

@Repository
public class SummonerRepositoryImpl implements SummonerRepository {
    public SummonerRepositoryImpl() {
    }

    @Override
    public Summoner getSummonerByName(String summonerName, Region region) {
        if (region == null) {
            return Orianna.summonerNamed(summonerName).get();
        }
        return Orianna.summonerNamed(summonerName).withRegion(region).get();
    }
}
