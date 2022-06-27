package io.github.michaelbui99.lolinsightsbackend.service;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import io.github.michaelbui99.lolinsightsbackend.exception.SummonerNotFoundException;
import io.github.michaelbui99.lolinsightsbackend.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummonerServiceImpl implements SummonerService {
    private final SummonerRepository summonerRepository;

    @Autowired
    public SummonerServiceImpl(SummonerRepository summonerRepository) {
        this.summonerRepository = summonerRepository;
    }


    @Override
    public Summoner getSummonerByName(String summonerName, Region region) {
        Summoner summoner;

        if (summonerName == null){
            throw new IllegalArgumentException("Summoner name must be specified");
        }

        if ("".equals(summonerName) || summonerName.trim().isEmpty()){
            throw new IllegalArgumentException("Summoner name must be specified");
        }

        if (region == null) {
            summoner = Orianna.summonerNamed(summonerName).get();
        } else {
            summoner = Orianna.summonerNamed(summonerName).withRegion(region).get();
        }

        if (summoner == null) {
            throw new SummonerNotFoundException("No summoner with name: " + summonerName + " was found");
        }

        return summoner;
    }
}
