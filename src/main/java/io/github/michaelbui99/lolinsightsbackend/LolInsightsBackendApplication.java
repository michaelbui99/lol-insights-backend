package io.github.michaelbui99.lolinsightsbackend;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LolInsightsBackendApplication {
    public static void main(String[] args) {
        Orianna.setRiotAPIKey(System.getenv("RIOT_API_KEY"));
        Orianna.setDefaultRegion(Region.EUROPE_WEST);
        SpringApplication.run(LolInsightsBackendApplication.class, args);
    }

}
