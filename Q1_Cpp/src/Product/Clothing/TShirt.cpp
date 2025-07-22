#include "../../../include/Product/Clothing/TShirt.h"
#include <sstream>

// Constructor for TShirt
TShirt::TShirt(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string material, std::string color, std::string size)
    : Clothing(id, name, supplier, packagingUnits, price, material, color), size(size) {
}

// Overriding calculateDiscount method from Product class
double TShirt::calculateDiscount(int quantity, int month) {
    double discountRate = 0.15; // Base discount of 15%
    if (size == "XL") { // Extra discount for XL size
        discountRate += 0.05; // 5% more
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string TShirt::displayProductInfo() {
    // Returns string representation of TShirt
    std::stringstream ss;
    ss << "TShirt{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Material='" << getMaterial() << '\'' <<
       ", Color='" << getColor() << '\'' <<
       ", Size='" << size << '\'' <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for size
std::string TShirt::getSize() const {
    return size;
}

void TShirt::setSize(const std::string& size) {
    this->size = size;
}
