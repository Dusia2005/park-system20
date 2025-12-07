package com.park.system.dao;

import com.park.system.model.Plant;

import java.util.List;
import java.util.Optional;

public interface PlantDao {
    void save(Plant plant);
    Optional<Plant> findById(Long id);
    List<Plant> findAll();
    void update(Plant plant);
    void delete(Long id);
}
