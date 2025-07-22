#include "../../../include/Product/Clothing/Clothing.h"

// Constructor for Clothing
Clothing::Clothing(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string material, std::string color)
    : Product(id, name, supplier, packagingUnits, price), material(material), color(color) {
}

// Getter and setter for material
std::string Clothing::getMaterial() const {
    return material;
}

void Clothing::setMaterial(const std::string& material) {
    this->material = material;
}

// Getter and setter for color
std::string Clothing::getColor() const {
    return color;
}

void Clothing::setColor(const std::string& color) {
    this->color = color;
}
