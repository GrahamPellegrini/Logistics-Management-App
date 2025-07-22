package com.yourorganization.Transport; // Package for transportation classes

import java.util.List;



import java.util.ArrayList; // Importing for list functionalities

public class Truck extends Transport {
    private List<String> motorways; // Keeping a list of motorways the truck uses

    // Constructor for Truck object
    public Truck(String id, double speed, double costPerKm, List<String> motorways) {
        super(id, speed, costPerKm); // Calling the Transport's constructor
        this.motorways = new ArrayList<>(motorways); // Assigning motorways list
    }

    // Overriding the getRoutePlan method
    @Override
    public List<String> getRoutePlan() {
        return motorways;
    }

    // Getter and setter for motorways
    public List<String> getMotorways() {
        return motorways;
    }

    public void setMotorways(List<String> motorways) {
        this.motorways = motorways;
    }
}
