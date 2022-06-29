package io.github.michaelbui99.lolinsightsbackend.service;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import io.github.michaelbui99.lolinsightsbackend.domain.Constants;
import io.github.michaelbui99.lolinsightsbackend.domain.exception.SummonerNotFoundException;
import io.github.michaelbui99.lolinsightsbackend.domain.validation.SummonerNameValidator;
import io.github.michaelbui99.lolinsightsbackend.repository.SummonerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SummonerServiceImpl implements SummonerService {
    private final SummonerRepository summonerRepository;
    private final SummonerNameValidator summonerNameValidator;

    @Autowired
    public SummonerServiceImpl(SummonerRepository summonerRepository, SummonerNameValidator summonerNameValidator) {
        this.summonerRepository = summonerRepository;
        this.summonerNameValidator = summonerNameValidator;
    }


    @Override
    public Summoner getSummonerByName(String summonerName, Region region) {
        Summoner summoner;
        summonerNameValidator.validateName(summonerName);

        if (region == null) {
            summoner = summonerRepository.getSummonerByName(summonerName, Constants.DEFAULT_REGION);
        } else {
            summoner = summonerRepository.getSummonerByName(summonerName, region);

            // DO NOT REMOVE
            System.out.println(summoner.getLevel()); // Summoner is only fetched when this is called for some reason?
        }

        if (summoner == null) {
            throw new SummonerNotFoundException("No summoner with name: " + summonerName + " was found");
        }

        return summoner;
    }

    @Override
    public Summoner getSummonersByName(String summonerName, Region region) {
        throw new RuntimeException("NOT IMPLEMENTED YET");
    }
}
