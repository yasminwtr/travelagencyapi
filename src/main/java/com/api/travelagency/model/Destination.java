package com.api.travelagency.model;

public class Destination {
    private Long id;
    private String name;
    private String location;
    private String description;
    private double averageRating; 
    private int totalRating;
    private int reviewCount;

    public Destination() {
        this.averageRating = 0.0;
        this.totalRating = 0;
        this.reviewCount = 0;
    }

    public Destination(Long id, String name, String location, String description, double averageRating) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.description = description;
        this.averageRating = 0.0;
        this.totalRating = 0;
        this.reviewCount = 0;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getAverageRating() { return averageRating; }
    public void setAverageRating(double averageRating) { this.averageRating = averageRating; }

    public int getReviewCount() { return reviewCount; }

    public void addRating(int newRating) {
        if (newRating < 1 || newRating > 10) {
            throw new IllegalArgumentException("Rating must be between 1 and 10.");
        }

        totalRating += newRating;
        reviewCount++;

        averageRating = (double) totalRating / reviewCount;
    }
}
