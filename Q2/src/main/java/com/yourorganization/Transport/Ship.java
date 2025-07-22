package com.yourorganization.Transport; // Package for transport modes

import java.util.List;



import java.util.ArrayList; // Imports for list handling

public class Ship extends Transport {
    private List<String> seaRoutes; // List of sea routs the ship travels

    // Constructor for initializing Ship
    public Ship(String id,double speed, double costPerKm, List<String> seaRoutes) {
        super(id, speed, costPerKm); // Invoking Transport's constructor
        this.seaRoutes = new ArrayList<>(seaRoutes); // Assigning sea routes
    }

    // Overriding getRoutePlan from the Transport class
    @Override
    public List<String> getRoutePlan() {
        return seaRoutes; 
    }

    // Getter and setter for seaRoutes
    public List<String> getSeaRoutes() {
        return seaRoutes;
    }

    public void setSeaRoutes(List<String> seaRoutes) {
        this.seaRoutes = seaRoutes;
    }
}
