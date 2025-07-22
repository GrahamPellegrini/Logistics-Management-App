package com.yourorganization.Product.Furniture; // Package for Furniture products

import com.yourorganization.Product.Product;
import com.yourorganization.Product.Supplier;
// Abstract Furniture class, extends Product
public abstract class Furniture extends Product {
    private String material; // Material of the furniture
    private String dimensions; // Dimensions of the furniture (format: "Height x Width x Depth" in cm)

    // Constructor for Furniture
    public Furniture(String id, String name, Supplier supplier, int packagingUnits, double price, String material, String dimensions) {
        super(id, name, supplier, packagingUnits, price); // Calling Product's constructor
        this.material = material; // Setting material
        this.dimensions = dimensions; // Setting dimensions
    }

    // Getter and setter for material
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    // Getter and setter for dimensions
    public String getDimensions() { return dimensions; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }
}
