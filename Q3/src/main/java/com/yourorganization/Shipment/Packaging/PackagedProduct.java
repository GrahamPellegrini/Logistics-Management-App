package com.yourorganization.Shipment.Packaging; // Package for shipment and packaging classes

import java.time.LocalDate; // Importing for date handling

import com.yourorganization.Product.Product;

import yourorganization.Data;


public class PackagedProduct {
    private Product product; // The actual product
    private Packaging packaging; // The packaging for the product
    private int quantity; // How many of this product

    // Constructor for PackagedProduct
    public PackagedProduct(Product product, Packaging packaging, int quantity) {
        this.product = product; // Assigning the product
        this.packaging = packaging; // Assigning the packaging
        this.quantity = quantity; // Setting the quantity
    }

    // Calculates the total cost of the product based on quantity and discounts
    public double calculateTotalProductCost() {
        LocalDate currentDate = LocalDate.now(); // Getting today's date
        int currentMonth = currentDate.getMonthValue(); // Extracting the current month
        return (product.getPrice() - product.calculateDiscount(quantity, currentMonth)) * quantity; // Calculating total cost
    }

    // Calculates the total cost of packaging
    public double getPackagingCost() {
        return packaging.getCost() * quantity; // Assuming cost is per unit
    }

    // Getters for product, packaging, and quantity
    public Product getProduct() {
        return product;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters for product, packaging, and quantity
    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Data.PackagedProduct convertToPackagedProduct() {
 
         return Data.PackagedProduct.newBuilder()
                     .setProduct(getProduct().convertToProduct())
                     .setPackaging(getPackaging().convertToPackaging())
                     .setQuantity(getQuantity())
                     .build();
               
    }

    public PackagedProduct convertFromData(Data.PackagedProduct dataPackagedProduct) {

        return new PackagedProduct(Product.convertFromData(dataPackagedProduct.getProduct()),Packaging.convertFromData(dataPackagedProduct.getPackaging()),dataPackagedProduct.getQuantity());
    }
}
