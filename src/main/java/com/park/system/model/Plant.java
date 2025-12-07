package com.park.system.model;

public class Plant {
    private Long id;
    private String name;
    private String species;
    private String status; // HEALTHY, SICK, DAMAGED, etc.

    public Plant() {
    }

    public Plant(Long id, String name, String species, String status) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.status = status;
    }

    // Getters and setters (можно сгенерировать в IDE)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
