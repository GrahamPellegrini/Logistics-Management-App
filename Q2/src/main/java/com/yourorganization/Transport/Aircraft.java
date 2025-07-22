package com.yourorganization.Transport; // Package for transportation methods

import java.util.List;



import java.util.ArrayList; // Needed for list operations

public class Aircraft extends Transport {
    private List<String> airSpaces; // Tracks air spaces the aircraft travels through

    // Constructor to setup an Aircraft
    public Aircraft(String id, double speed, double costPerKm, List<String> airSpaces) {
        super(id,  speed, costPerKm); // Calls base Transport class constructor
        this.airSpaces = new ArrayList<>(airSpaces); // Initializing airSpaces list
    }

    // Overriding getRoutePlan from Transport
    @Override
    public List<String> getRoutePlan() {
        return airSpaces; 
    }

    // Getters and setters for airSpaces
    public List<String> getAirSpaces() {
        return airSpaces;
    }

    public void setAirSpaces(List<String> airSpaces) {
        this.airSpaces = airSpaces;
    }
}
