#ifndef CUSTOMER_H
#define CUSTOMER_H

#include <string>

class Customer {
private:
    std::string id; // Identifier for the customer
    std::string name; // Customer's name
    int distanceFromWarehouse; // Distance to warehouse in km

public:
    // Constructor for creating a new Customer
    Customer(std::string id, std::string name, int distanceFromWarehouse);

    // Getters and setters for Customer properties
    std::string getId() const;
    void setId(const std::string& id);
    std::string getName() const;
    void setName(const std::string& name);
    int getDistanceFromWarehouse() const;
    void setDistanceFromWarehouse(int distanceFromWarehouse);
};

#endif // CUSTOMER_H
