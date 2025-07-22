#include "../../../include/Product/Furniture/Chair.h"
#include <sstream>

// Constructor for Chair
Chair::Chair(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string material, std::string dimensions, bool hasArmrests)
    : Furniture(id, name, supplier, packagingUnits, price, material, dimensions), hasArmrests(hasArmrests) {
}

// Overriding calculateDiscount method from Product class
double Chair::calculateDiscount(int quantity, int month) {
    double discountRate = 0.10; // Base discount of 10%
    if (hasArmrests) { // Additional discount for chairs with armrests
        discountRate += 0.05; // 5% more
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string Chair::displayProductInfo() {
    // Returns string representation of Chair
    std::stringstream ss;
    ss << "Chair{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Material='" << getMaterial() << '\'' <<
       ", Dimensions='" << getDimensions() << '\'' <<
       ", Has Armrests=" << (getHasArmrests() ? "Yes" : "No") <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for hasArmrests
bool Chair::getHasArmrests() const {
    return hasArmrests;
}

void Chair::setHasArmrests(bool hasArmrests) {
    this->hasArmrests = hasArmrests;
}
