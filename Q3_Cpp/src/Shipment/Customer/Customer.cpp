#include "../../../include/Shipment/Customer/Customer.h"

// Constructor for creating a new Customer
Customer::Customer(std::string id, std::string name, int distanceFromWarehouse)
    : id(id), name(name), distanceFromWarehouse(distanceFromWarehouse) {
}

// Getters and setters for Customer properties
std::string Customer::getId() const {
    return id;
}

void Customer::setId(const std::string& id) {
    this->id = id;
}

std::string Customer::getName() const {
    return name;
}

void Customer::setName(const std::string& name) {
    this->name = name;
}

int Customer::getDistanceFromWarehouse() const {
    return distanceFromWarehouse;
}

void Customer::setDistanceFromWarehouse(int distanceFromWarehouse) {
    this->distanceFromWarehouse = distanceFromWarehouse;
}
