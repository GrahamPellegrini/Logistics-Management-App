#include "../../../include/Product/Food/Food.h"

// Constructor for Food
Food::Food(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string expirationDate, bool isOrganic)
    : Product(id, name, supplier, packagingUnits, price), expirationDate(expirationDate), isOrganic(isOrganic) {
}

// Getter and setter for expirationDate
std::string Food::getExpirationDate() const {
    return expirationDate;
}

void Food::setExpirationDate(const std::string& expirationDate) {
    this->expirationDate = expirationDate;
}

// Getter and setter for isOrganic
bool Food::getIsOrganic() const {
    return isOrganic;
}

void Food::setIsOrganic(bool isOrganic) {
    this->isOrganic = isOrganic;
}
