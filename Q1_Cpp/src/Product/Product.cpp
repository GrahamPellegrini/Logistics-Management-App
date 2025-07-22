#include "../../include/Product/Product.h"

// Constructor to initialize a Product
Product::Product(std::string id, std::string name, Supplier supplier, int packagingUnits, double price) 
    : id(id), name(name), supplier(supplier), packagingUnits(packagingUnits), price(price) {
}

// Getter and setter methods implementation
std::string Product::getId() const { return id; }
void Product::setId(const std::string& id) { this->id = id; }
std::string Product::getName() const { return name; }
void Product::setName(const std::string& name) { this->name = name; }
Supplier Product::getSupplier() const { return supplier; }
void Product::setSupplier(const Supplier& supplier) { this->supplier = supplier; }
int Product::getPackagingUnits() const { return packagingUnits; }
void Product::setPackagingUnits(int packagingUnits) { this->packagingUnits = packagingUnits; }
double Product::getPrice() const { return price; }
void Product::setPrice(double price) { this->price = price; }

// Note: The abstract methods 'calculateDiscount' and 'displayProductInfo' are not implemented here
// They should be implemented in the derived classes
