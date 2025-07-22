package Product.Food; // Package for Food products

import Product.Product;
import Product.Supplier;

// Abstract Food class, extends Product
public abstract class Food extends Product {
    private String expirationDate; // Expiration date in YYYY-MM-DD format
    private boolean isOrganic; // Indicates if the food is organic

    // Constructor for Food
    public Food(String id, String name, Supplier supplier, int packagingUnits, double price, String expirationDate, boolean isOrganic) {
        super(id, name, supplier, packagingUnits, price); // Calling Product's constructor
        this.expirationDate = expirationDate; // Setting expiration date
        this.isOrganic = isOrganic; // Setting organic status
    }

    // Getter and setter for expirationDate
    public String getExpirationDate() { return expirationDate; }
    public void setExpirationDate(String expirationDate) { this.expirationDate = expirationDate; }

    // Getter for isOrganic
    public boolean isOrganic() { return isOrganic; }

    // Setter for isOrganic
    public void setOrganic(boolean isOrganic) { this.isOrganic = isOrganic; }
}
