package io.github.michaelbui99.lolinsightsbackend;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Region;
import io.github.michaelbui99.lolinsightsbackend.domain.Constants;
import io.github.michaelbui99.lolinsightsbackend.domain.validation.SummonerNameValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LolInsightsBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(LolInsightsBackendApplication.class, args);
        Logger logger = LoggerFactory.getLogger(LolInsightsBackendApplication.class);
        Orianna.setRiotAPIKey(System.getenv("RIOT_API_KEY"));
        logger.info("RIOT API Key has been set");
        Orianna.setDefaultRegion(Constants.DEFAULT_REGION);
        logger.info("Default region has been set to EUW");
    }

    @Bean
    public SummonerNameValidator summonerNameValidator(){
        return new SummonerNameValidator();
    }

}
