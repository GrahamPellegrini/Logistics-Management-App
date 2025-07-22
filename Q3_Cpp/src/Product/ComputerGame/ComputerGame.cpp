#include "../../../include/Product/ComputerGame/ComputerGame.h"

// Constructor for ComputerGame
ComputerGame::ComputerGame(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string developer, int ageRating)
    : Product(id, name, supplier, packagingUnits, price), developer(developer), ageRating(ageRating) {
}

// Getter and setter for developer
std::string ComputerGame::getDeveloper() const {
    return developer;
}

void ComputerGame::setDeveloper(const std::string& developer) {
    this->developer = developer;
}

// Getter and setter for ageRating
int ComputerGame::getAgeRating() const {
    return ageRating;
}

void ComputerGame::setAgeRating(int ageRating) {
    this->ageRating = ageRating;
}
