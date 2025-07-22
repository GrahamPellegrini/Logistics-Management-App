package com.yourorganization.Transport; // Package for transport-related classes

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List; // Importing for using lists

import yourorganization.Data;


public class TransportCollection {
    private List<Transport> transports; // Stores a collection of Transport objects

    // Constructor for TransportCollection
    public TransportCollection() {
        transports = new ArrayList<>(); // Initializing the transports list
    }

    // Adds a transport to the collection
    public void addTransport(Transport transport) {
        transports.add(transport); // Adding transport to the list
    }

    // Returns all transports in the collection
    public List<Transport> getAllTransports() {
        return new ArrayList<>(transports); // Returning a copy of the transports list
    }
    
    // Retrieves a transport by its ID
    public Transport getTransportById(String transportId) {
        for (Transport transport : transports) {
            if (transport.getId().equals(transportId)) {
                return transport; // Returns the matched transport
            }
        }
        return null; // Returns null if no match found
    }

    // Updates a transport in the collection
    public boolean updateTransport(String transportId, Transport updatedTransport) {
        for (int i = 0; i < transports.size(); i++) { // Iterates through all transpots in list
            Transport transport = transports.get(i);
            if (transport.getId().equals(transportId)) {
                transports.set(i, updatedTransport); // Replaces old transport with updated one
                return true;
            }
        }
        return false; // Returns false if no match found
    }

    // Deletes a transport from the collection
    public boolean deleteTransport(String transportId) {
        return transports.removeIf(transport -> transport.getId().equals(transportId)); // Removes the transport by ID
    }

    public void save(String filename) {
    Data.Transport.Builder transportCollectionBuilder = Data.Transport.newBuilder();
    for (Transport transport : transports) {
        Data.Transport dataTransport = transport.convertToData(transport);
        transportCollectionBuilder.addTransport(dataTransport);
    }
    Data.Transport transport = transportCollectionBuilder.build();

    try (FileOutputStream output = new FileOutputStream(filename)) {
        transport.writeTo(output);
        }
    }

    public void load(String filename){
    try (FileInputStream input = new FileInputStream(filename)) {
        Data.Transport transportCollection = Data.Transport.parseFrom(input);
        this.transports.clear();
        for (Data.Transport dataTransport : transportCollection.getTransportsList()) {
            Transport transport = transport.convertFromData(dataTransport);
            this.transports.add(transport);
            }
        }
    }   

    
    
    
}
