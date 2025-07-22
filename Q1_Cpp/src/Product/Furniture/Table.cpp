#include "../../../include/Product/Furniture/Table.h"
#include <sstream>

// Constructor for Table
Table::Table(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string material, std::string dimensions, std::string shape)
    : Furniture(id, name, supplier, packagingUnits, price, material, dimensions), shape(shape) {
}

// Overriding calculateDiscount method from Product class
double Table::calculateDiscount(int quantity, int month) {
    double discountRate = 0.15; // Base discount of 15%
    if (shape == "Round") { // Additional discount for round tables
        discountRate += 0.1; // 10% more
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string Table::displayProductInfo() {
    // Returns string representation of Table
    std::stringstream ss;
    ss << "Table{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Material='" << getMaterial() << '\'' <<
       ", Dimensions='" << getDimensions() << '\'' <<
       ", Shape='" << shape << '\'' <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for shape
std::string Table::getShape() const {
    return shape;
}

void Table::setShape(const std::string& shape) {
    this->shape = shape;
}
