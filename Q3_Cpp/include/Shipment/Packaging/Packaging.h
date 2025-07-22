#ifndef PACKAGING_H
#define PACKAGING_H

#include <string>

class Packaging {
private:
    std::string type; // Describes the packaging type, like box or crate
    int capacity; // How much it can hold, in packaging units
    double cost; // The cost for this type of packaging

public:
    // Constructor for creating Packaging object
    Packaging(std::string type, int capacity, double cost);

    // Getters and setters for packaging properties
    std::string getType() const;
    void setType(const std::string& type);
    int getCapacity() const;
    void setCapacity(int capacity);
    double getCost() const;
    void setCost(double cost);
};

#endif // PACKAGING_H
