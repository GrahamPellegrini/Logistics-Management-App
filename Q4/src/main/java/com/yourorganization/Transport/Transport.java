package com.yourorganization.Transport; // Package for transportation-related classes

import java.time.Duration; // Importing Duration for time calculations
import java.util.List;

public abstract class Transport {
    private String id; // Unique identifier for each transport mode
    private double speed; // Speed of transport in km/h
    private double costPerKm; // Cost per km for using this transport

    // Constructor to set up a new transport method
    public Transport(String id, double speed, double costPerKm) {
        this.id = id; // Assigning ID
        this.speed = speed; // Setting speed
        this.costPerKm = costPerKm; // Setting cost per km
    }

    // Abstract method for getting route plan, to be implemented in subclasses
    public abstract List<String> getRoutePlan();

    // Calculates time taken for delivery based on distance
    public Duration calculateDeliveryTime(double distance) {
        return Duration.ofMinutes((long) ((distance / speed) * 60)); // converting hours to minuts using the DUration import
    }

    // Calculates cost of delivery based on distance
    public double calculateDeliveryCost(double distance) {
        return distance * costPerKm;
    }

    // Getters and setters
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getCostPerKm() {
        return costPerKm;
    }

    public void setCostPerKm(double costPerKm) {
        this.costPerKm = costPerKm;
    }

    public String getId() {
      return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
