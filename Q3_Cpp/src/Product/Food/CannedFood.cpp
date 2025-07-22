#include "../../../include/Product/Food/CannedFood.h"
#include <sstream>

// Constructor for CannedFood
CannedFood::CannedFood(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string expirationDate, bool isOrganic, std::string contents)
    : Food(id, name, supplier, packagingUnits, price, expirationDate, isOrganic), contents(contents) {
}

// Overriding calculateDiscount method from Product class
double CannedFood::calculateDiscount(int quantity, int month) {
    double discountRate = 0.12; // Base discount of 12%
    if (month == 11) { // Additional discount in November
        discountRate += 0.05; // 5% more
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string CannedFood::displayProductInfo() {
    // Returns string representation of CannedFood
    std::stringstream ss;
    ss << "CannedFood{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Contents='" << contents << '\'' <<
       ", Expiration Date='" << getExpirationDate() << '\'' <<
       ", Is Organic=" << (getIsOrganic() ? "Yes" : "No") <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for contents
std::string CannedFood::getContents() const {
    return contents;
}

void CannedFood::setContents(const std::string& contents) {
    this->contents = contents;
}
