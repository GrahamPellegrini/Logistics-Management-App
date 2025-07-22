#include "../../../include/Product/Electronic/Television.h"
#include <sstream>

// Constructor for Television
Television::Television(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string manufacturer, std::string model, int screenSize)
    : Electronic(id, name, supplier, packagingUnits, price, manufacturer, model), screenSize(screenSize) {
}

// Overriding calculateDiscount method from Product class
double Television::calculateDiscount(int quantity, int month) {
    double discountRate = 0.10; // Base discount of 10%
    if (screenSize > 50) { // Additional discount for larger screens
        discountRate += 0.05; // 5% more
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string Television::displayProductInfo() {
    // Returns string representation of Television
    std::stringstream ss;
    ss << "Television{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Manufacturer='" << getManufacturer() << '\'' <<
       ", Model='" << getModel() << '\'' <<
       ", Screen Size=" << screenSize << " inches" <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for screenSize
int Television::getScreenSize() const {
    return screenSize;
}

void Television::setScreenSize(int screenSize) {
    this->screenSize = screenSize;
}
