package Product.Food; // Package for Food products

import Product.Supplier;

// CannedFood class, extends Food
public class CannedFood extends Food {
    private String contents; // Type of food inside the can (e.g., "Tomato Soup", "Baked Beans")

    // Constructor for CannedFood
    public CannedFood(String id, String name, Supplier supplier, int packagingUnits, double price, String expirationDate, boolean isOrganic, String contents) {
        super(id, name, supplier, packagingUnits, price, expirationDate, isOrganic); // Calling Food's constructor
        this.contents = contents; // Setting the contents of the can
    }

    // Overriding calculateDiscount method
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.12; // Base discount of 12%
        if (month == 11) { // Additional discount in November
            discountRate += 0.05; // 5% more
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method
    @Override
    public String displayProductInfo() {
        // Returns string representation of CannedFood
        return "CannedFood{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Contents='" + contents + '\'' +
               ", Expiration Date='" + getExpirationDate() + '\'' +
               ", Is Organic=" + (isOrganic() ? "Yes" : "No") +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for contents
    public String getContents() { return contents; }
    public void setContents(String contents) { this.contents = contents; }
}
