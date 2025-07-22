package com.yourorganization.Shipment.Stock; // Package for stock managment

import java.util.ArrayList;
import java.util.List;

import com.yourorganization.Product.Product;



public class StockCollection {
    private List<Stock> items; // Stores the list of stock items

    public StockCollection() {
        this.items = new ArrayList<>(); // Initilizing the list for stock items
    }

     // Finds a stock item by its product
    private Stock findStockByProduct(Product product) {
        for (Stock stockItem : items) {
            if (stockItem.getProduct().equals(product)) {
                return stockItem; // Return the matching stock item
            }
        }
        return null; // Return null if no match found
    }
    
    // Finds a product in the stock by its ID
    public Product getProductById(String productId) {
        for (Stock stockItem : items) {
            Product product = stockItem.getProduct();
            if (product.getId().equals(productId)) {
                return product; // Return the product if ID matches
            }
        }
        return null; // Return null if no product with the given ID is found
    }

    // Adds a product and its qunatity to the stock
    public void addProduct(Product product, int quantity) {
        Stock stockItem = findStockByProduct(product);
        if (stockItem != null) {
            stockItem.setQuantity(stockItem.getQuantity() + quantity); // Update qunatity if product exists
        } else {
            items.add(new Stock(product, quantity)); // Add new stock item if not exists
        }
    }

    // Removes a specified quantity of a product from the stock
    public void removeProduct(Product product, int quantity) {
        Stock stockItem = findStockByProduct(product);
        if (stockItem == null) {
            System.out.println("Product not found in stock."); // Error msg if product not found
            return;
        }
    
        int currentQuantity = stockItem.getQuantity();
        if (quantity > currentQuantity) {
            System.out.println("Insufficent stock quantity."); // Error msg for insufficient stock
            return;
        }
    
        stockItem.setQuantity(currentQuantity - quantity); // Decrease the stock quantity
        if (stockItem.getQuantity() <= 0) {
            items.remove(stockItem); // Remove the stock item if quantity is zero or less
        }
    }
    
    
    // Retrives a stock item for a specific product
    public Stock getStockItem(Product product) {
        return findStockByProduct(product);
    }

    // Gets a list of all stock items
    public List<Stock> getAllStockItems() {
        return new ArrayList<>(items); // Return a copy of the stock items list
    }

    // Removes a product from the stock based on its ID
    public boolean removeProduct(String productId) {
        Stock stockItemToRemove = null;
        
        // Iterate to find a stock item with the matching product ID
        for (Stock stockItem : items) {
            if (stockItem.getProduct().getId().equals(productId)) { // Note this is the same as getProductById and findStockByProduct together
                stockItemToRemove = stockItem;
                break; // Stop once the product is found
            }
        }
    
        if (stockItemToRemove != null) {
            items.remove(stockItemToRemove); // Remove the found stock item
            return true; // Indicate success
        }
    
        return false; // Indicate failure if product not found
    }
    
    // Adds additional stock for a specific product
    public boolean addAdditionalStock(String productId, int additionalQuantity) {
        for (Stock stockItem : items) {
            if (stockItem.getProduct().getId().equals(productId)) {
                stockItem.setQuantity(stockItem.getQuantity() + additionalQuantity);
                return true; // Indicate successful update
            }
        }
    
        return false; // Indicate failure if product not found in stock
    }
}
