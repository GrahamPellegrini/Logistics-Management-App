#ifndef FURNITURE_H
#define FURNITURE_H

#include "../Product.h"
#include <string>

class Furniture : public Product {
private:
    std::string material; // Material of the furniture
    std::string dimensions; // Dimensions of the furniture (format: "Height x Width x Depth" in cm)

public:
    // Constructor for Furniture
    Furniture(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string material, std::string dimensions);

    // Inherited abstract methods from Product class are to be implemented in derived classes

    // Getter and setter for material
    std::string getMaterial() const;
    void setMaterial(const std::string& material);

    // Getter and setter for dimensions
    std::string getDimensions() const;
    void setDimensions(const std::string& dimensions);
};

#endif // FURNITURE_H
