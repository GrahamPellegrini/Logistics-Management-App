package com.yourorganization.Shipment; // Package for handling shipment collections

import java.util.ArrayList;
import java.util.List; // Imports for list functionality


public class ShipmentCollection {
    private List<Shipment> shipments; // List to store shipments

    // Constructor for ShipmentCollection
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
}
