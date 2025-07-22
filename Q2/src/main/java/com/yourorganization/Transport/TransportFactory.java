package com.yourorganization.Transport;

import java.util.List;


public class TransportFactory {

    // Factory method to create Transport objects based on type
    public static Transport createTransport(String type, String id, double speed, double costPerKm, List<String> routes) {
        switch (type.toLowerCase()) {
            case "aircraft":
                return new Aircraft(id, speed, costPerKm, routes); // Assuming routes are airSpaces
            case "seavessel":
                return new Ship(id, speed, costPerKm, routes); // Assuming routes are seaRoutes
            case "truck":
                return new Truck(id, speed, costPerKm, routes); // Assuming routes are motorways
            default:
            System.out.println("Unknown transport type: " + type);
            return null;
        }
    }
}
