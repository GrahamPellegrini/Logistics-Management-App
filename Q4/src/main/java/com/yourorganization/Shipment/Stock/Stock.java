package com.yourorganization.Shipment.Stock; // Package for shipment and stock management

import com.yourorganization.Product.Product;

public class Stock {
    private Product product; // The product itself
    private int quantity; // Quantity of the product in stock

    // Constructor for StockItem
    public Stock(Product product, int quantity) {
        this.product = product; // Setting the product
        this.quantity = quantity; // Setting the quantity
    }

    // Getter for product
    public Product getProduct() {
        return product;
    }

    // Setter for product
    public void setProduct(Product product) {
        this.product = product;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Setter for quantity
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
