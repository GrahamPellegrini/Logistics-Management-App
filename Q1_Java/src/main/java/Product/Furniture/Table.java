package Product.Furniture; // Package for Furniture products

import Product.Supplier;

// Table class, extends Furniture
public class Table extends Furniture {
    private String shape; // Shape of the table (e.g., "Round", "Square", "Rectangle")

    // Constructor for Table
    public Table(String id, String name, Supplier supplier, int packagingUnits, double price, String material, String dimensions, String shape) {
        super(id, name, supplier, packagingUnits, price, material, dimensions); // Calling Furniture's constructor
        this.shape = shape; // Setting the shape
    }

    // Overriding calculateDiscount method
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.15; // Base discount of 15%
        if ("Round".equals(shape)) { // Additional discount for round tables
            discountRate += 0.1; // 10% more
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method
    @Override
    public String displayProductInfo() {
        // Returns string representation of Table
        return "Table{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Material='" + getMaterial() + '\'' +
               ", Dimensions='" + getDimensions() + '\'' +
               ", Shape='" + shape + '\'' +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for shape
    public String getShape() { return shape; }
    public void setShape(String shape) { this.shape = shape; }
}
