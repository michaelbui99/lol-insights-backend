package io.github.michaelbui99.lolinsightsbackend.service;

import java.util.Map;

public interface StatisticsService {
    /**
     * Returns a map of win rates for all champions
     *
     * @return map of win rates where champion name is the key and win rate is the value.
     * */
    Map<String, Integer> getChampionWinRates();

    /**
     * Returns a map of pick rates for all champions
     *
     * @return map of pick rates where champion name is the key and pick rate is the value.
     * */
    Map<String, Integer> getChampionPickRates();


    /**
     * Returns a map of ban rates for all champions
     *
     * @return map of ban rates where champion name is the key and ban rate is the value.
     * */
    Map<String, Integer> getChampionBanRates();
}
