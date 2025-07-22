#include "../../../include/Product/ComputerGame/PuzzleGame.h"
#include <sstream>

// Constructor for PuzzleGame
PuzzleGame::PuzzleGame(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string developer, int ageRating, std::string difficultyLevel)
    : ComputerGame(id, name, supplier, packagingUnits, price, developer, ageRating), difficultyLevel(difficultyLevel) {
}

// Overriding calculateDiscount method from Product class
double PuzzleGame::calculateDiscount(int quantity, int month) {
    double discountRate = 0.15; // Base discount of 15%
    if (month == 1) { // Additional New Year discount
        discountRate += 0.1; // 10% more
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string PuzzleGame::displayProductInfo() {
    // Returns string representation of PuzzleGame
    std::stringstream ss;
    ss << "PuzzleGame{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Developer='" << getDeveloper() << '\'' <<
       ", Age Rating=" << getAgeRating() <<
       ", Difficulty Level='" << difficultyLevel << '\'' <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for difficultyLevel
std::string PuzzleGame::getDifficultyLevel() const {
    return difficultyLevel;
}

void PuzzleGame::setDifficultyLevel(const std::string& difficultyLevel) {
    this->difficultyLevel = difficultyLevel;
}
