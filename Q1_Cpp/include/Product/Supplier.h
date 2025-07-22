#ifndef SUPPLIER_H
#define SUPPLIER_H

#include <string>

class Supplier {
private:
    std::string id; // Holds the unique ID for Supplier
    std::string name; // Name for the Supplier

public:
    // Constructor to create a new Supplier
    Supplier(std::string id, std::string name);

    // Returns the Supplier's ID
    std::string getId() const;

    // Sets a new ID for the Supplier
    void setId(const std::string& id);

    // Gets the Supplier's name
    std::string getName() const;

    // Updates the name of the Supplier
    void setName(const std::string& name);
};

#endif // SUPPLIER_H
