package com.park.system.dao;

import com.park.system.model.Plant;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

private final HikariDataSource dataSource;

public PlantDaoImpl(HikariDataSource dataSource) {
    this.dataSource = dataSource;
}

@Override
public void save(Plant plant) {
    String sql = "INSERT INTO plant (name, species, status) VALUES (?, ?, ?)";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, plant.getName());
        stmt.setString(2, plant.getSpecies());
        stmt.setString(3, plant.getStatus());
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace(); // позже заменим на логгер
    }
}

@Override
public Optional<Plant> findById(Long id) {
    String sql = "SELECT * FROM plant WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setLong(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            Plant plant = mapRow(rs);
            return Optional.of(plant);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return Optional.empty();
}

@Override
public List<Plant> findAll() {
    List<Plant> plants = new ArrayList<>();
    String sql = "SELECT * FROM plant";
    try (Connection conn = dataSource.getConnection();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {
        while (rs.next()) {
            plants.add(mapRow(rs));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return plants;
}

@Override
public void update(Plant plant) {
    String sql = "UPDATE plant SET name = ?, species = ?, status = ? WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, plant.getName());
        stmt.setString(2, plant.getSpecies());
        stmt.setString(3, plant.getStatus());
        stmt.setLong(4, plant.getId());
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

@Override
public void delete(Long id) {
    String sql = "DELETE FROM plant WHERE id = ?";
    try (Connection conn = dataSource.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setLong(1, id);
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

private Plant mapRow(ResultSet rs) throws SQLException {
    return new Plant(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getString("species"),
            rs.getString("status")
    );
}
