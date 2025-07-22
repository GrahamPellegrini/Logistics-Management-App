#include "../../include/Product/Supplier.h"

// Constructor to create a new Supplier
Supplier::Supplier(std::string id, std::string name) : id(id), name(name) {
}

// Returns the Supplier's ID
std::string Supplier::getId() const {
    return id;
}

// Sets a new ID for the Supplier
void Supplier::setId(const std::string& id) {
    this->id = id;
}

// Gets the Supplier's name
std::string Supplier::getName() const {
    return name;
}

// Updates the name of the Supplier
void Supplier::setName(const std::string& name) {
    this->name = name;
}
