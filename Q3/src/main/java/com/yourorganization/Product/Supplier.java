package com.yourorganization.Product; // Package for the Product classes

import yourorganization.Data;

public class Supplier {
    private String id; // Holds the unique ID for Supplier
    private String name; // Name for the Supplier

    // Constructor to create a new Supplier
    public Supplier(String id, String name) {
        this.id = id; // Setting ID of supplier
        this.name = name; // Setting name of the supplier
    }

    // Returns the Supplier's ID
    public String getId() {
        return id;
    }

    // Sets a new ID for the Supplier
    public void setId(String id) {
        this.id = id;
    }

    // Gets the Supplier's name
    public String getName() {
        return name;
    }

    // Updates the name of the Supplier
    public void setName(String name) {
        this.name = name;
    }

    public Data.Supplier convertToSupplier() {
        return Data.Supplier.newBuilder()
                    .setId(getId())
                    .setName(getName())
                    .build();
               
    }

    public Supplier convertFromData(Data.Supplier dataSupplier) {

        return new Supplier(dataSupplier.getId(),dataSupplier.getName());
    }
}
