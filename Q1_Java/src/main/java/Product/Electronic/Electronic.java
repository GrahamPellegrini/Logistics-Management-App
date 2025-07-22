package Product.Electronic; // Package for Electronic products

import Product.Product;
import Product.Supplier;

// Abstract Electronic class, extends Product
public abstract class Electronic extends Product {
    private String manufacturer; // Manufacturer of the electronic product
    private String model; // Model of the electronic product

    // Constructor for Electronic
    public Electronic(String id, String name, Supplier supplier, int packagingUnits, double price, String manufacturer, String model) {
        super(id, name, supplier, packagingUnits, price); // Calling Product's constructor
        this.manufacturer = manufacturer; // Setting manufacturer
        this.model = model; // Setting model
    }

    // Getter and setter for manufacturer
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    // Getter and setter for model
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
}
