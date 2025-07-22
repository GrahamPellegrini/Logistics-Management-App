#include "../../../include/Product/Furniture/Furniture.h"

// Constructor for Furniture
Furniture::Furniture(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string material, std::string dimensions)
    : Product(id, name, supplier, packagingUnits, price), material(material), dimensions(dimensions) {
}

// Getter and setter for material
std::string Furniture::getMaterial() const {
    return material;
}

void Furniture::setMaterial(const std::string& material) {
    this->material = material;
}

// Getter and setter for dimensions
std::string Furniture::getDimensions() const {
    return dimensions;
}

void Furniture::setDimensions(const std::string& dimensions) {
    this->dimensions = dimensions;
}
