package io.github.michaelbui99.lolinsightsbackend.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.merakianalytics.orianna.Orianna;
import com.merakianalytics.orianna.types.common.Queue;
import com.merakianalytics.orianna.types.core.league.League;
import com.merakianalytics.orianna.types.core.league.LeagueEntry;
import com.merakianalytics.orianna.types.core.league.LeaguePositions;
import com.merakianalytics.orianna.types.core.summoner.Summoner;
import io.github.michaelbui99.lolinsightsbackend.domain.entity.QueueType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class LeagueRepositoryImpl implements LeagueRepository {

    @Override
    public League getLeagueForSummoner(Summoner summoner, QueueType queueType) {
        LeaguePositions summonerLeagues = Orianna.leaguePositionsForSummoner(summoner).get();

        Queue chosenQueue;
        if (queueType == QueueType.FLEX){
            chosenQueue = Queue.RANKED_FLEX;
        }else{
            chosenQueue = Queue.RANKED_SOLO;
        }

        List<LeagueEntry> rankedSoloQueueLeagueEntries = summonerLeagues.stream()
                .filter(leagueEntry ->
                        leagueEntry.getQueue() == chosenQueue
                )
                .collect(Collectors.toList());

        try {
            System.out.println(new ObjectMapper().writeValueAsString(rankedSoloQueueLeagueEntries));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return rankedSoloQueueLeagueEntries.get(0).getLeague();
    }
}
