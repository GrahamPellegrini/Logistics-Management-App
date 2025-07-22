#include "../../../include/Product/ComputerGame/ActionGame.h"
#include <sstream>

// Constructor for ActionGame
ActionGame::ActionGame(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string developer, int ageRating, std::string genre)
    : ComputerGame(id, name, supplier, packagingUnits, price, developer, ageRating), genre(genre) {
}

// Overriding calculateDiscount method from Product class
double ActionGame::calculateDiscount(int quantity, int month) {
    double discountRate = 0.2; // Base discount of 20%
    if (quantity > 50) { // Additional discount for bulk purchases
        discountRate += 0.05; // 5% more
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string ActionGame::displayProductInfo() {
    // Returns string representation of ActionGame
    std::stringstream ss;
    ss << "ActionGame{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Developer='" << getDeveloper() << '\'' <<
       ", Age Rating=" << getAgeRating() <<
       ", Genre='" << genre << '\'' <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for genre
std::string ActionGame::getGenre() const {
    return genre;
}

void ActionGame::setGenre(const std::string& genre) {
    this->genre = genre;
}
