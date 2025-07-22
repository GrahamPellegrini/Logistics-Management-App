package com.yourorganization.Product.Furniture; // Package for Furniture products
import com.yourorganization.Product.Supplier;

// Chair class, extends Furniture
public class Chair extends Furniture {
    private boolean hasArmrests; // Indicates if the chair has armrests

    // Constructor for Chair
    public Chair(String id, String name, Supplier supplier, int packagingUnits, double price, String material, String dimensions, boolean hasArmrests) {
        super(id, name, supplier, packagingUnits, price, material, dimensions); // Calling Furniture's constructor
        this.hasArmrests = hasArmrests; // Setting armrests status
    }

    // Overriding calculateDiscount method
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.10; // Base discount of 10%
        if (hasArmrests) { // Additional discount for chairs with armrests
            discountRate += 0.05; // 5% more
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method
    @Override
    public String displayProductInfo() {
        // Returns string representation of Chair
        return "Chair{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Material='" + getMaterial() + '\'' +
               ", Dimensions='" + getDimensions() + '\'' +
               ", Has Armrests=" + (hasArmrests ? "Yes" : "No") +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for hasArmrests
    public boolean isHasArmrests() { return hasArmrests; }
    public void setHasArmrests(boolean hasArmrests) { this.hasArmrests = hasArmrests; }
}
