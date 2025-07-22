package com.yourorganization.Product.ComputerGame; // Package for ActionGame

import com.yourorganization.Product.Supplier;

// ActionGame class, extends ComputerGame
public class ActionGame extends ComputerGame {
    private String genre; // Genre of the action game

    // Constructor for ActionGame
    public ActionGame(String id, String name, Supplier supplier, int packagingUnits, double price, String developer, int ageRating, String genre) {
        super(id, name, supplier, packagingUnits, price, developer, ageRating); // Calling ComputerGame's constructor
        this.genre = genre; // Setting the genre
    }

    // Overriding calculateDiscount method
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.2; // Base discount of 20%
        if (quantity > 50) { // Additional discount for bulk purchases
            discountRate += 0.05; // 5% more
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method
    @Override
    public String displayProductInfo() {
        // Returns string representation of ActionGame
        return "ActionGame{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Developer='" + getDeveloper() + '\'' +
               ", Age Rating=" + getAgeRating() +
               ", Genre='" + genre + '\'' +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for genre
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
}
