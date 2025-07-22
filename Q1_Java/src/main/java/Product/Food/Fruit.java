package Product.Food; // Package for Food products

import Product.Supplier;


// Fruit class, extends Food
public class Fruit extends Food {
    private String type; // Type of fruit (e.g., "Apple", "Banana")

    // Constructor for Fruit
    public Fruit(String id, String name, Supplier supplier, int packagingUnits, double price, String expirationDate, boolean isOrganic, String type) {
        super(id, name, supplier, packagingUnits, price, expirationDate, isOrganic); // Calling Food's constructor
        this.type = type; // Setting fruit type
    }

    // Overriding calculateDiscount method
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.08; // Base discount of 8%
        if (isOrganic()) { // Additional discount for organic fruits
            discountRate += 0.04; // 4% more
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method
    @Override
    public String displayProductInfo() {
        // Returns string representation of Fruit
        return "Fruit{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Type='" + type + '\'' +
               ", Expiration Date='" + getExpirationDate() + '\'' +
               ", Is Organic=" + (isOrganic() ? "Yes" : "No") +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for type
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
}
