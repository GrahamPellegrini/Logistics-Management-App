package com.yourorganization.Shipment; // Package for handling shipment collections

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List; // Imports for list functionality

import yourorganization.Data;


public class ShipmentCollection {
    private List<Shipment> shipments; // List to store shipments

    // Constructor for Shipment
    public ShipmentCollection() {
        this.shipments = new ArrayList<>(); // Initializes the list of shipments
    }

    // Add a shipment to the collection
    public void addShipment(Shipment shipment) {
        shipments.add(shipment); // Appends a new shipment to the list
    }

    // Retrieve all shipments in the collection
    public List<Shipment> getAllShipments() {
        return new ArrayList<>(shipments); // Returns a copy of the shipments list
        // Once again a copy is returned not the original
    }

    // Find a shipment by its ID
    public Shipment getShipmentById(String shipmentId) {
        for (Shipment shipment : shipments) {
            if (shipment.getId().equals(shipmentId)) {
                return shipment; // Returns the matching shipment
            }
        }
        return null; // Return null if no match found
    }

    // Remove a shipment from the collection by ID
    public boolean removeShipment(String shipmentId) {
        return shipments.removeIf(shipment -> shipment.getId().equals(shipmentId)); // Removes the shipment
    }

    // Find a shipment by the customer ID
    public Shipment getShipmentByCustomerId(String customerId) {
        for (Shipment shipment : shipments) {
            if (shipment.getCustomer().getId().equals(customerId)) {
                return shipment; // Returns the shipment if customer ID matches
            }
        }
        return null;
    }

    public void save(String filename) {
        Data.Shipment.Builder shipmentCollectionBuilder = Data.Shipment.newBuilder();
        for (Shipment shipment : shipments) {
            Data.Shipment dataShipment = convertToData(shipment);
            shipmentCollectionBuilder.addShipments(dataShipment);
        }
        Data.Shipment shipmentCollection = shipmentCollectionBuilder.build();

        try (FileOutputStream output = new FileOutputStream(filename)) {
            shipmentCollection.writeTo(output);
        }
    }

    public void load(String filename) {
    try (FileInputStream input = new FileInputStream(filename)) {
        Data.Shipment shipmentCollection = Data.Shipment.parseFrom(input);
        this.shipments.clear();
        for (Data.Shipment dataShipment : shipmentCollection.getShipmentsList()) {
                Shipment shipment = convertFromData(dataShipment);
                this.shipments.add(shipment);
            }
        }
    }   
}
