package io.github.michaelbui99.lolinsightsbackend.repository;

import io.github.michaelbui99.lolinsightsbackend.domain.entity.Champion;

import java.util.List;
import java.util.NoSuchElementException;

public interface ChampionRepository {
    List<Champion> getAll();
    Champion getById(String id) throws NoSuchElementException;
    Champion update(String id);
    Champion add(Champion champion);
    void delete(String id);
}
