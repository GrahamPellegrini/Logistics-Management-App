#include "../../../include/Product/Food/Fruit.h"
#include <sstream>

// Constructor for Fruit
Fruit::Fruit(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string expirationDate, bool isOrganic, std::string type)
    : Food(id, name, supplier, packagingUnits, price, expirationDate, isOrganic), type(type) {
}

// Overriding calculateDiscount method from Product class
double Fruit::calculateDiscount(int quantity, int month) {
    double discountRate = 0.08; // Base discount of 8%
    if (getIsOrganic()) { // Additional discount for organic fruits
        discountRate += 0.04; // 4% more
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string Fruit::displayProductInfo() {
    // Returns string representation of Fruit
    std::stringstream ss;
    ss << "Fruit{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Type='" << type << '\'' <<
       ", Expiration Date='" << getExpirationDate() << '\'' <<
       ", Is Organic=" << (getIsOrganic() ? "Yes" : "No") <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for type
std::string Fruit::getType() const {
    return type;
}

void Fruit::setType(const std::string& type) {
    this->type = type;
}
