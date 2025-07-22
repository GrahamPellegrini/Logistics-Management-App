#ifndef SMARTPHONE_H
#define SMARTPHONE_H

#include "Electronic.h"

class Smartphone : public Electronic {
private:
    int storageCapacity; // Storage capacity in GB

public:
    // Constructor for Smartphone
    Smartphone(std::string id, std::string name, Supplier supplier, int packagingUnits, double price, std::string manufacturer, std::string model, int storageCapacity);

    // Overriding calculateDiscount method from Product class
    double calculateDiscount(int quantity, int month) override;

    // Overriding displayProductInfo method from Product class
    std::string displayProductInfo() override;

    // Getter and setter for storageCapacity
    int getStorageCapacity() const;
    void setStorageCapacity(int storageCapacity);
};

#endif // SMARTPHONE_H
