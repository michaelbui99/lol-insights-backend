package io.github.michaelbui99.lolinsightsbackend.service;

import java.util.Map;

public interface StatisticService {
    Map<String, Integer> getChampionWinRates();
    Map<String, Integer> getChampionPickRates();
    Map<String, Integer> getChampionBanRates();

}
