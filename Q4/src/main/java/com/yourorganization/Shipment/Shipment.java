package com.yourorganization.Shipment; // Package for handling shipments

import java.util.List;

import com.yourorganization.Shipment.Customer.Customer;

import com.yourorganization.Shipment.Packaging.PackagedProduct;
import com.yourorganization.Transport.Transport;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList; // Imports for time and list handling

    public class Shipment {
        private String id; // Unique ID for each shipment
        private Customer customer; // The customer associated with this shipment
        private Transport transport; // The mode of transport used for the shipment
        private List<PackagedProduct> packagedProducts; // List of products in the shipment
        protected double totalCost; // Total cost of the shipment
        //dispatching variables
        protected LocalDateTime dispatchTime; // Time when shipment is dispatched
        protected LocalDateTime DeliveryDateTime; // Expected delivery date and time
        private boolean isDispatched; // Flag to check if shipment has been dispatched

        // Constructor for Shipment
        public Shipment(String id, Customer customer, Transport transport, List<PackagedProduct> packagedProducts) {
            this.id = id; 
            this.customer = customer; 
            this.transport = transport;
            this.packagedProducts = new ArrayList<>(packagedProducts);
            this.totalCost = 0.0;
            this.dispatchTime = null;
            this.DeliveryDateTime = null;
            this.isDispatched = false;
            recalculateTotalCost(); // Recalculates total cost on decleration
        }

        // Recalculates the total cost of the shipment
        private void recalculateTotalCost() {
            double productAndPackagingCost = 0.0;
        
            for (PackagedProduct packagedProduct : packagedProducts) {
            productAndPackagingCost += packagedProduct.calculateTotalProductCost();
            }
        
            double transportationCost = calculateTransportationCost();
        
            totalCost = productAndPackagingCost + transportationCost; // Summing up costs
        }


        // Adds a product to the shipment
        public void addPackagedProduct(PackagedProduct packagedProduct) {
            if (!isDispatched) {
                packagedProducts.add(packagedProduct);
                recalculateTotalCost(); // Recalculates cost after adding a product
            }
        }

        // Removes a product from the shipment
        public void removePackagedProduct(String productId) {
            if (!isDispatched) {
                packagedProducts.removeIf(p -> p.getProduct().getId().equals(productId));
                recalculateTotalCost(); // Recalculates cost after removing a product
            }
        }

        // Calculates transportation cost
        private double calculateTransportationCost() {
            double distance = calculateTotalDistance(); 
            return transport.calculateDeliveryCost(distance); // Using transport's method
        }

        // Calculates total distance for the shipment
        private double calculateTotalDistance() {
            return customer.getDistanceFromWarehouse(); // Getting distance from customer's data
        }

        // Calculates estimated delivery time
        public LocalDateTime calculateEstimatedDeliveryTime() {
            double distance = calculateTotalDistance(); 
            Duration travelTime = transport.calculateDeliveryTime(distance);
            return dispatchTime.plus(travelTime); // Adding travel time to dispatch time
            // plus() function from the Duration import is used to add LocalDataTime variables togeter
        }

        // Dispatches the shipment
        public void dispatchShipment() {
            if(isDispatched){
                System.err.println("Shipment Already Dispatched");
            }
            else{
                this.dispatchTime = LocalDateTime.now();
                this.DeliveryDateTime = calculateEstimatedDeliveryTime();
                this.isDispatched = true;

                System.out.println("Shipment dispatched successfully!");
                System.out.println("Dispatch Time: " + dispatchTime);
                System.out.println("Estimated Delivery Time: " + DeliveryDateTime);
                System.out.println("Shipment Overall Price: "+totalCost);
            }
        }

        // Getters and setters for shipment details
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public Customer getCustomer() {
            return customer;
        }

        public void setCustomer(Customer customer) {
            if (!isDispatched) {
                this.customer = customer;
            }
        }

        public Transport getTransport() {
            return transport;
        }

        public void setTransport(Transport transport) {
            if (!isDispatched) {
                this.transport = transport;
            }
        }

        public List<PackagedProduct> getPackagedProducts() {
            return packagedProducts;
        }

        public void setPackagedProducts(List<PackagedProduct> packagedProducts) {
            if (!isDispatched) {
                this.packagedProducts = new ArrayList<>(packagedProducts);
                recalculateTotalCost();
            }
        }

        public double getTotalCost() {
            return totalCost;
        }

        public void setTotalCost(double totalCost){
            this.totalCost= totalCost;

        }

        public boolean isDispatched() {
            return isDispatched;
        }

        
    }
