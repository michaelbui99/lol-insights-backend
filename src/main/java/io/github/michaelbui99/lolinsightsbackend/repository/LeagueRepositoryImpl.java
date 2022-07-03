package io.github.michaelbui99.lolinsightsbackend.repository;

import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import org.springframework.stereotype.Repository;

@Repository
public class LeagueRepositoryImpl implements LeagueRepository {

    @Override
    public League getLeagueForSummoner(Summoner summoner) {
        return Orianna.leaguePositionsForSummoner(summoner).get().get(0).getLeague();
    }
}
