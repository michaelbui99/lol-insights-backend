package io.github.michaelbui99.lolinsightsbackend.domain.validation;

public class SummonerNameValidator {

    public void validateName(String summonerName) {
        validateNameIsNotNull(summonerName);
        validateNameIsNotEmpty(summonerName);
    }

    private void validateNameIsNotNull(String summonerName) {
        if (summonerName == null) {
            throw new IllegalArgumentException("Summoner name must be specified");
        }
    }

    private void validateNameIsNotEmpty(String summonerName) {
        if ("".equals(summonerName) || summonerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Summoner name must be specified");
        }
    }
}
