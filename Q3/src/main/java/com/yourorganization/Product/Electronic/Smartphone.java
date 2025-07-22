package com.yourorganization.Product.Electronic; // Package for electronic devices

import com.yourorganization.Product.Supplier;

// Smartphone class, extends Electronic
public class Smartphone extends Electronic {
    private int storageCapacity; // Storage capacity in GB

    // Constructor for Smartphone
    public Smartphone(String id, String name, Supplier supplier, int packagingUnits, double price, String manufacturer, String model, int storageCapacity) {
        super(id, name, supplier, packagingUnits, price, manufacturer, model); // Calling Electronic's constructor
        this.storageCapacity = storageCapacity; // Setting storage capacity
    }

    // Overriding calculateDiscount method
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.12; // Base discount of 12%
        if (storageCapacity >= 128) { // Extra discount for large storage
            discountRate += 0.03; // 3% more
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method
    @Override
    public String displayProductInfo() {
        // Returns string representation of Smartphone
        return "Smartphone{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Manufacturer='" + getManufacturer() + '\'' +
               ", Model='" + getModel() + '\'' +
               ", Storage Capacity=" + storageCapacity + "GB" +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for storageCapacity
    public int getStorageCapacity() { return storageCapacity; }
    public void setStorageCapacity(int storageCapacity) { this.storageCapacity = storageCapacity; }
}
