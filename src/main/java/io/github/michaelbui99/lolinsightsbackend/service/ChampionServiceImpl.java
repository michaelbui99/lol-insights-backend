package io.github.michaelbui99.lolinsightsbackend.service;

import io.github.michaelbui99.lolinsightsbackend.domain.entity.Champion;
import io.github.michaelbui99.lolinsightsbackend.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChampionServiceImpl implements ChampionService {
    private final ChampionRepository championRepository;

    @Autowired
    public ChampionServiceImpl(ChampionRepository championRepository) {
        this.championRepository = championRepository;
    }

    @Override
    public List<Champion> getAll() {
        return championRepository.getAll();
    }

    @Override
    public Champion getById(String id) {
        return null;
    }
}
