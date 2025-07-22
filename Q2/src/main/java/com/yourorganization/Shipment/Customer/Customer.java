package com.yourorganization.Shipment.Customer; // Package for shipment-related classes

public class Customer {
    private String id; // Identifier for the customer
    private String name; // Customer's name
    private int distanceFromWarehouse; // Distance to warehouse in km

    // Constructor for creating a new Customer
    public Customer(String id, String name, int distanceFromWarehouse) {
        this.id = id; // Setting customer's ID
        this.name = name; // Setting customer's name
        this.distanceFromWarehouse = distanceFromWarehouse; // Setting distance from warehouse
    }

    // Getters and setters for Customer properties
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDistanceFromWarehouse() {
        return distanceFromWarehouse;
    }

    public void setDistanceFromWarehouse(int distanceFromWarehouse) {
        this.distanceFromWarehouse = distanceFromWarehouse;
    }
}
