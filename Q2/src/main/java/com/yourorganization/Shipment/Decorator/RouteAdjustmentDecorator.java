package com.yourorganization.Shipment.Decorator;

import java.time.LocalDateTime;
import java.time.Duration;
import java.util.List;

import com.yourorganization.Shipment.Shipment;



public class RouteAdjustmentDecorator extends ShipmentDecorator {
    private List<String> adjustedRouteStages;

    public RouteAdjustmentDecorator(Shipment decoratedShipment,List<String> routes) {
        super(decoratedShipment);
        this.adjustedRouteStages = routes; // Initializes with the provided route stages
    }

    // Method to add a route stage
    public void addRouteStage(String newStage) {
        adjustedRouteStages.add(newStage);
        shortenEstimatedDeliveryTime(); // Reduces the estimated delivery time
    }

    // Method to remove a route stage
    public void removeRouteStage(String stageToRemove) {
        adjustedRouteStages.remove(stageToRemove);
        extendEstimatedDeliveryTime(); // Increases the estimated delivery time
    }

    // Shortens the estimated delivery time
    private void shortenEstimatedDeliveryTime() {

        int NumberRoutes = adjustedRouteStages.size(); // Number of routes for factoring 

        LocalDateTime originalDeliveryDateTime = decoratedShipment.calculateEstimatedDeliveryTime(); // Original Delivery Date
        Duration timeToDelivery = Duration.between(dispatchTime, originalDeliveryDateTime); // Calculation of devlivery time

        Duration reducedTime = timeToDelivery.multipliedBy(NumberRoutes).dividedBy((NumberRoutes+1)); // Reducing the time by factor of Number of Routes
    
        this.DeliveryDateTime = dispatchTime.plus(reducedTime); // setting the devlivery date to the shortened date
    }

    // Extends the estimated delivery time
    private void extendEstimatedDeliveryTime() {
        int NumberRoutes = adjustedRouteStages.size(); // Number of routes for factoring 

        LocalDateTime originalDeliveryDateTime = decoratedShipment.calculateEstimatedDeliveryTime(); // Original Delivery Date
        Duration timeToDelivery = Duration.between(dispatchTime, originalDeliveryDateTime); // Calculation of devlivery time

        Duration extendedTime = timeToDelivery.multipliedBy((NumberRoutes+1)).dividedBy(NumberRoutes); // Extending the time by factor of Number of Routes
    
        this.DeliveryDateTime = dispatchTime.plus(extendedTime); // setting the devlivery date to the extended date
    }

    // Method to get the current route stages
    public List<String> getCurrentRouteStages() {
        return adjustedRouteStages;
    }

  
}