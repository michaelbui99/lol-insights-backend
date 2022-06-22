package io.github.michaelbui99.lolinsightsbackend.repository;

import com.merakianalytics.orianna.types.common.Region;
import com.merakianalytics.orianna.types.core.staticdata.Champions;
import io.github.michaelbui99.lolinsightsbackend.entity.Champion;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class ChampionRepositoryImpl implements ChampionRepository {
    private final Region DEFAULT_REGION = Region.EUROPE_WEST;
    private final Champions champions;

    public ChampionRepositoryImpl() {
        this.champions = Champions.withRegion(DEFAULT_REGION).get();
    }

    @Override
    public List<Champion> getAll() {
        List<Champion> allChampions = new ArrayList<>();
        champions.forEach(champion -> {
            allChampions.add(new Champion.ChampionsBuilder(champion).build());
        });

        return allChampions;
    }

    @Override
    public Champion getById(String id) throws NoSuchElementException {
        return null;
    }

    @Override
    public Champion update(String id) {
        return null;
    }

    @Override
    public Champion add(Champion champion) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
