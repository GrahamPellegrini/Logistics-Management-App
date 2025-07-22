package Transport; // Package for transport-related classes

import java.util.ArrayList;
import java.util.List; // Importing for using lists


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
}
