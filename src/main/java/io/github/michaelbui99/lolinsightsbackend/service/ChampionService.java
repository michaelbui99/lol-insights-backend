package io.github.michaelbui99.lolinsightsbackend.service;

import io.github.michaelbui99.lolinsightsbackend.domain.entity.Champion;

import java.util.List;

public interface ChampionService {
    List<Champion> getAll();
    Champion getById(String id);
}
