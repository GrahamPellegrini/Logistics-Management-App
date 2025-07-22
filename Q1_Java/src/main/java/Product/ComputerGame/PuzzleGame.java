package Product.ComputerGame; // Package for PuzzleGame

import Product.Supplier;


// PuzzleGame class, extends ComputerGame
public class PuzzleGame extends ComputerGame {
    private String difficultyLevel; // Difficulty level of the puzzle game

    // Constructor for PuzzleGame
    public PuzzleGame(String id, String name, Supplier supplier, int packagingUnits, double price, String developer, int ageRating, String difficultyLevel) {
        super(id, name, supplier, packagingUnits, price, developer, ageRating); // Calling ComputerGame's constructor
        this.difficultyLevel = difficultyLevel; // Setting the difficulty level
    }

    // Overriding calculateDiscount method
    @Override
    public double calculateDiscount(int quantity, int month) {
        double discountRate = 0.15; // Base discount of 15%
        if (month == 1) { // Additional New Year discount
            discountRate += 0.1; // 10% more
        }
        return quantity * discountRate; // Calculating total discount
    }

    // Overriding displayProductInfo method
    @Override
    public String displayProductInfo() {
        // Returns string representation of PuzzleGame
        return "PuzzleGame{" +
               "ID='" + getId() + '\'' +
               ", Name='" + getName() + '\'' +
               ", Developer='" + getDeveloper() + '\'' +
               ", Age Rating=" + getAgeRating() +
               ", Difficulty Level='" + difficultyLevel + '\'' +
               ", Supplier='" + getSupplier().getName() + '\'' +
               ", Packaging Units=" + getPackagingUnits() +
               '}';
    }

    // Getter and setter for difficultyLevel
    public String getDifficultyLevel() { return difficultyLevel; }
    public void setDifficultyLevel(String difficultyLevel) { this.difficultyLevel = difficultyLevel; }
}
