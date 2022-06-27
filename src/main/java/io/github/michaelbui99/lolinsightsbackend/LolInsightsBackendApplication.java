package io.github.michaelbui99.lolinsightsbackend;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LolInsightsBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(LolInsightsBackendApplication.class, args);
        Logger logger = LoggerFactory.getLogger(LolInsightsBackendApplication.class);
        Orianna.setRiotAPIKey(System.getenv("RIOT_API_KEY"));
        logger.info("RIOT API Key has been set");
        Orianna.setDefaultRegion(Region.EUROPE_WEST);
        logger.info("Default region has been set to EUW");
    }

}
