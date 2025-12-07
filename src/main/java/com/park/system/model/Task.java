package com.park.system.model;

import java.time.LocalDate;

public class Task {
    private Long id;
    private String type;       // PLANTING, TREATMENT, etc.
    private Long plantId;
    private Long foresterId;
    private String status;     // PENDING, DONE, CONFIRMED
    private LocalDate date;

    public Task() {
    }

    public Task(Long id, String type, Long plantId, Long foresterId, String status, LocalDate date) {
        this.id = id;
        this.type = type;
        this.plantId = plantId;
        this.foresterId = foresterId;
        this.status = status;
        this.date = date;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPlantId() {
        return plantId;
    }

    public void setPlantId(Long plantId) {
        this.plantId = plantId;
    }

    public Long getForesterId() {
        return foresterId;
    }

    public void setForesterId(Long foresterId) {
        this.foresterId = foresterId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
