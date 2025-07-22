package com.yourorganization.Shipment.Decorator;


import java.time.LocalDateTime;
import java.util.List;

import com.yourorganization.Shipment.Shipment;
import com.yourorganization.Shipment.Customer.Customer;
import com.yourorganization.Shipment.Packaging.PackagedProduct;
import com.yourorganization.Transport.Transport;



public abstract class ShipmentDecorator extends Shipment {
    protected Shipment decoratedShipment;

    public ShipmentDecorator(Shipment decoratedShipment) {
        // Initialize the ShipmentDecorator with the Shipment object to be decorated
        super(decoratedShipment.getId(), decoratedShipment.getCustomer(),
              decoratedShipment.getTransport(), decoratedShipment.getPackagedProducts());
        this.decoratedShipment = decoratedShipment;
    }

    @Override
    public LocalDateTime calculateEstimatedDeliveryTime() {
        return decoratedShipment.calculateEstimatedDeliveryTime();
    }

    @Override
    public void addPackagedProduct(PackagedProduct packagedProduct) {
        decoratedShipment.addPackagedProduct(packagedProduct);
    }

    @Override
    public void removePackagedProduct(String productId) {
        decoratedShipment.removePackagedProduct(productId);
    }

    @Override
    public void dispatchShipment() {
        decoratedShipment.dispatchShipment();
    }

    @Override
    public String getId() {
        return decoratedShipment.getId();
    }

    @Override
    public void setId(String id) {
        decoratedShipment.setId(id);
    }

    @Override
    public Customer getCustomer() {
        return decoratedShipment.getCustomer();
    }

    @Override
    public void setCustomer(Customer customer) {
        decoratedShipment.setCustomer(customer);
    }

    @Override
    public Transport getTransport() {
        return decoratedShipment.getTransport();
    }

    @Override
    public void setTransport(Transport transport) {
        decoratedShipment.setTransport(transport);
    }

    @Override
    public List<PackagedProduct> getPackagedProducts() {
        return decoratedShipment.getPackagedProducts();
    }

    @Override
    public void setPackagedProducts(List<PackagedProduct> packagedProducts) {
        decoratedShipment.setPackagedProducts(packagedProducts);
    }

    @Override
    public double getTotalCost() {
        return decoratedShipment.getTotalCost();
    }

    @Override
    public boolean isDispatched() {
        return decoratedShipment.isDispatched();
    }

}
