package com.yourorganization.Product.Electronic; // Package for electronic devices

import com.yourorganization.Product.Supplier;

// Television class, extends Electronic
public class Television extends Electronic {
    private int screenSize; // Screen size in inches

    // Constructor for Television
    public Television(String id, String name, Supplier supplier, int packagingUnits, double price, String manufacturer, String model, int screenSize) {
        super(id, name, supplier, packagingUnits, price, manufacturer, model); // Calling Electronic's constructor
        this.screenSize = screenSize; // Setting screen size
    }

    // Overriding calculateDiscount method
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.10; // Base discount of 10%
        if (screenSize > 50) { // Additional discount for larger screens
            discountRate += 0.05; // 5% more
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method
    @Override
    public String displayProductInfo() {
        // Returns string representation of Television
        return "Television{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Manufacturer='" + getManufacturer() + '\'' +
               ", Model='" + getModel() + '\'' +
               ", Screen Size=" + screenSize + " inches" +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for screenSize
    public int getScreenSize() { return screenSize; }
    public void setScreenSize(int screenSize) { this.screenSize = screenSize; }
}
