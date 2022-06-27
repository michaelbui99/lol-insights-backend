package io.github.michaelbui99.lolinsightsbackend.exception;

public class SummonerNotFoundException extends RuntimeException {
    public SummonerNotFoundException() {
    }

    public SummonerNotFoundException(String message) {
        super(message);
    }
}
