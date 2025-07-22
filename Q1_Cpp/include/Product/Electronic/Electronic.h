#ifndef ELECTRONIC_H
#define ELECTRONIC_H

#include "../Product.h"
#include <string>

class Electronic : public Product {
private:
    std::string manufacturer; // Manufacturer of the electronic product
    std::string model; // Model of the electronic product

public:
    // Constructor for Electronic
    Electronic(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string manufacturer, std::string model);

    // Inherited abstract methods from Product class are to be implemented in derived classes

    // Getter and setter for manufacturer
    std::string getManufacturer() const;
    void setManufacturer(const std::string& manufacturer);

    // Getter and setter for model
    std::string getModel() const;
    void setModel(const std::string& model);
};

#endif // ELECTRONIC_H

