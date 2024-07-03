package com.Jaume.Koerber.models;

public class Article {
    private Long id;
    private String description;
    private double weight;
    private double volume;
    private boolean active;

    public Article(Long id, String description, double weight, double volume, boolean active) {
        this.id = id;
        this.description = description;
        this.weight = weight;
        this.volume = volume;
        this.active = active;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
