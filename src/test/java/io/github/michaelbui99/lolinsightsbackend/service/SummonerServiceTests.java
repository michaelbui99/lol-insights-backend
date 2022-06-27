package io.github.michaelbui99.lolinsightsbackend.service;

import com.merakianalytics.orianna.types.common.Region;
import io.github.michaelbui99.lolinsightsbackend.repository.SummonerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class SummonerServiceTests {
    private SummonerService summonerService;
    private SummonerRepository summonerRepositoryMock;

    @BeforeEach
    public void setup() {
        summonerRepositoryMock = Mockito.mock(SummonerRepository.class);
        summonerService = new SummonerServiceImpl(summonerRepositoryMock);
    }

    @Test
    public void getSummonerByName_NameIsWhiteSpace_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            summonerService.getSummonerByName("   ", Region.EUROPE_WEST);
        });
    }

    @Test
    public void getSummonerByName_NameIsNull_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            summonerService.getSummonerByName(null, Region.EUROPE_WEST);
        });
    }

    @Test
    public void getSummonerByName_NameIsEmptyString_ThrowsIllegalArgumentException(){
        assertThrows(IllegalArgumentException.class, ()->{
            summonerService.getSummonerByName("", Region.EUROPE_WEST);
        });
    }
}