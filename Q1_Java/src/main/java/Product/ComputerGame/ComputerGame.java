package Product.ComputerGame; // Package for ComputerGame

import Product.Product;
import Product.Supplier;

// Abstract class ComputerGame, extends Product
public abstract class ComputerGame extends Product {
    private String developer; // Developer of the computer game
    private int ageRating; // Age rating for the game

    // Constructor for ComputerGame
    public ComputerGame(String id, String name, Supplier supplier, int packagingUnits, double price, String developer, int ageRating) {
        super(id, name, supplier, packagingUnits, price); // Calling Product's constructor
        this.developer = developer; // Setting the developer
        this.ageRating = ageRating; // Setting the age rating
    }

    // Getter and setter for developer
    public String getDeveloper() { return developer; }
    public void setDeveloper(String developer) { this.developer = developer; }

    // Getter and setter for ageRating
    public int getAgeRating() { return ageRating; }
    public void setAgeRating(int ageRating) { this.ageRating = ageRating; }
}
