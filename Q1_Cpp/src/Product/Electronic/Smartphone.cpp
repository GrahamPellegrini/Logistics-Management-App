#include "../../../include/Product/Electronic/Smartphone.h"
#include <sstream>

// Constructor for Smartphone
Smartphone::Smartphone(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string manufacturer, std::string model, int storageCapacity)
    : Electronic(id, name, supplier, packagingUnits, price, manufacturer, model), storageCapacity(storageCapacity) {
}

// Overriding calculateDiscount method from Product class
double Smartphone::calculateDiscount(int quantity, int month) {
    double discountRate = 0.12; // Base discount of 12%
    if (storageCapacity >= 128) { // Extra discount for large storage
        discountRate += 0.03; // 3% more
    }
    return quantity * price * discountRate; // Calculating total discount
}

// Overriding displayProductInfo method from Product class
std::string Smartphone::displayProductInfo() {
    // Returns string representation of Smartphone
    std::stringstream ss;
    ss << "Smartphone{" <<
       "ID='" << getId() << '\'' <<
       ", Name='" << getName() << '\'' <<
       ", Manufacturer='" << getManufacturer() << '\'' <<
       ", Model='" << getModel() << '\'' <<
       ", Storage Capacity=" << storageCapacity << "GB" <<
       ", Supplier='" << getSupplier().getName() << '\'' <<
       ", Packaging Units=" << getPackagingUnits() <<
       '}';
    return ss.str();
}

// Getter and setter for storageCapacity
int Smartphone::getStorageCapacity() const {
    return storageCapacity;
}

void Smartphone::setStorageCapacity(int storageCapacity) {
    this->storageCapacity = storageCapacity;
}
