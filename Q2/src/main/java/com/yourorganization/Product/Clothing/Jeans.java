package com.yourorganization.Product.Clothing; // Package for Jeans class

import com.yourorganization.Product.Supplier;

// Jeans class, extends Clothing
public class Jeans extends Clothing {
    private int waistSize; // Waist size in inches

    // Constructor for Jeans
    public Jeans(String id, String name, Supplier supplier, int packagingUnits, double price, String material, String color, int waistSize) {
        super(id, name, supplier, packagingUnits, price, material, color); // Calling Clothing constructor
        this.waistSize = waistSize; // Setting waist size
    }

    // Overriding calculateDiscount method
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.20; // Base discount rate
        if (waistSize >= 36) { // Additional discount for larger sizes
            discountRate += 0.1; // 10% more
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method
    @Override
    public String displayProductInfo() {
        // Returns string representation of Jeans
        return "Jeans{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Material='" + getMaterial() + '\'' +
               ", Color='" + getColor() + '\'' +
               ", Waist Size=" + waistSize + " inches" +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for waistSize
    public int getWaistSize() { return waistSize; }
    public void setWaistSize(int waistSize) { this.waistSize = waistSize; }
}
