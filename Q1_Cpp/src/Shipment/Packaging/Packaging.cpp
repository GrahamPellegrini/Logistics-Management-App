#include "../../../include/Shipment/Packaging/Packaging.h"

// Constructor for creating Packaging object
Packaging::Packaging(std::string type, int capacity, double cost)
    : type(type), capacity(capacity), cost(cost) {
}

// Getters and setters for packaging properties
std::string Packaging::getType() const {
    return type;
}

void Packaging::setType(const std::string& type) {
    this->type = type;
}

int Packaging::getCapacity() const {
    return capacity;
}

void Packaging::setCapacity(int capacity) {
    this->capacity = capacity;
}

double Packaging::getCost() const {
    return cost;
}

void Packaging::setCost(double cost) {
    this->cost = cost;
}
