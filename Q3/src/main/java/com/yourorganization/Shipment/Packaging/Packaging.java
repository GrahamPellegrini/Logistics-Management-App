package com.yourorganization.Shipment.Packaging; // Package for shipment handling classes

import yourorganization.Data;

public class Packaging {
    private String type; // Describes the packaging type, like box or crate
    private int capacity; // How much it can hold, in packaging units
    private double cost; // The cost for this type of packaging

    // Constructor for creating Packaging object
    public Packaging(String type, int capacity, double cost) {
        this.type = type; // Setting the type of packaging
        this.capacity = capacity; // Setting the capacity
        this.cost = cost; // Setting the cost
    }

    // Getters and setters for packaging properties
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
    public Data.Packaging convertToPackaging() {
        return Data.Packaging.newBuilder()
                    .setType(getType())
                    .setCapacity(getCapacity())
                    .setCost(getCost())
                    .build();
               
    }

    public static Packaging convertFromData(Data.Packaging dataPackaging) {

        return new Packaging(dataPackaging.getType(),dataPackaging.getCapacity(),dataPackaging.getCost());
    }
}
