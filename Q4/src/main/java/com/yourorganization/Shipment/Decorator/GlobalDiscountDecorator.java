package com.yourorganization.Shipment.Decorator;

import com.yourorganization.Shipment.Shipment;

public class GlobalDiscountDecorator extends ShipmentDecorator {
    private double discountPercentage; // Discount in percentage

    public GlobalDiscountDecorator(Shipment decoratedShipment, double discountPercentage) {
        super(decoratedShipment);
        this.discountPercentage = discountPercentage;
        decoratedShipment.setTotalCost(getTotalCost());
    }

    @Override
    public double getTotalCost() {
        // Calculate the discounted cost
        double originalCost = decoratedShipment.getTotalCost();
        double discount = originalCost * (discountPercentage / 100.0);
        return originalCost - discount; // Apply the discount
    }

    // Getters and setters for the discount percentage
    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }


}
