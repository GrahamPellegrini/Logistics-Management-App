package Product; // Package for the class

public abstract class Product {
    private String id; // Product's ID
    private String name; // Product's name
    private Supplier supplier; // Supplier object for the product
    private int packagingUnits; // Packaging units of the product
    private double price; // Product's price

    // Constructor to initialize a Product
    public Product(String id, String name, Supplier supplier, int packagingUnits, double price) {
        this.id = id; // Setting product ID
        this.name = name; // Setting product name
        this.supplier = supplier; // Setting product's supplier
        this.packagingUnits = packagingUnits; // Setting packaging units
        this.price = price; // Setting price
    }

    // Abstract methods to be implemented in subclasses
    public abstract double calculateDiscount(int quantity, int month);
    public abstract String displayProductInfo();

    // Getter and setter methods
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Supplier getSupplier() { return supplier; }
    public void setSupplier(Supplier supplier) { this.supplier = supplier; }
    public int getPackagingUnits() { return packagingUnits; }
    public void setPackagingUnits(int packagingUnits) { this.packagingUnits = packagingUnits; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}
