package Product.Clothing; // Package for Clothing

import Product.Product;
import Product.Supplier;

// Abstract Clothing class, extends Product
public abstract class Clothing extends Product {
    private String material; // Material of the clothing
    private String color; // Color of the clothing

    // Constructor for Clothing
    public Clothing(String id, String name, Supplier supplier, int packagingUnits, double price, String material, String color) {
        super(id, name, supplier, packagingUnits, price); // Calling Product's constructor
        this.material = material; // Setting the material
        this.color = color; // Setting the color
    }

    // Getter and setter for material
    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    // Getter and setter for color
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
}
