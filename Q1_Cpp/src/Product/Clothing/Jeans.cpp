#include "../../../include/Product/Clothing/Jeans.h"
#include <sstream>

// Constructor for Jeans
Jeans::Jeans(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string material, std::string color, int waistSize)
    : Clothing(id, name, supplier, packagingUnits, price, material, color), waistSize(waistSize) {
}

// Overriding calculateDiscount method from Product class
double Jeans::calculateDiscount(int quantity, int month) {
    double discountRate = 0.20; // Base discount rate
    if (waistSize >= 36) { // Additional discount for larger sizes
        discountRate += 0.1; // 10% more
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string Jeans::displayProductInfo() {
    // Returns string representation of Jeans
    std::stringstream ss;
    ss << "Jeans{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Material='" << getMaterial() << '\'' <<
       ", Color='" << getColor() << '\'' <<
       ", Waist Size=" << waistSize << " inches" <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for waistSize
int Jeans::getWaistSize() const {
    return waistSize;
}

void Jeans::setWaistSize(int waistSize) {
    this->waistSize = waistSize;
}
