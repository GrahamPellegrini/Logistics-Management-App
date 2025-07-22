package Product.Clothing; // Package for TShirt

import Product.Supplier;


// TShirt class, extends Clothing
public class TShirt extends Clothing {
    private String size; // Size of the T-shirt (e.g., S, M, L, XL)

    // Constructor for TShirt
    public TShirt(String id, String name, Supplier supplier, int packagingUnits, double price, String material, String color, String size) {
        super(id, name, supplier, packagingUnits, price, material, color); // Calling Clothing's constructor
        this.size = size; // Setting the size
    }

    // Overriding calculateDiscount method
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.15; // Base discount of 15%
        if ("XL".equals(size)) { // Extra discount for XL size
            discountRate += 0.05; // 5% more
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method
    @Override
    public String displayProductInfo() {
        // Returns string representation of TShirt
        return "TShirt{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Material='" + getMaterial() + '\'' +
               ", Color='" + getColor() + '\'' +
               ", Size='" + size + '\'' +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for size
    public String getSize() { return size; }
    public void setSize(String size) { this.size = size; }
}
