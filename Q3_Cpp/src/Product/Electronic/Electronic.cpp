#include "../../../include/Product/Electronic/Electronic.h"

// Constructor for Electronic
Electronic::Electronic(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string manufacturer, std::string model)
    : Product(id, name, supplier, packagingUnits, price), manufacturer(manufacturer), model(model) {
}

// Getter and setter for manufacturer
std::string Electronic::getManufacturer() const {
    return manufacturer;
}

void Electronic::setManufacturer(const std::string& manufacturer) {
    this->manufacturer = manufacturer;
}

// Getter and setter for model
std::string Electronic::getModel() const {
    return model;
}

void Electronic::setModel(const std::string& model) {
    this->model = model;
}
